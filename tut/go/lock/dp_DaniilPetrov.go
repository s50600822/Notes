package main

import (
	"fmt"
	"sync"
	"time"
)

type chopStick struct {
	sync.Mutex
}

type philo struct {
	leftChopStick  *chopStick
	rightChopStick *chopStick
	num            int
}

func (p philo) eat(group *sync.WaitGroup, ch chan int) {
	defer group.Done()

	for i := 0; i < 3; i++ {
		<- ch

		p.leftChopStick.Lock()
		p.rightChopStick.Lock()

		fmt.Println("Philo", p.num, "started to eat", i)
		time.Sleep(5 * time.Second)
		fmt.Println("Philo", p.num, "finished eating", i)

		p.rightChopStick.Unlock()
		p.leftChopStick.Unlock()

		ch <- 1
	}

}

func host(ch chan int) {
	ch <- 1
	ch <- 1
}

func main() {
	var chopSticks = make([]*chopStick, 5)
	for i := 0; i < 5; i++ {
		chopSticks[i] = new(chopStick)
	}

	var philos = make([]*philo, 5)
	for i := 0; i < 5; i++ {
		philos[i] = &philo{chopSticks[i], chopSticks[(i+1)%5], i}
	}

	var group sync.WaitGroup
	var ch = make(chan int, 2)

	go host(ch)

	for i := 0; i < 5; i++ {
		group.Add(1)
		go philos[i].eat(&group, ch)
	}

	group.Wait()
}
