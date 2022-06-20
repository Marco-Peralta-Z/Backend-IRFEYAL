--------ROLES Y SEGURIDAD------

-------------------PAIS-------------------
INSERT INTO pais (pais) VALUES ('Ecuador');
INSERT INTO pais (pais) VALUES ('colombia');
INSERT INTO pais (pais) VALUES ('peru');
INSERT INTO pais (pais) VALUES ('chile');

-------------------PROVINCIA-------------------

INSERT INTO provincia (provincia) VALUES ('BOLIVAR');
INSERT INTO provincia (provincia) VALUES ('AZUAY');
INSERT INTO provincia (provincia) VALUES ('CARCHI');
INSERT INTO provincia (provincia) VALUES ('AZUAY');
INSERT INTO provincia (provincia) VALUES ('COTOPAXI');

-------------------CANTON-------------------
INSERT INTO canton (canton) VALUES ('CUENCA');
INSERT INTO canton (canton) VALUES ('GUARANDA');
INSERT INTO canton (canton) VALUES ('GIRON');
INSERT INTO canton (canton) VALUES ('CHIMBO');
INSERT INTO canton (canton) VALUES ('TULCAN');
INSERT INTO canton (canton) VALUES ('LATACUNGA');
INSERT INTO canton (canton) VALUES ('PUJILI');

-------------------PARROQUIA-------------------
INSERT INTO parroquia (parroquia) VALUES  ('BELLAVISTA');
INSERT INTO parroquia (parroquia) VALUES  ('ASUNCION');
INSERT INTO parroquia (parroquia) VALUES ('GUARANDA');
INSERT INTO parroquia (parroquia) VALUES  ('MALDONADO');
INSERT INTO parroquia (parroquia) VALUES  ('TOACASO');

-------------------GENERO-------------------
INSERT INTO genero (genero) VALUES ('FEMENINO');
INSERT INTO genero (genero) VALUES ('MASCULINO');

-------------------PERSONA-------------------
INSERT INTO persona (apellido, cedula, fecha_nacimiento, nombre, id_genero) VALUES ('Guayllas', '0102184322', '1998-04-17 19:00:00', 'magaly', 1);
INSERT INTO persona (apellido, cedula, fecha_nacimiento, nombre, id_genero) VALUES ('Lopez','0102879991','1997-02-18 19:00:00','juan',2);
INSERT INTO persona (apellido, cedula, fecha_nacimiento, nombre, id_genero) VALUES ('Ramirez','0107039971','1995-01-01 19:00:00','Ramiro',2);
INSERT INTO persona (apellido, cedula, fecha_nacimiento, nombre, id_genero) VALUES ('Perez','0107049975','1990-04-23 19:00:00','Paulina',1);
INSERT INTO persona (apellido, cedula, fecha_nacimiento, nombre, id_genero) VALUES ('Morocho','0103079940','1992-10-17 19:00:00','Elena',1);
INSERT INTO persona (apellido, cedula, fecha_nacimiento, nombre, id_genero) VALUES ('Pesantez','1056789020','1990-11-17 19:00:00','Alberto',2);
INSERT INTO persona (apellido, cedula, fecha_nacimiento, nombre, id_genero) VALUES ('Reino','1056780100','1997-09-19 19:00:00','Rodrigo',2);
INSERT INTO persona (apellido, cedula, fecha_nacimiento, nombre, id_genero) VALUES ('Sanchez','0100670892','1993-09-30 19:00:00','Naina',1);
INSERT INTO persona (apellido, cedula, fecha_nacimiento, nombre, id_genero) VALUES ('Quito','0108625478','1995-10-31 19:00:00','Ana',1);
INSERT INTO persona (apellido, cedula, fecha_nacimiento, nombre, id_genero) VALUES ('Perez','0105983216','1990-03-20 19:00:00','Belen',1);
INSERT INTO persona (apellido, cedula, fecha_nacimiento, nombre, id_genero) VALUES ('Murillo','0102587436','1950-08-10 19:00:00','Juana',1);
INSERT INTO persona (apellido, cedula, fecha_nacimiento, nombre, id_genero) VALUES ('Gonzales','0106893251','19987-07-03 19:00:00','Karina',1);
INSERT INTO persona (apellido, cedula, fecha_nacimiento, nombre, id_genero) VALUES ('Pauta','0132548740','1992-06-05 19:00:00','Robert',2);
INSERT INTO persona (apellido, cedula, fecha_nacimiento, nombre, id_genero) VALUES ('Salamea','0105986312','1998-05-18 19:00:00','Paulina',1);
INSERT INTO persona (apellido, cedula, fecha_nacimiento, nombre, id_genero) VALUES ('Ordoñes','0125896314','1993-11-14 19:00:00','Martha',1);
INSERT INTO persona (apellido, cedula, fecha_nacimiento, nombre, id_genero) VALUES ('Velez','0302154789','1994-04-02 19:00:00','Andrea',1);

-------------------PERSONA ESTUDIANTE-------------------

INSERT INTO persona (apellido, cedula, fecha_nacimiento, nombre, id_genero) VALUES ('Acevedo Manríquez', '0102549612', '1998-04-14 19:00:00', 'María Mireya', 1);
INSERT INTO persona (apellido, cedula, fecha_nacimiento, nombre, id_genero) VALUES ('Alejo Guerrero','0102877771','1997-02-01 19:00:00','Víctor Hugo',2);
INSERT INTO persona (apellido, cedula, fecha_nacimiento, nombre, id_genero) VALUES ('Ramirez Ibarra','0107031234','1995-01-15 19:00:00','Pascual Gerardo',2);
INSERT INTO persona (apellido, cedula, fecha_nacimiento, nombre, id_genero) VALUES ('Perez Santos','0107049456','1990-04-20 19:00:00','Paulina Rocio',1);
INSERT INTO persona (apellido, cedula, fecha_nacimiento, nombre, id_genero) VALUES ('Alarcon Perez','0703079940','1992-10-14 19:00:00','Maria Elena',1);
INSERT INTO persona (apellido, cedula, fecha_nacimiento, nombre, id_genero) VALUES ('Pesantez Camacho','0756789020','1990-11-05 19:00:00','Alberto Jose',2);
INSERT INTO persona (apellido, cedula, fecha_nacimiento, nombre, id_genero) VALUES ('Reina Navarro','0756780100','1997-09-19 19:00:00','Rodrigo Jesus',2);
INSERT INTO persona (apellido, cedula, fecha_nacimiento, nombre, id_genero) VALUES ('Sanchez Barbosa','0700670892','1993-09-10 19:00:00','Naina Rocio',1);
INSERT INTO persona (apellido, cedula, fecha_nacimiento, nombre, id_genero) VALUES ('Aleman Martinez','0108225475','1995-10-31 19:00:00','Ana Lucrecia',1);
INSERT INTO persona (apellido, cedula, fecha_nacimiento, nombre, id_genero) VALUES ('Perez Vargas','0705983216','1998-04-20 19:00:00','Belen Ofelia',1);
INSERT INTO persona (apellido, cedula, fecha_nacimiento, nombre, id_genero) VALUES ('Murillo Amaya','0702587436','1995-07-10 19:00:00','Andrea Lucia',1);
INSERT INTO persona (apellido, cedula, fecha_nacimiento, nombre, id_genero) VALUES ('Gonzales Melgar','0708893251','1998-06-03 19:00:00','Karina Rosalia',1);
INSERT INTO persona (apellido, cedula, fecha_nacimiento, nombre, id_genero) VALUES ('Pauta Arbea','0722548740','1992-06-05 19:00:00','Robert Javier',2);
INSERT INTO persona (apellido, cedula, fecha_nacimiento, nombre, id_genero) VALUES ('Salamea Burgos','0785986312','1994-05-18 19:00:00','Martha Paula',1);
INSERT INTO persona (apellido, cedula, fecha_nacimiento, nombre, id_genero) VALUES ('Ordoñes Valladares','0715896314','1993-09-14 19:00:00','Socorro',1);
INSERT INTO persona (apellido, cedula, fecha_nacimiento, nombre, id_genero) VALUES ('Velez Garcia','0184154789','1994-04-02 19:00:00','Angela',1);





-------------------DIRECCION-------------------
INSERT INTO direccion (av_principal, av_secundaria, id_canton, id_pais, id_parroquia, id_provincia) VALUES ('nueva calle', 'calle vieja', 1, 1, 1, 1);
INSERT INTO direccion (av_principal, av_secundaria, id_canton, id_pais, id_parroquia, id_provincia) VALUES ('Sangurima', 'honorato',1,1,1,1);
INSERT INTO direccion (av_principal, av_secundaria, id_canton, id_pais, id_parroquia, id_provincia) VALUES ('larga', 'benigno malo',2,1,2,2);
INSERT INTO direccion (av_principal, av_secundaria, id_canton, id_pais, id_parroquia, id_provincia) VALUES ('velez', 'matriz',3,1,3,3);
INSERT INTO direccion (av_principal, av_secundaria, id_canton, id_pais, id_parroquia, id_provincia) VALUES ('sin nombre', 'interseccion',4,1,4,4);
INSERT INTO direccion (av_principal, av_secundaria, id_canton, id_pais, id_parroquia, id_provincia) VALUES ('av torres', '3 noviembre',5,1,5,3);
INSERT INTO direccion (av_principal, av_secundaria, id_canton, id_pais, id_parroquia, id_provincia) VALUES ('calle mala', 'calle buena',6,1,5,3);
INSERT INTO direccion (av_principal, av_secundaria, id_canton, id_pais, id_parroquia, id_provincia) VALUES ('americas', 'lazo',7,1,5,4);


