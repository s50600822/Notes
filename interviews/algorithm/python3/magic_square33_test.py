import unittest
from magic_square33 import magic_square33

class TestMagicSquare33(unittest.TestCase):
    def test1(self):
        matrix = [[4,9,2], [3,5,7], [8,1,5]]
        self.assertEqual(magic_square33(matrix), 1)
    def test2(self):
        matrix = [[5,3,4], [1,5,8], [6,7,2]]
        self.assertEqual(magic_square33(matrix), 4)


if __name__ == '__main__':
    unittest.main()