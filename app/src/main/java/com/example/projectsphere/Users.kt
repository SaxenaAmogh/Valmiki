package com.example.projectsphere

import android.content.Context
import android.content.SharedPreferences
import com.google.firebase.auth.FirebaseUser

object UserManager {
    private const val PREFS_NAME = "user_prefs"
    private const val KEY_USER_ID = "user_id"

    private lateinit var sharedPreferences: SharedPreferences

    var currentUser: FirebaseUser? = null
    private var _userId: Int? = null

    // Flag to check if the value has been set
    private var isUserIdSet = false

    // Initialize UserManager with context
    fun initialize(context: Context) {
        sharedPreferences = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
        _userId = sharedPreferences.getInt(KEY_USER_ID, -1).takeIf { it != -1 }
        isUserIdSet = _userId != null
    }

    // Public read-only property for the user ID
    val userId: Int
        get() = _userId ?: throw IllegalStateException("User ID is not set")

    // Method to set the user ID, only if it's not already set
    fun setUserId(userId: Int) {
        if (!isUserIdSet) {
            _userId = userId
            isUserIdSet = true
            sharedPreferences.edit().putInt(KEY_USER_ID, userId).apply()
        } else {
            throw IllegalStateException("User ID is already set")
        }
    }

    // Method to clear the user ID, e.g., on logout
    fun clearUserId() {
        _userId = 0
        isUserIdSet = false
        sharedPreferences.edit().remove(KEY_USER_ID).apply()
    }
}
