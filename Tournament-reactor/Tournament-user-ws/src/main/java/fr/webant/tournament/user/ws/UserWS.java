package fr.webant.tournament.user.ws;

import com.jsoniter.JsonIterator;
import com.jsoniter.output.JsonStream;
import fr.webant.tournament.user.core.model.User;
import fr.webant.tournament.user.core.service.UserService;
import javax.inject.Inject;
import javax.inject.Singleton;

import spark.Request;
import spark.Response;
import spark.Route;
import spark.Spark;

/**
 *
 * @author anthony
 */
@Singleton
/**
 * Web service which provides all verbs used to manage users
 */
public class UserWS {

    @Inject
    /**
     * @UserService user service
     */
    public UserWS(UserService userService) {
        
        /* Find all users*/
        Spark.get("/users", new Route() {
            @Override
            public Object handle(Request req, Response resp) throws Exception {
                resp.type("application/json");
                return userService.findAll();
            }
        }, JsonStream::serialize);
        
        /*Find a user by id*/
        Spark.get("/users/:userId", new Route() {
            @Override
            public Object handle(Request req, Response resp) throws Exception {
                resp.type("application/json");
                Integer userId = Integer.valueOf(req.params("userId"));
                return userService.findUser(userId);
            }
        }, JsonStream::serialize);
        
        /* Create a user */
        Spark.post("/users", new Route() {
            @Override
            public Object handle(Request req, Response resp) throws Exception {
                resp.type("application/json");
                User user = JsonIterator.deserialize(req.queryParams("user"), User.class);
                return userService.createUser(user);
            }
        }, JsonStream::serialize);
        
        /* Update a user*/
        Spark.put("/users", new Route() {
            @Override
            public Object handle(Request req, Response resp) throws Exception {
                resp.type("application/json");
                User user = JsonIterator.deserialize(req.queryParams("user"), User.class);
                return userService.updateUser(user);
            }
        }, JsonStream::serialize);
        
        /* Delete a user*/
        Spark.delete("/users", new Route() {
            @Override
            public Object handle(Request req, Response resp) throws Exception {
                resp.type("application/json");
                User user = JsonIterator.deserialize(req.queryParams("user"), User.class);
                userService.deleteUser(user);
                resp.status(200);
                return null;
            }
        });
    }
}
