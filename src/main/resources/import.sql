----------------------------------------------------
--ROLES Y SEGURIDAD
----------------------------------------------------
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
INSERT INTO modulo (modulo, url, id_rol_usuario) VALUES ('matriculas', 'http//localhost/modmatricula.php', 1);
INSERT INTO empresa (nombre_empresa) VALUES ('irfeyal prueba');
INSERT INTO extension (nombre_extension, id_empresa, id_direccion) VALUES ('irfeyal_1', 1, 1);
INSERT INTO telefono (num_celular, telefono, id_extension) VALUES ('0987562111', '0723658988', 1);
INSERT INTO correo_electronico (correo, id_extension) VALUES ('irfeyalmatriz@edu.ec', 1);
INSERT INTO empleado (cargo, id_extension, id_direcion, id_telefono, id_usuario, id_correo, id_persona) VALUES ('tutor', 1, 1, 1, 1, 1, 1);
----------------------------------------------------
-- PARAMETRIZACION ACADEMICA
----------------------------------------------------
INSERT INTO malla (estado, descripcion, fecha_creacion) VALUES (true, 'En la Unidad Educativa José María Vélaz, S. J. Extensión 105 – Cuenca la oferta educativa tiene la siguiente malla curricular, tanto para la modalidad Intensiva como para la modalidad No Intensiva. ', '2021/02/03');
--INSERT INTO periodo (actividades, fecha_activiti, fecha_creacion, fecha_inicio, fecha_fin, costo_mensualidad, costo_matricula, id_malla) VALUES ('Bachillerato General Unificado', '2021/02/03', '2022/02/03', '2021/02/03', '2022/02/03', 1, 1, 1);
INSERT INTO curso (descripcion, tipo_curso, fec_creacion, id_rol_usuario) VALUES ('8vo', 'Educación General Básica Intensiva', '2022/03/02', 1); --OJO:id_rol_usuario
--INSERT INTO malla_curso (id_curso, id_malla, fec_creacion_mallacurso) VALUES(1, 1, '2022/02/03');
INSERT INTO asignatura (descripcion, fecha_creacion) VALUES ('Matematicas', '2022/02/03');
--INSERT INTO malla_asignatura (id_asignatura, id_malla, fec_creacion_mallaasignatura) VALUES (1, 1, '2022/02/03');
INSERT INTO modalidad (descripcion, hora_inicio, hora_fin) VALUES ('Matutino', '2022-12-05 07:30:10', '2022-12-05 07:30:10');
INSERT INTO modalidad_curso (id_modalidad, id_curso) VALUES (1, 1);
INSERT INTO horario (tiempo_inicio, tiempo_fin, dia, fecha_creacion, id_asignatura) VALUES ('2022-12-05 07:30:10', '2022-12-05 07:30:10', 1, '2022/02/03', 1); --OJOS:Tipos de datos de tiempo_inicio
INSERT INTO paralelo (descripcion, fec_creacion) VALUES ('A', '2022/02/03');
INSERT INTO curso_paralelo (id_paralelo, id_curso) VALUES (1, 1);
----------------------------------------------------
--MATRICULA
----------------------------------------------------
INSERT INTO estudiantes (estado_estudiante, id_extension, id_persona, id_correo, id_direccion, id_telefono) VALUES (true, 1, 1, 1, 1, 1); --OJO:
--INSERT INTO matriculas (fecha_matricula, id_periodo, id_curso, id_modalidad, id_usuario, id_paralelo, id_estudiante) VALUES ('2022-12-05', 1, 1, 1, 1, 1, 1);--OJO:error al ingresar PERDIODO en el modulo de parametrizacion
----------------------------------------------------
--ASISTENCIA
----------------------------------------------------
--INSERT INTO clase (fec_clase, id_asignatura, id_curso, id_docente, id_paralelo, id_modalidad_id_modalidad, id_periodo_id_periodo)values
-- ('2022/02/08', 1, 1, 1, 1, 1, 1);--OJO:no puedo ingresar PERIODO xq en el modulo de parametrizacion da error en esa tabla
--INSERT INTO asistencia (estado_asis, id_clase, id_estudiante) values (true, 1, 1);
----------------------------------------------------
--DOCUMENTOS ACADEMICOS
----------------------------------------------------
INSERT INTO unidad (nombre_unidad) VALUES ('Unidad 1'), ('Unidad 2'), ('Unidad 3'), ('Unidad 4'), ('Unidad 5'), ('Unidad 6'), ('Unidad 7'), ('Unidad 8'), ('Unidad 9'), ('Unidad 10');
--INSERT INTO plan_unidad (titulo_unidad, objetivos, contenidos, criterios_evaluacion, destrezas, fecha_inicio, fecha_fin, id_unidad, id_horario, id_paralelo, id_modalidad, id_periodo, id_curso, estado) VALUES ('Lengua y Literatura', 'Objetivo2', 'Contenido2', 'Criterio2', 'Destreza2', '01-09-2022', '30-06-2023', 2, 2, 2, 2, 2, 2, 'Aprobado');--OJO:no puedo ingresar PERIODO xq en el modulo de parametrizacion da error en esa tabla
----------------------------------------------------
--INVENTARIOS
--SOLO KIT PARA tipo_comprobante
--INSERT INTO kit(precio_kit, periodo) values (35, '2021-2022');
----------------------------------------------------
--PAGOS
----------------------------------------------------
INSERT INTO tipo_pago (descripcion) VALUES ('Efectivo');
--INSERT INTO tipo_comprobante (concepto_pago, id_periodo, id_kit) VALUES (Matricula, 1, 1);--OJO:no puedo ingresar PERIODO xq en el modulo de parametrizacion da error en esa tabla
--INSERT INTO comprobante (id_id_matricula, fecha, imagen, valor_total, estado, id_tipo_pago, id_tipo_comprobante, id_rol_usuario) values
--(1, '2022/03/15', 'img/foto.jpg', 10 , TRUE, 1, 1, 1);--OJO:Necesito primero el tipo de comprobante, esa tabla necesita PERIODO
--INSERT INTO detalle_comprobante (valor, detalle, id_comprobante) VALUES (10, "detalle", 1);--OJO:Necesito primero id_comprobante
----------------------------------------------------
----GESTION DE TUTORIAS
----------------------------------------------------
--INSERT INTO registro (aporte1, aporte2, aporte3, aporte4, evaluacion1, aporte5, aporte6, aporte7, aporte8, evaluacion2, examenfinal, promediofinal, examen_supletorio, promedio_supletorio, examen_remedial, promedio_remedial, examen_gracia, promedio_gracia, comportamiento, id_matricula, id_asignatura) VALUES (2, 6, 8, 4, 1, 10, 1, 10, 1, 10, 1, 10, 1, 10, 1, 10, 0, 1, 9, 1, 1);--OJO:Necesito id de la metricula del mod. de MATRICULA
--INSERT INTO reporte (nombre_reporte, fecha_reporte, id_registro) VALUES ('NotasFinales_CulturaFisica_2021-2022', '2022-02-10', ); --OJO: Necesito id del registro
----------------------------------------------------
--SECRETARIA
----------------------------------------------------
--INSERT INTO generar_certificado_matricula (rectora, fecha, id_rol_usuario, id_matricula, id_direccion) VALUES ('Alicia Gualavisi Lloré', '2022/03/16', 1, 1, 1);--OJO:Necesito Id de la matricula del mod. de MATRICULA y pilas id_rol_usuario por id_empleado
--INSERT INTO generar_certificado_promocion (promedio_general_num, promedio_general_let, descripcion, fecha, rectora, id_rol_usuario, id_registro, id_curso) VALUES (70.3, 'Setenta punto tres', 'Aprovado', '2022/03/16', 'Alicia Gualavisi Lloré', 1, 1 }, 1);--OJO:Necesito id del registro del mod. de TUTORIAS y pilas con id_rol_usuario por id_empleado
INSERT INTO documento (tipo_documento, descripcion, ubicacion) VALUES ('Certificado Matricula', 'descripcion', 'C/documentos');
INSERT INTO registro_bitacora (solicitante, emisor, fecha, hora, estado, id_documento, id_rol_usuario) VALUES ('Juan García', 'Pablo López', '2022/03/16', null, 'Pendiente', 1, 1); --OJO:tipo de patter de timestamp y pilas con id_rol_usuario por id_empleado
----------------------------------------------------
--INVENTARIOS
----------------------------------------------------
INSERT INTO categoria (catenombre, catedescri, cateestado) values ('categoria1', 'cositas', 'ocupado');
INSERT INTO aprobacion (id_empleado, observacion_aproba, estado_aproba, detalle_control, fecha_aprobacion, fecha_control) values (1, 'obs1', true, 'detacontrol1', '2022/02/12', '2022/02/12');
INSERT INTO detal_ingre_arti (fechaingreso, cantidad, observacion, tipo_ingreso, id_aprobacion) values ('2022/02/12', 2, 'usado', 'manual', 1);
INSERT INTO articulo (artinombre, articodigo, artiprecio, artidescrip, artiestado, artimarca, id_categoria, id_det_ingre_art ) values ('articulo1', '001', 10, 'casa', 'en uso', 'nike', 1, 1);
INSERT INTO inventario (codigo, cantidad, fechaingreso, fechaegreso, disponibilidad, ingresado_por, id_articulo) values ('0001', 25, '2022/02/12', '2022/02/12', 2, 'Marco', 1);
INSERT INTO detalle_baja_arti (codigo, cantidad, motivo, fecha_baja, id_inventario) values ('0001', 25, 'viejo', '2022/02/12', 1);
--INSERT INTO modulo_libro (cod_modulo, nombre_modulo , curso, cantidad, numero, numero_modulo, id_kit) values ('ModuloUno', 'CursoUno modulUno', 1, 1, 'NumeroMod2', 1);--OJO:Necesito id del kit que esta con error en el insert 
--INSERT INTO ingreso_kit (id_empleado, id_aprobacion, fecha_ingreso, id_kit) values (1, 1, '2022/02/12', 1);--OJO:Necesito id del kit que esta con error en el insert
--INSERT INTO entrega_kit (id_aprobacion, id_kit, fecha_entrega_kit, id_estudiante) values (1, 1, '2022/02/12', 1);--OJO:Necesito id del kit que esta con error en el insert y pilas con id_estudiante por id_empleado 
INSERT INTO recepcion_articulo (fecha, codigo, detallerecep, id_det_ingre_art) values ('2022/02/12', '001', 'recibido', 1);
INSERT INTO salida_articulo (fecha_salida, codigo, detallesalida, debarticulo_id, id_aprobacion) values ('2022/02/12', '001', 'salido',1, 1);--OJO:debarticulo_id???