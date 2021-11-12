/* Populate tabla clientes */

INSERT INTO regiones (id, nombre) VALUES (1, 'Sudamérica');
INSERT INTO regiones (id, nombre) VALUES (2, 'Centroamérica');
INSERT INTO regiones (id, nombre) VALUES (3, 'Norteamérica');
INSERT INTO regiones (id, nombre) VALUES (4, 'Europa');
INSERT INTO regiones (id, nombre) VALUES (5, 'Asia');
INSERT INTO regiones (id, nombre) VALUES (6, 'Africa');
INSERT INTO regiones (id, nombre) VALUES (7, 'Oceanía');
INSERT INTO regiones (id, nombre) VALUES (8, 'Antártida');

INSERT INTO clientes (region_id, nombre, apellido, email, numdoc , tipodoc, create_at,edad) VALUES(1, 'Alonso', 'Guzman', 'alonso@bolsadeideas.com','44887891','1', '2018-01-01',32);
INSERT INTO clientes (region_id, nombre, apellido, email, numdoc , tipodoc, create_at,edad) VALUES(1, 'Janier', 'Valdivia Carrillo', 'janovaldivia@gmail.com','44887892','1', '2018-01-01',45);
INSERT INTO clientes (region_id, nombre, apellido, email, numdoc , tipodoc, create_at,edad) VALUES(1, 'Alan', 'Cairampoma Carrillo', 'alancairampoma@gmail.com','44887893','1', '2018-01-01',32);
INSERT INTO clientes (region_id, nombre, apellido, email, numdoc , tipodoc, create_at,edad) VALUES(1, 'Matias','Cairampoma Serin', 'fserin@gmail.com','44887895','1', '2018-01-01',33);
INSERT INTO clientes (region_id, nombre, apellido, email, numdoc , tipodoc, create_at,edad) VALUES(1, 'Yur Adan', 'Valdez', 'yvaldez@gmail.com','44887894','1', '2018-01-01',33);

/* Creamos algunos usuarios con sus roles */
INSERT INTO adm_usuarios (username, password, enabled, nombre, apellido, email, medico) VALUES ('andres','$2a$10$C3Uln5uqnzx/GswADURJGOIdBqYrly9731fnwKDaUdBkt/M3qvtLq',true, 'Andres', 'Guzman','profesor@bolsadeideas.com', '032592');
INSERT INTO adm_usuarios (username, password, enabled, nombre, apellido, email, medico) VALUES ('admin','$2a$10$RmdEsvEfhI7Rcm9f/uZXPebZVCcPC7ZXZwV51efAvMAp1rIaRAfPK',true, 'John', 'Doe','jhon.doe@bolsadeideas.com', '032593');
INSERT INTO adm_usuarios (username, password, enabled, nombre, apellido, email, medico) VALUES ('alan','$2a$10$RmdEsvEfhI7Rcm9f/uZXPebZVCcPC7ZXZwV51efAvMAp1rIaRAfPK',true, 'Alan', 'Cairampoma','alancairampoma@gmail.com', '032594');
INSERT INTO adm_usuarios (username, password, enabled, nombre, apellido, email, medico) VALUES ('gziegler','$2a$10$RmdEsvEfhI7Rcm9f/uZXPebZVCcPC7ZXZwV51efAvMAp1rIaRAfPK',true, 'Gonzalo', 'Ziegler','gziegler@gmail.com', '032591');

INSERT INTO adm_roles (nombre) VALUES ('ROLE_USER');
INSERT INTO adm_roles (nombre) VALUES ('ROLE_ADMIN');

INSERT INTO adm_usuarios_roles (usuario_id, role_id) VALUES (1, 1);
INSERT INTO adm_usuarios_roles (usuario_id, role_id) VALUES (2, 2);
INSERT INTO adm_usuarios_roles (usuario_id, role_id) VALUES (2, 1);
INSERT INTO adm_usuarios_roles (usuario_id, role_id) VALUES (3, 1);
INSERT INTO adm_usuarios_roles (usuario_id, role_id) VALUES (3, 2);
INSERT INTO adm_usuarios_roles (usuario_id, role_id) VALUES (4, 1);
INSERT INTO adm_usuarios_roles (usuario_id, role_id) VALUES (4, 2);

/* Creamos algunos examenes*/
INSERT INTO cli_examenes_mae(nombre,tipo_servicio,cod_dpto,estado,fec_registro,user_registro) VALUES('ECOGRAFIA ESTOMAGO','1','001','1',NOW(),'ADMIN');
INSERT INTO cli_examenes_mae(nombre,tipo_servicio,cod_dpto,estado,fec_registro,user_registro) VALUES('ECOGRAFIA MAMA','1','001','1',NOW(),'ADMIN');
INSERT INTO cli_examenes_mae(nombre,tipo_servicio,cod_dpto,estado,fec_registro,user_registro) VALUES('ECOGRAFIA ESOFAGO','1','001','1',NOW(),'ADMIN');
INSERT INTO cli_examenes_mae(nombre,tipo_servicio,cod_dpto,estado,fec_registro,user_registro) VALUES('ECOGRAFIA BRAZOS','1','001','1',NOW(),'ADMIN');
INSERT INTO cli_examenes_mae(nombre,tipo_servicio,cod_dpto,estado,fec_registro,user_registro) VALUES('ECOGRAFIA PIERNAS','1','001','1',NOW(),'ADMIN');
INSERT INTO cli_examenes_mae(nombre,tipo_servicio,cod_dpto,estado,fec_registro,user_registro) VALUES('ECOGRAFIA UTERO','1','001','1',NOW(),'ADMIN');

