package ua.nure.strebkov.Practice5.part2;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

class Test extends Thread {

	public void run() {
		while (true) {
			try {
				System.out.println("Demon works");
				Thread.sleep(300);
			} catch (InterruptedException ex) {
				ex.printStackTrace();
			}
		}
	}

	public static void main(String[] args) throws Exception {
		Test t = new Test();
		t.setDaemon(true);
		t.start();

		new Thread() {
			public void run() {
				byte[] buffer = new byte[10];
				int count;
				try {
					do {
						while ((count = System.in.read(buffer)) == -1)
							;
					} while (!System.lineSeparator().equals(new String(buffer, 0, count)));
				} catch (IOException ex) {
					ex.printStackTrace();
				}
				System.out.println("ENTER has been obtained");
			}
		}.start();
	}
}

public class Part2 {
	public static void main(String[] args) throws Exception {
		// save standard input
		InputStream stdIn = System.in;
		// create input stream with line terminator (=ENTER)
		ByteArrayInputStream bais = new ByteArrayInputStream(System.lineSeparator().getBytes());
		// move internal pointer of input stream to the end of input
		bais.skip(System.lineSeparator().length());
		// assign new value of standard input
		System.setIn(bais);

		// main functionality
		Test.main(args);
		// wait for 3 s
		Thread.sleep(3000);
		System.out.println("Try to send enter to standard input");
		// move internal pointer to begin of input
		bais.reset();
		// restore standard input
		System.setIn(stdIn);
	}
}
