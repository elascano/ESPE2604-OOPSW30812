/*
========================================================
SD CARD MANAGEMENT SYSTEM
Programming Exam - JavaScript with JSON
========================================================

Student:
Alexander Tipantiza

University:
Universidad de las Fuerzas Armadas ESPE

========================================================
PROJECT DESCRIPTION
========================================================

This project was developed using JavaScript and Node.js.

The system allows the user to manage SD Cards
using a console menu and JSON files for data storage.

The program includes:

- Classes
- Attributes
- Constructors
- JSON files
- File management
- Object-oriented programming
- Class diagram
- CRUD operations

========================================================
PROJECT STRUCTURE
========================================================

model/
    SDCard.js

view/
    ConsoleView.js

util/
    fileManager.js

data/
    sdcards.json

index.js

package.json

========================================================
CLASS DESCRIPTION
========================================================

Class:
SDCard

Attributes:
- id
- brand
- capacity
- price

Constructor:
Used to initialize SD Card objects.

========================================================
FUNCTIONALITIES
========================================================

1. Create SD Card
2. View all SD Cards
3. Search SD Card by ID
4. Delete SD Card
5. Exit program

========================================================
JSON FILE
========================================================

The file "sdcards.json" stores all SD Card
objects permanently.

Example:

[
  {
    "id": 1,
    "brand": "SanDisk",
    "capacity": 128,
    "price": 25
  }
]

========================================================
CLASS DIAGRAM
========================================================

+-------------------+
|      SDCard       |
+-------------------+
| - id              |
| - brand           |
| - capacity        |
| - price           |
+-------------------+
| + constructor()   |
+-------------------+

========================================================
TECHNOLOGIES USED
========================================================

- JavaScript
- Node.js
- JSON
- Object-Oriented Programming
- MVC Structure

========================================================
END OF DOCUMENT
========================================================
*/