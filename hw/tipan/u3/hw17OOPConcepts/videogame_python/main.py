from warrior import Warrior
from mage import Mage
from archer import Archer
from team import Team

w = Warrior(1, "Arthur", 10, 100)
m = Mage(2, "Merlin", 12, 80)
a = Archer(3, "Robin", 11, 90)

w.add_item("Sword")
m.add_item("Staff")
a.add_item("Bow")

w.display_info()
m.display_info()
a.display_info()

print("\n--- POLYMORPHISM ---")
w.attack()
m.attack()
a.attack()

print("\n--- TEAM ---")
team = Team("Legends")
team.add_member(w)
team.add_member(m)
team.add_member(a)
team.show_team()