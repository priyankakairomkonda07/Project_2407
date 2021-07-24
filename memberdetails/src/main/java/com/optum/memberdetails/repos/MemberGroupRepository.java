package com.optum.memberdetails.repos;

import com.optum.memberdetails.entities.MemberG;
import com.optum.memberdetails.entities.MemberGroup;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberGroupRepository extends JpaRepository<MemberGroup, Integer> {

//    @Query("select l from membergroup l,member m where l.memgroupid = m.memgroupid")
//    public List<MemberGroup> findBysearchid();
	
	@Query(nativeQuery = true,value = "select count(*) from membergroup m where m.memgroupid = ?1")
	public int findbyGroups(int searchmemgroupid);

}