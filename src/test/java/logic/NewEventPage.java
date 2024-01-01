package logic;

import infra.BasePage;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class NewEventPage extends BasePage {
    private MobileElement eventName;
    private MobileElement saveButton;
    private final String EVENT_NAME="com.claudivan.taskagenda:id/etTitulo";
    private final String SAVE_BUTTON="com.claudivan.taskagenda:id/item_salvar";

    public NewEventPage(AndroidDriver<MobileElement> driver) {
        super(driver);
        this.eventName=this.driver.findElementById(EVENT_NAME);
        this.saveButton=this.driver.findElementById(SAVE_BUTTON);
    }
    public void setEventName(String name){
        this.eventName.sendKeys(name);
    }
    public void saveEvent(){
        this.saveButton.click();
    }
}
