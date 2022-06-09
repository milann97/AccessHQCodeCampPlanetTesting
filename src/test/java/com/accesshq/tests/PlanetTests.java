package com.accesshq.tests;

import com.accesshq.models.PlanetModels;
import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.*;

public class PlanetTests {
    WebDriver driver = new ChromeDriver();

    @BeforeEach
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://d18u5zoaatmpxx.cloudfront.net/");
    }
    @Test
    public void clickEarthTest() throws Exception {
        //Arrange
        var planet = new PlanetModels(driver);
        planet.planetTab();
        String input = "Earth";

        //Act
        planet.clickExplore(input);

        //Assert
        planet.checkExploration(input);
    }
}