-------------------DIRECCION ESTUDIANTE-------------------
INSERT INTO direccion (av_principal, av_secundaria, id_canton, id_pais, id_parroquia, id_provincia) VALUES ('Honorato', 'calle vieja', 1, 1, 1, 1);
INSERT INTO direccion (av_principal, av_secundaria, id_canton, id_pais, id_parroquia, id_provincia) VALUES ('Calle Larga', 'Honorato',1,1,1,1);
INSERT INTO direccion (av_principal, av_secundaria, id_canton, id_pais, id_parroquia, id_provincia) VALUES ('Cordero', 'Gran Colombia',2,1,2,2);
INSERT INTO direccion (av_principal, av_secundaria, id_canton, id_pais, id_parroquia, id_provincia) VALUES ('Vergel', 'Matriz',3,1,3,3);
INSERT INTO direccion (av_principal, av_secundaria, id_canton, id_pais, id_parroquia, id_provincia) VALUES ('Cisneros', 'Arizaga',4,1,4,4);
INSERT INTO direccion (av_principal, av_secundaria, id_canton, id_pais, id_parroquia, id_provincia) VALUES ('Av torres', '3 noviembre',5,1,5,3);
INSERT INTO direccion (av_principal, av_secundaria, id_canton, id_pais, id_parroquia, id_provincia) VALUES ('Francisco', 'Medio Ejido',6,1,5,3);
INSERT INTO direccion (av_principal, av_secundaria, id_canton, id_pais, id_parroquia, id_provincia) VALUES ('Chola Cuencana', 'Huaynacapac',7,1,5,4);
INSERT INTO direccion (av_principal, av_secundaria, id_canton, id_pais, id_parroquia, id_provincia) VALUES ('Americas', 'Baños', 1, 1, 1, 1);
INSERT INTO direccion (av_principal, av_secundaria, id_canton, id_pais, id_parroquia, id_provincia) VALUES ('San Joaquin', 'El Tejar',1,1,1,1);
INSERT INTO direccion (av_principal, av_secundaria, id_canton, id_pais, id_parroquia, id_provincia) VALUES ('Chacon', 'Cardenas',2,1,2,2);
INSERT INTO direccion (av_principal, av_secundaria, id_canton, id_pais, id_parroquia, id_provincia) VALUES ('Machuca', 'Vargas',3,1,3,3);
INSERT INTO direccion (av_principal, av_secundaria, id_canton, id_pais, id_parroquia, id_provincia) VALUES ('Aguirre', 'Cordoba',4,1,4,4);
INSERT INTO direccion (av_principal, av_secundaria, id_canton, id_pais, id_parroquia, id_provincia) VALUES ('Guayas', 'Solano',5,1,5,3);
INSERT INTO direccion (av_principal, av_secundaria, id_canton, id_pais, id_parroquia, id_provincia) VALUES ('El Batan', 'Medio Ejido',6,1,5,3);
INSERT INTO direccion (av_principal, av_secundaria, id_canton, id_pais, id_parroquia, id_provincia) VALUES ('Totoracocha', 'Huaynacapac',7,1,5,4);

------------------- EMPRESA-------------------
INSERT INTO empresa (nombre_empresa) VALUES ('irfeyal prueba');

-------------------EXTENSION-------------------
INSERT INTO extension (nombre_extension, id_empresa,id_direccion) VALUES ('irfeyal_1', 1,1);
INSERT INTO extension (nombre_extension, id_empresa,id_direccion) VALUES ('irfeyal_Guayaquil', 1,2);
INSERT INTO extension (nombre_extension, id_empresa,id_direccion) VALUES ('irfeyal_Cañar', 1,3);
INSERT INTO extension (nombre_extension, id_empresa,id_direccion) VALUES ('irfeyal_Quito', 1,4);


-------------------TELEFONO-------------------
INSERT INTO telefono (num_celular, telefono, id_extension) VALUES ('0987562111', '0723658988',1);
INSERT INTO telefono (num_celular, telefono, id_extension) VALUES ('099999999','0723658788',1);
INSERT INTO telefono (num_celular, telefono, id_extension) VALUES ('0987971203','0723503311',1);
INSERT INTO telefono (num_celular, telefono, id_extension) VALUES ('0987654591','0723503344',1);
INSERT INTO telefono (num_celular, telefono, id_extension) VALUES ('0999454590','0745600652',1);
INSERT INTO telefono (num_celular, telefono, id_extension) VALUES ('0983434581','0735660230',1);
INSERT INTO telefono (num_celular, telefono, id_extension) VALUES ('0934561294','0734560098',1);
INSERT INTO telefono (num_celular, telefono, id_extension) VALUES ('0988876491','0723456770',1);


-------------------TELEFONO ESTUDIANTE-------------------
INSERT INTO telefono (num_celular, telefono) VALUES ('0912345111','0712358988');
INSERT INTO telefono (num_celular, telefono) VALUES ('099977799','0723612388');
INSERT INTO telefono (num_celular, telefono) VALUES ('0987221203','0723503311');
INSERT INTO telefono (num_celular, telefono) VALUES ('0933354591','0723503123');
INSERT INTO telefono (num_celular, telefono) VALUES ('0994444590','0712300652');
INSERT INTO telefono (num_celular, telefono) VALUES ('0975344581','0735123230');
INSERT INTO telefono (num_celular, telefono) VALUES ('0935931294','0734512398');
INSERT INTO telefono (num_celular, telefono) VALUES ('0966676491','0712356770');
INSERT INTO telefono (num_celular, telefono) VALUES ('0912345112','0712358981');
INSERT INTO telefono (num_celular, telefono) VALUES ('099977794','0723612383');
INSERT INTO telefono (num_celular, telefono) VALUES ('0987221206','0723503315');
INSERT INTO telefono (num_celular, telefono) VALUES ('0933354597','0723503128');
INSERT INTO telefono (num_celular, telefono) VALUES ('0994444599','0712300610');
INSERT INTO telefono (num_celular, telefono) VALUES ('0975344511','0735123212');
INSERT INTO telefono (num_celular, telefono) VALUES ('0935931213','0734512314');
INSERT INTO telefono (num_celular, telefono) VALUES ('0966676415','0712356716');


-------------------CORREO_ELECTRONICO-------------------
INSERT INTO correo_electronico (correo, id_extension) VALUES ('irfeyalmatriz@edu.ec',1);
INSERT INTO correo_electronico (correo, id_extension) VALUES ('irfeyaladmi@edu.ec',1);
INSERT INTO correo_electronico (correo, id_extension) VALUES ('irfeyalgerente@edu.ec',1);
INSERT INTO correo_electronico (correo, id_extension) VALUES ('irfeyalsecre@edu.ec',1);
INSERT INTO correo_electronico (correo, id_extension) VALUES ('irfeyalest@edu.ec',1);
INSERT INTO correo_electronico (correo, id_extension) VALUES ('irfeyalcord@edu.ec',1);
INSERT INTO correo_electronico (correo, id_extension) VALUES ('irfeyalcordad@edu.ec',1);
INSERT INTO correo_electronico (correo, id_extension) VALUES ('irfeyalrect@edu.ec',1);


-------------------CORREO_ELECTRONICO_ESTUDIANTE-------------------
INSERT INTO correo_electronico (correo) VALUES ('est1@edu.ec');
INSERT INTO correo_electronico (correo) VALUES ('est2@edu.ec');
INSERT INTO correo_electronico (correo) VALUES ('est3@edu.ec');
INSERT INTO correo_electronico (correo) VALUES ('est4@edu.ec');
INSERT INTO correo_electronico (correo) VALUES ('est5@edu.ec');
INSERT INTO correo_electronico (correo) VALUES ('est6@edu.ec');
INSERT INTO correo_electronico (correo) VALUES ('est7@edu.ec');
INSERT INTO correo_electronico (correo) VALUES ('est8@edu.ec');
INSERT INTO correo_electronico (correo) VALUES ('est9@edu.ec');
INSERT INTO correo_electronico (correo) VALUES ('est10@edu.ec');
INSERT INTO correo_electronico (correo) VALUES ('est11@edu.ec');
INSERT INTO correo_electronico (correo) VALUES ('est12@edu.ec');
INSERT INTO correo_electronico (correo) VALUES ('est13@edu.ec');
INSERT INTO correo_electronico (correo) VALUES ('est14@edu.ec');
INSERT INTO correo_electronico (correo) VALUES ('est15@edu.ec');
INSERT INTO correo_electronico (correo) VALUES ('est16@edu.ec');

-------------------EMPLEADO-------------------
INSERT INTO empleado (cargo, id_extension, id_direcion, id_telefono, id_correo, id_persona) VALUES ('contratacion_docente', 1, 1, 1, 1, 1);
INSERT INTO empleado (cargo, id_extension, id_direcion, id_telefono, id_correo, id_persona) VALUES ('contratacion_secretario 1', 1, 2,2,2,2);
INSERT INTO empleado (cargo, id_extension, id_direcion, id_telefono, id_correo, id_persona) VALUES ('contratacion_gerente', 1,3,3,3,3);
INSERT INTO empleado (cargo, id_extension, id_direcion, id_telefono, id_correo, id_persona) VALUES ('contratacion_secretaria', 1,4,1,4,4);
INSERT INTO empleado (cargo, id_extension, id_direcion, id_telefono, id_correo, id_persona) VALUES ('contratacion_coordinador administrativo', 1,5,5,5,5);
INSERT INTO empleado (cargo, id_extension, id_direcion, id_telefono, id_correo, id_persona) VALUES ('contratacion_cordinador de desarrollo', 1,6,6,6,6);
INSERT INTO empleado (cargo, id_extension, id_direcion, id_telefono, id_correo, id_persona) VALUES ('contratacion_rector', 1,7,7,7,7);
INSERT INTO empleado (cargo, id_extension, id_direcion, id_telefono, id_correo, id_persona) VALUES ('contratacion_vicerector', 1,8,8,8,8);
INSERT INTO empleado (cargo, id_extension, id_direcion, id_telefono, id_correo, id_persona) VALUES ('contratacion_docente', 1, 1, 1, 1, 9);
INSERT INTO empleado (cargo, id_extension, id_direcion, id_telefono, id_correo, id_persona) VALUES ('contratacion_secretario 1', 1, 2,2,2,10);
INSERT INTO empleado (cargo, id_extension, id_direcion, id_telefono, id_correo, id_persona) VALUES ('contratacion_gerente', 1,3,3,3,11);
INSERT INTO empleado (cargo, id_extension, id_direcion, id_telefono, id_correo, id_persona) VALUES ('contratacion_secretaria', 1,4,1,4,12);
INSERT INTO empleado (cargo, id_extension, id_direcion, id_telefono, id_correo, id_persona) VALUES ('contratacion_coordinador administrativo', 1,5,5,5,13);
INSERT INTO empleado (cargo, id_extension, id_direcion, id_telefono, id_correo, id_persona) VALUES ('contratacion_cordinador de desarrollo', 1,6,6,6,14);


