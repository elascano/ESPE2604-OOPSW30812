import unittest
import sys
from pathlib import Path

# Add project root directory to path so calculator module can be resolved
root_dir = str(Path(__file__).resolve().parent.parent)
if root_dir not in sys.path:
    sys.path.append(root_dir)

from calculator.basic_operation import BasicOperation

class TestBasicOperation(unittest.TestCase):
    def test_add(self):
        # Basic assertions for add method
        self.assertEqual(BasicOperation.add(0.0, 0.0), 0.0)
        self.assertEqual(BasicOperation.add(5.5, 4.5), 10.0)
        self.assertEqual(BasicOperation.add(-1.0, 1.0), 0.0)

    def test_subtract(self):
        # Basic assertions for subtract method
        self.assertEqual(BasicOperation.subtract(0.0, 0.0), 0.0)
        self.assertEqual(BasicOperation.subtract(10.0, 4.5), 5.5)
        self.assertEqual(BasicOperation.subtract(-1.0, -1.0), 0.0)

if __name__ == '__main__':
    unittest.main()
