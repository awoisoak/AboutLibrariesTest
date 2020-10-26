package com.example.myapplication

import android.content.Context
import com.mikepenz.aboutlibraries.LibsBuilder

object Licenses {

    /**
     * Prefix to aim to the personalized library resources
     */
    private const val PREFIX = "x"

    /**
     * Builder to generate the list of dependencies
     */
    private var builder: LibsBuilder = LibsBuilder()

    /**
     * Starts the OSS notices activity
     */
    fun startActivity(context: Context) {
        builder.apply {
            withAutoDetect(false) //Detected with Gradle Plugin
            withAboutIconShown(true)
            withAboutVersionString(" ")
            withAboutAppName(context.resources.getString(R.string.app_name))
            withLicenseShown(true)
            withLicenseDialog(true)
            withFields(R.string::class.java.fields)

            personalize("com_tompee_kotlinbuilder__runtime")
            personalize("com_tompee_bunch__annotations")

            start(context)
        }
    }

    private fun LibsBuilder.personalize(lib: String) {
        withLibraryEnchantment(lib, "$PREFIX$lib")
    }
}