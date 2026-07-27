package model;

import java.util.Vector;

public class Directory extends FileSystemItem {
    protected Vector<FileSystemItem> contents = new Vector<>();

    public Directory(String aName) {
        this();
        name = aName;
    }

    public Directory() {
    }

    @Override
    public void describe() {
        super.describe();
        if (contents.size() > 0) {
            for (int i = 0; i < contents.size(); ++i) {
                contents.elementAt(i).describe();
            }
        }
    }

    public void add(FileSystemItem anItem) {
        this.contents.addElement(anItem);
    }
}
