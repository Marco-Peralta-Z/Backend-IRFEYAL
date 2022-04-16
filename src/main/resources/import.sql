-- ROLES Y SEGURIDAD
INSERT INTO pais (pais) VALUES ('Ecuador');
INSERT INTO provincia (provincia) VALUES ('AZUAY');
INSERT INTO canton (canton) VALUES ('CUENCA');
INSERT INTO parroquia (parroquia) VALUES ('BELLAVISTA');
INSERT INTO genero (genero) VALUES ('FEMENINO');
INSERT INTO persona (apellido, cedula, fecha_nacimiento, nombre, id_genero) VALUES ('Guayllas', '0102184322', '1998-04-17 19:00:00', 'magaly', 1);
INSERT INTO direccion (av_principal, av_secundaria, id_canton, id_pais, id_parroquia, id_provincia) VALUES ('nueva calle', 'calle vieja', 1, 1, 1, 1);
INSERT INTO usuario (contrasenia, est_usuario, usuario) VALUES ('123', true, 'tutor');
INSERT INTO rol (descripcion) VALUES ('Administrador'), ('gerente'), ('secretaria'), ('estudiante'), ('coordinador de desarrollo'), ('coordinador administrativo'), ('rectora');
INSERT INTO rol_usuario (estado, id_rol, id_usuario) VALUES (true, 1, 1);
INSERT INTO modulo (modulo,url,id_rol_usuario) VALUES ('matriculas','http//localhost/modmatricula.php',1);
INSERT INTO empresa (nombre_empresa) VALUES ('irfeyal prueba');
INSERT INTO extension (nombre_extension, id_empresa,id_direccion) VALUES ('irfeyal_1', 1,1);
INSERT INTO telefono (num_celular, telefono, id_extension) VALUES ('0987562111', '0723658988',1);
INSERT INTO correo_electronico (correo, id_extension) VALUES ('irfeyalmatriz@edu.ec',1);
INSERT INTO empleado (cargo,id_extension,id_direcion,id_telefono,id_usuario,id_correo,id_persona) VALUES ('tutor', 1, 1, 1, 1, 1, 1);


-- PARAMETRIZACION ACADEMICA

-------------------MODALIDAD-----------------------------
INSERT INTO public.modalidad (descripcion, hora_fin, hora_inicio) VALUES('Nocturna', '2022-01-01 18:00:00', '2022-01-01 22:00:00');
INSERT INTO public.modalidad (descripcion, hora_fin, hora_inicio) VALUES('Matutina', '2022-01-01 07:00:00', '2022-01-01 12:00:00');
INSERT INTO public.modalidad (descripcion, hora_fin, hora_inicio) VALUES('Vespertina', '2022-01-01 13:00:00', '2022-01-01 18:00:00');

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

INSERT INTO public.periodo (actividades, costo_matricula, costo_mensualidad, fecha_actividad, fecha_creacion, fecha_fin, fecha_inicio, id_malla) VALUES('Ninguna', 30.0, 50.0, '08/8/2022', '07/04/2022', '11/11/2022', '09/01/2022', 1);
INSERT INTO public.periodo (actividades, costo_matricula, costo_mensualidad, fecha_actividad, fecha_creacion, fecha_fin, fecha_inicio, id_malla) VALUES('Ninguna', 30.0, 50.0, '08/8/2022', '07/04/2022', '11/11/2022', '09/01/2022', 2);
INSERT INTO public.periodo (actividades, costo_matricula, costo_mensualidad, fecha_actividad, fecha_creacion, fecha_fin, fecha_inicio, id_malla) VALUES('Ninguna', 30.0, 50.0, '08/8/2022', '07/04/2022', '11/11/2022', '09/01/2022', 3);
INSERT INTO public.periodo (actividades, costo_matricula, costo_mensualidad, fecha_actividad, fecha_creacion, fecha_fin, fecha_inicio, id_malla) VALUES('Ninguna', 30.0, 50.0, '08/8/2022', '07/04/2022', '11/11/2022', '09/01/2022', 4);
INSERT INTO public.periodo (actividades, costo_matricula, costo_mensualidad, fecha_actividad, fecha_creacion, fecha_fin, fecha_inicio, id_malla) VALUES('Ninguna', 30.0, 50.0, '08/8/2022', '07/04/2022', '11/11/2022', '09/01/2022', 5);


-------------------------------CURSO
INSERT INTO public.curso (descripcion, fecha_creacion, tipo_curso, id_empleado) VALUES('Octavo', '07/04/2022', 'nuevo', 1);

