import pytest
from calculator.controller.basic_operation import BasicOperation

def test_add():
    print("add")
    addend1 = 1.2
    addend2 = 2.4
    exp_result = 3.6
    
    result = BasicOperation.add(addend1, addend2)
    assert result == pytest.approx(exp_result)

def test_subtract():
    print("subtract")
    minuend = 3.6
    subtrahend = 1.2
    exp_result = 2.4
    
    result = BasicOperation.subtract(minuend, subtrahend)
    assert result == pytest.approx(exp_result)