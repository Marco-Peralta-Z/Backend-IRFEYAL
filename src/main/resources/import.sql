----------ROLES Y SEGURIDAD------------------

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
INSERT INTO persona (apellido, cedula, fecha_nacimiento, nombre, id_genero) VALUES ('Ramirez','0107039975','1995-01-01 19:00:00','Ramiro',2);
INSERT INTO persona (apellido, cedula, fecha_nacimiento, nombre, id_genero) VALUES ('Perez','0107049975','1990-04-23 19:00:00','Paulina',1);
INSERT INTO persona (apellido, cedula, fecha_nacimiento, nombre, id_genero) VALUES ('Morocho','0103079940','1992-10-17 19:00:00','Elena',1);
INSERT INTO persona (apellido, cedula, fecha_nacimiento, nombre, id_genero) VALUES ('Pesantez','1056789020','1990-11-17 19:00:00','Alberto',2);
INSERT INTO persona (apellido, cedula, fecha_nacimiento, nombre, id_genero) VALUES ('Reino','1056780100','1997-09-19 19:00:00','Rodrigo',2);
INSERT INTO persona (apellido, cedula, fecha_nacimiento, nombre, id_genero) VALUES ('Sanchez','0100670892','1993-09-30 19:00:00','Naina',1);

-------------------DIRECCION-------------------
INSERT INTO direccion (av_principal, av_secundaria, id_canton, id_pais, id_parroquia, id_provincia) VALUES ('nueva calle', 'calle vieja', 1, 1, 1, 1);
INSERT INTO direccion (av_principal, av_secundaria, id_canton, id_pais, id_parroquia, id_provincia) VALUES ('Sangurima', 'honorato',1,1,1,1);
INSERT INTO direccion (av_principal, av_secundaria, id_canton, id_pais, id_parroquia, id_provincia) VALUES ('larga', 'benigno malo',2,1,2,2);
INSERT INTO direccion (av_principal, av_secundaria, id_canton, id_pais, id_parroquia, id_provincia) VALUES ('velez', 'matriz',3,1,3,3);
INSERT INTO direccion (av_principal, av_secundaria, id_canton, id_pais, id_parroquia, id_provincia) VALUES ('sin nombre', 'interseccion',4,1,4,4);
INSERT INTO direccion (av_principal, av_secundaria, id_canton, id_pais, id_parroquia, id_provincia) VALUES ('av torres', '3 noviembre',5,1,5,3);
INSERT INTO direccion (av_principal, av_secundaria, id_canton, id_pais, id_parroquia, id_provincia) VALUES ('calle mala', 'calle buena',6,1,5,3);
INSERT INTO direccion (av_principal, av_secundaria, id_canton, id_pais, id_parroquia, id_provincia) VALUES ('americas', 'lazo',7,1,5,4);

-------------------USUARIO-------------------
INSERT INTO public.usuario (contrasenia,est_usuario,usuario) VALUES ('123',true,'usuario_1');
INSERT INTO public.usuario (contrasenia,est_usuario,usuario) VALUES ('abc',true,'usuario_2');
INSERT INTO public.usuario (contrasenia,est_usuario,usuario) VALUES ('1abc',true,'usuario_3');
INSERT INTO public.usuario (contrasenia,est_usuario,usuario) VALUES ('abc1',true,'usuario_4');
INSERT INTO public.usuario (contrasenia,est_usuario,usuario) VALUES ('def',true,'usuario_5');
INSERT INTO public.usuario (contrasenia,est_usuario,usuario) VALUES ('123a',true,'usuario_6');
INSERT INTO public.usuario (contrasenia,est_usuario,usuario) VALUES ('1234',true,'usuario_7');
INSERT INTO public.usuario (contrasenia,est_usuario,usuario) VALUES ('1234a',true,'usuario_8');

-------------------ROL-------------------
INSERT INTO rol (descripcion) VALUES ('Administrador');
INSERT INTO rol (descripcion) VALUES('gerente');
INSERT INTO rol (descripcion) VALUES ('secretaria');
INSERT INTO rol (descripcion) VALUES ('estudiante');
INSERT INTO rol (descripcion) VALUES ('coordinador de desarrollo');
INSERT INTO rol (descripcion) VALUES ('coordinador administrativo');
INSERT INTO rol (descripcion) VALUES ('rectora');

-------------------MODULO-------------------
INSERT INTO modulo (modulo,url) VALUES ('matriculas','http//localhost/modmatricula.php');
INSERT INTO modulo (modulo,url) VALUES ('asistencia','http//localhost/modasistencia.php');
INSERT INTO modulo (modulo,url) VALUES ('documentos academicos','http//localhost/moddocumentos.php');
INSERT INTO modulo (modulo,url) VALUES ('inventarios','http//localhost/modinventarios.php');
INSERT INTO modulo (modulo,url) VALUES ('pagos','http//localhost/modpagos.php');
INSERT INTO modulo (modulo,url) VALUES ('gestion de tutorias','http//localhost/modtutorias.php');
INSERT INTO modulo (modulo,url) VALUES ('secretaria','http//localhost/modsecretaria.php');

