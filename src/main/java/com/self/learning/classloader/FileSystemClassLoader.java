package com.self.learning.classloader;

import java.io.*;

public class FileSystemClassLoader extends ClassLoader {
    private String rootDir ;

    public FileSystemClassLoader(String rootDir) {
        this.rootDir = rootDir;
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        Class<?> loadedClass = this.findLoadedClass(name);
        if (loadedClass != null) {
            return loadedClass;
        } else {
            try {
                loadedClass = this.getParent().loadClass(name);
            } catch (ClassNotFoundException e) {
            }
            if (loadedClass != null) {
                return loadedClass;
            } else {
                byte[] bytes = getClassBytes(name);
                if (bytes == null) {
                    throw new ClassNotFoundException();
                } else {
                    loadedClass = this.defineClass(name, bytes, 0, bytes.length);
                }
            }
        }
        return loadedClass;
    }

    //com.self.learning.Person  D:/project/j2selearning/target/classes/com/self/learning/Person.class
    private byte[] getClassBytes(String name) {
        String path = this.rootDir + "/" + name.replaceAll("\\.", "/") + ".class";
        InputStream is = null;
        try {
            is = new FileInputStream(path);
            byte[] buffer = new byte[1024];
            int length = 0;
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            while ((length = is.read(buffer)) != -1) {
                baos.write(buffer, 0, length);
            }
            return baos.toByteArray();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }
}
