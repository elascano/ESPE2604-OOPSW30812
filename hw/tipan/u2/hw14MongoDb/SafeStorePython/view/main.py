from model.supplier import Supplier
from dao.supplier_dao import save_supplier

from model.cash_control import CashControl
from dao.cash_control_dao import save_cash_control

from model.slow_moving import SlowMoving
from dao.slow_moving_dao import save_slow_moving


supplier = Supplier("1", "David", "0988247321", "david@gmail.com")
save_supplier(supplier)

cash = CashControl("David", 100, 150)
save_cash_control(cash)

item = SlowMoving("Papel Higienico", 150, 3, "Slow Moving")
save_slow_moving(item)

print("TODO GUARDADO EN MONGO")