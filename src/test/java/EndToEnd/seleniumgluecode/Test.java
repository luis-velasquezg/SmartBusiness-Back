package EndToEnd.seleniumgluecode;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import static io.github.bonigarcia.wdm.DriverManagerType.CHROME;

import static org.junit.Assert.assertTrue;

public class Test {

    private WebDriver driver;

    @Given("^dado que el usaurio se encuentra en la pagina principal$")
    public void dado_que_el_usaurio_se_encuentra_en_la_pagina_principal() throws Throwable {
        //System.setProperty("webbdriver.chrome.driver", "D:\\Clases 2019-2\\Ingeniería de Procesos de Software\\ProyectoFinal\\SmartBusiness\\src\\test\\java\\EndToEnd\\resources\\chromedriver\\chromedriver.exe");
        WebDriverManager.chromedriver().setup();



        // DesiredCapabilities.chrome();
        driver = new ChromeDriver();
//        driver.get("http://192.168.137.2:4200/#/home");
        driver.get("http://localhost:4200/#/home");
        driver.manage().window().maximize();
    }

    @When("^hace clic sobre promociones$")
    public void hace_clic_sobre_promociones() throws Throwable {
        WebElement linkPromociones = driver.findElement(By.xpath(("/html/body/app-root/app-header/header/div/nav/ul/li[2]/a")));
        linkPromociones.click();
    }

    @When("^hace clic sobre promociones sugeridas$")
    public void hace_clic_sobre_promociones_sugeridas() throws Throwable {
        WebElement linkPromocionesSugeridas = driver.findElement(By.xpath(("/html/body/app-root/app-header/header/div/nav/ul/li[2]/nav/ul/li[1]/a")));
        linkPromocionesSugeridas.click();
    }

    @Then("^se debe redirigir a la patalla promociones sugeridas$")
    public void se_debe_redirigir_a_la_patalla_promociones_sugeridas() throws Throwable {
        WebElement promocionesSugeridas = driver.findElement(By.id("titulo-promociones-sugeridas"));
        assertTrue(promocionesSugeridas.isDisplayed());
    }


}
