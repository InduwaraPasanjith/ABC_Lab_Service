/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package resources.Model;

import java.sql.Date;

/**
 *
 * @author induwara
 */
public class Patients {
    
    private int pId;
    private String pName;
    private String nic;
    private String phoneNumber;
    private String email;
    private Date dob;
    private int uiId;
    
    
    public Patients(){
        
    }

    public Patients(int pId, String pName, String nic, String phoneNumber, String email, Date dob, int uiId) {
        this.pId = pId;
        this.pName = pName;
        this.nic = nic;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.dob = dob;
        this.uiId = uiId;
    }

    public int getpId() {
        return pId;
    }

    public void setpId(int pId) {
        this.pId = pId;
    }

    public String getpName() {
        return pName;
    }

    public void setpName(String pName) {
        this.pName = pName;
    }

    public String getNic() {
        return nic;
    }

    public void setNic(String nic) {
        this.nic = nic;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public int getUiId() {
        return uiId;
    }

    public void setUiId(int uiId) {
        this.uiId = uiId;
    }

    
   
}
