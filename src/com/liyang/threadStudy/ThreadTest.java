package com.liyang.threadStudy;

public class ThreadTest {

	public static void main(String[] args) {
		for (int i = 0; i < 100; i++) {
			System.out.println(Thread.currentThread().getName() + " " + i);
			if (i == 30) {
				// Thread myThread1 = new MyThread();
				// Thread myThread2 = new MyThread();
				Runnable myRunnable = new MyRunnable();
				Thread myThread1 = new Thread(myRunnable);
				Thread myThread2 = new Thread(myRunnable);
				myThread1.start();
				myThread2.start();
			}

		}

	}

}
