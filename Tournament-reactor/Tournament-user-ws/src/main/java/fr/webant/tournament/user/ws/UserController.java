package fr.webant.tournament.user.ws;

import com.jsoniter.JsonIterator;
import fr.webant.tournament.user.core.dto.User;
import fr.webant.tournament.user.core.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import java.util.List;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import spark.Request;
import spark.Response;

/**
 *
 * @author anthony
 */
@Api("/")
public class UserController {

    private UserService userService;

    @Inject
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GET
    @Path("/users/{userId}")
    @Produces(MediaType.APPLICATION_JSON)
    @ApiOperation(value = "Find a user by its id", nickname = "findUserById")
    @ApiImplicitParams({
        @ApiImplicitParam(required = true, dataType = "integer", name = "userId", paramType = "path")
    })
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "User found", response = User.class)})
    public User findUserById(@ApiParam(hidden = true) Request req, @ApiParam(hidden = true) Response resp) {
        Integer userId = Integer.valueOf(req.params("userId"));
        resp.type("application/json");
        return userService.findUser(userId);
    }

    @GET
    @Path("/users")
    @Produces(MediaType.APPLICATION_JSON)
    @ApiOperation(value = "Find all users", nickname = "findUsers")
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "Users list", responseContainer = "List", response = User.class)})
    public List<User> findUsers(@ApiParam(hidden = true) Request req, @ApiParam(hidden = true) Response resp) {
        resp.type("application/json");
        return userService.findAll();
    }

    @POST
    @Path("/users")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @ApiOperation(value = "Add a user", nickname = "createUser")
    @ApiImplicitParams({
        @ApiImplicitParam(required = true, name = "user", dataType = "fr.webant.tournament.user.core.dto.User", paramType = "body")
    })
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "User created", response = User.class)})
    public User createUser(@ApiParam(hidden = true) Request req, @ApiParam(hidden = true) Response resp) {
        resp.type("application/json");
        User user = JsonIterator.deserialize(req.body(), User.class);
        return userService.createUser(user);

    }

    @PUT
    @Path("/users")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @ApiOperation(value = "Update a user", nickname = "updateUser")
    @ApiImplicitParams({
        @ApiImplicitParam(required = true, name = "user", dataType = "fr.webant.tournament.user.core.dto.User", paramType = "body")
    })
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "User updated", response = User.class)
    })
    public User updateUser(@ApiParam(hidden = true) Request req, @ApiParam(hidden = true) Response resp) {
        resp.type("application/json");
        User user = JsonIterator.deserialize(req.body(), User.class);
        return userService.updateUser(user);
    }

    @DELETE
    @Path("/users/{userId}")
    @Produces(MediaType.APPLICATION_JSON)
    @ApiOperation(value = "Delete a user by its id", nickname = "deleteUser")
    @ApiImplicitParams({
        @ApiImplicitParam(required = true, dataType = "integer", name = "userId", paramType = "path")
    })
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "User deleted")})
    public boolean deleteUser(@ApiParam(hidden = true) Request req, @ApiParam(hidden = true) Response resp) {
        Integer userId = Integer.valueOf(req.params("userId"));
        userService.deleteUser(userId);
        return true;
    }
}
