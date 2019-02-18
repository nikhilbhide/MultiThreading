package com.nik.tutorial.threading.diningphilosopher;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
* This class implements dining philospher's problem.
* Five silent philosophers sit at a round table with bowls of spaghetti. Forks are placed between each pair of adjacent philosophers.
* Each philosopher must alternately think and eat. However, a philosopher can only eat spaghetti when they have both left and right forks.
* Each fork can be held by only one philosopher and so a philosopher can use the fork only if it is not being used by another philosopher. 
* After an individual philosopher finishes eating, they need to put down both forks so that the forks become available to others. 
* A philosopher can take the fork on their right or the one on their left as they become available, but cannot start eating before getting both forks.
* Eating is not limited by the remaining amounts of spaghetti or stomach space; an infinite supply and an infinite demand are assumed.

* The problem is how to design a discipline of behavior (a concurrent algorithm) such that no philosopher will starve; i.e., each can forever continue to alternate between eating and thinking. 
* @author nikhil.bhide
*/
public class DiningPhilosopherExample {
	private ArrayList<Philosopher> philosphers = new ArrayList();
	Fork[] forks = new Fork[5];

	
	public Fork[] getForks() {
		return forks;
	}

	public void setForks(Fork[] forks) {
		this.forks = forks;
	}

	/**
	 * Add philosopher to the group
	 * 
	 * @param philosopherInstance The object that represents the philosopher
	 * 
	 * @return <code>true</code> if philosopher is added successfully to the group
	 * 
	 */
	public boolean addPhilosopher(Philosopher philosopherInstance) {
		philosphers.add(philosopherInstance);
		return true;
	}
	
	public ArrayList<Philosopher> getPhilosphers() {
		return philosphers;
	}

	public void setPhilosphers(ArrayList<Philosopher> philosphers) {
		this.philosphers = philosphers;
	}

	/**
	 * Action to perform eating or thinking activities done by the philosopher. 
	 * These actions are performed randonly based on the availability of both the forks - right and left
	 *  
	 * @return
	 * @throws InterruptedException
	 * @throws ExecutionException
	 */
	public boolean eatNThink() throws InterruptedException, ExecutionException {
		ArrayList<Future<Boolean>> eatingDoneFuture = new ArrayList();
		ExecutorService service = Executors.newCachedThreadPool(); 
		
		for(Philosopher philospher:philosphers) {
			service.submit(philospher);
		}
		
		Thread.sleep(1000);
		
		return true;
	}
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		DiningPhilosopherExample instance = new DiningPhilosopherExample();
		Philosopher philosopher1 = new Philosopher("1");
		Philosopher philosopher2 = new Philosopher("2");
		Philosopher philosopher3 = new Philosopher("3");
		Philosopher philosopher4 = new Philosopher("4");
		Philosopher philosopher5 = new Philosopher("5");
		Fork fork1 = new Fork();
		Fork fork2 = new Fork();
		Fork fork3 = new Fork();
		Fork fork4 = new Fork();
		Fork fork5 = new Fork();
		
		
		philosopher1.setLeftFork(fork1);
		philosopher1.setRightFork(fork2);
		
		philosopher2.setLeftFork(fork2);
		philosopher2.setRightFork(fork3);
		
		philosopher3.setLeftFork(fork3);
		philosopher3.setRightFork(fork4);
		
		philosopher4.setLeftFork(fork4);
		philosopher4.setRightFork(fork5);
		
		philosopher5.setLeftFork(fork5);
		philosopher5.setRightFork(fork1);

		instance.addPhilosopher(philosopher1);
		instance.addPhilosopher(philosopher2);
		instance.addPhilosopher(philosopher3);
		instance.addPhilosopher(philosopher4);
		instance.addPhilosopher(philosopher5);
			
		instance.eatNThink();
		Thread.sleep(1000);
		instance.displayStats();
	}

	public void displayStats() {
		for(Philosopher philospher:philosphers) {
			philospher.setMealOver(true);
		}	
		
		for(Philosopher philospher:philosphers) {
			System.out.println("Philosopher - " + philospher.getName() + " Meals - "+philospher.getNumOfMeals());
		}
	}	
}