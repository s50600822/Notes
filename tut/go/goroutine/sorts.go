package main

import (
	"bufio"
	"fmt"
	"os"
	"sort"
	"strconv"
	"sync"
)

func main() {
	var nums []int
	fmt.Println("one int per line:")

	scanner := bufio.NewScanner(os.Stdin)
	for scanner.Scan() {
		input := scanner.Text()
		if input == "" {
			break
		}
		num, err := strconv.Atoi(input)
		if err != nil {
			break
		}
		nums = append(nums, num)
	}

	n := len(nums)
	size := n / 4
	parts := make([]chan []int, 4)
	for i := 0; i < 4; i++ {
		start := i * size
		end := (i + 1) * size
		if i == 3 {
			end = n
		}
		parts[i] = make(chan []int, 1)
		go sortPart(nums[start:end], parts[i])
	}

	var sorted []int
	var wg sync.WaitGroup
	for _, part := range parts {
		wg.Add(1)
		go func(part chan []int) {
			sorted = append(sorted, <-part...)
			wg.Done()
		}(part)
	}
	wg.Wait()

	sort.Ints(sorted)

	fmt.Println("The sorted list is:")
	fmt.Println(sorted)
}

func sortPart(nums []int, ch chan []int) {
	sort.Ints(nums)
	fmt.Println(nums)
	ch <- nums
}
