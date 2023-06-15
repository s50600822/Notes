package main

import (
	"bufio"
	"fmt"
	"math"
	"os"
	"sort"
	"strconv"
	"strings"
)

/*
Write a program to sort an array of integers. The program should partition the array into 4 parts, each of which is
sorted by a different goroutine. Each partition should be of approximately equal size. Then the main goroutine should
merge the 4 sorted subarrays into one large sorted array.

The program should prompt the user to input a series of integers. Each goroutine which sorts ¼ of the array should
print the subarray that it will sort. When sorting is complete, the main goroutine should print the entire sorted list.
*/

const (
	NoSubarrays = 4
)

func ScanIntSeries(intSlice []int) []int {
	fmt.Print("Enter a series of integers split by spaces: ")
	input, readError := bufio.NewReader(os.Stdin).ReadString('\n')
	if readError != nil {
		panic(readError)
	}

	input = strings.TrimSuffix(input, "\n")
	splitWords := strings.Split(input, " ")

	for idx := range splitWords {
		integer, conversionError := strconv.Atoi(splitWords[idx])
		if conversionError != nil {
			panic(strings.Join([]string{"Error:", splitWords[idx], "is not a number"}, " "))
		}

		intSlice = append(intSlice, integer)
	}

	return intSlice
}

func SortSubarray(subarray []int, channel chan []int) {
	fmt.Println("Sorting subarray", subarray)
	sort.Ints(subarray)
	channel <- subarray
}

func SplitAndSortSubarrays(intSlice []int, channel chan []int) int {
	seriesLength := len(intSlice)
	subarraySize := int(math.Max(float64(seriesLength)/NoSubarrays, 1))
	from := 0
	startedSubroutines := 0

	for i := 0; i < NoSubarrays && from < seriesLength; i++ {
		to := from + subarraySize

		if to > seriesLength || i == NoSubarrays-1 {
			to = seriesLength
		}

		go SortSubarray(intSlice[from:to], channel)
		startedSubroutines++
		from = to
	}

	return startedSubroutines
}

func CollectResults(startedSubroutines int, channel chan []int) [][]int {
	results := make([][]int, startedSubroutines)

	for idx := range results {
		results[idx] = <-channel
	}

	return results
}

func MergeAndSortResults(sortedSubarrays [][]int) []int {
	result := make([]int, 0)
	for _, subarray := range sortedSubarrays {
		result = append(result, subarray...)
	}
	sort.Ints(result)
	return result
}

func main() {
	intSlice := make([]int, 0)
	intSlice = ScanIntSeries(intSlice)

	channel := make(chan []int, NoSubarrays)

	startedSubroutines := SplitAndSortSubarrays(intSlice, channel)
	results := CollectResults(startedSubroutines, channel)
	sortedArray := MergeAndSortResults(results)

	fmt.Println("Sorted array", sortedArray)
}
