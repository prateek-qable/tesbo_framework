package web.tests.demo.Infrastructure_Host;

//import org.automation.dataproviders.DataProviders;
import web.tests.demo.Infrastructure_Host.*;
import io.unity.framework.init.base;
import io.unity.framework.exception.locator_validation_exception;
import io.unity.framework.init.base;
import org.testng.annotations.Test;
import web.object_repository.Infrastructure.Infrastructure_Page;
import web.object_repository.Infrastructure_Host.Infrastructure_Host_Page;
import web.object_repository.Login.Login_Page;

import java.time.Duration;

public  class Infrastructure_Host_Test extends base {
    Login_Page login_page = null;
    Infrastructure_Host_Page infrastructure_host_page = null;
    Infrastructure_Page infrastructure_page = null;

    @Test()
    public void Verify_that_the_user_can_navigate_to_the_Hosts_tab_IS_01(String username, String password) {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        login_page = new Login_Page(driver);
        infrastructure_host_page = new Infrastructure_Host_Page(driver);
        login_page.click_on_email_id_text_box(username);
        login_page.click_on_password_text_box(password);
        login_page.click_on_login_button();
        login_page.click_on_Embrace_your_pro_user_pop_up();
        login_page.isWelcomeToMiddlewarePageDisplayed();
        infrastructure_host_page.verify_and_click_on_Infrastructure();
        infrastructure_host_page.verify_and_check_clickable_on_Host();
        infrastructure_host_page.click_on_host_Tab();
        infrastructure_host_page.verify_host_name_list_present_on_Page();
        infrastructure_host_page.verify_with_mw_table_row_Count();
    }

    @Test()
    public void Verify_that_both_Hosts_and_Dashboards_tabs_are_present_IS_02(String username, String password) {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        login_page = new Login_Page(driver);
        infrastructure_host_page = new Infrastructure_Host_Page(driver);
        login_page.click_on_email_id_text_box(username);
        login_page.click_on_password_text_box(password);
        login_page.click_on_login_button();
        login_page.click_on_Embrace_your_pro_user_pop_up();
        login_page.isWelcomeToMiddlewarePageDisplayed();
        infrastructure_host_page.verify_and_click_on_Infrastructure();
        infrastructure_host_page.verify_and_check_clickable_on_Host();
        infrastructure_host_page.verify_and_check_clickable_on_Dashboard_Tab();
    }

    @Test()
    public void Verify_the_presence_of_essential_UI_elements_IS_03(String username, String password) {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        login_page = new Login_Page(driver);
        infrastructure_host_page = new Infrastructure_Host_Page(driver);
        login_page.click_on_email_id_text_box(username);
        login_page.click_on_password_text_box(password);
        login_page.click_on_login_button();
        login_page.click_on_Embrace_your_pro_user_pop_up();
        login_page.isWelcomeToMiddlewarePageDisplayed();
        infrastructure_host_page.verify_and_click_on_Infrastructure();
        infrastructure_host_page.click_on_host_Tab();
        infrastructure_host_page.verify_element_visible_present_on_Page();
    }

    @Test()
    public void Verify_the_Live_button_functionality_IS_04(String username, String password) {
        // Verify the Refresh/Update button functionality_IS_05
        //Verify the Copy button functionality_IS_06
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        login_page = new Login_Page(driver);
        infrastructure_host_page = new Infrastructure_Host_Page(driver);
        login_page.click_on_email_id_text_box(username);
        login_page.click_on_password_text_box(password);
        login_page.click_on_login_button();
        login_page.click_on_Embrace_your_pro_user_pop_up();
        login_page.isWelcomeToMiddlewarePageDisplayed();
        infrastructure_host_page.verify_and_click_on_Infrastructure();
        infrastructure_host_page.click_on_host_Tab();
        infrastructure_host_page.click_on_live_Button();
        infrastructure_host_page.click_on_refresh_Button();
        infrastructure_host_page.click_on_copy_Button();
        infrastructure_host_page.verify_url_copied_pop_up_MessageDisplayed();
    }

    @Test()
    public void Verify_the_Global_Calendar_selection_functionality_IS_07(String username, String password) throws InterruptedException {
        // Verify the Previous and Next buttons for Global Calendar_IS_08
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        login_page = new Login_Page(driver);
        infrastructure_host_page = new Infrastructure_Host_Page(driver);
        login_page.click_on_email_id_text_box(username);
        login_page.click_on_password_text_box(password);
        login_page.click_on_login_button();
        login_page.click_on_Embrace_your_pro_user_pop_up();
        login_page.isWelcomeToMiddlewarePageDisplayed();
        login_page.verify_and_click_on_calendar_menu();
        login_page.verify_and_select_specific_date("Mar", "2025");
        infrastructure_host_page.verify_and_click_on_Infrastructure();
        infrastructure_host_page.click_on_host_Tab();
        infrastructure_host_page.verify_data_select_range_of_Calender();
        login_page.click_on_global_calender_previous_Button();
        infrastructure_host_page.verify_data_select_range_of_Calender();
        login_page.click_on_global_calender_forward_Button();
        infrastructure_host_page.verify_data_select_range_of_Calender();
    }

