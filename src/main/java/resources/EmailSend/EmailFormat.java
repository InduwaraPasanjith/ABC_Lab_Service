/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package resources.EmailSend;

/**
 *
 * @author induwara
 */
public class EmailFormat {
    public static String emailBody(String msg,String userEmail, String passowrd) {
        return msg = "Hello,\n\n"
                    + "Your login credentials are as follows:\n"
                    + "Username: " + userEmail + "\n"
                    + "Password: " + passowrd + "\n\n"
                    + "Please keep this information secure.";
        
    }
    
    public static String emailBodyPayment(String msg) {
        return msg = "Hello,\n\n"
                    + "\"Your credit card payment of Rs.1200 was successful. Thank you for your payment!";
        
    }
}
