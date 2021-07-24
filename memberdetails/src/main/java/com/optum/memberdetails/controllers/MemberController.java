package com.optum.memberdetails.controllers;


import com.optum.memberdetails.entities.MemberG;
import com.optum.memberdetails.entities.MemberGroup;
import com.optum.memberdetails.entities.MemberGroupContract;
import com.optum.memberdetails.repos.MemberGroupContractRepository;
import com.optum.memberdetails.repos.MemberGroupRepository;
import com.optum.memberdetails.repos.MemberRepository;
import com.optum.memberdetails.service.MemberServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@CrossOrigin
@RestController
@RequestMapping("/member")
public class MemberController {

    @Autowired
    MemberGroupRepository memberGroupRepository;
    @Autowired
    MemberRepository memberRepository;
    @Autowired
    MemberGroupContractRepository memberGroupContractRepository;

    @Autowired
    MemberServiceImpl memberServiceImpl;

    @PostMapping ("/savemember")
    public MemberG createMember(@RequestBody MemberG memberG) throws Exception {
        return memberServiceImpl.save(memberG);
        //return memberRepository.save(memberG);
    }

    @PostMapping ("/savemembergroup")
    public MemberGroup createMemberGroup(@RequestBody MemberGroup memberGroup) throws Exception {
        return memberServiceImpl.save(memberGroup);
        //return memberGroupRepository.save(memberGroup);
    }
    @PostMapping ("/savemembergroupcontract")
    public MemberGroupContract createMemberGroupContract(@RequestBody MemberGroupContract memberGroupContract) throws Exception {
        return memberServiceImpl.save(memberGroupContract);
        //return memberGroupContractRepository.save(memberGroupContract);
    }
    @GetMapping("/getmembergroup")
    public List<MemberGroup> getMember() throws Exception {

        return memberGroupRepository.findAll();
    }

    @GetMapping("/getmembergcontract")
    public List<MemberGroupContract> getMcontract() throws Exception {

        return memberGroupContractRepository.findAll();
    }
    
  @GetMapping("/get/{searchmemgroupid}")
  public int getMemberDetails(@PathVariable int searchmemgroupid) throws Exception {

      return memberGroupRepository.findbyGroups(searchmemgroupid);
  }

    @GetMapping("/getmember")
    public Iterable<MemberG> getMemberDetails() throws Exception {

        return memberRepository.findAll();
    }
//    @GetMapping("/getfindBysearchid")
//    public List<MemberGroup> findBysearchid() throws Exception {
//
//        return memberServiceImpl.findBysearchid();
//    }

}