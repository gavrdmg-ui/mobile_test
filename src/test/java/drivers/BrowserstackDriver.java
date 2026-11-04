package drivers;

import com.codeborne.selenide.WebDriverProvider;
import config.ConfigProvider;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;


public class BrowserstackDriver implements WebDriverProvider {
    @Override
    public WebDriver createDriver(Capabilities capabilities) {
        MutableCapabilities caps = new MutableCapabilities();

        HashMap<String, Object> bstackOptions = new HashMap<>();
        bstackOptions.put("userName", ConfigProvider.browserStackConfig.userName());
        bstackOptions.put("accessKey", ConfigProvider.browserStackConfig.accessKey());
        bstackOptions.put("projectName", ConfigProvider.browserStackConfig.projectName());
        bstackOptions.put("buildName", ConfigProvider.browserStackConfig.buildName());
        bstackOptions.put("sessionName", ConfigProvider.browserStackConfig.sessionName());
        bstackOptions.put("deviceName", ConfigProvider.browserStackConfig.deviceName());
        bstackOptions.put("osVersion", ConfigProvider.browserStackConfig.osVersion());
        bstackOptions.put("appiumVersion", ConfigProvider.browserStackConfig.appiumVersion());

        UiAutomator2Options options = new UiAutomator2Options();
        options.merge(capabilities);
        options.setApp(ConfigProvider.browserStackConfig.app());
        options.setCapability("bstack:options", bstackOptions);
        caps.setCapability("appium:app", ConfigProvider.browserStackConfig.app());
        caps.setCapability("bstack:options", bstackOptions);

        try {
            return new AndroidDriver(
                    new URL(ConfigProvider.browserStackConfig.baseUrl()), options);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }
}