package Factories;

import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

import java.io.File;

public class ServerFactory {
    public static AppiumDriverLocalService appiumDriverLocalService;

    public static void startServer() {
        appiumDriverLocalService = new AppiumServiceBuilder()
                .withAppiumJS(new File("C:\\Users\\Mohamed\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js"))
                .withIPAddress("127.0.0.1")
                .usingPort(4723)
                .build();
        appiumDriverLocalService.start();
    }

    public static void stopServer() {
        appiumDriverLocalService.stop();
    }
}
