package web.object_repository.Dashboard;
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

public class Dashboard_Page {
    WebDriver driver = null;
    Element element = null;
    Verify verify = null;
    Wait wait = null;
    Window window = null;
    //DataReaders dataReaders = new DataReaders();
    Actions actions = null;
    WebDriverWait waitForElement = null;

    public Dashboard_Page(WebDriver driver) {
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

    public void verify_and_click_on_Dashboard() {
        verify.check_element_is_present("Dashboard_Menu");
        element.click("Dashboard_Menu");
    }

    public void verify_and_check_clickable_on_Host() {
        verify.check_element_is_present("Host_Tab");
        wait.wait_until_element_is_clickable("Host_Tab");
    }

    public void verify_Dashboard_Text_isvisible(){
        verify.element_is_present("Dashboard_Tab_Text");
    }
    public void verify_and_click_on_search_field_and_search_for_k8s_cluster(){
        verify.check_element_is_present("Dashboard_Tab_Search_field");
        element.click("Dashboard_Tab_Search_field");
        element.enter_text("Dashboard_Tab_Search_field","K8s Cluster");
    }
    public void verify_and_click_Dashboard_Searched_table() {
        verify.check_element_is_present("Dashboard_Tab_Searched_K8s_Cluster");
        element.click("Dashboard_Tab_Searched_K8s_Cluster");
    }
    public void click_on_Dashboard_Tab_Dropdown_Text1_Arrow_Icon(){
        element.click("Dashboard_Tab_Dropdown_Arrow_Icon");
    }
    public void click_on_Dashboard_Tab_Dropdown_Text2_Arrow_Icon(){
        element.click("Dashboard_Tab_Dropdown_Arrow_Icon_Text2");
    }
    public void click_on_Dashboard_Tab_Dropdown_Text3_Arrow_Icon(){
        element.click("Dashboard_Tab_Dropdown_Arrow_Icon_Text3");
    }
    public void click_on_Dashboard_Tab_Dropdown_Text4_Arrow_Icon(){
        element.click("Dashboard_Tab_Dropdown_Arrow_Icon_Text4");
    }
    public void click_on_Dashboard_Tab_Dropdown_Text5_Arrow_Icon(){
        element.click("Dashboard_Tab_Dropdown_Arrow_Icon_Text5");
    }
    public void click_on_Dashboard_Tab_Dropdown_Text6_Arrow_Icon(){
        element.click("Dashboard_Tab_Dropdown_Arrow_Icon_Text6");
    }
    public void click_on_Dashboard_Tab_Dropdown_Text7_Arrow_Icon(){
        element.click("Dashboard_Tab_Dropdown_Arrow_Icon_Text7");
    }
}

