from abc import ABC, abstractmethod

class GUIFactory(ABC):
    
    @staticmethod
    def get_factory():
        sys = GUIFactory.read_from_file("OS_TYPE")
        if sys == 0:
            import model.WinFactory as wf  
            return wf.WinFactory()        
        else:
            import model.LinuxFactory as lf  
            return lf.LinuxFactory()         

    @staticmethod
    def read_from_file(key):
        try:
            with open("config.properties", "r") as f:
                for line in f:
                    if line.strip() and not line.startswith("#"):
                        k, v = line.split("=")
                        if k.strip() == key:
                            return int(v.strip())
            return 0
        except (FileNotFoundError, ValueError):
            return 0

    @abstractmethod
    def create_button(self):
        pass

    @abstractmethod
    def create_menu(self):
        pass