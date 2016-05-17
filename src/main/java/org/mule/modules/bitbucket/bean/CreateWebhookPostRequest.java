package org.mule.modules.bitbucket.bean;

public class CreateWebhookPostRequest {

	private String[] events;

    private String description;

    private String active;

    private String url;

    public String[] getEvents ()
    {
        return events;
    }

    public void setEvents (String[] events)
    {
        this.events = events;
    }

    public String getDescription ()
    {
        return description;
    }

    public void setDescription (String description)
    {
        this.description = description;
    }

    public String getActive ()
    {
        return active;
    }

    public void setActive (String active)
    {
        this.active = active;
    }

    public String getUrl ()
    {
        return url;
    }

    public void setUrl (String url)
    {
        this.url = url;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [events = "+events+", description = "+description+", active = "+active+", url = "+url+"]";
    }
    
}
