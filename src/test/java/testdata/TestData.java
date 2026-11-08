package testdata;

import config.ConfigProvider;

public class TestData {
    public String articleName = ConfigProvider.testDataConfig.articleName();
    public static String emptySearchHistoryMessage = "No recently viewed articles";
}
