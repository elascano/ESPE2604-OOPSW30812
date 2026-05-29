import unittest
from model.basic_operation import BasicOperation

class TestBasicOperation(unittest.TestCase):

    def test_some_method(self):
        self.fail("The test case is a prototype.")

    def test_add(self):
        print("add")

        addend1 = 1.0
        addend2 = 2.0
        expected = 3.0

        result = BasicOperation.add(addend1, addend2)

        self.assertEqual(expected, result)

    def test_subtract(self):
        print("subtract")

        minuend = 3.6
        subtrahend = 1.2
        expected = 2.4

        result = BasicOperation.subtract(minuend, subtrahend)

        self.assertAlmostEqual(expected, result, places=1)


if __name__ == '__main__':
    unittest.main()