-------------------USUARIO-------------------
INSERT INTO usuario (contrasenia,est_usuario,usuario,id_empleado) VALUES ('$2a$10$nau04Ps5X18uv9e/X0x1xOzXm9iV7yiGOdP57gtLalbP9YAA8g6k2',true,'0102184322',1);
INSERT INTO usuario (contrasenia,est_usuario,usuario,id_empleado) VALUES ('$2a$10$39Thszk62DPiSgdigkVNquHGuNQPPlyZpxK7GUOQIpd/DLinvL8Mq',true,'0102879991',2);
INSERT INTO usuario (contrasenia,est_usuario,usuario,id_empleado) VALUES ('$2a$10$/e8KsXdeGrGWjlrWj7unCORNcjJWrzWkq00qKFiQY5vYA5RrSxj5O',true,'0107039971',3);
INSERT INTO usuario (contrasenia,est_usuario,usuario,id_empleado) VALUES ('$2a$10$7Zqo8bxy42s8GyZ8frzQUebr6eMGo4tFUrAHeETvw7PUjd5MzT4IC',true,'0107049975',4);
INSERT INTO usuario (contrasenia,est_usuario,usuario,id_empleado) VALUES ('$2a$10$KgudhTCVpOXApMV7x/qDyOBHVXO8NqUHLviBgJ4z8FBF/09BNuBYK',true,'0103079940',5);
INSERT INTO usuario (contrasenia,est_usuario,usuario,id_empleado) VALUES ('$2a$10$oor3IUso1XvSYlSUVMp/IuOJjnQcZblV1KaGLq9j9/TCoQyz2QiCW',true,'1056789020',6);
INSERT INTO usuario (contrasenia,est_usuario,usuario,id_empleado) VALUES ('$2a$10$MlbvclpzIV74LgAoTkWTNua.KZEMKPVssf6zAHcmoQP1fRZ.qIww2',true,'1056780100',7);
INSERT INTO usuario (contrasenia,est_usuario,usuario,id_empleado) VALUES ('$2a$10$7257qhHd6F0p4hm7p8zTk.VLvMwHGVl0StBmtgRdFqdUP.3OjwLyK',true,'0100670892',8);
INSERT INTO usuario (contrasenia,est_usuario,usuario,id_empleado) VALUES ('$2a$10$nau04Ps5X18uv9e/X0x1xOzXm9iV7yiGOdP57gtLalbP9YAA8g6k2',true,'0108625478',9);
INSERT INTO usuario (contrasenia,est_usuario,usuario,id_empleado) VALUES ('$2a$10$39Thszk62DPiSgdigkVNquHGuNQPPlyZpxK7GUOQIpd/DLinvL8Mq',true,'0105983216',10);
INSERT INTO usuario (contrasenia,est_usuario,usuario,id_empleado) VALUES ('$2a$10$/e8KsXdeGrGWjlrWj7unCORNcjJWrzWkq00qKFiQY5vYA5RrSxj5O',true,'0102587436',11);
INSERT INTO usuario (contrasenia,est_usuario,usuario,id_empleado) VALUES ('$2a$10$7Zqo8bxy42s8GyZ8frzQUebr6eMGo4tFUrAHeETvw7PUjd5MzT4IC',true,'0106893251',12);
INSERT INTO usuario (contrasenia,est_usuario,usuario,id_empleado) VALUES ('$2a$10$KgudhTCVpOXApMV7x/qDyOBHVXO8NqUHLviBgJ4z8FBF/09BNuBYK',true,'0132548740',13);
INSERT INTO usuario (contrasenia,est_usuario,usuario,id_empleado) VALUES ('$2a$10$oor3IUso1XvSYlSUVMp/IuOJjnQcZblV1KaGLq9j9/TCoQyz2QiCW',true,'0105986312',14);
-- INSERT INTO usuario (contrasenia,est_usuario,usuario,id_empleado) VALUES ('123',true,'usuario_1',1);
-- INSERT INTO usuario (contrasenia,est_usuario,usuario,id_empleado) VALUES ('abc',true,'usuario_2',2);
-- INSERT INTO usuario (contrasenia,est_usuario,usuario,id_empleado) VALUES ('1abc',true,'usuario_3',3);
-- INSERT INTO usuario (contrasenia,est_usuario,usuario,id_empleado) VALUES ('abc1',true,'usuario_4',4);
-- INSERT INTO usuario (contrasenia,est_usuario,usuario,id_empleado) VALUES ('def',true,'usuario_5',5);
-- INSERT INTO usuario (contrasenia,est_usuario,usuario,id_empleado) VALUES ('123a',true,'usuario_6',6);
-- INSERT INTO usuario (contrasenia,est_usuario,usuario,id_empleado) VALUES ('1234',true,'usuario_7',7);
-- INSERT INTO usuario (contrasenia,est_usuario,usuario,id_empleado) VALUES ('1234a',true,'usuario_8',8);

-------------------ROL-------------------
INSERT INTO rol (descripcion) VALUES ('Administrador');
INSERT INTO rol (descripcion) VALUES('coordinador academico');
INSERT INTO rol (descripcion) VALUES ('secretaria');
INSERT INTO rol (descripcion) VALUES ('coordinador de desarrollo');
INSERT INTO rol (descripcion) VALUES ('coordinador administrativo');
INSERT INTO rol (descripcion) VALUES ('rectora');
INSERT INTO rol (descripcion) VALUES ('docente');

-------------------MODULO-------------------
INSERT INTO modulo (modulo,url) VALUES ('matriculas','http//localhost/modmatricula.php');
INSERT INTO modulo (modulo,url) VALUES ('asistencia','http//localhost/modasistencia.php');
INSERT INTO modulo (modulo,url) VALUES ('documentos academicos','http//localhost/moddocumentos.php');
INSERT INTO modulo (modulo,url) VALUES ('inventarios','http//localhost/modinventarios.php');
INSERT INTO modulo (modulo,url) VALUES ('pagos','http//localhost/modpagos.php');
INSERT INTO modulo (modulo,url) VALUES ('gestion de tutorias','http//localhost/modtutorias.php');
INSERT INTO modulo (modulo,url) VALUES ('secretaria','http//localhost/modsecretaria.php');

------------------ROL_USUARIO-------------------
INSERT INTO rol_usuario (estado, id_rol,id_modulo, id_usuario) VALUES (true,1,2,1);
INSERT INTO rol_usuario (estado, id_rol,id_modulo, id_usuario) VALUES (true,2,3,2);
INSERT INTO rol_usuario (estado, id_rol,id_modulo, id_usuario) VALUES (true,3,5,3);
INSERT INTO rol_usuario (estado, id_rol,id_modulo, id_usuario) VALUES (true,4,1,4);
INSERT INTO rol_usuario (estado, id_rol,id_modulo, id_usuario) VALUES (true,5,6,5);
INSERT INTO rol_usuario (estado, id_rol,id_modulo, id_usuario) VALUES (true,6,3,6);
INSERT INTO rol_usuario (estado, id_rol,id_modulo, id_usuario) VALUES (true,7,1,7);
INSERT INTO rol_usuario (estado, id_rol,id_modulo, id_usuario) VALUES (true,7,1,8);
INSERT INTO rol_usuario (estado, id_rol,id_modulo, id_usuario) VALUES (true,2,3,9);
INSERT INTO rol_usuario (estado, id_rol,id_modulo, id_usuario) VALUES (true,3,5,10);
INSERT INTO rol_usuario (estado, id_rol,id_modulo, id_usuario) VALUES (true,4,1,11);
INSERT INTO rol_usuario (estado, id_rol,id_modulo, id_usuario) VALUES (true,5,6,12);
INSERT INTO rol_usuario (estado, id_rol,id_modulo, id_usuario) VALUES (true,6,3,13);
INSERT INTO rol_usuario (estado, id_rol,id_modulo, id_usuario) VALUES (true,7,1,14);

-- PARAMETRIZACION ACADEMICA

-------------------MODALIDAD-----------------------------
INSERT INTO public.modalidad (descripcion) VALUES('Intensivo');
INSERT INTO public.modalidad (descripcion) VALUES('No Intensivo');

------------------PARALELO---------------------
INSERT INTO public.paralelo (descripcion, fecha_creacion) VALUES('A', '02/02/2022');
INSERT INTO public.paralelo (descripcion, fecha_creacion) VALUES('B', '01/01/2022');
INSERT INTO public.paralelo (descripcion, fecha_creacion) VALUES('C', '07/03/2022');

---------------------MALLA-------------------------------
INSERT INTO public.malla (descripcion, estado, fecha_creacion, id_modalidad) VALUES('Educacion Basica', true,'07/04/2022', 1);
INSERT INTO public.malla (descripcion, estado, fecha_creacion, id_modalidad) VALUES('Primaria', true,'07/04/2022', 1);
INSERT INTO public.malla (descripcion, estado, fecha_creacion, id_modalidad) VALUES('Secundaria', true,'07/04/2022', 1);
INSERT INTO public.malla (descripcion, estado, fecha_creacion, id_modalidad) VALUES('Preparatoria', true,'07/04/2022', 1);
INSERT INTO public.malla (descripcion, estado, fecha_creacion, id_modalidad) VALUES('Bachillerato', true,'07/04/2022', 2);
INSERT INTO public.malla (descripcion, estado, fecha_creacion, id_modalidad) VALUES('Basica', true,'07/04/2022', 2);
INSERT INTO public.malla (descripcion, estado, fecha_creacion, id_modalidad) VALUES('Jardin', true,'07/04/2022', 2);
INSERT INTO public.malla (descripcion, estado, fecha_creacion, id_modalidad) VALUES('Inicial', true,'07/04/2022', 2);
INSERT INTO public.malla (descripcion, estado, fecha_creacion, id_modalidad) VALUES('Unificado', true,'07/04/2022', 1);
INSERT INTO public.malla (descripcion, estado, fecha_creacion, id_modalidad) VALUES('General', true,'07/04/2022', 2);

------------------------ASIGNATURA--------------------------
INSERT INTO public.asignatura (descripcion, fecha_creacion) VALUES('MATEMÁTICAS', '07/04/2022');
INSERT INTO public.asignatura (descripcion, fecha_creacion) VALUES('INGLES', '07/04/2022');
INSERT INTO public.asignatura (descripcion, fecha_creacion) VALUES('LITERATURA', '07/04/2022');
INSERT INTO public.asignatura (descripcion, fecha_creacion) VALUES('BIOLOGÍA', '07/04/2022');
INSERT INTO public.asignatura (descripcion, fecha_creacion) VALUES('QUÍMICA', '07/04/2022');
INSERT INTO public.asignatura (descripcion, fecha_creacion) VALUES('FÍSICA', '07/04/2022');
INSERT INTO public.asignatura (descripcion, fecha_creacion) VALUES('ESTUDIOS SOCIALES', '07/04/2022');
INSERT INTO public.asignatura (descripcion, fecha_creacion) VALUES('PSICOLOGÍA', '07/04/2022');
INSERT INTO public.asignatura (descripcion, fecha_creacion) VALUES('LENGUAJE', '07/04/2022');
INSERT INTO public.asignatura (descripcion, fecha_creacion) VALUES('ELECTRÓNICA', '07/04/2022');

