package com.example.signinapp.helper

import androidx.test.platform.app.InstrumentationRegistry
import com.google.gson.Gson
import java.io.BufferedReader
import java.io.IOException
import java.io.InputStreamReader
import java.lang.reflect.Type

object ReadFromFileAndDeserialize
{
    private val gson: Gson = Gson()
    @Throws(IOException::class)
    fun <T> readAndDeserializeJson(fileRelativePath: String, jsonObjectClassType: Type): T {

        val fileReader = BufferedReader(InputStreamReader(
            InstrumentationRegistry.getInstrumentation().context.assets.open(fileRelativePath))
        )
        fileReader.use {
            return gson.fromJson(it, jsonObjectClassType)
        }
    }
}