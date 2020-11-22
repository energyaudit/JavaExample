package main.Java3.Junit4;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.assertTrue;


import java.io.File;
import java.io.IOException;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

public class RuleTester {

    @Rule
    public TemporaryFolder folder = new TemporaryFolder();

    @Test
    public void testUsingTempFolder() throws IOException {

        //test1
        File createdFolder = folder.newFolder("newfolder");
        File createdFile = folder.newFile("myfile.txt");
        assertTrue(createdFile.exists());

        //test2
        File testFile = folder.newFile("test-file.txt");
        assertTrue("The file should have been created: ", testFile.isFile());
        assertEquals("Temp folder and test file should match: ", folder.getRoot(), testFile.getParentFile());
    }
}