-------------------ROL_USUARIO-------------------
INSERT INTO rol_usuario (estado, id_rol,id_modulo, id_usuario) VALUES (true, 1,2,1);
INSERT INTO rol_usuario (estado, id_rol,id_modulo, id_usuario) VALUES (true,2,1,2);
INSERT INTO rol_usuario (estado, id_rol,id_modulo, id_usuario) VALUES (true,3,5,3);
INSERT INTO rol_usuario (estado, id_rol,id_modulo, id_usuario) VALUES (true,4,1,4);
INSERT INTO rol_usuario (estado, id_rol,id_modulo, id_usuario) VALUES (true,5,6,5);
INSERT INTO rol_usuario (estado, id_rol,id_modulo, id_usuario) VALUES (true,6,3,6);
INSERT INTO rol_usuario (estado, id_rol,id_modulo, id_usuario) VALUES (true,7,1,7);


------------------- EMPRESA-------------------
INSERT INTO empresa (nombre_empresa) VALUES ('irfeyal prueba');

-------------------EXTENSION-------------------
INSERT INTO extension (nombre_extension, id_empresa,id_direccion) VALUES ('irfeyal_1', 1,1);

-------------------TELEFONO-------------------
INSERT INTO telefono (num_celular, telefono, id_extension) VALUES ('0987562111', '0723658988',1);
INSERT INTO telefono (num_celular, telefono, id_extension) VALUES ('099999999','0723658788',1);
INSERT INTO telefono (num_celular, telefono, id_extension) VALUES ('0987971203','0723503311',1);
INSERT INTO telefono (num_celular, telefono, id_extension) VALUES ('0987654591','0723503344',1);
INSERT INTO telefono (num_celular, telefono, id_extension) VALUES ('0999454590','0745600652',1);
INSERT INTO telefono (num_celular, telefono, id_extension) VALUES ('0983434581','0735660230',1);
INSERT INTO telefono (num_celular, telefono, id_extension) VALUES ('0934561294','0734560098',1);
INSERT INTO telefono (num_celular, telefono, id_extension) VALUES ('0988876491','0723456770',1);

-------------------CORREO_ELECTRONICO-------------------
INSERT INTO correo_electronico (correo, id_extension) VALUES ('irfeyalmatriz@edu.ec',1);
INSERT INTO correo_electronico (correo, id_extension) VALUES ('irfeyaladmi@edu.ec',1);
INSERT INTO correo_electronico (correo, id_extension) VALUES ('irfeyalgerente@edu.ec',1);
INSERT INTO correo_electronico (correo, id_extension) VALUES ('irfeyalsecre@edu.ec',1);
INSERT INTO correo_electronico (correo, id_extension) VALUES ('irfeyalest@edu.ec',1);
INSERT INTO correo_electronico (correo, id_extension) VALUES ('irfeyalcord@edu.ec',1);
INSERT INTO correo_electronico (correo, id_extension) VALUES ('irfeyalcordad@edu.ec',1);
INSERT INTO correo_electronico (correo, id_extension) VALUES ('irfeyalrect@edu.ec',1);

-------------------EMPLEADO-------------------
INSERT INTO empleado (cargo, id_extension, id_direcion, id_telefono, id_usuario, id_correo, id_persona) VALUES ('tutor', 1, 1, 1, 1, 1, 1);
INSERT INTO empleado (cargo, id_extension, id_direcion, id_telefono, id_usuario, id_correo, id_persona) VALUES ('secretario 1', 1, 2,2,2,2,2);
INSERT INTO empleado (cargo, id_extension, id_direcion, id_telefono, id_usuario, id_correo, id_persona) VALUES ('gerente1', 1,3,3,3,3,3);
INSERT INTO empleado (cargo, id_extension, id_direcion, id_telefono, id_usuario, id_correo, id_persona) VALUES ('secre', 1,4,1,4,4,4);
INSERT INTO empleado (cargo, id_extension, id_direcion, id_telefono, id_usuario, id_correo, id_persona) VALUES ('coordinador admi', 1,5,5,5,5,5);
INSERT INTO empleado (cargo, id_extension, id_direcion, id_telefono, id_usuario, id_correo, id_persona) VALUES ('cordinador', 1,6,6,6,6,6);
INSERT INTO empleado (cargo, id_extension, id_direcion, id_telefono, id_usuario, id_correo, id_persona) VALUES ('rector', 1,7,7,7,7,7);
INSERT INTO empleado (cargo, id_extension, id_direcion, id_telefono, id_usuario, id_correo, id_persona) VALUES ('vicerector', 1,8,8,8,8,8);

-- PARAMETRIZACION ACADEMICA

-------------------MODALIDAD-----------------------------
INSERT INTO public.modalidad (descripcion, hora_fin, hora_inicio) VALUES('Matutina', '2022-01-01 07:00:00', '2022-01-01 12:00:00');
INSERT INTO public.modalidad (descripcion, hora_fin, hora_inicio) VALUES('Vespertina', '2022-01-01 13:00:00', '2022-01-01 18:00:00');
INSERT INTO public.modalidad (descripcion, hora_fin, hora_inicio) VALUES('Nocturna', '2022-01-01 18:00:00', '2022-01-01 22:00:00');
INSERT INTO public.modalidad (descripcion, hora_fin, hora_inicio) VALUES('Atardecer', '2022-01-01 18:00:00', '2022-01-01 22:00:00');
INSERT INTO public.modalidad (descripcion, hora_fin, hora_inicio) VALUES('Amanecer', '2022-01-01 18:00:00', '2022-01-01 22:00:00');

