package com.hobson.test;

import com.hobson.simple.IdProduction;

/**
 * @author haibin.tang
 * @create 2020-01-20 2:31 PM
 **/
public class IdProductionThread extends Thread {

    @Override
    public void run() {
        System.out.println(IdProduction.getCode());
    }
}
