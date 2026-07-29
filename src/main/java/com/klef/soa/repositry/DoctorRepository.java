package com.klef.soa.repositry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.klef.soa.entity.Doctor;
import java.util.List;



@Repository

public interface DoctorRepository extends JpaRepository<Doctor, Long>
{
	//from Doctor d where d.gender=?1
	List<Doctor> findByGender(String gender);
	
}
