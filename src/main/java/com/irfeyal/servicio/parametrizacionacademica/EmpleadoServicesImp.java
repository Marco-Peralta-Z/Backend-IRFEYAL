package com.irfeyal.servicio.parametrizacionacademica;

import java.util.List;

import com.irfeyal.interfaces.parametrizacionacademica.EmpleadoServices;
import com.irfeyal.modelo.dao.parametrizacionacademica.EmpleadoRepository;
import com.irfeyal.modelo.rolseguridad.Empleado;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmpleadoServicesImp implements EmpleadoServices{

    @Autowired
    private EmpleadoRepository empleadoRepo;

    @Override
    public List<Empleado> empleadoPorCargo(String cargo) {
        return empleadoRepo.empleadoByCargo(cargo);
    }

}
