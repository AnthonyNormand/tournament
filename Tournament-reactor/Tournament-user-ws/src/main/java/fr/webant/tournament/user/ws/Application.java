package fr.webant.tournament.user.ws;

import fr.webant.tournament.user.ws.swagger.SwaggerParser;
import com.jsoniter.output.JsonStream;
import io.swagger.annotations.Info;
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
title = "Manage user through Web Services"), //
schemes = { SwaggerDefinition.Scheme.HTTP, SwaggerDefinition.Scheme.HTTPS }, //
consumes = { "application/json" }, //
produces = { "application/json" })
public class Application {

    public static void main(String[] args) {
        Spark.port(8080);
        Feather feather = Feather.with();
        feather.instance(UserWS.class);
        Spark.get("/users", feather.instance(FindUsersRoute.class), JsonStream::serialize);
        Spark.get("/swagger", (req, res) -> {return SwaggerParser.getSwaggerJson("fr.webant.tournament.user.ws");});
    }
}
