const fs = require('fs');
const Table = require('../model/Table');

let tableArrayList = [];

const table1 = new Table(11, "Wood", "Brown", "1.5m x 0.8m");
const table2 = new Table(12, "Glass", "Transparent", "1.2m x 1.2m");
const table3 = new Table(13, "Metal", "Black", "2.0m x 1.0m");

tableArrayList.push(table1);
tableArrayList.push(table2);
tableArrayList.push(table3);

console.log(" Saving data to JSON ");

const dataToString = JSON.stringify(tableArrayList, null, 2);
fs.writeFileSync('tables.json', dataToString);

const rawData = fs.readFileSync('tables.json', 'utf8');
const listFromJson = JSON.parse(rawData);

console.log(" Data Read from File ");
console.table(listFromJson);