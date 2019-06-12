package sample

import com.sun.xml.internal.ws.developer.Serialization
import io.ktor.application.*
import io.ktor.html.*
import io.ktor.http.content.*
import io.ktor.routing.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import kotlinx.html.*
import java.io.*


data class Configuration(val porta:Int)

fun main() {
    embeddedServer(Netty, port = 8082, host = "127.0.0.1") {

        routing {
            get("/") {
                call.respondHtml {
                    head {
                        title("Hello from Ktor!")
                    }
                    body {
                        +"from Ktor. Check me value: "
                        div {
                            id = "js-response"
                            +"Loading..."
                        }
                        script(src = "/static/require.min.js") {
                        }
                        script {
                            +"require.config({baseUrl: '/static'});\n"
                            +"require(['/static/TesteClienteServidor.js'], function(js) { js.sample.helloWorld('Hi'); });\n"
                        }
                    }
                }
            }
            static("/static") {
                files("./build/web")
            }
        }
    }.start(wait = true)
}