package com.irfeyal.interfaces.inventarios;

import java.util.List;
import java.util.Optional;

import org.springframework.validation.BindingResult;

import com.irfeyal.modelo.inventarios.Kit;


//@Service("KitInterface")
public interface KitInterface {
	
	public abstract Kit save(Kit kit, BindingResult result);

	public abstract List<Kit> listAllKit();
	
	public abstract Optional<Kit> getById(Long kitId);

	public abstract Kit update(Kit kit);

	public abstract Kit delete(Long kitId);

}
