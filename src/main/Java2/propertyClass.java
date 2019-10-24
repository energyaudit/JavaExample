package src.main.Java2;

/**
 * Created by byang on 2018-06-12.
 */

import java.util.Iterator;
        import java.util.Properties;
        import java.util.Set;

/**
 * This class is used to show the simple
 * Properties class example.
 * @author codesjava
 */
public class propertyClass {//Properties class is a subclass of Hashtable
    public static void main(String[] args) {

        Properties prop = new Properties();
        Set props;
        String str;

        //Set the properties value
        prop.setProperty("database", "oracle10g");
        prop.setProperty("username", "system");
        prop.setProperty("password", "oracle");

        //Get key set,Get Set view of Keys
        props = prop.keySet();
        System.out.println("Set view of Keys, Keys contains :");
        //iterate through the Set of keys
        Iterator itr = props.iterator();
        while(itr.hasNext())
            System.out.println(itr.next());

        //Print the properties
        Iterator iterator = props.iterator();
        while(iterator.hasNext()) {
            str = (String) iterator.next();
            System.out.println("Prpperty: " + str +
                    ", Property Value: " + prop.getProperty(str));
        }

        Properties gfg = new Properties();
        Set URL;
        String str1;

        gfg.put("ide", "ide.geeksforgeeks.org");
        gfg.put("contribute", "contribute.geeksforgeeks.org");
        gfg.put("quiz", "quiz.geeksforgeeks.org");

        // checking what's in table
        URL = gfg.keySet();
        Iterator itr1 = URL.iterator();

        while(itr1.hasNext())
        {
            str1 = (String)itr1.next();
            System.out.println("The URL for " + str1 +
                    " is " + gfg.getProperty(str1));
        }

        System.out.println();

        // looking for URL that not in list
        str1 = gfg.getProperty("articl", "not found");
        System.out.println("The URL for article is " + str1);

    }
}