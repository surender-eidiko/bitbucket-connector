package org.mule.modules.bitbucket.bean;

public class CreateWebhookPostResponse {

	private String read_only;

    private String source;

    private String skip_cert_verification;

    private String[] events;

    private Subject subject;

    private String description;

    private String active;

    private String created_at;

    private Links links;

    private String uuid;

    private String type;

    private String url;

    public String getRead_only ()
    {
        return read_only;
    }

    public void setRead_only (String read_only)
    {
        this.read_only = read_only;
    }

    public String getSource ()
    {
        return source;
    }

    public void setSource (String source)
    {
        this.source = source;
    }

    public String getSkip_cert_verification ()
    {
        return skip_cert_verification;
    }

    public void setSkip_cert_verification (String skip_cert_verification)
    {
        this.skip_cert_verification = skip_cert_verification;
    }

    public String[] getEvents ()
    {
        return events;
    }

    public void setEvents (String[] events)
    {
        this.events = events;
    }

    public Subject getSubject ()
    {
        return subject;
    }

    public void setSubject (Subject subject)
    {
        this.subject = subject;
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

    public String getCreated_at ()
    {
        return created_at;
    }

    public void setCreated_at (String created_at)
    {
        this.created_at = created_at;
    }

    public Links getLinks ()
    {
        return links;
    }

    public void setLinks (Links links)
    {
        this.links = links;
    }

    public String getUuid ()
    {
        return uuid;
    }

    public void setUuid (String uuid)
    {
        this.uuid = uuid;
    }

    public String getType ()
    {
        return type;
    }

    public void setType (String type)
    {
        this.type = type;
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
        return "ClassPojo [read_only = "+read_only+", source = "+source+", skip_cert_verification = "+skip_cert_verification+", events = "+events+", subject = "+subject+", description = "+description+", active = "+active+", created_at = "+created_at+", links = "+links+", uuid = "+uuid+", type = "+type+", url = "+url+"]";
    }
}
