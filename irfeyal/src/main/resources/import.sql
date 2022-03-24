
INSERT INTO public.pais (id_pais ,pais) VALUES(1,'Ecuador');

INSERT INTO public.provincia (id_provincia ,provincia) VALUES(1,'AZUAY'),(2,'LOJA'),(3,'CAÑAR'),(4,'GUAYAS');

INSERT INTO public.canton (id_canton,canton) VALUES(101,'CUENCA'),(102,'GIRON'),(103,'CATAMAYO'),(104,'AZOGUES'), (105,'BIBLIAN'),(106,'GUAYAQUIL'),(107,'RIOBAMBA'),(108,'QUITO');
INSERT INTO public.parroquia (id_parroquia,parroquia) VALUES(500,'BELLAVISTA'),(501,'EL BATAN'),(502,'MONAY'),(503,'SAN BLAS'),(504,'BORRERO'),	(505,'SAN FRANCISCO'),(506,'PUNIN'), (507,'FLORES'), (508,'BOLIVAR'), (509,'ROCAFUERTE');

INSERT INTO public.genero (id_genero,genero) VALUES(1,'MASCULINO'),(2,'FEMENINO'),(3,'OTRO');

INSERT INTO public.empresa (id_empresa,empresa) VALUES(110,'irfeyal');

INSERT INTO public.direccion (id_direccion,av_principal,av_secundaria,id_canton,id_empresa,id_pais,id_parroquia,id_provincia) VALUES(11,'AV. DE LAS AMERICAS','LUIS CORDERO',101,110,1,500,1);
	
--Direccion Secretaria
INSERT INTO public.direccion (id_direccion,av_principal,av_secundaria,id_canton,id_empresa,id_pais,id_parroquia,id_provincia) VALUES(12,'sucre','sangurima',101,110,1,501,1);
INSERT INTO public."extension" (id_extension,"extension",id_direccion,id_empresa) VALUES(501,'irfeyal_azogues',11,110);
	
INSERT INTO public.direccion(id_direccion ,av_principal, av_secundaria, id_canton, id_empresa, id_pais, id_parroquia, id_provincia)VALUES(1,'Calle principal', 'calle secundaria', 101, 110, 1, 505, 1),(2,'Calle principal', 'calle secundaria', 101, 110, 1, 505, 1),(3,'Calle principal', 'calle secundaria', 101, 110, 1, 505, 1),(4,'Calle principal', 'calle secundaria',  101, 110, 1, 505, 1),(5,'Calle principal', 'calle secundaria',  101, 110, 1, 505, 1),(6,'Calle principal', 'calle secundaria', 101, 110, 1, 505, 1),(7,'Calle principal', 'calle secundaria', 101, 110, 1, 505, 1),(8,'Calle principal', 'calle secundaria', 101, 110, 1, 505, 1),(9,'Calle principal', 'calle secundaria', 101, 110, 1, 505, 1),(10,'Calle principal', 'calle secundaria', 101, 110, 1, 505, 1);

--Insert de tabla personas
--Doireccion secretaria
INSERT INTO public.persona (id_persona ,apellido,cedula,fecha_nacimiento,nombre,id_direccion,id_genero) VALUES(11,'Orellana','200356492','12/12/1996','Laura',12,2);
	 	 
INSERT INTO public.persona(id_persona ,apellido, cedula, fecha_nacimiento, nombre, id_direccion, id_genero)VALUES(1, 'Mendez', '0107462125', '15-11-1988', 'Juan', 1, 1),(2,'Suarez', '0107462345', '12-10-1995', 'Carina', 2, 2),(3,'Oyola', '0107462378', '01-09-1991', 'Matias', 3, 1),(4,'Ramirez', '0107462314', '10-08-1989', 'Eduardo', 4, 1),(5,'Diaz', '0107462377', '22-03-1993', 'Elisa', 5, 2),(6,'Nieves', '0107462300', '22-04-1999', 'Fernada', 6, 2),(7,'Mendieta', '0107462344', '28-03-1995', 'Luis', 7, 1),(8,'Cañizares', '0107462333', '01-03-1997', 'Abel', 8,1),(9,'Cordoba', '0107462311', '20-07-1990', 'Jonathan', 9, 1),(10,'Mendoza', '0107462328', '24-11-1984', 'Vinicio', 10, 1);


INSERT INTO public.rol (id_rol,descripcion) VALUES(1,'Administrador'),(2,'Gerente'),(3,'Secretaria'),(4,'estudiante'),(5,'docente'),(6,'estudiante'),(7,'tutor'),(8,'coordinador administrativo'),(9,'coordinador de desarrollo institucional');

INSERT INTO public.usuario (id_usuario,contrasenia,est_usuario,usuario,id_persona) VALUES(1,'123','activo','secre',11);		
	
INSERT INTO public.rol_usuario (id_rolusuario,estado,id_rol,id_usuario) VALUES(1,true,3,1);


INSERT INTO public.estudiantes(id_estudiante ,estado_estudiante, id_extension, id_persona)VALUES(1,'1', 501, 1),(2,'1', 501, 2),(3,'1', 501,3),(4,'1', 501, 4),(5,'1', 501, 5),(6,'1', 501, 6),(7,'1', 501, 7),(8,'1', 501, 8),(9,'1', 501, 9),(10,'1', 501, 10);



	