-------------------------------PERIODO---------------------------
INSERT INTO public.periodo (periodo_academico, costo_matricula, costo_mensualidad, fecha_fin, fecha_inicio, ano_inicio, ano_fin, vigencia, id_malla) VALUES('EDUCACION GENERAL', 30.0, 50.0, '11/11/2022', '09/01/2022','2022','2023', true, 1);
INSERT INTO public.periodo (periodo_academico, costo_matricula, costo_mensualidad, fecha_fin, fecha_inicio, ano_inicio, ano_fin, vigencia, id_malla) VALUES('EDUCACION GENERAL', 30.0, 50.0, '11/11/2022', '09/01/2022','2022','2023', true, 2);
INSERT INTO public.periodo (periodo_academico, costo_matricula, costo_mensualidad, fecha_fin, fecha_inicio, ano_inicio, ano_fin, vigencia, id_malla) VALUES('EDUCACION GENERAL UNIFICADO', 30.0, 50.0, '11/11/2022', '09/01/2022','2022','2023', false, 3);
INSERT INTO public.periodo (periodo_academico, costo_matricula, costo_mensualidad, fecha_fin, fecha_inicio, ano_inicio, ano_fin, vigencia, id_malla) VALUES('EDUCACION GENERAL UNIFICADO', 30.0, 50.0, '11/11/2022', '09/01/2022','2022','2023', true, 4);
INSERT INTO public.periodo (periodo_academico, costo_matricula, costo_mensualidad, fecha_fin, fecha_inicio, ano_inicio, ano_fin, vigencia, id_malla) VALUES('EDUCACION GENERAL UNIFICADO', 30.0, 50.0, '11/11/2022', '09/01/2022','2022','2023', false, 5);

-------------------------------CURSO---------------------------
INSERT INTO public.curso (descripcion, fecha_creacion) VALUES('Octavo', '07/04/2022');
INSERT INTO public.curso (descripcion, fecha_creacion) VALUES('Noveno', '08/04/2022');
INSERT INTO public.curso (descripcion, fecha_creacion) VALUES('Decimo', '09/04/2022');
INSERT INTO public.curso (descripcion, fecha_creacion) VALUES('Primero Bachillerato',  '10/04/2022');
INSERT INTO public.curso (descripcion, fecha_creacion) VALUES('Segundo Bachillerato', '11/04/2022');

-------------------------HORARIO-----------------------
INSERT INTO public.horario (dia, fecha_creacion, tiempo_fin, tiempo_inicio) VALUES(1, '07/04/2022', '08/09/2022 07:00:00', '07/12/2022 08:00:00');
INSERT INTO public.horario (dia, fecha_creacion, tiempo_fin, tiempo_inicio) VALUES(2, '07/04/2022', '08/09/2022 08:00:00', '07/12/2022 09:00:00');
INSERT INTO public.horario (dia, fecha_creacion, tiempo_fin, tiempo_inicio) VALUES(3, '07/04/2022', '08/09/2022 09:00:00', '07/12/2022 10:00:00');
INSERT INTO public.horario (dia, fecha_creacion, tiempo_fin, tiempo_inicio) VALUES(4, '07/04/2022', '08/09/2022 10:00:00', '07/12/2022 11:00:00');
INSERT INTO public.horario (dia, fecha_creacion, tiempo_fin, tiempo_inicio) VALUES(5, '07/04/2022', '08/09/2022 11:00:00', '07/12/2022 12:00:00');
INSERT INTO public.horario (dia, fecha_creacion, tiempo_fin, tiempo_inicio) VALUES(6, '07/04/2022', '08/09/2022 12:00:00', '07/12/2022 13:00:00');
INSERT INTO public.horario (dia, fecha_creacion, tiempo_fin, tiempo_inicio) VALUES(7, '07/04/2022', '08/09/2022 13:00:00', '07/12/2022 14:00:00');

------------------------HORARIO EMPLEADO-------------------	
INSERT INTO public.horario_empleado (id_empleado, id_horario) VALUES(1, 1);
INSERT INTO public.horario_empleado (id_empleado, id_horario) VALUES(2, 2);
INSERT INTO public.horario_empleado (id_empleado, id_horario) VALUES(3, 3);
INSERT INTO public.horario_empleado (id_empleado, id_horario) VALUES(4, 4);
INSERT INTO public.horario_empleado (id_empleado, id_horario) VALUES(5, 5);

---------------------ASIGNATURA HORARIO------------------
INSERT INTO public.asignatura_horario (id_asignatura, id_horario) VALUES(1, 1);
INSERT INTO public.asignatura_horario (id_asignatura, id_horario) VALUES(2, 2);
INSERT INTO public.asignatura_horario (id_asignatura, id_horario) VALUES(3, 3);
INSERT INTO public.asignatura_horario (id_asignatura, id_horario) VALUES(4, 4);
INSERT INTO public.asignatura_horario (id_asignatura, id_horario) VALUES(5, 5);

---------------------ASIGNATURA EMPLEADO----------------
INSERT INTO public.asignatura_empleado (id_asignatura, id_empleado) VALUES(1, 1);
INSERT INTO public.asignatura_empleado (id_asignatura, id_empleado) VALUES(2, 1);
INSERT INTO public.asignatura_empleado (id_asignatura, id_empleado) VALUES(3, 1);
INSERT INTO public.asignatura_empleado (id_asignatura, id_empleado) VALUES(4, 1);
INSERT INTO public.asignatura_empleado (id_asignatura, id_empleado) VALUES(5, 1);

---------------------AREA----------------
INSERT INTO public.area (descripcion)VALUES('MATEMATICAS');
INSERT INTO public.area (descripcion)VALUES('LENGUAJE');
INSERT INTO public.area (descripcion)VALUES('CIENCIAS NATURALES');
INSERT INTO public.area (descripcion)VALUES('ESTUDIOS SOCIALES');
INSERT INTO public.area (descripcion)VALUES('LENGUA EXTRANJERA');

---------------------AREA ASIGNATURA----------------
INSERT INTO public.area_asignatura(id_asignatura,id_area)VALUES(1, 1);
INSERT INTO public.area_asignatura(id_asignatura,id_area)VALUES(3, 2);
INSERT INTO public.area_asignatura(id_asignatura,id_area)VALUES(8, 2);
INSERT INTO public.area_asignatura(id_asignatura,id_area)VALUES(9, 2);
INSERT INTO public.area_asignatura(id_asignatura,id_area)VALUES(4, 3);
INSERT INTO public.area_asignatura(id_asignatura,id_area)VALUES(5, 3);
INSERT INTO public.area_asignatura(id_asignatura,id_area)VALUES(6, 3);
INSERT INTO public.area_asignatura(id_asignatura,id_area)VALUES(7, 4);
INSERT INTO public.area_asignatura(id_asignatura,id_area)VALUES(2, 5);

--------------------CURSO HORARIO----------------------
INSERT INTO public.curso_horario (id_curso, id_horario) VALUES(1, 1);
INSERT INTO public.curso_horario (id_curso, id_horario) VALUES(1, 2);
INSERT INTO public.curso_horario (id_curso, id_horario) VALUES(1, 3);
INSERT INTO public.curso_horario (id_curso, id_horario) VALUES(1, 4);
INSERT INTO public.curso_horario (id_curso, id_horario) VALUES(1, 5);

------------------------MALLA CURSO-----------------------
INSERT INTO public.malla_curso (id_curso, id_malla) VALUES(1, 1);
INSERT INTO public.malla_curso (id_curso, id_malla) VALUES(1, 2);
INSERT INTO public.malla_curso (id_curso, id_malla) VALUES(1, 3);
INSERT INTO public.malla_curso (id_curso, id_malla) VALUES(1, 4);
INSERT INTO public.malla_curso (id_curso, id_malla) VALUES(1, 5);

------------------MODALIDAD CURSO----------------
INSERT INTO public.modalidad_curso (id_curso, id_modalidad) VALUES(1, 1);
INSERT INTO public.modalidad_curso (id_curso, id_modalidad) VALUES(1, 2);
INSERT INTO public.modalidad_curso (id_curso, id_modalidad) VALUES(1, 1);
INSERT INTO public.modalidad_curso (id_curso, id_modalidad) VALUES(1, 2);
INSERT INTO public.modalidad_curso (id_curso, id_modalidad) VALUES(1, 1);

---------------MALLA ASIGNATURA---------------
INSERT INTO public.malla_asignatura (id_asignatura, id_malla) VALUES(1, 1);
INSERT INTO public.malla_asignatura (id_asignatura, id_malla) VALUES(2, 2);
INSERT INTO public.malla_asignatura (id_asignatura, id_malla) VALUES(3, 3);
INSERT INTO public.malla_asignatura (id_asignatura, id_malla) VALUES(4, 4);
INSERT INTO public.malla_asignatura (id_asignatura, id_malla) VALUES(5, 5);

INSERT INTO public.malla_asignatura (id_asignatura, id_malla) VALUES(6, 1);
INSERT INTO public.malla_asignatura (id_asignatura, id_malla) VALUES(7, 2);
INSERT INTO public.malla_asignatura (id_asignatura, id_malla) VALUES(8, 3);
INSERT INTO public.malla_asignatura (id_asignatura, id_malla) VALUES(9, 4);
INSERT INTO public.malla_asignatura (id_asignatura, id_malla) VALUES(10, 5);

-- Fin parametrización academica

--MATRICULA---------

