package logic;

import infra.BasePage;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class Events extends BasePage {
    private MobileElement event;
    private MobileElement delete;
    private MobileElement yes;
    private MobileElement no;

    private final String DELETE="com.claudivan.taskagenda:id/item_excluir";
    private final String YES="android:id/button1";
    private final String NO="android:id/button2";


    public Events(AndroidDriver<MobileElement> driver) {
        super(driver);
        this.delete=this.driver.findElementByXPath(DELETE);
    }
    public void clickOnEvent(String event){
        this.event=this.driver.findElementById("//android.widget.RelativeLayout[android.widget.TextView[@text='"+event+"']]");
        this.event.click();
    }
    public void clickOnDelete(){
        this.delete.click();
        this.yes=this.driver.findElementByXPath(YES);
        this.yes.click();
    }


}
