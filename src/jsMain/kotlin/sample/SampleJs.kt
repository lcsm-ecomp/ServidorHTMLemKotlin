package sample

import kotlin.browser.*




@Suppress("unused")
@JsName("helloWorld")
fun helloWorld(salutation: String) {
    val message = "$salutation from Kotlin.JS check me value:"
    document.getElementById("js-response")?.textContent = message
}