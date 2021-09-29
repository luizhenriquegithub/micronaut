package br.net.uno

import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get

@Controller("/hello")
class HelloEndPoint {

    @Get("/{name}")
    fun hello(name: String): String {
        return "Ola, $name voce esta agora em kotlin !"
    }

    @Get("/teste")
    fun getTeste() = "funcao de teste, micronaut continua rodando"

}