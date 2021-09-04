package chap03.sec01;

import java.io.Writer;
import java.io.FileWriter;

public class WriterExample6 {
	
	public static void main(String [] args) throws Exception {
		Writer writer = new FileWriter("c:/temp/test9.txt");
		
		char[] array = {'a', 'b', 'c', 'd', 'e'};
		
		writer.write(array, 1, 3);
		
		writer.flush();
		writer.close();
		
	}

}
