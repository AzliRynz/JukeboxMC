package org.jukeboxmc.crafting;

import com.nukkitx.protocol.bedrock.data.inventory.*;
import com.nukkitx.protocol.bedrock.data.inventory.descriptor.ItemDescriptorWithCount;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import lombok.Getter;
import org.jukeboxmc.Server;
import org.jukeboxmc.config.Config;
import org.jukeboxmc.config.ConfigType;
import org.jukeboxmc.crafting.recipes.Recipe;
import org.jukeboxmc.crafting.recipes.SmeltingRecipe;
import org.jukeboxmc.item.Item;
import org.jukeboxmc.util.ItemPalette;

import java.io.IOException;
import java.io.InputStream;
import java.util.*;

/**
 * @author LucGamesYT
 * @version 1.0
 */
@Getter
public class CraftingManager {

    private final List<CraftingData> craftingData = new ObjectArrayList<>();
    private final List<PotionMixData> potionMixData = new ObjectArrayList<>();
    private final List<ContainerMixData> containerMixData = new ObjectArrayList<>();

    private final Set<SmeltingRecipe> smeltingRecipes = new HashSet<>();
    private final Set<Recipe> recipes = new HashSet<>();

    public CraftingManager() {
        InputStream recipesStream = Server.class.getClassLoader().getResourceAsStream( "recipes.json" );
        if ( recipesStream == null ) {
            throw new AssertionError( "Unable to find recipes.json" );
        }
        Config config = new Config( recipesStream, ConfigType.JSON );
        List<Map<String, Object>> recipes = (List<Map<String, Object>>) config.getMap().get( "recipes" );
        for ( Map<String, Object> recipe : recipes ) {
            CraftingDataType craftingDataType = CraftingDataType.valueOf( (String) recipe.get( "type" ) );
            String recipeId = (String) recipe.get( "recipeId" );
            int width = (int) (double) recipe.get( "width" );
            int height = (int) (double) recipe.get( "height" );
            int inputId = (int) (double) recipe.get( "inputId" );
            int inputDamage = (int) (double) recipe.get( "inputDamage" );

            List<ItemDescriptorWithCount> inputItems = new ArrayList<>();
            if ( recipe.containsKey( "inputs" ) ) {
                List<Map<String, Object>> inputs = (List<Map<String, Object>>) recipe.get( "inputs" ); //TODO
                for ( Map<String, Object> input : inputs ) {
                    int id = (int) (double) input.get( "id" );
                    int damage = (int) (double) input.get( "damage" );
                    int count = (int) (double) input.get( "count" );
                    List<Object> canPlace = (List<Object>) input.get( "canPlace" );
                    List<Object> canBreak = (List<Object>) input.get( "canBreak" );
                    int blockingTicks = (int) (double) input.get( "blockingTicks" );
                    int blockRuntimeId = (int) (double) input.get( "blockRuntimeId" );
                    boolean usingNetId = (boolean) input.get( "usingNetId" );
                    int netId = (int) (double) input.get( "netId" );

                    String identifier;
                    if ( id == 0 ) {
                        identifier = "minecraft:air";
                    } else {
                        identifier = ItemPalette.getIdentifier( (short) id );
                    }
                    Item item = new Item( identifier, damage, blockRuntimeId );
                    item.setAmount( count );
                    inputItems.add( item.toItemDescriptorWithCount() );
                }
            }

            List<ItemData> outputItems = new ArrayList<>();
            List<Map<String, Object>> outputs = (List<Map<String, Object>>) recipe.get( "outputs" ); //TODO
            if ( recipe.containsKey( "outputs" ) ) {
                for ( Map<String, Object> output : outputs ) {
                    int id = (int) (double) output.get( "id" );
                    int damage = (int) (double) output.get( "damage" );
                    int count = (int) (double) output.get( "count" );
                    List<Object> canPlace = (List<Object>) output.get( "canPlace" );
                    List<Object> canBreak = (List<Object>) output.get( "canBreak" );
                    int blockingTicks = (int) (double) output.get( "blockingTicks" );
                    int blockRuntimeId = (int) (double) output.get( "blockRuntimeId" );
                    boolean usingNetId = (boolean) output.get( "usingNetId" );
                    int netId = (int) (double) output.get( "netId" );

                    String identifier = ItemPalette.getIdentifier( (short) id );
                    Item item = new Item( identifier, damage, blockRuntimeId );
                    item.setAmount( count );
                    outputItems.add( item.toNetwork() );
                }
            }

            if ( craftingDataType.equals( CraftingDataType.FURNACE ) || craftingDataType.equals( CraftingDataType.FURNACE_DATA ) ) {
                Item input = new Item( ItemPalette.getIdentifier( (short) inputId ) );
                if ( inputDamage != 32767 ) {
                    input.setMeta( inputDamage );
                }
                Item output = Item.fromItemData( outputItems.get( 0 ) );
                if ( output.getMeta() == 32767 ) {
                    output.setMeta( 0 );
                }
                this.smeltingRecipes.add( new SmeltingRecipe( input, output ) );
            }

            UUID uuid = recipe.get( "uuid" ) != null ? UUID.fromString( (String) recipe.get( "uuid" ) ) : null;
            String craftingTag = (String) recipe.get( "craftingTag" );
            int priority = (int) (double) recipe.get( "priority" );
            int networkId = (int) (double) recipe.get( "networkId" );
            this.craftingData.add( new CraftingData( craftingDataType, recipeId, width, height, inputId, inputDamage, inputItems, outputItems, uuid, craftingTag, priority, networkId ) );
        }
        List<Map<String, Object>> containerMixes = (List<Map<String, Object>>) config.getMap().get( "containerMixes" );
        for ( Map<String, Object> recipe : containerMixes ) {
            int inputId = (int) (double) recipe.get( "inputId" );
            int reagentId = (int) (double) recipe.get( "reagentId" );
            int outputId = (int) (double) recipe.get( "outputId" );
            this.containerMixData.add( new ContainerMixData( inputId, reagentId, outputId ) );
        }

        List<Map<String, Object>> potionMixes = (List<Map<String, Object>>) config.getMap().get( "potionMixes" );
        for ( Map<String, Object> recipe : potionMixes ) {
            int inputId = (int) (double) recipe.get( "inputId" );
            int inputMeta = (int) (double) recipe.get( "inputMeta" );
            int reagentId = (int) (double) recipe.get( "reagentId" );
            int reagentMeta = (int) (double) recipe.get( "reagentMeta" );
            int outputId = (int) (double) recipe.get( "outputId" );
            int outputMeta = (int) (double) recipe.get( "outputMeta" );
            this.potionMixData.add( new PotionMixData( inputId, inputMeta, reagentId, reagentMeta, outputId, outputMeta ) );
        }
        try {
            recipesStream.close();
        } catch ( IOException e ) {
            e.printStackTrace();
        }
    }

    public void registerRecipe( String recipeId, Recipe recipe ) {
        try {
            this.craftingData.add( recipe.doRegister( this, recipeId ) );
        } catch ( RuntimeException e ) {
            Server.getInstance().getLogger().error( "Could not register recipe " + recipeId + "!", e );
        }
    }

    public SmeltingRecipe getSmeltingRecipe( Item input ) {
        return this.smeltingRecipes.stream().filter( smeltingRecipe -> smeltingRecipe.getInput().equals( input ) ).findFirst().orElse( null );
    }
}
