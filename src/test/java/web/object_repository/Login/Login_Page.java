package web.object_repository.Login;
import io.unity.performaction.autoweb.Element;
import io.unity.performaction.autoweb.Verify;
import io.unity.performaction.autoweb.Wait;
import io.unity.performaction.autoweb.Window;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Reporter;

import java.util.List;

public class Login_Page {
    WebDriver driver = null;
    Element element = null;
    Verify verify = null;
    Wait wait = null;
    Window window=null;
    Actions actions=null;

    public Login_Page(WebDriver driver) {
        this.driver = driver;
        element = new Element(driver);
        verify = new Verify(driver);
        wait = new Wait(driver);
        window=new Window(driver);
        actions=new Actions(driver);
        driver.manage().window().maximize();
    }

    public void verify_and_click_on_login_in() {
        wait.wait_for_second(2);
        verify.check_element_is_present("login_In");
        element.click("login_In");
    }
    public void switchToNewWindow(){
        String currentWindow= window.get_current_window_handle("email_textbox");
        window.find_new_window_and_switch(currentWindow);
        //window.open_child_window("https://92ab-2402-a00-405-9a3b-c5fa-ef61-d13b-524f.ngrok-free.app/api",2);
        element.click("Visit_Site");
    }
    public void click_on_email_id_text_box (String username) {
        //window.switch_to_new_window_by_index(1);
        wait.wait_for_second(10);
        element.enter_text("email_textbox",username);
    }

    public void click_on_password_text_box(String password) {
        verify.check_element_is_present("password_textbox");
        element.click("password_textbox");
        element.enter_text("password_textbox",password);
        Reporter.log(password);
    }
    public void testPasses(String text){
        Reporter.log(text);
    }

    public void click_on_login_button() {
        wait.wait_until_element_is_visible("login_button");
        verify.check_element_is_present("login_button");
        element.click("login_button");
    }
    public void verify_explore_and_keep_an_eye_on_your_metrics_isVisible() {
        verify.check_element_is_present("explore_and_keep_an_eye_on_your_metrics");
    }
    public void verify_and_click_on_logout_menu_option(){
        wait.wait_for_second(2);
        verify.check_element_is_present("logout_menu");
        element.click("logout_menu");
    }
    public void click_on_logout_button(){
        wait.wait_for_second(2);
        element.click("logout_button");

    }
    public void isWelcomeToMiddlewarePageDisplayed(){
        wait.wait_until_element_is_visible("welcome_to_middleware");
        verify.check_element_is_present("welcome_to_middleware");
    }
    public void verify_and_click_on_calendar_menu() {
        wait.wait_for_second(2);
        verify.check_element_is_present("calendar_Menu");
        element.click("calendar_Menu");
    }
    public void verify_and_select_specific_date(String month, String Year)  {
        while (true) {
            String dynamicLocator = String.format("(//div[contains(@class,'date-panel')]//child::button[contains(@class,'month-btn')])[1]");
            WebElement monthYear = driver.findElement(By.xpath(dynamicLocator));
            String monthYearText = monthYear.getText();
            String yearLocator = String.format("(//div[contains(@class,'date-panel')]//child::button[contains(@class,'year-btn')])[1]");
            WebElement yearLocatorText = driver.findElement(By.xpath(yearLocator));
            String getYearText = yearLocatorText.getText();
            String monthAndYear = monthYearText + " " + getYearText;
            if (monthAndYear.equals(month + " " + Year)) {
                break;
            }
            WebElement pre_button = element.find("calender_pre_button");
            pre_button.click();
        }
        element.click("date_seven_mar");
        element.click("date_thirteen_mar");
    }
    public void click_on_global_calender_previous_Button(){
        wait.wait_for_second(1);
        element.click("global_calender_previous_button");
    }
    public void click_on_global_calender_previous_Button_inside_page(){
        wait.wait_for_second(1);
        element.click("global_calender_previous_button_inside_page");
    }
    public void click_on_specific_minutes(String minute){
        wait.wait_for_second(1);
        List<WebElement> specfic_days= element.find_multiple_elements("select_specfic_date");
        for (WebElement sd : specfic_days) {
            if(sd.getText().equals(minute)){
                sd.click();
                break;
            }
        }
    }
    public void click_on_global_calender_forward_Button(){
        wait.wait_for_second(1);
        WebElement forwardButton= element.find("global_calender_forward_button");
        actions.doubleClick(forwardButton).build().perform();
    }
    public void click_on_global_calender_forward_Button_inside_page(){
        wait.wait_for_second(1);
        WebElement forwardButton= element.find("global_calender_forward_button_inside_page");
        actions.doubleClick(forwardButton).build().perform();
    }
    public void click_on_Embrace_your_pro_user_pop_up() {
        try {
            wait.wait_until_element_is_visible("Embrace_your_pro_pop_up");
            WebElement pop_up= element.find("Embrace_your_pro_pop_up");
            if(pop_up.isDisplayed()){
                element.click("Embrace_your_pro_pop_up");
            }
        } catch (Exception e) {

        }
    }

    public void click_on_past_hour(){
        wait.wait_for_second(2);
        element.click("Past_hour");
    }

}

