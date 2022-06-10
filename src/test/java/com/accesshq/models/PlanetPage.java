package com.accesshq.models;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.function.Predicate;

public class PlanetPage {
    WebDriver driver;

    public PlanetPage(WebDriver driver) { this.driver = driver; }

    public ArrayList<PlanetCard> getAllPlanets() {
        var allPlanets = new ArrayList<PlanetCard>();
        for(WebElement p : driver.findElements(By.className("planet"))) {
            allPlanets.add(new PlanetCard(p));
        }
        return allPlanets;
    }

    public PlanetCard getPlanet(Predicate<PlanetCard> logic) {
        for(PlanetCard p : getAllPlanets()) {
            if(logic.test(p)) {
                return p;
            }
        }
        throw new NotFoundException("Planet not found");
    }

    public Long checkFurthest() {
        Long distance = 0L;
        for(var p : getAllPlanets()) {
            if(p.getDistance() > distance ) {
                distance = p.getDistance();
            }
        }
        return distance;
    }

    public void checkExploration(String planet) {
        WebElement popup = driver.findElement(By.className("snackbar"));
        new WebDriverWait(driver, Duration.ofSeconds(15)).until(ExpectedConditions.visibilityOf(popup));
        Assertions.assertEquals("Exploring " + planet, popup.getText());
    }
}
