package main

import (
	"bufio"
	"fmt"
	"net"
	"os"
)

func handleIncomingMessages(conn net.Conn) {
	// Continuously listen for incoming messages from the server
	for {
		message, err := bufio.NewReader(conn).ReadString('\n')
		if err != nil {
			fmt.Println("Error receiving message:", err.Error())
			os.Exit(1)
		}
		fmt.Print(message)
	}
}

func main() {
	// Connect to server
	conn, err := net.Dial("tcp", "localhost:8080")
	if err != nil {
		fmt.Println("Error connecting to server:", err.Error())
		os.Exit(1)
	}
	defer conn.Close()

	// Start goroutine to handle incoming messages from server
	go handleIncomingMessages(conn)

	// Continuously read input from user and send to server
	for {
		// Read user input
		reader := bufio.NewReader(os.Stdin)
		fmt.Print("> ")
		input, _ := reader.ReadString('\n')

		// Send message to server
		_, err = conn.Write([]byte(input))
		if err != nil {
			fmt.Println("Error sending message:", err.Error())
			os.Exit(1)
		}
	}
}
