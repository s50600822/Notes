//https://leetcode.com/problems/combinations/
pub fn combine(n: i32, k: i32) -> Vec<Vec<i32>> {
    let mut result = Vec::new();
    let mut current = Vec::new();

    fn backtrack(result: &mut Vec<Vec<i32>>, current: &mut Vec<i32>, start: i32, end: i32, k: i32) {
        if k == 0 {
            result.push(current.clone());
        } else {
            for i in start..=end {
                current.push(i);
                backtrack(result, current, i + 1, end, k - 1);
                current.pop();
            }
        }
    }

    backtrack(&mut result, &mut current, 1, n, k);
    result
}


pub fn length_of_last_word(s: String) -> i32 {
    return s.trim()
    .split(' ')
    .last()
    .map_or(0, |word| word.len() as i32)
}

pub fn plus_one(digits: Vec<i32>) -> Vec<i32> {
    let mut digits = digits;
    let n = digits.len();
    for i in (0..n).rev() {
        if digits[i] == 9 {
            digits[i] = 0;
        } else {
            digits[i] += 1;
            return digits;
        }
    }
    digits.insert(0, 1);
    digits
}


#[cfg(test)]
mod tests {
    use super::*;

    #[test]
    fn test_combine() {
        assert_eq!(combine(4, 2), vec![vec![1,2], vec![1,3], vec![1,4], vec![2,3], vec![2,4], vec![3,4]]);
        assert_eq!(combine(1, 1), vec![vec![1]]);
        assert_eq!(combine(3, 3), vec![vec![1,2,3]]);
        assert_eq!(combine(5, 3), vec![vec![1,2,3], vec![1,2,4], vec![1,2,5], vec![1,3,4], vec![1,3,5], vec![1,4,5], vec![2,3,4], vec![2,3,5], vec![2,4,5], vec![3,4,5]]);
    }

    #[test]
    fn test_length_of_last_word() {
        assert_eq!(length_of_last_word(String::from("hello world")), 5);
        assert_eq!(length_of_last_word(String::from("  fly me   to   the moon  ")), 4);
        assert_eq!(length_of_last_word(String::from("luffy is still joyboy")), 6);
        assert_eq!(length_of_last_word(String::from("  ")), 0);
        assert_eq!(length_of_last_word(String::from("123 ")), 3);
        assert_eq!(length_of_last_word(String::from(" foo bar ")), 3);
    }
    #[test]
    fn test_plus_one() {
        assert_eq!(plus_one(vec![1, 2, 3]), vec![1, 2, 4]);
        assert_eq!(plus_one(vec![4, 3, 2, 1]), vec![4, 3, 2, 2]);
        assert_eq!(plus_one(vec![9]), vec![1, 0]);
        assert_eq!(plus_one(vec![9, 9]), vec![1, 0, 0]);
    }

    
}