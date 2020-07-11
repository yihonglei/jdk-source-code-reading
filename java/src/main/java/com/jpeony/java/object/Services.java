package com.jpeony.java.object;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author yihonglei
 */
public class Services {
    private Services() {

    }

    private static final Map<String, Provider> providers =
            new ConcurrentHashMap<String, Provider>();

    public static final String DEFAULT_PROVIDER_NAME = "<def>";

    // Provider registration API
    public static void registerDefaultProvider(Provider p) {
        registerProvider(DEFAULT_PROVIDER_NAME, p);
    }

    public static void registerProvider(String name, Provider p) {
        providers.put(name, p);
    }

    // Service access API
    public static Service newInstance() {
        return newInstance(DEFAULT_PROVIDER_NAME);
    }

    public static Service newInstance(String name) {
        Provider p = providers.get(name);
        if (null == p)
            throw new IllegalArgumentException(
                    "No Provider registered with name：" + name);

        return p.newService();
    }
}
