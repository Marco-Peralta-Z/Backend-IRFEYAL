package com.irfeyal.modelo.dao.parametrizacionacademica;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.irfeyal.modelo.parametrizacionacademica.Tutor;

@Repository
public interface TutorRepository extends JpaRepository<Tutor, Long> {

}
