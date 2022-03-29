
INSERT INTO public.pais (id_pais ,pais) VALUES(1,'Ecuador');

INSERT INTO public.provincia (id_provincia ,provincia) VALUES(1,'AZUAY'),(2,'LOJA'),(3,'CAÑAR'),(4,'GUAYAS');

INSERT INTO public.canton (id_canton,canton) VALUES(101,'CUENCA'),(102,'GIRON'),(103,'CATAMAYO'),(104,'AZOGUES'), (105,'BIBLIAN'),(106,'GUAYAQUIL'),(107,'RIOBAMBA'),(108,'QUITO');
INSERT INTO public.parroquia (id_parroquia,parroquia) VALUES(500,'BELLAVISTA'),(501,'EL BATAN'),(502,'MONAY'),(503,'SAN BLAS'),(504,'BORRERO'),	(505,'SAN FRANCISCO'),(506,'PUNIN'), (507,'FLORES'), (508,'BOLIVAR'), (509,'ROCAFUERTE');

INSERT INTO public.genero (id_genero,genero) VALUES(1,'MASCULINO'),(2,'FEMENINO'),(3,'OTRO');
INSERT INTO public.direccion (id_direccion,av_principal,av_secundaria,id_canton,id_pais,id_parroquia,id_provincia) VALUES(11,'AV. DE LAS AMERICAS','LUIS CORDERO',101,1,500,1);

INSERT INTO public.empresa (id_empresa,nombre_empresa,id_direccion) VALUES(110,'irfeyal',11);

	
