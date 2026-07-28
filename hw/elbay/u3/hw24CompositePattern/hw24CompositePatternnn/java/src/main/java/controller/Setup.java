package controller;

import model.*;
import view.Client;

public class Setup {
    public static void main(String[] args) {
        TextFile readme = new TextFile("readme.txt", 2);
        ImageFile logo = new ImageFile("logo.png", 150);
        Directory assets = new Directory("assets");
        assets.add(readme);
        assets.add(logo);

        TextFile mainCode = new TextFile("main.py", 8);
        TextFile utilsCode = new TextFile("utils.py", 5);
        Directory src = new Directory("src");
        src.add(mainCode);
        src.add(utilsCode);

        Directory project = new Directory("project");
        project.add(assets);
        project.add(src);

        Client.rootItem = project;
        Client.doClientTasks();
    }
}
