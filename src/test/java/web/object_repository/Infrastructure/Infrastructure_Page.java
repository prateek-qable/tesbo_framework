package web.object_repository.Infrastructure;
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

public class Infrastructure_Page {
    WebDriver driver = null;
    Element element = null;
    Verify verify = null;
    Wait wait = null;
    Window window = null;
    //DataReaders dataReaders = new DataReaders();
    Actions actions = null;
    WebDriverWait waitForElement = null;

    public Infrastructure_Page(WebDriver driver) {
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

    public void verify_and_click_on_Infrastructure() {
        verify.check_element_is_present("Infrastructure_Menu");
        element.click("Infrastructure_Menu");
    }

    public void verify_and_check_clickable_on_Host() {
        verify.check_element_is_present("Host_Tab");
        wait.wait_until_element_is_clickable("Host_Tab");
    }

    public void click_on_apm_service_customize_button() {
        element.click("APM_SERVICE_customize_button");
    }

    public void check_on_no_data_found_IsVissible() {
        while (true) {
            if (!isElementPresent()) {
                break;
            }
            element.click("calender_forward_button");
        }
    }

    private boolean isElementPresent() {
        try {
            WebElement noDataElement = element.find("No_data_found_for_selected_time_period");
            return noDataElement.isDisplayed();
        } catch (NoSuchElementException | StaleElementReferenceException e) {
            return false;
        }
    }
   public void No_Data_found_IsVissible() {
       element.refresh_Until_No_Data_Message_Disappears_Then_Click_Metrics("No_data_found_for_selected_time_period","metrics");
   }

//    public void verify_option_container_List() {
//        wait.wait_for_second(2);
//        List<WebElement> option_container = element.find_multiple_elements("Customize_option_container");
//        List<String> optionTextList = new ArrayList<>();
//        for (WebElement option : option_container) {
//            optionTextList.add(option.getText().trim());
//        }
//        List<String> expectedoptioncontainer = dataReaders.readExcelData("Infrastructure.xlsx", "Sheet1", 0);
//        for (String uiText : optionTextList) {
//            Assert.assertTrue(expectedoptioncontainer.contains(uiText), "UI Text not found in Excel: " + uiText);
//        }
//    }

    public void click_on_option_container_apply_button() {
        element.click("Apply_Button");
        wait.wait_for_second(2);
    }


    public void enter_text_search_box(String name, String operator) {
        String value= verify_host_name_present_on_page();
        element.click("search_by_name_tag_label_box");
        wait.wait_for_second(2);
        element.enter_text("search_by_name_tag_label_box", name);
        wait.wait_for_second(5);
        List<WebElement >operator_value= element.find_multiple_elements("name_operator_value");
        for (WebElement ov : operator_value) {
            if(ov.getText().equals("host.name"))
            {
                ov.click();
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
        wait.wait_for_second(5);
        List<WebElement> valueList = element.find_multiple_elements("operator_name");
        for (WebElement vl : valueList) {
            if (vl.getText().equals(value)) {
                wait.wait_for_second(3);
                vl.click();
                break;
            }
        }
        wait.wait_for_second(3);
    }

    public void enter_text_host_name_global_infra_process_search_box(String name, String operator) throws InterruptedException {
        element.enter_text_global_infra_process("search_by_name_tag_label_box", name, "name_operator_value", "operator_name", operator, "Operating_Systems");
        wait.wait_for_second(2);
        element.click("Apply_Filter_Button");
        wait.wait_for_second(2);
        element.verify_with_applied_filter_to_table_data("apply_filter_info", "Operating_Systems");
        element.click("clear_all");
    }

    public void enter_text_global_infra_process(String name, String operator) {
        String value = verify_host_name_present_on_page();
        element.click("global_search_infra_process");
        wait.wait_for_second(2);
        element.enter_text("global_search_infra_process", name);
        wait.wait_for_second(5);
        element.click("name_operator_value");
        wait.wait_for_second(2);
        List<WebElement> operatorList = element.find_multiple_elements("operator_name");
        for (WebElement ol : operatorList) {
            if (ol.getText().equals(operator)) {
                ol.click();
                break;
            }
        }
        wait.wait_for_second(5);
        List<WebElement> valueList = element.find_multiple_elements("operator_name");
        for (WebElement vl : valueList) {
            if (vl.getText().equals(value)) {
                vl.click();
                break;
            }
        }
    }

    public void click_on_apply_filter_button() {
        wait.wait_for_second(2);
        element.click("Apply_Filter_Button");
    }

    public void verify_ant_table_container_header() {

        List<WebElement> ant_table_container = element.find_multiple_elements("ant_table_container");
        List<WebElement> ant_table_container_value = element.find_multiple_elements("ant_table_container_value");

        if (ant_table_container == null || ant_table_container.isEmpty()) {
            throw new AssertionError("Table header elements not found. Failing the script.");
        }
        JavascriptExecutor js = (JavascriptExecutor) driver;

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
                Reporter.log("No value found for: " + optionText,true);
            }

            Reporter.log("UI Text: " + optionText + " | Value: " + optionValue,true);
        }
    }
    public void click_on_First_Host_Name_From_Host_Table() {
        wait.wait_for_second(2);
        element.click("Host_Name_Table_data");
    }

    public String verify_host_name_present_on_page() {
        WebElement host_Name = element.find("Host_Names");
        String hostName = host_Name.getText();
        return hostName;
    }
    public String  click_on_first_host_name_from_table(){
         String hostName;
        wait.wait_for_second(2);
        WebElement Host_Name= element.find("Host_Name");
        host_name= Host_Name.getText();
        element.click("Host_Name");
        return host_name;
    }
    public void verify_host_info_page_present_on_page() {
        wait.wait_for_second(2);
        WebElement host_info_name= element.find("Host_info_name");
        String hostInfoName = host_info_name.getText();
        System.out.println(" Host INFO Name " + hostInfoName);
        Assert.assertEquals(host_name,hostInfoName);
    }

    public String verify_operating_system_present_on_page() {
        WebElement operating_system = element.find("Operating_Systems");
        String operatingSystem =   operating_system.getText();
        return operatingSystem;
    }

    public void verify_host_info_tab_present_on_page() {
        verify.check_element_is_present("Host_info");
        wait.wait_until_element_is_clickable("Host_info");
    }

    public void verify_option_container_Lists() {
        wait.wait_for_second(2);
        element.verifyTheListOfOption("Host_info_tab_content","Host_info_tab_content_value");
    }

    public void verify_header_system_info_and_value() {
        wait.wait_for_second(2);
        element.verifyTheListOfOption("Host_info_system_info_header","Host_info_system_info_header_value");
    }

    public void verify_value_in_progress_bar() {
        int executionCount = 0;

        while (executionCount < 1) {
            wait.wait_for_second(2);

            List<WebElement> titles = element.find_multiple_elements("progress_bar_tittle");
            for (WebElement title : titles) {
                System.out.println(title.getText());

                List<WebElement> progressBars = element.find_multiple_elements("progress_bar");
                for (WebElement progressBar : progressBars) {
                    actions.moveToElement(progressBar).perform();
                    wait.wait_for_second(2);

                    List<WebElement> progressBarValues = element.find_multiple_elements("progress_bar_value");
                    for (WebElement progressBarValue : progressBarValues) {
                        System.out.println(progressBarValue.getText());
                    }
                }
                break;
            }

            executionCount++;
        }
    }

    public void click_on_metrics_tab() {
        element.click("metrics");
        wait.wait_for_second(5);
    }

    public void validate_graphs() {
        for (int graphIndex = 1; graphIndex <= 16; graphIndex++) {
            if (graphIndex == 10 || graphIndex == 11 || graphIndex == 12 || graphIndex == 16) {
                System.out.println("Skipping Graph #" + graphIndex);
                continue;
            }

            String graphXpath = "(//*[local-name()='svg']//*[name()='g' and @class='highcharts-series-group'])[" + graphIndex + "]//*[name()='path'][@class='highcharts-point highcharts-color-0']";
            List<WebElement> cpugraph = driver.findElements(By.xpath(graphXpath));

            if (cpugraph.isEmpty()) {
                System.out.println("Graph #" + graphIndex + " not found. Skipping...");
                continue;
            }

            System.out.println("Processing Graph #" + graphIndex + " | Total Points: " + cpugraph.size());

            for (WebElement point : cpugraph) {
                try {
                    actions.moveToElement(point).perform();

                    List<WebElement> cpu_values = driver.findElements(By.xpath("//span[contains(text(),'system')]/ancestor::div[@class='highcharts_item_row']"));

                    for (WebElement element : cpu_values) {
                        String text = element.getText().trim();
                        System.out.println("Graph #" + graphIndex + " Data: " + text);

                        if (!text.isEmpty()) {
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
                                } else if (unitPart.equalsIgnoreCase("GB") || unitPart.equalsIgnoreCase("MB") || unitPart.equalsIgnoreCase("KB") || unitPart.equalsIgnoreCase("TB") || unitPart.equalsIgnoreCase("KB/s") || unitPart.equalsIgnoreCase("Bytes/s") || unitPart.equalsIgnoreCase("MB/s")) {
                                    Assert.assertTrue(value >= 0, "Test Failed: Memory usage is not greater than zero. Found: " + value + " " + unitPart);
                                } else if (unitPart.isEmpty()) {
                                    Assert.assertTrue(value >= 0, "Test Failed: Numeric value is not greater than zero. Found: " + value);
                                } else {
                                    Assert.fail("Test Failed: Unknown unit '" + unitPart + "' in text: " + text);
                                }
                            } else {
                                Assert.fail("Test Failed: Value format is incorrect for text: " + text);
                            }
                        } else {
                            Assert.fail("Test Failed: Empty or invalid value received for Graph #" + graphIndex);
                        }
                    }
                } catch (StaleElementReferenceException e) {
                    System.out.println("Stale element detected. Skipping Graph #" + graphIndex);
                }
            }
        }
    }

    public void click_on_processes_tab() {
        wait.wait_until_element_is_visible("processes_tab");
        element.click("processes_tab");
    }

    public void verify_header_value() {
        List<WebElement> ant_table_container = element.find_multiple_elements("processes_tab_table_header");
        List<WebElement> ant_table_container_value = element.find_multiple_elements("processes_tab_table_header_value");

        List<String> optionTextList = new ArrayList<>();
        JavascriptExecutor js = (JavascriptExecutor) driver;

        for (int i = 0; i < ant_table_container.size(); i++) {
            WebElement headerElement = ant_table_container.get(i);

            if (!headerElement.isDisplayed()) {
                js.executeScript("arguments[0].scrollIntoView({inline: 'center'});", headerElement);
                wait.wait_for_second(1);
            }

            String optionText = headerElement.getText().trim();
            optionTextList.add(optionText);

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
                System.out.println("No value found for: " + optionText);
            }

            System.out.println("UI Text: " + optionText + " | Value: " + optionValue);
        }
    }

    public void verify_apply_filter_host_name_with_table_details() {
        element.verify_with_applied_filter_to_table_data("apply_filter_info", "Host_Name");
    }
    public void click_on_clear_button() {
        element.click("Clear_All");
    }


    public void verify_process_tab_table_host_name() {
        WebElement process_tab_table_host_name = element.find("process_tab_table_host_name_row");
        String procees_table_host_name = process_tab_table_host_name.getText();
        Assert.assertEquals(verify_host_name_present_on_page(), procees_table_host_name);
    }

    public void verify_process_tab_table_operating_system_name() {
        WebElement process_tab_table_operating_system = element.find("process_tab_table_operating_system_row");
        String procees_table_opearing_system = process_tab_table_operating_system.getText();
        Assert.assertEquals(verify_operating_system_present_on_page(), procees_table_opearing_system);
    }
    public void unselect_customize_container_checkbox(String Text){

        List<WebElement >unselect= element.find_multiple_elements("customize_container_checked");
        for (WebElement unsel : unselect) {
            unsel.click();
        }
        element.click("customize_container_search_box");
        wait.wait_for_second(2);
        element.enter_text("customize_container_search_box",Text);
        wait.wait_for_second(2);
        List<WebElement>select_container_check_box= driver.findElements(By.xpath("//span[@class='checkbox-label-content']/span"));
        for (WebElement sel : select_container_check_box) {
            if(sel.getText().equalsIgnoreCase(Text)){
                sel.click();
                break;
            }
        }
        wait.wait_for_second(1);
        element.click("Apply_Button");
    }
    public void unselect_customize_container_checkboxes(String Text) {
        wait.wait_for_second(1);
        List<WebElement> unselect = element.find_multiple_elements("customize_container_checked");
        for (WebElement unsel : unselect) {
            unsel.click();
        }
        wait.wait_for_second(1);
        element.click("customize_container_search_box");
        wait.wait_for_second(1);
        element.enter_text("customize_container_search_box", Text);
        List<WebElement> dropdownSuggestions = driver.findElements(By.xpath("//span[@class='checkbox-label-content']/span"));
        boolean matchFound = false;
        for (WebElement suggestion : dropdownSuggestions) {
            if (suggestion.getText().equalsIgnoreCase(Text)) {
                matchFound = true;
                break;
            }
        }

        if (!matchFound) {
            throw new AssertionError("No matching suggestion found for text: " + Text);
        }
    }



    public void click_on_logs_tab() {
        wait.wait_for_second(2);
        element.click("Logs");
        wait.wait_for_second(5);
    }

    public void hover_on_logs_graph() {
        wait.wait_for_second(5);
        element.hover_on_graph("Info_graph", "total_logs_and_info","date_tool_tip");
        wait.wait_for_second(2);
        WebElement total_and_logs = element.find("total_logs_and_info_value");
        System.out.println("Total  and INFO " + total_and_logs.getText());
    }

    public void verify_logs() {
        element.click("Logs_plus_button");
        wait.wait_for_second(2);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement json_value_operating_system = element.find("json_value_operating_system");
        String json_operating_system = json_value_operating_system.getText();
        System.out.println(" os.type " + json_operating_system);
        Assert.assertEquals(verify_operating_system_present_on_page().toUpperCase(), json_operating_system.toUpperCase());
        WebElement json_value_host_name = element.find("json_value_host_name");
        if (!json_value_host_name.isDisplayed()) {
            js.executeScript("arguments[0].scrollIntoView({block: 'center'});", json_value_host_name);
            wait.wait_for_second(1);
        }
        String json_host_name = json_value_host_name.getText();
        System.out.println(" host Name " + json_host_name);
        Assert.assertEquals(verify_host_name_present_on_page(), json_host_name);
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
    public void hover_on_expand_button_and_click(String locator_key1, String locator_key2) {
        actions.moveToElement(element.find(locator_key1)).perform();
        actions.moveToElement(element.find(locator_key2)).perform();
        element.click(locator_key2);
    }


    public void cpu_usage_present_on_page() {
        wait.wait_for_second(2);
        wait.wait_until_element_is_visible("cpu_usage");
        WebElement cpu_usage = element.find("cpu_usage");
        System.out.println("CPU Usage " + cpu_usage.getText());
        hover_on_element_and_click("cpu_usage", "cpu_usage_filter_button", "check_box");
    }

    public void verify_no_data_found_selected_time_period() {
        wait.wait_for_second(2);
        wait.wait_until_element_is_visible("No_data_found_for_selected_time_period");
    }

    public void enter_text_filter_by_searh_box() throws InterruptedException {
        for (int i = 0; i <= 1; i++) {
            String cpuText = "cpu" + i;
            System.out.println("Executing for: " + cpuText);
            element.click("filter_by_search");
            wait.wait_for_second(2);
            element.enter_text_filter_by_search_box("filter_by_search", cpuText, "checkbox_label_content", 1, "cpu_usage", "cpu_usage_filter_button");
        }
    }

    public void cpu_usage_by_state_present_on_page() {
        wait.wait_for_second(2);
        wait.wait_until_element_is_visible("cpu_usage_by_state");
        hover_on_element_and_click("cpu_usage_by_state", "cpu_usage_by_state_filter_button", "check_box");
    }
    public void enter_text_filter_by_searh_box_by_state() throws InterruptedException {
        wait.wait_for_second(2);
        String[] states = {"idle", "interrupt", "system", "user","nice","steal"};
        for (String state : states) {
            element.enter_text_filter_by_search_box("filter_by_search", state, "checkbox_label_content", 2, "cpu_usage_by_state", "cpu_usage_by_state_filter_button");
        }
    }

    public void cpu_load_average_present_on_page() {
        wait.wait_for_second(2);
        wait.wait_until_element_is_visible("cpu_load_average");
        hover_on_element_and_click("cpu_load_average", "cpu_load_average_filter_button", "check_box");
    }

    public void enter_text_cpu_load_average_search_box() throws InterruptedException {
        element.enter_text_filter_by_search_box("filter_by_search", "laravel-test-vm", "checkbox_label_content", 3, "cpu_load_average", "cpu_load_average_filter_button");
    }

    public void swap_memory_by_state_bytes_present_on_page() {
        wait.wait_for_second(2);
        wait.wait_until_element_is_visible("swap_memory_by_state_bytes");
        hover_on_element_and_click("swap_memory_by_state_bytes", "swap_memory_by_state_bytes_filter_button", "check_box");
    }

    public void enter_text_swap_memory_by_state_bytes_search_box() throws InterruptedException {
        wait.wait_for_second(1);
        for (String smb : METRICS_FILTER_BY_OPTION_MEMORY_BYTES) {
            element.enter_text_filter_by_search_box("filter_by_search", smb, "checkbox_label_content", 4, "swap_memory_by_state_bytes", "swap_memory_by_state_bytes_filter_button");
        }
    }

    public void verify_memory_by_state_bytes_present_on_page() {
        wait.wait_for_second(1);
        wait.wait_until_element_is_visible("memory_usage_by_state_bytes");
        hover_on_element_and_click("memory_usage_by_state_bytes", "memory_by_state_bytes_filter_button", "check_box");
    }

    public void enter_text_memory_by_state_bytes_search_box() throws InterruptedException {
        wait.wait_for_second(2);
        for (String mb : METRICS_FILTER_BY_OPTION_MEMORY_BYTES) {
            element.enter_text_filter_by_search_box("filter_by_search", mb, "checkbox_label_content", 5, "memory_usage_by_state_bytes", "memory_by_state_bytes_filter_button");
        }
    }

    public void verify_memory_usage_by_state_percent_present_on_page() {
        WebElement memory_usage_by_state_percent = element.find("memory_usage_by_state_percent");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", memory_usage_by_state_percent);
        wait.wait_for_second(2);
        wait.wait_until_element_is_visible("memory_usage_by_state_percent");
        hover_on_element_and_click("memory_usage_by_state_percent", "memory_usage_by_state_percent_filter_button", "check_box");
    }

    public void enter_text_memory_usage_by_state_percent_search_box() throws InterruptedException {
        wait.wait_for_second(1);
        for (String mbp : METRICS_FILTER_BY_OPTION_MEMORY_BYTES) {
            element.enter_text_filter_by_search_box("filter_by_search", mbp, "checkbox_label_content", 6, "memory_usage_by_state_percent", "memory_usage_by_state_percent_filter_button");
        }
    }

    public void verify_Network_IO_by_Direction_Bytes_present_on_page() {
        WebElement Network_IO_by_Direction_Bytes = element.find("Network_IO_by_Direction_Bytes");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", Network_IO_by_Direction_Bytes);
        wait.wait_for_second(2);
        wait.wait_until_element_is_visible("memory_usage_by_state_percent");
        hover_on_element_and_click("Network_IO_by_Direction_Bytes", "Network_IO_by_Direction_Bytes_filter_button", "check_box");
    }


    public void enter_text_Network_IO_by_Direction_Bytes_search_box() throws InterruptedException {
        wait.wait_for_second(1);
        for (String networkIoByDirBytes : METRICS_FILTER_BY_OPTION) {
            element.enter_text_filter_by_search_box("filter_by_search", networkIoByDirBytes, "checkbox_label_content", 7, "Network_IO_by_Direction_Bytes", "Network_IO_by_Direction_Bytes_filter_button");
        }
    }

    public void verify_network_connection_by_state_present_on_page() {
        WebElement networkConnectionsByState = element.find("Network_connections_by_State");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", networkConnectionsByState);
        wait.wait_for_second(2);
        wait.wait_until_element_is_visible("Network_connections_by_State");
        hover_on_element_and_click("Network_connections_by_State", "Network_connections_by_State_filter_button", "check_box");
    }

    public void enter_text_network_connection_search_box() throws InterruptedException {
        wait.wait_for_second(1);
        String[] networkConnectionByStates = {"CLOSE", "CLOSE_WAIT", "CLOSING", "DELETE", "ESTABLISHED", "FIN_WAIT_1", "FIN_WAIT_2", "LAST_ACK", "LISTEN", "TIME_WAIT"};
        for (String networkConnectionByState : networkConnectionByStates) {
            element.enter_text_filter_by_search_box("filter_by_search", networkConnectionByState, "checkbox_label_content", 8, "Network_connections_by_State", "Network_connections_by_State_filter_button");
        }
    }

    public void verify_network_connection_protocol_present_on_page() {
        WebElement networkConnectionsProtocol = element.find("Network_connections_protocol");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", networkConnectionsProtocol);
        wait.wait_for_second(2);
        wait.wait_until_element_is_visible("Network_connections_protocol");
        hover_on_element_and_click("Network_connections_protocol", "Network_connections_protocol_filter_button", "check_box");
    }

    public void enter_text_network_connection_protocol_search_box() throws InterruptedException {
        wait.wait_for_second(1);
        element.enter_text_filter_by_search_box("filter_by_search", "tcp", "checkbox_label_content", 9, "Network_connections_protocol", "Network_connections_protocol_filter_button");

    }

    public void verify_network_error_rate_by_directional_bytes_present_on_page() {
        WebElement networkErrorRateByDirectinalBytes = element.find("Network_error_rate_by_direction_bytes");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", networkErrorRateByDirectinalBytes);
        wait.wait_for_second(2);
        wait.wait_until_element_is_visible("Network_error_rate_by_direction_bytes");
        hover_on_element_and_click("Network_error_rate_by_direction_bytes", "Network_error_rate_by_direction_bytes_filter_button", "check_box");
    }

    public void enter_text_network_error_rate_by_directional_bytesearch_box() throws InterruptedException {
        wait.wait_for_second(1);
        for (String value : METRICS_FILTER_BY_OPTION) {
            element.enter_text_filter_by_search_box("filter_by_search", value, "checkbox_label_content", 10, "Network_error_rate_by_direction_bytes", "Network_error_rate_by_direction_bytes_filter_button");
        }
    }

    public void verify_network_dropped_rate_by_directional_packets_present_on_page() {
        WebElement networkErrorRateByDirectinalPackets = element.find("Network_dropped_rate_by_direction_packets");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", networkErrorRateByDirectinalPackets);
        wait.wait_for_second(2);
        wait.wait_until_element_is_visible("Network_dropped_rate_by_direction_packets");
        hover_on_element_and_click("Network_dropped_rate_by_direction_packets", "Network_dropped_rate_by_direction_packets_filter_button", "check_box");
    }

    public void enter_text_network_dropped_rate_by_directional_packets_search_box() throws InterruptedException {
        wait.wait_for_second(1);
        for (String value : METRICS_FILTER_BY_OPTION) {
            element.enter_text_filter_by_search_box("filter_by_search", value, "checkbox_label_content", 11, "Network_dropped_rate_by_direction_packets", "Network_dropped_rate_by_direction_packets_filter_button");
        }
    }

    public void verify_network_packets_by_direction_packets_present_on_page() {
        WebElement networkPacketsByDirectionPackets = element.find("Network_packets_by_direction_packets");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", networkPacketsByDirectionPackets);
        wait.wait_for_second(2);
        wait.wait_until_element_is_visible("Network_packets_by_direction_packets");
        hover_on_element_and_click("Network_packets_by_direction_packets", "Network_packets_by_direction_packets_filter_button", "check_box");
    }

    public void enter_text_network_packets_by_direction_packets_search_box() throws InterruptedException {
        wait.wait_for_second(1);
        for (String value : METRICS_FILTER_BY_OPTION) {
            element.enter_text_filter_by_search_box("filter_by_search", value, "checkbox_label_content", 12, "Network_packets_by_direction_packets", "Network_packets_by_direction_packets_filter_button");
        }
    }

    public void verify_network_io_rate_by_direction_bytes_present_on_page() {
        WebElement networkIoRateByDirectionBytes = element.find("Network_io_rate_by_direction_bytes");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", networkIoRateByDirectionBytes);
        wait.wait_for_second(2);
        wait.wait_until_element_is_visible("Network_io_rate_by_direction_bytes");
        hover_on_element_and_click("Network_io_rate_by_direction_bytes", "Network_io_rate_by_direction_bytes_filter_button", "check_box");
    }

    public void enter_text_network_io_rate_by_direction_bytes_search_box() throws InterruptedException {
        wait.wait_for_second(1);
        for (String value : METRICS_FILTER_BY_OPTION) {
            element.enter_text_filter_by_search_box("filter_by_search", value, "checkbox_label_content", 13, "Network_io_rate_by_direction_bytes", "Network_io_rate_by_direction_bytes_filter_button");
        }
    }

    public void verify_network_packets_rate_by_direction_packets_present_on_page() {
        WebElement networkPacketsRateByDirectionPackets = element.find("Network_packets_rate_by_direction_packets");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", networkPacketsRateByDirectionPackets);
        wait.wait_for_second(2);
        wait.wait_until_element_is_visible("Network_packets_rate_by_direction_packets");
        hover_on_element_and_click("Network_packets_rate_by_direction_packets", "Network_packets_rate_by_direction_packets_filter_button", "check_box");
    }

    public void enter_text_network_packets_rate_by_direction_packets_search_box() throws InterruptedException {
        wait.wait_for_second(1);
        for (String value : METRICS_FILTER_BY_OPTION) {
            element.enter_text_filter_by_search_box("filter_by_search", value, "checkbox_label_content", 14, "Network_packets_rate_by_direction_packets", "Network_packets_rate_by_direction_packets_filter_button");
        }
    }

    public void verify_disk_operations_by_direction_bytes_present_on_page() {
        WebElement DiskOperationsByDirectionBytes = element.find("Disk_operations_by_Direction_Bytes");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", DiskOperationsByDirectionBytes);
        wait.wait_for_second(2);
        wait.wait_until_element_is_visible("Disk_operations_by_Direction_Bytes");
        hover_on_element_and_click("Disk_operations_by_Direction_Bytes", "Disk_operations_by_Direction_Bytes_filter_button", "check_box");
    }

    public void enter_text_disk_operations_by_direction_bytes_search_box() throws InterruptedException {
        wait.wait_for_second(1);
        String[] diskOperationsByDirectionBytes = {"read", "write"};
        for (String diskOperationsByDirBytes : diskOperationsByDirectionBytes) {
            element.enter_text_filter_by_search_box("filter_by_search", diskOperationsByDirBytes, "checkbox_label_content", 15, "Disk_operations_by_Direction_Bytes", "Disk_operations_by_Direction_Bytes_filter_button");
        }
    }

    public void click_on_cpu_usage_action_button() {
        wait.wait_for_second(1);
        element.hover_on_expand_button_and_click("cpu_usage", "cpu_usage_action_button_chart");
        wait.wait_for_second(2);
    }

    public void click_on_cpu_usage_by_state_action_button() {
        wait.wait_for_second(1);
        element.hover_on_expand_button_and_click("cpu_usage_by_state", "cpu_usage_by_state_action_button_chart");
        wait.wait_for_second(1);
    }
    public void verify_cpu_usage_by_state_graph_with_table_data() throws InterruptedException {
        wait.wait_for_second(1);
        element.verify_table_data_with_tooltip_message("graph","tool_tip","table_row","table_row_name");
    }
    public void verify_graph_time(int amount , String timeUnit) {
        boolean isTimeValid =  element.verifyGraphTime("graph_chart_time",amount,timeUnit);
        if (isTimeValid) {
            System.out.println("✅ Time is within range. Proceeding to hover over the logs graph.");
            hover_on_logs_graph();
        } else {
            Assert.fail("❌ Timestamps are out of range. Test failed.");
        }
    }
    public void click_on_containers_tab(){
        wait.wait_for_second(1);
        element.click("Containers_tabs");
    }
    public void verify_with_total_containers_present_on_page(){
        wait.wait_for_second(1);
        element.validate_table_row_with_total_page("Total_no_table_rows","Total_no_rows_table");
    }
    public void verify_with_total_processes_present_on_page(){
        wait.wait_for_second(1);
        WebElement totalNoRows= element.find("Total_no_table_rows");
        int number1 = Integer.parseInt(totalNoRows.getText().trim());
        WebElement totalShowingPages= element.find("Total_no_showing_page");
        int number2 = Integer.parseInt(totalShowingPages.getText().trim());
        Assert.assertEquals(number1, number2, "Total number of rows does not match total number of showing pages!");
    }
    public void wait_for_five_sec(){
        wait.wait_for_second(5);
    }
    public void wait_for_ten_sec(){
        wait.wait_for_second(10);
    }





}