    @Test()
    public void Verify_Search_Using_Host_Attributes_IS_11(String username, String password) throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        login_page = new Login_Page(driver);
        infrastructure_host_page = new Infrastructure_Host_Page(driver);
        login_page.click_on_email_id_text_box(username);
        login_page.click_on_password_text_box(password);
        login_page.click_on_login_button();
        login_page.click_on_Embrace_your_pro_user_pop_up();
        login_page.isWelcomeToMiddlewarePageDisplayed();
        infrastructure_host_page.verify_and_click_on_Infrastructure();
        infrastructure_host_page.click_on_host_Tab();
        infrastructure_host_page.click_on_global_search_field();
        infrastructure_host_page.enter_text_host_name_global_infra_process_search_box("host.name", "= Equal to");
        infrastructure_host_page.click_on_global_search_field();
        //  infrastructure_host_page.enter_text_os_type_global_infra_process_search_box("os.type","= Equal to");
    }

    @Test()
    public void Verify_that_no_results_appear_for_an_invalid_search_IS_12(String username, String password) {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        login_page = new Login_Page(driver);
        infrastructure_host_page = new Infrastructure_Host_Page(driver);
        login_page.click_on_email_id_text_box(username);
        login_page.click_on_password_text_box(password);
        login_page.click_on_login_button();
        login_page.click_on_Embrace_your_pro_user_pop_up();
        login_page.isWelcomeToMiddlewarePageDisplayed();
        infrastructure_host_page.verify_and_click_on_Infrastructure();
        infrastructure_host_page.click_on_host_Tab();
        infrastructure_host_page.click_on_global_search_field();
        infrastructure_host_page.enter_invalid_host_name_in_global_search_box("host.name", "= Equal to", "AutomationTesting");
        infrastructure_host_page.click_on_apply_filter_Button();
        infrastructure_host_page.verify_No_Data_Found_MessageDisplayed();
    }

    @Test()
    public void Verify_the_Customize_button_functionality_menu_IS_13(String username, String password) throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        login_page = new Login_Page(driver);
        infrastructure_host_page = new Infrastructure_Host_Page(driver);
        login_page.click_on_email_id_text_box(username);
        login_page.click_on_password_text_box(password);
        login_page.click_on_login_button();
        login_page.click_on_Embrace_your_pro_user_pop_up();
        login_page.isWelcomeToMiddlewarePageDisplayed();
        infrastructure_host_page.verify_and_click_on_Infrastructure();
        infrastructure_host_page.click_on_host_Tab();
        infrastructure_host_page.click_on_customize_button();
        infrastructure_host_page.verify_customize_option_container_visible_present_on_Page();
    }
    @Test()
    public void Verify_search_functionality_in_the_Customize_menu_IS_14(String username, String password) throws InterruptedException{
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        login_page = new Login_Page(driver);
        infrastructure_host_page = new Infrastructure_Host_Page(driver);
        infrastructure_page= new Infrastructure_Page(driver);
        login_page.click_on_email_id_text_box(username);
        login_page.click_on_password_text_box(password);
        login_page.click_on_login_button();
        login_page.click_on_Embrace_your_pro_user_pop_up();
        login_page.isWelcomeToMiddlewarePageDisplayed();
        infrastructure_host_page.verify_and_click_on_Infrastructure();
        infrastructure_host_page.click_on_host_Tab();
        infrastructure_page.verify_host_name_present_on_page();
        infrastructure_host_page.click_on_customize_button();
        infrastructure_page.unselect_customize_container_checkbox("Host Name");
     //   infrastructure_page.verify_Host_Name_after_search_in_customize_button();
    }
    @Test()
    public void Verify_Default_button_functionality_in_Customize_menu_IS_15(String username, String password)throws InterruptedException{
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        login_page = new Login_Page(driver);
        infrastructure_host_page = new Infrastructure_Host_Page(driver);
        infrastructure_page= new Infrastructure_Page(driver);
        login_page.click_on_email_id_text_box(username);
        login_page.click_on_password_text_box(password);
        login_page.click_on_login_button();
        login_page.click_on_Embrace_your_pro_user_pop_up();
        login_page.isWelcomeToMiddlewarePageDisplayed();
        infrastructure_host_page.verify_and_click_on_Infrastructure();
        infrastructure_host_page.click_on_host_Tab();
        infrastructure_host_page.click_on_customize_button();
        infrastructure_host_page.verify_default_column_reset_default_State();
    }

    @Test()
    public void Verify_Apply_Changes_and_Cancel_buttons_in_Customize_menu_IS_16(String username, String password) {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        login_page = new Login_Page(driver);
        infrastructure_host_page = new Infrastructure_Host_Page(driver);
        login_page.click_on_email_id_text_box(username);
        login_page.click_on_password_text_box(password);
        login_page.click_on_login_button();
        login_page.click_on_Embrace_your_pro_user_pop_up();
        login_page.isWelcomeToMiddlewarePageDisplayed();
        infrastructure_host_page.verify_and_click_on_Infrastructure();
        infrastructure_host_page.click_on_host_Tab();
        infrastructure_host_page.click_on_customize_button();
        infrastructure_host_page.click_on_cancel_button_customize_container();
        infrastructure_host_page.verify_apply_filter_host_name_present_on_Page();
    }

    @Test()
    public void Verify_Available_Hosts_list_displays_correctly_IS_17(String username, String password) throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        login_page = new Login_Page(driver);
        infrastructure_host_page = new Infrastructure_Host_Page(driver);
        infrastructure_page = new Infrastructure_Page(driver);
        login_page.click_on_email_id_text_box(username);
        login_page.click_on_password_text_box(password);
        login_page.click_on_login_button();
        login_page.click_on_Embrace_your_pro_user_pop_up();
        login_page.isWelcomeToMiddlewarePageDisplayed();
        infrastructure_host_page.verify_and_click_on_Infrastructure();
        infrastructure_host_page.click_on_host_Tab();
        infrastructure_page.verify_ant_table_container_header();
      //  infrastructure_host_page.store_data_before_sorting();
      //  infrastructure_host_page.click_on_host_name_Header();
     //   infrastructure_host_page.verify_HostName_Sorting_List_In_AscendingOrder();
     //   infrastructure_host_page.click_on_host_name_ascending_arrow_Button();
        // infrastructure_host_page.verify_host_name_sorting_list_in_descending_Order();// Descending Order
    }

    @Test()
    public void Verify_UI_elements_on_the_Host_Info_page_IS_20(String username, String password) {
        // Verify correct OS information is displayed_IS_21
        // Verify CPU Utilization displays correct values_IS_22
        //  Verify RAM Utilization displays correct values_IS_23
        // Verify Avg. Load Time value is displayed correctly_IS_24
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        login_page = new Login_Page(driver);
        infrastructure_host_page = new Infrastructure_Host_Page(driver);
        login_page.click_on_email_id_text_box(username);
        login_page.click_on_password_text_box(password);
        login_page.click_on_login_button();
        login_page.click_on_Embrace_your_pro_user_pop_up();
        login_page.isWelcomeToMiddlewarePageDisplayed();
        infrastructure_host_page.verify_and_click_on_Infrastructure();
        infrastructure_host_page.click_on_host_Tab();
        infrastructure_host_page.click_on_First_Host_Name_From_Host_Table();
        infrastructure_host_page.check_Host_Name_PageDisplayed();
        infrastructure_host_page.visible_UI_element_Of_Host_Info_Page_and_Value_Present_On_Page();
    }

    @Test()
    public void Verify_Network_Packets_display_correct_data_IS_25(String username, String password) {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        login_page = new Login_Page(driver);
        infrastructure_host_page = new Infrastructure_Host_Page(driver);
        infrastructure_page = new Infrastructure_Page(driver);
        login_page.click_on_email_id_text_box(username);
        login_page.click_on_password_text_box(password);
        login_page.click_on_login_button();
        login_page.click_on_Embrace_your_pro_user_pop_up();
        login_page.isWelcomeToMiddlewarePageDisplayed();
        infrastructure_host_page.verify_and_click_on_Infrastructure();
        infrastructure_host_page.click_on_host_Tab();
        infrastructure_host_page.click_on_First_Host_Name_From_Host_Table();
        infrastructure_host_page.check_Host_Name_PageDisplayed();
        infrastructure_host_page.visible_System_Info_Header_and_value();
        infrastructure_page.verify_value_in_progress_bar();
    }

    @Test()
    public void Verify_tab_navigation_between_sections_IS_32(String username, String password) {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        login_page = new Login_Page(driver);
        infrastructure_host_page = new Infrastructure_Host_Page(driver);
        login_page.click_on_email_id_text_box(username);
        login_page.click_on_password_text_box(password);
        login_page.click_on_login_button();
        login_page.click_on_Embrace_your_pro_user_pop_up();
        login_page.isWelcomeToMiddlewarePageDisplayed();
        infrastructure_host_page.verify_and_click_on_Infrastructure();
        infrastructure_host_page.click_on_host_Tab();
        infrastructure_host_page.click_on_First_Host_Name_From_Host_Table();
        infrastructure_host_page.check_Host_Name_PageDisplayed();
        infrastructure_host_page.visible_System_Info_Header_and_value();
        //    infrastructure_host_page.verify_graphs_are_displayed();
        infrastructure_host_page.verify_containers_data_are_displayed();
        infrastructure_host_page.verify_processes_data_are_displayed();
        infrastructure_host_page.verify_APM_data_are_displayed();
    }

    @Test()
    public void Verify_past_week_data_selection_IS_33(String username, String password) {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        login_page = new Login_Page(driver);
        infrastructure_host_page = new Infrastructure_Host_Page(driver);
        login_page.click_on_email_id_text_box(username);
        login_page.click_on_password_text_box(password);
        login_page.click_on_login_button();
        login_page.click_on_Embrace_your_pro_user_pop_up();
        login_page.isWelcomeToMiddlewarePageDisplayed();
        login_page.verify_and_click_on_calendar_menu();
        login_page.click_on_specific_minutes("Past week");
        infrastructure_host_page.verify_and_click_on_Infrastructure();
        infrastructure_host_page.click_on_host_Tab();
        infrastructure_host_page.click_on_First_Host_Name_From_Host_Table();
        infrastructure_host_page.check_Host_Name_PageDisplayed();
     //   infrastructure_host_page.visible_System_Info_Header_and_value();
        infrastructure_host_page.hover_on_i_tag_pop_up_Displayed();
        infrastructure_host_page.click_on_x_button_of_HostPage();
        infrastructure_host_page.verify_x_button_of_HostPage_close();
    }

    @Test()
    public void Verify_UI_elements_on_the_Metrics_page_IS_37(String username, String password) {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        login_page = new Login_Page(driver);
        infrastructure_host_page = new Infrastructure_Host_Page(driver);
        login_page.click_on_email_id_text_box(username);
        login_page.click_on_password_text_box(password);
        login_page.click_on_login_button();
        login_page.click_on_Embrace_your_pro_user_pop_up();
        login_page.isWelcomeToMiddlewarePageDisplayed();
        infrastructure_host_page.verify_and_click_on_Infrastructure();
        infrastructure_host_page.click_on_host_Tab();
        infrastructure_host_page.click_on_First_Host_Name_From_Host_Table();
        infrastructure_host_page.check_Host_Name_PageDisplayed();
        infrastructure_host_page.click_on_MetricsTab();
        infrastructure_host_page.vissile_UI_element_Of_Metrics();
    }

    @Test()
    public void Verify_CPU_Usage_chart_displays_correct_values_IS_38(String username, String password) {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        login_page = new Login_Page(driver);
        infrastructure_host_page = new Infrastructure_Host_Page(driver);
        login_page.click_on_email_id_text_box(username);
        login_page.click_on_password_text_box(password);
        login_page.click_on_login_button();
        login_page.click_on_Embrace_your_pro_user_pop_up();
        login_page.isWelcomeToMiddlewarePageDisplayed();
        infrastructure_host_page.verify_and_click_on_Infrastructure();
        infrastructure_host_page.click_on_host_Tab();
        infrastructure_host_page.click_on_First_Host_Name_From_Host_Table();
        infrastructure_host_page.check_Host_Name_PageDisplayed();
        infrastructure_host_page.click_on_MetricsTab();
        infrastructure_host_page.No_Data_found_IsVissible("Metrics");
        infrastructure_host_page.verify_graph_time_with_actualTime(1, 1, "hours");
        infrastructure_host_page.verify_graph_Data(1);
    }

    @Test()
    public void Verify_CPU_Usage_by_State_chart_IS_39(String username, String password) throws locator_validation_exception {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        login_page = new Login_Page(driver);
        infrastructure_host_page = new Infrastructure_Host_Page(driver);
        login_page.click_on_email_id_text_box(username);
        login_page.click_on_password_text_box(password);
        login_page.click_on_login_button();
        login_page.click_on_Embrace_your_pro_user_pop_up();
        login_page.isWelcomeToMiddlewarePageDisplayed();
        infrastructure_host_page.verify_and_click_on_Infrastructure();
        infrastructure_host_page.click_on_host_Tab();
        infrastructure_host_page.click_on_First_Host_Name_From_Host_Table();
        infrastructure_host_page.check_Host_Name_PageDisplayed();
        infrastructure_host_page.click_on_MetricsTab();
        infrastructure_host_page.No_Data_found_IsVissible("Metrics");
        infrastructure_host_page.verify_graph_time_with_actualTime(2, 1, "hours");
        infrastructure_host_page.verify_graph_Data(2);
    }

    @Test()
    public void Verify_CPU_Load_Average_graph_updates_IS_40(String username, String password) {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        login_page = new Login_Page(driver);
        infrastructure_host_page = new Infrastructure_Host_Page(driver);
        login_page.click_on_email_id_text_box(username);
        login_page.click_on_password_text_box(password);
        login_page.click_on_login_button();
        login_page.click_on_Embrace_your_pro_user_pop_up();
        login_page.isWelcomeToMiddlewarePageDisplayed();
        infrastructure_host_page.verify_and_click_on_Infrastructure();
        infrastructure_host_page.click_on_host_Tab();
        infrastructure_host_page.click_on_First_Host_Name_From_Host_Table();
        infrastructure_host_page.check_Host_Name_PageDisplayed();
        infrastructure_host_page.click_on_MetricsTab();
        infrastructure_host_page.No_Data_found_IsVissible("Metrics");
        infrastructure_host_page.verify_graph_time_with_actualTime(3, 1, "hours");
        infrastructure_host_page.verify_graph_Data(3);

    }

    @Test()
    public void Verify_Swap_Memory_usage_updates_correctly_IS_41(String username, String password) {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        login_page = new Login_Page(driver);
        infrastructure_host_page = new Infrastructure_Host_Page(driver);
        login_page.click_on_email_id_text_box(username);
        login_page.click_on_password_text_box(password);
        login_page.click_on_login_button();
        login_page.click_on_Embrace_your_pro_user_pop_up();
        login_page.isWelcomeToMiddlewarePageDisplayed();
        infrastructure_host_page.verify_and_click_on_Infrastructure();
        infrastructure_host_page.click_on_host_Tab();
        infrastructure_host_page.click_on_First_Host_Name_From_Host_Table();
        infrastructure_host_page.check_Host_Name_PageDisplayed();
        infrastructure_host_page.click_on_MetricsTab();
        infrastructure_host_page.No_Data_found_IsVissible("Metrics");
        infrastructure_host_page.verify_graph_time_with_actualTime(4, 1, "hours");
        infrastructure_host_page.verify_graph_Data(4);
    }

    @Test()
    public void Verify_Memory_Usage_by_State_percentage_graph_IS_42(String username, String password) {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        login_page = new Login_Page(driver);
        infrastructure_host_page = new Infrastructure_Host_Page(driver);
        login_page.click_on_email_id_text_box(username);
        login_page.click_on_password_text_box(password);
        login_page.click_on_login_button();
        login_page.click_on_Embrace_your_pro_user_pop_up();
        login_page.isWelcomeToMiddlewarePageDisplayed();
        infrastructure_host_page.verify_and_click_on_Infrastructure();
        infrastructure_host_page.click_on_host_Tab();
        infrastructure_host_page.click_on_First_Host_Name_From_Host_Table();
        infrastructure_host_page.check_Host_Name_PageDisplayed();
        infrastructure_host_page.click_on_MetricsTab();
        infrastructure_host_page.No_Data_found_IsVissible("Metrics");
        infrastructure_host_page.verify_graph_time_with_actualTime(5, 1, "hours");
        infrastructure_host_page.verify_graph_Data(5);
    }

    @Test()
    public void Verify_Memory_Usage_by_State_Bytes_graph_IS_43(String username, String password) {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        login_page = new Login_Page(driver);
        infrastructure_host_page = new Infrastructure_Host_Page(driver);
        login_page.click_on_email_id_text_box(username);
        login_page.click_on_password_text_box(password);
        login_page.click_on_login_button();
        login_page.click_on_Embrace_your_pro_user_pop_up();
        login_page.isWelcomeToMiddlewarePageDisplayed();
        infrastructure_host_page.verify_and_click_on_Infrastructure();
        infrastructure_host_page.click_on_host_Tab();
        infrastructure_host_page.click_on_First_Host_Name_From_Host_Table();
        infrastructure_host_page.check_Host_Name_PageDisplayed();
        infrastructure_host_page.click_on_MetricsTab();
        infrastructure_host_page.No_Data_found_IsVissible("Metrics");
        infrastructure_host_page.verify_graph_time_with_actualTime(6, 1, "hours");
        infrastructure_host_page.verify_graph_Data(6);
    }

    @Test()
    public void Verify_Network_IO_by_Direction_graph_IS_44(String username, String password) {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        login_page = new Login_Page(driver);
        infrastructure_host_page = new Infrastructure_Host_Page(driver);
        login_page.click_on_email_id_text_box(username);
        login_page.click_on_password_text_box(password);
        login_page.click_on_login_button();
        login_page.click_on_Embrace_your_pro_user_pop_up();
        login_page.isWelcomeToMiddlewarePageDisplayed();
        infrastructure_host_page.verify_and_click_on_Infrastructure();
        infrastructure_host_page.click_on_host_Tab();
        infrastructure_host_page.click_on_First_Host_Name_From_Host_Table();
        infrastructure_host_page.check_Host_Name_PageDisplayed();
        infrastructure_host_page.click_on_MetricsTab();
        infrastructure_host_page.No_Data_found_IsVissible("Metrics");
        infrastructure_host_page.verify_graph_time_with_actualTime(7, 1, "hours");
        infrastructure_host_page.verify_graph_Data(7);
    }

    @Test()
    public void Verify_Network_Connections_by_State_graph_IS_45(String username, String password) {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        login_page = new Login_Page(driver);
        infrastructure_host_page = new Infrastructure_Host_Page(driver);
        login_page.click_on_email_id_text_box(username);
        login_page.click_on_password_text_box(password);
        login_page.click_on_login_button();
        login_page.click_on_Embrace_your_pro_user_pop_up();
        login_page.isWelcomeToMiddlewarePageDisplayed();
        infrastructure_host_page.verify_and_click_on_Infrastructure();
        infrastructure_host_page.click_on_host_Tab();
        infrastructure_host_page.click_on_First_Host_Name_From_Host_Table();
        infrastructure_host_page.check_Host_Name_PageDisplayed();
        infrastructure_host_page.click_on_MetricsTab();
        infrastructure_host_page.No_Data_found_IsVissible("Metrics");
        infrastructure_host_page.verify_graph_time_with_actualTime(8, 1, "hours");
        infrastructure_host_page.verify_graph_Data(8);
    }

    @Test()
    public void Verify_Network_Connections_Protocol_graph_IS_46(String username, String password) {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        login_page = new Login_Page(driver);
        infrastructure_host_page = new Infrastructure_Host_Page(driver);
        login_page.click_on_email_id_text_box(username);
        login_page.click_on_password_text_box(password);
        login_page.click_on_login_button();
        login_page.click_on_Embrace_your_pro_user_pop_up();
        login_page.isWelcomeToMiddlewarePageDisplayed();
        infrastructure_host_page.verify_and_click_on_Infrastructure();
        infrastructure_host_page.click_on_host_Tab();
        infrastructure_host_page.click_on_First_Host_Name_From_Host_Table();
        infrastructure_host_page.check_Host_Name_PageDisplayed();
        infrastructure_host_page.click_on_MetricsTab();
        infrastructure_host_page.No_Data_found_IsVissible("Metrics");
        infrastructure_host_page.verify_graph_time_with_actualTime(9, 1, "hours");
        infrastructure_host_page.verify_graph_Data(9);
    }

    @Test()
    public void Verify_Network_Error_Rate_by_direction_Bytes_graph_IS_47(String username, String password) {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        login_page = new Login_Page(driver);
        infrastructure_host_page = new Infrastructure_Host_Page(driver);
        login_page.click_on_email_id_text_box(username);
        login_page.click_on_password_text_box(password);
        login_page.click_on_login_button();
        login_page.click_on_Embrace_your_pro_user_pop_up();
        login_page.isWelcomeToMiddlewarePageDisplayed();
        infrastructure_host_page.verify_and_click_on_Infrastructure();
        infrastructure_host_page.click_on_host_Tab();
        infrastructure_host_page.click_on_First_Host_Name_From_Host_Table();
        infrastructure_host_page.check_Host_Name_PageDisplayed();
        infrastructure_host_page.click_on_MetricsTab();
        infrastructure_host_page.No_Data_found_IsVissible("Metrics");
        infrastructure_host_page.verify_graph_time_with_actualTime(10, 1, "hours");
        infrastructure_host_page.verify_graph_Data(10);
    }

    @Test()
    public void Verify_Network_Dropped_rate_by_direction_Packets_graph_IS_48(String username, String password) {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        login_page = new Login_Page(driver);
        infrastructure_host_page = new Infrastructure_Host_Page(driver);
        login_page.click_on_email_id_text_box(username);
        login_page.click_on_password_text_box(password);
        login_page.click_on_login_button();
        login_page.click_on_Embrace_your_pro_user_pop_up();
        login_page.isWelcomeToMiddlewarePageDisplayed();
        infrastructure_host_page.verify_and_click_on_Infrastructure();
        infrastructure_host_page.click_on_host_Tab();
        infrastructure_host_page.click_on_First_Host_Name_From_Host_Table();
        infrastructure_host_page.check_Host_Name_PageDisplayed();
        infrastructure_host_page.click_on_MetricsTab();
        infrastructure_host_page.No_Data_found_IsVissible("Metrics");
        infrastructure_host_page.verify_graph_time_with_actualTime(11, 1, "hours");
        infrastructure_host_page.verify_graph_Data(11);
    }

    @Test()
    public void Verify_Network_packets_by_direction_Packets_graph_IS_49(String username, String password) {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        login_page = new Login_Page(driver);
        infrastructure_host_page = new Infrastructure_Host_Page(driver);
        login_page.click_on_email_id_text_box(username);
        login_page.click_on_password_text_box(password);
        login_page.click_on_login_button();
        login_page.click_on_Embrace_your_pro_user_pop_up();
        login_page.isWelcomeToMiddlewarePageDisplayed();
        infrastructure_host_page.verify_and_click_on_Infrastructure();
        infrastructure_host_page.click_on_host_Tab();
        infrastructure_host_page.click_on_First_Host_Name_From_Host_Table();
        infrastructure_host_page.check_Host_Name_PageDisplayed();
        infrastructure_host_page.click_on_MetricsTab();
        infrastructure_host_page.No_Data_found_IsVissible("Metrics");
        infrastructure_host_page.verify_graph_time_with_actualTime(12, 1, "hours");
        infrastructure_host_page.verify_graph_Data(12);
    }

    @Test()
    public void Verify_Network_IO_rate_by_direction_Bytes_graph_IS_50(String username, String password) {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        login_page = new Login_Page(driver);
        infrastructure_host_page = new Infrastructure_Host_Page(driver);
        login_page.click_on_email_id_text_box(username);
        login_page.click_on_password_text_box(password);
        login_page.click_on_login_button();
        login_page.click_on_Embrace_your_pro_user_pop_up();
        login_page.isWelcomeToMiddlewarePageDisplayed();
        infrastructure_host_page.verify_and_click_on_Infrastructure();
        infrastructure_host_page.click_on_host_Tab();
        infrastructure_host_page.click_on_First_Host_Name_From_Host_Table();
        infrastructure_host_page.check_Host_Name_PageDisplayed();
        infrastructure_host_page.click_on_MetricsTab();
        infrastructure_host_page.No_Data_found_IsVissible("Metrics");
        infrastructure_host_page.verify_graph_time_with_actualTime(13, 1, "hours");
        infrastructure_host_page.verify_graph_Data(13);
    }

    @Test()
    public void Verify_Network_Packets_rate_by_Direction_Packets_graph_IS_51(String username, String password) {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        login_page = new Login_Page(driver);
        infrastructure_host_page = new Infrastructure_Host_Page(driver);
        login_page.click_on_email_id_text_box(username);
        login_page.click_on_password_text_box(password);
        login_page.click_on_login_button();
        login_page.click_on_Embrace_your_pro_user_pop_up();
        login_page.isWelcomeToMiddlewarePageDisplayed();
        infrastructure_host_page.verify_and_click_on_Infrastructure();
        infrastructure_host_page.click_on_host_Tab();
        infrastructure_host_page.click_on_First_Host_Name_From_Host_Table();
        infrastructure_host_page.check_Host_Name_PageDisplayed();
        infrastructure_host_page.click_on_MetricsTab();
        infrastructure_host_page.No_Data_found_IsVissible("Metrics");
        infrastructure_host_page.verify_graph_time_with_actualTime(14, 1, "hours");
        infrastructure_host_page.verify_graph_Data(14);
    }

    @Test()
    public void Verify_Disk_Operations_by_direction_Bytes_graph_IS_52(String username, String password) {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        login_page = new Login_Page(driver);
        infrastructure_host_page = new Infrastructure_Host_Page(driver);
        login_page.click_on_email_id_text_box(username);
        login_page.click_on_password_text_box(password);
        login_page.click_on_login_button();
        login_page.click_on_Embrace_your_pro_user_pop_up();
        login_page.isWelcomeToMiddlewarePageDisplayed();
        infrastructure_host_page.verify_and_click_on_Infrastructure();
        infrastructure_host_page.click_on_host_Tab();
        infrastructure_host_page.click_on_First_Host_Name_From_Host_Table();
        infrastructure_host_page.check_Host_Name_PageDisplayed();
        infrastructure_host_page.click_on_MetricsTab();
        infrastructure_host_page.No_Data_found_IsVissible("Metrics");
        infrastructure_host_page.verify_graph_time_with_actualTime(15, 1, "hours");
        infrastructure_host_page.verify_graph_Data(15);
    }

    @Test()
    public void Verify_Disk_IO_speed_by_direction_Bytes_Seconds_graph_IS_53(String username, String password) {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        login_page = new Login_Page(driver);
        infrastructure_host_page = new Infrastructure_Host_Page(driver);
        login_page.click_on_email_id_text_box(username);
        login_page.click_on_password_text_box(password);
        login_page.click_on_login_button();
        login_page.click_on_Embrace_your_pro_user_pop_up();
        login_page.isWelcomeToMiddlewarePageDisplayed();
        infrastructure_host_page.verify_and_click_on_Infrastructure();
        infrastructure_host_page.click_on_host_Tab();
        infrastructure_host_page.click_on_First_Host_Name_From_Host_Table();
        infrastructure_host_page.check_Host_Name_PageDisplayed();
        infrastructure_host_page.click_on_MetricsTab();
        infrastructure_host_page.No_Data_found_IsVissible("Metrics");
        infrastructure_host_page.verify_graph_time_with_actualTime(16, 1, "hours");
        infrastructure_host_page.verify_graph_Data(16);
    }

    @Test()
    public void Verify_Past_Week_data_selection_updates_correctly_IS_54(String username, String password) {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        login_page = new Login_Page(driver);
        infrastructure_host_page = new Infrastructure_Host_Page(driver);
        login_page.click_on_email_id_text_box(username);
        login_page.click_on_password_text_box(password);
        login_page.click_on_login_button();
        login_page.click_on_Embrace_your_pro_user_pop_up();
        login_page.isWelcomeToMiddlewarePageDisplayed();
        login_page.verify_and_click_on_calendar_menu();
        login_page.click_on_specific_minutes("Past week");
        infrastructure_host_page.verify_and_click_on_Infrastructure();
        infrastructure_host_page.click_on_host_Tab();
        infrastructure_host_page.click_on_First_Host_Name_From_Host_Table();
        infrastructure_host_page.check_Host_Name_PageDisplayed();
        infrastructure_host_page.click_on_MetricsTab();
        infrastructure_host_page.No_Data_found_IsVissible("Metrics");
        infrastructure_host_page.verify_graph_time_with_actualTime(1, 1, "weeks");
        infrastructure_host_page.verify_graph_Data(1);
    }

    @Test()
    public void Verify_changing_range_updates_Graph_data_IS_56(String username, String password) {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        login_page = new Login_Page(driver);
        infrastructure_host_page = new Infrastructure_Host_Page(driver);
        login_page.click_on_email_id_text_box(username);
        login_page.click_on_password_text_box(password);
        login_page.click_on_login_button();
        login_page.click_on_Embrace_your_pro_user_pop_up();
        login_page.isWelcomeToMiddlewarePageDisplayed();
        login_page.verify_and_click_on_calendar_menu();
        login_page.click_on_specific_minutes("Past day");
        infrastructure_host_page.verify_and_click_on_Infrastructure();
        infrastructure_host_page.click_on_host_Tab();
        infrastructure_host_page.click_on_First_Host_Name_From_Host_Table();
        infrastructure_host_page.check_Host_Name_PageDisplayed();
        infrastructure_host_page.click_on_MetricsTab();
        infrastructure_host_page.No_Data_found_IsVissible("Metrics");
        infrastructure_host_page.verify_graph_time_with_actualTime(1, 1, "days");
        infrastructure_host_page.verify_graph_Data(1);
    }

    @Test()
    public void Verify_filter_and_expand_options_for_each_graph_IS_57(String username, String password) throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        login_page = new Login_Page(driver);
        infrastructure_host_page = new Infrastructure_Host_Page(driver);
        login_page.click_on_email_id_text_box(username);
        login_page.click_on_password_text_box(password);
        login_page.click_on_login_button();
        login_page.click_on_Embrace_your_pro_user_pop_up();
        login_page.isWelcomeToMiddlewarePageDisplayed();
        infrastructure_host_page.verify_and_click_on_Infrastructure();
        infrastructure_host_page.click_on_host_Tab();
        infrastructure_host_page.click_on_First_Host_Name_From_Host_Table();
        infrastructure_host_page.check_Host_Name_PageDisplayed();
        infrastructure_host_page.click_on_MetricsTab();
        infrastructure_host_page.cpu_usage_present_on_page();
        infrastructure_host_page.vissible_no_data_found_TextDisplayed();
        infrastructure_host_page.enter_text_in_cpu_usage_filter_Search_box();
        infrastructure_host_page.click_on_expand_button_on_cpu_Usage();
        infrastructure_host_page.verify_graph_expand_successfully();
    }

    @Test()
    public void Verify_tooltips_for_information_icons_IS_58(String username, String password) throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        login_page = new Login_Page(driver);
        infrastructure_host_page = new Infrastructure_Host_Page(driver);
        login_page.click_on_email_id_text_box(username);
        login_page.click_on_password_text_box(password);
        login_page.click_on_login_button();
        login_page.click_on_Embrace_your_pro_user_pop_up();
        login_page.isWelcomeToMiddlewarePageDisplayed();
        infrastructure_host_page.verify_and_click_on_Infrastructure();
        infrastructure_host_page.click_on_host_Tab();
        infrastructure_host_page.click_on_First_Host_Name_From_Host_Table();
        infrastructure_host_page.check_Host_Name_PageDisplayed();
        infrastructure_host_page.click_on_MetricsTab();
        infrastructure_host_page.hover_on_each_graph_and_verify_tool_tip();
    }

    @Test()
    public void Verify_Clicking_on_the_Expand_Button_of_Each_Graph_IS_59(String username, String password) throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        login_page = new Login_Page(driver);
        infrastructure_host_page = new Infrastructure_Host_Page(driver);
        login_page.click_on_email_id_text_box(username);
        login_page.click_on_password_text_box(password);
        login_page.click_on_login_button();
        login_page.click_on_Embrace_your_pro_user_pop_up();
        login_page.isWelcomeToMiddlewarePageDisplayed();
        infrastructure_host_page.verify_and_click_on_Infrastructure();
        infrastructure_host_page.click_on_host_Tab();
        infrastructure_host_page.click_on_First_Host_Name_From_Host_Table();
        infrastructure_host_page.check_Host_Name_PageDisplayed();
        infrastructure_host_page.click_on_MetricsTab();
        infrastructure_host_page.No_Data_found_IsVissible("Metrics");
        infrastructure_host_page.verifY_clicking_on_each_graph();
    }

    @Test()
    public void Verify_TRANSFORM_GRAPH_options_are_visible_For_each_Graph_IS_60(String username, String password) throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        login_page = new Login_Page(driver);
        infrastructure_host_page = new Infrastructure_Host_Page(driver);
        login_page.click_on_email_id_text_box(username);
        login_page.click_on_password_text_box(password);
        login_page.click_on_login_button();
        login_page.click_on_Embrace_your_pro_user_pop_up();
        login_page.isWelcomeToMiddlewarePageDisplayed();
        infrastructure_host_page.verify_and_click_on_Infrastructure();
        infrastructure_host_page.click_on_host_Tab();
        infrastructure_host_page.click_on_First_Host_Name_From_Host_Table();
        infrastructure_host_page.check_Host_Name_PageDisplayed();
        infrastructure_host_page.click_on_MetricsTab();
        infrastructure_host_page.No_Data_found_IsVissible("Metrics");
        infrastructure_host_page.click_on_expand_button_on_cpu_Usage();
        infrastructure_host_page.verify_the_Transform_Graph_Options_IsDisplayed();
    }

    @Test()
    public void Verify_COMPARE_TO_PREVIOUS_options_are_visible_For_each_Graph_IS_65(String username, String password) throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        login_page = new Login_Page(driver);
        infrastructure_host_page = new Infrastructure_Host_Page(driver);
        login_page.click_on_email_id_text_box(username);
        login_page.click_on_password_text_box(password);
        login_page.click_on_login_button();
        login_page.click_on_Embrace_your_pro_user_pop_up();
        login_page.isWelcomeToMiddlewarePageDisplayed();
        infrastructure_host_page.verify_and_click_on_Infrastructure();
        infrastructure_host_page.click_on_host_Tab();
        infrastructure_host_page.click_on_First_Host_Name_From_Host_Table();
        infrastructure_host_page.check_Host_Name_PageDisplayed();
        infrastructure_host_page.click_on_MetricsTab();
     //   infrastructure_host_page.No_Data_found_IsVissible("Metrics");
        infrastructure_host_page.click_on_expand_button_on_cpu_Usage();
        infrastructure_host_page.verify_compare_to_previous_options_ISDisplayed();
    }

    @Test()
    public void Verify_navigation_of_Containers_tab_IS_76(String username, String password) throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        login_page = new Login_Page(driver);
        infrastructure_host_page = new Infrastructure_Host_Page(driver);
        infrastructure_page = new Infrastructure_Page(driver);
        login_page.click_on_email_id_text_box(username);
        login_page.click_on_password_text_box(password);
        login_page.click_on_login_button();
        login_page.click_on_Embrace_your_pro_user_pop_up();
        login_page.isWelcomeToMiddlewarePageDisplayed();
        login_page.verify_and_click_on_calendar_menu();
        login_page.verify_and_select_specific_date("Mar", "2025");
        infrastructure_host_page.verify_and_click_on_Infrastructure();
        infrastructure_host_page.click_on_host_Tab();
        infrastructure_page.check_on_no_data_found_IsVissible();
        infrastructure_host_page.click_on_First_Host_Name_From_Host_Table();
        infrastructure_host_page.check_Host_Name_PageDisplayed();
        infrastructure_host_page.click_on_container_Tab();
        infrastructure_host_page.No_Data_found_IsVissible("Containers");
        infrastructure_host_page.verify_containers_data_are_displayed();
    }

    @Test()
    public void Verify_the_presence_of_essential_UI_elements_IS_77(String username, String password) throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        login_page = new Login_Page(driver);
        infrastructure_host_page = new Infrastructure_Host_Page(driver);
        infrastructure_page = new Infrastructure_Page(driver);
        login_page.click_on_email_id_text_box(username);
        login_page.click_on_password_text_box(password);
        login_page.click_on_login_button();
        login_page.click_on_Embrace_your_pro_user_pop_up();
        login_page.isWelcomeToMiddlewarePageDisplayed();
        login_page.verify_and_click_on_calendar_menu();
        login_page.verify_and_select_specific_date("Mar", "2025");
        infrastructure_host_page.verify_and_click_on_Infrastructure();
        infrastructure_host_page.click_on_host_Tab();
        infrastructure_page.check_on_no_data_found_IsVissible();
        infrastructure_host_page.click_on_First_Host_Name_From_Host_Table();
        infrastructure_host_page.check_Host_Name_PageDisplayed();
        infrastructure_host_page.click_on_container_Tab();
        infrastructure_host_page.No_Data_found_IsVissible("Containers");
        infrastructure_host_page.verify_UI_element_present_on_page();
    }

    @Test()
    public void Verify_the_Previous_and_Next_buttons_for_Global_Calendar_IS_79(String username, String password) throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        login_page = new Login_Page(driver);
        infrastructure_host_page = new Infrastructure_Host_Page(driver);
        infrastructure_page = new Infrastructure_Page(driver);
        login_page.click_on_email_id_text_box(username);
        login_page.click_on_password_text_box(password);
        login_page.click_on_login_button();
        login_page.click_on_Embrace_your_pro_user_pop_up();
        login_page.isWelcomeToMiddlewarePageDisplayed();
        login_page.verify_and_click_on_calendar_menu();
        login_page.verify_and_select_specific_date("Mar", "2025");
        infrastructure_host_page.verify_and_click_on_Infrastructure();
        infrastructure_host_page.click_on_host_Tab();
        infrastructure_page.check_on_no_data_found_IsVissible();
        infrastructure_host_page.click_on_First_Host_Name_From_Host_Table();
        infrastructure_host_page.check_Host_Name_PageDisplayed();
        infrastructure_host_page.click_on_container_Tab();
        infrastructure_host_page.No_Data_found_IsVissible("Containers");
        infrastructure_host_page.verify_data_select_range_of_CalenderInContainer();
        login_page.click_on_global_calender_previous_Button();
        infrastructure_host_page.verify_data_select_range_of_CalenderInContainer();
        login_page.click_on_global_calender_forward_Button();
        infrastructure_host_page.verify_data_select_range_of_CalenderInContainer();
    }

    @Test()
    public void Verify_the_search_bar_dropdown_and_AI_based_search_IS_80(String username, String password) {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        login_page = new Login_Page(driver);
        infrastructure_host_page = new Infrastructure_Host_Page(driver);
        infrastructure_page = new Infrastructure_Page(driver);
        login_page.click_on_email_id_text_box(username);
        login_page.click_on_password_text_box(password);
        login_page.click_on_login_button();
        login_page.click_on_Embrace_your_pro_user_pop_up();
        login_page.isWelcomeToMiddlewarePageDisplayed();
        login_page.verify_and_click_on_calendar_menu();
        login_page.verify_and_select_specific_date("Mar", "2025");
        infrastructure_host_page.verify_and_click_on_Infrastructure();
        infrastructure_host_page.click_on_host_Tab();
        infrastructure_page.check_on_no_data_found_IsVissible();
        infrastructure_host_page.click_on_First_Host_Name_From_Host_Table();
        infrastructure_host_page.check_Host_Name_PageDisplayed();
        infrastructure_host_page.click_on_container_Tab();
        infrastructure_host_page.No_Data_found_IsVissible("Containers");
        infrastructure_host_page.click_on_global_search_of_container();
        infrastructure_host_page.verify_Ai_Search_bar();
    }

    @Test()
    public void Verify_that_no_results_appear_for_an_invalid_search_IS_82(String username, String password) throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        login_page = new Login_Page(driver);
        infrastructure_host_page = new Infrastructure_Host_Page(driver);
        infrastructure_page = new Infrastructure_Page(driver);
        login_page.click_on_email_id_text_box(username);
        login_page.click_on_password_text_box(password);
        login_page.click_on_login_button();
        login_page.click_on_Embrace_your_pro_user_pop_up();
        login_page.isWelcomeToMiddlewarePageDisplayed();
        login_page.verify_and_click_on_calendar_menu();
        login_page.verify_and_select_specific_date("Mar", "2025");
        infrastructure_host_page.verify_and_click_on_Infrastructure();
        infrastructure_host_page.click_on_host_Tab();
        infrastructure_page.check_on_no_data_found_IsVissible();
        infrastructure_host_page.click_on_First_Host_Name_From_Host_Table();
        infrastructure_host_page.check_Host_Name_PageDisplayed();
        infrastructure_host_page.click_on_container_Tab();
        infrastructure_host_page.No_Data_found_IsVissible("Containers");
        infrastructure_host_page.click_on_global_search_infra_container();
        infrastructure_host_page.enter_invalid_host_name_in_global_search("host.name", "= Equal to", "ManualTesting");
        infrastructure_host_page.click_on_apply_filter_Button();
        infrastructure_host_page.verify_No_Data_Found_MessageDisplayed();
    }

    @Test()
    public void Verify_the_Customize_button_functionality_IS_83(String username, String password) throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        login_page = new Login_Page(driver);
        infrastructure_host_page = new Infrastructure_Host_Page(driver);
        infrastructure_page = new Infrastructure_Page(driver);
        login_page.click_on_email_id_text_box(username);
        login_page.click_on_password_text_box(password);
        login_page.click_on_login_button();
        login_page.click_on_Embrace_your_pro_user_pop_up();
        login_page.isWelcomeToMiddlewarePageDisplayed();
        login_page.verify_and_click_on_calendar_menu();
        login_page.verify_and_select_specific_date("Mar", "2025");
        infrastructure_host_page.verify_and_click_on_Infrastructure();
        infrastructure_host_page.click_on_host_Tab();
        infrastructure_page.check_on_no_data_found_IsVissible();
        infrastructure_host_page.click_on_host_name_Tables_and_Containers();
        infrastructure_host_page.click_on_customize_container_Button();
        infrastructure_host_page.verify_customize_option_container_visible_present_on_Page();
        infrastructure_host_page.verify_customize_option_container_visible_present("Host Name");
        infrastructure_host_page.click_on_apply_changes_Button();
        infrastructure_host_page.verify_apply_filter_host_name_present_on_Page();
        infrastructure_host_page.click_on_customize_container_Button();
        infrastructure_host_page.click_on_clear_all_Button();
        infrastructure_host_page.click_on_customize_container_Button();
        infrastructure_host_page.verify_default_column_reset_default_State();
    }

    @Test()
    public void Verify_Available_Containers_list_displays_correctly_IS_87(String username, String password) throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        login_page = new Login_Page(driver);
        infrastructure_host_page = new Infrastructure_Host_Page(driver);
        infrastructure_page = new Infrastructure_Page(driver);
        login_page.click_on_email_id_text_box(username);
        login_page.click_on_password_text_box(password);
        login_page.click_on_login_button();
        login_page.click_on_Embrace_your_pro_user_pop_up();
        login_page.isWelcomeToMiddlewarePageDisplayed();
        login_page.verify_and_click_on_calendar_menu();
        login_page.verify_and_select_specific_date("Mar", "2025");
        infrastructure_host_page.verify_and_click_on_Infrastructure();
        infrastructure_host_page.click_on_host_Tab();
        infrastructure_page.check_on_no_data_found_IsVissible();
        infrastructure_host_page.click_on_First_Host_Name_From_Host_Table();
        infrastructure_host_page.check_Host_Name_PageDisplayed();
        infrastructure_host_page.click_on_container_Tab();
        infrastructure_host_page.No_Data_found_IsVissible("Containers");
        infrastructure_host_page.verify_correct_data_Display();
    }

    @Test()
    public void Verify_sorting_functionality_for_Containers_List_IS_88(String username, String password) {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        login_page = new Login_Page(driver);
        infrastructure_host_page = new Infrastructure_Host_Page(driver);
        infrastructure_page = new Infrastructure_Page(driver);
        login_page.click_on_email_id_text_box(username);
        login_page.click_on_password_text_box(password);
        login_page.click_on_login_button();
        login_page.click_on_Embrace_your_pro_user_pop_up();
        login_page.isWelcomeToMiddlewarePageDisplayed();
        login_page.verify_and_click_on_calendar_menu();
        login_page.verify_and_select_specific_date("Mar", "2025");
        infrastructure_host_page.verify_and_click_on_Infrastructure();
        infrastructure_host_page.click_on_host_Tab();
        infrastructure_page.check_on_no_data_found_IsVissible();
        infrastructure_host_page.click_on_First_Host_Name_From_Host_Table();
        infrastructure_host_page.check_Host_Name_PageDisplayed();
        infrastructure_host_page.click_on_host_name_Tables_and_Containers();
        infrastructure_host_page.store_container_data_before_sorting();
        infrastructure_host_page.click_on_container_table_Header();
        infrastructure_host_page.verify_HostName_Sorting_List_In_AscendingOrder();
        //     infrastructure_host_page.click_on_container_table_data_ascending_arrow_Button();
        //      infrastructure_host_page.verify_host_name_sorting_list_in_descending_Order();// Descending Order
    }

    @Test()
    public void Verify_Pagination_functionality_IS_89(String username, String password) throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        login_page = new Login_Page(driver);
        infrastructure_host_page = new Infrastructure_Host_Page(driver);
        infrastructure_page = new Infrastructure_Page(driver);
        login_page.click_on_email_id_text_box(username);
        login_page.click_on_password_text_box(password);
        login_page.click_on_login_button();
        login_page.click_on_Embrace_your_pro_user_pop_up();
        login_page.isWelcomeToMiddlewarePageDisplayed();
        login_page.verify_and_click_on_calendar_menu();
        login_page.verify_and_select_specific_date("Mar", "2025");
        infrastructure_host_page.verify_and_click_on_Infrastructure();
        infrastructure_host_page.click_on_host_Tab();
        infrastructure_page.check_on_no_data_found_IsVissible();
        infrastructure_host_page.click_on_First_Host_Name_From_Host_Table();
        infrastructure_host_page.check_Host_Name_PageDisplayed();
        infrastructure_host_page.click_on_container_Tab();
        infrastructure_host_page.No_Data_found_IsVissible("Containers");
    }

    @Test()
    public void Verify_navigation_of_Processes_tab_IS_90(String username, String password) throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        login_page = new Login_Page(driver);
        infrastructure_host_page = new Infrastructure_Host_Page(driver);
        infrastructure_page = new Infrastructure_Page(driver);
        login_page.click_on_email_id_text_box(username);
        login_page.click_on_password_text_box(password);
        login_page.click_on_login_button();
        login_page.click_on_Embrace_your_pro_user_pop_up();
        login_page.isWelcomeToMiddlewarePageDisplayed();
        login_page.verify_and_click_on_calendar_menu();
        login_page.verify_and_select_specific_date("Mar", "2025");
        infrastructure_host_page.verify_and_click_on_Infrastructure();
        infrastructure_host_page.click_on_host_Tab();
        infrastructure_page.check_on_no_data_found_IsVissible();
        infrastructure_host_page.click_on_First_Host_Name_From_Host_Table();
        infrastructure_host_page.check_Host_Name_PageDisplayed();
        infrastructure_host_page.click_on_processes_Tab();
        infrastructure_host_page.No_Data_found_IsVissible("Processes");
        infrastructure_host_page.verify_processes_data_are_Displayed();
    }

    @Test()
    public void Verify_the_presence_of_essential_UI_elements_IS_91(String username, String password) throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        login_page = new Login_Page(driver);
        infrastructure_host_page = new Infrastructure_Host_Page(driver);
        infrastructure_page = new Infrastructure_Page(driver);
        login_page.click_on_email_id_text_box(username);
        login_page.click_on_password_text_box(password);
        login_page.click_on_login_button();
        login_page.click_on_Embrace_your_pro_user_pop_up();
        login_page.isWelcomeToMiddlewarePageDisplayed();
        login_page.verify_and_click_on_calendar_menu();
        login_page.verify_and_select_specific_date("Mar", "2025");
        infrastructure_host_page.verify_and_click_on_Infrastructure();
        infrastructure_host_page.click_on_host_Tab();
        infrastructure_page.check_on_no_data_found_IsVissible();
        infrastructure_host_page.click_on_First_Host_Name_From_Host_Table();
        infrastructure_host_page.check_Host_Name_PageDisplayed();
        infrastructure_host_page.click_on_processes_Tab();
        infrastructure_host_page.verify_UI_element_of_processes_present_on_page();
    }

    @Test()
    public void Verify_the_Global_Calendar_selection_functionality_IS_92(String username, String password) {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        login_page = new Login_Page(driver);
        infrastructure_host_page = new Infrastructure_Host_Page(driver);
        infrastructure_page = new Infrastructure_Page(driver);
        login_page.click_on_email_id_text_box(username);
        login_page.click_on_password_text_box(password);
        login_page.click_on_login_button();
        login_page.click_on_Embrace_your_pro_user_pop_up();
        login_page.isWelcomeToMiddlewarePageDisplayed();
        login_page.verify_and_click_on_calendar_menu();
        login_page.verify_and_select_specific_date("Mar", "2025");
        infrastructure_host_page.verify_and_click_on_Infrastructure();
        infrastructure_host_page.click_on_host_Tab();
        infrastructure_page.check_on_no_data_found_IsVissible();
        infrastructure_host_page.click_on_First_Host_Name_From_Host_Table();
        infrastructure_host_page.click_on_processes_Tab();
        infrastructure_host_page.verify_data_select_range_of_CalenderInContainer();
        login_page.click_on_global_calender_previous_Button();
        infrastructure_host_page.verify_data_select_range_of_CalenderInContainer();
        login_page.click_on_global_calender_forward_Button();
        infrastructure_host_page.verify_data_select_range_of_CalenderInContainer();
    }

    @Test()
    public void Verify_the_search_bar_dropdown_and_AI_based_search_IS_94(String username, String password) {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        login_page = new Login_Page(driver);
        infrastructure_host_page = new Infrastructure_Host_Page(driver);
        infrastructure_page = new Infrastructure_Page(driver);
        login_page.click_on_email_id_text_box(username);
        login_page.click_on_password_text_box(password);
        login_page.click_on_login_button();
        login_page.click_on_Embrace_your_pro_user_pop_up();
        login_page.isWelcomeToMiddlewarePageDisplayed();
        login_page.verify_and_click_on_calendar_menu();
        login_page.verify_and_select_specific_date("Mar", "2025");
        infrastructure_host_page.verify_and_click_on_Infrastructure();
        infrastructure_host_page.click_on_host_Tab();
        infrastructure_page.check_on_no_data_found_IsVissible();
        infrastructure_host_page.click_on_First_Host_Name_From_Host_Table();
        infrastructure_host_page.check_Host_Name_PageDisplayed();
        infrastructure_host_page.click_on_processes_Tab();
        infrastructure_host_page.No_Data_found_IsVissible("Processes");
        infrastructure_host_page.click_on_global_search_of_processes();
        infrastructure_host_page.verify_Ai_Search_bar();
    }

    @Test()
    public void Verify_that_no_results_appear_for_an_invalid_search_IS_96(String username, String password) throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        login_page = new Login_Page(driver);
        infrastructure_host_page = new Infrastructure_Host_Page(driver);
        infrastructure_page = new Infrastructure_Page(driver);
        login_page.click_on_email_id_text_box(username);
        login_page.click_on_password_text_box(password);
        login_page.click_on_login_button();
        login_page.click_on_Embrace_your_pro_user_pop_up();
        login_page.isWelcomeToMiddlewarePageDisplayed();
        login_page.verify_and_click_on_calendar_menu();
        login_page.verify_and_select_specific_date("Mar", "2025");
        infrastructure_host_page.verify_and_click_on_Infrastructure();
        infrastructure_host_page.click_on_host_Tab();
        infrastructure_page.check_on_no_data_found_IsVissible();
        infrastructure_host_page.click_on_First_Host_Name_From_Host_Table();
        infrastructure_host_page.click_on_processes_Tab();
        infrastructure_host_page.No_Data_found_IsVissible("Process");
        infrastructure_host_page.click_on_global_search_of_processes();
        infrastructure_host_page.enter_invalid_host_name_in_global_search("host.name", "= Equal to", "ManualTesting");
        infrastructure_host_page.click_on_apply_filter_Button();
        infrastructure_host_page.verify_No_Data_Found_MessageDisplayed();
    }

    @Test()
    public void Verify_the_Customize_button_functionality_IS_97(String username, String password) throws InterruptedException {
        //   Verify search functionality in the Customize menu IS_98
        //   Verify Default button functionality in Customize menu IS_99
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        login_page = new Login_Page(driver);
        infrastructure_host_page = new Infrastructure_Host_Page(driver);
        infrastructure_page = new Infrastructure_Page(driver);
        login_page.click_on_email_id_text_box(username);
        login_page.click_on_password_text_box(password);
        login_page.click_on_login_button();
        login_page.click_on_Embrace_your_pro_user_pop_up();
        login_page.isWelcomeToMiddlewarePageDisplayed();
        login_page.verify_and_click_on_calendar_menu();
        login_page.verify_and_select_specific_date("Mar", "2025");
        infrastructure_host_page.verify_and_click_on_Infrastructure();
        infrastructure_host_page.click_on_host_Tab();
        infrastructure_page.check_on_no_data_found_IsVissible();
        infrastructure_host_page.click_on_First_Host_Name_From_Host_Table();
        infrastructure_host_page.check_Host_Name_PageDisplayed();
        infrastructure_host_page.click_on_processes_Tab();
        infrastructure_host_page.No_Data_found_IsVissible("Processes");
        infrastructure_host_page.click_on_customize_container_Button();
        infrastructure_host_page.verify_customize_option_container_visible_present_on_Page();
        infrastructure_host_page.verify_customize_option_container_visible_present("Host");
        infrastructure_host_page.click_on_apply_changes_Button();
        infrastructure_host_page.verify_apply_filter_host_name_present_on_Page();
        infrastructure_host_page.click_on_customize_container_Button();
        infrastructure_host_page.click_on_clear_all_Button();
        infrastructure_host_page.click_on_customize_container_Button();
        infrastructure_host_page.verify_default_column_reset_default_State();
    }

    @Test()
    public void Verify_Apply_Changes_and_Cancel_buttons_in_Customize_menu_IS_100(String username, String password) {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        login_page = new Login_Page(driver);
        infrastructure_host_page = new Infrastructure_Host_Page(driver);
        infrastructure_page = new Infrastructure_Page(driver);
        login_page.click_on_email_id_text_box(username);
        login_page.click_on_password_text_box(password);
        login_page.click_on_login_button();
        login_page.click_on_Embrace_your_pro_user_pop_up();
        login_page.isWelcomeToMiddlewarePageDisplayed();
        login_page.verify_and_click_on_calendar_menu();
        login_page.verify_and_select_specific_date("Mar", "2025");
        infrastructure_host_page.verify_and_click_on_Infrastructure();
        infrastructure_host_page.click_on_host_Tab();
        infrastructure_page.check_on_no_data_found_IsVissible();
        infrastructure_host_page.click_on_First_Host_Name_From_Host_Table();
        infrastructure_host_page.check_Host_Name_PageDisplayed();
        infrastructure_host_page.click_on_processes_Tab();
        infrastructure_host_page.No_Data_found_IsVissible("Processes");
        infrastructure_host_page.click_on_customize_container_Button();
        infrastructure_host_page.verify_and_uncheck_option_from_customize_container();
        infrastructure_host_page.checked_options_from_customize_container();
        infrastructure_host_page.click_on_customize_container_apply_changes_button();
        infrastructure_host_page.click_on_customize_container_Button();
        infrastructure_host_page.click_on_cancel_button_customize_container();
    }

    @Test()
    public void Verify_Available_Processes_list_displays_correctly_IS_101(String username, String password) {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        login_page = new Login_Page(driver);
        infrastructure_host_page = new Infrastructure_Host_Page(driver);
        infrastructure_page = new Infrastructure_Page(driver);
        login_page.click_on_email_id_text_box(username);
        login_page.click_on_password_text_box(password);
        login_page.click_on_login_button();
        login_page.click_on_Embrace_your_pro_user_pop_up();
        login_page.isWelcomeToMiddlewarePageDisplayed();
        login_page.verify_and_click_on_calendar_menu();
        login_page.verify_and_select_specific_date("Mar", "2025");
        infrastructure_host_page.verify_and_click_on_Infrastructure();
        infrastructure_host_page.click_on_host_Tab();
        infrastructure_page.check_on_no_data_found_IsVissible();
        infrastructure_host_page.click_on_First_Host_Name_From_Host_Table();
        infrastructure_host_page.check_Host_Name_PageDisplayed();
        infrastructure_host_page.click_on_processes_Tab();
        infrastructure_host_page.No_Data_found_IsVissible("Processes");
        infrastructure_host_page.verify_processes_data_are_displayed();
        infrastructure_host_page.verify_process_data_are_displayed();
    }

    @Test()
    public void Verify_sorting_functionality_for_Containers_List_IS_102(String username, String password) {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        login_page = new Login_Page(driver);
        infrastructure_host_page = new Infrastructure_Host_Page(driver);
        infrastructure_page = new Infrastructure_Page(driver);
        login_page.click_on_email_id_text_box(username);
        login_page.click_on_password_text_box(password);
        login_page.click_on_login_button();
        login_page.click_on_Embrace_your_pro_user_pop_up();
        login_page.isWelcomeToMiddlewarePageDisplayed();
        login_page.verify_and_click_on_calendar_menu();
        login_page.verify_and_select_specific_date("Mar", "2025");
        infrastructure_host_page.verify_and_click_on_Infrastructure();
        infrastructure_host_page.click_on_host_Tab();
        infrastructure_page.check_on_no_data_found_IsVissible();
        infrastructure_host_page.click_on_First_Host_Name_From_Host_Table();
        infrastructure_host_page.check_Host_Name_PageDisplayed();
        infrastructure_host_page.click_on_processes_Tab();
        infrastructure_host_page.No_Data_found_IsVissible("Processes");
        infrastructure_host_page.store_container_data_before_sorting();
        infrastructure_host_page.click_on_container_table_Header();
        infrastructure_host_page.verify_HostName_Sorting_List_In_AscendingOrder();
        infrastructure_host_page.click_on_container_table_data_ascending_arrow_Button();
        //      infrastructure_host_page.verify_host_name_sorting_list_in_descending_Order();// Descending Order
    }

    @Test()
    public void Verify_page_navigation_to_Process_Info_IS_103(String username, String password) {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        login_page = new Login_Page(driver);
        infrastructure_host_page = new Infrastructure_Host_Page(driver);
        infrastructure_page = new Infrastructure_Page(driver);
        login_page.click_on_email_id_text_box(username);
        login_page.click_on_password_text_box(password);
        login_page.click_on_login_button();
        login_page.click_on_Embrace_your_pro_user_pop_up();
        login_page.isWelcomeToMiddlewarePageDisplayed();
        login_page.verify_and_click_on_calendar_menu();
        login_page.verify_and_select_specific_date("Mar", "2025");
        infrastructure_host_page.verify_and_click_on_Infrastructure();
        infrastructure_host_page.click_on_host_Tab();
        infrastructure_page.check_on_no_data_found_IsVissible();
        infrastructure_host_page.click_on_First_Host_Name_From_Host_Table();
        infrastructure_host_page.check_Host_Name_PageDisplayed();
        infrastructure_host_page.click_on_processes_Tab();
        infrastructure_host_page.No_Data_found_IsVissible("Processes");
        infrastructure_host_page.click_on_first_processes_id_table();
        infrastructure_host_page.verify_processes__page_visible();
        infrastructure_page.verify_option_container_Lists();
    }

    @Test()
    public void Verify_Operating_System_information_display_IS_107(String username, String password) throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        login_page = new Login_Page(driver);
        infrastructure_host_page = new Infrastructure_Host_Page(driver);
        infrastructure_page = new Infrastructure_Page(driver);
        login_page.click_on_email_id_text_box(username);
        login_page.click_on_password_text_box(password);
        login_page.click_on_login_button();
        login_page.click_on_Embrace_your_pro_user_pop_up();
        login_page.isWelcomeToMiddlewarePageDisplayed();
        infrastructure_host_page.verify_and_click_on_Infrastructure();
        infrastructure_host_page.click_on_host_Tab();
        infrastructure_host_page.click_on_processes_check_data_isPresent();
        infrastructure_host_page.click_on_first_processes_id_table();
        infrastructure_host_page.verify_operating_system_display_on_page();
    }

    @Test()
    public void Verify_CPU_Utilization_data_IS_108(String username, String password) throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        login_page = new Login_Page(driver);
        infrastructure_host_page = new Infrastructure_Host_Page(driver);
        infrastructure_page = new Infrastructure_Page(driver);
        login_page.click_on_email_id_text_box(username);
        login_page.click_on_password_text_box(password);
        login_page.click_on_login_button();
        login_page.click_on_Embrace_your_pro_user_pop_up();
        login_page.isWelcomeToMiddlewarePageDisplayed();
        infrastructure_host_page.verify_and_click_on_Infrastructure();
        infrastructure_host_page.click_on_host_Tab();
        infrastructure_host_page.click_on_processes_check_data_isPresent();
        infrastructure_host_page.click_on_first_processes_id_table();
        infrastructure_host_page.verify_cpu_utilization_value_display_on_process_info_page();
    }

    @Test()
    public void Verify_Memory_Utilization_data_IS_109(String username, String password) throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        login_page = new Login_Page(driver);
        infrastructure_host_page = new Infrastructure_Host_Page(driver);
        infrastructure_page = new Infrastructure_Page(driver);
        login_page.click_on_email_id_text_box(username);
        login_page.click_on_password_text_box(password);
        login_page.click_on_login_button();
        login_page.click_on_Embrace_your_pro_user_pop_up();
        login_page.isWelcomeToMiddlewarePageDisplayed();
        login_page.verify_and_click_on_calendar_menu();
        login_page.verify_and_select_specific_date("Mar", "2025");
        infrastructure_host_page.verify_and_click_on_Infrastructure();
        infrastructure_host_page.click_on_host_Tab();
        infrastructure_page.check_on_no_data_found_IsVissible();
        infrastructure_page.verify_host_name_present_on_page();
        infrastructure_page.verify_operating_system_present_on_page();
        infrastructure_host_page.click_on_First_Host_Name_From_Host_Table();
        infrastructure_host_page.check_Host_Name_PageDisplayed();
        infrastructure_host_page.click_on_processes_Tab();
        infrastructure_host_page.No_Data_found_IsVissible("Process");
        infrastructure_host_page.click_on_customize_container_Button();
        infrastructure_host_page.verify_and_uncheck_option_from_customize_container();
        infrastructure_host_page.enter_customize_container_option_in_SearchBox("Memory Usage Percent");
        infrastructure_host_page.click_on_select_customize_option_container();
        infrastructure_host_page.click_on_customize_container_apply_changes_button();
        infrastructure_host_page.click_on_first_processes_id_table();
        infrastructure_host_page.verify_memory_usage_value_display_on_process_info_page();
    }

    @Test()
    public void Verify_Disk_I_O_data_IS_110(String username, String password) throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        login_page = new Login_Page(driver);
        infrastructure_host_page = new Infrastructure_Host_Page(driver);
        infrastructure_page = new Infrastructure_Page(driver);
        login_page.click_on_email_id_text_box(username);
        login_page.click_on_password_text_box(password);
        login_page.click_on_login_button();
        login_page.click_on_Embrace_your_pro_user_pop_up();
        login_page.isWelcomeToMiddlewarePageDisplayed();
        login_page.verify_and_click_on_calendar_menu();
        login_page.verify_and_select_specific_date("Mar", "2025");
        infrastructure_host_page.verify_and_click_on_Infrastructure();
        infrastructure_host_page.click_on_host_Tab();
        infrastructure_page.check_on_no_data_found_IsVissible();
        infrastructure_page.verify_host_name_present_on_page();
        infrastructure_page.verify_operating_system_present_on_page();
        infrastructure_host_page.click_on_First_Host_Name_From_Host_Table();
        infrastructure_host_page.check_Host_Name_PageDisplayed();
        infrastructure_host_page.click_on_processes_Tab();
        infrastructure_host_page.No_Data_found_IsVissible("Process");
        infrastructure_host_page.click_on_customize_container_Button();
        infrastructure_host_page.verify_and_uncheck_option_from_customize_container();
        infrastructure_host_page.enter_customize_container_option_in_SearchBox("Disk IO");
        infrastructure_host_page.click_on_select_customize_option_container();
        infrastructure_host_page.click_on_customize_container_apply_changes_button();
        infrastructure_host_page.click_on_first_processes_id_table();
        infrastructure_host_page.verify_DISK_IO_display_on_process_info_page();
    }

    @Test()
    public void Verify_Virtual_Usage_data_IS_112(String username, String password) throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        login_page = new Login_Page(driver);
        infrastructure_host_page = new Infrastructure_Host_Page(driver);
        infrastructure_page = new Infrastructure_Page(driver);
        login_page.click_on_email_id_text_box(username);
        login_page.click_on_password_text_box(password);
        login_page.click_on_login_button();
        login_page.click_on_Embrace_your_pro_user_pop_up();
        login_page.isWelcomeToMiddlewarePageDisplayed();
        login_page.verify_and_click_on_calendar_menu();
        login_page.verify_and_select_specific_date("Mar", "2025");
        infrastructure_host_page.verify_and_click_on_Infrastructure();
        infrastructure_host_page.click_on_host_Tab();
        infrastructure_page.check_on_no_data_found_IsVissible();
        infrastructure_page.verify_host_name_present_on_page();
        infrastructure_page.verify_operating_system_present_on_page();
        infrastructure_host_page.click_on_First_Host_Name_From_Host_Table();
        infrastructure_host_page.check_Host_Name_PageDisplayed();
        infrastructure_host_page.click_on_processes_Tab();
        infrastructure_host_page.No_Data_found_IsVissible("Process");
        infrastructure_host_page.click_on_customize_container_Button();
        infrastructure_host_page.verify_and_uncheck_option_from_customize_container();
        infrastructure_host_page.enter_customize_container_option_in_SearchBox("Virtual Usage");
        infrastructure_host_page.click_on_select_customize_option_container();
        infrastructure_host_page.click_on_customize_container_apply_changes_button();
        infrastructure_host_page.click_on_first_processes_id_table();
        infrastructure_host_page.verify_Virtual_Usage_display_on_process_info_page();
    }

    @Test()
    public void Verify_Process_Host_Information_IS_113(String username, String password) throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        login_page = new Login_Page(driver);
        infrastructure_host_page = new Infrastructure_Host_Page(driver);
        infrastructure_page = new Infrastructure_Page(driver);
        login_page.click_on_email_id_text_box(username);
        login_page.click_on_password_text_box(password);
        login_page.click_on_login_button();
        login_page.click_on_Embrace_your_pro_user_pop_up();
        login_page.isWelcomeToMiddlewarePageDisplayed();