---------------------MALLA-------------------------------
INSERT INTO public.malla (descripcion, estado, fecha_creacion) VALUES('Educacion Basica', true,'07/04/2022');
INSERT INTO public.malla (descripcion, estado, fecha_creacion) VALUES('Primaria', true,'07/04/2022');
INSERT INTO public.malla (descripcion, estado, fecha_creacion) VALUES('Secundaria', true,'07/04/2022');
INSERT INTO public.malla (descripcion, estado, fecha_creacion) VALUES('Preparatoria', true,'07/04/2022');
INSERT INTO public.malla (descripcion, estado, fecha_creacion) VALUES('Bachillerato', true,'07/04/2022');
INSERT INTO public.malla (descripcion, estado, fecha_creacion) VALUES('Basica', true,'07/04/2022');
INSERT INTO public.malla (descripcion, estado, fecha_creacion) VALUES('Jardin', true,'07/04/2022');
INSERT INTO public.malla (descripcion, estado, fecha_creacion) VALUES('Inicial', true,'07/04/2022');
INSERT INTO public.malla (descripcion, estado, fecha_creacion) VALUES('Unificado', true,'07/04/2022');
INSERT INTO public.malla (descripcion, estado, fecha_creacion) VALUES('General', true,'07/04/2022');

------------------------ASIGNATURA--------------------------
INSERT INTO public.asignatura (descripcion, fecha_creacion) VALUES('Matematicas', '07/04/2022');
INSERT INTO public.asignatura (descripcion, fecha_creacion) VALUES('Ingles', '07/04/2022');
INSERT INTO public.asignatura (descripcion, fecha_creacion) VALUES('Literatura', '07/04/2022');
INSERT INTO public.asignatura (descripcion, fecha_creacion) VALUES('Biologia', '07/04/2022');
INSERT INTO public.asignatura (descripcion, fecha_creacion) VALUES('Quimica', '07/04/2022');
INSERT INTO public.asignatura (descripcion, fecha_creacion) VALUES('Fisica', '07/04/2022');
INSERT INTO public.asignatura (descripcion, fecha_creacion) VALUES('Estudios Sociales', '07/04/2022');
INSERT INTO public.asignatura (descripcion, fecha_creacion) VALUES('Psicologia', '07/04/2022');
INSERT INTO public.asignatura (descripcion, fecha_creacion) VALUES('Lenguaje', '07/04/2022');
INSERT INTO public.asignatura (descripcion, fecha_creacion) VALUES('Electronica', '07/04/2022');

-------------------------------PERIODO---------------------------
INSERT INTO public.periodo (actividades, costo_matricula, costo_mensualidad, fecha_actividad, fecha_creacion, fecha_fin, fecha_inicio, id_malla) VALUES('Ninguna 1', 30.0, 50.0, '08/8/2022', '07/04/2022', '11/11/2022', '09/01/2022', 1);
INSERT INTO public.periodo (actividades, costo_matricula, costo_mensualidad, fecha_actividad, fecha_creacion, fecha_fin, fecha_inicio, id_malla) VALUES('Ninguna 2', 30.0, 50.0, '08/8/2022', '07/04/2022', '11/11/2022', '09/01/2022', 2);
INSERT INTO public.periodo (actividades, costo_matricula, costo_mensualidad, fecha_actividad, fecha_creacion, fecha_fin, fecha_inicio, id_malla) VALUES('Ninguna 3', 30.0, 50.0, '08/8/2022', '07/04/2022', '11/11/2022', '09/01/2022', 3);
INSERT INTO public.periodo (actividades, costo_matricula, costo_mensualidad, fecha_actividad, fecha_creacion, fecha_fin, fecha_inicio, id_malla) VALUES('Ninguna 4', 30.0, 50.0, '08/8/2022', '07/04/2022', '11/11/2022', '09/01/2022', 4);
INSERT INTO public.periodo (actividades, costo_matricula, costo_mensualidad, fecha_actividad, fecha_creacion, fecha_fin, fecha_inicio, id_malla) VALUES('Ninguna 5', 30.0, 50.0, '08/8/2022', '07/04/2022', '11/11/2022', '09/01/2022', 5);

-------------------------------CURSO---------------------------
INSERT INTO public.curso (descripcion, fecha_creacion, tipo_curso, id_empleado) VALUES('Octavo', '07/04/2022', 'nuevo', 1);
INSERT INTO public.curso (descripcion, fecha_creacion, tipo_curso, id_empleado) VALUES('Noveno', '08/04/2022', 'nuevo', 1);
INSERT INTO public.curso (descripcion, fecha_creacion, tipo_curso, id_empleado) VALUES('Decimo', '09/04/2022', 'nuevo', 1);
INSERT INTO public.curso (descripcion, fecha_creacion, tipo_curso, id_empleado) VALUES('Primero Bachillerato', '10/04/2022', 'nuevo', 1);
INSERT INTO public.curso (descripcion, fecha_creacion, tipo_curso, id_empleado) VALUES('Segundo Bachillerato', '11/04/2022', 'nuevo', 1);

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
INSERT INTO public.asignatura_empleado (id_asignatura, id_empleado) VALUES(2, 2);
INSERT INTO public.asignatura_empleado (id_asignatura, id_empleado) VALUES(3, 3);
INSERT INTO public.asignatura_empleado (id_asignatura, id_empleado) VALUES(4, 4);
INSERT INTO public.asignatura_empleado (id_asignatura, id_empleado) VALUES(5, 5);

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
INSERT INTO public.modalidad_curso (id_curso, id_modalidad) VALUES(1, 3);
INSERT INTO public.modalidad_curso (id_curso, id_modalidad) VALUES(1, 2);
INSERT INTO public.modalidad_curso (id_curso, id_modalidad) VALUES(1, 1);

