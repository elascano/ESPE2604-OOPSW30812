package model;

public class ImageFile extends FileSystemItem {
    public ImageFile(String aName, long aSize) {
        this();
        name = aName;
        size = aSize;
    }

    public ImageFile() {
    }

    @Override
    public void describe() {
        super.describe();
    }
}
