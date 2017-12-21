package com.lanhuigu.base.annotation;

public class TestTable {

    public void execute() {
        System.out.println("Executing ......");
    }

    @Test
    void testExecute() {
        execute();
    }

}
