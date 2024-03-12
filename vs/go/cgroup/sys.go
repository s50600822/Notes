package main

import (
	"fmt"
	"runtime"

	"github.com/shirou/gopsutil/mem"
)

func main() {
	availableProcessors := runtime.NumCPU()
	fmt.Println("Available Processor Count:", availableProcessors)
	memInfo, err := mem.VirtualMemory()
	if err != nil {
		panic(err)
	}
	totalMemoryMB := memInfo.Total / 1024 / 1024
	freeMemoryMB := memInfo.Free / 1024 / 1024
	fmt.Println("Available Memory (Total):", totalMemoryMB, "MB")
	fmt.Println("Available Memory (Free):", freeMemoryMB, "MB")
}
