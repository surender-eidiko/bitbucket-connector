package org.mule.modules.bitbucket.bean;

public class Subject {

	private String name;

    private Links links;

    private String uuid;

    private String type;

    private String full_name;

    public String getName ()
    {
        return name;
    }

    public void setName (String name)
    {
        this.name = name;
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

    public String getFull_name ()
    {
        return full_name;
    }

    public void setFull_name (String full_name)
    {
        this.full_name = full_name;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [name = "+name+", links = "+links+", uuid = "+uuid+", type = "+type+", full_name = "+full_name+"]";
    }
}
