/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.webant.tournament.user.ws;

import fr.webant.tournament.user.core.dto.User;
import fr.webant.tournament.user.core.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import javax.inject.Inject;
import javax.inject.Singleton;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import spark.Request;
import spark.Response;
import spark.Route;

/**
 *
 * @author anthony
 */
@Singleton
@Api("/users")
@Path("/users")
@Produces("application/json")
public class FindUsersRoute implements Route {

    private UserService userService;
    
    @Inject
    private FindUsersRoute(UserService userService){
        this.userService = userService;
    }

    @Override
    @GET
    @ApiOperation(value = "Retrieve all users", nickname = "findUsers")
    @ApiParam(name = "userId", allowEmptyValue = false, type = "Integer.class", required = true)
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Success", response = User.class),        
//	@ApiResponse(code = 400, message = "Invalid input data", response = ApiError.class), 
//        @ApiResponse(code = 401, message = "Unauthorized", response = ApiError.class),
//	@ApiResponse(code = 404, message = "User not found", response = ApiError.class) 
    })
    public Object handle(@ApiParam(hidden = true) Request rqst, @ApiParam(hidden = true) Response rspns) throws Exception {
        return userService.findAll();
       
    }

}
