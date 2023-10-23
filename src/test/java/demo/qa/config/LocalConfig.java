package demo.qa.config;

import org.aeonbits.owner.Config;

@Config.Sources({
        "classpath:local.properties"
})
public interface LocalConfig extends Config {
    @Key("platform_version")
    String getPlatformVersion();

    @Key("device_name")
    String getDeviceName();
}
