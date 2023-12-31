package infra;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.FileReader;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class AppiumDriverProvider {
    private static AndroidDriver<MobileElement> driver;
    private static String appiumServerUrl;
    private static final String CONFIG_FILE_PATH = "C:\\Users\\lets_\\IdeaProjects\\appimium-summary-exercise\\src\\test\\java\\utils\\config.json";


    public AndroidDriver<MobileElement> getDriver() {
        if (driver == null) {
            initializeDriver();
        }
        return driver;
    }

    private void initializeDriver() {
        DesiredCapabilities caps = loadConfig();

        try {
            driver = new AndroidDriver<>(new URL(appiumServerUrl), caps);
        } catch (MalformedURLException e) {
            handleException("Malformed URL", e);
        }
    }

    private DesiredCapabilities loadConfig() {
        DesiredCapabilities caps = new DesiredCapabilities();

        try {
            FileReader reader = new FileReader(CONFIG_FILE_PATH);
            JSONParser jsonParser = new JSONParser();
            JSONObject jsonObject = (JSONObject) jsonParser.parse(reader);

            for (Object key : jsonObject.keySet()) {
                String keyStr = (String) key;
                String value = (String) jsonObject.get(keyStr);

                if (!keyStr.equals("appiumServerUrl")) {
                    caps.setCapability(keyStr, value);
                } else {
                    appiumServerUrl = value;
                }
            }

        } catch (IOException | ParseException e) {
            handleException("Error loading configuration", e);
        }

        return caps;
    }

    private void handleException(String message, Exception e) {
        System.err.println(message);
        e.printStackTrace();
    }

    public void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}