//        login_page.verify_and_click_on_calendar_menu();
//        login_page.verify_and_select_specific_date("Mar", "2025");
        infrastructure_host_page.verify_and_click_on_Infrastructure();
        infrastructure_host_page.click_on_host_Tab();
        infrastructure_host_page.verify_and_click_on_Host_Name_in_UP_State();
//        infrastructure_page.check_on_no_data_found_IsVissible();
//        infrastructure_host_page.click_on_First_Host_Name_From_Host_Table();
//        infrastructure_host_page.check_Host_Name_PageDisplayed();
        infrastructure_host_page.click_on_processes_Tab();
      //  infrastructure_host_page.No_Data_found_IsVissible("Process");
        infrastructure_host_page.click_on_customize_container_Button();
        infrastructure_host_page.verify_and_uncheck_option_from_customize_container();
        infrastructure_host_page.enter_customize_container_option_in_SearchBox("Host");
        infrastructure_host_page.click_on_select_customize_option_container();
        infrastructure_host_page.click_on_customize_container_apply_changes_button();
        infrastructure_host_page.click_on_first_processes_id_table();
        infrastructure_host_page.verify_Host_Name_display_on_process_info_page();
    }

    @Test()
    public void Verify_Process_ID_display_IS_114(String username, String password) throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        login_page = new Login_Page(driver);
        infrastructure_host_page = new Infrastructure_Host_Page(driver);
        infrastructure_page = new Infrastructure_Page(driver);
        login_page.click_on_email_id_text_box(username);
        login_page.click_on_password_text_box(password);
        login_page.click_on_login_button();
        login_page.click_on_Embrace_your_pro_user_pop_up();
        login_page.isWelcomeToMiddlewarePageDisplayed();
        login_page.verify_and_click_on_calendar_menu();
        login_page.verify_and_select_specific_date("Mar", "2025");
        infrastructure_host_page.verify_and_click_on_Infrastructure();
        infrastructure_host_page.click_on_host_Tab();
        infrastructure_page.check_on_no_data_found_IsVissible();
        infrastructure_host_page.click_on_First_Host_Name_From_Host_Table();
        infrastructure_host_page.check_Host_Name_PageDisplayed();
        infrastructure_host_page.verify_and_check_clickable_on_Host();
        infrastructure_host_page.click_on_processes_Tab();
        infrastructure_host_page.No_Data_found_IsVissible("Process");
        infrastructure_host_page.click_on_customize_container_Button();
        infrastructure_host_page.verify_and_uncheck_option_from_customize_container();
        infrastructure_host_page.enter_customize_container_option_in_SearchBox("PID");
        infrastructure_host_page.click_on_select_customize_option_container();
        infrastructure_host_page.click_on_customize_container_apply_changes_button();
        infrastructure_host_page.click_on_first_processes_id_table();
        infrastructure_host_page.verify_Processes_ID_display_on_process_info_page();
    }

    @Test()
    public void Verify_Process_Owner_display_IS_115(String username, String password) {
        //    Verify_Full_Command_Details_IS_116
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        login_page = new Login_Page(driver);
        infrastructure_host_page = new Infrastructure_Host_Page(driver);
        infrastructure_page = new Infrastructure_Page(driver);
        login_page.click_on_email_id_text_box(username);
        login_page.click_on_password_text_box(password);
        login_page.click_on_login_button();
        login_page.click_on_Embrace_your_pro_user_pop_up();
        login_page.isWelcomeToMiddlewarePageDisplayed();
        login_page.verify_and_click_on_calendar_menu();
        login_page.verify_and_select_specific_date("Mar", "2025");
        infrastructure_host_page.verify_and_click_on_Infrastructure();
        infrastructure_host_page.click_on_host_Tab();
        infrastructure_page.check_on_no_data_found_IsVissible();
        infrastructure_host_page.click_on_First_Host_Name_From_Host_Table();
        infrastructure_host_page.check_Host_Name_PageDisplayed();
        infrastructure_host_page.click_on_processes_Tab();
        infrastructure_host_page.No_Data_found_IsVissible("Process");
        infrastructure_host_page.click_on_first_processes_id_table();
        infrastructure_host_page.verify_Process_owner_display_on_process_info_page();
    }

    @Test()
    public void Verify_Copy_Command_Functionality_IS_117(String username, String password) {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        login_page = new Login_Page(driver);
        infrastructure_host_page = new Infrastructure_Host_Page(driver);
        infrastructure_page = new Infrastructure_Page(driver);
        login_page.click_on_email_id_text_box(username);
        login_page.click_on_password_text_box(password);
        login_page.click_on_login_button();
        login_page.click_on_Embrace_your_pro_user_pop_up();
        login_page.isWelcomeToMiddlewarePageDisplayed();
        login_page.verify_and_click_on_calendar_menu();
        login_page.verify_and_select_specific_date("Mar", "2025");
        infrastructure_host_page.verify_and_click_on_Infrastructure();
        infrastructure_host_page.click_on_host_Tab();
        infrastructure_page.check_on_no_data_found_IsVissible();
        infrastructure_host_page.click_on_First_Host_Name_From_Host_Table();
        infrastructure_host_page.check_Host_Name_PageDisplayed();
        infrastructure_host_page.click_on_processes_Tab();
        infrastructure_host_page.No_Data_found_IsVissible("Process");
        infrastructure_host_page.click_on_first_processes_id_table();
        infrastructure_host_page.click_on_full_command();
    }

    @Test()
    public void Verify_Metric_tab_IS_118(String username, String password) throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        login_page = new Login_Page(driver);
        infrastructure_host_page = new Infrastructure_Host_Page(driver);
        infrastructure_page = new Infrastructure_Page(driver);
        login_page.click_on_email_id_text_box(username);
        login_page.click_on_password_text_box(password);
        login_page.click_on_login_button();
        login_page.click_on_Embrace_your_pro_user_pop_up();
        login_page.isWelcomeToMiddlewarePageDisplayed();
        login_page.verify_and_click_on_calendar_menu();
        login_page.verify_and_select_specific_date("Mar", "2025");
        infrastructure_host_page.verify_and_click_on_Infrastructure();
        infrastructure_host_page.click_on_host_Tab();
        infrastructure_page.check_on_no_data_found_IsVissible();
        infrastructure_host_page.click_on_First_Host_Name_From_Host_Table();
        infrastructure_host_page.check_Host_Name_PageDisplayed();
        infrastructure_host_page.click_on_processes_Tab();
        infrastructure_host_page.No_Data_found_IsVissible("Process");
        infrastructure_host_page.click_on_first_processes_id_table();
        infrastructure_host_page.click_on_process_info_Metrics_Tab();
        infrastructure_page.validate_graphs();
        infrastructure_host_page.click_on_process_info_Logs_Tab();
    }

    @Test()
    public void Verify_navigation_of_Logs_tab_IS_122(String username, String password) throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        login_page = new Login_Page(driver);
        infrastructure_host_page = new Infrastructure_Host_Page(driver);
        infrastructure_page = new Infrastructure_Page(driver);
        login_page.click_on_email_id_text_box(username);
        login_page.click_on_password_text_box(password);
        login_page.click_on_login_button();
        login_page.click_on_Embrace_your_pro_user_pop_up();
        login_page.isWelcomeToMiddlewarePageDisplayed();
        login_page.verify_and_click_on_calendar_menu();
        login_page.verify_and_select_specific_date("Mar", "2025");
        infrastructure_host_page.verify_and_click_on_Infrastructure();
        infrastructure_host_page.click_on_host_Tab();
        infrastructure_page.check_on_no_data_found_IsVissible();
        infrastructure_host_page.click_on_First_Host_Name_From_Host_Table();
        infrastructure_host_page.check_Host_Name_PageDisplayed();
        infrastructure_host_page.click_on_Logs_Tab();
        infrastructure_host_page.verify_UI_element_present_on_Logs_Tabs();

    }

    @Test()
    public void Verify_Source_Log_Trend_graph_visibility_IS_123(String username, String password) throws InterruptedException {
        //    Verify that hovering over the graph displays tooltip data_IS_124
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        login_page = new Login_Page(driver);
        infrastructure_host_page = new Infrastructure_Host_Page(driver);
        infrastructure_page = new Infrastructure_Page(driver);
        login_page.click_on_email_id_text_box(username);
        login_page.click_on_password_text_box(password);
        login_page.click_on_login_button();
        login_page.click_on_Embrace_your_pro_user_pop_up();
        login_page.isWelcomeToMiddlewarePageDisplayed();
        login_page.verify_and_click_on_calendar_menu();
        login_page.verify_and_select_specific_date("Mar", "2025");
        infrastructure_host_page.verify_and_click_on_Infrastructure();
        infrastructure_host_page.click_on_host_Tab();
        infrastructure_page.check_on_no_data_found_IsVissible();
        infrastructure_host_page.click_on_host_name_Table();
        infrastructure_host_page.hover_on_graph();
    }

    @Test()
    public void Verify_date_time_filter_functionality_IS_126(String username, String password) throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        login_page = new Login_Page(driver);
        infrastructure_host_page = new Infrastructure_Host_Page(driver);
        infrastructure_page = new Infrastructure_Page(driver);
        login_page.click_on_email_id_text_box(username);
        login_page.click_on_password_text_box(password);
        login_page.click_on_login_button();
        login_page.click_on_Embrace_your_pro_user_pop_up();
        login_page.isWelcomeToMiddlewarePageDisplayed();
        login_page.verify_and_click_on_calendar_menu();
        login_page.verify_and_select_specific_date("Mar", "2025");
        infrastructure_host_page.verify_and_click_on_Infrastructure();
        infrastructure_host_page.click_on_host_Tab();
        infrastructure_page.check_on_no_data_found_IsVissible();
        infrastructure_host_page.click_on_host_name_Table();
        infrastructure_host_page.verify_date_and_Time();
    }

    @Test()
    public void Verify_log_entries_display_IS_127(String username, String password) throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        login_page = new Login_Page(driver);
        infrastructure_host_page = new Infrastructure_Host_Page(driver);
        infrastructure_page = new Infrastructure_Page(driver);
        login_page.click_on_email_id_text_box(username);
        login_page.click_on_password_text_box(password);
        login_page.click_on_login_button();
        login_page.click_on_Embrace_your_pro_user_pop_up();
        login_page.isWelcomeToMiddlewarePageDisplayed();
        login_page.verify_and_click_on_calendar_menu();
        login_page.verify_and_select_specific_date("Mar", "2025");
        infrastructure_host_page.verify_and_click_on_Infrastructure();
        infrastructure_host_page.click_on_host_Tab();
        infrastructure_page.check_on_no_data_found_IsVissible();
        infrastructure_host_page.click_on_host_name_Table();
        infrastructure_host_page.verify_Logs_present_inside_the_table();
    }

    @Test()
    public void Verify_log_message_expand_collapse_IS_128(String username, String password) throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        login_page = new Login_Page(driver);
        infrastructure_host_page = new Infrastructure_Host_Page(driver);
        infrastructure_page = new Infrastructure_Page(driver);
        login_page.click_on_email_id_text_box(username);
        login_page.click_on_password_text_box(password);
        login_page.click_on_login_button();
        login_page.click_on_Embrace_your_pro_user_pop_up();
        login_page.isWelcomeToMiddlewarePageDisplayed();
        login_page.verify_and_click_on_calendar_menu();
        login_page.verify_and_select_specific_date("Mar", "2025");
        infrastructure_host_page.verify_and_click_on_Infrastructure();
        infrastructure_host_page.click_on_host_Tab();
        infrastructure_page.check_on_no_data_found_IsVissible();
        infrastructure_host_page.click_on_host_name_Table();
        infrastructure_host_page.expand_Logs_Table();
        infrastructure_host_page.verify_host_Name_present_inside_Logs_table();
    }
    @Test()
    public void Verify_scroll_functionality_for_logs_IS_129(String username, String password) throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        login_page = new Login_Page(driver);
        infrastructure_host_page = new Infrastructure_Host_Page(driver);
        infrastructure_page = new Infrastructure_Page(driver);
        login_page.click_on_email_id_text_box(username);
        login_page.click_on_password_text_box(password);
        login_page.click_on_login_button();
        login_page.click_on_Embrace_your_pro_user_pop_up();
        login_page.isWelcomeToMiddlewarePageDisplayed();
        login_page.verify_and_click_on_calendar_menu();
        login_page.verify_and_select_specific_date("Mar", "2025");
        infrastructure_host_page.verify_and_click_on_Infrastructure();
        infrastructure_host_page.click_on_host_Tab();
        infrastructure_page.check_on_no_data_found_IsVissible();
        infrastructure_host_page.click_on_host_name_Table();
      //  infrastructure_host_page.expand_Logs_Table();
        infrastructure_host_page.scroll_to_bottom_of_logs_table();
    }
    @Test()
    public void  Verify_total_logs_count_display_IS_130(String username, String password) throws InterruptedException {
     //   Verify download logs functionality_IS_131
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        login_page = new Login_Page(driver);
        infrastructure_host_page = new Infrastructure_Host_Page(driver);
        infrastructure_page = new Infrastructure_Page(driver);
        login_page.click_on_email_id_text_box(username);
        login_page.click_on_password_text_box(password);
        login_page.click_on_login_button();
        login_page.click_on_Embrace_your_pro_user_pop_up();
        login_page.isWelcomeToMiddlewarePageDisplayed();
        login_page.click_on_Embrace_your_pro_user_pop_up();
        login_page.verify_and_click_on_calendar_menu();
        login_page.verify_and_select_specific_date("Mar", "2025");
        infrastructure_host_page.verify_and_click_on_Infrastructure();
        infrastructure_host_page.click_on_host_Tab();
        infrastructure_page.check_on_no_data_found_IsVissible();
        infrastructure_host_page.click_on_host_name_Table();
        infrastructure_host_page.verify_total_logs_with_actual_Logs();
        infrastructure_host_page.click_on_download_button_of_Logs();
    }
    @Test()
    public void Verify_Pagination_functionality_IS_134(String username, String password) throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        login_page = new Login_Page(driver);
        infrastructure_host_page = new Infrastructure_Host_Page(driver);
        infrastructure_page = new Infrastructure_Page(driver);
        login_page.click_on_email_id_text_box(username);
        login_page.click_on_password_text_box(password);
        login_page.click_on_login_button();
        login_page.click_on_Embrace_your_pro_user_pop_up();
        login_page.isWelcomeToMiddlewarePageDisplayed();
        login_page.click_on_Embrace_your_pro_user_pop_up();
        login_page.verify_and_click_on_calendar_menu();
        login_page.verify_and_select_specific_date("Mar", "2025");
        infrastructure_host_page.verify_and_click_on_Infrastructure();
        infrastructure_host_page.click_on_host_Tab();
        infrastructure_page.check_on_no_data_found_IsVissible();
        infrastructure_host_page.click_on_host_name_Table();
        infrastructure_host_page.verify_showing_result_of_Pagination();
        infrastructure_host_page.click_on_next_button_of_Pagination();
    }
    @Test()
    public void Verify_navigation_of_APM_Services_tab_IS_136(String username, String password) throws InterruptedException{
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        login_page = new Login_Page(driver);
        infrastructure_host_page = new Infrastructure_Host_Page(driver);
        infrastructure_page = new Infrastructure_Page(driver);
        login_page.click_on_email_id_text_box(username);
        login_page.click_on_password_text_box(password);
        login_page.click_on_login_button();
        login_page.click_on_Embrace_your_pro_user_pop_up();
        login_page.isWelcomeToMiddlewarePageDisplayed();
        infrastructure_host_page.verify_and_click_on_Infrastructure();
        infrastructure_host_page.click_on_host_Tab();
        infrastructure_host_page.verify_and_click_on_Host_Name_in_UP_State();
        infrastructure_host_page.verify_UI_element_APM_Services();
        infrastructure_host_page.verify_the_APM_Service_Data();
    }
    @Test()
    public void Verify_the_Global_Calendar_selection_functionality_IS_137(String username, String password) throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        login_page = new Login_Page(driver);
        infrastructure_host_page = new Infrastructure_Host_Page(driver);
        infrastructure_page = new Infrastructure_Page(driver);
        login_page.click_on_email_id_text_box(username);
        login_page.click_on_password_text_box(password);
        login_page.click_on_login_button();
        login_page.click_on_Embrace_your_pro_user_pop_up();
        login_page.isWelcomeToMiddlewarePageDisplayed();
        infrastructure_host_page.verify_and_click_on_Infrastructure();
        infrastructure_host_page.click_on_host_Tab();
        infrastructure_host_page.verify_and_click_on_Host_Name_in_UP_State();
        infrastructure_host_page.click_on_calender_menu_button();
        login_page.verify_and_select_specific_date("Mar", "2025");
        infrastructure_host_page.No_details_found();
    }
    @Test()
    public void Verify_the_Previous_and_Next_buttons_for_Global_Calendar_IS_138(String username, String password) throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        login_page = new Login_Page(driver);
        infrastructure_host_page = new Infrastructure_Host_Page(driver);
        infrastructure_page = new Infrastructure_Page(driver);
        login_page.click_on_email_id_text_box(username);
        login_page.click_on_password_text_box(password);
        login_page.click_on_login_button();
        login_page.click_on_Embrace_your_pro_user_pop_up();
        login_page.isWelcomeToMiddlewarePageDisplayed();
        infrastructure_host_page.verify_and_click_on_Infrastructure();
        infrastructure_host_page.click_on_host_Tab();
        infrastructure_host_page.verify_and_click_on_Host_Name_in_UP_State();
        infrastructure_host_page.click_on_date_picker_previous_button();
       // infrastructure_host_page.verify_data_after_clicking_on_date_picker_button();
        infrastructure_host_page.verify_the_APM_Service_Data();
        infrastructure_host_page.click_on_date_picker_forward_button();
        infrastructure_host_page.verify_the_APM_Service_Data();
    }
    @Test()
    public void Verify_the_Customize_button_functionality_IS_139(String username, String password) throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        login_page = new Login_Page(driver);
        infrastructure_host_page = new Infrastructure_Host_Page(driver);
        infrastructure_page = new Infrastructure_Page(driver);
        login_page.click_on_email_id_text_box(username);
        login_page.click_on_password_text_box(password);
        login_page.click_on_login_button();
        login_page.click_on_Embrace_your_pro_user_pop_up();
        login_page.isWelcomeToMiddlewarePageDisplayed();
        infrastructure_host_page.verify_and_click_on_Infrastructure();
        infrastructure_host_page.click_on_host_Tab();
        infrastructure_host_page.verify_and_click_on_Host_Name_in_UP_State();
        infrastructure_page.click_on_apm_service_customize_button();
        infrastructure_host_page.verify_and_check_option_from_customize_container();
    }
    @Test()
    public void Verify_search_functionality_in_the_Customize_menu_IS_140(String username, String password) throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        login_page = new Login_Page(driver);
        infrastructure_host_page = new Infrastructure_Host_Page(driver);
        infrastructure_page = new Infrastructure_Page(driver);
        login_page.click_on_email_id_text_box(username);
        login_page.click_on_password_text_box(password);
        login_page.click_on_login_button();
        login_page.click_on_Embrace_your_pro_user_pop_up();
        login_page.isWelcomeToMiddlewarePageDisplayed();
        infrastructure_host_page.verify_and_click_on_Infrastructure();
        infrastructure_host_page.click_on_host_Tab();
        infrastructure_host_page.verify_and_click_on_Host_Name_in_UP_State();
        infrastructure_page.click_on_apm_service_customize_button();
        infrastructure_page.unselect_customize_container_checkbox("Requests");
        infrastructure_host_page.get_Request_value_from_APM_table();
        infrastructure_host_page.click_on_service_table();
        infrastructure_host_page.verify_Request_display_on_service_info_page();
    }
    @Test()
    public void Verify_Default_button_functionality_in_Customize_menu_IS_141(String username, String password) throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        login_page = new Login_Page(driver);
        infrastructure_host_page = new Infrastructure_Host_Page(driver);
        infrastructure_page = new Infrastructure_Page(driver);
        login_page.click_on_email_id_text_box(username);
        login_page.click_on_password_text_box(password);
        login_page.click_on_login_button();
        login_page.click_on_Embrace_your_pro_user_pop_up();
        login_page.isWelcomeToMiddlewarePageDisplayed();
        infrastructure_host_page.verify_and_click_on_Infrastructure();
        infrastructure_host_page.click_on_host_Tab();
        infrastructure_host_page.verify_and_click_on_Host_Name_in_UP_State();
        infrastructure_page.click_on_apm_service_customize_button();
        infrastructure_host_page.click_on_clear_all_Button();
        infrastructure_page.click_on_apm_service_customize_button();
        infrastructure_host_page.verify_default_column_reset_default_State();
    }
    @Test()
    public void Verify_Apply_Changes_and_Cancel_buttons_in_Customize_menu_IS_142(String username, String password) throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        login_page = new Login_Page(driver);
        infrastructure_host_page = new Infrastructure_Host_Page(driver);
        infrastructure_page = new Infrastructure_Page(driver);
        login_page.click_on_email_id_text_box(username);
        login_page.click_on_password_text_box(password);
        login_page.click_on_login_button();
        login_page.click_on_Embrace_your_pro_user_pop_up();
        login_page.isWelcomeToMiddlewarePageDisplayed();
        infrastructure_host_page.verify_and_click_on_Infrastructure();
        infrastructure_host_page.click_on_host_Tab();
        infrastructure_host_page.verify_and_click_on_Host_Name_in_UP_State();
        infrastructure_page.click_on_apm_service_customize_button();
        infrastructure_page.unselect_customize_container_checkbox("Requests");
        infrastructure_host_page.get_Request_value_from_APM_table();
        infrastructure_page.click_on_apm_service_customize_button();
        infrastructure_host_page.click_on_cancel_button_customize_container();
        infrastructure_host_page.verify_APM_table_after_clicking_on_cancel_button();
    }
    @Test()
    public void Verify_that_clicking_the_icon_displays(String username, String password) throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        login_page = new Login_Page(driver);
        infrastructure_host_page = new Infrastructure_Host_Page(driver);
        infrastructure_page = new Infrastructure_Page(driver);
        login_page.click_on_email_id_text_box(username);
        login_page.click_on_password_text_box(password);
        login_page.click_on_login_button();
        login_page.click_on_Embrace_your_pro_user_pop_up();
        login_page.isWelcomeToMiddlewarePageDisplayed();
        infrastructure_host_page.verify_and_click_on_Infrastructure();
        infrastructure_host_page.click_on_host_Tab();
        infrastructure_host_page.verify_and_click_on_Host_Name_in_UP_State();
        infrastructure_host_page.verify_and_click_table_help_Button();
        infrastructure_host_page.drag_and_rearrange();
    }
    @Test()
    public void Verify_Cross_button_or_Back_button_functionality(String username, String password) throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        login_page = new Login_Page(driver);
        infrastructure_host_page = new Infrastructure_Host_Page(driver);
        infrastructure_page = new Infrastructure_Page(driver);
        login_page.click_on_email_id_text_box(username);
        login_page.click_on_password_text_box(password);
        login_page.click_on_login_button();
        login_page.click_on_Embrace_your_pro_user_pop_up();
        login_page.isWelcomeToMiddlewarePageDisplayed();
        infrastructure_host_page.verify_and_click_on_Infrastructure();
        infrastructure_host_page.click_on_host_Tab();
        infrastructure_host_page.verify_and_click_on_Host_Name_in_UP_State();
        infrastructure_host_page.click_on_x_button_of_HostPage();
        infrastructure_host_page.verify_x_button_of_HostPage_close();
    }
    @Test()
    public void Verify_that_clicking_the_icon_displays_IS_148(String username, String password) throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        login_page = new Login_Page(driver);
        infrastructure_host_page = new Infrastructure_Host_Page(driver);
        infrastructure_page = new Infrastructure_Page(driver);
        login_page.click_on_email_id_text_box(username);
        login_page.click_on_password_text_box(password);
        login_page.click_on_login_button();
        login_page.click_on_Embrace_your_pro_user_pop_up();
        login_page.isWelcomeToMiddlewarePageDisplayed();
        infrastructure_host_page.verify_and_click_on_Infrastructure();
        infrastructure_host_page.click_on_host_Tab();
        infrastructure_host_page.verify_and_click_table_help_Button();
        infrastructure_host_page.drag_and_rearrange();
    }
}





