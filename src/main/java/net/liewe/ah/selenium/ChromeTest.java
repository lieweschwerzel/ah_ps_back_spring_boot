package net.liewe.ah.selenium;

import net.liewe.ah.model.Product;
import net.liewe.ah.repository.ProductRepository;
import org.hibernate.type.StringNVarcharType;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

class ChromeTest {
    public static void main(String[] args) {
        //setting the driver executable
        System.setProperty("webdriver.chrome.driver", ".\\drivers\\chromedriver.exe");

        //Initiating your chromedriver
        WebDriver driver=new ChromeDriver();

        //Applied wait time
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        //maximize window

        //open browser with desried URL
        driver.get("https://www.ah.nl/producten");
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(15));

        //wait for cookies popup and accept
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"accept-cookies\"]")));
//        driver.findElement(By.xpath("//*[@id=\"accept-cookies\"]")).click();

        //get Categories
        List<WebElement> catElementList = driver.findElements(By.cssSelector("a[class^='taxonomy-card_title']"));
        List<Category> categoryList = new ArrayList<>();
        for (WebElement element : catElementList){
            Category cat = new Category (element.getText(), element.getAttribute("href"));
            categoryList.add(cat);
        }
        System.out.println(categoryList);

        //get Prods from Category
        String url = categoryList.get(1).url;
        driver.get(url); //"?page=26

        String cssSel = "span[class^='button-or-anchor_label']";
        //check for more pages, stop when no more "next page" found
              //wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
        while (true){
            try{
                WebElement nextButton = driver.findElement(By.cssSelector(cssSel));
                System.out.println("TEXT"+nextButton.getText());
                if (nextButton.getText().equals("Meer resultaten") && nextButton.isDisplayed()) {
                    driver.findElement(By.cssSelector(cssSel)).click();
                    //wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(cssSel)));
                } else {
                    break;
                }
            }catch (org.openqa.selenium.NoSuchElementException e){
                break;
            }
        }

        List<WebElement> productsTitleUrl = driver.findElements(By.cssSelector("a[class='link_root__65rmW']"));

        List<Product> tmplist = new ArrayList<>();
        for (WebElement element : productsTitleUrl){
            String productName = element.getAttribute("title");
            String productUrl = element.getAttribute("href");
            String priceTmp = element.findElements(By.tagName("div")).get(3).getText();
            Double price;
            if (priceTmp.length() != 0){
                price = Double.valueOf(priceTmp);
            }else {
                price = null;
            }
            
            String unit = element.findElements(By.tagName("span")).get(3).getText();
            String imgUrl = element.findElement(By.tagName("img")).getAttribute("src");
            String discount = null;
            try{
                String dis1 = element.findElements(By.tagName("span")).get(4).getText();
                if (dis1.length()!=0){
                    discount = dis1;
                    String dis2 = element.findElements(By.tagName("span")).get(5).getText();
                    if (dis2.length() != 0){
                        try{
                            discount += " "+ dis2;
                        }catch (IndexOutOfBoundsException ignored){}
                    }
                }
            }catch (IndexOutOfBoundsException ignored){}
            tmplist.add(new Product(productName, price, unit, discount, imgUrl, productUrl));
        }
        for (Product el: tmplist){
            System.out.println( el );
        }
        //closing the browser
        driver.close();

    }

    private static boolean existsElement(String css, WebDriver driver) {
        try {
            driver.findElement(By.cssSelector(css));
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