package main

import (
	"fmt"
)

func main() {

	// Create a channel
	ch := make(chan int)

	// Start a goroutine that adds values to the queue
	go func() {
		for i := 0; i < 10; i++ {
			ch <- i
		}
	}()

	// Start a goroutine that removes values from the queue
	go func() {
		for {
			v := <-ch
			fmt.Println(v)
		}
	}()

	select {}

}
