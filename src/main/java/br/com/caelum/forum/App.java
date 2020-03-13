package br.com.caelum.forum;

import br.com.caelum.forum.model.Post;
import spark.ModelAndView;
import spark.template.freemarker.FreeMarkerEngine;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static spark.Spark.*;

public class App {
    public static void main(String[] args) {
        get("/", (req, resp) -> {
            Post primeiroPost = new Post("Meu primeiro post", "Não tenho muito o que dizer");
            Post postSobreKart = new Post("Como é correr de kart", "Correr de kart é muito divertido");


            Map<String, Object> map = new HashMap<>();
            map.put("message", "Hello World");
            map.put("posts", Arrays.asList(primeiroPost, postSobreKart));
            return new ModelAndView(map, "topicos.ftl");
        }, new FreeMarkerEngine());
    }
}
