package test;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.util.Properties;

import org.junit.BeforeClass;
import org.junit.Test;

public class SqlTest {
    private static String name;
    @BeforeClass
    public static void loadKey() throws IOException {
        Properties properties = new Properties();
        properties.load(SqlTest.class.getResourceAsStream("test.properties"));
        name = properties.getProperty("username");
    }
    @Test
    public void test() {
        assertEquals("root", name); 
    }
}
