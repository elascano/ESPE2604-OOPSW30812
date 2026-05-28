# model/student.py

class Student:
    """Student class representing a student with subjects and grades"""
    
    def __init__(self, first_name, last_name, age, subjects_grades=None):
        """
        Initialize a Student object
        
        Args:
            first_name (str): Student's first name
            last_name (str): Student's last name
            age (int): Student's age
            subjects_grades (dict): Dictionary of subjects with list of grades
        """
        self._first_name = first_name
        self._last_name = last_name
        self._age = age
        self._subjects_grades = subjects_grades or {}
    
    # Properties (Getters and Setters)
    @property
    def first_name(self):
        return self._first_name
    
    @first_name.setter
    def first_name(self, value):
        self._first_name = value
    
    @property
    def last_name(self):
        return self._last_name
    
    @last_name.setter
    def last_name(self, value):
        self._last_name = value
    
    @property
    def age(self):
        return self._age
    
    @age.setter
    def age(self, value):
        self._age = value
    
    @property
    def subjects_grades(self):
        return self._subjects_grades
    
    @subjects_grades.setter
    def subjects_grades(self, value):
        self._subjects_grades = value
    
    def get_overall_average(self):
        """
        Calculate the overall average of all grades
        
        Returns:
            float: Overall average rounded to 2 decimals
        """
        total = 0
        count = 0
        
        for grades in self._subjects_grades.values():
            for grade in grades:
                total += grade
                count += 1
        
        if count == 0:
            return 0.0
        
        return round(total / count, 2)
    
    def add_subject(self, subject, grades):
        """Add a subject with its grades"""
        self._subjects_grades[subject] = grades
    
    def remove_subject(self, subject):
        """Remove a subject from the student"""
        if subject in self._subjects_grades:
            del self._subjects_grades[subject]
            return True
        return False
    
    def get_subject_names(self):
        """Get list of all subject names"""
        return list(self._subjects_grades.keys())
    
    def to_dict(self):
        """Convert Student object to dictionary for JSON serialization"""
        return {
            "firstName": self._first_name,
            "lastName": self._last_name,
            "age": self._age,
            "subjectsGrades": self._subjects_grades
        }
    
    @staticmethod
    def from_dict(data):
        """Create Student object from dictionary"""
        return Student(
            data.get("firstName", ""),
            data.get("lastName", ""),
            data.get("age", 0),
            data.get("subjectsGrades", {})
        )
    
    def __str__(self):
        return f"{self._first_name} {self._last_name} - Age: {self._age} - Avg: {self.get_overall_average()}"