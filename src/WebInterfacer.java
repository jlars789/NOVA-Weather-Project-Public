/**
 * Class responsible for hourly web-based tasks
 * @author jlars
 */
public class WebInterfacer implements Runnable {
	
	public WebInterfacer() {
		
	}
	/**
	 * Utilizes an {@link APICommunicator} object to store data from a {@link WeatherData} object into a MySQL Database
	 */
	@Override
	public void run() {
		APICommunicator apiCall = new APICommunicator();
		
		WeatherData wd = apiCall.retrieve();
		DatabaseUpload db = new DatabaseUpload(wd);
		db.writetoDB();
		System.out.println("Object written and stored to database at " + wd.getDate().hourOfDay().get() + ":" + wd.getDate().minuteOfHour().get() + ":" + wd.getDate().secondOfMinute().get());
	}

}
