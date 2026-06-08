#!/usr/bin/env python3
"""
SafeStore - Main entry point
"""

from view.main_frame import MainApp
from model.mongodb_connection import MongoDBConnection

def main():
    """Main entry point"""
    MongoDBConnection.connect()
    app = MainApp()
    app.run()

if __name__ == "__main__":
    main()