---------------MALLA ASIGNATURA---------------
INSERT INTO public.malla_asignatura (id_asignatura, id_malla) VALUES(1, 1);
INSERT INTO public.malla_asignatura (id_asignatura, id_malla) VALUES(2, 2);
INSERT INTO public.malla_asignatura (id_asignatura, id_malla) VALUES(3, 3);
INSERT INTO public.malla_asignatura (id_asignatura, id_malla) VALUES(4, 4);
INSERT INTO public.malla_asignatura (id_asignatura, id_malla) VALUES(5, 5);

------------------PARALELO---------------------
INSERT INTO public.paralelo (descripcion, fecha_creacion) VALUES('Quisquam ', '02/02/2022');
INSERT INTO public.paralelo (descripcion, fecha_creacion) VALUES('Consectetur', '01/01/2022');
INSERT INTO public.paralelo (descripcion, fecha_creacion) VALUES('Dolorem  ', '07/03/2022');
INSERT INTO public.paralelo (descripcion, fecha_creacion) VALUES('Eleifend ', '08/03/2022');
INSERT INTO public.paralelo (descripcion, fecha_creacion) VALUES('Vulputate ', '12/02/2022');
INSERT INTO public.paralelo (descripcion, fecha_creacion) VALUES('Sollicitudin ', '22/01/2022');
INSERT INTO public.paralelo (descripcion, fecha_creacion) VALUES('Nimperdiet', '17/03/2022');
INSERT INTO public.paralelo (descripcion, fecha_creacion) VALUES('Praesent', '15/02/2022');
INSERT INTO public.paralelo (descripcion, fecha_creacion) VALUES('Commodo', '11/01/2022');
INSERT INTO public.paralelo (descripcion, fecha_creacion) VALUES('Ultricies', '03/01/2022');

--------------------------CURSO PARALELO--------------------------
INSERT INTO public.curso_paralelo (id_curso, id_paralelo) VALUES(1, 1);
INSERT INTO public.curso_paralelo (id_curso, id_paralelo) VALUES(1, 2);
INSERT INTO public.curso_paralelo (id_curso, id_paralelo) VALUES(1, 3);
INSERT INTO public.curso_paralelo (id_curso, id_paralelo) VALUES(1, 4);
INSERT INTO public.curso_paralelo (id_curso, id_paralelo) VALUES(1, 5);

--MATRICULA---------

INSERT INTO estudiantes (estado_estudiante, id_extension, id_persona, id_correo, id_direccion, id_telefono) VALUES (true, 1,1,1,1,1);
INSERT INTO estudiantes (estado_estudiante, id_extension, id_persona, id_correo, id_direccion, id_telefono) VALUES (true, 1,2,2,2,2);
INSERT INTO estudiantes (estado_estudiante, id_extension, id_persona, id_correo, id_direccion, id_telefono) VALUES (true, 1,3,3,3,3);
INSERT INTO estudiantes (estado_estudiante, id_extension, id_persona, id_correo, id_direccion, id_telefono) VALUES (true, 1,4,4,4,4);
INSERT INTO estudiantes (estado_estudiante, id_extension, id_persona, id_correo, id_direccion, id_telefono) VALUES (true, 1,5,5,5,5);

INSERT INTO matriculas (fecha_matricula, id_periodo, id_curso, id_modalidad, id_usuario, id_paralelo, id_estudiante) VALUES ('2022-12-05',1,1,1,1,1,1);
INSERT INTO matriculas (fecha_matricula, id_periodo, id_curso, id_modalidad, id_usuario, id_paralelo, id_estudiante) VALUES ('2022-12-05',2,2,2,2,2,2);
INSERT INTO matriculas (fecha_matricula, id_periodo, id_curso, id_modalidad, id_usuario, id_paralelo, id_estudiante) VALUES ('2022-12-05',3,3,3,3,3,3);
INSERT INTO matriculas (fecha_matricula, id_periodo, id_curso, id_modalidad, id_usuario, id_paralelo, id_estudiante) VALUES ('2022-12-05',4,4,4,4,4,4);
INSERT INTO matriculas (fecha_matricula, id_periodo, id_curso, id_modalidad, id_usuario, id_paralelo, id_estudiante) VALUES ('2022-12-05',5,5,5,5,5,5);

--ASISTENCIA-------------

INSERT INTO clase (fec_clase,id_asignatura,id_curso,id_docente,id_paralelo,id_modalidad_id_modalidad,id_periodo_id_periodo) values ('2022/02/01',1, 1, 1, 1,1,1);--OJO:no puedo ingresar PERIODO xq en el modulo de parametrizacion da error en esa tabla
INSERT INTO clase (fec_clase,id_asignatura,id_curso,id_docente,id_paralelo,id_modalidad_id_modalidad,id_periodo_id_periodo) values ('2022/02/02',2, 2, 2, 2,1,2);
INSERT INTO clase (fec_clase,id_asignatura,id_curso,id_docente,id_paralelo,id_modalidad_id_modalidad,id_periodo_id_periodo) values ('2022/02/03',3, 3, 3, 3,2,3);
INSERT INTO clase (fec_clase,id_asignatura,id_curso,id_docente,id_paralelo,id_modalidad_id_modalidad,id_periodo_id_periodo) values ('2022/02/04',4, 4, 4, 4,2,4);
INSERT INTO clase (fec_clase,id_asignatura,id_curso,id_docente,id_paralelo,id_modalidad_id_modalidad,id_periodo_id_periodo) values ('2022/02/05',5, 5, 5, 5,3,5);

