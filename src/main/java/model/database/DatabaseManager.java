package model.database;

import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;
import org.apache.ibatis.jdbc.ScriptRunner;


public class DatabaseManager {

    private static DatabaseManager databaseManager=null;
    Connection connection;
    ClassLoader classLoader=getClass().getClassLoader();

    private DatabaseManager() throws IOException {
        Properties properties=getFileFromResourceAsStream("database/database.properties");
        String url=properties.getProperty("datasource.url");
        String user=properties.getProperty("datasource.username");
        String pass=properties.getProperty("datasource.password");
        try {
            connection= DriverManager.getConnection(url,user,pass);
            ScriptRunner sr=new ScriptRunner(connection);
            Reader reader=new InputStreamReader(classLoader.getResourceAsStream("database/start.sql"));
            sr.runScript(reader);
            reader.close();
            connection = DriverManager.getConnection(url+"teacherstudent",user,pass);

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public static DatabaseManager getInstance() throws IOException {
        if(databaseManager==null){
            databaseManager=new DatabaseManager();
        }
        return databaseManager;
    }

    private Properties getFileFromResourceAsStream(String address) throws IOException {

        // The class loader that loaded the class
        InputStream inputStream = classLoader.getResourceAsStream(address);
        // the stream holding the file content
        if (inputStream == null) {
            throw new IllegalArgumentException("file not found! " + "database/database.properties");
        } else {
            Properties properties=new Properties();
            properties.load(inputStream);
            inputStream.close();
            return properties;
        }

    }

    public Connection getConnection() {
        return connection;
    }
}
