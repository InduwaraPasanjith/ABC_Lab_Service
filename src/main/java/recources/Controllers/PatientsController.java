/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package recources.Controllers;

import com.google.gson.Gson;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.sql.SQLException;
import recources.DataAccess.PatientsDataAccess;
import recources.DataAccess.UserInformationDataAccess;
import static resources.EmailSend.Email.sendEmail;
import static resources.EmailSend.EmailFormat.emailBody;
import static resources.EmailSend.PasswordGenerator.generateRandomPassword;
import resources.Model.Patient;
import resources.Model.UserInformation;
//import resources.DataAccess.
/**
 *
 * @author induwara
 */

@Path("patients")
public class PatientsController {
    
     Gson gson = new Gson();

    public PatientsController() {
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getStudents(){ 
        
        
        return Response
                .ok(gson.toJson(new PatientsDataAccess().getPatients()))
                .build();
    }
    
    
    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getStudent(@PathParam("id") int id){ 
        try {
        Patient student = new PatientsDataAccess().getPatients(id);
        
        if (student != null) {
                  return Response
                    .ok(gson.toJson(student))
                    .build();
        } 

        return Response
                .status(Response.Status.NOT_FOUND)
                .build();
        } catch(SQLException e) {
             return Response
                .status(Response.Status.INTERNAL_SERVER_ERROR)
                .build();
        }
    }
    
     @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addStudent(String json){ 
        String message = "";
        UserInformation UserInfor =null;
        Patient Patient = gson.fromJson(json, Patient.class); 
        String password = generateRandomPassword(8);
        String emailBody = emailBody(message,Patient.getEmail(),password);
        sendEmail(Patient.getEmail(),"Patient Login Info",emailBody);
        UserInfor = new UserInformation();
        UserInfor.setEmail(Patient.getEmail());
        UserInfor.setPassword(password); 
        UserInfor.setUserName(Patient.getpName()); 
        UserInfor.setrId(3); 
        new UserInformationDataAccess().addUserInformation(UserInfor);
        new PatientsDataAccess().addPatients(Patient);
        return Response
                .status(Response.Status.CREATED)
                .build();
    }
    
    @PUT
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateStudent(String json, @PathParam("id") int id){ 
        Patient student = gson.fromJson(json, Patient.class);
        new PatientsDataAccess().updatePatients(student);
        return Response
                    .ok()
                    .build();
    }
    
    
    @DELETE
    @Path("{id}")
    public Response deleteStudent(@PathParam("id") int id){ 
        new PatientsDataAccess().deletePatients(id);
        return Response
            .ok()
            .build();
    }

    
}
