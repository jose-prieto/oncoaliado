CREATE DATABASE ONCOALIADO;

CREATE TABLE PAIS (
	id INT NOT NULL,
    nombre VARCHAR(60) NOT NULL,
    CONSTRAINT pk_pais PRIMARY KEY (id)
);

CREATE TABLE ESTADO (
	id INT NOT NULL,
    nombre VARCHAR(60) NOT NULL,
    id_pais INT NOT NULL,
    CONSTRAINT pk_estado PRIMARY KEY (id, id_pais),
    CONSTRAINT fk_pais FOREIGN KEY (id_pais) REFERENCES PAIS (id)
);

CREATE TABLE USUARIO (
    correo VARCHAR(50) NOT NULL,
    contrasena VARCHAR(30) NOT NULL,
    nombre1 VARCHAR(50) NOT NULL,
    nombre2 VARCHAR(50),
    apellido1 VARCHAR(50) NOT NULL,
    apellido2 VARCHAR(50),
    fechaNac DATE NOT NULL,
    genero VARCHAR(50) NOT NULL,
    foto LONGBLOB,
    direccion VARCHAR(50) NOT NULL,
    id_estado INT NOT NULL,
    id_pais INT NOT NULL,
    CONSTRAINT pk_usuario PRIMARY KEY (correo),
    CONSTRAINT fk_direccion FOREIGN KEY (id_estado, id_pais) REFERENCES ESTADO (id, id_pais),
    CONSTRAINT check_genero CHECK (genero in ('hombre', 'mujer'))
);

CREATE TABLE EVENTO (
    id INT NOT NULL,
    titulo VARCHAR(200) NOT NULL,
    direccion VARCHAR (200),
    tipo VARCHAR(50) NOT NULL,
    estatus VARCHAR(50) NOT NULL,
    foto LONGBLOB,
    fecha DATE NOT NULL,
    id_estado INT,
    id_pais INT,
    CONSTRAINT pk_evento PRIMARY KEY (id),
    CONSTRAINT fk_lugar FOREIGN KEY (id_estado, id_pais) REFERENCES ESTADO (id, id_pais),
    CONSTRAINT tipo_check CHECK (tipo in ('salud', 'educativo', 'otro'))
);

CREATE TABLE HIST_CAMBIO (
    id INT NOT NULL,
    descripcion VARCHAR(500) NOT NULL,
    fecha DATE NOT NULL,
    correo VARCHAR(50) NOT NULL,
    CONSTRAINT pk_cambio PRIMARY KEY (id, correo),
    CONSTRAINT fk_usuario_cambio FOREIGN KEY (correo) REFERENCES USUARIO (correo)
);

CREATE TABLE PACIENTE (
    id INT NOT NULL,
    correo VARCHAR(50) NOT NULL,
    CONSTRAINT pk_paciente PRIMARY KEY (id, correo),
    CONSTRAINT fk_usuario_paciente FOREIGN KEY (correo) REFERENCES USUARIO (correo)
);

CREATE TABLE MEDICO (
    id INT NOT NULL,
    descripcion VARCHAR(500) NOT NULL,
    correo VARCHAR(50) NOT NULL,
    CONSTRAINT pk_medico PRIMARY KEY (id, correo),
    CONSTRAINT FK_USUARIO_MEDICO FOREIGN KEY (correo) REFERENCES USUARIO (correo)
);

CREATE TABLE ESPECIALIDAD (
	id INT NOT NULL,
    nombre VARCHAR(30) NOT NULL,
    descripcion VARCHAR (100),
    CONSTRAINT pk_especialidad PRIMARY KEY (id)
);

CREATE TABLE ESPECIALIDAD_MEDICO (
	id_medico INT NOT NULL,
    correo_user VARCHAR(50) NOT NULL,
    id_especialidad INT NOT NULL,
    CONSTRAINT pk_especialidad_medico PRIMARY KEY (id_medico, correo_user, id_especialidad),
    CONSTRAINT fk_medico FOREIGN KEY (id_medico, correo_user) REFERENCES MEDICO (id, correo),
    CONSTRAINT fk_especialidad FOREIGN KEY (id_especialidad) REFERENCES ESPECIALIDAD (id)
);

CREATE TABLE TIPO_CITA (
	id INT NOT NULL,
    nombre VARCHAR(30) NOT NULL,
    descripcion VARCHAR(100),
    CONSTRAINT pk_tipo_cita PRIMARY KEY (id)
);

CREATE TABLE HIST_PRECIO (
	fecha_inicio DATE NOT NULL,
    fecha_fin DATE,
    precio DECIMAL(15,2),
    id_tipo_cita INT NOT NULL,
    CONSTRAINT pk_historico_precio PRIMARY KEY (fecha_inicio, id_tipo_cita),
    CONSTRAINT fk_tipo_cita FOREIGN KEY (id_tipo_cita) REFERENCES TIPO_CITA(id)
);

CREATE TABLE FACTURA (
	id INT NOT NULL,
    fecha DATE NOT NULL,
    comprobante INT NOT NULL,
    banco VARCHAR(40) NOT NULL,
    estatus VARCHAR(40) NOT NULL,
    total DECIMAL(15,2),
    CONSTRAINT pk_factura PRIMARY KEY (id),
    CONSTRAINT check_estatus CHECK(estatus in ('pagado, pendiente'))
);

CREATE TABLE CITA (
	id INT NOT NULL,
	estatus VARCHAR(50) NOT NULL,
    fecha DATE NOT NULL,
    descripcion VARCHAR(200),
    correo_paciente VARCHAR(50),
    id_paciente INT,
    correo_medico VARCHAR(50) NOT NULL,
    id_medico INT NOT NULL,
    id_especialidad INT NOT NULL,
    correo_medico_diagnostico VARCHAR(50),
    id_medico_diagnostico INT,
    id_especialidad_diagnostico INT,
    id_factura INT,
	id_tipo_cita INT,
    hist_precio DATE NOT NULL,
    CONSTRAINT pk_cita PRIMARY KEY (id, correo_medico, id_medico, id_especialidad, id_tipo_cita),
    CONSTRAINT fk_medico_cita FOREIGN KEY (id_medico, correo_medico, id_especialidad) REFERENCES ESPECIALIDAD_MEDICO(id_medico, correo_user, id_especialidad),
    CONSTRAINT fk_medico_diagnostico FOREIGN KEY (id_medico_diagnostico, correo_medico_diagnostico, id_especialidad_diagnostico) REFERENCES ESPECIALIDAD_MEDICO(id_medico, correo_user, id_especialidad),
    CONSTRAINT fk_factura_cita FOREIGN KEY (id_factura) REFERENCES FACTURA(id),
    CONSTRAINT fk_tipo_cita_cita FOREIGN KEY (id_tipo_cita) REFERENCES TIPO_CITA(id),
    CONSTRAINT fk_paciente_cita FOREIGN KEY (id_paciente, correo_paciente) REFERENCES PACIENTE(id, correo),
    CONSTRAINT check_estatus_cita CHECK (estatus in ('inactiva', 'pendiente', 'lista'))
);