package Railway;

import Constant.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BookTicketPage {
    // Locators
    private By departDate = By.xpath("//select[@name='Date']");
    private By departStation = By.name("DepartStation");
    private By arriveStation = By.name("ArriveStation");
    private By seatType = By.name("SeatType");
    private By ticketAmount = By.name("TicketAmount");
    private By bookTicketButton = By.xpath("//input[@value='Book ticket']");
    private By successMessage = By.xpath("//h1[@align='center' and contains(text(), 'Ticket Booked Successfully')]");
    private By departStationValue = By.xpath("//table//tr[2]/td[1]");
    private By arriveStationValue = By.xpath("//table//tr[2]/td[2]");
    private By seatTypeValue = By.xpath("//table//tr[2]/td[3]");
    private By departDateValue = By.xpath("//table//tr[2]/td[4]");
    private By ticketAmountValue = By.xpath("//table//tr[2]/td[7]");

    // Scroll to bottom to ensure form is in view
    private void scrollToBottom() {
        JavascriptExecutor js = (JavascriptExecutor) Constant.WEBDRIVER;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
    }

    // Select depart date
    public void selectDepartDate(String date) {
        WebElement element = Constant.WEBDRIVER.findElement(departDate);
        Select select = new Select(element);
        select.selectByVisibleText(date);
    }

    // Select depart station
    public void selectDepartStation(String station) {
        WebElement element = Constant.WEBDRIVER.findElement(departStation);
        Select select = new Select(element);
        select.selectByVisibleText(station);
    }

    // Select arrive station
    public void selectArriveStation(String station) {
        WebElement element = Constant.WEBDRIVER.findElement(arriveStation);
        Select select = new Select(element);
        select.selectByVisibleText(station);
    }

    // Select seat type
    public void selectSeatType(String type) {
        WebElement element = Constant.WEBDRIVER.findElement(seatType);
        Select select = new Select(element);
        select.selectByVisibleText(type);
    }

    // Select ticket amount
    public void selectTicketAmount(String amount) {
        WebElement element = Constant.WEBDRIVER.findElement(ticketAmount);
        Select select = new Select(element);
        select.selectByVisibleText(amount);
    }

    // Click book ticket button
    public void clickBookTicketButton() {
        scrollToBottom();
        Constant.WEBDRIVER.findElement(bookTicketButton).click();
    }

    // Perform book ticket action
    public void bookTicket(String date, String departStation, String arriveStation, String seatType, String ticketAmount) {
        selectDepartDate(date);
        selectDepartStation(departStation);
        selectArriveStation(arriveStation);
        selectSeatType(seatType);
        selectTicketAmount(ticketAmount);
        clickBookTicketButton();
    }

    // Get success message
    public String getSuccessMessage() {
        WebDriverWait wait = new WebDriverWait(Constant.WEBDRIVER, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(successMessage)).getText().trim();
    }

    // Get ticket information
    public String getDepartStationValue() {
        WebDriverWait wait = new WebDriverWait(Constant.WEBDRIVER, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(departStationValue)).getText().trim();
    }

    public String getArriveStationValue() {
        WebDriverWait wait = new WebDriverWait(Constant.WEBDRIVER, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(arriveStationValue)).getText().trim();
    }

    public String getSeatTypeValue() {
        WebDriverWait wait = new WebDriverWait(Constant.WEBDRIVER, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(seatTypeValue)).getText().trim();
    }

    public String getDepartDateValue() {
        WebDriverWait wait = new WebDriverWait(Constant.WEBDRIVER, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(departDateValue)).getText().trim();
    }

    public String getTicketAmountValue() {
        WebDriverWait wait = new WebDriverWait(Constant.WEBDRIVER, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(ticketAmountValue)).getText().trim();
    }
}