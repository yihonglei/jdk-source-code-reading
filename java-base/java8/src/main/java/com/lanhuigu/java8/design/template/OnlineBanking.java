package com.lanhuigu.java8.design.template;

/**
 * @author yihonglei
 * @version 1.0.0
 * @ClassName: OnlineBanking
 * @Package: com.lanhuigu.java8.design.template
 * @date 2018/6/29 11:53
 */
public abstract class OnlineBanking {
    /** 模板方法不变的部分 */
    public void processCustomer(int id){
        Customer c = Database.getCustomerWithId(id);
        makeCustomerHappy(c);
    }

    // dummy Customer class
    static private class Customer {}
    // dummy Datbase class
    static private class Database{
        static Customer getCustomerWithId(int id){ return new Customer();}
    }

    /** 模板方法可变的部分 */
    abstract void makeCustomerHappy(Customer c);
}
