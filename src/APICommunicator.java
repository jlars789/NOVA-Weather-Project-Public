import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Properties;
import java.util.Scanner;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

/**
 * Class used to connect to OpenWeatherMap.org's API. Data obtained includes temperature, humidity, and barometric pressure.
 * @author jlars
 */

public class APICommunicator {
	
	private Credentials credentials;
	
	public APICommunicator() {
		this.credentials = new Credentials();
	}
	
	/**
	 * Creates a connection to OpenWeatherMap's API and retrieves the requested data. 
	 * 
	 * @return A {@code WeatherData} object with {@code temperature}, {@code humidity}, and {@code pressure} values filled.
	 * Value will return {@code null} if API connection cannot be made.
	 */
	
	public WeatherData retrieve() {
		
		String inline = "";
		WeatherData wd = null;
		
		try {
			
			Properties prop = credentials.getProperties();
			
			URL url = new URL("http://api.openweathermap.org/data/2.5/weather?zip="+prop.getProperty("api.zip")
			+"&APPID="+prop.getProperty("api.appId"));
			HttpURLConnection conn = (HttpURLConnection)url.openConnection();
			
			conn.setRequestMethod("GET");
			conn.connect();
			
			int responsecode = conn.getResponseCode();
			if(responsecode != 200) {
				throw new RuntimeException("ERROR - Response Code: " + responsecode);
			} else {
				Scanner sc = new Scanner(url.openStream());
				while(sc.hasNext()) {
					inline+=sc.nextLine();
				}
				sc.close();
			}
			
			//OpenWeatherMap API Call
			JSONParser parse = new JSONParser();
			JSONObject jobj = (JSONObject)parse.parse(inline);
			JSONObject jobj1 = (JSONObject)jobj.get("main");
			double temp = (double)jobj1.get("temp");
			long humidity = (long) jobj1.get("humidity");
			long pressure = (long) jobj1.get("pressure");
			wd = new WeatherData(temp, humidity, pressure);
			
			conn.disconnect();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		return wd;
	}

}
