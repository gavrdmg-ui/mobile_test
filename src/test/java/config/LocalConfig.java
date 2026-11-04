package config;

import org.aeonbits.owner.Config;

@Config.Sources({
        "classpath:LocalConfig.properties"
})
public interface LocalConfig extends Config {

    String appPackage();

    String appActivity();

    String deviceName();

    String osVersion();
}

