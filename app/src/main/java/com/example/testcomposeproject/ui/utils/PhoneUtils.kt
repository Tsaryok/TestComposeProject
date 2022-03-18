package com.example.testcomposeproject.ui.utils

fun isPhoneNumber(phone: String): Boolean {
    return Regex("^\\+?\\d{5,15}$").matches(phone)
}