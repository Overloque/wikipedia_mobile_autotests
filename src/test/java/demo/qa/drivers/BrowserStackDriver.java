package demo.qa.drivers;

import com.codeborne.selenide.WebDriverProvider;
import demo.qa.config.BrowserStackConfig;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import javax.annotation.Nonnull;
import java.net.MalformedURLException;
import java.net.URL;

public class BrowserStackDriver implements WebDriverProvider {
    protected static final BrowserStackConfig browserstackConfig = ConfigFactory.create(BrowserStackConfig.class, System.getProperties());

    @Nonnull
    @Override
    public WebDriver createDriver(@Nonnull Capabilities capabilities) {
        MutableCapabilities caps = new MutableCapabilities();

        caps.setCapability("browserstack.user", browserstackConfig.getUsername());
        caps.setCapability("browserstack.key", browserstackConfig.getPassword());

        caps.setCapability("app", browserstackConfig.getApp());

        caps.setCapability("device", browserstackConfig.getDevice());
        caps.setCapability("os_version", browserstackConfig.getVersion());

        caps.setCapability("project", browserstackConfig.getProject());
        caps.setCapability("build", browserstackConfig.getBuild());
        caps.setCapability("name", browserstackConfig.getName());

        try {
            return new RemoteWebDriver(
                    new URL(browserstackConfig.getRemoteUrl()), caps);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }
}
