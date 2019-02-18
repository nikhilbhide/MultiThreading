package com.nik.tutorial.threading.MultithreadingExamples;

public class App {
	public static void main(String[] args) throws InterruptedException {
		CustomInteger customIntegerInstance = new CustomInteger();
		ThreadDemo instance1 = new ThreadDemo();
		instance1.setCustomInteger(customIntegerInstance);
		instance1.start();
		ThreadDemo instance2 = new ThreadDemo();
		instance2.setCustomInteger(customIntegerInstance);
		instance2.start();
		ThreadDemo instance3 = new ThreadDemo();
		instance3.setCustomInteger(customIntegerInstance);
		instance3.start();
	}
}
