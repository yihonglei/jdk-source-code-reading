package com.jpeony.reflect.spi;

import sun.misc.Service;

import java.util.Iterator;
import java.util.ServiceLoader;

public class SPITest {
    public static void main(String[] args) {
        // 方式1
        Iterator<SPIService> providers = Service.providers(SPIService.class);
        while (providers.hasNext()) {
            SPIService ser = providers.next();
            ser.execute();
        }
        System.out.println("--------------------------------");
        // 方式2
        ServiceLoader<SPIService> load = ServiceLoader.load(SPIService.class);
        Iterator<SPIService> iterator = load.iterator();
        while (iterator.hasNext()) {
            SPIService ser = iterator.next();
            ser.execute();
        }
    }
}
