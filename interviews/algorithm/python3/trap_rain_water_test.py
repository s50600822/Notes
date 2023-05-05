import unittest
from trap_rain_water import trap

class TestTrapRainWater(unittest.TestCase):
    def test_empty_array(self):
        self.assertEqual(trap([]), 0)
        
    def test_single_element_array(self):
        self.assertEqual(trap([1]), 0)
        
    def test_two_elements_array(self):
        self.assertEqual(trap([1, 2]), 0)
        self.assertEqual(trap([2, 1]), 0)
        
    def test_three_elements_array(self):
        # The smallest height is in the middle
        self.assertEqual(trap([2, 1, 2]), 1)
        # The smallest height is at the edges
        self.assertEqual(trap([3, 1, 3]), 2)
        self.assertEqual(trap([3, 2, 3]), 1)
        
    def test_four_elements_array(self):
        # The smallest height is at the edges
        self.assertEqual(trap([3, 0, 0, 2]), 4)
        # The smallest height is in the middle
        self.assertEqual(trap([2, 0, 0, 3]), 4)
        
    def test_five_elements_array(self):
        # The smallest height is at index 2
        self.assertEqual(trap([0, 1, 0, 2, 1, 0, 1, 3]), 5)
        # The smallest height is at index 3
        self.assertEqual(trap([0, 1, 0, 2, 1, 0, 1, 4]), 5)
        
    def test_orgiginal(self):
        self.assertEqual(trap([0,1,0,2,1,0,1,3,2,1,2,1]), 6)
        
if __name__ == '__main__':
    unittest.main()