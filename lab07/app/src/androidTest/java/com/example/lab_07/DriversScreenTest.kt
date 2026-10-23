package com.example.lab_07

import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.performTextInput
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class DriversScreenTest {
    @get:Rule
    val composeTestRule = createAndroidComposeRule<MainActivity>() // access MainActivity

    @Test
    fun navigate_to_drivers_add_driver_and_return_home() {
        // navigate to drivers screen
        composeTestRule
            .onNodeWithTag("driverButton")
            .performClick()

        // verify drivers screen
        composeTestRule
            .onNodeWithText("Drivers")
            .assertExists()

        // enter driver name
        composeTestRule
            .onNodeWithTag("driverInput")
            .performTextInput("Sam")

        // add driver name
        composeTestRule
            .onNodeWithTag("addDriverButton")
            .performClick()

        // verify name appears
        composeTestRule
            .onNodeWithText("Sam")
            .assertExists()

        // clear all drivers
        composeTestRule
            .onNodeWithTag("clearDriversButton")
            .performClick()

        // verify driver was removed
        composeTestRule
            .onNodeWithText("Sam")
            .assertDoesNotExist()


        // return to home screen
        composeTestRule
            .onNodeWithTag("driversBackButton")
            .performClick()

        // verify return to home screen
        composeTestRule
            .onNodeWithText("FormulaZero Home")
            .assertExists()
    }
}