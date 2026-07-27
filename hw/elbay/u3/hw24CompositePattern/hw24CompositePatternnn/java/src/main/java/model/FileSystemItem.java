package model;

public abstract class FileSystemItem {
    protected String name = "unnamed";
    protected long size = 0;

    public void describe() {
        System.out.println(name + " - " + size + "KB");
    }
}
