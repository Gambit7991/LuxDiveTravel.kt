package com.example.domain.domain.useCases

import com.example.domain.domain.models.ContactUsForm
import java.util.*
import javax.mail.*
import javax.mail.internet.InternetAddress
import javax.mail.internet.MimeMessage


class SendContactFormUseCase {
    private val sender = "senderEmail@gmail.com"
    private val senderPassword = "senderPassword"
    fun execute (form: ContactUsForm) {
        val properties = Properties()
        properties["mail.smtp.auth"] = "true"
        properties["mail.smtp.starttls.enable"] = "true"
        properties["mail.smtp.host"] = "smtp.gmail.com"
        properties["mail.smtp.port"] = "587"
        Session.getInstance(properties)
        val session: Session = Session.getInstance(properties, object : Authenticator() {
            override fun getPasswordAuthentication(): PasswordAuthentication {
                return PasswordAuthentication(sender, senderPassword)
            }
        })
        try {
            val message: Message = MimeMessage(session)
            message.setFrom(InternetAddress(sender))
            val receiver = "recieverEmail@gmail.com"
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(receiver))
            message.subject = "This message is from Diving Travel App"
            message.setText(form.toString())
            Transport.send(message)
        } catch (e: MessagingException) {
            e.printStackTrace()
        }
    }
}