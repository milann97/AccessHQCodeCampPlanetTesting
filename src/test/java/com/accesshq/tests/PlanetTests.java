package com.accesshq.tests;

import com.accesshq.models.*;
import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import javax.tools.Tool;

public class PlanetTests {
    WebDriver driver;

    @BeforeEach
    public void startup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://d18u5zoaatmpxx.cloudfront.net/");

    }

    @AfterEach
    public void close() throws InterruptedException {
        Thread.sleep(1500);
        driver.quit();
    }

    @Test
    public void clickEarthTest() {
        //Arrange
        new ToolBar(driver).selectPlanets();

        //Act
        new PlanetPage(driver).getPlanet(p -> p.getName().
                equalsIgnoreCase("Earth")).explorePlanet();

        //Assert
        new PlanetPage(driver).checkExploration("Earth");
    }

    @Test
    public void clickVenusTest() {
        //Arrange
        new ToolBar(driver).selectPlanets();

        //Act
        new PlanetPage(driver).getPlanet(p -> p.getDistance()
                == 108200000L).explorePlanet();

        //Assert
        new PlanetPage(driver).checkExploration("Venus");
    }

    @Test
    public void checkFurthestPlanetTest() {
        //Arrange
        new ToolBar(driver).selectPlanets();

        //Act
        new PlanetPage(driver).getPlanet(p -> p.getDistance()
                == new PlanetPage(driver).checkFurthest()).explorePlanet();

        //Assert
        new PlanetPage(driver).checkExploration("Neptune");
    }
}
