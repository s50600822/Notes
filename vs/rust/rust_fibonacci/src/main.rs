use std::env;

fn main () {
    let args: Vec<String> = env::args().collect();
    let input_num: i32 = args[1].parse().unwrap();
    println!("{}", fib(input_num));
}


fn fib(n: i32) -> u64 {
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