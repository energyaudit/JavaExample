package main.Java0;
/*
Must implement Serializable.It should have a public no-arg constructor.
All properties in java bean must be private with public getters and setter methods.
Beans are special type of Pojos. There are some restrictions on POJO to be a bean.
All JavaBeans are POJOs but not all POJOs are JavaBeans.
Serializable i.e. they should implement Serializable interface. Still, some POJOs who don’t implement Serializable
interface are called POJOs because Serializable is a marker interface and therefore not of much burden.
Fields should be private. This is to provide the complete control on fields.Fields should have getters or setters or both.
A no-arg constructor should be there in a bean.Fields are accessed only by constructor or getter setters.
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