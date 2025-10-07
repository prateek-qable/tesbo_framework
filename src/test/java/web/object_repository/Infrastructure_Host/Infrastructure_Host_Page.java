package web.object_repository.Infrastructure_Host;

import io.unity.framework.readers.DataReaders;
import io.unity.performaction.autoweb.Element;
import io.unity.performaction.autoweb.Verify;
import io.unity.performaction.autoweb.Wait;
import io.unity.performaction.autoweb.Window;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import web.object_repository.Infrastructure.Infrastructure_Page;

import java.time.Duration;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Infrastructure_Host_Page {
    WebDriver driver = null;
    Element element = null;
    Verify verify = null;
    Wait wait = null;
    Window window = null;
    DataReaders dataReaders = new DataReaders();
    Infrastructure_Page infrastructure_page=null;
    Actions actions = null;
    private String Executable_Name;
    public Infrastructure_Host_Page(WebDriver driver) {
        this.driver = driver;
        element = new Element(driver);
        verify = new Verify(driver);
        wait = new Wait(driver);
        window = new Window(driver);
        infrastructure_page = new Infrastructure_Page(driver);
        actions = new Actions(driver);
        driver.manage().window().maximize();
    }

    public static final String[] AI_SEARCH_BAR = {"host.name"};
    public static final String[] EXPAND_EACH_GRAPH = {"CPU usage (%)", "CPU usage by State (%)", "CPU Load Average", "Swap Memory by State (Bytes)",
            "Memory usage by State (Bytes)", "Memory usage by State (%)", "Network IO by Direction (Bytes)", "Network connections by State", "Network connections (Protocol)", "Network Error Rate by Direction (Bytes)",
            "Network Dropped Rate by Direction (Packets)", "Network packets by Direction (Packets)", "Network IO Rate by Direction (Bytes)", "Network packets Rate by Direction (Packets)", "Disk operations by Direction (Bytes)", "Disk IO speed by Direction (Bytes/Second)"};
    public static final String[] CUSTOMIZE_CONTAINER_OPTIONS = {"Operating System", "CPU Utilization Percent", "Memory Usage Percent", "Virtual Usage", "Disk IO", "Host", "PID"};
    public static final String[] OVERVIEW={"Hosts","Containers","Processes"};
    public void verify_and_click_on_Infrastructure() {
        wait.wait_for_second(2);
        verify.check_element_is_present("Infrastructure_Menu");
        element.click("Infrastructure_Menu");
    }
    public void verify_data_select_range_of_Calender() {
        wait.wait_for_second(2);
        if (verify.check_element_is_present("Host_Name_Table")) {
            Assert.assertTrue(verify.check_element_is_present("Host_Name_Table"), "Host name table is not displayed.");
            WebElement hostNameElement = element.find("Host_Name_Table");
            System.out.println("Host Name Table Element: " + hostNameElement.getText());
        } else {
            wait.wait_until_all_element_is_visible("No_Data_Found_Message");
            Assert.assertTrue(verify.check_element_is_present("No_Data_Found_Message"), "'No data found' message is not displayed.");
            WebElement noDataElement = element.find("No_Data_Found_Message");
            System.out.println("No Data Message: " + noDataElement.getText());
        }
    }

    public void verify_data_select_range_of_CalenderInContainer() {
        wait.wait_for_second(2);
        if (verify.check_element_is_present("container_table_host_name")) {
            WebElement Host_Name = element.find("container_table_host_name");
            String hs= Host_Name.getText();
            Reporter.log(" Host Name "+ hs);
            Assert.assertTrue(verify.check_element_is_present("container_table_host_name"));
        } else {
            verify.check_element_is_present("No_Data_Found_Message");
            WebElement no_data = element.find("No_Data_Found_Message");
            String No_data= no_data.getText();
            Reporter.log(" No Data " + No_data);
            Assert.assertTrue(verify.check_element_is_present("No_Data_Found_Message"));
        }
    }

    public void vissible_no_data_found_TextDisplayed() {
        verify.check_element_is_present("No_Data_Found_Message");
    }

    public void verify_and_check_clickable_on_Host() {
        verify.check_element_is_present("Host_Tab");
        wait.wait_until_element_is_clickable("Host_Tab");
    }

    public void verify_and_check_clickable_on_Dashboard_Tab() {
        verify.check_element_is_present("Dashboard_Tab");
        wait.wait_until_element_is_clickable("Dashboard_Tab");
    }

    public void click_on_host_Tab() {
        wait.wait_for_second(2);
        element.click("Host_Tab");

    }
    public void visible_of_Infra_host_Header(){
        verify.check_element_is_present("Host_Tab");
        verify.check_element_is_present("Dashboard_Tab");
        verify.check_element_is_present("Quick_Filter");
        verify.check_element_is_present("Overview");
    }

    public void click_on_First_Host_Name_From_Host_Table() {
        element.click("Host_Name_Table");
    }

    public void verify_host_name_list_present_on_Page() {
        wait.wait_for_second(2);
        verify.check_element_is_present("Host_Name_Table");
        WebElement Host_Name = element.find("Host_Name_Table");
        System.out.println(" Host_Name : " + Host_Name.getText());

    }

    public void verify_with_mw_table_row_Count() {
        wait.wait_for_second(1);
        WebElement rowCountElement = element.find("mw_table_row_count");
        WebElement totalPageElement = element.find("mw_total_no_showing_page_count");
        int rowCount = Integer.parseInt(rowCountElement.getText().trim());
        int totalPage = Integer.parseInt(totalPageElement.getText().trim());
        Assert.assertTrue(rowCount > 0, "Row count should be greater than 0 but found: " + rowCount);
        Assert.assertTrue(totalPage > 0, "Total page count should be greater than 0 but found: " + totalPage);
        Assert.assertEquals(rowCount, totalPage, "Row count and total page count do not match.");
    }

    public void verify_element_visible_present_on_Page() {
        verify.check_element_is_present("Enable_Live_button");
        boolean update_button = verify.check_element_is_present("Update_button");
        Assert.assertTrue(update_button, "Update button is not present");
        verify.check_element_is_present("copy_button");
        verify.check_element_is_present("calender");
        verify.check_element_is_present("calender_back_button");
        verify.check_element_is_present("global_search");
        verify.check_element_is_present("customize_button");
        verify.check_element_is_present("Host_Name_Table");
    }

    public void click_on_live_Button() {
        WebElement firstColumnBeforeRefresh = element.find("Host_Name_Table");
        String firstColumnBeforeRef = firstColumnBeforeRefresh.getText().trim();
        element.click("Enable_Live_button");
        wait.wait_until_all_element_is_visible("Host_Name_Table");
        wait.wait_for_second(5);
        WebElement firstColumnAfterRefresh = element.find("Host_Name_Table");
        String firstColumnAfterRef = firstColumnAfterRefresh.getText().trim();
        Assert.assertEquals(firstColumnAfterRef, firstColumnBeforeRef, "Table data changed after refresh!");
    }

    public void click_on_refresh_Button() {
        wait.wait_for_second(1);
        element.click("Update_button");
        wait.wait_for_second(2);
        WebElement mw_table_row_count = element.find("mw_table_row_count");
        int rowCount = Integer.parseInt(mw_table_row_count.getText().trim());
        Assert.assertTrue(rowCount > 0, "Row count should be greater than 0 but found: " + rowCount);
    }

    public void click_on_copy_Button() {
        wait.wait_for_second(1);
        element.click("copy_button");
    }

    public void verify_url_copied_pop_up_MessageDisplayed() {
        wait.wait_until_element_is_visible("URL_Copied");
        verify.check_element_is_present("URL_Copied");
        wait.wait_for_second(5);
    }

    public void click_on_global_search_field() {
        wait.wait_for_second(1);
        element.click("global_search");
    }

    public void click_on_global_search_infra_container() {
        wait.wait_for_second(1);
        element.click("Search_global_text_field_container");
    }

    public void click_on_apply_filter_Button() {
        element.click("Apply_Filter_Button");
    }

    public void enter_text_host_name_global_infra_process_search_box(String name, String operator) throws InterruptedException {
        element.enter_text_global_infra_process("global_search", name, "name_operator_value", "operator_name", operator, "Host_Name_Table");
        wait.wait_for_second(2);
        element.click("Apply_Filter_Button");
        wait.wait_for_second(2);
        element.verify_with_applied_filter_to_table_data("apply_filter_info", "Host_Name_Table");
        element.click("clear_all");
    }

    public void enter_text_os_type_global_infra_process_search_box(String name, String operator) throws InterruptedException {
        element.enter_text_global_infra_process("global_search", name, "name_operator_value", "operator_name", operator, "Host_Name_Table");
        wait.wait_for_second(2);
        element.click("Apply_Filter_Button");
        wait.wait_for_second(2);
        element.verify_with_applied_filter_to_table_data("apply_filter_info", "Host_Name_Table");
        element.click("clear_all");
    }

    public void enter_invalid_host_name_in_global_search_box(String name, String operator, String value) {
        element.click("global_search");
        element.enter_text("global_search", name);
        wait.wait_for_second(2);
        List<WebElement >host_Name_Attribute= element.find_multiple_elements("name_operator_value");
        for(WebElement host_name:host_Name_Attribute){
            if(host_name.getText().equals(name)){
                host_name.click();
                break;
            }
        }
        wait.wait_for_second(2);
        List<WebElement> operatorList = element.find_multiple_elements("operator_name");
        for (WebElement ol : operatorList) {
            if (ol.getText().equals(operator)) {
                ol.click();
                break;
            }
        }
        wait.wait_for_second(2);
        element.enter_text("global_search", value);
        element.find("global_search").sendKeys(Keys.ENTER);
    }

    public void verify_No_Data_Found_MessageDisplayed() {
        verify.check_element_is_present("No_Data_Found_Message");
    }

    public void click_on_customize_button() {
        wait.wait_for_second(2);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("document.body.style.zoom='50%'");
        element.click("customize_button");
    }

    public void verify_customize_option_container_visible_present_on_Page() {
        wait.wait_for_second(2);
        List<WebElement> customize_container = element.find_multiple_elements("customize_column_option");
        for (WebElement container : customize_container) {
            Assert.assertTrue(container.isDisplayed());
        }
    }

    public void verify_customize_option_container_visible_present(String HostName) throws InterruptedException {
        wait.wait_for_second(2);
        List<WebElement> customize_container = element.find_multiple_elements("uncheck_customize_option_container");
        for (WebElement container : customize_container) {
            container.click();
        }
        wait.wait_for_second(2);
        element.click("customize_container_search_box");
        element.enter_text("customize_container_search_box", HostName);
        wait.wait_for_second(2);
        driver.findElement(By.xpath("(//span[@class=\"checkbox-label-content\"]/span)[2]")).click();
    }

    public void click_on_apply_changes_Button() {
        element.click("customize_container_apply_changes_button");
        Assert.assertTrue(verify.check_element_is_present("Host_Name_Table"));
    }

    public void verify_apply_filter_host_name_present_on_Page() {
        Assert.assertTrue(verify.check_element_is_present("Host_Name_Table"));
    }

    public void click_on_clear_all_Button() {
        wait.wait_for_second(2);
        element.click("customize_container_default_button");
        wait.wait_for_second(4);
    }

    public void verify_default_column_reset_default_State() {
        wait.wait_for_second(2);
        Assert.assertTrue(verify.check_element_is_present("uncheck_customize_option_container"));
    }

    public void click_on_cancel_button_customize_container() {
        wait.wait_until_element_is_visible("customize_container_cancel_button");
        element.click("customize_container_cancel_button");
    }

    public String store_data_before_sorting() {
        WebElement before_Shorting_data = element.find("Host_Name_Table");
        String before_shorting = before_Shorting_data.getText();
        System.out.println("Before shorting : " + before_shorting);
        return before_shorting;
    }

    public String store_container_data_before_sorting() {
        WebElement before_Shorting_data = element.find("container_table_first_row");
        String before_shorting = before_Shorting_data.getText();
        System.out.println("Before shorting : " + before_shorting);
        return before_shorting;
    }

    public void click_on_host_name_Header() {
        wait.wait_for_second(2);
        element.click("Host_Name_Table_Header");
    }

    public void click_on_container_table_Header() {
        wait.wait_for_second(2);
        element.click("container_table_header");
    }

    public void click_on_host_name_ascending_arrow_Button() {
        wait.wait_for_second(2);
        element.click("Host_Name_sort_ascending");
        wait.wait_for_second(2);
        element.click("Host_Name_sort_descending");
    }

    public void click_on_container_table_data_ascending_arrow_Button() {
        wait.wait_for_second(2);
        element.click("container_table_header");
    }

    public void verify_tool_tip_pop_up_Displayed() {
        wait.wait_for_second(1);
        verify.check_element_is_present("Tool_Tip");
    }

    public String verify_HostName_Sorting_List_In_AscendingOrder() {
        String beforeSorting = store_container_data_before_sorting();
        wait.wait_for_second(2);
        WebElement afterSortingData = element.find("Host_Name_Table");
        String afterSorting = afterSortingData.getText();
        System.out.println("After sorting: " + afterSorting);
        Assert.assertNotEquals(beforeSorting, afterSorting, "Sorting did not change the order!");
        return beforeSorting;
    }

    public String verify_container_table_data_Sorting_List_In_AscendingOrder() {
        String beforeSorting = store_data_before_sorting();
        wait.wait_for_second(2);
        WebElement afterSortingData = element.find("container_table_first_row");
        String afterSorting = afterSortingData.getText();
        System.out.println("After sorting: " + afterSorting);
        Assert.assertNotEquals(beforeSorting, afterSorting, "Sorting did not change the order!");
        return beforeSorting;
    }

    public void verify_host_name_sorting_list_in_descending_Order() {
        String after = verify_HostName_Sorting_List_In_AscendingOrder();
        WebElement AfterShorting_data = element.find("Host_Name_Table");
        String After_shorting = AfterShorting_data.getText();
        Assert.assertEquals(after, After_shorting);
    }

    public void check_Host_Name_PageDisplayed() {
        wait.wait_for_second(2);
        Assert.assertTrue(verify.check_element_is_present("Host_Name_Page"));
    }

    public void visible_UI_element_Of_Host_Info_Page_and_Value_Present_On_Page() {
        wait.wait_for_second(2);
        element.verify_the_list_of_options("Host_info_tab_content", "Host_info_tab_content_value", "Infrastructure.xlsx", "Sheet1", 1);
    }

    public void visible_System_Info_Header_and_value() {
        wait.wait_for_second(2);
        element.verifyTheListOfOption("Host_info_system_info_header","Host_info_system_info_header_value");
    }

    public void verify_graphs_are_displayed() {
        wait.wait_for_second(2);
        element.click("Metrics");
    }

    public void verify_containers_data_are_displayed() {
        wait.wait_for_second(2);
        element.click("Containers");
        try {
            WebElement total_no_container = element.find("Total_No_container");
            String total_container = total_no_container.getText().trim();
            int totalContainerInt = Integer.parseInt(total_container.replaceAll("[^0-9]", ""));
            List<WebElement> total_no_row_count = element.find_multiple_elements("Total_No_row_container");
            Assert.assertEquals(totalContainerInt, total_no_row_count.size());

        } catch (NumberFormatException e) {
            Assert.fail("Failed to convert total container count to an integer.");
        } catch (Exception e) {
            Assert.fail("Unexpected error occurred while verifying containers.");
        }
    }

    public void verify_processes_data_are_displayed() {
        wait.wait_for_second(2);
        element.click("Process");
        try {
            wait.fluent_wait_method_for_element("Total_No_container", 60, 5);
            WebElement total_no_processes = element.find("Total_No_container");
            String total_processes = total_no_processes.getText().trim();
            int totalProcessesInt = Integer.parseInt(total_processes.replaceAll("[^0-9]", ""));
            if (totalProcessesInt > 0) {
                System.out.println("Processes tab data are Successfully Loaded: " + totalProcessesInt);
            } else {
                System.out.println("Processes tab data are Not Loaded.");
            }
        } catch (NumberFormatException e) {
            Assert.fail("Failed to convert total process count to an integer.");
        } catch (Exception e) {
            Assert.fail("Unexpected error occurred while verifying processes.");
        }
    }

    public void verify_APM_data_are_displayed() {
        wait.wait_for_second(2);
        element.click("APM_Services");
        element.verify_ant_table_container_header("Total_No_header_container", "APM_Services_table_row_value");
    }

    public void hover_on_i_tag_pop_up_Displayed() {
        wait.wait_for_second(2);
        List<WebElement> tag_button = element.find_multiple_elements("host_tag_i_tag_button");
        for (WebElement button : tag_button) {
            actions.moveToElement(button).perform();
            wait.wait_for_second(1);
            WebElement toolTip = element.find("i_tag_tool_tip");
            String tooltipText = toolTip.getText().trim();
            System.out.println("Tooltip text: " + tooltipText);
        }
    }

    public void click_on_x_button_of_HostPage() {
        wait.wait_until_element_is_visible("x_button_close_host_page");
        element.click("x_button_close_host_page");
    }
    public void click_on_close_button_of_source_trend_log(){
        wait.wait_for_second(1);
        wait.wait_until_all_element_is_visible("close_button_log_trend_graph");
        element.click("close_button_log_trend_graph");
    }

    public void verify_x_button_of_HostPage_close() {
        Assert.assertFalse(verify.check_element_is_not_present("x_button_close_host_page"));
    }
    public void click_on_MetricsTab() {
        element.click("Metrics");
        wait.wait_for_second(5);
    }
    public void vissile_UI_element_Of_Metrics() {
        wait.wait_for_second(2);
        List<WebElement> UIElement = element.find_multiple_elements("Metrics_UI_element");
        for (WebElement el : UIElement) {
            if (!el.isDisplayed()) {
                ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", el);
                wait.wait_for_second(1);
            }

            boolean isVisible = el.isDisplayed();
            String elementText = el.getText().trim();
            Reporter.log("UI Element: " + elementText + " | Visible: " + isVisible,true);
            Assert.assertTrue(isVisible, "Metrics UI Element '" + elementText + "' is not visible!");
        }

    }

    public void hover_on_element_and_click(String locator_key1, String locator_key2, String locator_key3) {
        actions.moveToElement(element.find(locator_key1)).perform();
        actions.moveToElement(element.find(locator_key2)).perform();
        element.click(locator_key2);
        List<WebElement> filterBy = element.find_multiple_elements(locator_key3);
        for (WebElement filter : filterBy) {
            element.click(locator_key3);
        }

    }

    public void verify_graph_time_with_actualTime(int graphIndex, int amount, String timeUnit) {
        boolean isTimeValid = element.verifyGraphTimeWithActualTime(graphIndex, amount, timeUnit);
        if (isTimeValid) {
            System.out.println("✅ Time is within range. Proceeding to hover over the logs graph.");

        } else {
            Assert.fail("❌ Timestamps are out of range. Test failed.");
        }
    }

    public void verify_graph_Data(int graphIndex) {
        element.validate_graphs_data(graphIndex);
    }

    public void click_on_customize_container_apply_changes_button() {
        wait.wait_for_second(2);
        element.click("customize_container_apply_changes_button");
        wait.wait_for_second(2);
    }

    public void cpu_usage_present_on_page() {
        wait.wait_for_second(2);
        wait.wait_until_element_is_visible("cpu_usage");
        WebElement cpu_usage = element.find("cpu_usage");
        System.out.println("CPU Usage " + cpu_usage.getText());
        hover_on_element_and_click("cpu_usage", "cpu_usage_filter_button", "check_box");
    }

    public void enter_text_in_cpu_usage_filter_Search_box() throws InterruptedException {
        for (int i = 0; i <= 1; i++) {
            String cpuText = "cpu" + i;
            System.out.println("Executing for: " + cpuText);
            element.click("filter_by_search");
            wait.wait_for_second(2);
            element.enter_text_filter_by_search_box("filter_by_search", cpuText, "checkbox_label_content", 1, "cpu_usage", "cpu_usage_filter_button");
        }
    }

    public void click_on_expand_button_on_cpu_Usage() {
        element.hover_on_expand_button_and_click("cpu_usage", "expand_button_cpu_usage");
    }


    public void verify_graph_expand_successfully() {
        wait.wait_for_second(2);
        Assert.assertTrue(verify.check_element_is_present("chart_expand"));
    }

    public void No_Data_found_IsVissible(String text) {
        element.refresh_Until_No_Data_Message_Disappears_Then_Click_Metrics("No_Data_Found_Message", text);
    }
    public void click_on_host_name_Tables_and_Containers() {
        List<WebElement> host_name_column = element.find_multiple_elements("Host_Table");
        int host_name_count = host_name_column.size();
        for (int i = 0; i < host_name_count; i++) {
            host_name_column = element.find_multiple_elements("Host_Table");
            host_name_column.get(i).click();
            element.click("Containers");
            boolean noDataFound = driver.findElements(By.xpath("//span[@title=\"No data found for selected time period.\"]")).size() > 0;
            if (noDataFound) {
                wait.wait_for_second(2);
                driver.navigate().refresh();
                wait.wait_for_second(3);
                element.click("Containers");
                noDataFound = driver.findElements(By.xpath("//span[@title=\"No data found for selected time period.\"]")).size() > 0;
            }
            if (noDataFound) {
                wait.wait_for_second(2);
                element.click("Back_button_Host_Tab");
            } else {
                wait.wait_for_second(2);
                break;
            }
        }
    }
public void hover_on_each_graph_and_verify_tool_tip() {
    wait.wait_until_all_element_is_visible("i_icon_each_graph");
    List<WebElement> i_icon_each_graph = element.find_multiple_elements("i_icon_each_graph");

    for (int i = 0; i <= 9 && i < i_icon_each_graph.size(); i++) {
        WebElement ele = i_icon_each_graph.get(i);
        actions.moveToElement(ele).perform();
        wait.wait_for_second(1);

        wait.wait_until_element_is_visible("tool_tip_i_icon_each_graph");
        WebElement hover_Text = element.find("tool_tip_i_icon_each_graph");
        System.out.println("Tooltip text: " + hover_Text.getText().trim());

        // Scroll after index 9 if next element exists (this block won't run since i == 9 is max)
        if (i == 9 && i + 1 < i_icon_each_graph.size()) {
            WebElement nextEle = i_icon_each_graph.get(i + 1);
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", nextEle);
            wait.wait_for_second(2);
        }
    }

}



    public void verifY_clicking_on_each_graph() throws InterruptedException {
        wait.wait_for_second(1);
        for (String Expand_Each_Graph : EXPAND_EACH_GRAPH) {
            boolean isGraphExpanded = false;
            int scrollAttempts = 0;

            while (!isGraphExpanded && scrollAttempts < 5) {
                try {
                    WebElement graphElement = driver.findElement(By.xpath("//div[contains(text(),'" + Expand_Each_Graph + "')]/parent::div"));

                    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center', inline: 'nearest'});", graphElement);
                    wait.wait_for_second(1);

                    if (graphElement.isDisplayed()) {
                        actions.moveToElement(graphElement).perform();
                        wait.wait_for_second(1);

                        WebElement expandButton = driver.findElement(By.xpath("//div[contains(text(),'" + Expand_Each_Graph + "')]/parent::div//button[@class='action-button-chart']"));
                        expandButton.click();
                        wait.wait_for_second(1);

                        element.click("graph_expand_close_button");
                        isGraphExpanded = true;
                    }
                } catch (Exception e) {
                    scrollAttempts++;
                }
            }
        }
    }

    public void verify_the_Transform_Graph_Options_IsDisplayed() {
        verify.check_element_is_present("Transform_Graph");
        List<WebElement> transform_graph_options = element.find_multiple_elements("Transform_Graph_options");
        for (WebElement transform_graph_option : transform_graph_options) {
            boolean transform_graph = transform_graph_option.isDisplayed();
            Assert.assertTrue(transform_graph);
        }
        for (int i = 0; i < transform_graph_options.size(); i++) {
            transform_graph_options.get(i).click();
            wait.wait_for_second(1);
            wait.fluent_wait_method_for_element("Forecast", 60, 5);
            verify.check_element_is_present("Forecast");
        }
    }

    public void verify_compare_to_previous_page_present_on_UI() {
        verify.check_element_is_present("compare_to_previous");
    }

    public void verify_compare_to_previous_options_ISDisplayed() {
        List<WebElement> compare_to_previous = element.find_multiple_elements("compare_to_previous_hour_day_week_month");
        for (WebElement compare_to_previous_option : compare_to_previous) {
            boolean compare_to_pre = compare_to_previous_option.isDisplayed();
            Assert.assertTrue(compare_to_pre);
        }
        for (int i = 0; i < compare_to_previous.size(); i++) {
            wait.wait_for_second(5);
            compare_to_previous.get(i).click();
            wait.wait_for_second(5);
            element.hover_on_graphs("graph_data", "tool_tip_graph");
        }
    }

    public void click_on_container_Tab() {
        wait.wait_for_second(2);
        element.click("Containers");
        WebElement tabElement = element.find("Containers");
        String classAtt= tabElement.getText();
        if(classAtt.contains("Containers"))
        {
            Reporter.log(" User Navigate Containers Tab is Highlighted",true);
        }
        else{
            Reporter.log("Tab is not Highlighted",true);
        }
    }


    public void verify_UI_element_present_on_page() {
        WebElement search_global_text_field = element.find("Search_global_text_field_container");
        String placeHolder = search_global_text_field.getAttribute("placeholder");
        Assert.assertEquals(placeHolder, "Search by name, tag, label or annotation",
                "Placeholder text is incorrect or not visible.");
        verify.check_element_is_present("customize_button");
        verify.check_element_is_present("Ai_search_icon");
    }

    public void verify_UI_element_of_processes_present_on_page() {
        WebElement search_global_text_field = element.find("search_global_text_filed");
        String placeHolder = search_global_text_field.getAttribute("placeholder");
        Assert.assertEquals(placeHolder, "Search by name, tag, label or annotation",
                "Placeholder text is incorrect or not visible.");
        verify.check_element_is_present("customize_button");
        verify.check_element_is_present("Ai_search_icon");
    }

    public void click_on_global_search_of_container() {
        wait.wait_for_second(2);
        element.click("search_global_text_filed");
    }

    public void click_on_global_search_of_processes() {
        wait.wait_for_second(2);
        element.click("search_global_text_filed");
    }
    public void verify_Ai_Search_bar() {
    for (String AI_Search : AI_SEARCH_BAR) {
        element.enter_text("search_global_text_filed", AI_Search);
        wait.wait_for_second(1);

        List<WebElement> options = element.find_multiple_elements("name_operator_value");
        Assert.assertTrue(options.size() > 0, "No dropdown options found for input: " + AI_Search);

        boolean relevantSuggestionFound = false;

        for (WebElement option : options) {
            if (option.isDisplayed()) {
                String suggestionText = option.getText().trim().toLowerCase();
                Reporter.log("Suggestion found: " + suggestionText);

                if (!suggestionText.isEmpty() && suggestionText.contains(AI_Search.toLowerCase())) {
                    relevantSuggestionFound = true;
                    break;
                }
            }
        }

        Assert.assertTrue(relevantSuggestionFound, "No relevant suggestions containing keyword '" + AI_Search + "' found.");
        element.clear_text_field("search_global_text_filed");
    }
}

    public void enter_invalid_host_name_in_global_search(String name, String operator, String value) throws InterruptedException {
        element.enter_invalid_host_name_in_global_search_box("search_global_text_filed", name, "name_operator_value", "operator_name", operator, value);
    }

    public void click_on_customize_container_Button() {
        wait.wait_for_second(1);
        element.click("customize_container_button");
    }
    public void click_on_customize_container_filter_Button() {
        wait.wait_for_second(1);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("document.body.style.zoom='50%'");
        element.click("customize_container_button");
    }

    public void verify_correct_data_Display() throws InterruptedException {
        element.verify_correct_data_display_on_Table("container_table_header_list", "container_table_header_row_data");
    }

    public void click_on_processes_Tab() {
        wait.wait_for_second(2);
        element.click("Process");
    }

    public void verify_processes_data_are_Displayed() {
        WebElement process_table = element.find("Total_No_container");
        String valueStr = process_table.getText().trim();
        int value = Integer.parseInt(valueStr);
        Assert.assertTrue(value > 0, "Process count should be greater than 0 but found: " + value);
    }

    public void verify_and_uncheck_option_from_customize_container() {
        wait.wait_for_second(2);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        List<WebElement> uncheck = element.find_multiple_elements("uncheck_customize_option_container");
        for (WebElement uncheckOption : uncheck) {
            try {
                js.executeScript("arguments[0].scrollIntoView(true);", uncheckOption);
                wait.wait_for_second(1);
                if (uncheckOption.isDisplayed() && uncheckOption.isEnabled()) {
                    uncheckOption.click();
                }
            } catch (Exception e) {
                System.out.println("Failed to uncheck option: " + e.getMessage());
            }
        }
        wait.wait_for_second(2);
        WebElement apply_button = element.find("customize_container_apply_changes_button");
        if (!apply_button.isEnabled()) {
            System.out.println("Apply button is Disabled");
        }
    }
    public void verify_and_check_option_from_customize_container() {
        List<WebElement> uncheck = element.find_multiple_elements("uncheck_customize_option_container");
        for (WebElement uncheckOption : uncheck) {
            try {
                if (uncheckOption.isDisplayed() && uncheckOption.isEnabled()) {
                    String uncheckOptionlist= uncheckOption.getText();
                    Reporter.log("check option List "+uncheckOptionlist,true);
                }
            } catch (Exception e) {
                System.out.println("Failed to uncheck option: " + e.getMessage());
            }
        }
        wait.wait_for_second(2);
        WebElement apply_button = element.find("customize_container_apply_changes_button");
        if (apply_button.isEnabled()) {
            System.out.println("Apply button is Enabled");
        }
    }

    public void checked_options_from_customize_container() {
        wait.wait_until_element_is_visible("select_customize_option_container");
        List<WebElement> checked = element.find_multiple_elements("select_customize_option_container");
        for (WebElement checked_option : checked) {
            checked_option.click();
        }
    }

    public void verify_process_data_are_displayed() {
        try {
            List<WebElement> total_no_row_count = element.find_multiple_elements("Total_No_row_container");
            WebElement total_no_container = element.find("showing_page_count");
            String fullText = total_no_container.getText();
            String[] parts = fullText.split("-");
            String lastNumber = parts[1];
            System.out.println("Last number: " + lastNumber);
//            WebElement showing_page = element.find("showing_page_count");
//            String text= showing_page.getText();
//            String numberAfterOf = text.replaceAll(".*of\\s+(\\d+)", "$1");

        //    System.out.println("Number after 'of': " + numberAfterOf);
            int totalContainerInt = Integer.parseInt(lastNumber.replaceAll("[^0-9]", ""));
            Assert.assertEquals(totalContainerInt, total_no_row_count.size());

        } catch (NumberFormatException e) {
            Assert.fail("Failed to convert total container count to an integer.");
        } catch (Exception e) {
            Assert.fail("Unexpected error occurred while verifying containers.");
        }
    }

    public String  click_on_first_processes_id_table() {
        wait.wait_until_element_is_visible("processes_id_table");
        String Executable_Name =  element.get_element_text("processes_id_table");
        element.click("processes_id_table");
        return Executable_Name;
    }

    public void verify_processes__page_visible() {
        wait.wait_for_second(1);
        verify.element_is_present("processes_id_info_page");
    }

    public void enter_customize_container_options_in_SearchBox() {
        wait.wait_for_second(1);
        element.click("customize_container_search_box");
        for (String cco : CUSTOMIZE_CONTAINER_OPTIONS) {
            wait.wait_for_second(2);
            element.enter_text("customize_container_search_box", cco);
            wait.wait_for_second(2);
            element.click("Select_customize_option_container");
            wait.wait_for_second(2);
            element.clear_text_field("customize_container_search_box");
        }
    }

    public void enter_customize_container_option_in_SearchBox(String text) {
        wait.wait_for_second(3);
        element.click("customize_container_search_box");
        for (String cco : CUSTOMIZE_CONTAINER_OPTIONS) {
            if (cco.equalsIgnoreCase(text)) {
                element.enter_text("customize_container_search_box", text);
                break;
            }
        }
        //   element.click("Select_customize_option_container");
    }

    public void click_on_select_customize_option_container() {
        wait.wait_for_second(2);
        element.click("Select_customize_option_container");
    }
    public void unselect_multiple_options_from_drop_Down(){
        element.click_on_multiple_elements("uncheck_customize_option_container");
    }

    public void verify_operating_system_display_on_page() {
        element.verify_single_option_and_value("process_table_operating_system_header","process_info_page_operating_system");
    }

    public void verify_cpu_utilization_value_display_on_process_info_page() {
       element.verify_single_option_and_value("process_table_cpu_utilization_header","process_info_page_cpu_utilization");
    }
    public void verify_memory_usage_value_display_on_process_info_page() {
        element.verify_single_option_and_value("process_table_memory_usage_percentage_header","process_info_page_memory_usage_value");
    }
    public void verify_DISK_IO_display_on_process_info_page() {
        element.verify_single_option_and_value("process_table_DISH_IO_header","process_info_page_DISH_IO_value");
    }
    public void verify_physical_usage_display_on_process_info_page() {
        element.verify_single_option_and_value("process_table_physical_usage_data_header","process_info_page_physical_usage_data_value");
    }

    public void verify_Virtual_Usage_display_on_process_info_page() {
        element.verify_single_option_and_value("process_table_Virtual_Usage_header","process_info_Virtual_Usage_value");
    }

    public void verify_Host_Name_display_on_process_info_page() {
        element.verify_single_option_and_value("process_table_Host_Name_header","process_info_Host_Name_value");
    }
    public void verify_Processes_ID_display_on_process_info_page() {
        element.verify_single_option_and_value("process_table_PID_header","process_info_PID_value");
    }
    public void verify_Processes_OWNER_display_on_process_info_page() {
        element.verify_single_option_and_value("process_table_OWNER_header","process_info_Process_owner_value");
    }
    public void verify_full_command_details_on_process_info_page() {
        element.verify_single_option_and_value("process_table_Full_Command_header","process_info_full_command_value");
    }

    public void verify_Process_owner_display_on_process_info_page() {
        wait.wait_for_second(2);
        WebElement processes_owner_value = element.find("process_info_Process_owner_value");
        WebElement full_command = element.find("process_info_full_command_value");
        if (processes_owner_value.isDisplayed() || full_command.isDisplayed()) {
            Assert.assertTrue(processes_owner_value.isDisplayed());
            Assert.assertTrue(full_command.isDisplayed());
        }
        String Owner_name = processes_owner_value.getText();
        String Full_Command = full_command.getText();
        Reporter.log("Processes Owner : " + Owner_name + " Full Command : " + Full_Command, true);
    }
    public String verify_host_name_present_on_page() {
        WebElement host_Name = element.find("container_Host_Names");
        String hostName = host_Name.getText();
        System.out.println(hostName);
        return hostName;
    }
        public void enter_text_in_search_field(String Host_Text, String single_operators) throws InterruptedException {
        String value = verify_host_name_present_on_page();
        element.enter_text_in_search_field("search_global_text_filed", Host_Text, "name_operator_value", "name_operator_value", single_operators);
        wait.wait_for_second(2);
        element.enter_text("search_global_text_filed",value);
    }

    public void click_on_full_command() {
       wait.wait_until_element_is_visible("process_info_full_command_copy");
       element.click("process_info_full_command_copy");
    }
    public void verify_full_command_copied_correctly(){
        wait.wait_until_element_is_visible("full_command_copied");
        verify.element_is_present("full_command_copied");
    }

    public void click_on_process_info_Metrics_Tab() {
        wait.wait_for_second(2);
        element.click("process_info_Metrics_Tab");
        wait.wait_for_second(5);
    }
    public void verify_applied_filter_not_present(){
        verify.check_element_is_not_present("clear_filter");
    }

    public void click_on_process_info_Logs_Tab() {
        wait.wait_for_second(2);
        element.click("process_info_Logs_Tab");
    }
    public void click_on_Logs_Tab() {
        element.click("Logs");
    }
    public void verify_UI_element_present_on_Logs_Tabs(){
        verify.element_is_present("Back_button_Host_Tab");
        verify.element_is_present("Source_Log_Trend");
        verify.element_is_present("Logs_Export_Button");
        List<WebElement >log_header= element.find_multiple_elements("Logs_Table_header");
        for(WebElement log_header_part:log_header){
            Reporter.log("Log Header: " + log_header_part.getText(),true);
        }
    }
    public void click_on_host_name_Table() {
        List<WebElement> host_name_column = element.find_multiple_elements("Host_Table");
        int host_name_count = host_name_column.size();

        for (int i = 0; i < host_name_count; i++) {
            host_name_column = element.find_multiple_elements("Host_Table");
            host_name_column.get(i).click();
            element.click("Logs");

            boolean noDataTrend = driver.findElements(By.xpath("//div[text()='Source Log Trend']/ancestor::div[contains(@class,'mw-card-v2')]//span[text()='No data found for selected time period.']")).size() > 0;
            boolean noDataTable = driver.findElements(By.xpath("//span[text()='Date']/ancestor::div[@class=\"ant-table-container\"]/child::div[@class=\"ant-table-body\"]//tr[@class=\"ant-table-placeholder\"]//span[text()='No data found for selected time period.']")).size() > 0;

            if (noDataTrend) {
                wait.wait_until_element_is_visible("Logs");
                element.click("Logs");
                noDataTrend = driver.findElements(By.xpath("//div[text()='Source Log Trend']/ancestor::div[contains(@class,'mw-card-v2')]//span[text()='No data found for selected time period.']")).size() > 0;
                noDataTable = driver.findElements(By.xpath("//span[text()='Date']/ancestor::div[@class=\"ant-table-container\"]/child::div[@class=\"ant-table-body\"]//tr[@class=\"ant-table-placeholder\"]//span[text()='No data found for selected time period.']")).size() > 0;
            }

            if (noDataTrend || noDataTable) {
                wait.wait_until_element_is_visible("Back_button_Host_Tab");
                element.click("Back_button_Host_Tab");
            } else {
                wait.wait_for_second(2);
                break;
            }
        }
    }

    public void hover_on_graph(){
        element.hover_on_graphs("info_graph","total_logs_info");
    }
    public void verify_date_and_Time(){
       WebElement Date_and_Time= driver.findElement(By.xpath("//button[@data-testid=\"panel-datepicker-infra-host\"]//span[@class='btn-text']"));
        String Date_and_Time_value = Date_and_Time.getText();
        System.out.println("Date and Time: " + Date_and_Time_value);
        String[] dateParts= Date_and_Time_value.split("-");
        String startDateStr = dateParts[0];
        String endDateStr = dateParts[1];
      //  System.out.println("Start Date: " + startDateStr);
      //  System.out.println("End Date: " + endDateStr);
        String[] startDateParts = startDateStr.split(" ");
        String startMonthDate = startDateParts[0] + " " + startDateParts[1];

        String[] endDateParts = endDateStr.split(" ");
        String endMonthDate = endDateParts[0] + " " + endDateParts[1];

        System.out.println("Start Month-Date: " + startMonthDate);
        System.out.println("End Month-Date: " + endMonthDate);

        WebElement table_date_and_Time=  driver.findElement(By.xpath("((//tbody[@class=\"ant-table-tbody\"])[2]//tr[position() > 1]//td)[1]//span[@class=\"cor-text\"]"));
        String[] table_Date_and_Time_value = table_date_and_Time.getText().split(" ");
        String datePart = table_Date_and_Time_value[0] + " " + table_Date_and_Time_value[1];
        System.out.println(datePart);
    }
    public void verify_Logs_present_inside_the_table() throws InterruptedException {
        element.verify_correct_data_display_on_Table("Logs_Table_header","Logs_Table_data");
    }
    public void expand_Logs_Table(){
        element.click("Logs_table_plus_button");
        wait.wait_for_second(2);
        element.find("Logs_table_expand");
        Assert.assertTrue( element.find("Logs_table_expand").isDisplayed(),"Logs table Not Expand");
    }
    public void verify_host_Name_present_inside_Logs_table() throws InterruptedException {
        String Logs_Host_Name = element.get_element_text("Logs_Host_Name");
        String json_value_host_Name= element.get_element_text("json_value_host_name");
        Assert.assertEquals(Logs_Host_Name,json_value_host_Name);
        element.verify_correct_data_display_on_Table("json_key_value","json_value");
    }
    public void scroll_to_bottom_of_logs_table() {
        try {

            WebElement scrollableLogs= element.find("scroll_down");
            Actions actions = new Actions(driver);
            actions.moveToElement(scrollableLogs).perform();
            wait.wait_for_second(1);
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].scrollTop = 5000;", scrollableLogs);
            wait.wait_for_second(1);

        } catch (Exception e) {
            System.out.println("Failed to scroll logs table: " + e.getMessage());
        }
    }
    public void verify_total_logs_with_actual_Logs(){
        String total_Logs= element.get_element_text("Total_logs");
        System.out.println("Total Logs"+total_Logs);
        String[] split_part= total_Logs.split(": ");
        String Total_value = split_part[1];
        String actual_Logs=element.get_element_text("Actual_logs");
        System.out.println("Actual Logs"+actual_Logs);
        String[] split_part_text = actual_Logs.split(": ");
        String Info_Value= split_part_text[1];
        Reporter.log(" INFO " + Info_Value + " Total " + Total_value);
        Assert.assertEquals(Total_value,Info_Value);
    }
    public void click_on_download_button_of_Logs(){
        wait.wait_for_second(2);
        WebElement download_button= element.find("download_logs_button");
        if(download_button.isDisplayed()) {
            wait.wait_for_second(2);
            element.click("download_logs_button");
            Reporter.log("REPORT Downloaded SUCCESSFUL", true);
        }

    }
    public String verify_showing_result_of_Pagination(){
        String showing_result_pagination_before= element.get_element_text("showing_result_logs_table");
        Reporter.log("Before Showing " + showing_result_pagination_before);
        String range_1_50 = showing_result_pagination_before.replaceAll(".*?([\\d]+-[\\d]+).*", "$1");
        return range_1_50;
    }
    public void click_on_next_button_of_Pagination(){
        element.click("next_button_pagination");
        wait.wait_for_second(2);
        String showing_result_pagination_after= element.get_element_text("showing_result_logs_table");
        Reporter.log("After Showing "+ showing_result_pagination_after, true);
        String range_51_100 = showing_result_pagination_after.replaceAll(".*?([\\d]+-[\\d]+).*", "$1");
        Assert.assertNotEquals("Pagination range should have changed after clicking next", verify_showing_result_of_Pagination(), range_51_100);
    }
    public void click_on_host_name_Tables_and_APM_Services() {
        List<WebElement> host_name_column = element.find_multiple_elements("Host_Table");
        int host_name_count = host_name_column.size();
        for (int i = 0; i < host_name_count; i++) {
            host_name_column = element.find_multiple_elements("Host_Table");
            host_name_column.get(i).click();
            element.click("APM_Services");
            boolean noDataFound = driver.findElements(By.xpath("//span[@title=\"No data found for selected time period.\"]")).size() > 0;
            if (noDataFound) {
                element.click("APM_Services");
                noDataFound = driver.findElements(By.xpath("//span[@title=\"No data found for selected time period.\"]")).size() > 0;
            }
            if (noDataFound) {
                element.click("Back_button_Host_Tab");
            } else {
                break;
            }
        }
    }
    public void verify_UI_element_APM_Services(){
        verify.element_is_present("service_list");
        verify.element_is_present("customize_container_button");
        verify.element_is_present("table_help_button");
    }
    public void verify_and_click_on_Host_Name_in_UP_State() throws InterruptedException {
       element.verify_and_click_on_Host_Name_in_UP_State("Host_Names","Resource_State");
    }
    public void click_on_APM_Services(){
        wait.wait_for_second(2);
        element.click("APM_Services");
    }
    public void check_data_is_present_on_UI() {
        List<String> timeOptions = Arrays.asList("Past 5 minutes", "Past 15 minutes", "Past 3 hours", "Past 12 hours", "Past day", "Past 2 days", "Past week");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        for (String option : timeOptions) {
            try {
                boolean isNoDataVisible = driver.findElements(By.xpath("//*[contains(text(),'No data found for selected time period.')]")).size() > 0;
                if (isNoDataVisible) {
                    WebElement dropdownButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//button[contains(@data-testid,\"datepicker\")]//*[name()='svg'])[2]")));
                    dropdownButton.click();
                    WebElement timeOption = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(text(),'" + option + "')]")));
                    timeOption.click();
                    Thread.sleep(3000);
                    boolean isStillNoData = driver.findElements(By.xpath("//*[contains(text(),'No data found for selected time period.')]")).size() > 0;
                    if (!isStillNoData) {
                        System.out.println("Data appeared after selecting time period: " + option);
                        break;
                    }
                } else {
                    System.out.println("Data already present, no need to change time period.");
                    break;
                }
            } catch (Exception e) {
                System.out.println("Exception occurred while selecting time period: " + option);
                e.printStackTrace();
            }
        }
    }
    public Map<String, String> verify_the_APM_Service_Data() {

        List<WebElement> ant_table_container = element.find_multiple_elements("APM_service_header");
        List<WebElement> ant_table_container_value = element.find_multiple_elements("APM_service_value");

        JavascriptExecutor js = (JavascriptExecutor) driver;

        Map<String, String> apmServiceData = new HashMap<>();

        for (int i = 0; i < ant_table_container.size(); i++) {
            WebElement headerElement = ant_table_container.get(i);

            if (!headerElement.isDisplayed()) {
                js.executeScript("arguments[0].scrollIntoView({inline: 'center'});", headerElement);
                wait.wait_for_second(1);
            }

            String optionText = headerElement.getText().trim();
            String optionValue = "Not Found";

            try {
                if (i < ant_table_container_value.size()) {
                    WebElement valueElement = ant_table_container_value.get(i);

                    if (!valueElement.isDisplayed()) {
                        js.executeScript("arguments[0].scrollIntoView({inline: 'center'});", valueElement);
                        wait.wait_for_second(1);
                    }

                    optionValue = valueElement.getText().trim();
                }
            } catch (Exception e) {
                Reporter.log("No value found for: " + optionText, true);
            }

            Reporter.log("UI Text: " + optionText + " | Value: " + optionValue, true);
            apmServiceData.put(optionText, optionValue);
        }

        return apmServiceData;
    }

    public void verify_searched_column_IsVisible(String Text) throws InterruptedException {
        verify.verifyDropdownContainsSearchText("customize_container_search_box",Text,"Customize_column_option");
    }

    public void click_on_calender_menu_button(){
        element.click("Infra_calendar_Menu");
    }
    public void No_details_found(){
        wait.wait_for_second(2);
        verify.element_is_present("No_details_found");
    }
    public void click_on_date_picker_previous_button(){
        wait.wait_for_second(2);
        element.click("date_picker_previous_button");
    }
    public void click_on_date_picker_forward_button(){
        wait.wait_for_second(2);
        element.click("date_picker_forward_button");
    }
    public String get_Request_value_from_APM_table() {
        wait.wait_for_second(2);
        String Requests_Value = element.get_element_text("APM_table_Requests_value");
        Reporter.log(" Requests Value "+Requests_Value);
        return Requests_Value;
    }
    public void click_on_service_table(){
        element.click("APM_service_table");
    }

    public void verify_Request_display_on_service_info_page() {
        String Request_value = element.get_element_text("service_info_Requests_value");
        Reporter.log(" Service Info " + Request_value, true);
        Assert.assertEquals(get_Request_value_from_APM_table(), Request_value);
    }
    public void verify_APM_table_after_clicking_on_cancel_button() {
        wait.wait_for_second(2);
        String Request_Value= element.get_element_text("APM_table_Requests_value");
        Assert.assertEquals(get_Request_value_from_APM_table(),Request_Value);
    }
    public void click_on_processes_check_data_isPresent() throws InterruptedException {
        element.click_on_host_name_Tables_with_data("Host_Table","Process","Back_button_Host_Tab");
    }
    public void verify_and_click_table_help_Button(){
        verify.element_is_present("table_help_button");
        element.click("table_help_button");
        wait.wait_for_second(1);
        element.click("table_help_close_button");
    }
    public void drag_and_rearrange(){
        // //th[contains(.,'Service')]
        // //th[contains(.,'Type')]
        // (//span[@class="react-resizable-handle"])[1]
        WebElement service= driver.findElement(By.xpath("//th[@aria-label=\"Host Name\"]//span[@class=\"dragHandler \"]//span[@class=\"ant-table-column-title\"]"));
        WebElement type= driver.findElement(By.xpath("//th[@aria-label=\"Memory Utilization\"]//span[@class=\"dragHandler \"]//span[@class=\"ant-table-column-title\"]"));
        //actions.clickAndHold(service).moveToElement(type).pause(Duration.ofMillis(500)).release().build().perform();
     //   actions.dragAndDropBy(service,300,0).build().perform();
     //   actions.dragAndDrop(service,type).build().perform();
     //      actions.clickAndHold(service).moveByOffset(100,0).release().build().perform();
        actions.clickAndHold(service)
                .moveToElement(type)
                .moveByOffset(100, 0)
                .release()
                .build()
                .perform();

    }
    public void click_on_back_button_of_Host_Name(){
        element.click("Back_button_Host_Tab");

    }
    public void expand_logs_graph(){
        wait.wait_for_second(2);
        element.hover_on_expand_button_and_click("Source_Log_Trend","Expand_source_trend_log");
    }
    public void verify_source_trend_log_on_page() {
        wait.wait_for_second(2);
        wait.wait_until_element_is_visible("Source_Log_Trend");
        hover_on_element_and_click("Source_Log_Trend", "Source_Log_Trend_filter_button", "check_box");
    }
    public String get_data_from_search_box(){
        String INFO= element.get_element_text("mv_popover_content");
        return INFO;
    }
    public void click_on_search_button_enter_text(){
        wait.wait_for_second(2);
        String info= get_data_from_search_box();
        element.click("search_box_content");
        element.enter_text("search_box_content",info);
        element.click("mv_popover_content");
        element.click("Source_Log_Trend");
    }

}





