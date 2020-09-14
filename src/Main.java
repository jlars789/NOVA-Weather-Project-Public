import java.util.concurrent.*;

public class Main {
	
	/**
	 * Runs the {@link WebInterfacer} every hour
	 */
	public static void main(String[] args) {
		
		WebInterfacer create = new WebInterfacer();
		ScheduledExecutorService ses = Executors.newScheduledThreadPool(1);
		ses.scheduleAtFixedRate(create, 0, 1, TimeUnit.HOURS);
		
	}

}
