package chap14.Lab;

import java.io.*;
// competition of byte based stream and character based stream
public class BBvsCB {
	static String msg = "hello friends?";
	static byte[] msg_b = msg.getBytes();
	static char[] msg_c = msg.toCharArray();
	public static void main(String [] args) throws Exception{
		long s, e;
		
		StringBuffer bb = new StringBuffer("bb: ");
		StringBuffer cb = new StringBuffer("cb: ");
		
		
		for(int i=0; i<30; ++i) {		
			s = System.nanoTime();		
			writeWithBB();
			e = System.nanoTime();
			
			bb.append((e - s) + "\t");
			
			s = System.nanoTime();		
			writeWithCB();
			e = System.nanoTime();
			
			cb.append((e-s) + "\t");
		}
		
		System.out.println(bb);
		System.out.println(cb);
		
		
	}
	
	public static void writeWithBB() throws Exception{
		FileOutputStream fos = new FileOutputStream("c:/temp/ByteBasedStream");
		
		for(int i=0; i<500; ++i)
			fos.write(msg_b);
		
		fos.flush();
		fos.close();
	}
	public static void writeWithCB() throws Exception{
		FileWriter w = new FileWriter("c:/temp/CharacterBasedStream");
		
		for(int i=0; i<500; ++i)
			w.write(msg);
		
		w.flush();
		w.close();
	}
	

}
