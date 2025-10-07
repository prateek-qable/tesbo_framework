package io.unity.performaction.autoweb;


import com.google.common.net.MediaType;
import io.appium.java_client.AppiumBy;
import io.unity.framework.exception.locator_validation_exception;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.NetworkInterceptor;
import org.openqa.selenium.devtools.v85.log.Log;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.WheelInput;
import org.openqa.selenium.remote.http.HttpResponse;
import org.openqa.selenium.remote.http.Route;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.Reporter;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.function.Consumer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.openqa.selenium.remote.http.Contents.utf8String;


public class Element {

    WebDriver driver;
    testng_logs logs = new testng_logs();
    Actions a = null;


    public Element(WebDriver dri) {
        this.driver = dri;
    }


    private WebElement get_element_from_value(String locator_type, String locator_value) {
        WebElement element = null;
        switch (locator_type) {
            case "xpath":
                element = driver.findElement(By.xpath(locator_value));
                break;
            case "id":
                element = driver.findElement(By.id(locator_value));
                break;
            case "css_selector":
                element = driver.findElement(By.cssSelector(locator_value));
                break;
            case "class_name":
                element = driver.findElement(By.className(locator_value));
                break;
            case "name":
                element = driver.findElement(By.name(locator_value));
                break;
            case "link_text":
                element = driver.findElement(By.linkText(locator_value));
                break;
            case "partial_link_text":
                element = driver.findElement(By.partialLinkText(locator_value));
                break;
            case "tag":
                element = driver.findElement(By.tagName(locator_value));
                break;
            case "accessibility-id":
                element = driver.findElement(new AppiumBy.ByAccessibilityId(locator_value));
                break;
            default:
                logs.test_step("Incorrect Locator Type");
        }
        return element;
    }


    public WebElement find(String locator_value) {

        WebElement element = null;
        locator_reader reader = new locator_reader();

        Map<String, String> locator_details = reader.get_locator_value(locator_value);
        element = get_element_from_value(locator_details.get("locator_type"), locator_details.get("locator_value"));

        return element;
    }

    public WebElement find_element_by_xpath(String locator_value) {
        WebElement element = null;
        element = driver.findElement(By.xpath(locator_value));
        return element;
    }

    public WebElement find_element_using_dynamic_xpath(String locator_value, Map<String, String> dynamic_value) throws locator_validation_exception {
        WebElement element = null;
        locator_reader reader = new locator_reader();


        Map<String, String> locator_details = reader.get_locator_value(locator_value);


        String final_xpath = "";
        if (locator_details.get("locator_type").equalsIgnoreCase("dyn-xpath")) {
            String current_xpath = locator_details.get("locator_value");
            final_xpath = current_xpath;
            if (current_xpath.contains("${")) {

                for (Map.Entry<String, String> entry : dynamic_value.entrySet()) {

                    System.out.println("Key = " + entry.getKey() +
                            ", Value = " + entry.getValue());

                    final_xpath = final_xpath.replace("${" + entry.getKey() + "}", entry.getValue());
                }

            } else {
                throw new locator_validation_exception("No Dynamic Value Found in locator");
            }


        } else {
            throw new locator_validation_exception("locator type is not a dyn-xpath, This method only use for the Dynamic Xpath ");
        }

        return driver.findElement(By.xpath(final_xpath));
    }

    public List<WebElement> find_multiple_elements(String locator_value) {

        List<WebElement> elements = null;

        locator_reader reader = new locator_reader();

        Map<String, String> locator_details = reader.get_locator_value(locator_value);




        switch (locator_details.get("locator_type")) {
            case "xpath":
                elements = driver.findElements(By.xpath(locator_details.get("locator_value")));
                break;
            case "id":
                elements = driver.findElements(By.id(locator_details.get("locator_value")));
                break;
            case "css_selector":
                elements = driver.findElements(By.cssSelector(locator_details.get("locator_value")));
                break;
            case "class_name":
                elements = driver.findElements(By.className(locator_details.get("locator_value")));
                break;
            case "name":
                elements = driver.findElements(By.name(locator_details.get("locator_value")));
                break;
            case "link_text":
                elements = driver.findElements(By.linkText(locator_details.get("locator_value")));
                break;
            case "partial_link_text":
                elements = driver.findElements(By.partialLinkText(locator_details.get("locator_value")));
                break;
            case "tag":
                elements = driver.findElements(By.tagName(locator_details.get("locator_value")));
                break;
            default:
                logs.test_step("Incorrect Locator Type");
        }

        return elements;
    }


    public List<WebElement> find_multiple_element_from_element(String main_element, String element_to_find) {
        WebElement main = find(main_element);

        List<WebElement> elements = null;

        locator_reader reader = new locator_reader();

        Map<String, String> locator_details = reader.get_locator_value(element_to_find);


        switch (locator_details.get("locator_type")) {
            case "xpath":
                elements = main.findElements(By.xpath(locator_details.get("locator_value")));
                break;
            case "id":
                elements = main.findElements(By.id(locator_details.get("locator_value")));
                break;
            case "css_selector":
                elements = main.findElements(By.cssSelector(locator_details.get("locator_value")));
                break;
            case "class_name":
                elements = main.findElements(By.className(locator_details.get("locator_value")));
                break;
            case "name":
                elements = main.findElements(By.name(locator_details.get("locator_value")));
                break;
            case "link_text":
                elements = main.findElements(By.linkText(locator_details.get("locator_value")));
                break;
            case "partial_link_text":
                elements = main.findElements(By.partialLinkText(locator_details.get("locator_value")));
                break;
            case "tag":
                elements = main.findElements(By.tagName(locator_details.get("locator_value")));
                break;
            default:
                logs.test_step("Incorrect Locator Type");
        }


        return elements;
    }


