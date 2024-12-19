package com.example.signinapp.modules

import androidx.compose.ui.test.SemanticsNodeInteraction
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.isDisplayed
import androidx.compose.ui.test.junit4.ComposeTestRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.performTextInput
import com.example.signinapp.dataobjects.TestDataObject
import com.example.signinapp.helper.ReadFromFileAndDeserialize

internal class LoginPageModule(val composeRule: ComposeTestRule)
{
    private val userIdField: SemanticsNodeInteraction = composeRule.onNodeWithTag("TechTaskUserId")
    private val passwordField: SemanticsNodeInteraction = composeRule.onNodeWithTag("TechTaskPassword")
    private val signInButton: SemanticsNodeInteraction = composeRule.onNodeWithText("Sign in")
    private val loginErrorTitle: SemanticsNodeInteraction = composeRule.onNodeWithTag("TechTaskLoginError")
    private val doneButtonOnDialog: SemanticsNodeInteraction = composeRule.onNodeWithTag("TechTaskConfirmButton")

    fun loginToTheApp(userId: String, password: String)
    {
        userIdField.performTextInput(userId)
        passwordField.performTextInput(password)
        signInButton.performClick()
    }

    fun verifyLoginPageDisplayed()
    {
        userIdField.assertIsDisplayed()
        passwordField.isDisplayed()
        signInButton.isDisplayed()
    }

    fun getUserDetailsTestData(testDataFileLocation: String): TestDataObject
    {
          return  ReadFromFileAndDeserialize.readAndDeserializeJson<TestDataObject>(
                testDataFileLocation,
                TestDataObject::class.java
            )
    }

    fun verifyLoginErrorDialogDisplayed()
    {
        loginErrorTitle.assertIsDisplayed()
        doneButtonOnDialog.performClick()
    }
}