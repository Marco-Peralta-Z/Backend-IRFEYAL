package com.irfeyal.interfaces.parametrizacionacademica;

import java.util.List;

import com.irfeyal.modelo.rolseguridad.Empleado;

public interface EmpleadoServices {

    public List<Empleado> empleadoPorCargo(String cargo);
    
}
