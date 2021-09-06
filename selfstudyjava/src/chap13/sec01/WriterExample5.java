package chap13.sec01;

import java.io.Writer;
import java.io.FileWriter;

public class WriterExample5 {
	
	public static void main(String [] args) throws Exception {
		Writer writer = new FileWriter("c:/temp/test8.txt");
		
		char[] array = {'a', 'b', 'c'};
		
		writer.write(array);
		
		writer.flush();
		writer.close();
		
		
		
	}

}
