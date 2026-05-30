from controller.basic_operation import BasicOperation


def test_add():
    expected = 8.1
    result = BasicOperation.add(5.10, 3.0)

    assert expected == result


def test_subtract():
    expected = 0.0
    result = BasicOperation.subtract(0.0, 0.0)

    assert expected == result