INSERT INTO asistencia (estado_asis,id_clase,id_estudiante) values (true, 1, 1);--OJO:Necesito la clase 
INSERT INTO asistencia (estado_asis,id_clase,id_estudiante) values (true, 2, 2);
INSERT INTO asistencia (estado_asis,id_clase,id_estudiante) values (true, 3, 3);
INSERT INTO asistencia (estado_asis,id_clase,id_estudiante) values (false, 4, 4);
INSERT INTO asistencia (estado_asis,id_clase,id_estudiante) values (false, 5, 5);

--DOCUMENTOS ACADEMICOS-----------

INSERT INTO unidad (nombre_unidad) VALUES ('Unidad 1'), ('Unidad 2'), ('Unidad 3'), ('Unidad 4'), ('Unidad 5'), ('Unidad 6'), ('Unidad 7'), ('Unidad 8'), ('Unidad 9'), ('Unidad 10');

INSERT INTO plan_unidad (titulo_unidad, objetivos, contenidos, criterios_evaluacion, destrezas, fecha_inicio, fecha_fin, id_unidad, id_asignatura, id_modalidad, id_periodo, estado, id_curso, id_paralelo) values ('Matematicas', 'Objetivo1', 'Contenido1', 'Criterio1', 'Destreza1', '01-09-2022', '30-06-2023', 1, 2, 3, 1, 'Pendiente', 1, 2);
INSERT INTO plan_unidad (titulo_unidad, objetivos, contenidos, criterios_evaluacion, destrezas, fecha_inicio, fecha_fin, id_unidad, id_asignatura, id_modalidad, id_periodo, estado, id_curso, id_paralelo) values ('Lengua y Literatura', 'Objetivo2', 'Contenido2', 'Criterio2', 'Destreza2', '01-09-2022', '30-06-2023', 3, 4, 2, 3, 'Aprobado', 3, 1);
INSERT INTO plan_unidad (titulo_unidad, objetivos, contenidos, criterios_evaluacion, destrezas, fecha_inicio, fecha_fin, id_unidad, id_asignatura, id_modalidad, id_periodo, estado, id_curso, id_paralelo) values ('Historia y Ciencias Sociales', 'Objetivo3', 'Contenido3', 'Criterio3', 'Destreza3', '01-09-2022', '30-06-2023', 2, 1, 5, 2, 'Aprobado', 4, 3);
INSERT INTO plan_unidad (titulo_unidad, objetivos, contenidos, criterios_evaluacion, destrezas, fecha_inicio, fecha_fin, id_unidad, id_asignatura, id_modalidad, id_periodo, estado, id_curso, id_paralelo) values ('Ciencias', 'Objetivo4', 'Contenido4', 'Criterio4', 'Destreza4', '01-09-2022', '30-06-2023', 3, 2, 4, 1, 'Rechazado', 2, 5);
INSERT INTO plan_unidad (titulo_unidad, objetivos, contenidos, criterios_evaluacion, destrezas, fecha_inicio, fecha_fin, id_unidad, id_asignatura, id_modalidad, id_periodo, estado, id_curso, id_paralelo) values ('Quimica', 'Objetivo5', 'Contenido5', 'Criterio5', 'Destreza5', '01-09-2022', '30-06-2023', 1, 5, 2, 4, 'Aprobado', 2, 3);
INSERT INTO plan_unidad (titulo_unidad, objetivos, contenidos, criterios_evaluacion, destrezas, fecha_inicio, fecha_fin, id_unidad, id_asignatura, id_modalidad, id_periodo, estado, id_curso, id_paralelo) values ('Fisica', 'Objetivo6', 'Contenido6', 'Criterio6', 'Destreza6', '01-09-2022', '30-06-2023', 4, 2, 1, 4, 'Rechazado', 3, 5);
INSERT INTO plan_unidad (titulo_unidad, objetivos, contenidos, criterios_evaluacion, destrezas, fecha_inicio, fecha_fin, id_unidad, id_asignatura, id_modalidad, id_periodo, estado, id_curso, id_paralelo) values ('Ingles', 'Objetivo7', 'Contenido7', 'Criterio7', 'Destreza7', '01-09-2022', '30-06-2023', 5, 4, 3, 1, 'Pendiente', 5, 1);
INSERT INTO plan_unidad (titulo_unidad, objetivos, contenidos, criterios_evaluacion, destrezas, fecha_inicio, fecha_fin, id_unidad, id_asignatura, id_modalidad, id_periodo, estado, id_curso, id_paralelo) values ('Biologia', 'Objetivo8', 'Contenido8', 'Criterio8', 'Destreza8', '01-09-2022', '30-06-2023', 2, 2, 1, 5, 'Aprobado', 1, 4);
INSERT INTO plan_unidad (titulo_unidad, objetivos, contenidos, criterios_evaluacion, destrezas, fecha_inicio, fecha_fin, id_unidad, id_asignatura, id_modalidad, id_periodo, estado, id_curso, id_paralelo) values ('Educación física', 'Objetivo9', 'Contenido9', 'Criterio9', 'Destreza9', '01-09-2022', '30-06-2023', 3, 1, 5, 4, 'Pendiente', 2, 1);
INSERT INTO plan_unidad (titulo_unidad, objetivos, contenidos, criterios_evaluacion, destrezas, fecha_inicio, fecha_fin, id_unidad, id_asignatura, id_modalidad, id_periodo, estado, id_curso, id_paralelo) values ('Informática', 'Objetivo10', 'Contenido10', 'Criterio10', 'Destreza10', '01-09-2022', '30-06-2023', 5, 1, 2, 1, 'Rechazado', 4, 3);

