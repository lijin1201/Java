package chap1;

import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.util.concurrent.TimeUnit;

public class FlushTest {

	public static void main(String []args) throws Exception {
		String strs[] = {"X","Y","Z"};
		for (int cnt =0;  cnt<0; cnt++) {
			for (int i=0; i<8; i++) {
	            for (int j=0; j<8; j++) {
	                System.out.print(strs[cnt]);
	            }
	            System.out.println();
	        }
//			https://stackoverflow.com/questions/24104313/how-do-i-make-a-delay-in-java
			
	        try  { TimeUnit.SECONDS.sleep(1); }
	        catch (Exception e) {}
	        //https://www.javatpoint.com/how-to-clear-screen-in-java
	        //https://stackoverflow.com/questions/2979383/how-to-clear-the-console
//	        https://stackoverflow.com/questions/25209808/clear-the-console-in-java
//	        https://rootstack.com/en/blog/java-clear-screen
	        //works:
//	        try {
//	            if (System.getProperty("os.name").contains("Windows")) {
//	                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
//	            } else {
//	                System.out.print("\033\143");
//	            }
//	        }   catch (IOException | InterruptedException ex) {}
	        
	        
	        System.out.print("\033[H\033[2J");  
	        System.out.flush(); 
	        System.out.println("2nd");
	        
		}
		
		//print utf:
		//https://stackoverflow.com/questions/44878530/print-unicode-character-in-java
        
		Charset utf8 = Charset.forName("UTF-8");
        Charset def = Charset.defaultCharset();
//        String charToPrint = "\u0905";
        String charToPrint = "\uD83D\uDC48"; //hand

        byte[] bytes = charToPrint.getBytes("UTF-8");
        String message = new String(bytes , def.name());
        
		PrintWriter printWriter = new PrintWriter(System.out,true);
//		char aa = '\u0905';

		//windows settings:
//		https://stackoverflow.com/questions/57131654/using-utf-8-encoding-chcp-65001-in-command-prompt-windows-powershell-window
		printWriter.println("aa = " + message);
        
        
		
		//utf code:
		//https://stackoverflow.com/questions/57131654/using-utf-8-encoding-chcp-65001-in-command-prompt-windows-powershell-window
        


     }

}
