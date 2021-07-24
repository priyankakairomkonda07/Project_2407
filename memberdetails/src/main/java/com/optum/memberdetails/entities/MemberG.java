package com.optum.memberdetails.entities;


import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "memberg")
public class MemberG {

    @Id
    @Column(name = "memberid")
    private int memberID;
    @Column(name = "membername")
    private String membername;
    @Column(name = "birthdate")
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date birthDate;
    @Column(name = "maritalstatus")
    private String maritalStatus;
    @Column(name = "citizenshipstatus")
    private String citizenshipStatus;
    @Column(name = "privacytype")
    private String privacyType;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "memgroupid")
    private MemberGroup memberGroup;

    public MemberG() {
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public MemberG(int memberID, String membername, Date birthDate, String maritalStatus, String citizenshipStatus, String privacyType, MemberGroup memberGroup) {
        super();
        this.memberID = memberID;
        this.membername = membername;
        this.birthDate = birthDate;
        this.maritalStatus = maritalStatus;
        this.citizenshipStatus = citizenshipStatus;
        this.privacyType = privacyType;
        this.memberGroup = memberGroup;
    }

    public int getMemberID() {
        return memberID;
    }

    public void setMemberID(int memberID) {
        this.memberID = memberID;
    }

    public MemberGroup getMemberGroup() {
        return memberGroup;
    }
    public void setMemberGroup(MemberGroup memberGroup) {
        this.memberGroup = memberGroup;
    }
    public String getMembername() {
        return membername;
    }
    public void setMembername(String membername) {
        this.membername = membername;
    }

    public String getMaritalStatus() {
        return maritalStatus;
    }
    public void setMaritalStatus(String maritalStatus) {
        this.maritalStatus = maritalStatus;
    }
    public String getCitizenshipStatus() {
        return citizenshipStatus;
    }
    public void setCitizenshipStatus(String citizenshipStatus) {
        this.citizenshipStatus = citizenshipStatus;
    }
    public String getPrivacyType() {
        return privacyType;
    }
    public void setPrivacyType(String privacyType) {
        this.privacyType = privacyType;
    }

}