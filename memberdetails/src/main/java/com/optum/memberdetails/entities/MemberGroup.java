package com.optum.memberdetails.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "membergroup")
public class MemberGroup {

    @Id
    @Column(name = "memgroupid")
    private int memGroupID;
    @Column(name = "memgroupname")
    private String memGroupName;
    @Column(name = "industryclasscode")
    private String industryClassCode;
    @Column(name = "industryclasscodetype")
    private String industryClassCodeType;
    @Column(name = "organizationtype")
    private String organizationType;
    @Column(name = "exchangetype")
    private String exchangeType;
    @Column(name = "vendorid")
    private String vendorID;
    
    public MemberGroup() {
    }

    public MemberGroup(int memGroupID, String memGroupName, String industryClassCode, String industryClassCodeType, String organizationType, String exchangeType, String vendorID) {
        super();
        this.memGroupID = memGroupID;
        this.memGroupName = memGroupName;
        this.industryClassCode = industryClassCode;
        this.industryClassCodeType = industryClassCodeType;
        this.organizationType = organizationType;
        this.exchangeType = exchangeType;
        this.vendorID = vendorID;
    }

    
	public int getMemGroupID() {
        return memGroupID;
    }

    public void setMemGroupID(int memGroupID) {
        this.memGroupID = memGroupID;
    }

    public String getMemGroupName() {
        return memGroupName;
    }
    public void setMemGroupName(String memGroupName) {
        this.memGroupName = memGroupName;
    }
    public String getIndustryClassCode() {
        return industryClassCode;
    }
    public void setIndustryClassCode(String industryClassCode) {
        this.industryClassCode = industryClassCode;
    }
    public String getIndustryClassCodeType() {
        return industryClassCodeType;
    }
    public void setIndustryClassCodeType(String industryClassCodeType) {
        this.industryClassCodeType = industryClassCodeType;
    }
    public String getOrganizationType() {
        return organizationType;
    }
    public void setOrganizationType(String organizationType) {
        this.organizationType = organizationType;
    }
    public String getExchangeType() {
        return exchangeType;
    }
    public void setExchangeType(String exchangeType) {
        this.exchangeType = exchangeType;
    }
    public String getVendorID() {
        return vendorID;
    }
    public void setVendorID(String vendorID) {
        this.vendorID = vendorID;
    }


}