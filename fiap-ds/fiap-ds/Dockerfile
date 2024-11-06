# Usando imagem base do OpenJDK
FROM openjdk:17-jdk-slim

# Diretório de trabalho dentro do container
WORKDIR /app

# Copiando o JAR gerado para dentro do container
COPY target/*.jar app.jar

# Variáveis de ambiente para a conexão com o banco de dados MySQL
ENV MYSQL_HOST=db
ENV MYSQL_PORT=3306
ENV MYSQL_DATABASE=gerenciamento_trafego
ENV MYSQL_USER=gerenciador
ENV MYSQL_PASSWORD=

# Expondo a porta onde o Spring Boot vai rodar
EXPOSE 8080

# Comando para iniciar a aplicação
ENTRYPOINT ["java", "-jar", "app.jar"]