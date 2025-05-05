package PageClass;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import static BaseClass.DriverFactory.driver;

public class PageClass {
    static By carmoddd = By.xpath("(//div[@class='flex-row']//*[text()='Model'])/following::select[@class='w-100 forminput'][1]");
    static By fueloptndd = By.xpath("(//div[@class='flex-row']//*[text()='Fuel Type'])/following::select[@class='w-100 forminput'][1]");
    static By frstvarientdd = By.xpath("(//div[@class='flex-row']//*[text()='Variant'])/following::select[@class='w-100 forminput'][1]");
    static By exteriordd = By.xpath("((//div[@class='flex-row']//*[text()='Exterior Color'])/following::select[@class='w-100 forminput'][1])[1]");
    static By stateoption = By.xpath("//select[@id='state-01']//option");
    static By statedd=By.xpath("(//select[@class='w-100 forminput'])[6]");
    static By citydd = By.xpath("((//div[@class='flex-row']//*[text()='Dealer City'])/following::select[@class='w-100 forminput'][1])[1]");
    static By dealerdd = By.xpath("((//div[@class='flex-row']//*[text()='Dealer Name'])/following::select[@class='w-100 forminput'][1])[1]");
    static By proceedbtn = By.xpath("//button[@class='btn btn-blue']");
    static By bookingdetailsHeader = By.xpath("//h3[text()='Booking Summary']");
    static By dealership = By.xpath("//div//h4[@class='panel-title']");
    static By producttitle = By.xpath("//div[@class='tit ico-bullet']");
    static By addressdetail = By.xpath("//li[@class='ico-address']");
    static By phonenumber = By.xpath("//li[@class='ico-phone']");
    static By openinghourtitle = By.xpath("//li[@class='ico-hours']");
    static By salesopening = By.xpath("//*[@id=\"dealeraddresscol\"]/div/ul/li/ul/li[4]//span");
    static By monday = By.xpath("(//*[@id=\"dealeraddresscol\"]/div/ul/li/ul/li[4]//span)[1]");
    static By saturday = By.xpath("(//*[@id=\"dealeraddresscol\"]/div/ul/li/ul/li[4]//span)[2]");
    static By holiday = By.xpath("(//*[@id=\"dealeraddresscol\"]/div/ul/li/ul/li[4]//span)[3]");

