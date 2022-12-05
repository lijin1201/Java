package chap1;

import java.io.IOException;
import java.io.PrintStream;
import java.nio.charset.Charset;
import java.util.concurrent.TimeUnit;

public class EmojiTest {

	public static void main(String[] args) throws Exception {

        
      //hand, watermelon, arrow, love letter
        String uchar[] = {"\uD83D\uDC48 ","12 ", "\uD83C\uDF49","\u2934","\u2B50","\uD83D\uDC8C","😀"}; 
//	        String uchar[] = {"1\u200D2"};
        
        
		PrintStream out = new PrintStream(System.out, true, "UTF-8");
		for (String c: uchar) {
			out.print(c);
		}
		System.out.println();

		for (int cnt =0;  cnt<uchar.length; cnt++) {
			for (int i=0; i<4; i++) {
	            for (int j=0; j<4; j++) {
	                out.print(uchar[cnt]);
	            }
			}
			System.out.println();
			Thread.sleep(800);
		}
        
	}
}

