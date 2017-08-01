import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.*;
import org.junit.Test;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Main {
    private WebDriver driver;
    private JavascriptExecutor js;

    @Before
    public void SetUp()
    {
        System.setProperty("webdriver.gecko.driver", "/home/upfire/Downloads/selenium/geckodriver");
        driver = new FirefoxDriver();
        String URL ="http://timvroom.com/selenium/playground/";
        driver.get(URL);
        js = (JavascriptExecutor) driver;
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void GenerallTest(){
        driver.findElement(By.id("answer1")).sendKeys(driver.getTitle());
        driver.findElement(By.id("name")).sendKeys("Kilgore Trout");
        WebElement listBoxchoose = driver.findElement(By.id("occupation"));
        Select sel = new Select(listBoxchoose);
        sel.selectByValue("scifiauthor");
        List<WebElement> BlueBox = driver.findElements(By.className("bluebox"));
        driver.findElement(By.id("answer4")).sendKeys(Integer.toString(BlueBox.size()));
        driver.findElement(By.xpath("html/body/a[3]")).click();
        driver.findElement(By.id("answer6")).sendKeys(driver.findElement(By.id("redbox")).getAttribute("class"));
        js.executeScript("ran_this_js_function");
        driver.findElement(By.id("answer8")).sendKeys((String) js.executeScript("got_return_from_js_function"));
        driver.findElement(By.xpath(".//*[@id='testform']/input[2]")).click();
        driver.findElement(By.id("answer10")).sendKeys(driver.findElement(By.id("redbox")).getText());
        List<WebElement> ListOfBoxes = driver.findElements(By.xpath("html/body/span"));
        int size = ListOfBoxes.size();
        String pizdec = driver.findElement(By.xpath("html/body/span[" + (size - 1) + "]")).getText();
        String pizdec2 = "";
            if (pizdec.matches("green Box"))
            {
             pizdec2 = "green";
            }
            if (pizdec.matches("orange Box"))
            {
                pizdec2 = "orange";
            }
        driver.findElement(By.id("answer11")).sendKeys(pizdec2);
        driver.manage().window().setSize(new Dimension(850, 650));
        Boolean isPresent = driver.findElements(By.id("ishere")).size() > 0;
            if (isPresent == true)
            {
                driver.findElement(By.id("answer13")).sendKeys("yes");
            }
            else
                driver.findElement(By.id("answer13")).sendKeys("no");
        Boolean isPresent2 = driver.findElements(By.id("purplebox")).size() > 0;
            if (isPresent2 == true)
            {
                driver.findElement(By.id("answer14")).sendKeys("yes");
            }
            else
                driver.findElement(By.id("answer14")).sendKeys("no");
        driver.findElement(By.partialLinkText("click then wait")).click();
        WebDriverWait wait = new WebDriverWait(driver, 0, 5);
        WebElement clikedToWait = wait.until(ExpectedConditions.presenceOfElementLocated(By.partialLinkText("click after wait")));
        clikedToWait.click();
        Alert alert = driver.switchTo().alert();
        alert.accept();
        driver.findElement(By.id("submitbutton")).click();
        driver.findElement(By.id("checkresults")).click();
    }
    @Test
    public void TC1() {

    driver.findElement(By.id("answer1")).sendKeys(driver.getTitle());
}
    @Test
    public void TC2() {
    driver.findElement(By.id("name")).sendKeys("Kilgore Trout");
}
    @Test
    public void TC3() {
    WebElement listBoxchoose = driver.findElement(By.id("occupation"));
    Select sel = new Select(listBoxchoose);
    sel.selectByValue("scifiauthor");
}
    @Test
    public void TC4() {
    List<WebElement> BlueBox = driver.findElements(By.className("bluebox"));
    driver.findElement(By.id("answer4")).sendKeys(Integer.toString(BlueBox.size()));
}
    @Test
    public void TC5() {
    driver.findElement(By.xpath("html/body/a[3]")).click();
}
    @Test
    public void TC6() {
    driver.findElement(By.id("answer6")).sendKeys(driver.findElement(By.id("redbox")).getAttribute("class"));
}
    @Test
    public void TC7() {
    js.executeScript("ran_this_js_function");
}
    @Test
    public void TC8() {
    driver.findElement(By.id("answer8")).sendKeys((String) js.executeScript("got_return_from_js_function"));
}
    @Test
    public void TC9() {
        driver.findElement(By.xpath(".//*[@id='testform']/input[2]")).click();
    }
    @Test
    public void TC10() {
        driver.findElement(By.id("answer10")).sendKeys(driver.findElement(By.id("redbox")).getText());
    }
    @Test
    public void TC11() {
        List<WebElement> ListOfBoxes = driver.findElements(By.xpath("html/body/span"));
        int size = ListOfBoxes.size();
        String pizdec = driver.findElement(By.xpath("html/body/span[" + (size - 1) + "]")).getText();
        String pizdec2 = "";
        if (pizdec.matches("green Box")) {
            pizdec2 = "green";
        }
        if (pizdec.matches("orange Box")) {
            pizdec2 = "orange";
        }
        driver.findElement(By.id("answer11")).sendKeys(pizdec2);
    }
    @Test
    public void TC12() {

            driver.manage().window().setSize(new Dimension(850, 650));
        }
    @Test
    public void TC13() {

        Boolean isPresent = driver.findElements(By.id("ishere")).size() > 0;
        if (isPresent == true) {
            driver.findElement(By.id("answer13")).sendKeys("yes");
        } else driver.findElement(By.id("answer13")).sendKeys("no");
    }
    @Test
    public void TC14() {
        Boolean isPresent2 = driver.findElements(By.id("purplebox")).size() > 0;
        if (isPresent2 == true) {
            driver.findElement(By.id("answer14")).sendKeys("yes");
        } else driver.findElement(By.id("answer14")).sendKeys("no");
    }
    @Test
    public void TC15() {
        driver.findElement(By.partialLinkText("click then wait")).click();
        WebDriverWait wait = new WebDriverWait(driver, 0, 5);
        WebElement clikedToWait = wait.until(ExpectedConditions.presenceOfElementLocated(By.partialLinkText("click after wait")));
        clikedToWait.click();
    }
    @Test
    public void TC16() {
        Alert alert = driver.switchTo().alert();
        alert.accept();
    }
    @Test
    public void TC17() {
        driver.findElement(By.id("submitbutton")).click();
        driver.findElement(By.id("checkresults")).click();
    }
    @After
    public void EndOfTest()
    {
        driver.findElement(By.id("checkresults")).click();
        driver.close();
    }

}