    public static void launchurl(){
        driver.get("https://clicktobuy.hyundai.co.in/#/bookACar?modelCode=0Y");
    }
    public static void carmodel() throws InterruptedException {
        WebElement modeldropdown = driver.findElement(carmoddd);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(carmoddd));
        Select select = new Select(modeldropdown);
        select.selectByVisibleText("New Verna");
        Thread.sleep(1000);
    }
    public static void fueloption() throws InterruptedException {
        WebElement fuelopn = driver.findElement(fueloptndd);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(fueloptndd));
        Select select = new Select(fuelopn);
        select.selectByVisibleText("Petrol");
        Thread.sleep(1000);
    }
    public static void firstvarient() throws InterruptedException {
        WebElement firstvarient = driver.findElement(frstvarientdd);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(frstvarientdd));
        Select select = new Select(firstvarient);
        select.selectByIndex(1);
        Thread.sleep(1000);
    }
    public static void extdropdown() throws InterruptedException {
        WebElement extedropdown = driver.findElement(exteriordd);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(exteriordd));
        Select select = new Select(extedropdown);
        select.selectByIndex(1);
        Thread.sleep(1000);
    }
    public static void enhance() throws InterruptedException {
        WebElement statedrop = driver.findElement(statedd);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(statedd));
        Select statedropdown = new Select(statedrop);
        List<WebElement> stateoptions =statedropdown.getOptions();
        List<String> states = new ArrayList<>();
        for (WebElement state:stateoptions){
            states.add(state.getText());
        }
        for (int i=1;i<states.size();i++){
            Select stadd= new Select(driver.findElement(statedd));
            Thread.sleep(1000);
            stadd.selectByIndex(i);
            Thread.sleep(1000);
            // Cities Details
            WebElement citydrop = driver.findElement(citydd);
            wait.until(ExpectedConditions.visibilityOfElementLocated(citydd));
            Select citydropdown = new Select(citydrop);
            List<WebElement> cityoptions =citydropdown.getOptions();
            List<String> cities = new ArrayList<>();
            for (WebElement city:cityoptions){
                cities.add(city.getText());
            }
            for (int j=1;j<cities.size();j++) {
                Select citadd = new Select(driver.findElement(citydd));
                Thread.sleep(1000);
                citadd.selectByIndex(j);
                Thread.sleep(1000);
                //Dealer Options
                WebElement dealerdrop = driver.findElement(dealerdd);
                wait.until(ExpectedConditions.visibilityOfElementLocated(dealerdd));
                Select dealerdropdown = new Select(dealerdrop);
                List<WebElement> dealeroptions = dealerdropdown.getOptions();
                List<String> dealers = new ArrayList<>();
                for (WebElement dealer : dealeroptions) {
                    dealers.add(dealer.getText());
                }
                for (int k = 1; k < dealers.size(); k++) {
                    Select dealeadd = new Select(driver.findElement(dealerdd));
                    Thread.sleep(1000);
                    dealeadd.selectByIndex(k);
                    Thread.sleep(1000);
                    // Get Booking Details
                    WebElement detailsheader = driver.findElement(bookingdetailsHeader);
                    String BookingSummary = detailsheader.getText();
                    System.out.println("Booking Summary Header: " + BookingSummary);
                    WebElement dealship = driver.findElement(dealership);
                    String DelershipDetails = dealship.getText();
                    System.out.println("Dealer Hip Detail Header: " + DelershipDetails);
                    try {
                        WebElement Addres = driver.findElement(addressdetail);
                        String Addresso = Addres.getText();
                        System.out.println("Address Details: " +Addresso);
                    } catch (NoSuchElementException e) {
                        System.out.println("Error: Could not find the address details element.");
                    } catch (Exception e) {
                        System.out.println("An unexpected error occurred: " + e.getMessage());
                    }

                    try {
                        WebElement phone = driver.findElement(phonenumber);
                        String phonetext = phone.getText();
                        System.out.println("Address Details: " +phonetext);
                    } catch (NoSuchElementException e) {
                        System.out.println("Error: Could not find the phone number details element.");
                    } catch (Exception e) {
                        System.out.println("An unexpected error occurred: " + e.getMessage());
                    }
                    try {
                        WebElement Opentitle = driver.findElement(openinghourtitle);
                        String Opentitleheader = Opentitle.getText();
                        System.out.println("Address Details: " +Opentitleheader);
                    } catch (NoSuchElementException e) {
                        System.out.println("Error: Could not find the open title header details element.");
                    } catch (Exception e) {
                        System.out.println("An unexpected error occurred: " + e.getMessage());
                    }
                    try {
                        WebElement mondaytext = driver.findElement(monday);
                        String modaytime = mondaytext.getText();
                        System.out.println("Monday-Friday Opening Timings"+modaytime);

                    } catch (NoSuchElementException e) {
                        System.out.println("Error: Could not find the Details");
                    } catch (Exception e) {
                        System.out.println("An unexpected error occurred: " + e.getMessage());
                    }

                    try {
                        WebElement closedetails = driver.findElement(saturday);
                        String closedetailstext = closedetails.getText();
                        System.out.println("Closing Timings: "+closedetailstext);

                    } catch (NoSuchElementException e) {
                        System.out.println("Error: Could not find the Details");
                    } catch (Exception e) {
                        System.out.println("An unexpected error occurred: " + e.getMessage());
                    }

                    try {
                        WebElement holidaydet = driver.findElement(holiday);
                        String holdaytext = holidaydet.getText();
                        System.out.println("Holiday Details Timings: "+holdaytext);

                    } catch (NoSuchElementException e) {
                        System.out.println("Error: Could not find the Details");
                    } catch (Exception e) {
                        System.out.println("An unexpected error occurred: " + e.getMessage());
                    }
                }
            }
        }
        System.out.println(states.size());
    }
}
