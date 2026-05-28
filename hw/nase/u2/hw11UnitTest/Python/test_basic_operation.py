import unittest
from BasicOperation import BasicOperation


import unittest
from BasicOperation import BasicOperation


class TestBasicOperation(unittest.TestCase):

    def test_add(self):

        add_cases = [
            (1.2, 2.4, 3.6),
            (5.0, 5.0, 10.0),
            (0.1, 1.0, 1.1),
            (-1.5, -2.5, -4.0),
            (-5.0, 3.0, -2.0),
            (100.5, 200.5, 301.0),
            (0.001, 0.002, 0.003),
            (10.0, 20.0, 30.0),
            (1.1, 1.1, 2.2),
            (9.9, 0.1, 10.0)
        ]

        
        for addend1, addend2, expected in add_cases:

            result = BasicOperation.add(addend1, addend2)

            print(f"{addend1} + {addend2} = {result}")

            self.assertAlmostEqual(expected, result, places=2)

    def test_subtract(self):

        subtract_cases = [
            (3.6, 1.2, 2.4),
            (10.0, 5.0, 5.0),
            (0.8, 0.13, 0.67),
            (-4.0, -1.5, -2.5),
            (-2.0, 3.0, -5.0),
            (301.0, 100.5, 200.5),
            (0.003, 0.001, 0.002),
            (30.0, 10.0, 20.0),
            (2.2, 1.1, 1.1),
            (10.0, 0.1, 9.9)
        ]

      
        for minuend, subtrahend, expected in subtract_cases:

            result = BasicOperation.subtract(minuend, subtrahend)

            print(f"{minuend} - {subtrahend} = {result}")

            self.assertAlmostEqual(expected, result, places=2)


if __name__ == "__main__":
    unittest.main()