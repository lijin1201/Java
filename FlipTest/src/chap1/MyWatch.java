package chap1;

import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

import javax.swing.text.DefaultStyledDocument;

public class MyWatch {
	static Timer timer;
	static String input ="I";
	static Reader reader = new InputStreamReader(System.in);
	static Scanner sc = new Scanner(System.in);
	
	
	public static void main(String[] args) throws Exception{
		
		
		timer = new Timer();
	    System.out.print("Input 4 numbers => : ");
	    long start = System.currentTimeMillis();
	    
	    
	    Thread thread2 = new Thread(() -> {
            
		    int delay = 1000;
		    int period = 1000;
//		    System.out.println();
//		    System.out.print("           ");
		    timer.scheduleAtFixedRate(new TimerTask() {
		        public void run() {
//		        	System.out.print("\b\b\b\b\b\b\b\b");					
		        	System.out.print("\033[0K");
		        	System.out.print("     ");
		            System.out.print(timeText(start));
		            System.out.print("\033[12D");
		        }
		    }, delay, period);
		});
	   
	    thread2.start();
	    input += "AA";
//	    input += sc.nextByte();
	    inputUntilR();
	    timer.cancel();
	    thread2.stop();
	    System.out.println(input);
	}

	private static final String timeText(long start) {
		long millis = System.currentTimeMillis() - start;
		String hms = String.format("%02d:%02d:%02d", 
	            TimeUnit.MILLISECONDS.toHours(millis), 
	            TimeUnit.MILLISECONDS.toMinutes(millis) - TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS.toHours(millis)), 
	            TimeUnit.MILLISECONDS.toSeconds(millis) - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(millis)));
		return hms;
	}
	
	static void inputUntilR() throws Exception {
		int ch=0;
	    while (true) {
	    	ch = reader.read();
			if (ch != '\r') {  // check for EOF
			    input += (char)ch;// we have a character ...
			} else {
				return;
			}
		}
	}
	
	static String input4() {
		String inp = sc.nextLine();
		//check inp
		
		return inp;
	}
}

