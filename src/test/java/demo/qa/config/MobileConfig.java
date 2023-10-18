package demo.qa.config;

import org.aeonbits.owner.Config;

@Config.Sources({"classpath:mobile.properties"})
public interface MobileConfig extends Config {
    @Key("mobile.${env}.app")
    String getApp();

    @Key("mobile.${env}.device")
    @DefaultValue("Samsung Galaxy S22 Ultra")
    String getDevice();

    @Key("mobile.${env}.os_version")
    @DefaultValue("12.0")
    String getVersion();
}
