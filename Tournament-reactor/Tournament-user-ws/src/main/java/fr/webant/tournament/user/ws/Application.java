package fr.webant.tournament.user.ws;

import com.jsoniter.output.JsonStream;
import io.swagger.annotations.Contact;
import io.swagger.annotations.Info;
import io.swagger.annotations.License;
import io.swagger.annotations.SwaggerDefinition;
import org.codejargon.feather.Feather;
import spark.Spark;

/**
 *
 * @author anthony
 */
@SwaggerDefinition(host = "localhost:8080", //
info = @Info(description = "Tournament User API", //
version = "V1.0", //
contact = @Contact(name = "Anthony Normand", email = "antho.normand@gmail.com", url="http://test.test.fr"),
license = @License(name = "", url= "http://test.test.fr"),
title = "Manage user through Web Services"), //
schemes = {SwaggerDefinition.Scheme.HTTP}, //
consumes = { "application/json" }, //
produces = { "application/json" })
public class Application {

    public static void main(String[] args) {
        Spark.port(8080);
        UserController controller = Feather.with().instance(UserController.class);
        Spark.get("/users", controller::findUsers, JsonStream::serialize);
        Spark.get("/users/:userId", controller::findUserById, JsonStream::serialize);
        Spark.post("/users", controller::createUser, JsonStream::serialize);
        Spark.put("/users", controller::updateUser, JsonStream::serialize);
        Spark.delete("/users/:userId", controller::deleteUser, JsonStream::serialize);
    }
}

