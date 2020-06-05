package util;


import com.google.common.io.CharStreams;

import java.io.*;


public class ReadJsonFileResource {
public static String resultO;

    public  String inputpar(String relapath) throws Exception  {

        ClassLoader classLoader = getClass().getClassLoader();
        InputStream inputStream = classLoader.getResourceAsStream(relapath);
        String resultO = null;
        try (final Reader reader = new InputStreamReader(inputStream)) {
            resultO = CharStreams.toString(reader);
        }
        finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        System.out.println(resultO);
        return resultO;
    }

    }


