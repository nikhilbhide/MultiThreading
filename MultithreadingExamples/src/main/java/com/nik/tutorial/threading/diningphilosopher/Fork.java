package com.nik.tutorial.threading.diningphilosopher;

import java.util.concurrent.locks.ReentrantLock;

/**
 * Class that represents a fork. Access to a fork is facilitated by a lock object.
 * 
 * @author nikhil.bhide
 *
 */public class Fork {
	ReentrantLock lock = new ReentrantLock();

	public ReentrantLock getLock() {
		return lock;
	}

	public void setLock(ReentrantLock lock) {
		this.lock = lock;
	}	
}