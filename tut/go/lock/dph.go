package main

import (
	"fmt"
	"sync"
	"time"
)

/*
There should be 5 philosophers sharing chopsticks, with one chopstick between each adjacent pair of philosophers.

Each philosopher should eat only 3 times (not in an infinite loop as we did in lecture)

The philosophers pick up the chopsticks in any order, not lowest-numbered first (which we did in lecture).

In order to eat, a philosopher must get permission from a host which executes in its own goroutine.

The host allows no more than 2 philosophers to eat concurrently.

Each philosopher is numbered, 1 through 5.

When a philosopher starts eating (after it has obtained necessary locks) it prints “starting to eat <number>” on a line by itself, where <number> is the number of the philosopher.

When a philosopher finishes eating (before it has released its locks) it prints “finishing eating <number>” on a line by itself, where <number> is the number of the philosopher.
*/

type stick struct{ sync.Mutex }
type phd struct {
	id          int
	left, right *stick
}

var wg sync.WaitGroup

func (p phd) eat() {
	defer wg.Done()
	for j := 0; j < 3; j++ {
		semaphore <- struct{}{}
		p.left.Lock()
		p.right.Lock()

		fmt.Printf("starting to eat %d\n", p.id+1)
		time.Sleep(time.Second)

		p.right.Unlock()
		p.left.Unlock()

		fmt.Printf("finishing eating %d\n", p.id+1)
		time.Sleep(time.Second)
		<-semaphore
	}

}

var (
	semaphore = make(chan struct{}, 2)
)

func main() {

	count := 5
	sticks := make([]*stick, count)
	for i := 0; i < count; i++ {
		sticks[i] = new(stick)
	}

	philosophers := make([]*phd, count)
	for i := 0; i < count; i++ {
		philosophers[i] = &phd{id: i, left: sticks[i], right: sticks[(i+1)%count]}
		wg.Add(1)
		go philosophers[i].eat()

	}
	wg.Wait()

}
