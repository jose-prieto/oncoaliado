CREATE DATABASE ONCOALIADO;

CREATE TABLE PAIS (
	id INT AUTO_INCREMENT PRIMARY KEY,
    estatus ENUM('a','i') NOT NULL DEFAULT 'a',
    nombre VARCHAR(60) NOT NULL
);

CREATE TABLE ESTADO (
	id INT AUTO_INCREMENT PRIMARY KEY,
    estatus ENUM('a','i') NOT NULL DEFAULT 'a',
    nombre VARCHAR(60) NOT NULL,
    id_pais INT NOT NULL,	
    CONSTRAINT fk_pais FOREIGN KEY (id_pais) REFERENCES PAIS (id),
    CONSTRAINT unique_estado_pais UNIQUE (id, id_pais)
);

CREATE TABLE TIPO_USUARIO (
	id INT AUTO_INCREMENT PRIMARY KEY,
	estatus ENUM('a','i') NOT NULL DEFAULT 'a',
    tipo ENUM('paciente','medico','administrador','desarrollador') NOT NULL,
    descripcion VARCHAR(50) NOT NULL
);

CREATE TABLE USUARIO (
	id INT AUTO_INCREMENT PRIMARY KEY,
    estatus ENUM('a','i') NOT NULL DEFAULT 'a',
    correo VARCHAR(50) NOT NULL UNIQUE,
    contrasena VARCHAR(30) NOT NULL,
    nombre1 VARCHAR(50) NOT NULL,
    nombre2 VARCHAR(50),
    apellido1 VARCHAR(50) NOT NULL,
    apellido2 VARCHAR(50),
    fechaNac DATE NOT NULL,
    genero ENUM ('fem','mas') NOT NULL,
    foto LONGBLOB,
    direccion VARCHAR(50) NOT NULL,
    id_estado INT NOT NULL,
    id_tipo_usuario INT NOT NULL,
    CONSTRAINT fk_direccion FOREIGN KEY (id_estado) REFERENCES ESTADO (id),
    CONSTRAINT fk_tipo_usuario FOREIGN KEY (id_tipo_usuario) REFERENCES TIPO_USUARIO (id),
    CONSTRAINT unique_usuario_tipo UNIQUE (id, id_tipo_usuario)
);

CREATE TABLE EVENTO (
    id INT AUTO_INCREMENT PRIMARY KEY,
    estatus ENUM ('a','i') NOT NULL DEFAULT 'a',
    titulo VARCHAR(200) NOT NULL,
    contenido VARCHAR(10000),
    direccion VARCHAR (200),
    tipo ENUM ('salud','educativo','otro') NOT NULL,
    foto LONGBLOB,
    fecha DATE NOT NULL,
    id_estado INT NOT NULL,
    CONSTRAINT fk_lugar FOREIGN KEY (id_estado) REFERENCES ESTADO (id)
);

CREATE TABLE HIST_CAMBIO (
    id INT AUTO_INCREMENT PRIMARY KEY,
    estatus ENUM ('a','i') NOT NULL DEFAULT 'a',
    descripcion VARCHAR(500) NOT NULL,
    fecha DATE NOT NULL,
    id_usuario INT NOT NULL,
    CONSTRAINT fk_usuario_cambio FOREIGN KEY (id_usuario) REFERENCES USUARIO (id)
);

CREATE TABLE PACIENTE (
    id INT AUTO_INCREMENT PRIMARY KEY,
    estatus ENUM ('a','i') NOT NULL DEFAULT 'a',
    cedula INT UNIQUE NOT NULL,
    id_usuario INT UNIQUE NOT NULL,
    CONSTRAINT fk_usuario_paciente FOREIGN KEY (id_usuario) REFERENCES USUARIO (id),
    CONSTRAINT unique_paciente_usuario UNIQUE (id, id_usuario)
);

