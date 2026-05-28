import unittest
from controller.basic_operation import BasicOperation

class TestBasicOperation(unittest.TestCase):

    def test_add(self):
        add_cases = [
            [1.2, 2.4, 3.6],
            [5.0, 5.0, 10.0],
            [1.1, 1.1, 2.2],
            [-1.5, -2.5, -4.0]
        ]
        
        for operand1, operand2, expected_result in add_cases:
            with self.subTest(msg=f"Adding {operand1} + {operand2}"):
                actual_result = BasicOperation.add(operand1, operand2)
                self.assertAlmostEqual(actual_result, expected_result, places=2)

    def test_subtract(self):
  
        subtract_cases = [
            [3.6, 1.2, 2.4],
            [10.0, 5.0, 5.0],
            [2.2, 1.1, 1.1],
            [-4.0, -1.5, -2.5]
        ]
        
        for minuend, subtrahend, expected_result in subtract_cases:
            with self.subTest(msg=f"Subtracting {minuend} - {subtrahend}"):
                actual_result = BasicOperation.subtract(minuend, subtrahend)
                self.assertAlmostEqual(actual_result, expected_result, places=2)

if __name__ == '__main__':
    unittest.main()