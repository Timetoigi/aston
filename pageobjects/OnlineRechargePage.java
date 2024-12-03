package com.example.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class OnlineRechargePage {
    private WebDriver driver;

    // Конструктор
    public OnlineRechargePage(WebDriver driver) {
        this.driver = driver;
    }

    // Элементы страницы
    private By rechargeBlockTitle = By.xpath("//h2[contains(text(), 'Онлайн пополнение без комиссии')]");
    private By paymentSystemVisa = By.cssSelector("img[src*= 'visa']");
    private By paymentSystemMasterCard = By.cssSelector("img[src*= 'mastercard']");
    private By paymentSystemBelCard = By.cssSelector("img[src*= 'belcard']");
    private By moreInfoLink = By.linkText("Подробнее о сервисе");
    private By serviceTypeSelect = By.id("serviceType");
    private By phoneNumberInput = By.id("297777777");
    private By continueButton = By.id("continueButton");

    // Методы для взаимодействия с элементами
    public String getRechargeBlockTitle() {
        return driver.findElement(rechargeBlockTitle).getText();
    }

    public boolean isPaymentSystemVisible(String system) {
        return driver.findElement(By.cssSelector("img[src*='" + system + "']")).isDisplayed();
    }

    public void clickMoreInfo() {
        driver.findElement(moreInfoLink).click();
    }

    public void fillRechargeForm(String serviceType, String phoneNumber) {
        driver.findElement(serviceTypeSelect).sendKeys(serviceType);
        driver.findElement(phoneNumberInput).sendKeys(phoneNumber);
        driver.findElement(continueButton).click();
    }
}