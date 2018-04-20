package ua.nure.strebkov.Practice5.part2;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.Scanner;

public class Spam {
	private long[] times;
	private String[] messages;
	private Thread[] threads;

	public void start() {
		threads = new Thread[messages.length];
		for (int i = 0; i < messages.length; i++) {
			threads[i] = new MyThread(times[i], messages[i]);
			threads[i].start();
		}
	}

	public void stop() {
		for (int i = 0; i < messages.length; i++) {
			threads[i].interrupt();

		}
	}

	public Spam(long[] times, String[] messages) {
		this.times = times;
		this.messages = messages;
	}

	public static void main(String[] args) throws InterruptedException, IOException {
		Spam spam = new Spam(new long[] { 333L, 555L, 777L }, new String[] { "Hello", "World", "!!!" });
		spam.start();
		System.setIn(new ByteArrayInputStream(System.lineSeparator().getBytes("Cp1251")));
		BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));
	    consoleReader.readLine();
	    
		Thread.sleep(5000);
		
		/*Scanner sc = new Scanner(System.in);		
		sc.nextLine();
		spam.stop();
		sc.close()*/;

	}

	private class MyThread extends Thread {
		private long time;
		private String s;

		MyThread(long t, String s) {
			time = t;
			this.s = s;
		}

		@Override
		public void run() {
			try {
				while (!isInterrupted()) {
					sleep(time);
					System.out.println(s);
				}
			} catch (InterruptedException e) {
				return;
			}
		}
	}
}
