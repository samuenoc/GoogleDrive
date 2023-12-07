CREATE TABLE tbl_archivos (
    id_archivo     INTEGER NOT NULL,
    tamano         INTEGER NOT NULL,
    nombre         VARCHAR2(200) NOT NULL,
    id_propietario NUMBER NOT NULL,
    fecha_creacion DATE NOT NULL,
    fecha_abierto  DATE NOT NULL,
    descripcion    VARCHAR2(500),
    ubicacion      INTEGER NOT NULL,
    tipo_archivo   INTEGER NOT NULL,
    estado         NUMBER NOT NULL
);

ALTER TABLE tbl_archivos ADD CONSTRAINT tbl_documentos_pk PRIMARY KEY ( id_archivo );

CREATE TABLE tbl_compartidos (
    id_compartidos        INTEGER NOT NULL,
    id_propietario        NUMBER NOT NULL,
    id_usuario_receptor   NUMBER NOT NULL,
    id_archivo_compartido INTEGER NOT NULL,
    id_permiso            INTEGER NOT NULL
);

ALTER TABLE tbl_compartidos ADD CONSTRAINT tbl_compartidos_pk PRIMARY KEY ( id_compartidos );

CREATE TABLE tbl_copias_de_seguridad (
    id_copia_de_seguridad INTEGER NOT NULL,
    nombre                VARCHAR2(200) NOT NULL,
    origen                VARCHAR2(300),
    fecha_modificacion    DATE,
    id_usuario            NUMBER NOT NULL
);

COMMENT ON COLUMN tbl_copias_de_seguridad.origen IS
    'plataforma o aplicacion de la copia de seguridad (whatasapp, google pixel 6)';

ALTER TABLE tbl_copias_de_seguridad ADD CONSTRAINT tbl_copias_de_seguridad_pk PRIMARY KEY ( id_copia_de_seguridad );

CREATE TABLE tbl_estados_archivo (
    id_estado   NUMBER NOT NULL,
    tipo_estado VARCHAR2(100) NOT NULL
);

COMMENT ON COLUMN tbl_estados_archivo.tipo_estado IS
    'activo
papelera
destacado
spam
';

ALTER TABLE tbl_estados_archivo ADD CONSTRAINT tbl_estado_archivo_pk PRIMARY KEY ( id_estado );

CREATE TABLE tbl_facturacion_planes (
    id_facturacion_planes INTEGER NOT NULL,
    fecha_compra          DATE,
    usuario               NUMBER NOT NULL,
    plan                  NUMBER NOT NULL,
    id_tarjeta            NUMBER NOT NULL
);

ALTER TABLE tbl_facturacion_planes ADD CONSTRAINT tbl_facturacion_planes_pk PRIMARY KEY ( id_facturacion_planes );

CREATE TABLE tbl_genero (
    id_genero   NUMBER NOT NULL,
    tipo_genero VARCHAR2(50) NOT NULL
);

ALTER TABLE tbl_genero ADD CONSTRAINT tbl_genero_pk PRIMARY KEY ( id_genero );

CREATE TABLE tbl_lugares (
    id_lugar       NUMBER NOT NULL,
    id_tipo_lugar  NUMBER NOT NULL,
    nombre_lugar   VARCHAR2(500) NOT NULL,
    id_lugar_padre NUMBER
);

ALTER TABLE tbl_lugares ADD CONSTRAINT tbl_lugares_pk PRIMARY KEY ( id_lugar );

CREATE TABLE tbl_modificacion_archivos (
    tbl_modificacion_archivos INTEGER NOT NULL,
    fecha_modificacion        DATE,
    id_tipo_modificacion      INTEGER NOT NULL,
    id_usuario_modificador    NUMBER NOT NULL,
    id_archivo                INTEGER NOT NULL
);

ALTER TABLE tbl_modificacion_archivos ADD CONSTRAINT tbl_modificacion_archivos_pk PRIMARY KEY ( tbl_modificacion_archivos );

CREATE TABLE tbl_ofertas (
    id_oferta       NUMBER NOT NULL,
    descuento       NUMBER NOT NULL,
    duracion_oferta NUMBER NOT NULL
);

COMMENT ON COLUMN tbl_ofertas.descuento IS
    'descuento en porcentajes
';

