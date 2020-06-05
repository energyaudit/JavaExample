package util;

/**
 * Pseudo Algorithm :
 *
 * *   Change strings  originalstring and removecharacterstring  to character array .
 * *   Create a temporary boolean array named   tempBoolean of length 128 (ASCII characters) . This will set
 *      all the indexes value to false  by default .
 * *   Iterate through each character in   removecharacterstring   , setting the corresponding values  in the
 *      tempBoolean  array to true .
 * *  Start iterating originalstring  from 0 to the length of the originalstring string , copying each character           only if  its corresponding value in tempBoolean array is false .
 */
public class removeSpecifyChar {
    public static String removeSpecificChars(String originalstring ,String removecharacterstring)
    {
        char[] orgchararray=originalstring.toCharArray();
        char[] removechararray=removecharacterstring.toCharArray();
        int start,end=0;

        //tempBoolean automatically initialized to false ,size 128 assumes ASCII
        boolean[]  tempBoolean = new boolean[128];

        //Set flags for the character to be removed
        for(start=0;start < removechararray.length;++start)
        {
            tempBoolean[removechararray[start]]=true;
        }

        //loop through all characters ,copying only if they are flagged to false
        for(start=0;start < orgchararray.length;++start)
        {
            if(!tempBoolean[orgchararray[start]])
            {
                orgchararray[end++]=orgchararray[start];
            }
        }

        return new String(orgchararray,0,end);
    }
    public static void main(String[] args)
    {
        String originalstring="Alive is Awesome";
        System.out.println("Original string is >>  "+ originalstring);

        String removecharacterstring="asmz";
        String output=removeSpecificChars(originalstring, removecharacterstring);
        System.out.println("");
        System.out.println("");
        System.out.print("Output is >>  " );
        System.out.println(output);
    }


}