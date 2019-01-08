package com.testautomationguru.pages;

import com.testautomationguru.jquery.controls.Slider;
import org.openqa.selenium.WebDriver;

public class JQuerySliderPage {

    private final WebDriver driver;
    private Slider slider;

    public JQuerySliderPage(final WebDriver driver){
        this.driver = driver;
    }

    public void goTo(){
       this.driver.get("http://jqueryui.com/slider/");
       this.driver.switchTo().frame(0);
       this.slider = new Slider(driver);
    }

    public Slider getSlider() {
        return slider;
    }
    
}
