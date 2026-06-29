from utils.console_printer import ConsolePrinter

class StreamingPlatformView:

    def __init__(self):
        self.printer = ConsolePrinter()

    def show_message(self, message):
        self.printer.print(message)