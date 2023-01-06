package tests;


import org.example.config.ConfigProperties;
import org.testng.annotations.BeforeTest;

public class BaseTest {
    protected ConfigProperties configProperties;

    @BeforeTest
    public void getData() {
        configProperties = new ConfigProperties().readConfigProperties();
    }
}
