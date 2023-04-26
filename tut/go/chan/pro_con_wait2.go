package main

import (
	"fmt"
	"sync"
)

func main() {
	// Create a WaitGroup
	var wg sync.WaitGroup
	wg.Add(2) // Add two goroutines to the WaitGroup

	// Create a channel
	ch := make(chan int)

	// Start a goroutine that adds values to the queue
	go func() {
		defer wg.Done() // Mark the goroutine as done when it exits
		for i := 0; i < 10; i++ {
			ch <- i
		}
		close(ch) // Close the channel when done adding values
	}()

	// Start a goroutine that removes values from the queue
	go func() {
		defer wg.Done() // Mark the goroutine as done when it exits
		for v := range ch {
			fmt.Println(v)
		}
	}()

	wg.Wait() // Wait for both goroutines to finish
}
