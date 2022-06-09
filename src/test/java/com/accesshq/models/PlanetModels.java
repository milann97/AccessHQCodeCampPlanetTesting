package com.accesshq.models;

import com.accesshq.tests.PlanetTests;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PlanetModels {
    WebDriver driver;

    public PlanetModels(WebDriver driver) {
        this.driver = driver;
    }

    public void planetTab() {
        driver.findElement(By.cssSelector("[aria-label=planets]")).click();
    }

    public void clickExplore(String planet) throws Exception {
        for(var p : driver.findElements(By.className("planet"))) {
            if(p.findElement(By.className("planet")).getText().equalsIgnoreCase(planet)) {
                driver.findElement(By.cssSelector("[type=button]")).click();
            }
        }
        throw new Exception("Planet not found");
    }

    public void checkExploration(String planet) {
    }
}
