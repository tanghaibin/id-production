package com.hobson.test;

import com.hobson.simple.IdProduction;
import org.junit.Test;

/**
 * 生成器测试
 *
 * @author haibin.tang
 * @create 2020-01-20 2:29 PM
 **/
public class IdProductionTest {

    @Test
    public void test() {
        System.out.println(IdProduction.getCode());
    }

    /**
     * 多线程测试并发场景下的id生成是否重复
     */
    @Test
    public void threadTest() {
        for (int index = 0; index < 1000; ++ index) {
            IdProductionThread thread = new IdProductionThread();
            thread.start();
        }
        try {
            Thread.currentThread().join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}