package com.optum.memberdetails.repos;

import com.optum.memberdetails.entities.MemberG;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository extends CrudRepository<MemberG, Serializable> {


	@Query(nativeQuery = true,value = "select * from memberg m where m.memgroupid = ?1")
	public List<MemberG> finByMemberGs(int searchmemgroupid);
	
	
}

