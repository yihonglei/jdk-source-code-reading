package com.lanhuigu.reflect.constructors;

import com.lanhuigu.reflect.common.MyObject;

import java.lang.reflect.Constructor;

public class Test4 {
    public static void main(String[] args) throws NoSuchMethodException {
        /** 获取Class对象 */
        Class myClass = MyObject.class;
        /** 获取对象中所有构造器 */
        Constructor[] constructors = myClass.getConstructors();
        /** 遍历构造器 */
        for (int i = 0; i < constructors.length; i ++) {
            Constructor constructor = constructors[i];
            System.out.println("###########第"+(i+1)+"个构造器--start--###########");
            /** 获取构造器中参数列表 */
            Class[] parameterTypes = constructor.getParameterTypes();
            for (Class type : parameterTypes) {
                /** 循环打印构造器参数类型 */
                System.out.println("构造器参数类型:"+type.getName());
            }
            System.out.println("###########第"+(i+1)+"个构造器--end--###########");
        }
    }
}