--INVENTARIOS----------

--SOLO KIT PARA tipo_comprobante----------
INSERT INTO kit(precio_kit, periodo) values (35, '2022/02/02');
INSERT INTO kit(precio_kit, periodo) values (15, '2022/02/02');
INSERT INTO kit(precio_kit, periodo) values (25, '2022/02/02');
INSERT INTO kit(precio_kit, periodo) values (45, '2022/02/02');
INSERT INTO kit(precio_kit, periodo) values (55, '2022/02/02');

--PAGOS-----------

INSERT INTO tipo_pago (descripcion) VALUES ('Efectivo');
INSERT INTO tipo_pago (descripcion) VALUES ('Deposito');
INSERT INTO tipo_pago (descripcion) VALUES ('Cheque');

INSERT INTO tipo_comprobante (concepto_pago, id_periodo, id_kit) VALUES ('Matricula', 1, 1);--OJO:no puedo ingresar PERIODO xq en el modulo de parametrizacion da error en esa tabla
INSERT INTO tipo_comprobante (concepto_pago, id_periodo, id_kit) VALUES ('Matricula', 2, 2);
INSERT INTO tipo_comprobante (concepto_pago, id_periodo, id_kit) VALUES ('Kit', 3, 3);
INSERT INTO tipo_comprobante (concepto_pago, id_periodo, id_kit) VALUES ('Kit', 4, 4);
INSERT INTO tipo_comprobante (concepto_pago, id_periodo, id_kit) VALUES ('Mensual', 5, 5);

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

INSERT INTO reporte (nombre_reporte, fecha_reporte, id_registro) VALUES ('NotasFinales_CulturaFisica','2022/02/02', 1); --OJO: Necesito id del registro
INSERT INTO reporte (nombre_reporte, fecha_reporte, id_registro) VALUES ('NotasFinales_Cultura','2022/02/02', 2);
INSERT INTO reporte (nombre_reporte, fecha_reporte, id_registro) VALUES ('NotasFinales_Fisica','2022/02/02', 3);
INSERT INTO reporte (nombre_reporte, fecha_reporte, id_registro) VALUES ('NotasFinales_Lengua','2022/02/02', 4);
INSERT INTO reporte (nombre_reporte, fecha_reporte, id_registro) VALUES ('NotasFinales_Matematicas','2022/02/02', 5);

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

INSERT INTO categoria (catenombre, catedescri, cateestado) values ('categoria 1', 'cositas 1', 'ocupado');
INSERT INTO categoria (catenombre, catedescri, cateestado) values ('categoria 2', 'cositas 2', 'ocupado');
INSERT INTO categoria (catenombre, catedescri, cateestado) values ('categoria 3', 'cositas 3', 'desocupado');
INSERT INTO categoria (catenombre, catedescri, cateestado) values ('categoria 4', 'cositas 4', 'ocupado');
INSERT INTO categoria (catenombre, catedescri, cateestado) values ('categoria 5', 'cositas 5', 'desocupado');

INSERT INTO aprobacion (id_empleado_admin, observacion_aproba, estado_aproba, detalle_control, fecha_aprobacion, fecha_control) values (1, 'obs 1', true, 'detacontrol 2', '2022/02/12', '2022/02/12');
INSERT INTO aprobacion (id_empleado_admin, observacion_aproba, estado_aproba, detalle_control, fecha_aprobacion, fecha_control) values (2, 'obs 2', true, 'detacontrol 3', '2022/02/13', '2022/02/13');
INSERT INTO aprobacion (id_empleado_admin, observacion_aproba, estado_aproba, detalle_control, fecha_aprobacion, fecha_control) values (3, 'obs 3', true, 'detacontrol 4', '2022/02/14', '2022/02/14');
INSERT INTO aprobacion (id_empleado_admin, observacion_aproba, estado_aproba, detalle_control, fecha_aprobacion, fecha_control) values (4, 'obs 4', true, 'detacontrol 5', '2022/02/15', '2022/02/15');
INSERT INTO aprobacion (id_empleado_admin, observacion_aproba, estado_aproba, detalle_control, fecha_aprobacion, fecha_control) values (5, 'obs 5', true, 'detacontrol 6', '2022/02/16', '2022/02/16');

INSERT INTO detal_ingre_arti (fechaingreso, cantidad, observacion, tipo_ingreso, id_aprobacion) values ('2022/02/12', 2, 'usado', 'manual', 1);
INSERT INTO detal_ingre_arti (fechaingreso, cantidad, observacion, tipo_ingreso, id_aprobacion) values ('2022/02/13', 1, 'usado', 'manual', 2);
INSERT INTO detal_ingre_arti (fechaingreso, cantidad, observacion, tipo_ingreso, id_aprobacion) values ('2022/02/14', 3, 'usado', 'manual', 3);
INSERT INTO detal_ingre_arti (fechaingreso, cantidad, observacion, tipo_ingreso, id_aprobacion) values ('2022/02/15', 1, 'usado', 'manual', 4);
INSERT INTO detal_ingre_arti (fechaingreso, cantidad, observacion, tipo_ingreso, id_aprobacion) values ('2022/02/16', 2, 'usado', 'manual', 5);

