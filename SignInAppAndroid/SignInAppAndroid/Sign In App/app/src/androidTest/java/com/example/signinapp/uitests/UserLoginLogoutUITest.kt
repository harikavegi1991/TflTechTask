package com.example.signinapp.uitests

import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.signinapp.MainActivity
import com.example.signinapp.modules.LoginPageModule
import com.example.signinapp.modules.ProfilePageModule
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

/*
  Given User login the app with the correct credentials
  And the correct profile details displayed on the app
  When User logs out
  Then User is logged out
  And User lands on login screen
 */

@RunWith(AndroidJUnit4::class)
class UserLoginLogoutUITest {
    @get:Rule
    val composeRule = createAndroidComposeRule<MainActivity>()

    @Test
    fun userSuccessfulLoginLogoutScenario() {

        val loginPage = LoginPageModule(composeRule)
        val profilePage = ProfilePageModule(composeRule)

        val testData = loginPage.getUserDetailsTestData("resources/testdata.json")
        composeRule.waitForIdle()
        loginPage.loginToTheApp(testData.username,testData.password)
        composeRule.waitForIdle()
        profilePage.verifyProfileDetailsDisplayedAsProvided(testData.name,testData.role,testData.office)
        profilePage.signOutTheUser()
        composeRule.waitForIdle()
        loginPage.verifyLoginPageDisplayed()
    }
}