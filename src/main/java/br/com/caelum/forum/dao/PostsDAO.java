package br.com.caelum.forum.dao;

import br.com.caelum.forum.infra.ConnectionFactory;
import br.com.caelum.forum.model.Post;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PostsDAO {

    public List<Post> listAll() {
        try {
            ConnectionFactory factory = new ConnectionFactory();
            Connection connection = factory.create();

            PreparedStatement statement = connection.prepareStatement("SELECT title, summary FROM `Posts`");
            ResultSet result = statement.executeQuery();

            ArrayList<Post> posts = new ArrayList<>();

            while (result.next()) {
                String title = result.getString("title");
                String summary = result.getString("summary");
                posts.add(new Post(title, summary));
            }

            connection.close();
            return posts;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
