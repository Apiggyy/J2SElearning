package com.self.learning.gof.composite;

import java.util.ArrayList;
import java.util.List;

public interface AbstractFile {
    void killVirus();
}

class ImageFile implements AbstractFile {
    private String name;

    public ImageFile(String name) {
        this.name = name;
    }

    @Override
    public void killVirus() {
        System.out.println("---ImageFile:" + name + "进行查杀！");
    }
}

class TextFile implements AbstractFile {
    private String name;

    public TextFile(String name) {
        this.name = name;
    }

    @Override
    public void killVirus() {
        System.out.println("---TextFile:" + name + "进行查杀！");
    }
}

class Folder implements AbstractFile {
    private String name;
    private List<AbstractFile> files = new ArrayList<>();

    public Folder(String name) {
        this.name = name;
    }

    public void add(AbstractFile file) {
        files.add(file);
    }

    public void remove(AbstractFile file) {
        files.remove(file);
    }

    public AbstractFile get(int index) {
        return files.get(index);
    }

    @Override
    public void killVirus() {
        for (AbstractFile file : files) {
            System.out.println("---Folder:" + name + "开始进行查杀！");
            file.killVirus();
        }
    }
}
