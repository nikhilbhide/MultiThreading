package com.nik.tutorial.threading.MultithreadingExamples;

import java.util.concurrent.atomic.AtomicInteger;


/**
 * Custom Integer class that increments or decrements atomic integer instance
 * @author nikhil.bhide
 *
 */
public class CustomInteger {
	private AtomicInteger number = new AtomicInteger(0);
	private Integer simpleInteger = new Integer(0);

	public AtomicInteger getNumber() {
		return number;
	}

	public void setNumber(AtomicInteger number) {
		this.number = number;
	}
	
	public Integer increment() throws InterruptedException {
		return number.incrementAndGet();
	}
	
	public Integer incrementSimpleNumber() throws InterruptedException {
		simpleInteger = simpleInteger + 1;
		return simpleInteger;
	}
}