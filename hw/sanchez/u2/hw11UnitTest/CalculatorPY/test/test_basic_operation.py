import unittest
import sys
import os

sys.path.append(os.path.dirname(os.path.dirname(os.path.abspath(__file__))))

from controller.basic_operation import BasicOperation


class TestBasicOperation(unittest.TestCase):
    
    def test_add(self):
        print("add")
        addent1 = 1.2
        addent2 = 2.4
        expResult = 3.6
        result = BasicOperation.add(addent1, addent2)
        self.assertAlmostEqual(expResult, result, delta=0.0001)
    
    def test_addsmall(self):
        print("add")
        addent1 = 4.2
        addent2 = 2.4
        expResult = 3.6
        result = BasicOperation.add(addent1, addent2)
        self.assertAlmostEqual(expResult, result, delta=3)
    
    def test_subtract(self):
        print("subtract")
        minuend = 0.0
        subtrahend = 0.0
        expResult = 0.0
        result = BasicOperation.subtract(minuend, subtrahend)
        self.assertAlmostEqual(expResult, result, delta=0.0001)


if __name__ == "__main__":
    unittest.main()