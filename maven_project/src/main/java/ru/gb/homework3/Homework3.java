package ru.gb.homework3;

import io.github.bonigarcia.wdm.WebDriverManager;
import net.bytebuddy.asm.Advice;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Homework3 {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();
        driver.get("https://test.gp.mos.ru/");

        driver.findElement(By.xpath("//div[contains(text(), 'Войти')]")).click();
        //Thread.sleep(5000);
        driver.findElement(By.xpath("//input[@placeholder = 'Логин']")).click();
        driver.findElement(By.xpath("//input[@placeholder = 'Логин']")).sendKeys("support_saveleva");
        driver.findElement(By.xpath("//input[@placeholder = 'Пароль']")).click();
        driver.findElement(By.xpath("//input[@placeholder = 'Пароль']")).sendKeys("Milyaginskaya330");
        driver.findElement(By.xpath("//input[@placeholder = 'Пароль']")).sendKeys(Keys.chord(Keys.ENTER));

        WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(5));
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@href='/gu']")));
        driver.findElement(By.xpath("//a[@href='/gu']")).click();

        driver.findElement(By.xpath("//a[contains(text(),'Реестр')]")).click();
        driver.findElement(By.xpath("//span[contains(text(),'Применить')]")).click();
        Thread.sleep(2000); //не применила WebDriverWait, так как элемент есть на странице, но он не активен до нажатия "Применить"
        driver.findElement(By.xpath("//span[contains(text(), 'Показать')]")).click();

        Thread.sleep(5000);
        driver.quit();
    }
}
