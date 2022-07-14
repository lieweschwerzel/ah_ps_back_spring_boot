package net.liewe.ah.selenium;

import jdk.jfr.Category;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.swing.*;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

class ChromeTest {
    public static void main(String[] args) {
        // TODO Auto-generated method stub

        //setting the driver executable
        System.setProperty("webdriver.chrome.driver", ".\\drivers\\chromedriver.exe");

        //Initiating your chromedriver
        WebDriver driver=new ChromeDriver();

        //Applied wait time
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(100));
        //maximize window

        //open browser with desried URL
        driver.get("https://www.ah.nl/producten");
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10, 1));

        //wait for cookies popup and accept
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"accept-cookies\"]")));
        driver.findElement(By.xpath("//*[@id=\"accept-cookies\"]")).click();

        //get Categories
        List<WebElement> catElementList = driver.findElements(By.cssSelector("a[class='taxonomy-card_titleLink__7TTrF']"));
        List<Category> categoryList = new ArrayList<>();
        for (WebElement element : catElementList){
            Category cat = new Category (element.getText(), element.getAttribute("href"));
            categoryList.add(cat);
        }

        //get Prods from Category
        String url = categoryList.get(0).url;
        driver.get(url);
        //check for more pages, stop when no more "next page" found
        String xpath = "//span[@class='button-or-anchor_label__2eIdb']";
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
        WebElement nextButton = driver.findElement(By.xpath(xpath));
        while (true){
            //nextButton = driver.findElement(By.xpath(xpath));
            if (nextButton.getText() == "Meer resultaten" && nextButton.isDisplayed()) {
                driver.findElement(By.xpath(xpath)).click();
            } else {
                break;
            }
        }
        //collect data into Product model findElement(By.xpath("//*[contains(@id,'lst-ib')]"));
        List<WebElement> productsElementsList = driver.findElements(By.xpath("//*[contains(@class,'link_root')]"));

        for (WebElement element : productsElementsList){
            System.out.println(driver.findElement(By.xpath("div[dataclass-hook='price-amount']")));
        }




        //button[@id='accept-cookies']
        System.out.println("TITLE IS: "+ categoryList.toString());
        //driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));


        //closing the browser
        driver.close();

    }

    private static boolean existsElement(String xpath, WebDriver driver) {
        try {
            driver.findElement(By.xpath(xpath));
        } catch (NoSuchElementException e) {
            return false;
        }
        return true;
    }

    public static class Category{
        String name;
        String url;

        public Category(String name, String url) {
            this.name = name;
            this.url = url;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        @Override
        public String toString() {
            return "Category{" +
                    "name='" + name + '\'' +
                    ", url='" + url + '\'' +
                    '}';
        }
    }
}