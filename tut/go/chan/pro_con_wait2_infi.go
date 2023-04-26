package main

import (
	"fmt"
	"sync"
)

func main() {
	var wg sync.WaitGroup
	wg.Add(2) // Add two goroutines to the WaitGroup

	// Create a channel
	ch := make(chan int)

	// Start a goroutine that adds values to the queue
	go func() {
		defer wg.Done()
		for i := 0; i < 10; i++ {
			ch <- i
		}
		close(ch)
	}()

	// Start a goroutine that removes values from the queue
	go func() {
		defer wg.Done()
		for { // for v := range ch
			v := <-ch
			fmt.Println(v)
		}
	}()
	wg.Wait()
}