-------------------------HORARIO-----------------------
INSERT INTO public.horario (dia, fecha_creacion, tiempo_fin, tiempo_inicio, id_asignatura) VALUES(1, '07/04/2022', '08/09/2022 07:00:00', '07/12/2022 08:00:00', 1);
INSERT INTO public.horario (dia, fecha_creacion, tiempo_fin, tiempo_inicio, id_asignatura) VALUES(2, '07/04/2022', '08/09/2022 08:00:00', '07/12/2022 09:00:00', 2);
INSERT INTO public.horario (dia, fecha_creacion, tiempo_fin, tiempo_inicio, id_asignatura) VALUES(3, '07/04/2022', '08/09/2022 09:00:00', '07/12/2022 10:00:00', 3);
INSERT INTO public.horario (dia, fecha_creacion, tiempo_fin, tiempo_inicio, id_asignatura) VALUES(4, '07/04/2022', '08/09/2022 10:00:00', '07/12/2022 11:00:00', 9);
INSERT INTO public.horario (dia, fecha_creacion, tiempo_fin, tiempo_inicio, id_asignatura) VALUES(5, '07/04/2022', '08/09/2022 11:00:00', '07/12/2022 12:00:00', 5);
INSERT INTO public.horario (dia, fecha_creacion, tiempo_fin, tiempo_inicio, id_asignatura) VALUES(6, '07/04/2022', '08/09/2022 12:00:00', '07/12/2022 13:00:00', 6);
INSERT INTO public.horario (dia, fecha_creacion, tiempo_fin, tiempo_inicio, id_asignatura) VALUES(7, '07/04/2022', '08/09/2022 13:00:00', '07/12/2022 14:00:00', 7);

------------------------HORARIO EMPLEADO-------------------	
INSERT INTO public.horario_empleado (id_empleado, id_horario) VALUES(1, 1);

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

