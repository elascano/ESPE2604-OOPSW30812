package view;

import model.FileSystemItem;

public class Client {
    public static FileSystemItem rootItem;

    public static void doClientTasks() {
        if (rootItem != null) {
            rootItem.describe();
        }
    }
}
