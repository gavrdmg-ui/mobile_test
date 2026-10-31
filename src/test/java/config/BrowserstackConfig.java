package config;

import org.aeonbits.owner.Config;

@Config.Sources({
        "classpath:BrowserstackConfig.properties"
})
public interface BrowserstackConfig extends Config {

    String baseUrl();

    String userName();

    String accessKey();

    String projectName();

    String buildName();

    String sessionName();

    String deviceName();

    String osVersion();

    String appiumVersion();

    String platformName();

    String app();


}
