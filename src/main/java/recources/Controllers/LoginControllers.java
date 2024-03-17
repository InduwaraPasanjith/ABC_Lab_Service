/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package recources.Controllers;

import com.google.gson.Gson;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import recources.DataAccess.LoginDataAccess;
import resources.Model.Login;

/**
 *
 * @author induwara
 */
@Path("login")
public class LoginControllers {
    Gson gson = new Gson(); 

    public LoginControllers() {
        
    }
    
    @POST
    //@Path("{json}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response login(String json){ 
        try {
            Login login = gson.fromJson(json, Login.class); 
            //UserInformation user = gson.fromJson(json, UserInformation.class); 
            var user = new LoginDataAccess().login(login);
                if (user != null) {
                      return Response
                        .ok(gson.toJson(user))
                        .build();
                } else{
                    return Response
                .status(Response.Status.INTERNAL_SERVER_ERROR)
                .build();
                }
            
        } catch(Exception e) {
             return Response
                .status(Response.Status.INTERNAL_SERVER_ERROR)
                .build();
        }
    }
}
