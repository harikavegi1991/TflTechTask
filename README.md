# **UI tools used:** 
Espresso + ComposeTestRule

# **Scenarios Added:**

## Successful Login:

 Given User login the app with the correct credentials
 
 And the correct profile details displayed on the app
 
 When User logs out
 
 Then User is logged out
 
 And User lands on login screen

## Unsuccessful Login:

Given User try login the app with the incorrect credentials

Then login error dialog is displayed

And User cannot login

# **Please note:** 
The testtag modifiers have been added for the controls on the activities to enable inspecting the controls for the UI tests.
