package ua.nure.strebkov.Practice5.part1;

public class Part1 {

	public static void main(String[] args) throws InterruptedException {
		Thread t1 = new Part1().new MyThread();
		t1.start();
		// t1.join();
		// System.out.println("=========");
		Thread t = new Thread(new Part1().new MyThreadRun());
		t.start();
		// t.join();
	}

	private class MyThread extends Thread {
		@Override
		public void run() {
			for (int i = 0; i < 10; i++) {
				System.out.println(getName());
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}

	private class MyThreadRun implements Runnable {
		@Override
		public void run() {
			for (int i = 0; i < 10; i++) {
				System.out.println(Thread.currentThread().getName());
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
