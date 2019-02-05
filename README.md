# MultiThreading
This repository provides the examples for multithreading. 
All of the common problems and applications are implemented in this repository using Java.
Following examples are implemented - 
1. Concurrency - Simple integer Vs Custom integer
In this example, multiple threads access two objects - simple integer and atomic integer. 
As access to simple integer is not thread safe, behavior is non-deterministic.
Atomic integer guarantees the thread safe concurrent access.

2. Dining Philosopher's Problem
Five silent philosophers sit at a round table with bowls of spaghetti. Forks are placed between each pair of adjacent philosophers.

Each philosopher must alternately think and eat. However, a philosopher can only eat spaghetti when they have both left and right forks. Each fork can be held by only one philosopher and so a philosopher can use the fork only if it is not being used by another philosopher. After an individual philosopher finishes eating, they need to put down both forks so that the forks become available to others. A philosopher can take the fork on their right or the one on their left as they become available, but cannot start eating before getting both forks.

Eating is not limited by the remaining amounts of spaghetti or stomach space; an infinite supply and an infinite demand are assumed.

The problem is how to design a discipline of behavior (a concurrent algorithm) such that no philosopher will starve; i.e., each can forever continue to alternate between eating and thinking, assuming that no philosopher can know when others may want to eat or think.