INSERT INTO estudiantes (estado_estudiante, id_extension, id_persona, id_correo, id_direccion, id_telefono) VALUES (true,1,17,9,9,9);
INSERT INTO estudiantes (estado_estudiante, id_extension, id_persona, id_correo, id_direccion, id_telefono) VALUES (true,1,18,10,10,10);
INSERT INTO estudiantes (estado_estudiante, id_extension, id_persona, id_correo, id_direccion, id_telefono) VALUES (true,1,19,11,11,11);
INSERT INTO estudiantes (estado_estudiante, id_extension, id_persona, id_correo, id_direccion, id_telefono) VALUES (true,1,20,12,12,12);
INSERT INTO estudiantes (estado_estudiante, id_extension, id_persona, id_correo, id_direccion, id_telefono) VALUES (true,1,21,13,13,13);
INSERT INTO estudiantes (estado_estudiante, id_extension, id_persona, id_correo, id_direccion, id_telefono) VALUES (true,1,22,14,14,14);
INSERT INTO estudiantes (estado_estudiante, id_extension, id_persona, id_correo, id_direccion, id_telefono) VALUES (true,1,23,15,15,15);
INSERT INTO estudiantes (estado_estudiante, id_extension, id_persona, id_correo, id_direccion, id_telefono) VALUES (true,1,24,16,16,16);
INSERT INTO estudiantes (estado_estudiante, id_extension, id_persona, id_correo, id_direccion, id_telefono) VALUES (true,1,25,17,17,17);
INSERT INTO estudiantes (estado_estudiante, id_extension, id_persona, id_correo, id_direccion, id_telefono) VALUES (true,1,26,18,18,18);
INSERT INTO estudiantes (estado_estudiante, id_extension, id_persona, id_correo, id_direccion, id_telefono) VALUES (true,1,27,19,19,19);
INSERT INTO estudiantes (estado_estudiante, id_extension, id_persona, id_correo, id_direccion, id_telefono) VALUES (true,1,28,20,20,20);
INSERT INTO estudiantes (estado_estudiante, id_extension, id_persona, id_correo, id_direccion, id_telefono) VALUES (true,1,29,21,21,21);
INSERT INTO estudiantes (estado_estudiante, id_extension, id_persona, id_correo, id_direccion, id_telefono) VALUES (true,1,30,22,22,22);
INSERT INTO estudiantes (estado_estudiante, id_extension, id_persona, id_correo, id_direccion, id_telefono) VALUES (true,1,31,23,23,23);
INSERT INTO estudiantes (estado_estudiante, id_extension, id_persona, id_correo, id_direccion, id_telefono) VALUES (true,1,32,24,24,24);


INSERT INTO matriculas (fecha_matricula,id_periodo, id_curso, id_modalidad, id_usuario, id_paralelo, id_estudiante) VALUES ('2022-12-05',1,1,1,3,1,1);
INSERT INTO matriculas (fecha_matricula,id_periodo, id_curso, id_modalidad, id_usuario, id_paralelo, id_estudiante) VALUES ('2022-11-03',2,2,2,3,2,2);
INSERT INTO matriculas (fecha_matricula,id_periodo, id_curso, id_modalidad, id_usuario, id_paralelo, id_estudiante) VALUES ('2022-10-04',3,3,1,3,3,3);
INSERT INTO matriculas (fecha_matricula,id_periodo, id_curso, id_modalidad, id_usuario, id_paralelo, id_estudiante) VALUES ('2022-11-07',4,4,1,3,2,4);
INSERT INTO matriculas (fecha_matricula,id_periodo, id_curso, id_modalidad, id_usuario, id_paralelo, id_estudiante) VALUES ('2022-12-05',5,5,2,3,1,5);
INSERT INTO matriculas (fecha_matricula,id_periodo, id_curso, id_modalidad, id_usuario, id_paralelo, id_estudiante) VALUES ('2022-12-05',1,1,1,3,1,6);
INSERT INTO matriculas (fecha_matricula,id_periodo, id_curso, id_modalidad, id_usuario, id_paralelo, id_estudiante) VALUES ('2022-12-05',2,2,2,3,2,7);
INSERT INTO matriculas (fecha_matricula,id_periodo, id_curso, id_modalidad, id_usuario, id_paralelo, id_estudiante) VALUES ('2022-12-05',3,3,1,3,3,8);
INSERT INTO matriculas (fecha_matricula,id_periodo, id_curso, id_modalidad, id_usuario, id_paralelo, id_estudiante) VALUES ('2022-12-05',4,4,1,3,2,9);
INSERT INTO matriculas (fecha_matricula,id_periodo, id_curso, id_modalidad, id_usuario, id_paralelo, id_estudiante) VALUES ('2022-12-05',5,5,2,3,1,10);
INSERT INTO matriculas (fecha_matricula,id_periodo, id_curso, id_modalidad, id_usuario, id_paralelo, id_estudiante) VALUES ('2022-12-05',1,1,1,3,1,11);
INSERT INTO matriculas (fecha_matricula,id_periodo, id_curso, id_modalidad, id_usuario, id_paralelo, id_estudiante) VALUES ('2022-12-05',2,2,2,3,2,12);
INSERT INTO matriculas (fecha_matricula,id_periodo, id_curso, id_modalidad, id_usuario, id_paralelo, id_estudiante) VALUES ('2022-12-05',3,1,2,3,3,13);
INSERT INTO matriculas (fecha_matricula,id_periodo, id_curso, id_modalidad, id_usuario, id_paralelo, id_estudiante) VALUES ('2022-12-05',4,4,1,3,2,14);
INSERT INTO matriculas (fecha_matricula,id_periodo, id_curso, id_modalidad, id_usuario, id_paralelo, id_estudiante) VALUES ('2022-12-05',5,5,2,3,1,15);
INSERT INTO matriculas (fecha_matricula,id_periodo, id_curso, id_modalidad, id_usuario, id_paralelo, id_estudiante) VALUES ('2022-12-05',5,5,2,3,1,16);


--ASISTENCIA-------------

INSERT INTO clase (fec_clase, id_asignatura, id_curso, id_docente, id_paralelo, id_modalidad_id_modalidad, id_periodo_id_periodo) values ('2022/02/01',1, 1, 1, 1, 1, 1);--OJO:no puedo ingresar PERIODO xq en el modulo de parametrizacion da error en esa tabla
INSERT INTO clase (fec_clase, id_asignatura, id_curso, id_docente, id_paralelo, id_modalidad_id_modalidad, id_periodo_id_periodo) values ('2022/02/02',2, 2, 2, 2, 1, 2);
INSERT INTO clase (fec_clase, id_asignatura, id_curso, id_docente, id_paralelo, id_modalidad_id_modalidad, id_periodo_id_periodo) values ('2022/02/03',3, 3, 3, 3, 2, 3);
INSERT INTO clase (fec_clase, id_asignatura, id_curso, id_docente, id_paralelo, id_modalidad_id_modalidad, id_periodo_id_periodo) values ('2022/02/04',4, 4, 4, 1, 2, 4);
INSERT INTO clase (fec_clase, id_asignatura, id_curso, id_docente, id_paralelo, id_modalidad_id_modalidad, id_periodo_id_periodo) values ('2022/02/05',5, 5, 5, 2, 1, 5);

INSERT INTO asistencia (estado_asis,id_clase,id_estudiante) values (true, 1, 1);--OJO:Necesito la clase 
INSERT INTO asistencia (estado_asis,id_clase,id_estudiante) values (true, 2, 2);
INSERT INTO asistencia (estado_asis,id_clase,id_estudiante) values (true, 3, 3);
INSERT INTO asistencia (estado_asis,id_clase,id_estudiante) values (false, 4, 4);
INSERT INTO asistencia (estado_asis,id_clase,id_estudiante) values (false, 5, 5);

--DOCUMENTOS ACADEMICOS-----------

INSERT INTO unidad (nombre_unidad) VALUES ('Unidad 1'), ('Unidad 2'), ('Unidad 3'), ('Unidad 4'), ('Unidad 5'), ('Unidad 6'), ('Unidad 7'), ('Unidad 8'), ('Unidad 9'), ('Unidad 10');

