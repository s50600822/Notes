package main

import (
	"fmt"
	"math/rand"
	"sync"
)

type ChopS struct {
	sync.Mutex
}

type Philo struct {
	seatNo  int
	leftCS  *ChopS
	rightCS *ChopS
}

func (p Philo) eat(wg *sync.WaitGroup) {
	p.leftCS.Lock()
	p.rightCS.Lock()

	fmt.Printf("starting to eat %d\n", p.seatNo)
	fmt.Printf("finishing eating %d\n", p.seatNo)

	p.rightCS.Unlock()
	p.leftCS.Unlock()
	wg.Done()
}

func hostPermission(wg *sync.WaitGroup, philos []*Philo, info map[int]int) {
	var counter int = 0
	for {
		if counter != 14 {
			philo1 := rand.Intn(5)
			philo2 := rand.Intn(5)
			if philo1 != philo2 {
				if info[philo1] < 3 && info[philo2] < 3 {
					var wg2 sync.WaitGroup
					wg2.Add(2)
					go philos[philo1].eat(&wg2)
					go philos[philo2].eat(&wg2)
					wg2.Wait()
					info[philo1]++
					info[philo2]++
					counter += 2
				}
			}
		} else {
			philo1 := rand.Intn(5)
			if info[philo1] < 3 {
				var wg2 sync.WaitGroup
				wg2.Add(1)
				go philos[philo1].eat(&wg2)
				wg2.Wait()
				counter++
				wg.Done()
			}
		}
	}

}

func main() {
	// initialize info
	var info = make(map[int]int)
	for i := 0; i < 5; i++ {
		info[i] = 0
	}
	// initialize chops
	CSticks := make([]*ChopS, 5)
	for i := 0; i < 5; i++ {
		CSticks[i] = new(ChopS)
	}
	philos := make([]*Philo, 5)
	for i := 0; i < 5; i++ {
		philos[i] = &Philo{i + 1, CSticks[i], CSticks[(i+1)%5]}
	}
	var wg sync.WaitGroup
	wg.Add(1)
	go hostPermission(&wg, philos, info)
	wg.Wait()
}
