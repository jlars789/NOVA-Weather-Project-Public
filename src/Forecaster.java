import java.util.ArrayList;

public class Forecaster {

	private Equation eq;
	private LineFitter lf;
	private SQLRetrieve data;
	
	public Forecaster(int hours) {
		data = new SQLRetrieve(hours);
		data.getData();
		this.createQuadraticForecast();
	}
	
	/**
	 * Create an equation using the {@link LineFitter}
	 */
	
	public void createQuadraticForecast() {
		WeatherData[] wd = toThreePoints(data.getWeatherData());
		if(wd == null) return;
		
		double[][] points = new double[3][2];
		
		for(int i = 0; i < 3; i++) {
			points[i][0] = (-2 + i);
			points[i][0] = wd[i].getTemperatureC();
		}
		
		lf = new LineFitter(points[0], points[1], points[2]);
		eq = lf.getEquation();
	}
	
	/**
	 * Formats the ArrayList time series into a WeatherData array used for Quadratic Line fitting
	 * @param list the WeatherData list to use for formatting
	 * @return An array of the three latest entries in the given List
	 */
	
	private WeatherData[] toThreePoints(ArrayList<WeatherData> list) {
		WeatherData[] ret = new WeatherData[3];
		for(int i = list.size()-3; i < list.size(); i++) {
			ret[i - list.size()-3] = list.get(i);
		}
		
		return ret;
	}
	
	/**
	 * Extrapolates data from a function to attempt to forecast data
	 * @param hours Amount of hours in the future to make the forecast
	 * @return The predicted temperature in n hours
	 */
	public double getTempin(double hours) {
		return eq.evaluate(hours);
	}

}