----------------------------------------------------
--MATRICULA
--
INSERT INTO estudiantes (estado_estudiante, id_extension,id_persona,id_correo,id_direccion,id_telefono) VALUES (true, 1,1,1,1,1);--OJO:
INSERT INTO matriculas (fecha_matricula, id_periodo,id_curso,id_modalidad,id_usuario,id_paralelo,id_estudiante) VALUES ('2022-12-05',1,1,1,1,1,1);--OJO:error al ingresar PERDIODO en el modulo de parametrizacion
--
--ASISTENCIA
--
INSERT INTO clase (fec_clase,id_asignatura,id_curso,id_docente,id_paralelo,id_modalidad_id_modalidad,id_periodo_id_periodo) values ('2022/02/08',1, 1, 1, 1,1,1);--OJO:no puedo ingresar PERIODO xq en el modulo de parametrizacion da error en esa tabla
INSERT INTO asistencia (estado_asis,id_clase,id_estudiante) values (true, 1, 1);--OJO:Necesito la clase 
--
--DOCUMENTOS ACADEMICOS
--
INSERT INTO unidad (nombre_unidad) VALUES ('Unidad 1'), ('Unidad 2'), ('Unidad 3'), ('Unidad 4'), ('Unidad 5'), ('Unidad 6'), ('Unidad 7'), ('Unidad 8'), ('Unidad 9'), ('Unidad 10');
INSERT INTO plan_unidad (titulo_unidad, objetivos, contenidos, criterios_evaluacion, destrezas, fecha_inicio, fecha_fin, id_unidad, id_horario,id_modalidad, id_periodo,estado,id_curso_paralelo) values ('Matematicas', 'Objetivo1', 'Contenido1', 'Criterio1', 'Destreza1', '01-09-2022', '30-06-2023', 1, 2, 3, 1, 'Pendiente', 1);
INSERT INTO plan_unidad (titulo_unidad, objetivos, contenidos, criterios_evaluacion, destrezas, fecha_inicio, fecha_fin, id_unidad, id_horario,id_modalidad, id_periodo,estado,id_curso_paralelo) values ('Lengua y Literatura', 'Objetivo2', 'Contenido2', 'Criterio2', 'Destreza2', '01-09-2022', '30-06-2023', 3, 4, 2, 3, 'Aprobado', 3);
INSERT INTO plan_unidad (titulo_unidad, objetivos, contenidos, criterios_evaluacion, destrezas, fecha_inicio, fecha_fin, id_unidad, id_horario,id_modalidad, id_periodo,estado,id_curso_paralelo) values ('Historia y Ciencias Sociales', 'Objetivo3', 'Contenido3', 'Criterio3', 'Destreza3', '01-09-2022', '30-06-2023', 2, 1, 3, 5, 'Aprobado', 4);
INSERT INTO plan_unidad (titulo_unidad, objetivos, contenidos, criterios_evaluacion, destrezas, fecha_inicio, fecha_fin, id_unidad, id_horario,id_modalidad, id_periodo,estado,id_curso_paralelo) values ('Ciencias', 'Objetivo4', 'Contenido4', 'Criterio4', 'Destreza4', '01-09-2022', '30-06-2023', 3, 2, 2, 1, 'Rechazado', 2);
INSERT INTO plan_unidad (titulo_unidad, objetivos, contenidos, criterios_evaluacion, destrezas, fecha_inicio, fecha_fin, id_unidad, id_horario,id_modalidad, id_periodo,estado,id_curso_paralelo) values ('Quimica', 'Objetivo5', 'Contenido5', 'Criterio5', 'Destreza5', '01-09-2022', '30-06-2023', 1, 5, 2, 4, 'Aprobado', 2);
INSERT INTO plan_unidad (titulo_unidad, objetivos, contenidos, criterios_evaluacion, destrezas, fecha_inicio, fecha_fin, id_unidad, id_horario,id_modalidad, id_periodo,estado,id_curso_paralelo) values ('Fisica', 'Objetivo6', 'Contenido6', 'Criterio6', 'Destreza6', '01-09-2022', '30-06-2023', 4, 2, 1, 4, 'Rechazado', 3);
INSERT INTO plan_unidad (titulo_unidad, objetivos, contenidos, criterios_evaluacion, destrezas, fecha_inicio, fecha_fin, id_unidad, id_horario,id_modalidad, id_periodo,estado,id_curso_paralelo) values ('Ingles', 'Objetivo7', 'Contenido7', 'Criterio7', 'Destreza7', '01-09-2022', '30-06-2023', 5, 4, 3, 1, 'Pendiente', 5);
INSERT INTO plan_unidad (titulo_unidad, objetivos, contenidos, criterios_evaluacion, destrezas, fecha_inicio, fecha_fin, id_unidad, id_horario,id_modalidad, id_periodo,estado,id_curso_paralelo) values ('Biologia', 'Objetivo8', 'Contenido8', 'Criterio8', 'Destreza8', '01-09-2022', '30-06-2023', 2, 2, 1, 5, 'Aprobado', 1);
INSERT INTO plan_unidad (titulo_unidad, objetivos, contenidos, criterios_evaluacion, destrezas, fecha_inicio, fecha_fin, id_unidad, id_horario,id_modalidad, id_periodo,estado,id_curso_paralelo) values ('Educación física', 'Objetivo9', 'Contenido9', 'Criterio9', 'Destreza9', '01-09-2022', '30-06-2023', 3, 1, 2, 4, 'Pendiente', 2);
INSERT INTO plan_unidad (titulo_unidad, objetivos, contenidos, criterios_evaluacion, destrezas, fecha_inicio, fecha_fin, id_unidad, id_horario,id_modalidad, id_periodo,estado,id_curso_paralelo) values ('Informática', 'Objetivo10', 'Contenido10', 'Criterio10', 'Destreza10', '01-09-2022', '30-06-2023', 5, 1, 2, 1, 'Rechazado', 4);
--
--INVENTARIOS 
--SOLO KIT PARA tipo_comprobante 
INSERT INTO kit(precio_kit, periodo) values (35, '2022/02/02');
--
--PAGOS
--
INSERT INTO tipo_pago (descripcion) VALUES ('Efectivo');
INSERT INTO tipo_comprobante (concepto_pago, id_periodo, id_kit) VALUES ('Matricula', 1, 1);--OJO:no puedo ingresar PERIODO xq en el modulo de parametrizacion da error en esa tabla
INSERT INTO comprobante (id_matricula, fecha, imagen, valor_total, estado, id_tipo_pago, id_tipo_comprobante, id_empleado) values (1, '2022/03/15', 'img/foto.jpg',10 , TRUE, 1, 1, 1);--OJO:Necesito primero el tipo de comprobante, esa tabla necesita PERIODO y pilas con id_rol_usuario por id_empleado 
INSERT INTO detalle_comprobante (valor,detalle, id_comprobante) VALUES (10, 'abc', 1);--OJO:Necesito primero id_comprobante 
--
----GESTION DE TUTORIAS
--
INSERT INTO registro (aporte1, aporte2, aporte3, aporte4, evaluacion1, aporte5, aporte6, aporte7, aporte8, evaluacion2, examenfinal, promediofinal, examen_supletorio, promedio_supletorio, examen_remedial, promedio_remedial, examen_gracia, promedio_gracia, comportamiento, id_matricula, id_asignatura) VALUES (2, 6, 8, 4, 1, 10, 1, 10, 1, 10, 1, 10, 1, 10, 1, 10, 0, 1, 9, 1, 1);--OJO:Necesito id de la metricula del mod. de MATRICULA
INSERT INTO reporte (nombre_reporte, fecha_reporte, id_registro) VALUES ('NotasFinales_CulturaFisica','2022/02/02', 1); --OJO: Necesito id del registro
--
--SECRETARIA 
--
INSERT INTO generar_certificado_matricula (rectora, fecha,id_empleado, id_matricula, id_direccion) VALUES ('Alicia Gualavisi Lloré', '2022/03/16', 1, 1, 1);--OJO:Necesito Id de la matricula del mod. de MATRICULA y pilas id_rol_usuario por id_empleado
INSERT INTO generar_certificado_promocion (promedio_general_num, promedio_general_let, descripcion, fecha, rectora, id_empleado, id_registro, id_curso) VALUES (70.3, 'Setenta punto tres', 'Aprovado', '2022/03/16', 'Alicia Gualavisi Lloré', 1,1,1);--OJO:Necesito id del registro del mod. de TUTORIAS y pilas con id_rol_usuario por id_empleado
INSERT INTO documento (tipo_documento, descripcion, ubicacion) VALUES ('Certificado Matricula', 'descripcion', 'C/documentos');
INSERT INTO registro_bitacora (solicitante, emisor, fecha, hora, estado, id_documento, id_empleado) VALUES ('Juan García', 'Pablo López', '2022/03/16', null, 'Pendiente', 1, 1); --OJO:tipo de patter de timestamp y pilas con id_rol_usuario por id_empleado 
--
--INVENTARIOS
--
INSERT INTO categoria (catenombre, catedescri, cateestado) values ('categoria1', 'cositas', 'ocupado');
INSERT INTO aprobacion (id_empleado, observacion_aproba, estado_aproba, detalle_control, fecha_aprobacion, fecha_control) values (1, 'obs1', true, 'detacontrol1', '2022/02/12', '2022/02/12');
INSERT INTO detal_ingre_arti (fechaingreso, cantidad, observacion, tipo_ingreso, id_aprobacion) values ('2022/02/12', 2, 'usado', 'manual', 1);
INSERT INTO articulo (artinombre, articodigo, artiprecio, artidescrip, artiestado, artimarca, id_categoria, id_det_ingre_art ) values ('articulo1', '001', 10, 'casa', 'en uso', 'nike', 1, 1);
INSERT INTO inventario (codigo, cantidad, fechaingreso, fechaegreso, disponibilidad, ingresado_por, id_articulo) values ('0001', 25, '2022/02/12', '2022/02/12', 2, 'Marco', 1);
INSERT INTO detalle_baja_arti (codigo, cantidad, motivo, fecha_baja, id_inventario) values ('0001', 25, 'viejo', '2022/02/12', 1);
INSERT INTO modulo_libro (cod_modulo, nombre_modulo , curso, cantidad, numero, numero_modulo, id_kit) values (1, 'CursoUno',' modulUno', 1, 1, 'NumeroMod2', 1);--OJO:Necesito id del kit que esta con error en el insert 
INSERT INTO ingreso_kit (id_empleado, id_aprobacion, fecha_ingreso, id_kit) values (1, 1, '2022/02/12', 1);--OJO:Necesito id del kit que esta con error en el insert
INSERT INTO entrega_kit (id_aprobacion, id_kit, fecha_entrega_kit, id_estudiante) values (1, 1, '2022/02/12', 1);--OJO:Necesito id del kit que esta con error en el insert y pilas con id_estudiante por id_empleado 
INSERT INTO recepcion_articulo (fecha, codigo, detallerecep, id_det_ingre_art) values ('2022/02/12', '001', 'recibido', 1);
INSERT INTO salida_articulo (fecha_salida, codigo, detallesalida, id_aprobacion) values ('2022/02/12', '001', 'salido',1);--OJO:debarticulo_id???