INSERT INTO plan_unidad (titulo_unidad, objetivos, contenidos, criterios_evaluacion, destrezas, fecha_inicio, fecha_fin, observaciones, id_unidad, id_empleado, id_asignatura, id_modalidad, id_periodo, estado, id_curso) values ('Algebra', 'Objetivo1', 'Contenido1', 'Criterio1', 'Destreza1', '01-09-2022', '30-06-2023', 'Sin observaciones', 1, 8, 1, 1, 1, 'Pendiente', 1);
INSERT INTO plan_unidad (titulo_unidad, objetivos, contenidos, criterios_evaluacion, destrezas, fecha_inicio, fecha_fin, observaciones, id_unidad, id_empleado, id_asignatura, id_modalidad, id_periodo, estado, id_curso) values ('El sistema inmunológico', 'Objetivo9', 'Contenido9', 'Criterio9', 'Destreza9', '01-09-2022', '30-06-2023', 'Sin observaciones', 3, 7, 4, 1, 2, 'Pendiente', 2);
INSERT INTO plan_unidad (titulo_unidad, objetivos, contenidos, criterios_evaluacion, destrezas, fecha_inicio, fecha_fin, observaciones, id_unidad, id_empleado, id_asignatura, id_modalidad, id_periodo, estado, id_curso) values ('Celulas', 'Objetivo2', 'Contenido2', 'Criterio2', 'Destreza2', '01-09-2022', '30-06-2023', 'Sin observaciones', 3, 7, 4, 2, 1, 'Aprobado', 3);
INSERT INTO plan_unidad (titulo_unidad, objetivos, contenidos, criterios_evaluacion, destrezas, fecha_inicio, fecha_fin, observaciones, id_unidad, id_empleado, id_asignatura, id_modalidad, id_periodo, estado, id_curso) values ('Reproducción y división celular', 'Objetivo3', 'Contenido3', 'Criterio3', 'Destreza3', '01-09-2022', '30-06-2023', 'Sin observaciones', 2, 7, 4, 1, 2, 'Aprobado', 4);
INSERT INTO plan_unidad (titulo_unidad, objetivos, contenidos, criterios_evaluacion, destrezas, fecha_inicio, fecha_fin, observaciones, id_unidad, id_empleado, id_asignatura, id_modalidad, id_periodo, estado, id_curso) values ('Genética clásica', 'Objetivo4', 'Contenido4', 'Criterio4', 'Destreza4', '01-09-2022', '30-06-2023', 'Sin observaciones', 3, 7, 4, 2, 1, 'Aprobado', 2);
INSERT INTO plan_unidad (titulo_unidad, objetivos, contenidos, criterios_evaluacion, destrezas, fecha_inicio, fecha_fin, observaciones, id_unidad, id_empleado, id_asignatura, id_modalidad, id_periodo, estado, id_curso) values ('Fundamentos de biología', 'Objetivo5', 'Contenido5', 'Criterio5', 'Destreza5', '01-09-2022', '30-06-2023', 'Corregir los objetivos de la unidad', 1, 7, 4, 1, 2, 'Rechazado', 2);
INSERT INTO plan_unidad (titulo_unidad, objetivos, contenidos, criterios_evaluacion, destrezas, fecha_inicio, fecha_fin, observaciones, id_unidad, id_empleado, id_asignatura, id_modalidad, id_periodo, estado, id_curso) values ('Genética molecular', 'Objetivo6', 'Contenido6', 'Criterio6', 'Destreza6', '01-09-2022', '30-06-2023', 'Corregir la fecha de inicio de la unidad', 4, 7, 4, 1, 2, 'Rechazado', 3);
INSERT INTO plan_unidad (titulo_unidad, objetivos, contenidos, criterios_evaluacion, destrezas, fecha_inicio, fecha_fin, observaciones, id_unidad, id_empleado, id_asignatura, id_modalidad, id_periodo, estado, id_curso) values ('Biotecnología', 'Objetivo7', 'Contenido7', 'Criterio7', 'Destreza7', '01-09-2022', '30-06-2023', 'Corregir los contenidos de la unidad', 5, 7, 4, 2, 1, 'Rechazado', 5);
INSERT INTO plan_unidad (titulo_unidad, objetivos, contenidos, criterios_evaluacion, destrezas, fecha_inicio, fecha_fin, observaciones, id_unidad, id_empleado, id_asignatura, id_modalidad, id_periodo, estado, id_curso) values ('Sumas y restas', 'Objetivo3', 'Contenido3', 'Criterio3', 'Destreza3', '01-09-2022', '30-06-2023', 'Sin observaciones', 1, 8, 1, 2, 2, 'Aprobado', 4);
INSERT INTO plan_unidad (titulo_unidad, objetivos, contenidos, criterios_evaluacion, destrezas, fecha_inicio, fecha_fin, observaciones, id_unidad, id_empleado, id_asignatura, id_modalidad, id_periodo, estado, id_curso) values ('Multiplicacion y divicion', 'Objetivo3', 'Contenido3', 'Criterio3', 'Destreza3', '01-09-2022', '30-06-2023', 'Sin observaciones', 2, 8, 1, 1, 2, 'Aprobado', 4);
INSERT INTO plan_unidad (titulo_unidad, objetivos, contenidos, criterios_evaluacion, destrezas, fecha_inicio, fecha_fin, observaciones, id_unidad, id_empleado, id_asignatura, id_modalidad, id_periodo, estado, id_curso) values ('Reglas de tres', 'Objetivo3', 'Contenido3', 'Criterio3', 'Destreza3', '01-09-2022', '30-06-2023', 'Sin observaciones', 3, 8, 1, 1, 2, 'Aprobado', 4);
INSERT INTO plan_unidad (titulo_unidad, objetivos, contenidos, criterios_evaluacion, destrezas, fecha_inicio, fecha_fin, observaciones, id_unidad, id_empleado, id_asignatura, id_modalidad, id_periodo, estado, id_curso) values ('Areas y perimetros', 'Objetivo3', 'Contenido3', 'Criterio3', 'Destreza3', '01-09-2022', '30-06-2023', 'Corregir la fecha de inicio del plan de unidad', 4, 8, 1, 2, 2, 'Rechazado', 3);
INSERT INTO plan_unidad (titulo_unidad, objetivos, contenidos, criterios_evaluacion, destrezas, fecha_inicio, fecha_fin, observaciones, id_unidad, id_empleado, id_asignatura, id_modalidad, id_periodo, estado, id_curso) values ('Raices cuadrada', 'Objetivo3', 'Contenido3', 'Criterio3', 'Destreza3', '01-09-2022', '30-06-2023', 'Corregir la fecha de finalizacion del plan de unidad', 3, 8, 1, 1, 2, 'Rechazado', 5);
INSERT INTO plan_unidad (titulo_unidad, objetivos, contenidos, criterios_evaluacion, destrezas, fecha_inicio, fecha_fin, observaciones, id_unidad, id_empleado, id_asignatura, id_modalidad, id_periodo, estado, id_curso) values ('Fracciones', 'Objetivo3', 'Contenido3', 'Criterio3', 'Destreza3', '01-09-2022', '30-06-2023', 'Corregir las fecha de inicio y finalizacion de plan de unidad', 3, 8, 1, 1, 2, 'Rechazado', 2);

--SOLO KIT PARA tipo_comprobante----------
--INVENTARIOS---------- 
INSERT INTO modulo_libro (cod_modulo, nombre_modulo , curso, cantidad, numero, numero_modulo) values ('codModI2', 'Inglés 2do EGB','2do', 30, 2,'2do Tomo');--OJO:Necesito id del kit que esta con error en el insert\
INSERT INTO modulo_libro (cod_modulo, nombre_modulo , curso, cantidad, numero, numero_modulo) values ('codModLL2', 'Lengua y Literatura 2do EGB','2do', 30,2, '2do Tomo');
INSERT INTO modulo_libro (cod_modulo, nombre_modulo , curso, cantidad, numero, numero_modulo) values ('codModM2', 'Matemática 2do EGB', '2do', 30,2, '2do Tomo');
INSERT INTO modulo_libro (cod_modulo, nombre_modulo , curso, cantidad, numero, numero_modulo) values ('codModES2', 'Estudios Sociales 2do EGB', '2do', 30, 2, '2do Tomo');
INSERT INTO modulo_libro (cod_modulo, nombre_modulo , curso, cantidad, numero, numero_modulo) values ('codModCN2', 'Ciencias Naturales 2do EGB', '2do', 30,2, '2do Tomo');

INSERT INTO modulo_libro (cod_modulo, nombre_modulo , curso, cantidad, numero, numero_modulo) values ('codModI3', 'Inglés 3ero EGB','3ero', 30, 3, '3ero Tomo');--OJO:Necesito id del kit que esta con error en el insert\
INSERT INTO modulo_libro (cod_modulo, nombre_modulo , curso, cantidad, numero, numero_modulo) values ('codModLL3', 'Lengua y Literatura 3ero EGB','3ero', 30, 3, '3ero Tomo');
INSERT INTO modulo_libro (cod_modulo, nombre_modulo , curso, cantidad, numero, numero_modulo) values ('codModM3', 'Matemática 3ero EGB', '3ero', 30, 3, '3ero Tomo');
INSERT INTO modulo_libro (cod_modulo, nombre_modulo , curso, cantidad, numero, numero_modulo) values ('codModES3', 'Estudios Sociales 3ero EGB', '3ero', 30, 3, '3ero Tomo');
INSERT INTO modulo_libro (cod_modulo, nombre_modulo , curso, cantidad, numero, numero_modulo) values ('codModCN3', 'Ciencias Naturales 3ero EGB', '3ero', 30, 3, '3ero Tomo');

INSERT INTO kit(nombrekit, precio_kit, id_periodo) values ('Segundo',12, 1);
INSERT INTO kit(nombrekit, precio_kit, id_periodo) values ('Tercero',12, 1);
INSERT INTO kit(nombrekit, precio_kit, id_periodo) values ('Cuarto',12, 1);
INSERT INTO kit(nombrekit, precio_kit, id_periodo) values ('Quinto',12, 1);
INSERT INTO kit(nombrekit, precio_kit, id_periodo) values ('Sexto',12, 1);

INSERT INTO ingreso_kit (id_kit,id_modulo_libro) values (1,1);--OJO:Necesito id del kit que esta con error en el insert
INSERT INTO ingreso_kit (id_kit,id_modulo_libro) values (1,2);
INSERT INTO ingreso_kit (id_kit,id_modulo_libro) values (1,3);
INSERT INTO ingreso_kit (id_kit,id_modulo_libro) values (1,4);
INSERT INTO ingreso_kit (id_kit,id_modulo_libro) values (1,5);

INSERT INTO ingreso_kit (id_kit,id_modulo_libro) values (2,6);--OJO:Necesito id del kit que esta con error en el insert
INSERT INTO ingreso_kit (id_kit,id_modulo_libro) values (2,7);
INSERT INTO ingreso_kit (id_kit,id_modulo_libro) values (2,8);
INSERT INTO ingreso_kit (id_kit,id_modulo_libro) values (2,9);
INSERT INTO ingreso_kit (id_kit,id_modulo_libro) values (2,10);


INSERT INTO aprobacionkit (id_administrador, tipo_aproba, estado_aproba, detalle_control, fecha_aprobacion, id_estudiante, id_kit) values (6, 'Entrega kit estudiante', false, 'Se aprueba pago 50%', '2022/02/15',3,1);
INSERT INTO aprobacionkit (id_administrador, tipo_aproba, estado_aproba, detalle_control, fecha_aprobacion, id_estudiante, id_kit) values (6, 'Entrega kit estudiante', false, 'Se aprueba pago completo', '2022/02/16',4,1);


--PAGOS-----------

INSERT INTO tipo_pago (descripcion) VALUES ('Efectivo');
INSERT INTO tipo_pago (descripcion) VALUES ('Deposito');
INSERT INTO tipo_pago (descripcion) VALUES ('Cheque');

INSERT INTO tipo_comprobante (concepto_pago, id_periodo) VALUES ('Matricula', 1);--OJO:no puedo ingresar PERIODO xq en el modulo de parametrizacion da error en esa tabla
INSERT INTO tipo_comprobante (concepto_pago, id_periodo) VALUES ('Matricula', 2);
INSERT INTO tipo_comprobante (concepto_pago, id_periodo, id_kit) VALUES ('Kit', 3, 1);
INSERT INTO tipo_comprobante (concepto_pago, id_periodo, id_kit) VALUES ('Kit', 4, 1);
INSERT INTO tipo_comprobante (concepto_pago, id_periodo) VALUES ('Mensual', 5);

INSERT INTO comprobante (id_matricula, fecha, imagen, valor_total, estado, id_tipo_pago, id_tipo_comprobante, id_empleado) values (1, '2022/03/15', 'img/foto.jpg', 10 , TRUE, 1, 1, 1);--OJO:Necesito primero el tipo de comprobante, esa tabla necesita PERIODO y pilas con id_rol_usuario por id_empleado 
INSERT INTO comprobante (id_matricula, fecha, imagen, valor_total, estado, id_tipo_pago, id_tipo_comprobante, id_empleado) values (2, '2022/03/15', 'img/foto.jpg', 20 , TRUE, 1, 2, 2);
INSERT INTO comprobante (id_matricula, fecha, imagen, valor_total, estado, id_tipo_pago, id_tipo_comprobante, id_empleado) values (3, '2022/03/15', 'img/foto.jpg', 30 , TRUE, 2, 3, 3);
INSERT INTO comprobante (id_matricula, fecha, imagen, valor_total, estado, id_tipo_pago, id_tipo_comprobante, id_empleado) values (4, '2022/03/15', 'img/foto.jpg', 40 , TRUE, 2, 4, 4);
INSERT INTO comprobante (id_matricula, fecha, imagen, valor_total, estado, id_tipo_pago, id_tipo_comprobante, id_empleado) values (5, '2022/03/15', 'img/foto.jpg', 50 , TRUE, 3, 5, 5);

