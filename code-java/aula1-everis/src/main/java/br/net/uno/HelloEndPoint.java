package br.net.uno;

import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;

@Controller("/hello")
public class HelloEndPoint {

    @Get("/{name}")
    public String hello(String name) {
        return "Ola, "+ name + " !";
    }
}
