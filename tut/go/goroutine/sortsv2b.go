package main

import (
	"fmt"
	"sort"
	"strconv"
	"strings"
	"sync"
)

var partitionNumber = 4

func main() {
	// Prompt the user to input a series of integers
	fmt.Println("Enter a series of integers (comma-separated):")
	var inputStr string
	_, err := fmt.Scanln(&inputStr)
	if err != nil {
		fmt.Println("Error reading input:", err)
		return
	}

	// Convert input string to an array of integers
	input := parseInput(inputStr)
	fmt.Println("Parsed array:", input)

	// Calculate the partition size
	partitionSize := len(input) / partitionNumber

	// Create wait group to synchronize goroutines
	var wg sync.WaitGroup

	// Create channels to communicate with goroutines
	channels := make([]chan []int, partitionNumber)

	// Launch goroutines to sort each partition
	for i := 0; i < partitionNumber; i++ {
		start := i * partitionSize
		end := (i + 1) * partitionSize

		// Last goroutine handles any remaining elements
		if i == partitionNumber-1 {
			end = len(input)
		}

		partedArray := input[start:end]
		fmt.Println("Parted array:", partedArray)

		channels[i] = make(chan []int, 1) // Buffered channel with capacity 1
		wg.Add(1)
		go sortPartition(partedArray, channels[i], &wg)
	}

	// Wait for all goroutines to complete
	wg.Wait()

	// Merge sorted subarrays
	merged := mergeSortedArrays(channels)

	// Print the sorted array
	fmt.Println("Sorted array:", merged)
}

func parseInput(inputStr string) []int {
	trimmed := strings.TrimSpace(inputStr)
	if trimmed == "" {
		return []int{}
	}

	strArr := strings.Split(trimmed, ",")
	input := make([]int, len(strArr))

	for i, str := range strArr {
		num, err := strconv.Atoi(strings.TrimSpace(str))
		if err != nil {
			fmt.Println("Invalid input:", str)
			return []int{}
		}
		input[i] = num
	}

	return input
}

func sortPartition(arr []int, c chan []int, wg *sync.WaitGroup) {
	// Sort the partition
	sort.Ints(arr)

	// Send the sorted partition through the channel
	c <- arr

	// Notify the wait group that this goroutine has completed
	wg.Done()
}

func mergeSortedArrays(channels []chan []int) []int {
	// Create a slice to store the merged sorted array
	merged := make([]int, 0)

	// Create a wait group to synchronize merging
	var wg sync.WaitGroup
	wg.Add(len(channels))

	// Launch a goroutine for each channel to merge the sorted subarrays
	for _, c := range channels {
		go func(c chan []int) {
			// Receive the sorted partition from the channel
			partition := <-c

			// Merge the partition with the existing sorted array
			merged = mergeArrays(merged, partition)

			// Notify the wait group that merging is complete
			wg.Done()
		}(c)
	}

	// Wait for all goroutines to complete merging
	wg.Wait()

	return merged
}

func mergeArrays(arr1, arr2 []int) []int {
	merged := make([]int, 0, len(arr1)+len(arr2))
	i, j := 0, 0

	for i < len(arr1) && j < len(arr2) {
		if arr1[i] < arr2[j] {
			merged = append(merged, arr1[i])
			i++
		} else {
			merged = append(merged, arr2[j])
			j++
		}
	}

	merged = append(merged, arr1[i:]...)
	merged = append(merged, arr2[j:]...)

	return merged
}