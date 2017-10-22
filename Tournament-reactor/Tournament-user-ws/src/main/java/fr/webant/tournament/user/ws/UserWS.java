package fr.webant.tournament.user.ws;

import com.jsoniter.JsonIterator;
import com.jsoniter.output.JsonStream;
import fr.webant.tournament.user.core.dto.User;
import fr.webant.tournament.user.core.service.UserService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import javax.inject.Inject;
import javax.inject.Singleton;

import spark.Request;
import spark.Response;
import spark.Route;
import spark.Spark;

/**
 *
 * @author anthony
 * Web service which provides all verbs used to manage users
 */

@Singleton
public class UserWS {

    /**
     * @UserService user service
     */
    @Inject
    public UserWS(UserService userService) {
        
        /**
        * TODO a implementer
        * Login
        * Logout
        * FindByLogin
        */
        
        
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
        Spark.put("/users/:userId", new Route() {
            @Override
            public Object handle(Request req, Response resp) throws Exception {
                resp.type("application/json");
                Integer userId = Integer.valueOf(req.params("userId"));
                User user = new User();
                user.setId(userId);
                user.setFirstname(req.queryParams("firstname"));
                user.setLastname(req.queryParams("lastname"));
                user.setEmail(req.queryParams("email"));
                return userService.updateUser(user);
            }
        }, JsonStream::serialize);
        
        /* Delete a user*/
        Spark.delete("/users/:userId", new Route() {
            @Override
            public Object handle(Request req, Response resp) throws Exception {
                resp.type("application/json");
                Integer userId = Integer.valueOf(req.params("userId"));
                userService.deleteUser(userId);
                return null;
            }
        });
    }
}
