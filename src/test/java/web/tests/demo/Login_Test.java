package web.tests.demo;

import io.unity.framework.init.base;
import org.testng.annotations.Test;
import web.object_repository.Login.Login_Page;
import web.object_repository.Infrastructure_Host.Infrastructure_Host_Page;
import web.object_repository.Infrastructure.Infrastructure_Page;


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

    @Test()
    public void login_with_valid_credentials() {
        login_page = new Login_Page(driver);
        login_page.click_on_email_id_text_box("Kinjal@qable.io");
        login_page.click_on_password_text_box("Test@123");
        login_page.click_on_login_button();
        login_page.verify_explore_and_keep_an_eye_on_your_metrics_isVisible();
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
        //  login_page.click_on_Embrace_your_pro_user_pop_up();
        // login_page.verify_and_click_on_logout_menu_option();

        login_page.click_on_logout_button();
        login_page.testPasses("Test is passed");

    }

    }