INSERT INTO articulo (artinombre, articodigo, artiprecio, artidescrip, artiestado, artimarca, id_categoria, id_det_ingre_art ) values ('articulo 1', '001', 10, 'casa', 'en uso', 'nike', 1, 1);
INSERT INTO articulo (artinombre, articodigo, artiprecio, artidescrip, artiestado, artimarca, id_categoria, id_det_ingre_art ) values ('articulo 2', '002', 100, 'pc', 'en uso', 'asus', 2, 2);
INSERT INTO articulo (artinombre, articodigo, artiprecio, artidescrip, artiestado, artimarca, id_categoria, id_det_ingre_art ) values ('articulo 3', '003', 20, 'radio', 'en uso', 'pioner', 3, 3);
INSERT INTO articulo (artinombre, articodigo, artiprecio, artidescrip, artiestado, artimarca, id_categoria, id_det_ingre_art ) values ('articulo 4', '004', 30, 'auto', 'en uso', 'toyota', 4, 4);
INSERT INTO articulo (artinombre, articodigo, artiprecio, artidescrip, artiestado, artimarca, id_categoria, id_det_ingre_art ) values ('articulo 5', '005', 50, 'oso', 'en uso', 'love', 5, 5);

INSERT INTO inventario (codigo, cantidad, fechaingreso, fechaegreso, disponibilidad, ingresado_por, id_articulo) values ('0001', 5, '2022/02/12', '2022/02/15', 2, 'Marco 1', 1);
INSERT INTO inventario (codigo, cantidad, fechaingreso, fechaegreso, disponibilidad, ingresado_por, id_articulo) values ('0002', 6, '2022/02/12', '2022/02/16', 2, 'Marco 2', 2);
INSERT INTO inventario (codigo, cantidad, fechaingreso, fechaegreso, disponibilidad, ingresado_por, id_articulo) values ('0003', 25, '2022/02/12', '2022/02/17', 2, 'Marco 3', 3);
INSERT INTO inventario (codigo, cantidad, fechaingreso, fechaegreso, disponibilidad, ingresado_por, id_articulo) values ('0004', 15, '2022/02/12', '2022/02/18', 2, 'Marco 4', 4);
INSERT INTO inventario (codigo, cantidad, fechaingreso, fechaegreso, disponibilidad, ingresado_por, id_articulo) values ('0005', 10, '2022/02/12', '2022/02/19', 2, 'Marco 5', 5);

INSERT INTO detalle_baja_arti (codigo, cantidad, motivo, fecha_baja, id_inventario) values ('0001', 25, 'viejo', '2022/02/12', 1);
INSERT INTO detalle_baja_arti (codigo, cantidad, motivo, fecha_baja, id_inventario) values ('0002', 24, 'roto', '2022/02/12', 2);
INSERT INTO detalle_baja_arti (codigo, cantidad, motivo, fecha_baja, id_inventario) values ('0003', 23, 'viejo', '2022/02/12', 3);
INSERT INTO detalle_baja_arti (codigo, cantidad, motivo, fecha_baja, id_inventario) values ('0004', 22, 'falla', '2022/02/12', 4);
INSERT INTO detalle_baja_arti (codigo, cantidad, motivo, fecha_baja, id_inventario) values ('0005', 21, 'caduco', '2022/02/12', 5);

INSERT INTO modulo_libro (cod_modulo, nombre_modulo , curso, cantidad, numero, numero_modulo, id_kit) values (1, 'CursoUno_kitUno',' modulUno_kitUno', 1, 1, 'NumeroMod2_kitUno',1);--OJO:Necesito id del kit que esta con error en el insert\
INSERT INTO modulo_libro (cod_modulo, nombre_modulo , curso, cantidad, numero, numero_modulo, id_kit) values (2, 'CursoDos_kitDos',' modulDos_kitDos', 2, 1, 'NumeroMod2_kitDos',2);
INSERT INTO modulo_libro (cod_modulo, nombre_modulo , curso, cantidad, numero, numero_modulo, id_kit) values (3, 'CursoTres_kitTres',' modulTres_kitTres', 3, 1, 'NumeroMod2_kitTres',3);
INSERT INTO modulo_libro (cod_modulo, nombre_modulo , curso, cantidad, numero, numero_modulo, id_kit) values (4, 'CursoCuatro_kitCuatro',' modulCuatro_kitCuatro', 4, 1, 'NumeroMod2_kitCuatro',4);
INSERT INTO modulo_libro (cod_modulo, nombre_modulo , curso, cantidad, numero, numero_modulo, id_kit) values (5, 'CursoCinco_kitCinco',' modulCinco_kitCinco', 5, 1, 'NumeroMod2_kitCinco',5);

