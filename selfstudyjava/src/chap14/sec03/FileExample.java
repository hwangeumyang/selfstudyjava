package chap14.sec03;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FileExample {
	public static void main(String [] args) throws Exception{ 
		File dir = new File("c:/temp/images");
		File file1 = new File("c:/temp/file1.txt");
		File file2 = new File("c:/temp/file1.txt");
		File file3 = new File("c:/temp/file1.txt");
		
		if(dir.exists()==false) dir.mkdirs();
		if(file1.exists()==false) file1.createNewFile();
		if(file2.exists()==false) file2.createNewFile();
		if(file3.exists()==false) file3.createNewFile();
		
		File temp = new File("c:/temp");
		File[] contents = temp.listFiles();
		
		System.out.println("시간\t\t\t형태\t\t크기\t이름");
		System.out.println("========================================================");
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd a HH:mm");
		for(File file : contents) {
			System.out.print(sdf.format(new Date(file.lastModified())));
			if(file.isDirectory())
				System.out.println("\t<DIR>\t\t\t" + file.getName());
			else System.out.println("\t\t\t" + file.length() + "\t" + file.getName());
//			System.out.println();
		}

		
		
	}
}
