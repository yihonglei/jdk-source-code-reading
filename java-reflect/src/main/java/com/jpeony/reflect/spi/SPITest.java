package com.jpeony.reflect.spi;

import sun.misc.Service;

import java.util.Iterator;
import java.util.ServiceLoader;

/**
 * @author yihonglei
 */
public class SPITest {
    public static void main(String[] args) {
        Iterator<SPIService> providers = Service.providers(SPIService.class);
        ServiceLoader<SPIService> load = ServiceLoader.load(SPIService.class);
        // 方式1
        while (providers.hasNext()) {
            SPIService ser = providers.next();
            ser.execute();
        }
        System.out.println("--------------------------------");
        // 方式2
        Iterator<SPIService> iterator = load.iterator();
        while (iterator.hasNext()) {
            SPIService ser = iterator.next();
            ser.execute();
        }
    }
}
