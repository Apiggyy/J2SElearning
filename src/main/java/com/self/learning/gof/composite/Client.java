package com.self.learning.gof.composite;

public class Client {

    public static void main(String[] args) {
        AbstractFile f1,f2;
        Folder f3 = new Folder("二级目录");
        Folder f4 = new Folder("一级目录");

        f1 = new ImageFile("head.jpg");
        f1.killVirus();

        f2 = new TextFile("myfile.txt");
        f2.killVirus();

        f3.add(f1);
        f3.add(f2);

        f4.add(f3);

        f4.killVirus();
    }
}
