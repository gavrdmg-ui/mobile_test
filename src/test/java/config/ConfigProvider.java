package config;

import org.aeonbits.owner.ConfigFactory;

public class ConfigProvider {

    public static final BrowserstackConfig config =
            ConfigFactory.create(BrowserstackConfig.class, System.getProperties());
}
