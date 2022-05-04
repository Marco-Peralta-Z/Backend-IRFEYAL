package com.irfeyal.modelo.dao.parametrizacionacademica;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.irfeyal.modelo.rolseguridad.Empleado;

@Repository
public interface EmpleadoRepository extends JpaRepository<Empleado, Long>{

	@Query(value = "SELECT * FROM empleado WHERE cargo = :cargo", nativeQuery = true)
	public List<Empleado> empleadoByCargo(String cargo);
	
}
