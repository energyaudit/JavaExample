package main.Java0;

import com.jayway.jsonpath.Configuration;
import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;
import com.jayway.jsonpath.spi.json.JacksonJsonNodeJsonProvider;
import com.jayway.jsonpath.spi.mapper.JacksonMappingProvider;
import main.util.JavaUtil;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

import static org.junit.Assert.assertEquals;

public class Compare2JsonFile {
    public static void main(String[] args) throws IOException {
       JavaUtil jul = new JavaUtil();
        String exampleRequest=jul.file2JsonString("src/main/resources/jsonNodes.json");

        String exampleRequest1 =jul.file2JsonString("src/main/resources/jsonNodes1.json");
        assertEquals(exampleRequest,exampleRequest1);
    }
}
