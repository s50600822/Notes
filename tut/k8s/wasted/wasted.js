let memoryUsage = 0;
let totalTime = 0;
const maxTime = 5 * 60 * 1000; // 5 minutes

function allocateMemory() {
    const arr = new Array(10 * 1024 * 1024); // Allocating 10 MiB of memory
    memoryUsage += 10;
    console.log(`Memory usage: ${memoryUsage} MiB`);
    totalTime += 1000; // Increment total time by 1 second
    if (totalTime < maxTime) {
        setTimeout(allocateMemory, 1000); // Call allocateMemory again after 1 second
    } else {
        console.log("Memory allocation completed. Exiting...");
        process.exit(0);
    }
}
allocateMemory();
