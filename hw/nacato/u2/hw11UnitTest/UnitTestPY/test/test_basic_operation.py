import unittest
import sys
import os

sys.path.append(os.path.abspath(os.path.join(os.path.dirname(__file__), '..')))
from controller.basic_operation import BasicOperation

class TestBasicOperation(unittest.TestCase):

    def test_add(self):
        add_cases = [
            (1.5, 2.5, 4.0),
            (10.0, 5.0, 15.0),
            (0.0, 0.0, 0.0),
            (2.5, 3.5, 6.0),
            (4.0, 4.0, 8.0),
            (150.2, 250.3, 400.5),
            (20.0, 30.0, 50.0),
            (1.2, 1.2, 2.4),
            (8.5, 1.5, 10.0),
            (0.4, 0.20, 0.60)
        ]
        print("test_add (test_basic_operation.TestBasicOperation.test_add) ... Running parameterized add test for: 1.2 + 2.4")
        for addend1, addend2, expResult in add_cases:
            print(f"Running parameterized add test for: {addend1} + {addend2}")
            result = BasicOperation.add(addend1, addend2)
            self.assertAlmostEqual(expResult, result, places=3)
        print("\033[92mck\033[0m")

    def test_subtract(self):
        sub_cases = [
            (20.0, 10.0, 10.0),
            (0.0, 0.0, 0.0),
            (-5.5, -2.5, -3.0),
            (-1.0, 4.0, -5.0),
            (400.5, 200.5, 200.0),
            (50.0, 20.0, 30.0),
            (3.3, 1.1, 2.2),
            (15.0, 5.0, 10.0),
            (90.0, 40.0, 50.0),
            (0.85, 0.35, 0.50)
        ]
        print("test_subtract (test_basic_operation.TestBasicOperation.test_subtract) ... Running parameterized subtract test for: 3.6 - 1.2")
        for minuend, subtrahend, expResult in sub_cases:
            print(f"Running parameterized subtract test for: {minuend} - {subtrahend}")
            result = BasicOperation.subtract(minuend, subtrahend)
            self.assertAlmostEqual(expResult, result, places=3)
        print("\033[92mck\033[0m")

if __name__ == '__main__':
    unittest.main()