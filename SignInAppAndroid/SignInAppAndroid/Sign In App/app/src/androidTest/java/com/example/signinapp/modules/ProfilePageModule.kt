package com.example.signinapp.modules

import androidx.compose.ui.test.SemanticsNodeInteraction
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.assertTextContains
import androidx.compose.ui.test.junit4.ComposeTestRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick


public class ProfilePageModule(val composeRule: ComposeTestRule)
{
    private val nameText: SemanticsNodeInteraction = composeRule.onNodeWithTag("TechTaskName")
    private val roleText: SemanticsNodeInteraction = composeRule.onNodeWithTag("TechTaskRole")
    private val officeText: SemanticsNodeInteraction = composeRule.onNodeWithTag("TechTaskOffice")
    private val signOutButton: SemanticsNodeInteraction = composeRule.onNodeWithText("Sign Out")
    private val signOutAlertTitle: SemanticsNodeInteraction = composeRule.onNodeWithTag("TechTaskSignOutAlert")
    private val signOutConfirmButton: SemanticsNodeInteraction = composeRule.onNodeWithTag("TechTaskConfirmButton")

    fun verifyProfileDetailsDisplayedAsProvided(userName: String, role: String, office: String)
    {
        nameText.assertTextContains(userName, ignoreCase = true)
        roleText.assertTextContains(role, ignoreCase = true)
        officeText.assertTextContains(office, ignoreCase = true)
    }

    fun signOutTheUser()
    {
        signOutButton.performClick()
        composeRule.waitForIdle()
        Thread.sleep(2000)
        signOutAlertTitle.assertIsDisplayed()
        signOutConfirmButton.performClick()
    }

}