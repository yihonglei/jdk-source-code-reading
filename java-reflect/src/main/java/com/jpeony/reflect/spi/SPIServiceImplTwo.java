package com.jpeony.reflect.spi;

public class SPIServiceImplTwo implements SPIService {

    @Override
    public void execute() {
        System.out.println("SPIServiceImplTwo.execute()");
    }
}
