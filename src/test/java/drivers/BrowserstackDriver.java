package drivers;

import com.codeborne.selenide.WebDriverProvider;
import config.ConfigProvider;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;


public class BrowserstackDriver implements WebDriverProvider {
    @Override
    public WebDriver createDriver(Capabilities capabilities) {
        MutableCapabilities caps = new MutableCapabilities();

        HashMap<String, Object> bstackOptions = new HashMap<>();
        bstackOptions.put("userName", ConfigProvider.config.userName());
        bstackOptions.put("accessKey", ConfigProvider.config.accessKey());
        bstackOptions.put("projectName", ConfigProvider.config.projectName());
        bstackOptions.put("buildName", ConfigProvider.config.buildName());
        bstackOptions.put("sessionName", ConfigProvider.config.sessionName());
        bstackOptions.put("deviceName", ConfigProvider.config.deviceName());
        bstackOptions.put("osVersion", ConfigProvider.config.osVersion());
        bstackOptions.put("appiumVersion", ConfigProvider.config.appiumVersion());

        //caps.setCapability("platformName", ConfigProvider.config.platformName());
        caps.setCapability("appium:app", ConfigProvider.config.app());
        caps.setCapability("bstack:options", bstackOptions);

        try {
            return new RemoteWebDriver(
                    new URL(ConfigProvider.config.baseUrl()), caps);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }
}