    public WebElement find_element_from_element(String main_element, String element_to_find) {
        WebElement main = find(main_element);

        WebElement element = null;
        String[] locator_to_find = element_to_find.split(":");

        switch (locator_to_find[0]) {
            case "xpath":
                element = main.findElement(By.xpath(locator_to_find[1]));
                break;
            case "id":
                element = main.findElement(By.id(locator_to_find[1]));
                break;
            case "css_selector":
                element = main.findElement(By.cssSelector(locator_to_find[1]));
                break;
            case "class_name":
                element = main.findElement(By.className(locator_to_find[1]));
                break;
            case "name":
                element = main.findElement(By.name(locator_to_find[1]));
                break;
            case "link_text":
                element = main.findElement(By.linkText(locator_to_find[1]));
                break;
            case "partial_link_text":
                element = main.findElement(By.partialLinkText(locator_to_find[1]));
                break;
            case "tag":
                element = main.findElement(By.tagName(locator_to_find[1]));
                break;
            default:
                logs.test_step("Incorrect Locator Type");
        }

        return element;
    }

    public WebElement get_active_element() {

        return driver.switchTo().activeElement();
    }

    public String get_element_tag(String locator_value) {
        return find(locator_value).getTagName();
    }

    public String get_css_value(String locator_value, String css) {

        return find(locator_value).getCssValue(css);
    }

    public String get_element_text(String locator_value) {
        return find(locator_value).getText();
    }

    public void enter_text(String locator_value, String text_to_enter) {
        logs.test_step("Enter text " + text_to_enter + " at locator " + locator_value);
        find(locator_value).sendKeys(text_to_enter);
    }

    public void clear_text_field(String locator_value) {
        logs.test_step("clear value from " + locator_value + " text fields");
        find(locator_value).sendKeys(Keys.CONTROL,"a",Keys.DELETE);
        // find(locator_value).clear();
    }

    public void clear_and_enter_in_text_field(String locator_value, String text_to_enter) {
        logs.test_step("clear value from " + locator_value + " text fields and enter text " + text_to_enter);
        find(locator_value).sendKeys(Keys.CONTROL,"a",Keys.DELETE);
        //find(locator_value).clear();
        find(locator_value).sendKeys(text_to_enter);
    }

    public void click(String locator_value) {
        logs.test_step("Click on " + locator_value);
        find(locator_value).click();
    }

    /**
     * @param element_name
     * @param element_text_for_click
     * @apiNote Click on the First element from the list
     */
    public void click_on_element_with_text_from_list(String element_name, String element_text_for_click) {
        logs.test_step("Click on " + element_text_for_click + " from list ");
        List<WebElement> elements_list = find_multiple_elements(element_name);
        Boolean bool = false;

        for (WebElement element : elements_list) {
            if (element.getText().contains(element_text_for_click)) {
                click(element_name);
                break;
            }
        }

    }

    public void click_using_js(WebElement element) throws Exception {
        try {
            logs.test_step("Click on " + element);
            if (element.isEnabled() && element.isDisplayed()) {
                logs.test_step("Clicking on element with using java script click");

                ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
            } else {
                logs.test_step("Unable to click on element");
            }
        } catch (StaleElementReferenceException e) {
            logs.test_step("Element is not attached to the page document " + e.getStackTrace());
        } catch (NoSuchElementException e) {
            logs.test_step("Element was not found in DOM " + e.getStackTrace());
        } catch (Exception e) {
            logs.test_step("Unable to click on element " + e.getStackTrace());
        }
    }

    public String get_attribute_value(String locator_value, String attribute_name) {
        return find(locator_value).getAttribute(attribute_name);
    }


