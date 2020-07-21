package com.jpeony.java.compute;

/**
 * 递增(++)和递减(--)
 *
 * @author yihongeli
 */
public class AutoTest {
    public static void main(String[] args) {
        // 1.递增
        // 1.1 先++（双加号在前）
        int preAdd = 1;
        //执行逻辑:preAdd先加1变成2，得到的结果preAdd为2赋值给表达式++preAdd,即preAddNum为2
        int preAddNum = ++preAdd;
        System.out.println("preAdd:" + preAdd);
        System.out.println("preAddNum:" + preAddNum);

        // 1.2 后++（双加号在后）
        int aftAdd = 1;
        //执行逻辑:先把aftAdd的值1赋值给表达式aftAdd++,即aftAddNum为1,再把aftAdd加1变成2
        int aftAddNum = aftAdd++;
        System.out.println("aftAdd:" + preAdd);
        System.out.println("aftAddNum:" + aftAddNum);

        //2.递减
        //2.1 先--（双减号在前）
        int preSubtract = 1;
        //执行逻辑:preSubtract先减1变成0，得到的结果preSubtract为0赋值给表达式--preSubtract,即preSubtractNum为0
        int preSubtractNum = --preSubtract;
        System.out.println("preSubtract:" + preSubtract);
        System.out.println("preSubtractNum:" + preSubtractNum);

        //2.2 后--（双减号在后）
        int aftSubtract = 1;
        //执行逻辑:先把aftSubtract的值1赋值给表达式aftSubtract--,即aftSubtractNum为1,再把aftSubtract减1变成0
        int aftSubtractNum = aftSubtract--;
        System.out.println("aftSubtract:" + preSubtract);
        System.out.println("aftSubtractNum:" + aftSubtractNum);
    }
}
