package com.optum.memberdetails.service;

import com.optum.memberdetails.entities.MemberG;
import com.optum.memberdetails.entities.MemberGroup;
import com.optum.memberdetails.entities.MemberGroupContract;

public interface MemberService {


    MemberG save(MemberG memberG) throws Exception;

    MemberGroup save(MemberGroup memberGroup);


    MemberGroupContract save(MemberGroupContract memberGroupContract) throws Exception;

    int  updateOrganizationType(int memGroupid);
}