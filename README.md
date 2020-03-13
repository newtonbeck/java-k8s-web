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

## Publicando a imagem Docker do projeto

Execute o comando abaixo alterando o `<usuario do docker hub>` pelo seu usuário do site [hub.docker.com][https://hub.docker.com] para criar uma imagem que será publicada.
```
docker build -t <usuario do docker hub>/my-blog:latest .
```

Execute o comando abaixo alterando o `<usuario do docker hub>` pelo seu usuário do site [hub.docker.com][https://hub.docker.com] para publicar a imagem criada.
```
docker push newtonbeck/my-blog:latest
```

## Executando o projeto no k8s

Para iniciar o `minikube` execute:
```
minikube start
```

Para fazer o deploy da aplicação execute:
```
kubectl apply -f k8s/mysql-deployment.yml
kubectl apply -f k8s/web-deployment.yml
```

Para verificar quais pods estão executando:
```
kubectl get pods
```

Para criar o banco de dados execute:
```
kubectl exec -it <pod do banco de dados> sh
```

Dentro do pod execute:
```
mysql -u root -p
```

Digite a senha do banco de dados `toor` e depois copie o conteúdo do arquivo `db/script.sql` e cole no terminal do pod de banco de dados.