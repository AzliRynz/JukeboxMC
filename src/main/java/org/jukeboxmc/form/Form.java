package org.jukeboxmc.form;

import com.nimbusds.jose.shaded.json.JSONArray;
import com.nimbusds.jose.shaded.json.JSONObject;
import lombok.RequiredArgsConstructor;

/**
 * @author GoMint
 * @version 1.0
 */
@RequiredArgsConstructor
public abstract class Form<R> {

    private final String title;
    private String icon = null;

    // Caching
    protected JSONObject cache;
    protected boolean dirty;

    /**
     * Get the type of form we have right here
     *
     * @return type of form
     */
    public abstract String getFormType();

    public void setIcon( String icon ) {
        this.icon = icon;
        this.dirty = true;
    }

    public String getIcon() {
        return this.icon;
    }

    public String getTitle() {
        return this.title;
    }

    /**
     * Get the JSON representation of this form
     *
     * @return ready to be sent JSON
     */
    public JSONObject toJSON() {
        // Basic data
        JSONObject obj = new JSONObject();
        obj.put( "type", this.getFormType() );
        obj.put( "title", this.getTitle() );
        obj.put( "content", new JSONArray() );

        // Check if we have a icon
        if ( this.icon != null ) {
            JSONObject jsonIcon = new JSONObject();
            jsonIcon.put( "type", this.icon.startsWith( "http" ) || this.icon.startsWith( "https" ) ? "url" : "path" );
            jsonIcon.put( "data", this.icon );
            obj.put( "icon", jsonIcon );
        }

        return obj;
    }

    /**
     * Parse the given response into the correct listener format
     *
     * @param json data from the client
     * @return correct formatted object for the listener
     */
    public abstract R parseResponse( String json );

    public void setDirty() {
        this.dirty = true;
    }

}