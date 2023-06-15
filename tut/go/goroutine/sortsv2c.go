package main

import (
	"bufio"
	"fmt"
	"log"
	"os"
	"strconv"
	"strings"
	"sync"
)

const chunkCount = 4

func main() {
	slice := make([]int, 0)

	fmt.Println("Please input several nums(integral multiples of 4):")
	scanner := bufio.NewScanner(os.Stdin)
	scanner.Scan()
	input := scanner.Text()
	nums := strings.Fields(input)

	for _, num := range nums {
		val, err := strconv.Atoi(num)
		if err == nil {
			slice = append(slice, val)
		}
	}

	slices := chunkSlice(slice, chunkCount)
	sortConcurrently(slices)

	res := merge(slices)

	fmt.Println(slices)

	fmt.Println(res)

	// res := concatSlices(slices)

	// fmt.Println(res)

	// BubbleSort(res)
	// log.Println("Entire sorted list", res)
}

func sortConcurrently(slices [][]int) {
	var wg sync.WaitGroup
	wg.Add(len(slices))

	for i := 0; i < len(slices); i++ {
		i := i
		go func() {
			log.Println("Slice being sorted", slices[i])
			BubbleSort(slices[i])
			log.Println("Sorted slice", slices[i])
			wg.Done()
		}()
	}
	wg.Wait()

}

func merge2(s1, s2 []int) []int {
	var tmp []int
	i, j := 0, 0
	for i < len(s1) || j < len(s2) {
		if i == len(s1) {
			tmp = append(tmp, s2[j])
			j++
			continue
		}
		if j == len(s2) {
			tmp = append(tmp, s1[i])
			i++
			continue
		}
		if s1[i] < s2[j] {
			tmp = append(tmp, s1[i])
			i++
			continue
		}
		tmp = append(tmp, s2[j])
		j++
	}
	return tmp
}

func merge(slices [][]int) []int {
	s1 := merge2(slices[0], slices[1])
	s2 := merge2(slices[2], slices[3])
	return merge2(s1, s2)
}

func chunkSlice(slice []int, chunkCount int) [][]int {
	chunks := make([][]int, chunkCount)
	for i := 0; i < chunkCount; i++ {
		chunks[i] = make([]int, 0)
	}
	for i := 0; i < len(slice); i++ {
		chunks[i%chunkCount] = append(chunks[i%chunkCount], slice[i])
	}
	return chunks
}

func BubbleSort(slice []int) {
	for i := 0; i < len(slice); i++ {
		for j := 0; j < (len(slice) - i - 1); j++ {
			if (slice)[j] > (slice)[j+1] {
				Swap(slice, j)
			}
		}
	}
}

func Swap(slice []int, i int) {
	(slice)[i], (slice)[i+1] = (slice)[i+1], (slice)[i]
}
