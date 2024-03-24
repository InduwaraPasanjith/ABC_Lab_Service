/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package resources.Model;

/**
 *
 * @author induwara
 */
public class Appoinment {
    
    private int apId;
    private String apDetails;
    private String apDocuments;
    private String apType;
    private String recdoc;
    private int pId;

    public Appoinment(int apId, String apDetails, String apDocuments, String apType, String recdoc, int pId) {
        this.apId = apId;
        this.apDetails = apDetails;
        this.apDocuments = apDocuments;
        this.apType = apType;
        this.recdoc = recdoc;
        this.pId = pId;
    }

    public Appoinment() {
    }

    public int getApId() {
        return apId;
    }

    public void setApId(int apId) {
        this.apId = apId;
    }

    public String getApDetails() {
        return apDetails;
    }

    public void setApDetails(String apDetails) {
        this.apDetails = apDetails;
    }

    public String getApDocuments() {
        return apDocuments;
    }

    public void setApDocuments(String apDocuments) {
        this.apDocuments = apDocuments;
    }

    public String getApType() {
        return apType;
    }

    public void setApType(String apType) {
        this.apType = apType;
    }

    public String getRecdoc() {
        return recdoc;
    }

    public void setRecdoc(String recdoc) {
        this.recdoc = recdoc;
    }

    public int getpId() {
        return pId;
    }

    public void setpId(int pId) {
        this.pId = pId;
    }

    


}
