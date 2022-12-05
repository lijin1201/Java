package chap1;

import java.util.Scanner;

public class StopWatchTest {
	 public static void main(String[] args) {
		 Thread thread1 = Thread.currentThread();
		 Thread thread2 = new Thread(() -> {
		     try {
		         for (int seconds = 1; seconds > 0; seconds--) {
//		             System.out.println(seconds+" second"+(seconds == 1 ? "s" : "")+" left");
		             System.out.print("\b"+seconds);
		             Thread.sleep(1000);
		         }
		         System.out.println("Time's up!");
		         thread1.stop();
		     }catch(InterruptedException weCanIgnoreThisException){}
		 });
		 System.out.println("1. What is 1+1?");
		 System.out.println("a. 2\tb. Cannot Be.\tc. 3\td. All of the above.");
		 Scanner scan = new Scanner(System.in);
		 thread2.start();
		 String answer = scan.next();
		 thread2.stop();
		 
	 }

}

//"java scanner when sleep" ==>
// https://stackoverflow.com/questions/40321588/how-to-make-a-timer-using-thread-sleep-while-waiting-for-console-input

//"java show stopwatch in terminal" ==>
//https://stackoverflow.com/questions/3491027/java-console-code-for-stopwatch-timer
//https://stackoverflow.com/questions/10820033/make-a-simple-timer-in-java

//"terminal escape refresh line"==> ...