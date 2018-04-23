package ua.nure.strebkov.Practice5.part6;

import java.io.IOException;
import java.io.RandomAccessFile;

public class Part6 extends Thread {

	private static final Object MONITOR = new Object();

	private static final int THREADS_NUMBER = 10;

	private static final int COLUMNS = 20;

	private static final int EOL_LENGTH = System.lineSeparator().length();

	private static String fileName = "test.txt";
	
	private Thread[] threads;	
	
	

	private RandomAccessFile out;
	

	@Override
	public void run() {
		for(int i = 0; i <= THREADS_NUMBER; i ++) {
			threads[i] = new Thread();
			threads[i].start();
		}
			
	}

	public static void main(String[] args) throws IOException,
			InterruptedException {
		// TODO place your code here
	}

}