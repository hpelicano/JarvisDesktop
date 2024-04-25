package com.fiserv.jarvis.models;

/**
 * @author F1W1JF7
 */
public class dbTestCases {
    
    private Long Id;
    private String TestDate;
    private String CaseNumber;
    private String Status;
    private String SequenceNumber;
    private String RespCode;
    private String ElapseTime;

    public dbTestCases() {
    }

    
    
    public dbTestCases(Long Id, String TestDate, String CaseNumber, String Status, String SequenceNumber, String RespCode, String ElapseTime) {
        this.Id = Id;
        this.TestDate = TestDate;
        this.CaseNumber = CaseNumber;
        this.Status = Status;
        this.SequenceNumber = SequenceNumber;
        this.RespCode = RespCode;
        this.ElapseTime = ElapseTime;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long Id) {
        this.Id = Id;
    }

    public String getTestDate() {
        return TestDate;
    }

    public void setTestDate(String TestDate) {
        this.TestDate = TestDate;
    }

    public String getCaseNumber() {
        return CaseNumber;
    }

    public void setCaseNumber(String CaseNumber) {
        this.CaseNumber = CaseNumber;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String Status) {
        this.Status = Status;
    }

    public String getSequenceNumber() {
        return SequenceNumber;
    }

    public void setSequenceNumber(String SequenceNumber) {
        this.SequenceNumber = SequenceNumber;
    }

    public String getRespCode() {
        return RespCode;
    }

    public void setRespCode(String RespCode) {
        this.RespCode = RespCode;
    }

    public String getElapseTime() {
        return ElapseTime;
    }

    public void setElapseTime(String ElapseTime) {
        this.ElapseTime = ElapseTime;
    }

    @Override
    public String toString() {
        return "dbTestCases{" + "Id=" + Id + ", TestDate=" + TestDate + ", CaseNumber=" + CaseNumber + ", Status=" + Status + ", SequenceNumber=" + SequenceNumber + ", RespCode=" + RespCode + ", ElapseTime=" + ElapseTime + '}';
    }
    
    
    
    
}
