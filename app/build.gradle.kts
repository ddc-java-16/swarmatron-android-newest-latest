/*
 *  Copyright 2023 CNM Ingenuity, Inc.
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
import java.io.FileInputStream
import java.util.*

plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.hilt)
    alias(libs.plugins.navigation.safeargs)
    alias(libs.plugins.schema.parser)
    alias(libs.plugins.junit)
}

android {

    namespace = project.property("basePackageName") as String?
    compileSdk = (project.property("targetSdk") as String).toInt()

    defaultConfig {

        applicationId = project.property("basePackageName") as String
        minSdk = (project.property("minSdk") as String).toInt()
        targetSdk = (project.property("targetSdk") as String).toInt()
        versionCode = (project.property("versionCode") as String).toInt()
        versionName = project.property("versionName") as String

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        testInstrumentationRunnerArguments["runnerBuilder"] =
            "de.mannodermaus.junit5.AndroidJUnit5Builder"

        resValue("string", "app_name", project.property("appName") as String)
        resValue("string", "client_id", getLocalProperty("client_id") ?: "")

        javaCompileOptions {
            annotationProcessorOptions {
                arguments(
                    mapOf(
                        "room.schemaLocation" to "$projectDir/schemas",
                        "room.incremental" to "true",
                        "room.expandProjection" to "true"
                    )
                )
            }
        }


        roomDdl {
            source.set(project.file("$projectDir/schemas/edu.cnm.deepdive.appstarter.service.SwarmatronDatabase/1.json"))
            destination.set(project.file("$projectDir/../docs/sql/ddl.sql"))
        }

    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro"
            )
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.valueOf("VERSION_${libs.versions.java.get()}")
        targetCompatibility = JavaVersion.valueOf("VERSION_${libs.versions.java.get()}")
    }

    buildFeatures {
        viewBinding = true
        dataBinding = true
    }

}

dependencies {

    // .jar-based libraries included in project

    // Basic Android components
    implementation(libs.app.compat)
    implementation(libs.constraint.layout)
    implementation(libs.recycler.view)

    // Fragment & navigation framework libraries
    implementation(libs.fragment)
    implementation(libs.navigation.fragment)
    implementation(libs.navigation.ui)

    // Lifecycle (LiveData and ViewModel) libraries
    runtimeOnly(libs.lifecycle.viewmodel)
    runtimeOnly(libs.lifecycle.livedata)

    // Preferences/settings components
    implementation(libs.preference)

    // Material Design components
    implementation(libs.material)

    // ReactiveX libraries
    implementation(libs.rx.java)
    implementation(libs.rx.android)

    // Room annotation processor, runtime library, and ReactiveX integration
    implementation(libs.room.runtime)
    annotationProcessor(libs.room.compiler)
    implementation(libs.room.rx.java)

    // Gson (Google JSON parser) library
    implementation(libs.gson)

    // Google Sign-in library
    implementation(libs.play.auth)

    // Retrofit (REST client) with ReactiveX & Gson integration
    implementation(libs.retrofit.core)
    implementation(libs.retrofit.converter.gson)
    implementation(libs.retrofit.adapter.rx.java)

    // Picasso image retrieval library
    implementation(libs.picasso)

    // Hilt dependency-injection library & annotation processor
    implementation(libs.hilt.android.core)
    annotationProcessor(libs.hilt.compiler)

    // OkHttp logging dependency
    implementation(libs.logging.interceptor)

    // Stetho (inspection) dependency
    implementation(libs.stetho)

    //Android Gif Animation Dependency
    // https://mvnrepository.com/artifact/pl.droidsonroids.gif/android-gif-drawable
    implementation("pl.droidsonroids.gif:android-gif-drawable:1.2.28")




    //Jsyn Synthesis Dependency
    implementation(libs.jsyn)
    // Libraries for JVM-based testing.
    testImplementation(libs.junit.api)
    testImplementation(libs.junit.params)
    testRuntimeOnly(libs.junit.engine)




    // Libraries for instrumented (run in Android) testing.
    androidTestImplementation(libs.test.runner)
    androidTestImplementation(libs.junit.android.core)
    androidTestRuntimeOnly(libs.junit.android.runner)
    androidTestImplementation(libs.junit.api)
    androidTestImplementation(libs.junit.params)
    androidTestImplementation(libs.espresso.core)
    androidTestImplementation(libs.hilt.android.testing)
    androidTestAnnotationProcessor(libs.hilt.compiler)
    androidTestAnnotationProcessor(libs.hilt.android.compiler)

    constraints {
        implementation(libs.kotlin.jdk7) {
            because("kotlin-stdlib-jdk7 is now a part of kotlin-stdlib")
        }
        //noinspection ForeignDelegate
        implementation(libs.kotlin.jdk8) {
            because("kotlin-stdlib-jdk8 is now a part of kotlin-stdlib")
        }
    }
}

roomDdl {
    source.set(project.file("$projectDir/schemas/edu.cnm.deepdive.appstarter.service.LocalDatabase/1.json"))
    destination.set(project.file("$projectDir/../docs/sql/ddl.sql"))
}

android.applicationVariants.configureEach {
    val simpleName = name
    val variantName = name.replaceFirstChar {
        if (it.isLowerCase()) {
            it.titlecase(Locale.getDefault())
        } else {
            it.toString()
        }
    }

    val task = project.tasks.create("generate${variantName}Javadoc", Javadoc::class.java) {
        title = "${project.property("appName")} (${android.defaultConfig.versionName})"
        group = "ApiDoc"
        description = "generates Javadoc for $variantName"

        source = javaCompileProvider.get().source

        doFirst {
            classpath = project.files(
                    projectDir
                            .toPath()
                            .resolve("build/intermediates/javac/${simpleName}/classes"),
                    javaCompileProvider.get().classpath.files,
                    android.bootClasspath
            )
        }

        exclude(
                "**/R",
                "**/R.**",
                "**/R\$**",
                "**/BuildConfig*"
        )
        setDestinationDir(file("$projectDir/../docs/api"))

        with(options as StandardJavadocDocletOptions) {
            windowTitle = "${project.property("appName")} (${android.defaultConfig.versionName})"
            memberLevel = JavadocMemberLevel.PROTECTED
            isLinkSource = true
            isAuthor = false
            links(

                    "https://docs.oracle.com/en/java/javase/${libs.versions.java.get()}/docs/api/",
                    "https://reactivex.io/RxJava/3.x/javadoc/",
                    "https://javadoc.io/doc/com.google.dagger/dagger/${libs.versions.hilt.get()}/",
                    "https://www.softsynth.com/jsyn/docs/javadocs/"
            )
            linksOffline("https://developer.android.com/reference", "$projectDir/..")
            addBooleanOption("html5", true)
            addStringOption("Xdoclint:none", "-quiet")
        }
        isFailOnError = true
    }
    task.dependsOn("assemble$variantName")
    //tasks["generateApiDoc"].dependsOn(task)
}
    fun getLocalProperty(name: String): String? {
        return getProperty("$projectDir/local.properties".toString(), name)
    }


    fun getProperty(filename: String, name: String): String? {
        return try {
            FileInputStream(filename).use {
                val props = Properties()
                props.load(it)
                props.getProperty(name)
            }
        } catch (e: Throwable) {
            null
        }
    }

    fun quoted(input: String): String {
        return "\"$input\""
    }

