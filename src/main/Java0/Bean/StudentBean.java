package main.Java0.Bean;
/**
 * JavaBeans are classes that encapsulate many objects into a single object (the bean). They are serializable,
 * have a zero-argument constructor, and allow access to properties using getter and setter methods.
 * The name “Bean”
 * was given to encompass this standard, which aims to create reusable software components for Java.
 */
public class StudentBean implements java.io.Serializable
    {
        private int id;
        private String name;
        public StudentBean()
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