INSERT INTO modulo_libro (cod_modulo, nombre_modulo , curso, cantidad, numero, numero_modulo, id_kit) values (1, 'CursoUno_kitUno',' modulUno_kitUno', 1, 1, 'NumeroMod2_kitUno',1);--OJO:Necesito id del kit que esta con error en el insert
INSERT INTO modulo_libro (cod_modulo, nombre_modulo , curso, cantidad, numero, numero_modulo, id_kit) values (2, 'CursoDos_kitDos',' modulDos_kitDos', 2, 2, 'NumeroMod2_kitDos',2);
INSERT INTO modulo_libro (cod_modulo, nombre_modulo , curso, cantidad, numero, numero_modulo, id_kit) values (3, 'CursoTres_kitTres',' modulTres_kitTres', 3, 3, 'NumeroMod2_kitTres',3);
INSERT INTO modulo_libro (cod_modulo, nombre_modulo , curso, cantidad, numero, numero_modulo, id_kit) values (4, 'CursoCuatro_kitCuatro',' modulCuatro_kitCuatro', 4, 4, 'NumeroMod2_kitCuatro',4);
INSERT INTO modulo_libro (cod_modulo, nombre_modulo , curso, cantidad, numero, numero_modulo, id_kit) values (5, 'CursoCinco_kitCinco',' modulCinco_kitCinco', 5, 5, 'NumeroMod2_kitCinco',5);

INSERT INTO modulo_libro (cod_modulo, nombre_modulo , curso, cantidad, numero, numero_modulo, id_kit) values (1, 'CursoUno_kitUno',' modulUno_kitUno', 1, 1, 'NumeroMod2_kitUno',1);--OJO:Necesito id del kit que esta con error en el insert 
INSERT INTO modulo_libro (cod_modulo, nombre_modulo , curso, cantidad, numero, numero_modulo, id_kit) values (2, 'CursoDos_kitDos',' modulUno_kitDos', 2, 2, 'NumeroMod2_kitDos',2);
INSERT INTO modulo_libro (cod_modulo, nombre_modulo , curso, cantidad, numero, numero_modulo, id_kit) values (3, 'CursoTres_kitTres',' modulUno_kitTres', 3, 3, 'NumeroMod2_kitTres',3);
INSERT INTO modulo_libro (cod_modulo, nombre_modulo , curso, cantidad, numero, numero_modulo, id_kit) values (4, 'CursoCuatro_kitCuatro',' modulUno_kitCuatro', 4, 4, 'NumeroMod2_kitCuatro',4);
INSERT INTO modulo_libro (cod_modulo, nombre_modulo , curso, cantidad, numero, numero_modulo, id_kit) values (5, 'CursoCinco_kitCinco',' modulUno_kitCincoo', 5, 5, 'NumeroMod2_kitCinco',5);

INSERT INTO ingreso_kit (id_secretaria, id_aprobacion, fecha_ingreso, id_kit) values (1, 1, '2022/02/12', 1);--OJO:Necesito id del kit que esta con error en el insert
INSERT INTO ingreso_kit (id_secretaria, id_aprobacion, fecha_ingreso, id_kit) values (2, 2, '2022/02/13', 2);
INSERT INTO ingreso_kit (id_secretaria, id_aprobacion, fecha_ingreso, id_kit) values (3, 3, '2022/02/14', 3);
INSERT INTO ingreso_kit (id_secretaria, id_aprobacion, fecha_ingreso, id_kit) values (4, 4, '2022/02/15', 4);
INSERT INTO ingreso_kit (id_secretaria, id_aprobacion, fecha_ingreso, id_kit) values (5, 5, '2022/02/16', 5);

INSERT INTO entrega_kit (id_aprobacion, id_kit, fecha_entrega_kit, id_estudiante) values (1, 1, '2022/02/12', 1);--OJO:Necesito id del kit que esta con error en el insert y pilas con id_estudiante por id_empleado 
INSERT INTO entrega_kit (id_aprobacion, id_kit, fecha_entrega_kit, id_estudiante) values (2, 2, '2022/02/13', 2);
INSERT INTO entrega_kit (id_aprobacion, id_kit, fecha_entrega_kit, id_estudiante) values (3, 3, '2022/02/14', 3);
INSERT INTO entrega_kit (id_aprobacion, id_kit, fecha_entrega_kit, id_estudiante) values (4, 4, '2022/02/15', 4);
INSERT INTO entrega_kit (id_aprobacion, id_kit, fecha_entrega_kit, id_estudiante) values (5, 5, '2022/02/16', 5);

INSERT INTO recepcion_articulo (fecha, codigo, detallerecep, id_det_ingre_art) values ('2022/02/12', '001', 'recibido', 1);
INSERT INTO recepcion_articulo (fecha, codigo, detallerecep, id_det_ingre_art) values ('2022/02/13', '002', 'recibido', 2);
INSERT INTO recepcion_articulo (fecha, codigo, detallerecep, id_det_ingre_art) values ('2022/02/14', '003', 'recibido', 3);
INSERT INTO recepcion_articulo (fecha, codigo, detallerecep, id_det_ingre_art) values ('2022/02/15', '004', 'recibido', 4);
INSERT INTO recepcion_articulo (fecha, codigo, detallerecep, id_det_ingre_art) values ('2022/02/16', '005', 'recibido', 5);

INSERT INTO salida_articulo (fecha_salida, codigo, detallesalida, id_aprobacion) values ('2022/02/12', '001', 'salido',1);--OJO:debarticulo_id???
INSERT INTO salida_articulo (fecha_salida, codigo, detallesalida, id_aprobacion) values ('2022/02/13', '002', 'salido',2);
INSERT INTO salida_articulo (fecha_salida, codigo, detallesalida, id_aprobacion) values ('2022/02/14', '003', 'salido',3);
INSERT INTO salida_articulo (fecha_salida, codigo, detallesalida, id_aprobacion) values ('2022/02/15', '004', 'salido',4);
INSERT INTO salida_articulo (fecha_salida, codigo, detallesalida, id_aprobacion) values ('2022/02/16', '005', 'salido',5);