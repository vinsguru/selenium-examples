package com.testautomationguru.jquery.controls;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Slider {

    private final JavascriptExecutor js;
    private final Actions action;

    @FindBy(css = "span.ui-slider-handle")
    private WebElement sliderHandle;

    public Slider(final WebDriver driver){
        PageFactory.initElements(driver, this);
        this.js = (JavascriptExecutor) driver;
        this.action = new Actions(driver);
    }

    public void moveBy(int p) {
        action.click(sliderHandle).build().perform();
        Keys key = p > 0 ? Keys.ARROW_RIGHT : Keys.ARROW_LEFT;
        p = Math.abs(p);
        for (int i = 0; i < p; i++) {
            action.sendKeys(key).build().perform();
        }
    }

    public String getValue() {
        return (String) js.executeScript("return arguments[0].style.left", sliderHandle);
    }

}
