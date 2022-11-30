package chap1;

import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

public class MyWatch {
	static Timer timer;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		timer = new Timer();
	    System.out.print("Input 4 numbers => : ");
	    String input = sc.nextLine();
	    long start = System.currentTimeMillis();
	    
	    System.out.print("        ");
	    timer.scheduleAtFixedRate(new TimerTask() {
	    	
	        public void run() {
	            System.out.println(timeText(start));
	
	        }
	    }, delay, period);
	}

	private static final String timeText(long start) {
		long millis = System.currentTimeMillis() - start;
		String hms = String.format("%02d:%02d:%02d", 
	            TimeUnit.MILLISECONDS.toHours(millis), 
	            TimeUnit.MILLISECONDS.toMinutes(millis) - TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS.toHours(millis)), 
	            TimeUnit.MILLISECONDS.toSeconds(millis) - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(millis)));

	}
}
