
//@uthor Christopher Lomas,<CodeBros>,ESPE

const fs = require('fs');
const path = require('path');

class Cathedral {
    constructor(id, name, city, height) {
        this.id = id;
        this.name = name;
        this.city = city;
        this.height = height;
    }
}

let cathedralsList = [];

const c1 = new Cathedral(101, "Saint Basil", "Moscow", 52);
const c2 = new Cathedral(102, "Notredam Cathedral", "France", 108);
const c3 = new Cathedral(103, "Cologne Cathedral", "Cologne", 157);

cathedralsList.push(c1, c2, c3);

const filePath = path.join(__dirname, 'cathedrals.json');

const jsonString = JSON.stringify(cathedralsList, null, 4);
fs.writeFileSync(filePath, jsonString);

const fileData = fs.readFileSync(filePath, 'utf8');
const importedCathedrals = JSON.parse(fileData);

console.log("Information ready for the JSON file:");
console.log(importedCathedrals);

