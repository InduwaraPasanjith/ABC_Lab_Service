/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package resources.Model;

/**
 *
 * @author induwara
 */
public class Admin {
    
    private int aId;
    private String aName;
    private String nic;
    private String phoneNumber;
    private String email;
    private int uiId;
    
    public Admin(){
        
    }

    public Admin(int aId, String aName, String nic, String phoneNumber, String email, int uiId) {
        this.aId = aId;
        this.aName = aName;
        this.nic = nic;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.uiId = uiId;
    }

    public int getaId() {
        return aId;
    }

    public void setaId(int aId) {
        this.aId = aId;
    }

    public String getaName() {
        return aName;
    }

    public void setaName(String aName) {
        this.aName = aName;
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

    public int getUiId() {
        return uiId;
    }

    public void setUiId(int uiId) {
        this.uiId = uiId;
    }
    
}
