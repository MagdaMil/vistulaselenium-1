package org.vistula.selenium.test.zadanie;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.assertj.core.api.Assertions;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.SendKeysAction;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ArenaTest {

    public WebDriver driver;

    @BeforeClass
    public static void setDriver() {
        WebDriverManager.chromedriver().setup();
    }


    @Test
    public void myFirstInteractionTest() {
        String nazwa_projektu = "NewM8";
        driver = new ChromeDriver();
        driver.get("http://demo.testarena.pl/zaloguj");
        WebElement email = driver.findElement(By.id("email"));
        WebElement password = driver.findElement(By.id("password"));
        WebElement login = driver.findElement(By.id("login"));


        email.sendKeys("administrator@testarena.pl");
        password.sendKeys("sumXQQ72$L");
        login.click();

        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.presenceOfElementLocated(By.id("footer")));

        Assertions.assertThat(driver.getTitle()).contains("Kokpit");

        WebElement header_admin = driver.findElement(By.className("header_admin"));
        header_admin.click();

        WebElement button_link = driver.findElement(By.className("button_link"));
        button_link.click();

        WebElement name = driver.findElement(By.id("name"));
        name.sendKeys(nazwa_projektu);

        WebElement prefix = driver.findElement(By.id("prefix"));
        prefix.sendKeys(nazwa_projektu);

        WebElement save = driver.findElement(By.id("save"));
        save.click();

        WebElement activeMenu = driver.findElement(By.className("activeMenu"));
        activeMenu.click();

        WebElement search = driver.findElement(By.id("search"));
        search.sendKeys(nazwa_projektu);

        WebElement j_searchButton = driver.findElement(By.id("j_searchButton"));
        j_searchButton.click();


        driver.quit();
    }

}
