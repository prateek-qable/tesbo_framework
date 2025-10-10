package web.object_repository.Settings;
import io.unity.performaction.autoweb.Element;
import io.unity.performaction.autoweb.Verify;
import io.unity.performaction.autoweb.Wait;
import io.unity.performaction.autoweb.Window;
import io.unity.framework.readers.DataReaders;

import io.unity.framework.readers.DataReaders;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import io.unity.performaction.autoweb.Element;

import java.util.ArrayList;
import java.util.List;

public class Settings_Page {
    WebDriver driver = null;
    Element element = null;
    Verify verify = null;
    Wait wait = null;
    Window window = null;
    //DataReaders dataReaders = new DataReaders();
    Actions actions = null;
    WebDriverWait waitForElement = null;

    public Settings_Page(WebDriver driver) {
        this.driver = driver;
        element = new Element(driver);
        verify = new Verify(driver);
        wait = new Wait(driver);
        window = new Window(driver);
        actions = new Actions(driver);
        driver.manage().window().maximize();
    }

    public static final String[] METRICS_FILTER_BY_OPTION = {"receive", "transmit"};
    public static final String[] METRICS_FILTER_BY_OPTION_MEMORY_BYTES = {"free", "used"};
    public String host_name;

    public void verify_and_click_on_Settings() {
        verify.check_element_is_present("Settings_Menu");
        element.click("Settings_Menu");
    }

    public void verify_and_check_Setting_Header() {
        verify.check_element_is_present("Settings_Menu_Header");
    }

    public void verify_and_click_Profile_section() {
        element.click("Settings_Menu_list_Text1");
    }
    public void verify_and_click_Users_section() {
        element.click("Settings_Menu_list_Text2");
    }
    public void verify_and_click_Teams_section() {
        element.click("Settings_Menu_list_Text3");
    }
    public void verify_and_click_Roles_and_Permissions_section() {
        element.click("Settings_Menu_list_Text4");
    }
    public void verify_and_click_Projects_section() {
        element.click("Settings_Menu_list_Text5");
    }
    public void verify_and_click_Billings() {
        element.click("Settings_Menu_list_Text6");
    }
    public void verify_and_click_Usage() {
        element.click("Settings_Menu_list_Text7");
    }
    public void verify_and_click_Ingestion_Control() {
        element.click("Settings_Menu_list_Text8");
    }
    public void verify_and_click_Pipeline() {
        element.click("Settings_Menu_list_Text9");
    }
    public void verify_and_click_API_key() {
        element.click("Settings_Menu_list_Text10");
    }
    public void verify_and_click_Agent_Pipeline() {
        element.click("Settings_Menu_list_Text11");
    }
    public void verify_and_click_on_search_field_and_search_for_k8s_cluster() {
        verify.check_element_is_present("Dashboard_Tab_Search_field");
        element.click("Dashboard_Tab_Search_field");
        element.enter_text("Dashboard_Tab_Search_field", "K8s Cluster");
    }
    public void verify_that_user_is_in_Profile_page() {
        verify.check_element_is_present("Settings_Menu_list_Profile_header1");
    }
}