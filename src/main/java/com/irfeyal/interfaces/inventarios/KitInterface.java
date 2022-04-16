package com.irfeyal.interfaces.inventarios;

import java.util.List;
import java.util.Optional;
import com.irfeyal.modelo.inventarios.Kit;


//@Service("KitInterface")
public interface KitInterface {
	
	public abstract Kit save(Kit kit);

	public abstract List<Kit> listAllKit();
	
	public abstract Optional<Kit> getById(Long kitId);

	public abstract Kit update(Long kitId, double nuevokit);

	public abstract boolean delete(Long kitId);

}
