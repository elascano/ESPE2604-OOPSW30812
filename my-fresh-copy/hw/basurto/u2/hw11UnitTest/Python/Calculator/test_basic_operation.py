from basic_operation import BasicOperation


def test_add():

    result = BasicOperation.add(2.4, 1.2)

    assert round(result, 2) == 3.6


def test_subtract():

    result = BasicOperation.subtract(3.6, 1.2)

    assert round(result, 2) == 2.4