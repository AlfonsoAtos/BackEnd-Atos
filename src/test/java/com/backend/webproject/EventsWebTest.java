package com.backend.webproject;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.WebElement;

public class EventsWebTest {
    public static RemoteWebDriver driver;

    @Test
    public void eventsAddTest() {
        try {
            driver.get("http://localhost:8081/admin-side/");
            driver.findElement(By.cssSelector(".admin-item:nth-child(2) path")).click();
            driver.findElement(By.linkText("New Promotion Event")).click();
            driver.findElement(By.name("eventsName")).click();
            driver.findElement(By.name("eventsName")).sendKeys("Halloween");
            driver.findElement(By.name("eventsDescription")).click();
            driver.findElement(By.name("eventsDescription")).sendKeys("Discount Halloween");
            driver.findElement(By.name("eventsStartDate")).click();
            driver.findElement(By.name("eventsStartDate")).sendKeys("2021-10-01");
            driver.findElement(By.name("eventsEndDate")).click();
            driver.findElement(By.name("eventsEndDate")).sendKeys("2021-10-31");
            driver.findElement(By.name("eventsStatus")).click();
            {
                WebElement dropdown = driver.findElement(By.name("eventsStatus"));
                dropdown.findElement(By.xpath("//option[. = 'Expired']")).click();
            }
            driver.findElement(By.name("eventsAdminId")).click();
            driver.findElement(By.name("eventsAdminId")).sendKeys("1");
            driver.findElement(By.cssSelector(".accept-button:nth-child(2)")).click();
            driver.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void eventsEditTest() {
        try {
            driver.get("http://localhost:8081/admin-side/");
            driver.findElement(By.cssSelector("tr:nth-child(1) a:nth-child(1) > svg")).click();
            driver.findElement(By.name("eventsName")).click();
            driver.findElement(By.name("eventsName")).sendKeys("Halloween 2022");
            driver.findElement(By.name("eventsDescription")).click();
            driver.findElement(By.name("eventsDescription")).sendKeys("Discount Halloween2022");
            driver.findElement(By.name("eventsStartDate")).click();
            driver.findElement(By.name("eventsStartDate")).sendKeys("2022-10-01");
            driver.findElement(By.name("eventsEndDate")).click();
            driver.findElement(By.name("eventsEndDate")).sendKeys("2022-10-31");
            driver.findElement(By.name("eventsStatus")).click();
            driver.findElement(By.cssSelector(".accept-button")).click();
            driver.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void eventsDeleteTest() {
        try {
            driver.get("http://localhost:8081/admin-side/");
            driver.findElement(By.cssSelector("tr:nth-child(1) a:nth-child(2) > svg")).click();
            driver.findElement(By.linkText("Yes")).click();
            driver.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
