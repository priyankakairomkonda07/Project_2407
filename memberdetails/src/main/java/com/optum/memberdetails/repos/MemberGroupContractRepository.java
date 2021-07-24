package com.optum.memberdetails.repos;

import com.optum.memberdetails.entities.MemberGroupContract;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberGroupContractRepository  extends JpaRepository<MemberGroupContract, Integer> {
}
