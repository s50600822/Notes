package main

import (
	"fmt"
	"sync"
)

var eating int = 0
var mut sync.Mutex
var wg sync.WaitGroup

type ChopS struct {
	sync.Mutex
}

type Philo struct {
	leftCS, rightCS *ChopS
	num             int
	ch              chan int
}

func (p Philo) eat() {
	<-p.ch
	p.leftCS.Lock()
	p.rightCS.Lock()

	fmt.Printf("starting to eat %d\n", p.num)

	p.rightCS.Unlock()
	p.leftCS.Unlock()
	fmt.Printf("finising eating %d\n", p.num)
	mut.Lock()
	eating--
	mut.Unlock()
	wg.Done()
}

func host(ch chan int) {
	for {
		if eating < 2 {
			mut.Lock()
			eating++
			mut.Unlock()
			ch <- 1
		}
	}
}

func main() {
	CSticks := make([]*ChopS, 5)
	for i := 0; i < 5; i++ {
		CSticks[i] = new(ChopS)
	}

	ch := make(chan int, 2)
	go host(ch)

	philos := make([]*Philo, 5)
	for i := 0; i < 5; i++ {
		philos[i] = &Philo{CSticks[i], CSticks[(i+1)%5], i, ch}
	}

	wg.Add(15)
	for i := 0; i < 5; i++ {
		for j := 0; j < 3; j++ {
			go philos[i].eat()
		}
	}
	wg.Wait()

}
