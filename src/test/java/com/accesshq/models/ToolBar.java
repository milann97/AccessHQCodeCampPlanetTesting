package com.accesshq.models;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ToolBar {
    WebDriver driver;

    public ToolBar(WebDriver driver) { this.driver = driver; }

    public void selectHome() {
        driver.findElement(By.cssSelector("[aria-label=home]")).click();
    }
    public void selectForms() {
        driver.findElement(By.cssSelector("[aria-label=forms]")).click();
    }
    public void selectPlanets() {
        driver.findElement(By.cssSelector("[aria-label=planets]")).click();
    }
}