ALTER TABLE tbl_ofertas ADD CONSTRAINT tbl_ofertas_pk PRIMARY KEY ( id_oferta );

CREATE TABLE tbl_permisos (
    id_permiso        INTEGER NOT NULL,
    nombre_de_permiso VARCHAR2(50)
);

COMMENT ON COLUMN tbl_permisos.nombre_de_permiso IS
    '(editar, compartir, leer)
';

ALTER TABLE tbl_permisos ADD CONSTRAINT tbl_tipo_permiso_pk PRIMARY KEY ( id_permiso );

CREATE TABLE tbl_planes (
    id_plan                NUMBER NOT NULL,
    nombre                 VARCHAR2(50) NOT NULL,
    espacio_almacenamiento NUMBER NOT NULL,
    precio                 NUMBER NOT NULL,
    duracion_plan          NUMBER NOT NULL,
    id_oferta              NUMBER NOT NULL
);

ALTER TABLE tbl_planes ADD CONSTRAINT tbl_planes_pk PRIMARY KEY ( id_plan );

CREATE TABLE tbl_tarjetas (
    id_tarjeta             NUMBER NOT NULL,
    numero_tarjeta         NUMBER NOT NULL,
    mes_fecha_vencimiento  INTEGER NOT NULL,
    anio_fecha_vencimiento INTEGER NOT NULL,
    codigo_postal          NUMBER NOT NULL,
    id_usuario_dueno       NUMBER NOT NULL,
    id_lugar               NUMBER NOT NULL
);

COMMENT ON COLUMN tbl_tarjetas.id_usuario_dueno IS
    'usuario que registro la tarjeta';

ALTER TABLE tbl_tarjetas ADD CONSTRAINT tbl_tarjetas_pk PRIMARY KEY ( id_tarjeta );

CREATE TABLE tbl_tipos_archivos (
    id_tipo_archivo INTEGER NOT NULL,
    tipo_archivo    VARCHAR2(50) NOT NULL
);

ALTER TABLE tbl_tipos_archivos ADD CONSTRAINT tbl_tipo_archivo_pk PRIMARY KEY ( id_tipo_archivo );

CREATE TABLE tbl_tipos_lugares (
    id_tipo_lugar NUMBER NOT NULL,
    nombre_tipo   VARCHAR2(500) NOT NULL
);

ALTER TABLE tbl_tipos_lugares ADD CONSTRAINT tbl_tipos_lugares_pk PRIMARY KEY ( id_tipo_lugar );

CREATE TABLE tbl_tipos_modificaciones (
    id_modificacion     INTEGER NOT NULL,
    nombre_modificacion VARCHAR2(50) NOT NULL
);

ALTER TABLE tbl_tipos_modificaciones ADD CONSTRAINT tbl_tipo_modificacion_pk PRIMARY KEY ( id_modificacion );

CREATE TABLE tbl_ubicaciones_archivos (
    id_ubicacion       INTEGER NOT NULL,
    id_ubicacion_padre INTEGER
);

ALTER TABLE tbl_ubicaciones_archivos ADD CONSTRAINT tbl_ubicacion_archivo_pk PRIMARY KEY ( id_ubicacion );

CREATE TABLE tbl_usuarios (
    id_usuario        NUMBER NOT NULL,
    nombre            VARCHAR2(50) NOT NULL,
    apellido          VARCHAR2(50) NOT NULL,
    correo            VARCHAR2(100) NOT NULL,
    contrasena        VARCHAR2(30) NOT NULL,
    id_genero         NUMBER NOT NULL,
    numero_telefonico NUMBER NOT NULL,
    pais              VARCHAR2(100) NOT NULL
);

ALTER TABLE tbl_usuarios ADD CONSTRAINT usuarios_pk PRIMARY KEY ( id_usuario );

ALTER TABLE tbl_usuarios ADD CONSTRAINT usuarios__un UNIQUE ( correo );

ALTER TABLE tbl_compartidos
    ADD CONSTRAINT archivos_fk FOREIGN KEY ( id_archivo_compartido )
        REFERENCES tbl_archivos ( id_archivo );

ALTER TABLE tbl_modificacion_archivos
    ADD CONSTRAINT archivos_fkv2 FOREIGN KEY ( id_archivo )
        REFERENCES tbl_archivos ( id_archivo );

