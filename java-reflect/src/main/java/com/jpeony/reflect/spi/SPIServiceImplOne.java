package com.jpeony.reflect.spi;

public class SPIServiceImplOne implements SPIService {

    @Override
    public void execute() {
        System.out.println("SPIServiceImplOne.execute()");
    }
}
