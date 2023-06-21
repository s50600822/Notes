import unittest
from fib import fibonacci

class TestFibonacci(unittest.TestCase):
    def test_fibonacci(self):
        self.assertEqual(fibonacci(0), 0)  # Test base case
        self.assertEqual(fibonacci(1), 1)  # Test base case
        self.assertEqual(fibonacci(2), 1)
        self.assertEqual(fibonacci(5), 5)
        self.assertEqual(fibonacci(10), 55)
        # Add more test cases as needed
        
if __name__ == '__main__':
    unittest.main()
