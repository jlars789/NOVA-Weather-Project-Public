import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * Handles Database Calls and managing user authorization data
 * @author jlars
 *
 */
public class Credentials {
	
	private Properties prop;
	
	/**
	 * Initializes a {@code Credentials} Object with the auth.properties file stored
	 */
	public Credentials() {
		try {
			prop = getCredentials();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Establishes a connection to an existing MySQL Database
	 * @return a connection to a MySQL Database
	 */
	public Connection establishDBConnection() {
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			String dbName = prop.getProperty("weather.dbName");
			String userName = prop.getProperty("weather.userName");
			String password = prop.getProperty("weather.password");
			String hostname = prop.getProperty("weather.hostname");
			String port = prop.getProperty("weather.port");
			String jdbcUrl = "jdbc:mysql://" + hostname + ":" + port + "/" + dbName + "?user=" + userName + "&password=" + password;
			System.out.println("Attempting to connect to MySQL Database...");
			Connection con = DriverManager.getConnection(jdbcUrl);
			return con;
			
	    } catch (ClassNotFoundException e) { 
	    	e.printStackTrace();
	    }
	    catch (SQLException e) { 
	    	e.printStackTrace();
	    }
		
	    return null;
	}
	/**
	 * Attempts to get the credentials stored in aut.properties
	 * @return A Properties object with all stored properties added
	 * @throws IOException
	 */
	private Properties getCredentials() throws IOException {
		Properties prop = new Properties();
		InputStream inputStream;
		try {
			String propFileName = "auth.properties";
			inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);
			
			if (inputStream != null) {
				prop.load(inputStream);
			} else {
				throw new FileNotFoundException("property file '" + propFileName + "' not found in the classpath");
			}
			
		} catch(IOException e) {
			e.printStackTrace();
		}
		
		return prop;
	}
	
	public Properties getProperties() {
		return this.prop;
	}

}
