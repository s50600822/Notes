package main

import (
	"fmt"
	"math/rand"
	"sync"
	"time"
)

type Chopstick struct{ sync.Mutex }

type Philosopher struct {
	number                        int
	leftChopstick, rightChopstick *Chopstick
}

func (p Philosopher) eat(host chan bool, wg *sync.WaitGroup) {
	defer wg.Done()

	for i := 0; i < 3; i++ {
		host <- true // Request permission from the host to eat
		p.leftChopstick.Lock()
		p.rightChopstick.Lock()

		fmt.Println("Starting to eat", p.number)

		time.Sleep(time.Duration(rand.Intn(1000)) * time.Millisecond) // Simulate eating time

		fmt.Println("Finishing eating", p.number)

		p.rightChopstick.Unlock()
		p.leftChopstick.Unlock()
		<-host // Release permission to the host
	}
}

func main() {
	rand.Seed(time.Now().UnixNano())

	chopsticks := make([]*Chopstick, 5)
	for i := 0; i < 5; i++ {
		chopsticks[i] = new(Chopstick)
	}

	philosophers := make([]*Philosopher, 5)
	host := make(chan bool, 2) // Allow two philosophers to eat concurrently
	wg := &sync.WaitGroup{}

	for i := 0; i < 5; i++ {
		philosophers[i] = &Philosopher{
			number:         i + 1,
			leftChopstick:  chopsticks[i],
			rightChopstick: chopsticks[(i+1)%5],
		}
	}

	rand.Shuffle(5, func(i, j int) {
		philosophers[i], philosophers[j] = philosophers[j], philosophers[i]
	})

	for _, p := range philosophers {
		wg.Add(1)
		go p.eat(host, wg)
	}

	wg.Wait()
}
