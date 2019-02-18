package com.nik.tutorial.threading.diningphilosopher;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

/**
 * Class that represents philosopher. This class is responsible for performing eat and think activities of a philosopher.
 * 
 * @author nikhil.bhide
 *
 */
public class Philosopher implements Callable<Boolean>{
	private String name;
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	private Fork leftFork;
	
	public Fork getLeftFork() {
		return leftFork;
	}

	public void setLeftFork(Fork leftFork) {
		this.leftFork = leftFork;
	}

	public Fork getRightFork() {
		return rightFork;
	}

	public void setRightFork(Fork rightFork) {
		this.rightFork = rightFork;
	}

	private Fork rightFork;
	
	
	private volatile boolean isMealOver = false;
	
	public boolean isMealOver() {
		return isMealOver;
	}

	public void setMealOver(boolean isMealOver) {
		this.isMealOver = isMealOver;
	}

	private int numOfMeals = 0;

	public int getNumOfMeals() {
		return numOfMeals;
	}

	public void setNumOfMeals(int numOfMeals) {
		this.numOfMeals = numOfMeals;
	}

	public Philosopher(String name) {
		this.name = name;
	}

	public Boolean call() throws Exception {
		boolean eatingDone = false; 
		while(!isMealOver) {
			eatNThink();
		}
		return true;
	}

	public void eatNThink() throws InterruptedException {
		eat();
		think();
	}

	/**
	 * Performs the thinking activity of a philopsher.
	 * For a philosopher, eating is the priority if fork can not be accessed then a philosopher starts to think.
	 *  
	 * @throws InterruptedException
	 */
	public void think() throws InterruptedException {
		System.out.println("Philosopher # "+name + " is thinking");
		Thread.sleep(100);
	}

	/**
	 * Performs the eating activity of the philosopher.
	 * A philosopher can eat only when a philosopher can get access to both the forks.
	 * Its simulated by making use of locks. Philosopher can acquire lock on the left fork and then lock on the right fork.
	 * Otherwise, just return to thinking mode 
	 *  
	 * @throws InterruptedException
	 */
	public void eat() throws InterruptedException {
		if(leftFork.getLock().tryLock(10,TimeUnit.MILLISECONDS)) {
			try {
				if(rightFork.getLock().tryLock(10,TimeUnit.MILLISECONDS)) {
					System.out.println("Philosopher # "+name + " is eating");
					Thread.sleep(100);
					numOfMeals++;
					rightFork.getLock().unlock();
				}

			} catch (InterruptedException e) {
			}
			leftFork.getLock().unlock();
		}
	}
}