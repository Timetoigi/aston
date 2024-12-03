package com.example.tests;

import com.example.pageobjects.OnlineRechargePage;
import io.github.bonigarcia.seljup.SeleniumWatch;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;

public class OnlineRechargeTest {
    private WebDriver driver;
    private OnlineRechargePage onlineRechargePage;

    @Before
    public void setUp() {
        // Инициализация драйвера с помощью WebDriverManager
        io.github.bonigarcia.wdm.WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://mts.by");

        onlineRechargePage = new OnlineRechargePage(driver);
    }

    @Test
    public void testOnlineRechargeBlock() {
        // Проверка названия блока
        assertEquals("Онлайн пополнение без комиссии", onlineRechargePage.getRechargeBlockTitle());

        // Проверка наличия логотипов платёжных систем
        assertTrue(onlineRechargePage.isPaymentSystemVisible("visa"));
        assertTrue(onlineRechargePage.isPaymentSystemVisible("mastercard"));
        assertTrue(onlineRechargePage.isPaymentSystemVisible("belcard"));

        // Проверка работы ссылки «Подробнее о сервисе»
        onlineRechargePage.clickMoreInfo();
        assertEquals("О сервисе | МТС", driver.getTitle());
        driver.navigate().back(); // Возвращаемся на главную страницу

        // Заполнение полей и проверка работы кнопки «Продолжить»
        onlineRechargePage.fillRechargeForm("Услуги связи", "297777777");
    }

    @After
    public void tearDown() {
        // Закрыть браузер
        driver.quit();
    }
}