import unittest
#@uthor Christopher Lomas,CodeBros,ESPE
from controller.basic_operation import BasicOperation

class TestBasicOperation(unittest.TestCase):

    def test_add(self):
        
        add_cases = [
            (1.2, 2.4, 3.6),      
            (5.0, 5.0, 10.0),      
            (0.0, 0.0, 0.0),       
            (-1.5, -2.5, -4.0),    
            (-5.0, 3.0, -2.0),     
            (100.5, 200.5, 301.0), 
            (0.001, 0.002, 0.003), 
            (10.0, 20.0, 30.0),    
            (1.1, 1.1, 2.2),       
            (9.9, 0.1, 10.0),      
            (-10.0, -10.0, -20.0), 
            (50.0, 25.0, 75.0),    
            (0.5, 0.25, 0.75)      
        ]
        
        for addend1, addend2, expected in add_cases:
            
            with self.subTest(msg=f"Scenario: {addend1} + {addend2}"):
                print(f"Running parameterized add test for: {addend1} + {addend2}")
                
                self.assertAlmostEqual(BasicOperation.add(addend1, addend2), expected, places=3)

    def test_subtract(self):
        
        subtract_cases = [
            (3.6, 1.2, 2.4),       
            (10.0, 5.0, 5.0),      
            (0.0, 0.0, 0.0),       
            (-4.0, -1.5, -2.5),    
            (-2.0, 3.0, -5.0),     
            (301.0, 100.5, 200.5), 
            (0.003, 0.001, 0.002), 
            (30.0, 10.0, 20.0),    
            (2.2, 1.1, 1.1),       
            (10.0, 0.1, 9.9),      
            (-20.0, -10.0, -10.0), 
            (75.0, 25.0, 50.0),    
            (0.75, 0.25, 0.5)      
        ]
        
        for minuend, subtrahend, expected in subtract_cases:
            with self.subTest(msg=f"Scenario: {minuend} - {subtrahend}"):
                print(f"Running parameterized subtract test for: {minuend} - {subtrahend}")
                self.assertAlmostEqual(BasicOperation.subtract(minuend, subtrahend), expected, places=3)

if __name__ == '__main__':
    unittest.main()