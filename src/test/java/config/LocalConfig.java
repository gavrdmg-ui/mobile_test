package config;

import org.aeonbits.owner.Config;

@Config.Sources({
        "classpath:configurations/drivers/LocalConfig.properties"
})
public interface LocalConfig extends Config {

    String appPackage();

    String appActivity();

    String deviceName();

    String osVersion();
}

