#!/bin/bash

# Navigate into each direct child directory
for dir in */; do
    if [ -d "$dir" ]; then
        echo "Entering directory: $dir"
        cd "$dir" || exit 1

        # Compile Solution.java and run the compiled class
        if [ -f "Solution.java" ]; then
            javac Solution.java && java -ea Solution
        else
            echo "Solution.java not found in $dir"
        fi

        # Return to the parent directory
        cd - || exit 1
        echo "Returning to parent directory"
    fi
done
