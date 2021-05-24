package main.Java2;

import java.util.Arrays;
import java.util.Comparator;
import java.util.function.BiFunction;
import java.util.function.Function;

/**
 * Hello world!
 *
 */
public class LambdaExp
{
    public static void main( String[] args )
    {
    	final String prefix = "MR. ";
    	
        System.out.println( process("Hello World!", str -> {
        	
        	return prefix.concat(str);
        }) );
        
        System.out.println( process2("Hello World!", 5, String::substring));
        
        String[] names = {"Mr Sanjay", "Ms Trupti", "Dr John"};

        Arrays.sort(names, Comparator.comparing(LambdaExp::firstName).reversed().thenComparing(LambdaExp::title)
		);
        
        System.out.println(Arrays.toString(names));
    }
    
    public static String title(String name) {
    	return name.split(" ")[0];
    }

    public static String firstName(String name) {
    	return name.split(" ")[1];
    }
    

	private static String process2(String str, int i,
			BiFunction<String, Integer, String> processor) {
		
		return processor.apply(str, i);
	}

	private static String process(String str, Function<String, String> processor) {
		
		return processor.apply(str);
	}
}
