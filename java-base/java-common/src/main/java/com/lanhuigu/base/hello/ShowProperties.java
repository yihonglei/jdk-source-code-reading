package com.lanhuigu.base.hello;

import java.util.Properties;

public class ShowProperties {
    public static void main(String[] args) {
        // 系统属性
        Properties p = System.getProperties();
        System.out.println("=============直接通过list打印===============");
        p.list(System.out);
        System.out.println("=============对应属性打印==============");
        System.out.println("Java运行时环境的版本:" + p.getProperty("java.version"));
        System.out.println("Java运行时环境的供应商:" + p.getProperty("java.vendor"));
        System.out.println("Java厂商的官方网址:" + p.getProperty("java.vendor.url"));
        System.out.println("Java安装目录:" + p.getProperty("java.home"));
        System.out.println("Java虚拟机规范版本:" + p.getProperty("java.vm.specification.version"));
        System.out.println("Java虚拟机规范供应商:" + p.getProperty("java.vm.specification.vendor"));
        System.out.println("Java虚拟机规范供应商名称:" + p.getProperty("java.vm.specification.name"));
        System.out.println("Java虚拟机实现的版本:" + p.getProperty("java.vm.version"));
        System.out.println("Java虚拟机实现的版本供应商:" + p.getProperty("java.vm.vendor"));
        System.out.println("Java虚拟机实现的版本供应商名称:" + p.getProperty("java.vm.name"));
        System.out.println("Java运行时环境规范的版本:" + p.getProperty("java.specification.version"));
        System.out.println("Java运行时环境规范的版本供应商:" + p.getProperty("java.specification.vendor"));
        System.out.println("Java运行时环境规范的版本供应商名称:" + p.getProperty("java.specification.name"));
        System.out.println("Java类格式版本号:" + p.getProperty("java.class.version"));
        System.out.println("Java类路径:" + p.getProperty("java.class.path"));
        System.out.println("Java运行路径搜索时加载库列表:" + p.getProperty("java.library.path"));
        System.out.println("默认的临时文件路径:" + p.getProperty("java.io.tmpdir"));
        System.out.println("JIT编译器使用的名称:" + p.getProperty("java.compiler"));
        System.out.println("一个或多个扩展目录路径:" + p.getProperty("java.ext.dirs"));
        System.out.println("操作系统名称:" + p.getProperty("os.name"));
        System.out.println("操作系统结构:" + p.getProperty("os.arch"));
        System.out.println("操作系统版本:" + p.getProperty("os.version"));
        System.out.println("在UNIX文件分隔符(“/”):" + p.getProperty("file.separator"));// unix,linux为/,windows为\
        System.out.println("路径分隔符(UNIX)':':" + p.getProperty("path.separator"));
        System.out.println("行分隔符('\n'在UNIX):" + p.getProperty("line.separator"));
        System.out.println("用户的账户名称:" + p.getProperty("user.name"));
        System.out.println("用户的主目录:" + p.getProperty("user.home"));
        System.out.println("用户的当前工作目录(项目工作空间):" + p.getProperty("user.dir"));

    }
}
