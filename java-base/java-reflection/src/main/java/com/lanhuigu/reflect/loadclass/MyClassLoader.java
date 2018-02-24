package com.lanhuigu.reflect.loadclass;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class MyClassLoader extends ClassLoader {

    public MyClassLoader(ClassLoader parent) {
        super(parent);
    }

    public Class loadClass(String name) throws ClassNotFoundException {
        if(!"com.lanhuigu.reflect.loadclass.MyObject".equals(name))
            return super.loadClass(name);
        try {
            String url = "file:D:\\yhlGitHub\\Java-Base\\java-base\\java-reflection\\target\\classes\\com\\lanhuigu\\reflect\\loadclass\\MyObject.class";
            URL myUrl = new URL(url);
            URLConnection connection = myUrl.openConnection();
            InputStream input = connection.getInputStream();
            ByteArrayOutputStream buffer = new ByteArrayOutputStream();
            int data = input.read();
            while(data != -1){
                buffer.write(data);
                data = input.read();
            }
            input.close();
            byte[] classData = buffer.toByteArray();
            return defineClass("com.lanhuigu.reflect.loadclass.MyObject", classData, 0, classData.length);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) throws ClassNotFoundException,
            IllegalAccessException, InstantiationException {
        ClassLoader parentClassLoader = MyClassLoader.class.getClassLoader();
        MyClassLoader classLoader = new MyClassLoader(parentClassLoader);
        Class myObjectClass = classLoader.loadClass("com.lanhuigu.reflect.loadclass.MyObject");
        AnInterface2 object1 = (AnInterface2) myObjectClass.newInstance();
        MyObjectSuperClass object2 = (MyObjectSuperClass) myObjectClass.newInstance();
        //create new class loader so classes can be reloaded.
        classLoader = new MyClassLoader(parentClassLoader);
        myObjectClass = classLoader.loadClass("com.lanhuigu.reflect.loadclass.MyObject");
        object1 = (AnInterface2)       myObjectClass.newInstance();
        object2 = (MyObjectSuperClass) myObjectClass.newInstance();
    }
}
