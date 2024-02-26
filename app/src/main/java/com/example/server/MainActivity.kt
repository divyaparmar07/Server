package com.example.server

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.server.databinding.ActivityMainBinding
//import com.google.api.client.googleapis.auth.oauth2.GoogleCredential
//import com.google.api.client.googleapis.auth.oauth2.GoogleCredential
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
//import com.google.firebase.remoteconfig.ConfigUpdate
//import com.google.firebase.remoteconfig.ConfigUpdateListener
import com.google.firebase.remoteconfig.FirebaseRemoteConfig
import com.google.firebase.remoteconfig.FirebaseRemoteConfigSettings
//import com.google.firebase.remoteconfig.FirebaseRemoteConfigException

//import java.io.FileInputStream
//import java.util.Arrays


class MainActivity : AppCompatActivity() {

    private lateinit var databaseReference: DatabaseReference
    private lateinit var remoteConfig: FirebaseRemoteConfig

    //    private val remoteConfig: FirebaseRemoteConfig = Firebase.remoteConfig
//    private val remoteConfig: FirebaseRemoteConfig = Firebase.remoteConfig
    private lateinit var mainBinding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainBinding = ActivityMainBinding.inflate(layoutInflater)
        val view = mainBinding.root
        setContentView(view)

        // Initialize Firebase Remote Config
        remoteConfig = FirebaseRemoteConfig.getInstance()
        val configSettings = FirebaseRemoteConfigSettings.Builder()
            .setMinimumFetchIntervalInSeconds(3600) // Set your desired fetch interval
            .build()
        remoteConfig.setConfigSettingsAsync(configSettings)

        // Initialize Realtime Database reference
        databaseReference = FirebaseDatabase.getInstance().getReference("remote_config")

        // Read values from Realtime Database
        databaseReference.addListenerForSingleValueEvent(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                if (snapshot.exists()) {
                    val newValue = snapshot.child("welcome_message").value.toString()
                    // Apply the configuration values to Firebase Remote Config
//                    applyRemoteConfigValues(newValue)
                }
            }

            override fun onCancelled(databaseError: DatabaseError) {
                // Handle database error
            }
        })

    }
    private fun applyRemoteConfigValues(newValue: String,welcome_message : String) {

        val remoteConfig = FirebaseRemoteConfig.getInstance()

        // Set the value in Firebase Remote Config
//        remoteConfig.setDefaultsAsync(welcome_message,newValue)
        remoteConfig.activate()

        // Set the values in Firebase Remote Config
//        remoteConfig.setDefaultsAsync(configData)
//        remoteConfig.activate()
//
//        // Now, you can use the updated Remote Config values in your app
//        val someConfigValue = remoteConfig.getString("welcome_message")
        // Use the config value as needed
    }





//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        mainBinding = ActivityMainBinding.inflate(layoutInflater)
//        val view = mainBinding.root
//        setContentView(view)
//
////        val SCOPES = arrayOf("https://console.cloud.google.com/apis/api/firebaseremoteconfig.googleapis.com/credentials?project=remoteconfigdemo-3c62d&supportedpurview=project")
////        val credentials = GoogleCredential.fromStream(
////            FileInputStream("Downloads/remoteconfigdemo-3c62d-firebase-adminsdk-m67i4-3e16eb62f7.json")
////        )
////            .createScoped(Arrays.asList(*SCOPES))
////        credentials.refreshToken()
//
////        val serviceAccount =
////            FileInputStream("admin-sdk.json")
//        val options =
//            FirebaseOptions.Builder()
//                .setApplicationId("1:362288165309:android:10b10b0cdda403f10e62d4")
//                .setApiKey("c08b42d17673b8a82eba38d80abaade220f03532")
////                .setCredentials(GoogleCredentials.fromStream(serviceAccount))
//                .setDatabaseUrl("https://console.firebase.google.com/project/remoteconfigdemo-3c62d/overview")
//                .build()
//        FirebaseApp.initializeApp(applicationContext, options, "Server")
//
//        val configSettings = remoteConfigSettings {
//            minimumFetchIntervalInSeconds = 10
//        }
//        remoteConfig.setConfigSettingsAsync(configSettings)
//
//        remoteConfig.setDefaultsAsync(R.xml.login_default_values)
//
//        mainBinding.buttonSend.setOnClickListener {
//            val newValue = mainBinding.editTextInput.text
////            val updatedParameters = hashMapOf<String, Any>()
////            updatedParameters["say_hello"] = newValue
//            Log.d("divya", newValue.toString())
//            val remoteConfigValues: MutableMap<String, Any> = HashMap()
//            remoteConfigValues["say_hello"] = "Hello, World!"
////
//
////            remoteConfig.addOnConfigUpdateListener(object : ConfigUpdateListener{
////                override fun onUpdate(configUpdate: ConfigUpdate) {
//////                    remoteConfig.setDefaultsAsync(remoteConfigValues)
////                    remoteConfig.setDefaultsAsync(mapOf("say_hello" to newValue))
////                }
////
////                override fun onError(error: FirebaseRemoteConfigException) {
////
////                }
////
////            })
////// Set the parameters
//            remoteConfig.setDefaultsAsync(remoteConfigValues)
//            remoteConfig.setDefaultsAsync(mapOf("say_hello" to newValue))
////            Log.d("")
////            remoteConfig.setDefaultsAsync(updatedParameters)
////            getValueFromFirebaseConfig()
//        }
//
////        val mFirebaseRemoteConfig = FirebaseRemoteConfig.getInstance()
////
////// Create a parameter map
////        val remoteConfigValues: MutableMap<String, Any> = HashMap()
////        remoteConfigValues["say_hello"] = "Hello, World!"
////
////// Set the parameters
////        mFirebaseRemoteConfig.setDefaultsAsync(remoteConfigValues)
//
//
////        val newValue = mainBinding.editTextInput.text
////        val updatedParameters = hashMapOf<String, Any>()
////        updatedParameters["your_param_key"] = newValue
//
//
////        mainBinding.editTextInput
////        mainBinding.buttonSend.setOnClickListener {
////
////        }
//    }
}