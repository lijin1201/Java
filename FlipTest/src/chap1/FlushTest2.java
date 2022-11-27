package chap1;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.concurrent.TimeUnit;

public class FlushTest2 {

	public static void main(String[] args) throws Exception {
		Charset utf8 = Charset.forName("UTF-8");
        Charset def = Charset.defaultCharset();
//        String charToPrint = "\u0905";]
        
      //hand, watermelon, arrow, love letter
        String uchar[] = {"\uD83D\uDC48 ","12 ", "\uD83C\uDF49","\u2934","\u2B50","\uD83D\uDC8C"}; 
//        String uchar[] = {"1\u200D2"};
        String chars[] = new String[uchar.length];

        for (int i=0; i<uchar.length; i++) {
        	byte[] bytes = uchar[i].getBytes("UTF-8");
        	chars[i] = new String(bytes , def.name());
        }
//print time:
//        https://www.techiedelight.com/measure-elapsed-time-execution-time-java/

        long startTime = System.currentTimeMillis();
        for (int cnt =0;  cnt<uchar.length; cnt++) {
        	
        	 try {
 	            if (System.getProperty("os.name").contains("Windows")) {
 	                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
 	            } else {
 	                System.out.print("\033\143");
 	            }
 	        }   catch (IOException | InterruptedException ex) {}
        		 
//        	System.out.print("\033[H\033[2J");  
//	        System.out.flush(); 
	        
			for (int i=0; i<8; i++) {
	            for (int j=0; j<8; j++) {
	                System.out.print(chars[cnt]);
	            }
	            System.out.println();
	        }
//			https://stackoverflow.com/questions/24104313/how-do-i-make-a-delay-in-java
			
	        try  { TimeUnit.SECONDS.sleep(1); }
	        catch (Exception e) {}
	        long curTime = System.currentTimeMillis();
	        
	        long timeElapsed = curTime - startTime;
	 
	        System.out.println("Execution time in milliseconds: " + timeElapsed);
	        
		}     
        
        
	}

}