CREATE TABLE MEDICO (
    id INT AUTO_INCREMENT PRIMARY KEY,
    estatus ENUM ('a','i') NOT NULL DEFAULT 'a',
    cedula INT NOT NULL UNIQUE,
    descripcion VARCHAR(500) NOT NULL,
    id_usuario INT UNIQUE NOT NULL,
    CONSTRAINT FK_USUARIO_MEDICO FOREIGN KEY (id_usuario) REFERENCES USUARIO (id),
    CONSTRAINT unique_medico_usuario UNIQUE (id, id_usuario)
);

CREATE TABLE ESPECIALIDAD (
	id INT AUTO_INCREMENT PRIMARY KEY,
    estatus ENUM ('a','i') NOT NULL DEFAULT 'a',
    nombre VARCHAR(30) NOT NULL,
    descripcion VARCHAR (100)
);

CREATE TABLE ESPECIALIDAD_MEDICO (
	id INT AUTO_INCREMENT PRIMARY KEY,
    estatus ENUM ('a','i') NOT NULL DEFAULT 'a',
	id_medico INT NOT NULL,
    id_especialidad INT NOT NULL,
    CONSTRAINT fk_medico FOREIGN KEY (id_medico) REFERENCES MEDICO (id),
    CONSTRAINT fk_especialidad FOREIGN KEY (id_especialidad) REFERENCES ESPECIALIDAD (id),
    CONSTRAINT un_pas UNIQUE (id_medico, id_especialidad)
);

CREATE TABLE TIPO_CITA (
	id INT AUTO_INCREMENT PRIMARY KEY,
    estatus ENUM ('a','i') NOT NULL DEFAULT 'a',
    nombre VARCHAR(30) NOT NULL,
    descripcion VARCHAR(100)
);

CREATE TABLE HIST_PRECIO (
	id INT AUTO_INCREMENT PRIMARY KEY,
    estatus ENUM ('a','i') NOT NULL DEFAULT 'a',
	fecha_inicio DATE NOT NULL,
    id_tipo_cita INT NOT NULL,
    fecha_fin DATE,
    precio DECIMAL(15,2),
    CONSTRAINT fk_tipo_cita FOREIGN KEY (id_tipo_cita) REFERENCES TIPO_CITA(id),
    CONSTRAINT unique_idCita_fechaPrecio UNIQUE (fecha_inicio, id_tipo_cita)
);

CREATE TABLE FACTURA (
	id INT AUTO_INCREMENT PRIMARY KEY,
    estatus ENUM ('pagado', 'pendiente') NOT NULL DEFAULT 'pendiente',
    fecha DATE NOT NULL,
    comprobante INT NOT NULL,
    banco VARCHAR(40) NOT NULL,
    total DECIMAL(15,2)
);

CREATE TABLE CITA (
	id INT AUTO_INCREMENT PRIMARY KEY,
	estatus ENUM ('inactiva','pendiente','lista') NOT NULL,
	fecha DATE NOT NULL,
    descripcion VARCHAR(200),
    id_medico_especialidad INT NOT NULL,
    id_medico_diagnostico INT,
    id_paciente INT,
    id_factura INT,
	id_tipo_cita INT NOT NULL,
    CONSTRAINT fk_medico_cita FOREIGN KEY (id_medico_especialidad) REFERENCES ESPECIALIDAD_MEDICO(id),
    CONSTRAINT fk_medico_diagnostico FOREIGN KEY (id_medico_diagnostico) REFERENCES ESPECIALIDAD_MEDICO(id),
    CONSTRAINT fk_factura_cita FOREIGN KEY (id_factura) REFERENCES FACTURA(id),
    CONSTRAINT fk_tipo_cita_cita FOREIGN KEY (id_tipo_cita) REFERENCES TIPO_CITA(id),
    CONSTRAINT fk_paciente_cita FOREIGN KEY (id_paciente) REFERENCES PACIENTE(id),
    CONSTRAINT unique_medico_cita UNIQUE (id_medico_especialidad, fecha)
);