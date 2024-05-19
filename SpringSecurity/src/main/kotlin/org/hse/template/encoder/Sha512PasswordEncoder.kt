package org.hse.template.encoder

import org.springframework.security.crypto.password.PasswordEncoder
import java.security.MessageDigest
import java.security.NoSuchAlgorithmException

class Sha512PasswordEncoder : PasswordEncoder {

    override fun encode(rawPassword: CharSequence) =
        hashWithSHA512(rawPassword.toString())

    override fun matches(rawPassword: CharSequence, encodedPassword: String) =
        encodedPassword == encode(rawPassword)

    private fun hashWithSHA512(input: String): String {
        val result = StringBuilder()

        try {
            val messageDigest = MessageDigest.getInstance("SHA-512")
            val digested = messageDigest.digest(input.toByteArray())

            digested.forEach {
                result.append(Integer.toHexString(0xFF and it.toInt()))
            }
        } catch (e: NoSuchAlgorithmException) {
            throw RuntimeException("Bad algorithm")
        }

        return result.toString()
    }
}