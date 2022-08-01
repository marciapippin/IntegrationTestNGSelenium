/*
 * Copyright (c) 2022 Anh Tester
 * Automation Framework Selenium
 */

package anhtester.com.projects.website.crm.testcases;

import anhtester.com.common.BaseTest;
import anhtester.com.dataprovider.DataProviderManager;
import anhtester.com.projects.website.crm.pages.SignIn.SignInPage;
import anhtester.com.utils.WebUI;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Step;
import org.testng.annotations.Test;

import java.util.Hashtable;

@Epic("Regression Test CRM")
@Feature("Sign In Test")
public class SignInTest extends BaseTest {

    public SignInTest() {
        signInPage = new SignInPage();
        System.out.println("signInPage: " + signInPage);
    }

    //Using library DataProvider with read Hashtable
    @Test(priority = 1, dataProvider = "getSignInDataHashTable", dataProviderClass = DataProviderManager.class)
    @Step("SignInTestDataProviderHashtable")
    public void SignInTestDataProviderHashtable(Hashtable<String, String> data) {
        signInPage.signIn(data);
    }

    @Test(priority = 2, dataProvider = "getSignInDataHashTable2", dataProviderClass = DataProviderManager.class)
    @Step("SignInTestDataProviderHashtable")
    public void SignInTestDataProviderHashtable2(Hashtable<String, String> data) {
        signInPage.signIn(data);
    }

    @Test(priority = 3)
    @Step("SignInTestDataAdmin")
    public void SignInTestDataAdmin() {
        signInPage.signInWithAdminRole();
        WebUI.verifyElementPresent(getDashboardPage().menuDashboard, 5, "The menu Dashboard does not exist.");
    }

    @Test(priority = 4)
    @Step("SignInTestDataTeamLeader")
    public void SignInTestDataTeamLeader() {
        signInPage.signInWithTeamLeaderRole();
    }

}
