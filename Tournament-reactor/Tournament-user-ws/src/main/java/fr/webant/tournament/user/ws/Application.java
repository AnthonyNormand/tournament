package fr.webant.tournament.user.ws;

import org.codejargon.feather.Feather;
import spark.Spark;

/**
 *
 * @author anthony
 */
public class Application {

    public static void main(String[] args) {
        Spark.port(8080);
        Feather feather = Feather.with();
        feather.instance(UserWS.class);
    }
}
