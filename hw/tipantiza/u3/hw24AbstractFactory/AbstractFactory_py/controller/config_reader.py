import sys

class ConfigReader:
    
    @staticmethod
    def get_os_type():
        return ConfigReader.detect_os_from_system()
    
    @staticmethod
    def detect_os_from_system():
        os_name = sys.platform.lower()
        if os_name.startswith('win'):
            return 0
        elif os_name.startswith('darwin'):
            return 2
        else:
            return 1
    
    @staticmethod
    def get_operating_system_name():
        os_type = ConfigReader.get_os_type()
        if os_type == 0:
            return "Windows"
        elif os_type == 2:
            return "Mac"
        else:
            return "Linux"