INSERT INTO detalle_comprobante (valor, detalle, id_comprobante) VALUES (10, 'Detalle 1', 1);--OJO:Necesito primero id_comprobante 
INSERT INTO detalle_comprobante (valor, detalle, id_comprobante) VALUES (20, 'Detalle 2', 2);
INSERT INTO detalle_comprobante (valor, detalle, id_comprobante) VALUES (30, 'Detalle 3', 3);
INSERT INTO detalle_comprobante (valor, detalle, id_comprobante) VALUES (40, 'Detalle 4', 4);
INSERT INTO detalle_comprobante (valor, detalle, id_comprobante) VALUES (50, 'Detalle 5', 5);

----GESTION DE TUTORIAS

INSERT INTO registro (aporte1, aporte2, aporte3, aporte4, evaluacion1, aporte5, aporte6, aporte7, aporte8, evaluacion2, examenfinal, promediofinal, examen_supletorio, promedio_supletorio, examen_remedial, promedio_remedial, examen_gracia, promedio_gracia, comportamiento, id_matricula, id_asignatura) VALUES (2, 6, 8, 4, 1, 10, 1, 10, 1, 10, 1, 10, 1, 10, 1, 10, 0, 1, 9, 1, 1);--OJO:Necesito id de la metricula del mod. de MATRICULA
INSERT INTO registro (aporte1, aporte2, aporte3, aporte4, evaluacion1, aporte5, aporte6, aporte7, aporte8, evaluacion2, examenfinal, promediofinal, examen_supletorio, promedio_supletorio, examen_remedial, promedio_remedial, examen_gracia, promedio_gracia, comportamiento, id_matricula, id_asignatura) VALUES (3, 7, 8, 4, 1, 10, 1, 10, 1, 10, 1, 10, 1, 10, 1, 10, 0, 1, 9, 2, 2);
INSERT INTO registro (aporte1, aporte2, aporte3, aporte4, evaluacion1, aporte5, aporte6, aporte7, aporte8, evaluacion2, examenfinal, promediofinal, examen_supletorio, promedio_supletorio, examen_remedial, promedio_remedial, examen_gracia, promedio_gracia, comportamiento, id_matricula, id_asignatura) VALUES (4, 8, 9, 6, 1, 10, 1, 10, 1, 10, 1, 10, 1, 10, 1, 10, 0, 1, 9, 3, 3);
INSERT INTO registro (aporte1, aporte2, aporte3, aporte4, evaluacion1, aporte5, aporte6, aporte7, aporte8, evaluacion2, examenfinal, promediofinal, examen_supletorio, promedio_supletorio, examen_remedial, promedio_remedial, examen_gracia, promedio_gracia, comportamiento, id_matricula, id_asignatura) VALUES (5, 6, 9, 6, 1, 10, 1, 10, 1, 10, 1, 10, 1, 10, 1, 10, 0, 1, 9, 4, 4);
INSERT INTO registro (aporte1, aporte2, aporte3, aporte4, evaluacion1, aporte5, aporte6, aporte7, aporte8, evaluacion2, examenfinal, promediofinal, examen_supletorio, promedio_supletorio, examen_remedial, promedio_remedial, examen_gracia, promedio_gracia, comportamiento, id_matricula, id_asignatura) VALUES (6, 9, 5, 8, 1, 10, 1, 10, 1, 10, 1, 10, 1, 10, 1, 10, 0, 1, 9, 5, 5);


--SECRETARIA 

INSERT INTO generar_certificado_matricula (rectora, fecha, id_empleado, id_matricula, id_direccion) VALUES ('Alicia Gualavisi Lloré', '2022/03/16', 1, 1, 1);--OJO:Necesito Id de la matricula del mod. de MATRICULA y pilas id_rol_usuario por id_empleado
INSERT INTO generar_certificado_matricula (rectora, fecha, id_empleado, id_matricula, id_direccion) VALUES ('Alicia Gualavisi Lloré', '2022/03/16', 2, 2, 2);
INSERT INTO generar_certificado_matricula (rectora, fecha, id_empleado, id_matricula, id_direccion) VALUES ('Alicia Gualavisi Lloré', '2022/03/16', 3, 3, 3);
INSERT INTO generar_certificado_matricula (rectora, fecha, id_empleado, id_matricula, id_direccion) VALUES ('Alicia Gualavisi Lloré', '2022/03/16', 4, 4, 4);
INSERT INTO generar_certificado_matricula (rectora, fecha, id_empleado, id_matricula, id_direccion) VALUES ('Alicia Gualavisi Lloré', '2022/03/16', 5, 5, 5);

INSERT INTO generar_certificado_promocion (promedio_general_num, promedio_general_let, descripcion, fecha, rectora, id_empleado, id_registro, id_curso) VALUES (70, 'Setenta', 'Aprovado', '2022/03/16', 'Alicia Gualavisi Lloré', 1,1,1);--OJO:Necesito id del registro del mod. de TUTORIAS y pilas con id_rol_usuario por id_empleado
INSERT INTO generar_certificado_promocion (promedio_general_num, promedio_general_let, descripcion, fecha, rectora, id_empleado, id_registro, id_curso) VALUES (70.3, 'Setenta punto tres', 'Aprovado', '2022/03/16', 'Alicia Gualavisi Lloré', 2,2,2);
INSERT INTO generar_certificado_promocion (promedio_general_num, promedio_general_let, descripcion, fecha, rectora, id_empleado, id_registro, id_curso) VALUES (40, 'Quarenta', 'Reprovado', '2022/03/16', 'Alicia Gualavisi Lloré', 3,3,3);
INSERT INTO generar_certificado_promocion (promedio_general_num, promedio_general_let, descripcion, fecha, rectora, id_empleado, id_registro, id_curso) VALUES (50, 'Cincuenta', 'Reprovado', '2022/03/16', 'Alicia Gualavisi Lloré', 4,4,4);
INSERT INTO generar_certificado_promocion (promedio_general_num, promedio_general_let, descripcion, fecha, rectora, id_empleado, id_registro, id_curso) VALUES (60.3, 'Sesenta punto tres', 'Aprovado', '2022/03/16', 'Alicia Gualavisi Lloré', 5,5,5);

INSERT INTO documento (tipo_documento, descripcion, ubicacion) VALUES ('Certificado Matricula 1', 'descripcion 1', 'C/documentos');
INSERT INTO documento (tipo_documento, descripcion, ubicacion) VALUES ('Certificado Matricula 2', 'descripcion 2', 'C/documentos');
INSERT INTO documento (tipo_documento, descripcion, ubicacion) VALUES ('Certificado Matricula 3', 'descripcion 3', 'C/documentos');
INSERT INTO documento (tipo_documento, descripcion, ubicacion) VALUES ('Certificado Matricula 4', 'descripcion 4', 'C/documentos');
INSERT INTO documento (tipo_documento, descripcion, ubicacion) VALUES ('Certificado Matricula 5', 'descripcion 5', 'C/documentos');

INSERT INTO registro_bitacora (solicitante, emisor, fecha, hora, estado, id_documento, id_empleado) VALUES ('Juan García', 'Pablo López', '2022/03/16', null, 'Pendiente', 1, 1); --OJO:tipo de patter de timestamp y pilas con id_rol_usuario por id_empleado 
INSERT INTO registro_bitacora (solicitante, emisor, fecha, hora, estado, id_documento, id_empleado) VALUES ('Jose García', 'Pablo López', '2022/03/17', null, 'Pendiente', 2, 2); 
INSERT INTO registro_bitacora (solicitante, emisor, fecha, hora, estado, id_documento, id_empleado) VALUES ('Carlos García', 'Pedro López', '2022/03/17', null, 'Pendiente', 3, 3); 
INSERT INTO registro_bitacora (solicitante, emisor, fecha, hora, estado, id_documento, id_empleado) VALUES ('Jonas García', 'Pedro López', '2022/03/16', null, 'Pendiente', 4, 4); 
INSERT INTO registro_bitacora (solicitante, emisor, fecha, hora, estado, id_documento, id_empleado) VALUES ('Luis García', 'Pablo López', '2022/03/16', null, 'Pendiente', 5, 5); 


