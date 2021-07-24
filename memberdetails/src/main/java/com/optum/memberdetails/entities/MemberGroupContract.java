package com.optum.memberdetails.entities;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "membergroupcontract")
public class MemberGroupContract {

    @Id
    @Column(name = "memgroupcontractid")
    private int memgroupcontractid;
    @Column(name = "contractdescription")
    private String contractDescription;
    @Column(name = "contractexpirationreason")
    private String contractExpirationReason;
    @Column(name = "renewalmonth")
    private String renewalMonth;
    @Column(name = "renewaldayofmonth")
    private String renewalDayOfMonth;
    @Column(name = "documentcontrolnumber")
    private String documentControlNumber;
    @Column(name = "contractstatus")
    private String contractStatus;
    @Column(name = "originalcontractdate")
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date originalContractDate;
    @Column(name = "validationstate")
    private String validationState;
    @Column(name = "effectivedate")
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date effectiveDate;
    @Column(name = "expirationdate")
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date expirationDate;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "memgroupid")
    private MemberGroup memberGroup;

    public int getMemgroupcontractid() {
        return memgroupcontractid;
    }

    public void setMemgroupcontractid(int memgroupcontractid) {
        this.memgroupcontractid = memgroupcontractid;
    }

    public Date getOriginalContractDate() {
        return originalContractDate;
    }

    public void setOriginalContractDate(Date originalContractDate) {
        this.originalContractDate = originalContractDate;
    }

    public Date getEffectiveDate() {
        return effectiveDate;
    }

    public void setEffectiveDate(Date effectiveDate) {
        this.effectiveDate = effectiveDate;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }


    public String getContractDescription() {
        return contractDescription;
    }
    public void setContractDescription(String contractDescription) {
        this.contractDescription = contractDescription;
    }
    public String getContractExpirationReason() {
        return contractExpirationReason;
    }
    public void setContractExpirationReason(String contractExpirationReason) {
        this.contractExpirationReason = contractExpirationReason;
    }
    public String getRenewalMonth() {
        return renewalMonth;
    }
    public void setRenewalMonth(String renewalMonth) {
        this.renewalMonth = renewalMonth;
    }
    public String getRenewalDayOfMonth() {
        return renewalDayOfMonth;
    }
    public void setRenewalDayOfMonth(String renewalDayOfMonth) {
        this.renewalDayOfMonth = renewalDayOfMonth;
    }
    public String getDocumentControlNumber() {
        return documentControlNumber;
    }
    public void setDocumentControlNumber(String documentControlNumber) {
        this.documentControlNumber = documentControlNumber;
    }
    public String getContractStatus() {
        return contractStatus;
    }
    public void setContractStatus(String contractStatus) {
        this.contractStatus = contractStatus;
    }

    public String getValidationState() {
        return validationState;
    }
    public void setValidationState(String validationState) {
        this.validationState = validationState;
    }

    public MemberGroup getMemberGroup() {
        return memberGroup;
    }
    public void setMemberGroup(MemberGroup memberGroup) {
        this.memberGroup = memberGroup;
    }

}