/* Creamos algunos medicamentos*/
INSERT INTO cli_medicina_mae(nombre,estado,tipo_medicina,fec_registro,user_registro) VALUES('OMEPRAZOL','1','2',NOW(),'ADMIN');
INSERT INTO cli_medicina_mae(nombre,estado,tipo_medicina,fec_registro,user_registro) VALUES('RANITIDINA','1','2',NOW(),'ADMIN');
INSERT INTO cli_medicina_mae(nombre,estado,tipo_medicina,fec_registro,user_registro) VALUES('PARACETAMOL','1','2',NOW(),'ADMIN');
INSERT INTO cli_medicina_mae(nombre,estado,tipo_medicina,fec_registro,user_registro) VALUES('IBUPROFENO','1','2',NOW(),'ADMIN');
INSERT INTO cli_medicina_mae(nombre,estado,tipo_medicina,fec_registro,user_registro) VALUES('GARBAPASEPINA','1','2',NOW(),'ADMIN');
INSERT INTO cli_medicina_mae(nombre,estado,tipo_medicina,fec_registro,user_registro) VALUES('CETERISINA','1','2',NOW(),'ADMIN');

/* Creamos algunos medicos*/
INSERT INTO adm_catalogos_mae(nom_tabla,id_elemento,nom_elemento,cod_medico,cod_especialidad,estado, id_user, fec_registro,user_registro)VALUES('ADM_MEDICO_MAE',1,'GONZALO ZIEGLER GUTIERREZ','032591','MASTOLOGIA','1',1,NOW(),'ADMIN');
INSERT INTO adm_catalogos_mae(nom_tabla,id_elemento,nom_elemento,cod_medico,cod_especialidad,estado, id_user, fec_registro,user_registro)VALUES('ADM_MEDICO_MAE',2,'GUSTAVO SARRIA BARDARLES','032593','RADIOTERAPIA','1',2,NOW(),'ADMIN');
INSERT INTO adm_catalogos_mae(nom_tabla,id_elemento,nom_elemento,cod_medico,cod_especialidad,estado, id_user, fec_registro,user_registro)VALUES('ADM_MEDICO_MAE',3,'FERNADO TORRES VEGA','032594','CABEZA Y CUELLO','1',3,NOW(),'ADMIN');

/* Creamos algunos diagnostico*/
INSERT INTO adm_catalogos_mae(nom_tabla,id_elemento,cod_elemento,nom_elemento,estado,fec_registro,user_registro)VALUES('ADM_DX_MAE',501,'C431','CA.LARINGE','1',NOW(),'ADMIN');
INSERT INTO adm_catalogos_mae(nom_tabla,id_elemento,cod_elemento,nom_elemento,estado,fec_registro,user_registro)VALUES('ADM_DX_MAE',502,'C432','CA.UTERO','1',NOW(),'ADMIN');
INSERT INTO adm_catalogos_mae(nom_tabla,id_elemento,cod_elemento,nom_elemento,estado,fec_registro,user_registro)VALUES('ADM_DX_MAE',503,'C501','CA.MAMA','1',NOW(),'ADMIN');
INSERT INTO adm_catalogos_mae(nom_tabla,id_elemento,cod_elemento,nom_elemento,estado,fec_registro,user_registro)VALUES('ADM_DX_MAE',504,'C502','CA.ESTOMOGO','1',NOW(),'ADMIN');
INSERT INTO adm_catalogos_mae(nom_tabla,id_elemento,cod_elemento,nom_elemento,estado,fec_registro,user_registro)VALUES('ADM_DX_MAE',505,'C503','CA.COLON','1',NOW(),'ADMIN');

/* Creamos algunos Especialidad*/
INSERT INTO adm_catalogos_mae(nom_tabla,id_elemento,nom_elemento,estado,fec_registro,user_registro)VALUES('ADM_DPTO_MAE','1','ABDOMEN','1',NOW(),'ADMIN');
INSERT INTO adm_catalogos_mae(nom_tabla,id_elemento,nom_elemento,estado,fec_registro,user_registro)VALUES('ADM_DPTO_MAE','2','CABEZA Y CUELLO','1',NOW(),'ADMIN');
INSERT INTO adm_catalogos_mae(nom_tabla,id_elemento,nom_elemento,estado,fec_registro,user_registro)VALUES('ADM_DPTO_MAE','3','GINECOLOGIA','1',NOW(),'ADMIN');
INSERT INTO adm_catalogos_mae(nom_tabla,id_elemento,nom_elemento,estado,fec_registro,user_registro)VALUES('ADM_DPTO_MAE','4','MAMAS Y TEJIDOS ','1',NOW(),'ADMIN');
INSERT INTO adm_catalogos_mae(nom_tabla,id_elemento,nom_elemento,estado,fec_registro,user_registro)VALUES('ADM_DPTO_MAE','5','ONCOLOGIA MEDICA','1',NOW(),'ADMIN');

