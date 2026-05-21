# model/json_manager.py

import json
import os

class JsonManager:
    """Handles JSON file operations for Student data"""
    
    FILE_NAME = os.path.join("data", "students.json")
    
    @classmethod
    def _ensure_data_dir(cls):
        """Ensure the data directory exists"""
        data_dir = os.path.dirname(cls.FILE_NAME)
        if not os.path.exists(data_dir):
            os.makedirs(data_dir)
    
    @classmethod
    def save_students(cls, students):
        """
        Save list of students to JSON file
        
        Args:
            students (list): List of Student objects
        """
        try:
            cls._ensure_data_dir()
            
            data = [student.to_dict() for student in students]
            
            with open(cls.FILE_NAME, "w", encoding="utf-8") as file:
                json.dump(data, file, indent=2, ensure_ascii=False)
            
            return True
        
        except Exception as e:
            print(f"Error saving students: {e}")
            return False
    
    @classmethod
    def read_students(cls):
        """
        Read list of students from JSON file
        
        Returns:
            list: List of Student objects
        """
        try:
            if not os.path.exists(cls.FILE_NAME):
                return []
            
            with open(cls.FILE_NAME, "r", encoding="utf-8") as file:
                data = json.load(file)
            
            # Import Student here to avoid circular import
            from model.student import Student
            
            students = []
            for item in data:
                student = Student.from_dict(item)
                students.append(student)
            
            return students
        
        except Exception as e:
            print(f"Error reading students: {e}")
            return []
    
    @classmethod
    def delete_data_file(cls):
        """Delete the data file (useful for testing)"""
        if os.path.exists(cls.FILE_NAME):
            os.remove(cls.FILE_NAME)
            return True
        return False