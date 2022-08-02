package com.example.domain.domain.models

class ContactUsForm(
    var name: String,
    var email: String,
    var phoneNumber: String,
    var message: String,
) {
    constructor() : this(name = "", email = "", phoneNumber = "", message = "")


}