    public void take_element_screen_shot(WebElement element, String image_name) {

        File scrFile = element.getScreenshotAs(OutputType.FILE);
        try {
            File screenshot_file = new File("./" + image_name + ".png");
            FileUtils.copyFile(scrFile, screenshot_file);
            logs.test_step("Screenshot saved at  <img href=" + screenshot_file.getAbsolutePath() + ">");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void network_interception_Method(WebDriver driver) {
         /* 1. If you want to capture network events coming into the browser
            2. and you want to manipulate them you are able to do it with the following examples.*/

        try (NetworkInterceptor interceptor = new NetworkInterceptor(
                driver,
                Route.matching(req -> true)
                        .to(() -> req -> new HttpResponse()
                                .setStatus(200)
                                .addHeader("Content-Type", MediaType.HTML_UTF_8.toString())
                                .setStatus(200)
                                .setContent(utf8String("Creamy, delicious cheese!"))));) {
            logs.test_step("INFO : Network Interceptor is executed..");
        } catch (Exception e) {
            logs.test_step("INFO : " + e.getStackTrace());
        }

    }

    public void jsException_method(ChromeDriver driver, String locator_value) {
        //Usage Of This method :
        //Listen to the JS Exceptions and register callbacks to process the exception details.

        DevTools devTools = driver.getDevTools();
        devTools.createSession();

        ((ChromeDriver) driver).getDevTools().createSession();

        List<JavascriptException> jsExceptionsList = new ArrayList<>();
        Consumer<JavascriptException> addEntry = jsExceptionsList::add;
        devTools.getDomains().events().addJavascriptExceptionListener(addEntry);

        WebElement link2click = find(locator_value);
        ((JavascriptExecutor) driver).executeScript("arguments[0].setAttribute(arguments[1], arguments[2]);",
                link2click, "onclick", "throw new Error('Hello, world!')");
        link2click.click();

        for (JavascriptException jsException : jsExceptionsList) {
            logs.test_step("JS exception message: " + jsException.getMessage());
            logs.test_step("JS exception system information: " + jsException.getSystemInformation());
            logs.test_step("JS exception Get cause : " + jsException.getCause());
            logs.test_step("JS exception get Build Information: " + jsException.getBuildInformation());
            logs.test_step("JS exception Get full stack trace : " + jsException.fillInStackTrace());
            logs.test_step("JS exception get raw Message : " + jsException.getRawMessage());

            jsException.printStackTrace();
        }
    }

    public void console_Log_method(ChromeDriver driver) {
        DevTools devTools = driver.getDevTools();
        devTools.createSession();
        devTools.getCdpSession();
        devTools.send(Log.enable());
        devTools.addListener(Log.entryAdded(),
                logEntry -> {
                    logs.test_step("INFO : log      : " + logEntry.getText());
                    logs.test_step("INFO : level    : " + logEntry.getLevel());
                    logs.test_step("INFO : Time     : " + logEntry.getTimestamp());
                    logs.test_step("INFO : URL      : " + logEntry.getUrl());
                    logs.test_step("INFO : WorkerID : " + logEntry.getWorkerId());

                });

    }

    public void select_single_option_from_dropdown(String locator_value, String Value) {
        Select drp = new Select(find(locator_value));
        List<WebElement> options = drp.getOptions();
        for (WebElement option : options) {
            if (option.getText().equals(Value)) {
                option.click();
                break;
            }
            logs.test_step("INFO : " + Value + " is selected.");
        }
    }

    public void select_all_options_options_from_dropDown(String locator_value) {
        Select drp = new Select(find(locator_value));
        boolean multiple_Selected_dropDown = drp.isMultiple();
        List<WebElement> options = drp.getOptions();
        if (multiple_Selected_dropDown == true) {
            for (WebElement option : options) {
                option.click();
            }
            logs.test_step("INFO : All options are Selected..");
        } else {
            logs.test_step("INFO : This Dropdown is not a multiSelected DropDown.");
        }
    }

    public void select_options_from_dropdown_by_value(String locator_value, String value) {
        Select drp = new Select(find(locator_value));
        drp.selectByValue(value);
        logs.test_step("INFO : Select " + value + " From Dropdown");

    }

    public void select_options_from_dropdown_by_index(String locator_value, int index) {
        Select drp = new Select(find(locator_value));
        drp.selectByIndex(index);
        logs.test_step("INFO : Select " + index + " Index From Dropdown");

    }

    public void select_options_from_dropdown_by_visibleText(String locator_value, String visibleText) {
        Select drp = new Select(find(locator_value));
        drp.selectByVisibleText(visibleText);
        logs.test_step("INFO : Select " + visibleText + " From Dropdown");

    }

    public void deSelect_allOptions_from_dropDown(String locator_value) {
        Select drp = new Select(find(locator_value));
        boolean multiple_Selected_dropDown = drp.isMultiple();
        if (multiple_Selected_dropDown == true) {
            drp.deselectAll();
            logs.test_step("INFO : All options are DeSelected..");
        } else {
            logs.test_step("INFO : This Dropdown is not a multiSelected DropDown.");
        }

    }

    public void deSelect_options_from_dropDown_using_index(String locator_value, int index) {
        Select drp = new Select(find(locator_value));
        drp.deselectByIndex(index);
        logs.test_step("INFO : De-Select " + index + " From Dropdown");
    }

    public void deSelect_options_from_dropDown_using_value(String locator_value, String value) {
        Select drp = new Select(find(locator_value));
        drp.deselectByValue(value);
        logs.test_step("INFO : De-Select " + value + " From Dropdown");
    }

    public void deSelect_options_from_dropDown_using_visible_text(String locator_value, String text) {
        Select drp = new Select(find(locator_value));
        drp.deselectByVisibleText(text);
        logs.test_step("INFO : De-Select " + text + " From Dropdown");
    }

    public void get_all_selected_options_from_dropDown(String locator_value) {
        Select drp = new Select(find(locator_value));
        List<WebElement> AllOptions = drp.getAllSelectedOptions();
        for (WebElement option : AllOptions) {
            logs.test_step("INFO : Selected Options are : " + option.getText());
        }
    }

    public void perform_scroll_to_element(String locator_value) {

        new Actions(driver)
                .scrollToElement(find(locator_value))
                .perform();
    }

    public void perform_horizontal_scroll_to_element(String locator_value, int scroll_amount) {

        int deltaY = find(locator_value).getRect().y;
        new Actions(driver)
                .scrollByAmount(scroll_amount, deltaY)
                .perform();
    }

    public void perform_scroll_by_amount(int x, int y) {

        new Actions(driver)
                .scrollByAmount(x, y)
                .perform();
    }

    public void perform_scroll_from_element_by_amount(String locator_value, int x, int y) {

        WheelInput.ScrollOrigin scrollOrigin = WheelInput.ScrollOrigin.fromElement(find(locator_value));
        new Actions(driver)
                .scrollFromOrigin(scrollOrigin, x, y)
                .perform();
    }

    public void refresh_Until_No_Data_Message_Disappears_Then_Click_Metrics(String locator1, String locator2 ) {
        int maxRetries = 3;
        int retryCount = 0;

        while (retryCount < maxRetries) {
            try {
                WebElement noDataMessage = find(locator1);
                if (noDataMessage.isDisplayed()) {
                    System.out.println("Message found. Refreshing the page...");
                    driver.navigate().refresh();
                    Thread.sleep(5000);
                    click(locator2);
                }
            } catch (NoSuchElementException e) {
                System.out.println("Message not found. Clicking on Metrics button...");
                return;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            retryCount++;
        }

        if (retryCount == maxRetries) {
            System.out.println("Max retries reached. 'No data' message is still present.");
        }
    }
    public void enter_text_global_infra_process(String locators_val1, String name, String name_operator_value, String operator_name, String operator_value, String host_name) throws InterruptedException {
        enter_text(locators_val1, name);
        Thread.sleep(2000);
        List<WebElement>name_operator= find_multiple_elements(name_operator_value);
        for(WebElement nam:name_operator)
        {
            if(nam.getText().equals("os.type")){
                nam.click();
                break;
            }
        }
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        List<WebElement> operatorList = find_multiple_elements(operator_name);
        for (WebElement ol : operatorList) {
            if (ol.getText().equals(operator_value)) {
                ol.click();
                break;
            }
        }
        Thread.sleep(2000);
        WebElement host_Name = find(host_name);
        enter_text(locators_val1, host_Name.getText().toLowerCase());
    }

    public void verify_with_applied_filter_to_table_data(String locator_key1, String locator_key2) {
        WebElement appliedFilterElement = find(locator_key1);
        String expectedtName = appliedFilterElement.getText();
        System.out.println("expectedtName " + expectedtName);
        WebElement hostNameElement = find(locator_key2);
        String actualName = hostNameElement.getText();
        System.out.println("actualName " + actualName);

        Assert.assertEquals(actualName, expectedtName, "Both are Matched with each other");
        System.out.println("Validation Passed");
    }

    public void verifyTheListOfOption(String locatorVal1, String locatorVal2) {
        List<WebElement> optionContainers = find_multiple_elements(locatorVal1);
        List<WebElement> hostInfoValues = find_multiple_elements(locatorVal2);

        for (int i = 0; i < optionContainers.size(); i++) {
            String optionText = optionContainers.get(i).getText().trim();
            String value = "Not Found";

            if (i < hostInfoValues.size()) {
                try {
                    value = hostInfoValues.get(i).getText().trim();
                } catch (Exception e) {
                    Reporter.log("Could not fetch value for option: " + optionText,true);
                }
            }

            Reporter.log("UI Text: " + optionText + " | Value: " + value, true);
        }
    }

    public void hover_on_graph(String locator_key1, String locator_key2, String locator_key3) {
        Actions actions = new Actions(driver);
        List<WebElement> graphBars = find_multiple_elements(locator_key1);
        for (WebElement bar : graphBars) {
            actions.moveToElement(bar).perform();
            WebElement dateElement = find(locator_key3);
            String dateText = dateElement.getText().trim();
            System.out.println("Date: " + dateText);
            List<WebElement> totals = find_multiple_elements(locator_key2);
            for (WebElement total : totals) {
                String text = total.getText().replaceAll("[^0-9.]", "");
                if (!text.isEmpty()) {
                    double value = Double.parseDouble(text);
                    if (value > 0) {
                        Reporter.log("Hovered Data (Valid): " + text, true);
                    } else {
                        Reporter.log("Hovered Data (Ignored, Value <= 0): " + text,true);
                    }
                }
            }
        }
    }

    public void enter_text_filter_by_search_box(String locator_key1, String texts, String locator_key2, int graphIndex, String locator_key3, String locator_key4) throws InterruptedException {
        click(locator_key1);
        enter_text(locator_key1, texts);
        Thread.sleep(2000);
        click(locator_key2);
        driver.findElement(By.xpath("//div[text()='Overview']")).click();

        String graphXpath = String.format("(//*[local-name()='svg']//*[name()='g' and @class='highcharts-series-group'])[%d]//*[name()='path'][@class='highcharts-point highcharts-color-0']", graphIndex);
        List<WebElement> cpugraph = driver.findElements(By.xpath(graphXpath));

        for (WebElement point : cpugraph) {
            try {
                a.moveToElement(point).perform();

                List<WebElement> cpu_values = driver.findElements(By.xpath("//span[contains(text(),'system')]/ancestor::div[@class='highcharts_item_row']"));

                for (WebElement element : cpu_values) {
                    String text = element.getText().trim();

                    if (!text.isEmpty()) {
                        System.out.println("Graph Value: " + text);

                        String[] parts = text.split("\n");
                        if (parts.length > 1) {
                            String valueWithUnit = parts[1].trim();

                            String numberPart = valueWithUnit.replaceAll("[^0-9.]", "");
                            String unitPart = valueWithUnit.replaceAll("[0-9.]", "").trim();

                            if (numberPart.isEmpty()) {
                                Assert.fail("Test Failed: No numeric value found in text: " + text);
                            }

                            double value = Double.parseDouble(numberPart);

                            if (unitPart.equals("%")) {
                                Assert.assertTrue(value >= 0, "Test Failed: CPU utilization percentage is not greater than zero. Found: " + value + "%");
                            } else if (unitPart.equalsIgnoreCase("GB") || unitPart.equalsIgnoreCase("MB") || unitPart.equalsIgnoreCase("KB") || unitPart.equalsIgnoreCase("TB") || unitPart.equalsIgnoreCase("KB/s") || unitPart.equalsIgnoreCase("Bytes/s") || unitPart.equalsIgnoreCase("MB/s") || unitPart.equalsIgnoreCase("m")) {
                                Assert.assertTrue(value >= 0, "Test Failed: Memory usage is not greater than zero. Found: " + value + " " + unitPart);
                            } else if (unitPart.isEmpty()) {
                                Assert.assertTrue(value >= 0, "Test Failed: Numeric value is not greater than zero. Found: " + value);
                            } else {
                                Assert.fail("Test Failed: Unknown unit '" + unitPart + "' in text: " + text);
                            }
                        } else {
                            Assert.fail("Test Failed: Value format is incorrect for text: " + text);
                        }
                    }
                }
            } catch (StaleElementReferenceException e) {
                System.out.println("Found StaleElementReferenceException");
            }
        }
        a.moveToElement(find(locator_key3)).perform();
        a.moveToElement(find(locator_key4)).perform();
        a.click().perform();

        driver.findElement(By.xpath("//div[@class=\"custom-checkbox\"]//span[contains(@class,'checkbox-icon')]")).click();
    }

    public void hover_on_expand_button_and_click(String locator_val1, String locator_val2) {
        a.moveToElement(find(locator_val1)).perform();
        a.moveToElement(find(locator_val2)).click().perform();
    }

    public void verify_table_data_with_tooltip_message(String locator_key1, String locator_key2, String locator_key3, String locator_key4) throws InterruptedException {
        Map<String, List<Double>> cpuUtilizationMap = new HashMap<>();

        List<WebElement> graphPoints = find_multiple_elements(locator_key1);
        System.out.println("Total Graph Points: " + graphPoints.size());
        for (WebElement point : graphPoints) {
            try {
                a.moveToElement(point).perform();
                Thread.sleep(500);

                List<WebElement> tooltipElements = find_multiple_elements(locator_key2);
                if (!tooltipElements.isEmpty()) {
                    for (WebElement tooltip : tooltipElements) {
                        String text = tooltip.getText().trim();
                        if (!text.isEmpty()) {
                            System.out.println("Tooltip Data: " + text);

                            String[] parts = text.split("\n");
                            if (parts.length > 1) {
                                String cpuName = parts[0].trim();
                                String valueWithUnit = parts[1].trim().replaceAll("[^0-9.]", "");

                                if (valueWithUnit.isEmpty()) continue;

                                double value = Double.parseDouble(valueWithUnit);
                                cpuUtilizationMap.putIfAbsent(cpuName, new ArrayList<>());
                                cpuUtilizationMap.get(cpuName).add(value);
                            }
                        }
                    }
                } else {
                    System.out.println("No tooltip data found.");
                }
            } catch (StaleElementReferenceException e) {
                System.out.println("Stale Element Exception. Retrying...");
            } catch (Exception e) {
                System.out.println("Unexpected error: " + e.getMessage());
            }
        }

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,1000)");

        Map<String, Double[]> cpuTableMap = new HashMap<>();
        //   List<WebElement> cpuRows = driver.findElements(By.xpath("(//tbody[@class='ant-table-tbody'])[2]/tr"));
        List<WebElement> cpuRows = find_multiple_elements(locator_key3);


        for (WebElement row : cpuRows) {
            try {
                //   String cpuName = row.findElement(By.xpath("./td[@class='ant-table-cell']//span[@class='text-legend-label']")).getText().trim();
                WebElement cpName = row.findElement(By.xpath(locator_key4));
                String cpuName = cpName.getText().trim();
                WebElement minElement = row.findElement(By.xpath("./td[4]"));
                WebElement maxElement = row.findElement(By.xpath("./td[3]"));
                js.executeScript("arguments[0].scrollIntoView(true);", row);
                String minText = minElement.getText().replace("%", "").trim();
                String maxText = maxElement.getText().replace("%", "").trim();

                if (minText.isEmpty() || maxText.isEmpty()) {
                    System.out.println("Skipping row due to empty values: " + cpuName);
                    continue;
                }

                double minValue = Double.parseDouble(minText);
                double maxValue = Double.parseDouble(maxText);

                cpuTableMap.put(cpuName, new Double[]{minValue, maxValue});
            } catch (Exception e) {
            }
        }

        // Validate Data using Assertions
        System.out.println("\nValidation Results:");
        for (Map.Entry<String, List<Double>> entry : cpuUtilizationMap.entrySet()) {
            String cpuName = entry.getKey();
            List<Double> values = entry.getValue();

            double minTooltip = Collections.min(values);
            double maxTooltip = Collections.max(values);

            if (cpuTableMap.containsKey(cpuName)) {
                double minTable = cpuTableMap.get(cpuName)[0];
                double maxTable = cpuTableMap.get(cpuName)[1];

                double tolerance = 0.01;

                System.out.println(cpuName + " - Tooltip Min: " + minTooltip + "%, Max: " + maxTooltip + "% | Table Min: " + minTable + "%, Max: " + maxTable + "%");

                Assert.assertEquals(minTooltip, minTable, tolerance, cpuName + " ❌ Min values do not match!");
                Assert.assertEquals(maxTooltip, maxTable, tolerance, cpuName + " ❌ Max values do not match!");
            } else {
                Assert.fail("❌ CPU " + cpuName + " not found in the table!");
            }
        }
    }

    public void validate_table_row_with_total_page(String locator_val1, String locator_val2) {
        WebElement firstElement = find(locator_val1);
        List<WebElement> secondElements = find_multiple_elements(locator_val2);
        int number1 = Integer.parseInt(firstElement.getText().trim());
        System.out.println("Total number of pages: " + number1);
        int number2 = secondElements.size();
        System.out.println("Total number of rows: " + number2);
        Assert.assertTrue(number1 != 0, "Total number of pages is zero!");
        Assert.assertTrue(number2 != 0, "Total number of rows is zero!");
        Assert.assertEquals(number1, number2, "Total number of rows does not match total number of pages!");
    }
    public boolean verifyGraphTime( String locators, int amount, String timeUnit)  {
        LocalDateTime currentTime = LocalDateTime.now();
        LocalDateTime pastTime;

        switch (timeUnit.toLowerCase()) {
            case "minutes":
                pastTime = currentTime.minusMinutes(amount);
                break;
            case "hours":
                pastTime = currentTime.minusHours(amount);
                break;
            case "days":
                pastTime = currentTime.minusDays(amount);
                break;
            case "weeks":
                pastTime = currentTime.minusWeeks(amount);
                break;
            default:
                throw new IllegalArgumentException("Invalid time unit. Use 'minutes', 'hours', 'days', or 'weeks'.");
        }

        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm");
        System.out.println(timeFormatter);
        boolean isValid = true;
        List<WebElement> timeStamps = find_multiple_elements(locators);

        for (WebElement timestampElement : timeStamps) {
            String timestampText = timestampElement.getText().trim();

            if (timestampText.length() >= 5) {
                timestampText = timestampText.substring(0, 5);
            }

            System.out.println("⏱ Time Stamp: " + timestampText);
            try {
                LocalTime timeOnly = LocalTime.parse(timestampText, timeFormatter);
                LocalDateTime logTime = LocalDateTime.of(currentTime.toLocalDate(), timeOnly);

                if (logTime.isBefore(pastTime) || logTime.isAfter(currentTime)) {
                    System.out.println("❌ Log time " + timestampText + " is OUTSIDE the valid range.");
                    isValid = false;
                } else {
                    System.out.println("✅ Log time " + timestampText + " is within the valid range.");
                }
            } catch (Exception e) {
                System.out.println("❌ Error parsing timestamp: " + timestampText);
            }
        }

        return isValid;
    }
    public void verify_the_list_of_options(String locator_val1, String locator_val2, String Filepath, String sheetName, int columnNumber) {
        List<WebElement> option_container = find_multiple_elements(locator_val1);
        List<WebElement> host_info_value = find_multiple_elements(locator_val2);
        List<String> optionTextList = new ArrayList<>();
        for (int i = 0; i < option_container.size(); i++) {
            String optionText = option_container.get(i).getText().trim();
            optionTextList.add(optionText);
            String optionValue = "Not Found";
            try {
                if (i < host_info_value.size()) {
                    optionValue = host_info_value.get(i).getText().trim();
                }
            } catch (Exception e) {
                Reporter.log("No value found for: " + optionText,true);
            }
            Reporter.log("UI Text: " + optionText + " | Value: " + optionValue,true);
        }
//        List<String> expectedOptionContainer = dataReaders.readExcelData(Filepath, sheetName, columnNumber);
//        for (String uiText : optionTextList) {
//            Assert.assertTrue(expectedOptionContainer.contains(uiText),
//                    "UI Text not found in Excel: " + uiText);
//        }
    }

    public void verify_ant_table_container_header(String locator_val1, String locator_val2) {

        List<WebElement> ant_table_container = find_multiple_elements(locator_val1);
        List<WebElement> ant_table_container_value = find_multiple_elements(locator_val2);

        JavascriptExecutor js = (JavascriptExecutor) driver;

        for (int i = 0; i < ant_table_container.size(); i++) {
            WebElement headerElement = ant_table_container.get(i);

            if (!headerElement.isDisplayed()) {
                js.executeScript("arguments[0].scrollIntoView({inline: 'center'});", headerElement);
                driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
            }

            String optionText = headerElement.getText().trim();

            String optionValue = "Not Found";
            try {
                if (i < ant_table_container_value.size()) {
                    WebElement valueElement = ant_table_container_value.get(i);

                    if (!valueElement.isDisplayed()) {
                        js.executeScript("arguments[0].scrollIntoView({inline: 'center'});", valueElement);
                        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
                    }

                    optionValue = valueElement.getText().trim();
                }
            } catch (Exception e) {
                System.out.println("No value found for: " + optionText);
            }

            System.out.println("UI Text: " + optionText + " | Value: " + optionValue);
        }
    }

    public boolean verifyGraphTimeWithActualTime( int graphIndex, int amount, String timeUnit)  {
        LocalDateTime currentTime = LocalDateTime.now();
        System.out.println(currentTime);
        LocalDateTime pastTime;

        switch (timeUnit.toLowerCase()) {
            case "minutes":
                pastTime = currentTime.minusMinutes(amount);
                break;
            case "hours":
                pastTime = currentTime.minusHours(amount);
                break;
            case "days":
                pastTime = currentTime.minusDays(amount);
                break;
            case "weeks":
                pastTime = currentTime.minusWeeks(amount);
                break;
            default:
                throw new IllegalArgumentException("Invalid time unit. Use 'minutes', 'hours', 'days', or 'weeks'.");
        }

        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm");
        System.out.println(timeFormatter);
        boolean isValid = true;
        List<WebElement>timeStamp= driver.findElements(By.xpath("(//*[name()='g' and @class=\"highcharts-axis-labels highcharts-xaxis-labels\"])["+graphIndex+"]//*[name()='text']"));
        for (WebElement timestampElement : timeStamp) {
            String timestampText = timestampElement.getText().trim();

            if (timestampText.length() >= 5) {
                timestampText = timestampText.substring(0, 5);
            }

            System.out.println("⏱ Time Stamp: " + timestampText);
            try {
                LocalTime timeOnly = LocalTime.parse(timestampText, timeFormatter);
                LocalDateTime logTime = LocalDateTime.of(currentTime.toLocalDate(), timeOnly);

                if (logTime.isBefore(pastTime) || logTime.isAfter(currentTime)) {
                    System.out.println("❌ Log time " + timestampText + " is OUTSIDE the valid range.");
                    isValid = false;
                } else {
                    System.out.println("✅ Log time " + timestampText + " is within the valid range.");
                }
            } catch (Exception e) {
                System.out.println("❌ Error parsing timestamp: " + timestampText);
            }
        }

        return isValid;
    }

    public void validate_graphs_data(int graphIndex) {
        String graphXpath = "((//*[local-name()='svg']//*[name()='g' and @class='highcharts-series-group'])[" + graphIndex + "]//*[name()='g' and contains(@class, 'highcharts-markers')])[1]//*[name()='path']";
        List<WebElement> cpugraph = driver.findElements(By.xpath(graphXpath));

        System.out.println(" Processing Graph # " + graphIndex + " | Total Points: " + cpugraph.size());

        for (WebElement point : cpugraph) {
            try {
                a.moveToElement(point).perform();
                driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

                List<WebElement> cpu_values = driver.findElements(By.xpath("//span[contains(@style,'background-color')]"));

                for (WebElement element : cpu_values) {
                    String text = element.getText().trim();
                    System.out.println("Graph #" + graphIndex + " Raw Tooltip Text: " + text);

                    if (!text.isEmpty()) {
                        String[] parts = text.split("\n");
                        if (parts.length > 1) {
                            String valueWithUnit = parts[1].trim();

                            String numberPart = valueWithUnit.replaceAll("[^0-9.]", "");
                            String unitPart = valueWithUnit.replaceAll("[0-9.]", "").trim();

                            if (numberPart.isEmpty()) {
                                System.out.println("Skipping: No numeric value in text: " + text);
                                continue;
                            }

                            double value = Double.parseDouble(numberPart);

                            if (unitPart.equals("%")) {
                                Assert.assertTrue(value >= 0, "Test Failed: CPU utilization percentage is not greater than zero. Found: " + value + "%");
                            } else if (unitPart.equalsIgnoreCase("GB") || unitPart.equalsIgnoreCase("MB") || unitPart.equalsIgnoreCase("KB") ||
                                    unitPart.equalsIgnoreCase("TB") || unitPart.equalsIgnoreCase("KB/s") || unitPart.equalsIgnoreCase("Bytes/s") ||
                                    unitPart.equalsIgnoreCase("MB/s") || unitPart.equalsIgnoreCase("m")) {
                                Assert.assertTrue(value >= 0, "Test Failed: Memory usage is not greater than zero. Found: " + value + " " + unitPart);
                            } else if (unitPart.isEmpty()) {
                                Assert.assertTrue(value >= 0, "Test Failed: Numeric value is not greater than zero. Found: " + value);
                            } else {
                                System.out.println("Skipping: Unknown unit '" + unitPart + "' in text: " + text);
                                continue;
                            }
                        } else {
                            System.out.println("Skipping: Unexpected format in text: " + text);
                        }
                    } else {
                        System.out.println("Skipping: Empty or invalid value received for Graph #" + graphIndex);
                    }
                }
            } catch (StaleElementReferenceException e) {
                System.out.println("Stale element detected. Skipping Graph #" + graphIndex);
            }
        }
    }

    public void hover_on_graphs(String locator_key1, String locator_key2) {
        Actions actions = new Actions(driver);
        List<WebElement> graphBars = find_multiple_elements(locator_key1);

        for (int i = 0; i < graphBars.size(); i++) {
            try {
                graphBars = find_multiple_elements(locator_key1);
                WebElement bar = graphBars.get(i);

                actions.moveToElement(bar).perform();
                Thread.sleep(1000);

                try {
                    WebElement dateElement = driver.findElement(By.xpath("//div[@class='date_block']/b"));
                    String timestamp = dateElement.getText().trim();
                    Reporter.log(" Graph Timestamp: " + timestamp, true);
                } catch (NoSuchElementException e) {
                    Reporter.log("Timestamp not found in tooltip.", true);
                }

                List<WebElement> totals = find_multiple_elements(locator_key2);
                for (WebElement total : totals) {
                    String text = total.getText().trim();
                    Pattern pattern = Pattern.compile("(\\d+\\.\\d+)");
                    Matcher matcher = pattern.matcher(text);

                    if (matcher.find()) {
                        String numberStr = matcher.group(1);
                        try {
                            double value = Double.parseDouble(numberStr);
                            if (value >= 0) {
                                Reporter.log(" Graph data ==> " + text, true);
                            } else {
                                Reporter.log(" Graph data (Ignored, Value <= 0): ==> " + text, true);
                            }
                        } catch (NumberFormatException e) {
                            Reporter.log("Number format issue for text: " + text, true);
                        }
                    } else {
                        Reporter.log("No numeric value found in text: " + text, true);
                        Assert.fail("No numeric value found in text: " + text);
                    }
                }

            } catch (StaleElementReferenceException e) {
                Reporter.log("Stale element. Skipping bar index: " + i, true);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void enter_invalid_host_name_in_global_search_box(String locator_val1, String name,String locator_val2,String locator_val3, String operator, String value) throws InterruptedException {
        enter_text(locator_val1, name);
        Thread.sleep(2000);
        List<WebElement> hostList = find_multiple_elements(locator_val2);
        for (WebElement hl : hostList) {
            if (hl.getText().equals(name)) {
                System.out.println("Text"+ hl.getText());
                hl.click();
                break;
            }
        }
        Thread.sleep(2000);
        List<WebElement> operatorList= find_multiple_elements(locator_val3);
        for(WebElement ol:operatorList){
            if(ol.getText().equals(operator)){
                ol.click();
                break;
            }
        }
        enter_text(locator_val1, value);
    }
    public void verify_correct_data_display_on_Table(String locator_val1 , String locator_val2) throws InterruptedException {

        List<WebElement> ant_table_container = find_multiple_elements(locator_val1);
        List<WebElement> ant_table_container_value = find_multiple_elements(locator_val2);

        JavascriptExecutor js = (JavascriptExecutor) driver;

        for (int i = 0; i < ant_table_container.size(); i++) {
            WebElement headerElement = ant_table_container.get(i);

            if (!headerElement.isDisplayed()) {
                js.executeScript("arguments[0].scrollIntoView({inline: 'center'});", headerElement);
                Thread.sleep(3000);
            }

            String optionText = headerElement.getText().trim();

            String optionValue = "Not Found";
            try {
                if (i < ant_table_container_value.size()) {
                    WebElement valueElement = ant_table_container_value.get(i);

                    if (!valueElement.isDisplayed()) {
                        js.executeScript("arguments[0].scrollIntoView({inline: 'center'});", valueElement);
                        Thread.sleep(1000);
                    }

                    optionValue = valueElement.getText().trim();
                }
            } catch (Exception e) {
                Reporter.log("No value found for: " + optionText, true);
            }

            Reporter.log("UI Text: " + optionText + " | Value: " + optionValue,true);
        }
    }

    public void click_on_multiple_elements(String locator_value) {
        List<WebElement> elements = find_multiple_elements(locator_value);

        if (elements != null && !elements.isEmpty()) {
            for (WebElement element : elements) {
                try {
                    element.click();
                } catch (Exception e) {
                    logs.test_step("Failed to click on an element: " + e.getMessage());
                }
            }
        } else {
            logs.test_step("No elements found for locator: " + locator_value);
        }
    }

    public void verify_single_option_and_value(String locator_val1, String locator_val2) {
        try {
            WebElement optionElement = find(locator_val1);
            WebElement valueElement = find(locator_val2);

            String optionText = optionElement.getText().trim();
            String optionValue = valueElement.getText().trim();

            Reporter.log("UI Text: " + optionText + " | Value: " + optionValue, true);
        } catch (Exception e) {
            Reporter.log("Unable to find element(s) with locators: " + locator_val1 + ", " + locator_val2, true);
        }
    }

    public void enter_text_in_search_field(String text_locator, String hostText, String multiple_locator, String operator_locator, String expectedOperator) {
        try {
            // Step 1: Enter text
            enter_text(text_locator, hostText);

            // Step 2: Wait for host list and click matching host
            boolean hostFound = false;
            int retryCount = 0;
            while (retryCount < 5) {
                List<WebElement> multiple_hosts = find_multiple_elements(multiple_locator);
                for (WebElement mul_host : multiple_hosts) {
                    if (mul_host.getText().trim().equalsIgnoreCase(hostText)) {
                        mul_host.click();
                        hostFound = true;
                        break;
                    }
                }
                if (hostFound) break;
                Thread.sleep(1000);
                retryCount++;
            }

            if (!hostFound) {
                System.out.println("Host text '" + hostText + "' not found in the search results.");
            }

            // Step 3: Wait for operator list and click matching operator
            boolean operatorFound = false;
            retryCount = 0;
            while (retryCount < 5) {
                List<WebElement> multiple_operator = find_multiple_elements(operator_locator);
                for (WebElement single_operator : multiple_operator) {
                    if (single_operator.getText().trim().equalsIgnoreCase(expectedOperator)) {
                        single_operator.click();
                        operatorFound = true;
                        break;
                    }
                }
                if (operatorFound) break;
                Thread.sleep(1000);
                retryCount++;
            }

            if (!operatorFound) {
                System.out.println("Operator '" + expectedOperator + "' not found in the list.");
            }

        } catch (Exception e) {
            System.err.println("Error in 'enter_text_in_search_field': " + e.getMessage());
            e.printStackTrace();
        }
    }

    public void verify_and_click_on_Host_Name_in_UP_State(String locator_value1, String locator_value2) throws InterruptedException {
        boolean dataFound = false;
        Set<String> alreadyClickedHosts = new HashSet<>();

        while (!dataFound) {
            List<WebElement> hostNames = find_multiple_elements(locator_value1);
            List<WebElement> resourceStates = find_multiple_elements(locator_value2);

            for (int i = 0; i < hostNames.size(); i++) {
                String resourceStateText = resourceStates.get(i).getText().trim();
                String hostNameText = hostNames.get(i).getText().trim();

                if (resourceStateText.equalsIgnoreCase("UP")) {
                    hostNames.get(i).click();
                    Reporter.log("Clicked on Host Name: " + hostNameText + " ResourceState: " + resourceStateText);
                    Thread.sleep(2000);
                    driver.findElement(By.xpath("//span[text()='APM Services']")).click();
                    Thread.sleep(2000);

                    boolean noDataFound = driver.findElements(By.xpath("//span[@title='No data found for selected time period.']")).size() > 0;

                    if (noDataFound) {
                        Thread.sleep(3000);
                        Reporter.log("No data found even after refresh for Host: " + hostNameText);
                        driver.findElement(By.xpath("//div[@class='back-btn']/child::button[@class='button-v2 is-outlined']")).click();
                        if(resourceStateText.equalsIgnoreCase("UP") && !alreadyClickedHosts.contains(hostNameText))
                        {
                            hostNames.get(i).click();
                        }
                    } else {
                        Reporter.log("APM data found for Host: " + hostNameText);
                        dataFound = true;
                        break;
                    }
                }
            }
        }
    }

    public void click_on_host_name_Tables_with_data(String locator_val1, String locator_val2, String locator_val3) throws InterruptedException {
        List<WebElement> hostNameElements = find_multiple_elements(locator_val1);

        for (int i = 0; i < hostNameElements.size(); i++) {
            try {
                WebElement currentHost = hostNameElements.get(i);
                scrollIntoView(currentHost);
                currentHost.click();

                click(locator_val2);

                boolean noDataFound = isElementPresent("//span[@title=\"No data found for selected time period.\"]");

                if (noDataFound) {
                    click(locator_val2);
                    noDataFound = isElementPresent("//span[@title=\"No data found for selected time period.\"]");
                }

                if (noDataFound) {
                    click(locator_val3);
                } else {
                    break;
                }

            } catch (Exception e) {
                System.out.println("Exception while clicking host at index " + i + ": " + e.getMessage());
                click(locator_val3);
            }
        }
    }
    private void scrollIntoView(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }
    private boolean isElementPresent(String xpath) {
        return driver.findElements(By.xpath(xpath)).size() > 0;
    }

}