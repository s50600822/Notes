package main

import (
	"bufio"
	"encoding/json"
	"fmt"
	"os"
	"sort"
	"strconv"
	"strings"
)

/*
Write a program to sort an array of integers.
The program should partition the array into 4 parts, each of which is sorted by a different goroutine.
Each partition should be of approximately equal size.
Then the main goroutine should merge the 4 sorted subarrays into one large sorted array.

The program should prompt the user to input a series of integers.
Each goroutine which sorts ¼ of the array should print the subarray that it will sort.
When sorting is complete, the main goroutine should print the entire sorted list.
*/
func main() {
	scanner := bufio.NewScanner(os.Stdin)
	var returnArray []int
	channel := make(chan []int, 8)

	fmt.Print("Enter array of numbers separated by whitespace: ")
	if scanner.Scan() {
		input := scanner.Text()
		tempSlice := strings.Split(strings.TrimSpace(input), " ")
		var s []int
		for _, i := range tempSlice {
			j, err := strconv.Atoi(i)
			if err != nil {
				panic(err)
			}
			s = append(s, j)
		}

		size := len(s) / 4
		var j int
		for i := 0; i < len(s); i += size {
			j += size
			if j > len(s) {
				j = len(s)
			}
			go func(slice []int) {
				sort.Ints(slice)
				channel <- slice
			}(s[i:j])
			fmt.Println(s[i:j])
		}

		array1 := <-channel
		array2 := <-channel
		array3 := <-channel
		array4 := <-channel

		returnArray = append(returnArray, array1...)
		returnArray = append(returnArray, array2...)
		returnArray = append(returnArray, array3...)
		returnArray = append(returnArray, array4...)

		sort.Ints(returnArray)
		returnJson, _ := json.Marshal(returnArray)
		os.Stdout.Write(returnJson)
	}
}
