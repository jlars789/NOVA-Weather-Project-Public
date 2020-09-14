import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
public class DatabaseUpload {

	private WeatherData wd;
	private Credentials credentials;
	
	public DatabaseUpload(WeatherData wd) {
		this.wd = wd;
		this.credentials = new Credentials();
	}
	
	public void writetoDB() {
		
		try {
			Connection dbConn = credentials.establishDBConnection();
			
			if(dbConn != null) {
				System.out.println("Database connection successfully created");
			} else {
				System.out.println("Database connection failed");
				return;
			}
			
			String query = " INSERT INTO weather_data (Hour, Date, Temperature, Humidity, Pressure) VALUES (?, ?, ?, ?, ?)";
			PreparedStatement ps = dbConn.prepareStatement(query);
			
			ps.setInt(1, wd.getDate().getHourOfDay());
			ps.setDate(2, wd.getSQLDate());
			ps.setDouble(3, wd.getTemperatureC());
			ps.setLong(4, wd.getHumidity());
			ps.setLong(5, wd.getPressurehPa());
			
			System.out.println("Pushing data: " + wd.getSQLDate() + " | " + wd.getTemperatureC() + " | " 
			+ wd.getHumidity() + " | " + wd.getPressurehPa() + " | " 
			+ wd.getDate().getHourOfDay() + " to database.");
			
			ps.execute();
			
			dbConn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}
}
