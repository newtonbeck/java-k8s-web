# Java K8s Web

Este é um app de exemplo Java rodando em um cluster de Kubernetes.

## Requisitos

- Docker
- Minikube
- Java > 8
- Maven

## Rodando o projeto localmente

Execute o comando abaixo para iniciar o banco de dados.

```
docker-compose up -d
```

Usando um programa cliente do MySQL execute o script que está em `db/script.sql` para criar o banco de dados.

Execute o comando abaixo para gerar o arquivo `.jar` do projeto.
```
mvn clean package
```

Execute o comando abaixo para rodar o projeto:
```
java -jar target/java-k8s-web-1.0-SNAPSHOT-jar-with-dependencies.jar
```

## Gerando a imagem Docker do projeto

Execute o comando abaixo para gerar a imagem Docker do projeto:
```
docker build -t my-blog:latest .
```

Execute o banco de dados pelo seguinte comando:
```
docker run -p 3306:3306 -e "MYSQL_ROOT_PASSWORD=toor" -d --name mysql mysql:5.7
```

Execute a aplicação pelo seguinte comando:
```
docker run -p 4567:4567 --link mysql:mysql -e "MY_BLOG_DB_URL=jdbc:mysql://mysql:3306/my_blog?useSSL=false" my-blog:latest
```