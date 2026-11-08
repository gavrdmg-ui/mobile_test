package config;

import org.aeonbits.owner.Config;

@Config.Sources({
        "classpath:configurations/testdata/TestData.properties"
})
public interface TestDataConfig extends Config {

    @Key("articleName")
    @DefaultValue("")
    String articleName();


}
