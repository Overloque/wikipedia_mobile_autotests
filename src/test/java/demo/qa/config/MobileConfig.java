package demo.qa.config;

import org.aeonbits.owner.Config;

@Config.Sources({"classpath:mobile.properties"})
public interface MobileConfig extends Config {
    @Key("mobile.${env}.app")
    String getApp();

    @Key("mobile.${env}.device")
    String getDevice();

    @Key("mobile.${env}.os_version")
    String getVersion();
}
