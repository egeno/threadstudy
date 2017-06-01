package com.liyang.threadStudy;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

import com.sun.corba.se.impl.orbutil.closure.Future;

public class ThreadTest1 {

	public static void main(String[] args) {
		Callable<Integer> myCallable = new MyCallable();
		FutureTask<Integer> ft = new FutureTask<Integer>(myCallable);
		for (int i = 0; i < 100; i++) {
			System.out.println(Thread.currentThread().getName() + " " + i);
			if (i == 30) {
				Thread thread = new Thread(ft);
				thread.start();
			}
		}
		System.out.println("主线程for循环执行完毕..");

		try {
			int sum = ft.get();
			System.out.println("sum=" + sum);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}

class MyCallable implements Callable<Integer> {
	private int i = 0;

	@Override
	public Integer call() {
		int sum = 0;
		for (; i < 100; i++) {
			System.out.println(Thread.currentThread().getName() + " " + i);
			sum += i;
		}
		return sum;
	}
}
