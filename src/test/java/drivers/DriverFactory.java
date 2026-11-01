package drivers;

import java.util.Objects;

public class DriverFactory {

    public String getDriver(){
       String browser = null;

       if (Objects.equals(System.getProperty("deviceHost"), "browserstack")){
            browser= BrowserstackDriver.class.getName();
       }
       if (Objects.equals(System.getProperty("deviceHost"), "emulation")){
           browser= LocalDriver.class.getName();
       }
       if(browser==null)
       {
           browser= BrowserstackDriver.class.getName();
       }
       return browser;
    }
}