--INVENTARIOS
INSERT INTO public.categoria (cate_codigo, cate_nombre) VALUES ('02', 'BICICLETA');
INSERT INTO public.categoria (cate_codigo, cate_nombre) VALUES ('01', 'AUDIO Y VIDEO');
INSERT INTO public.categoria (cate_codigo, cate_nombre) VALUES ('03',  'COCINA');
INSERT INTO public.categoria (cate_codigo, cate_nombre) VALUES ('05', 'HOGAR');
INSERT INTO public.categoria (cate_codigo, cate_nombre) VALUES ('04', 'COMPUTACION');
INSERT INTO public.categoria (cate_codigo, cate_nombre) VALUES ('07', 'HERRAMIENTA');
INSERT INTO public.categoria (cate_codigo, cate_nombre) VALUES ('06', 'LAVADO Y SECADO');
INSERT INTO public.categoria (cate_codigo, cate_nombre) VALUES ('08', 'MOTOCICLETA');
INSERT INTO public.categoria (cate_codigo, cate_nombre) VALUES ('09', 'REFRIGERACION');
INSERT INTO public.categoria (cate_codigo, cate_nombre) VALUES ('10', 'TELEFONO');
INSERT INTO public.categoria (cate_codigo, cate_nombre) VALUES ('11', 'TV');
INSERT INTO public.categoria (cate_codigo, cate_nombre) VALUES ('12', 'VEHICULOS');
INSERT INTO public.categoria (cate_codigo, cate_nombre) VALUES ('01001', 'CONTROLADORA DJ');
INSERT INTO public.categoria (cate_codigo, cate_nombre) VALUES ('01002', 'PARLANTE');
INSERT INTO public.categoria (cate_codigo, cate_nombre) VALUES ('01003', 'MICROFONO');
INSERT INTO public.categoria (cate_codigo, cate_nombre) VALUES ('02001', 'BICICLETA');
INSERT INTO public.categoria (cate_codigo, cate_nombre) VALUES ('03001', 'COCINA A GAS');
INSERT INTO public.categoria (cate_codigo, cate_nombre) VALUES ('03002', 'COCINA A INDUCCION');
INSERT INTO public.categoria (cate_codigo, cate_nombre) VALUES ('03003', 'UTENCILIO DE COCINA');
INSERT INTO public.categoria (cate_codigo, cate_nombre) VALUES ('04001', 'PC PORTATIL');
INSERT INTO public.categoria (cate_codigo, cate_nombre) VALUES ('04002', 'PC ESCRITORIO');
INSERT INTO public.categoria (cate_codigo, cate_nombre) VALUES ('04003', 'ACCESORIOS');
INSERT INTO public.categoria (cate_codigo, cate_nombre) VALUES ('04004', 'IMPRESORAS');
INSERT INTO public.categoria (cate_codigo, cate_nombre) VALUES ('05001', 'CALEFON');
INSERT INTO public.categoria (cate_codigo, cate_nombre) VALUES ('05002', 'ASPIRADORA');
INSERT INTO public.categoria (cate_codigo, cate_nombre) VALUES ('05003', 'AIRE ACONDICIONADO');
INSERT INTO public.categoria (cate_codigo, cate_nombre) VALUES ('05004', 'CILINDRO DE GAS');
INSERT INTO public.categoria (cate_codigo, cate_nombre) VALUES ('06001', 'LAVADORA');
INSERT INTO public.categoria (cate_codigo, cate_nombre) VALUES ('06002', 'SECADORA');
INSERT INTO public.categoria (cate_codigo, cate_nombre) VALUES ('06003', 'LAVADORA Y SECADORA');
INSERT INTO public.categoria (cate_codigo, cate_nombre) VALUES ('07001', 'MECANICA');
INSERT INTO public.categoria (cate_codigo, cate_nombre) VALUES ('07002', 'ELECTRICA');
INSERT INTO public.categoria (cate_codigo, cate_nombre) VALUES ('08001', 'MOTOCICLETA');
INSERT INTO public.categoria (cate_codigo, cate_nombre) VALUES ('08002', 'CUADRON');
INSERT INTO public.categoria (cate_codigo, cate_nombre) VALUES ('08003', 'MOTOCICLETA ELECTRICA');
INSERT INTO public.categoria (cate_codigo, cate_nombre) VALUES ('08004', 'MOTONETA');
INSERT INTO public.categoria (cate_codigo, cate_nombre) VALUES ('08005', 'ACCESORIOS');
INSERT INTO public.categoria (cate_codigo, cate_nombre) VALUES ('09001', 'REFRIGERADOR');
INSERT INTO public.categoria (cate_codigo, cate_nombre) VALUES ('09002', 'CONGELADOR');
INSERT INTO public.categoria (cate_codigo, cate_nombre) VALUES ('10001', 'FIJO');
INSERT INTO public.categoria (cate_codigo, cate_nombre) VALUES ('10002', 'CELULAR');
INSERT INTO public.categoria (cate_codigo, cate_nombre) VALUES ('10003', 'TABLET');
INSERT INTO public.categoria (cate_codigo, cate_nombre) VALUES ('11001', 'TV NO SMART');
INSERT INTO public.categoria (cate_codigo, cate_nombre) VALUES ('9901', 'PUBLICIDAD');
INSERT INTO public.categoria (cate_codigo, cate_nombre) VALUES ('01004', 'VIDEO');
INSERT INTO public.categoria (cate_codigo, cate_nombre) VALUES ('99', 'VARIOS');
INSERT INTO public.categoria (cate_codigo, cate_nombre) VALUES ('9999', 'VARIOS');
INSERT INTO public.categoria (cate_codigo, cate_nombre) VALUES ('11002', 'TV SMART');
INSERT INTO public.categoria (cate_codigo, cate_nombre) VALUES ('11003', 'SOPORTES');
INSERT INTO public.categoria (cate_codigo, cate_nombre) VALUES ('03005', 'CAMPANA EXTRACTOR');
INSERT INTO public.categoria (cate_codigo, cate_nombre) VALUES ('07003', 'JARDINERIA');
INSERT INTO public.categoria (cate_codigo, cate_nombre) VALUES ('07004', 'MOTOR - COMPRENSOR');
INSERT INTO public.categoria (cate_codigo, cate_nombre) VALUES ('01005', 'MINICOMPONENTE');
INSERT INTO public.categoria (cate_codigo, cate_nombre) VALUES ('05005', 'COLCHON');
INSERT INTO public.categoria (cate_codigo, cate_nombre) VALUES ('05006', 'PLANCHA');
INSERT INTO public.categoria (cate_codigo, cate_nombre) VALUES ('03006', 'OLLA');
INSERT INTO public.categoria (cate_codigo, cate_nombre) VALUES ('03007', 'LICUADORA');
INSERT INTO public.categoria (cate_codigo, cate_nombre) VALUES ('03008', 'BATIDORA');
INSERT INTO public.categoria (cate_codigo, cate_nombre) VALUES ('03009', 'HORNO');
INSERT INTO public.categoria (cate_codigo, cate_nombre) VALUES ('03010', 'FREIDORA');
INSERT INTO public.categoria (cate_codigo, cate_nombre) VALUES ('03011', 'TOSTADORA');
INSERT INTO public.categoria (cate_codigo, cate_nombre) VALUES ('05007', 'HIDROLAVADORA');
INSERT INTO public.categoria (cate_codigo, cate_nombre) VALUES ('05008', 'MUEBLES');
INSERT INTO public.categoria (cate_codigo, cate_nombre) VALUES ('05009', 'MAQUINA DE COSER');
INSERT INTO public.categoria (cate_codigo, cate_nombre) VALUES ('12001', 'LLANTAS');
INSERT INTO public.categoria (cate_codigo, cate_nombre) VALUES ('05010', 'ACCESODIOS AGUA');
INSERT INTO public.categoria (cate_codigo, cate_nombre) VALUES ('03004', 'ENCIMERA');

INSERT INTO control_articulo (fechaingreso, cantidad, observacion, id_administrador) values ('2022/02/12', 1, 'Ingreso Articulo computadora Dell AMD',6);
INSERT INTO control_articulo (fechaingreso, cantidad, observacion, id_administrador) values ('2022/02/13', 1, 'Ingreso Articulo Proyector Sony',6);
INSERT INTO control_articulo (fechaingreso, cantidad, observacion, id_administrador) values ('2022/02/14', 1, 'Ingreso Articulo Monitor 26 plg',6);
INSERT INTO control_articulo (fechaingreso, cantidad, observacion, id_administrador) values ('2022/02/15', 1, 'Ingreso Articulo Impresora EPSON L3110 WIFI',6);
INSERT INTO control_articulo (fechaingreso, cantidad, observacion, id_administrador) values ('2022/02/16', 1, 'Ingreso Articulo Proyector LG',6);

INSERT INTO articulo (artinombre, articodigo, artiprecio, artidescrip, artiestado, artimarca, id_categoria, id_control_articulo ) values ('Computadora Dell AMD', '001compu', 60, 'Computadora Dell AMD Radeon', 'Nuevo', 'Dell', 5, 1);
INSERT INTO articulo (artinombre, articodigo, artiprecio, artidescrip, artiestado, artimarca, id_categoria, id_control_articulo ) values ('Proyector Sony', '002Proy', 70, 'Proyector Sony 10.000 lumenes de brillo y su relacion de contraste dinamico', 'Nuevo', 'Sony', 5, 2);
INSERT INTO articulo (artinombre, articodigo, artiprecio, artidescrip, artiestado, artimarca, id_categoria, id_control_articulo ) values ('Monitor LG 26 plg', '003Moni', 80, 'LG es un monitor compatible con TAA ', 'Nuevo', 'LG', 5, 3);
INSERT INTO articulo (artinombre, articodigo, artiprecio, artidescrip, artiestado, artimarca, id_categoria, id_control_articulo ) values ('Impresora EPSON L3110 WIFI', '004Impre', 90, 'Sistema de tanque de tinta de altisima capacidad, facil de rellenar.', 'Nuevo', 'EPSON', 23, 4);
INSERT INTO articulo (artinombre, articodigo, artiprecio, artidescrip, artiestado, artimarca, id_categoria, id_control_articulo ) values ('Proyector LG', '005Proy', 100, '5.000 lumenes de brillo y su relacion de contraste dinamico', 'Nuevo', 'LG', 5, 5);

INSERT INTO inventario (codigo, cantidad, fechaingreso, disponibilidad, ingresado_por, id_articulo) values ('0001', 1, '2022/02/12', 2, 'Nombre usuario', 1);
INSERT INTO inventario (codigo, cantidad, fechaingreso, disponibilidad, ingresado_por, id_articulo) values ('0002', 1, '2022/02/12', 2, 'Nombre usuario', 2);
INSERT INTO inventario (codigo, cantidad, fechaingreso, disponibilidad, ingresado_por, id_articulo) values ('0003', 1, '2022/02/12', 2, 'Nombre usuario', 3);
INSERT INTO inventario (codigo, cantidad, fechaingreso, disponibilidad, ingresado_por, id_articulo) values ('0004', 1, '2022/02/12', 2, 'Nombre usuario', 4);
INSERT INTO inventario (codigo, cantidad, fechaingreso, disponibilidad, ingresado_por, id_articulo) values ('0005', 1, '2022/02/12', 2, 'Nombre usuario', 5);

INSERT INTO detalle_baja_arti (motivo, fecha_baja, id_inventario) values ('roto', '2022/02/12', 3);

INSERT INTO recepcion_articulo (fecha, codigo, detallerecep, id_control_articulo) values ('2022/02/12', '001', 'recibido', 1);
INSERT INTO recepcion_articulo (fecha, codigo, detallerecep, id_control_articulo) values ('2022/02/13', '002', 'recibido', 2);

INSERT INTO salida_articulo (fecha_salida, codigo, detallesalida, id_control_articulo) values ('2022/02/12', '001', 'salido',1);--OJO:debarticulo_id???
INSERT INTO salida_articulo (fecha_salida, codigo, detallesalida, id_control_articulo) values ('2022/02/13', '002', 'salido',2);
