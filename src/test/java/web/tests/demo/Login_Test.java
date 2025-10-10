package web.tests.demo;

import io.unity.framework.init.base;
import org.testng.annotations.Test;
import web.object_repository.Dashboard.Dashboard_Page;
import web.object_repository.Login.Login_Page;
import web.object_repository.Infrastructure.Infrastructure_Page;
import web.object_repository.Settings.Settings_Page;
import java.time.Duration;

/**
 * Automation test for login.
 *
 * author: Jayant
 * testCaseID: eng-001,002,003
 * description: Verify login with valid credentials
 */
public class Login_Test extends base {
    Login_Page login_page = null;
    Infrastructure_Page infrastructure_page = null;
    Dashboard_Page dashboard_page = null;
    Settings_Page settings_page = null;


    @Test()
    public void login_with_valid_credentials() throws InterruptedException {
        login_page = new Login_Page(driver);
        infrastructure_page = new Infrastructure_Page(driver);
        dashboard_page = new Dashboard_Page(driver);

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        login_page.click_on_email_id_text_box("Kinjal@qable.io");
        login_page.click_on_password_text_box("Test@123");
        login_page.click_on_login_button();
        login_page.verify_explore_and_keep_an_eye_on_your_metrics_isVisible();
        infrastructure_page.verify_and_click_on_Infrastructure();
        infrastructure_page.verify_and_click_on_Cluster();
        infrastructure_page.verify_and_click_on_Dashboard_Tab();

        infrastructure_page.click_on_Dashboard_Tab_Dropdown_Text1_Arrow_Icon();
        infrastructure_page.get_the_text1_in_variable();
        infrastructure_page.click_on_Dashboard_Tab_Dropdown_Text1_Arrow_Icon();
        infrastructure_page.get_the_widgets_text_from_the_dropdown();
        infrastructure_page.click_on_Dashboard_Tab_Dropdown_Text2_Arrow_Icon();
        infrastructure_page.click_on_Dashboard_Tab_Dropdown_Text3_Arrow_Icon();
        infrastructure_page.click_on_Dashboard_Tab_Dropdown_Text4_Arrow_Icon();
        infrastructure_page.click_on_Dashboard_Tab_Dropdown_Text5_Arrow_Icon();
        infrastructure_page.click_on_Dashboard_Tab_Dropdown_Text6_Arrow_Icon();
        infrastructure_page.click_on_Dashboard_Tab_Dropdown_Text7_Arrow_Icon();
        dashboard_page.verify_and_click_on_Dashboard();
        dashboard_page.verify_Dashboard_Text_isvisible();
        dashboard_page.verify_and_click_on_search_field_and_search_for_k8s_cluster();
        Thread.sleep(5000);
        dashboard_page.verify_and_click_Dashboard_Searched_table();
        dashboard_page.click_on_Dashboard_Tab_Dropdown_Text1_Arrow_Icon();
        infrastructure_page.get_the_text2_in_variable();
        dashboard_page.click_on_Dashboard_Tab_Dropdown_Text2_Arrow_Icon();
        dashboard_page.click_on_Dashboard_Tab_Dropdown_Text3_Arrow_Icon();
        dashboard_page.click_on_Dashboard_Tab_Dropdown_Text4_Arrow_Icon();
        dashboard_page.click_on_Dashboard_Tab_Dropdown_Text5_Arrow_Icon();
        dashboard_page.click_on_Dashboard_Tab_Dropdown_Text6_Arrow_Icon();
        dashboard_page.click_on_Dashboard_Tab_Dropdown_Text7_Arrow_Icon();

        //  login_page.click_on_Embrace_your_pro_user_pop_up();
        login_page.verify_and_click_on_logout_menu_option();
        login_page.click_on_logout_button();
        login_page.testPasses("Test is passed");
    }

    public void login_with_valid_credentials_and_navigate_to_Infra_Module() {
        login_page = new Login_Page(driver);
        login_page.click_on_email_id_text_box("Kinjal@qable.io");
        login_page.click_on_password_text_box("Test@123");
        login_page.click_on_login_button();
        login_page.verify_explore_and_keep_an_eye_on_your_metrics_isVisible();
        // login_page.click_on_Embrace_your_pro_user_pop_up();
        // login_page.verify_and_click_on_logout_menu_option();

        login_page.click_on_logout_button();
        login_page.testPasses("Test is passed");

    }

    @Test()
    public void Settings_Page() throws InterruptedException {
        login_page = new Login_Page(driver);
        infrastructure_page = new Infrastructure_Page(driver);
        dashboard_page = new Dashboard_Page(driver);
        settings_page = new Settings_Page(driver);

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        login_page.click_on_email_id_text_box("Kinjal@qable.io");
        login_page.click_on_password_text_box("Test@123");
        login_page.click_on_login_button();
        settings_page.verify_and_click_on_Settings();
        settings_page.verify_that_user_is_in_Profile_page();
        settings_page.verify_and_check_Setting_Header();
        settings_page.verify_and_click_Profile_section();
        settings_page.verify_and_click_Users_section();
        settings_page.verify_and_click_Roles_and_Permissions_section();
        settings_page.verify_and_click_Projects_section();
        settings_page.verify_and_click_Billings();
        settings_page.verify_and_click_Usage();
        settings_page.verify_and_click_Ingestion_Control();
        settings_page.verify_and_click_Agent_Pipeline();
        settings_page.verify_and_click_API_key();
        settings_page.verify_and_click_Agent_Pipeline();
    }
    @Test()
    public void main(String[] args) {
        int num[] = {10, 20, 30, 40, 50};

        // Enhanced for loop
        for (int n : num) {
            System.out.println(n);
        }
    }
}