ALTER TABLE tbl_archivos
    ADD CONSTRAINT estado_archivo_fk FOREIGN KEY ( estado )
        REFERENCES tbl_estados_archivo ( id_estado );

ALTER TABLE tbl_facturacion_planes
    ADD CONSTRAINT planes_fk FOREIGN KEY ( plan )
        REFERENCES tbl_planes ( id_plan );

ALTER TABLE tbl_facturacion_planes
    ADD CONSTRAINT tarjetas_fk FOREIGN KEY ( id_tarjeta )
        REFERENCES tbl_tarjetas ( id_tarjeta );

ALTER TABLE tbl_usuarios
    ADD CONSTRAINT tbl_genero_fk FOREIGN KEY ( id_genero )
        REFERENCES tbl_genero ( id_genero );

ALTER TABLE tbl_lugares
    ADD CONSTRAINT tbl_lugares_tbl_lugares_fk FOREIGN KEY ( id_lugar_padre )
        REFERENCES tbl_lugares ( id_lugar );

ALTER TABLE tbl_planes
    ADD CONSTRAINT tbl_planes_tbl_ofertas_fk FOREIGN KEY ( id_oferta )
        REFERENCES tbl_ofertas ( id_oferta );

ALTER TABLE tbl_tarjetas
    ADD CONSTRAINT tbl_tarjetas_tbl_lugares_fk FOREIGN KEY ( id_lugar )
        REFERENCES tbl_lugares ( id_lugar );

ALTER TABLE tbl_tarjetas
    ADD CONSTRAINT tbl_tarjetas_tbl_usuarios_fk FOREIGN KEY ( id_usuario_dueno )
        REFERENCES tbl_usuarios ( id_usuario );

ALTER TABLE tbl_archivos
    ADD CONSTRAINT tipo_archivo_fk FOREIGN KEY ( tipo_archivo )
        REFERENCES tbl_tipos_archivos ( id_tipo_archivo );

ALTER TABLE tbl_modificacion_archivos
    ADD CONSTRAINT tipo_modificacion_fk FOREIGN KEY ( id_tipo_modificacion )
        REFERENCES tbl_tipos_modificaciones ( id_modificacion );

ALTER TABLE tbl_lugares
    ADD CONSTRAINT tipos_lugares_fk FOREIGN KEY ( id_tipo_lugar )
        REFERENCES tbl_tipos_lugares ( id_tipo_lugar );

ALTER TABLE tbl_compartidos
    ADD CONSTRAINT tipos_permisos_fk FOREIGN KEY ( id_permiso )
        REFERENCES tbl_permisos ( id_permiso );

ALTER TABLE tbl_archivos
    ADD CONSTRAINT ubicacion_archivo_fk FOREIGN KEY ( ubicacion )
        REFERENCES tbl_ubicaciones_archivos ( id_ubicacion );

ALTER TABLE tbl_ubicaciones_archivos
    ADD CONSTRAINT ubicaciones_archivos_fk FOREIGN KEY ( id_ubicacion_padre )
        REFERENCES tbl_ubicaciones_archivos ( id_ubicacion );

ALTER TABLE tbl_archivos
    ADD CONSTRAINT usr_fk FOREIGN KEY ( id_propietario )
        REFERENCES tbl_usuarios ( id_usuario );

ALTER TABLE tbl_compartidos
    ADD CONSTRAINT usuarios_fk FOREIGN KEY ( id_propietario )
        REFERENCES tbl_usuarios ( id_usuario );

ALTER TABLE tbl_copias_de_seguridad
    ADD CONSTRAINT usuarios_fkv1 FOREIGN KEY ( id_usuario )
        REFERENCES tbl_usuarios ( id_usuario );

ALTER TABLE tbl_compartidos
    ADD CONSTRAINT usuarios_fkv2 FOREIGN KEY ( id_usuario_receptor )
        REFERENCES tbl_usuarios ( id_usuario );

ALTER TABLE tbl_facturacion_planes
    ADD CONSTRAINT usuarios_fkv3 FOREIGN KEY ( usuario )
        REFERENCES tbl_usuarios ( id_usuario );

ALTER TABLE tbl_modificacion_archivos
    ADD CONSTRAINT usuarios_fkv5 FOREIGN KEY ( id_usuario_modificador )
        REFERENCES tbl_usuarios ( id_usuario );




