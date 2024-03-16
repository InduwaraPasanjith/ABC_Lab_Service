/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package resources.Model;

/**
 *
 * @author induwara
 */
public class Prescription {
    
    private int prId;
    private String prTestResult;
    private String prComment;
    private String prDocument;
    private int apId;
    
    public Prescription(){
        
    }

    public Prescription(int prId, String prTestResult, String prComment, String prDocument, int apId) {
        this.prId = prId;
        this.prTestResult = prTestResult;
        this.prComment = prComment;
        this.prDocument = prDocument;
        this.apId = apId;
    }

    public int getPrId() {
        return prId;
    }

    public void setPrId(int prId) {
        this.prId = prId;
    }

    public String getPrTestResult() {
        return prTestResult;
    }

    public void setPrTestResult(String prTestResult) {
        this.prTestResult = prTestResult;
    }

    public String getPrComment() {
        return prComment;
    }

    public void setPrComment(String prComment) {
        this.prComment = prComment;
    }

    public String getPrDocument() {
        return prDocument;
    }

    public void setPrDocument(String prDocument) {
        this.prDocument = prDocument;
    }

    public int getApId() {
        return apId;
    }

    public void setApId(int apId) {
        this.apId = apId;
    }
    
    
    
}
