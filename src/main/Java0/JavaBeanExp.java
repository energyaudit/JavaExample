package main.Java0;
/*
Must implement Serializable.
It should have a public no-arg constructor.
All properties in java bean must be private with public getters and setter methods.
 */

public class JavaBeanExp implements java.io.Serializable
{
    private int id;
    private String name;
    public JavaBeanExp()
    {
    }
    public void setId(int id)
    {
        this.id = id;
    }
    public int getId()
    {
        return id;
    }
    public void setName(String name)
    {
        this.name = name;
    }
    public String getName()
    {
        return name;
    }
}