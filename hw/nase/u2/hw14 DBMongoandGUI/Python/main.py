from view.mother_view import MotherView
from controller.mother_controller import MotherController

if __name__ == "__main__":
    view = MotherView()
    
    controller = MotherController(view)
    
    view.mainloop()