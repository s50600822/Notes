package main

import (
	"bufio"
	"fmt"
	"net"
	"os"
)

func handleConnection(conn net.Conn, clients map[net.Conn]bool) {
	defer conn.Close()

	fmt.Printf("Client %v connected.\n", conn.RemoteAddr())

	// Add client to map
	clients[conn] = true

	// Send a welcome message
	conn.Write([]byte("Welcome to the chat room!\n"))

	// Continuously listen for incoming messages from the client
	for {
		// Read incoming message
		message, err := bufio.NewReader(conn).ReadString('\n')
		if err != nil {
			fmt.Printf("Client %v disconnected.\n", conn.RemoteAddr())
			delete(clients, conn)
			return
		}

		// Broadcast message to all clients
		for client := range clients {
			if client != conn {
				client.Write([]byte(message))
			}
		}
	}
}

func main() {
	// Listen for incoming connections
	ln, err := net.Listen("tcp", ":8080")
	if err != nil {
		fmt.Println("Error listening:", err.Error())
		os.Exit(1)
	}
	defer ln.Close()

	fmt.Println("Server started. Listening on :8080")

	// Map to keep track of connected clients
	clients := make(map[net.Conn]bool)

	for {
		// Accept incoming connections
		conn, err := ln.Accept()
		if err != nil {
			fmt.Println("Error accepting:", err.Error())
			continue
		}

		// Handle incoming connection in a new goroutine
		go handleConnection(conn, clients)
	}
}