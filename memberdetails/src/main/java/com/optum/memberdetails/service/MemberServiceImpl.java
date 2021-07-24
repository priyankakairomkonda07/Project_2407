package com.optum.memberdetails.service;


import com.optum.memberdetails.entities.MemberG;
import com.optum.memberdetails.entities.MemberGroup;
import com.optum.memberdetails.entities.MemberGroupContract;
import com.optum.memberdetails.exceptions.BirthDateException;
import com.optum.memberdetails.repos.MemberGroupContractRepository;
import com.optum.memberdetails.repos.MemberGroupRepository;
import com.optum.memberdetails.repos.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

@Service
public class MemberServiceImpl implements MemberService{

    @Autowired
    private MemberGroupRepository memberGroupRepository;

    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private MemberGroupContractRepository memberGroupContractRepository;

    @Override
    public MemberG save(MemberG memberG) throws Exception {
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(memberG.getBirthDate());
        int year = calendar.get(Calendar.YEAR);
        if(year>1950) {
            if(memberG.getCitizenshipStatus().equalsIgnoreCase("V")){
                if(! (memberG.getMemberGroup().getMemGroupName().equalsIgnoreCase("CT"))){
                    return memberRepository.save(memberG);
                }
                else{
                    throw new Exception("Member with citizenship status as “V” cannot be added to the memGroup “CT”");
                }
            }
            else{
                return memberRepository.save(memberG);
            }
        }
        else{
            throw new BirthDateException("Birth year of the Member should be greater than 1950");
        }

    }

    @Override
    public MemberGroup save(MemberGroup memberGroup) {
    	
    	int  noOfMembers = updateOrganizationType(memberGroup.getMemGroupID());
        MemberGroup obj = new MemberGroup();
        obj.setIndustryClassCodeType(memberGroup.getIndustryClassCodeType());
        obj.setIndustryClassCode(memberGroup.getIndustryClassCode());
        obj.setVendorID(memberGroup.getVendorID());
        obj.setExchangeType(memberGroup.getExchangeType());
        obj.setMemGroupID(memberGroup.getMemGroupID());
        obj.setMemGroupName(memberGroup.getMemGroupName());
        if(noOfMembers > 5){
            obj.setOrganizationType("business Segment");
        }
        else{
            obj.setOrganizationType("small group");
        }
        return memberGroupRepository.save(obj);
    }

    @Override
    public MemberGroupContract save(MemberGroupContract memberGroupContract) throws Exception {
    	
        if(memberGroupContract.getEffectiveDate().after(memberGroupContract.getExpirationDate())){
            throw new Exception("effectiveDate should be less than the expiration date of the contract.");
        }
        else{
        	
        	boolean a = memberGroupContract.getOriginalContractDate().after(memberGroupContract.getExpirationDate());
        	boolean b = memberGroupContract.getOriginalContractDate().before(memberGroupContract.getEffectiveDate());
        	if(!( a || b))
        	{
        		throw new Exception("Contracts with Overlapping effective and expiration date with the existing contract cannot be added");
        	}
        	else {
            return memberGroupContractRepository.save(memberGroupContract);
        	}
        }

    }

    @Override
    public int updateOrganizationType(int memGroupid) {
    	
    	List<MemberG> list =  memberRepository.finByMemberGs(memGroupid);
    	return list.size();

    }
}

