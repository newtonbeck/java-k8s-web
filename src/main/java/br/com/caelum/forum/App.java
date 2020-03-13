package br.com.caelum.forum;

import static spark.Spark.*;

public class App {
    public static void main(String[] args) {
        get("/topicos", (req, resp) -> "Hello world!");
    }
}
