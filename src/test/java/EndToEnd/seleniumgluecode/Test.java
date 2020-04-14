package EndToEnd.seleniumgluecode;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.junit.Assert.assertTrue;

public class Test {

    private ChromeDriver driver;

    @Given("^dado que el usaurio se encuentra en la pagina principal$")
    public void dado_que_el_usaurio_se_encuentra_en_la_pagina_principal() throws Throwable {
        System.setProperty("webbdriver.chrome.driver", "./src/test/java/EntToEnd/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("http://localhost:4200/#/home");
        driver.manage().window().maximize();
    }

    @When("^hace clic sobre promociones$")
    public void hace_clic_sobre_promociones() throws Throwable {
        WebElement linkPromociones = driver.findElementByXPath("/html/body/app-root/app-header/header/div/nav/ul/li[2]/a");
        linkPromociones.click();
    }

    @Then("^se debe redirigir a la patalla promociones$")
    public void se_debe_redirigir_a_la_patalla_promociones() throws Throwable {
         WebElement promociones = driver.findElement(By.id("TituloPromociones"));
         assertTrue(promociones.isDisplayed());
    }




}
