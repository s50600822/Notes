use std::env;
use std::time::Instant;

fn main () {
    let start = Instant::now();
    
    let args: Vec<String> = env::args().collect();
    let input_num: u64 = args[1].parse().unwrap();
    let result = fib(input_num);
    
    let duration = start.elapsed().as_nanos();
    println!("startNs:[{:?}] elaspedNs:[{:?}] {:?}", start, duration, result);
}

// 93 max https://r-knott.surrey.ac.uk/Fibonacci/fibtable.html
fn fib(n: u64) -> u64 {
    if n < 0 {
        panic!("{} is negative!", n);
    } else if n == 0 {
        panic!("zero is not a right argument to fibonacci()!");
    } else if n == 1 {
        return 1;
    }

    let mut sum = 0;
    let mut last = 0;
    let mut curr = 1;
    for _i in 1..n {
        sum = last + curr;
        last = curr;
        curr = sum;
    }
    sum
}