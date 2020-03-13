package br.com.caelum.forum;

import br.com.caelum.forum.dao.PostsDAO;
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
            PostsDAO dao = new PostsDAO();
            Map<String, Object> map = new HashMap<>();
            map.put("posts", dao.listAll());
            return new ModelAndView(map, "posts.ftl");
        }, new FreeMarkerEngine());
    }
}
