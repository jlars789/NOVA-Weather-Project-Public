import java.io.Serializable;
import java.sql.Date;

import org.joda.time.*;

/**
 * Class used to store pertinent data regarding weather
 * @author jlars
 *
 */
public class WeatherData implements Serializable {
	
	private static final long serialVersionUID = -4694978676967819468L;

	private DateTime date;
	private Date sqlDate;
	private double temperature;
	private long humidity;
	private long pressure;
	private String filePath;
	
	/**
	 * Creates a WeatherData object using the current time
	 */
	public WeatherData() {
		date = new DateTime();
		sqlDate = new Date(System.currentTimeMillis());
		filePath = "weatherObj-" + date.hourOfDay().get() + "-" + date.dayOfMonth().get() + "-" + 
		date.monthOfYear().get() + "-" + date.getYear();
	}
	
	/**
	 * Creates a weather data object using custom parameters
	 * @param d date to be used
	 * @param hour hour of the day (from 0 to 23)
	 * @param temperature temperature recorded in Kelvin
	 * @param humidity relative humidity in percent
	 * @param pressure barometric pressure in hPa
	 */
	public WeatherData(Date d, int hour, double temperature, long humidity, long pressure) {
		date = new DateTime(d.toString() + "T" + hour + ":00:00.000-05:00");
		sqlDate = d;
		this.temperature = temperature;
		this.humidity = humidity;
		this.pressure = pressure;
	}
	
	public WeatherData(double temperature) {
		this();
		this.temperature = temperature;
	}
	
	public WeatherData(double temperature, long humidity, long pressure) {
		this();
		this.temperature = temperature;
		this.humidity = humidity;
		this.pressure = pressure;
	}
	
	public String getPath() {
		return filePath;
	}
	
	public DateTime getDate() {
		return date;
	}
	
	public Date getSQLDate() {
		return sqlDate;
	}
	
	public double getTemperatureK() {
		return temperature;
	}
	
	public double getTemperatureC() {
		return temperature - 273.15;
	}
	
	public double getTemperatureF() {
		return (getTemperatureC() * (9/5)) + 32;
	}
	
	public long getPressurehPa() {
		return pressure;
	}
	
	public double getPressuremmHg(){
		return pressure / 1.3332239;
	}
	
	public double getPressureinHg() {
		return pressure / 33.863886666667;
	}
	
	public long getHumidity() {
		return humidity;
	}

}
