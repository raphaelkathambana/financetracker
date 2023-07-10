package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.io.IOException;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import org.junit.BeforeClass;
import org.junit.Test;

public class SqlTest {
    private static String name;
    private static String password;
    private static String url;

    @BeforeClass
    public static void loadKey() throws IOException {
        Properties properties = new Properties();
        properties.load(SqlTest.class.getResourceAsStream("test.properties"));
        name = properties.getProperty("username");
        password = properties.getProperty("password");
        url = properties.getProperty("url");
    }

    @Test
    public void testSuccessfulLoadFromProperties() {
        assertEquals("root", name);
    }

    @Test
    public void testDbConnection() throws SQLException {
        assertNotNull(DriverManager.getConnection(url, name, password));
    }
}
