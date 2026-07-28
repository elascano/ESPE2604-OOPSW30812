package model;

public class TextFile extends FileSystemItem {
    public TextFile(String aName, long aSize) {
        this();
        name = aName;
        size = aSize;
    }

    public TextFile() {
    }

    @Override
    public void describe() {
        super.describe();
    }
}
