const TextFile = require("../model/TextFile");
const ImageFile = require("../model/ImageFile");
const Directory = require("../model/Directory");
const Client = require("../view/Client");

const readme = new TextFile("readme.txt", 2);
const logo = new ImageFile("logo.png", 150);
const assets = new Directory("assets");
assets.add(readme);
assets.add(logo);

const mainCode = new TextFile("main.py", 8);
const utilsCode = new TextFile("utils.py", 5);
const src = new Directory("src");
src.add(mainCode);
src.add(utilsCode);

const project = new Directory("project");
project.add(assets);
project.add(src);

Client.rootItem = project;
Client.doClientTasks();
