-- Generated by Oracle SQL Developer Data Modeler 23.1.0.087.0806
--   at:        2023-10-21 15:25:14 COT
--   site:      Oracle Database 11g
--   type:      Oracle Database 11g



-- predefined type, no DDL - MDSYS.SDO_GEOMETRY

-- predefined type, no DDL - XMLTYPE

CREATE TABLE bares (
    estilo    VARCHAR2(250) NOT NULL,
    id        NUMBER NOT NULL,
    capacidad NUMBER NOT NULL
);

ALTER TABLE bares ADD CONSTRAINT bares_pk PRIMARY KEY ( id );

CREATE TABLE carachabitaciones (
    nombre VARCHAR2(250) NOT NULL,
    id     NUMBER NOT NULL
);

ALTER TABLE carachabitaciones ADD CONSTRAINT carachabitaciones_pk PRIMARY KEY ( id );

CREATE TABLE caract_habitacion (
    carachabitaciones_id NUMBER NOT NULL,
    habitaciones_id      NUMBER NOT NULL
);

ALTER TABLE caract_habitacion ADD CONSTRAINT caract_habitacion_pk PRIMARY KEY ( carachabitaciones_id,
                                                                                habitaciones_id );

CREATE TABLE extrassalas (
    nombre VARCHAR2(250) NOT NULL,
    id     NUMBER NOT NULL,
    costo  NUMBER NOT NULL
);

ALTER TABLE extrassalas ADD CONSTRAINT extrassalas_pk PRIMARY KEY ( id );

CREATE TABLE gimnasio (
    capacidad     NUMBER NOT NULL,
    id            NUMBER NOT NULL,
    hora_apertura DATE NOT NULL,
    hora_cierre   DATE NOT NULL
);

ALTER TABLE gimnasio ADD CONSTRAINT gimnasio_pk PRIMARY KEY ( id );

CREATE TABLE habitaciones (
    costo_noche     NUMBER NOT NULL,
    tipo_habitacion VARCHAR2(250) NOT NULL,
    id              NUMBER NOT NULL,
    hoteles_nombre  VARCHAR2(250)
);

ALTER TABLE habitaciones ADD CONSTRAINT habitaciones_pk PRIMARY KEY ( id );

CREATE TABLE hoteles (
    nombre    VARCHAR2(250) NOT NULL,
    tipo      VARCHAR2(250) NOT NULL,
    estrellas NUMBER NOT NULL
);

ALTER TABLE hoteles ADD CONSTRAINT hoteles_pk PRIMARY KEY ( nombre );

CREATE TABLE lavado (
    numero_prendas NUMBER NOT NULL,
    id             NUMBER NOT NULL,
    tipo_prenda    VARCHAR2(250) NOT NULL
);

ALTER TABLE lavado ADD CONSTRAINT lavado_pk PRIMARY KEY ( id );

CREATE TABLE maquina (
    nombre VARCHAR2(250),
    id     NUMBER NOT NULL
);

ALTER TABLE maquina ADD CONSTRAINT maquina_pk PRIMARY KEY ( id );

CREATE TABLE maquina_gimnasio (
    gimnasio_id NUMBER NOT NULL,
    maquina_id  NUMBER NOT NULL
);

ALTER TABLE maquina_gimnasio ADD CONSTRAINT maquina_gimnasio_pk PRIMARY KEY ( gimnasio_id,
                                                                              maquina_id );

CREATE TABLE piscinas (
    horacierre    DATE NOT NULL,
    id            NUMBER NOT NULL,
    hora_apertura DATE NOT NULL,
    profundidad   NUMBER NOT NULL,
    capacidad     NUMBER NOT NULL
);

ALTER TABLE piscinas ADD CONSTRAINT piscinas_pk PRIMARY KEY ( id );

CREATE TABLE planes_de_cosumo (
    comida CHAR(1) NOT NULL,
    bebida CHAR(1) NOT NULL,
    id     NUMBER NOT NULL,
    nombre VARCHAR2(250) NOT NULL
);

ALTER TABLE planes_de_cosumo ADD CONSTRAINT planes_de_cosumo_pk PRIMARY KEY ( id );

CREATE TABLE planspa (
    duracion NUMBER NOT NULL,
    costo    NUMBER NOT NULL,
    id       NUMBER NOT NULL
);

ALTER TABLE planspa ADD CONSTRAINT planspa_pk PRIMARY KEY ( id );

CREATE TABLE productos (
    nombre VARCHAR2(250) NOT NULL,
    id     NUMBER NOT NULL,
    costo  NUMBER NOT NULL
);

ALTER TABLE productos ADD CONSTRAINT productos_pk PRIMARY KEY ( id );

CREATE TABLE reservas (
    numero_personas     NUMBER NOT NULL,
    id                  NUMBER NOT NULL,
    fecha_entrada       DATE NOT NULL,
    fecha_salida        DATE NOT NULL,
    costo_total         NUMBER NOT NULL,
    check_in            CHAR(1) NOT NULL,
    check_out           CHAR(1) NOT NULL,
    hoteles_nombre      VARCHAR2(250) NOT NULL,
    planes_de_cosumo_id NUMBER
);

ALTER TABLE reservas ADD CONSTRAINT reservas_pk PRIMARY KEY ( id );

CREATE TABLE reservas_servicios (
    reservas_id  NUMBER NOT NULL,
    servicios_id NUMBER NOT NULL
);

ALTER TABLE reservas_servicios ADD CONSTRAINT reservas_servicios_pk PRIMARY KEY ( reservas_id,
                                                                                  servicios_id );

CREATE TABLE reservassala (
    fecha    DATE NOT NULL,
    duracion NUMBER NOT NULL,
    salas_id NUMBER
);

ALTER TABLE reservassala ADD CONSTRAINT reservassala_pk PRIMARY KEY ( fecha );

CREATE TABLE reservasspa (
    fecha      DATE NOT NULL,
    planspa_id NUMBER,
    spas_id    NUMBER
);

ALTER TABLE reservasspa ADD CONSTRAINT reservasspa_pk PRIMARY KEY ( fecha );

CREATE TABLE restaurantes (
    estilo    VARCHAR2(250) NOT NULL,
    id        NUMBER NOT NULL,
    capacidad NUMBER NOT NULL
);

ALTER TABLE restaurantes ADD CONSTRAINT restaurantes_pk PRIMARY KEY ( id );

CREATE TABLE salas (
    capcacidad     NUMBER NOT NULL,
    id             NUMBER NOT NULL,
    costo_por_hora NUMBER NOT NULL,
    tipo           VARCHAR2(250) NOT NULL
);

ALTER TABLE salas ADD CONSTRAINT salas_pk PRIMARY KEY ( id );

CREATE TABLE salas_extra (
    reservassala_fecha DATE NOT NULL,
    extrassalas_id     NUMBER NOT NULL
);

ALTER TABLE salas_extra ADD CONSTRAINT salas_extra_pk PRIMARY KEY ( reservassala_fecha,
                                                                    extrassalas_id );

CREATE TABLE servicios (
    nombre        VARCHAR2(250) NOT NULL,
    id            NUMBER NOT NULL,
    tipo_servicio VARCHAR2(13) NOT NULL
);

ALTER TABLE servicios
    ADD CONSTRAINT ch_inh_servicios CHECK ( tipo_servicio IN ( 'Bares', 'Gimnasio', 'Lavado', 'Piscinas', 'Restaurantes',
                                                               'Salas', 'Spas', 'Supermercados', 'Tiendas', 'Wifis' ) );

ALTER TABLE servicios ADD CONSTRAINT servicios_pk PRIMARY KEY ( id );

CREATE TABLE servicios_productos (
    servicios_id NUMBER NOT NULL,
    productos_id NUMBER NOT NULL
);

ALTER TABLE servicios_productos ADD CONSTRAINT servicios_productos_pk PRIMARY KEY ( servicios_id,
                                                                                    productos_id );

CREATE TABLE spas (
    capacidad NUMBER NOT NULL,
    id        NUMBER NOT NULL
);

ALTER TABLE spas ADD CONSTRAINT spas_pk PRIMARY KEY ( id );

CREATE TABLE supermercados (
    id NUMBER NOT NULL
);

ALTER TABLE supermercados ADD CONSTRAINT supermercados_pk PRIMARY KEY ( id );

CREATE TABLE tiendas (
    tipo VARCHAR2(250) NOT NULL,
    id   NUMBER NOT NULL
);

ALTER TABLE tiendas ADD CONSTRAINT tiendas_pk PRIMARY KEY ( id );

CREATE TABLE usuarios (
    no_documento NUMBER NOT NULL,
    nombre       VARCHAR2(250) NOT NULL,
    contraseņa   VARCHAR2(250) NOT NULL,
    login        VARCHAR2(250) NOT NULL,
    reservas_id  NUMBER NOT NULL
);

CREATE UNIQUE INDEX usuarios__idx ON
    usuarios (
        reservas_id
    ASC );

ALTER TABLE usuarios ADD CONSTRAINT usuarios_pk PRIMARY KEY ( login );

CREATE TABLE wifis (
    costo_por_dia NUMBER NOT NULL,
    id            NUMBER NOT NULL,
    capacidad     NUMBER NOT NULL
);

ALTER TABLE wifis ADD CONSTRAINT wifis_pk PRIMARY KEY ( id );

ALTER TABLE bares
    ADD CONSTRAINT bares_servicios_fk FOREIGN KEY ( id )
        REFERENCES servicios ( id );

ALTER TABLE caract_habitacion
    ADD CONSTRAINT carachabitaciones_fk FOREIGN KEY ( carachabitaciones_id )
        REFERENCES carachabitaciones ( id );

ALTER TABLE caract_habitacion
    ADD CONSTRAINT caract_habitacionfk FOREIGN KEY ( habitaciones_id )
        REFERENCES habitaciones ( id );

ALTER TABLE gimnasio
    ADD CONSTRAINT gimnasio_servicios_fk FOREIGN KEY ( id )
        REFERENCES servicios ( id );

ALTER TABLE habitaciones
    ADD CONSTRAINT habitaciones_hoteles_fk FOREIGN KEY ( hoteles_nombre )
        REFERENCES hoteles ( nombre );

ALTER TABLE lavado
    ADD CONSTRAINT lavado_servicios_fk FOREIGN KEY ( id )
        REFERENCES servicios ( id );

ALTER TABLE maquina_gimnasio
    ADD CONSTRAINT maquina_gimnasio_gimnasio_fk FOREIGN KEY ( gimnasio_id )
        REFERENCES gimnasio ( id );

ALTER TABLE maquina_gimnasio
    ADD CONSTRAINT maquina_gimnasio_maquina_fk FOREIGN KEY ( maquina_id )
        REFERENCES maquina ( id );

ALTER TABLE piscinas
    ADD CONSTRAINT piscinas_servicios_fk FOREIGN KEY ( id )
        REFERENCES servicios ( id );

ALTER TABLE reservas
    ADD CONSTRAINT reservas_hoteles_fk FOREIGN KEY ( hoteles_nombre )
        REFERENCES hoteles ( nombre );

ALTER TABLE reservas
    ADD CONSTRAINT reservas_planes_de_cosumo_fk FOREIGN KEY ( planes_de_cosumo_id )
        REFERENCES planes_de_cosumo ( id );

ALTER TABLE reservas_servicios
    ADD CONSTRAINT reservas_servicios_reservas_fk FOREIGN KEY ( reservas_id )
        REFERENCES reservas ( id );

ALTER TABLE reservas_servicios
    ADD CONSTRAINT reservas_serviciosfk FOREIGN KEY ( servicios_id )
        REFERENCES servicios ( id );

ALTER TABLE reservassala
    ADD CONSTRAINT reservassala_salas_fk FOREIGN KEY ( salas_id )
        REFERENCES salas ( id );

ALTER TABLE reservasspa
    ADD CONSTRAINT reservasspa_planspa_fk FOREIGN KEY ( planspa_id )
        REFERENCES planspa ( id );

ALTER TABLE reservasspa
    ADD CONSTRAINT reservasspa_spas_fk FOREIGN KEY ( spas_id )
        REFERENCES spas ( id );

ALTER TABLE restaurantes
    ADD CONSTRAINT restaurantes_servicios_fk FOREIGN KEY ( id )
        REFERENCES servicios ( id );

ALTER TABLE salas_extra
    ADD CONSTRAINT salas_extra_extrassalas_fk FOREIGN KEY ( extrassalas_id )
        REFERENCES extrassalas ( id );

ALTER TABLE salas_extra
    ADD CONSTRAINT salas_extra_reservassala_fk FOREIGN KEY ( reservassala_fecha )
        REFERENCES reservassala ( fecha );

ALTER TABLE salas
    ADD CONSTRAINT salas_servicios_fk FOREIGN KEY ( id )
        REFERENCES servicios ( id );

ALTER TABLE servicios_productos
    ADD CONSTRAINT servicios_productosfk FOREIGN KEY ( servicios_id )
        REFERENCES servicios ( id );

ALTER TABLE servicios_productos
    ADD CONSTRAINT servicios_productosfkv2 FOREIGN KEY ( productos_id )
        REFERENCES productos ( id );

ALTER TABLE spas
    ADD CONSTRAINT spas_servicios_fk FOREIGN KEY ( id )
        REFERENCES servicios ( id );

ALTER TABLE supermercados
    ADD CONSTRAINT supermercados_servicios_fk FOREIGN KEY ( id )
        REFERENCES servicios ( id );

ALTER TABLE tiendas
    ADD CONSTRAINT tiendas_servicios_fk FOREIGN KEY ( id )
        REFERENCES servicios ( id );

ALTER TABLE usuarios
    ADD CONSTRAINT usuarios_reservas_fk FOREIGN KEY ( reservas_id )
        REFERENCES reservas ( id );

ALTER TABLE wifis
    ADD CONSTRAINT wifis_servicios_fk FOREIGN KEY ( id )
        REFERENCES servicios ( id );

CREATE OR REPLACE TRIGGER arc_fkarc_1_tiendas BEFORE
    INSERT OR UPDATE OF id ON tiendas
    FOR EACH ROW
DECLARE
    d VARCHAR2(13);
BEGIN
    SELECT
        a.tipo_servicio
    INTO d
    FROM
        servicios a
    WHERE
        a.id = :new.id;

    IF ( d IS NULL OR d <> 'Tiendas' ) THEN
        raise_application_error(-20223, 'FK Tiendas_Servicios_FK in Table Tiendas violates Arc constraint on Table Servicios - discriminator column Tipo_Servicio doesn''t have value ''Tiendas'''
        );
    END IF;

EXCEPTION
    WHEN no_data_found THEN
        NULL;
    WHEN OTHERS THEN
        RAISE;
END;
/

CREATE OR REPLACE TRIGGER arc_fkarc_1_spas BEFORE
    INSERT OR UPDATE OF id ON spas
    FOR EACH ROW
DECLARE
    d VARCHAR2(13);
BEGIN
    SELECT
        a.tipo_servicio
    INTO d
    FROM
        servicios a
    WHERE
        a.id = :new.id;

    IF ( d IS NULL OR d <> 'Spas' ) THEN
        raise_application_error(-20223, 'FK Spas_Servicios_FK in Table Spas violates Arc constraint on Table Servicios - discriminator column Tipo_Servicio doesn''t have value ''Spas'''
        );
    END IF;

EXCEPTION
    WHEN no_data_found THEN
        NULL;
    WHEN OTHERS THEN
        RAISE;
END;
/

CREATE OR REPLACE TRIGGER arc_fkarc_1_bares BEFORE
    INSERT OR UPDATE OF id ON bares
    FOR EACH ROW
DECLARE
    d VARCHAR2(13);
BEGIN
    SELECT
        a.tipo_servicio
    INTO d
    FROM
        servicios a
    WHERE
        a.id = :new.id;

    IF ( d IS NULL OR d <> 'Bares' ) THEN
        raise_application_error(-20223, 'FK Bares_Servicios_FK in Table Bares violates Arc constraint on Table Servicios - discriminator column Tipo_Servicio doesn''t have value ''Bares'''
        );
    END IF;

EXCEPTION
    WHEN no_data_found THEN
        NULL;
    WHEN OTHERS THEN
        RAISE;
END;
/

CREATE OR REPLACE TRIGGER arc_fkarc_1_restaurantes BEFORE
    INSERT OR UPDATE OF id ON restaurantes
    FOR EACH ROW
DECLARE
    d VARCHAR2(13);
BEGIN
    SELECT
        a.tipo_servicio
    INTO d
    FROM
        servicios a
    WHERE
        a.id = :new.id;

    IF ( d IS NULL OR d <> 'Restaurantes' ) THEN
        raise_application_error(-20223, 'FK Restaurantes_Servicios_FK in Table Restaurantes violates Arc constraint on Table Servicios - discriminator column Tipo_Servicio doesn''t have value ''Restaurantes'''
        );
    END IF;

EXCEPTION
    WHEN no_data_found THEN
        NULL;
    WHEN OTHERS THEN
        RAISE;
END;
/

CREATE OR REPLACE TRIGGER arc_fkarc_1_piscinas BEFORE
    INSERT OR UPDATE OF id ON piscinas
    FOR EACH ROW
DECLARE
    d VARCHAR2(13);
BEGIN
    SELECT
        a.tipo_servicio
    INTO d
    FROM
        servicios a
    WHERE
        a.id = :new.id;

    IF ( d IS NULL OR d <> 'Piscinas' ) THEN
        raise_application_error(-20223, 'FK Piscinas_Servicios_FK in Table Piscinas violates Arc constraint on Table Servicios - discriminator column Tipo_Servicio doesn''t have value ''Piscinas'''
        );
    END IF;

EXCEPTION
    WHEN no_data_found THEN
        NULL;
    WHEN OTHERS THEN
        RAISE;
END;
/

CREATE OR REPLACE TRIGGER arc_fkarc_1_gimnasio BEFORE
    INSERT OR UPDATE OF id ON gimnasio
    FOR EACH ROW
DECLARE
    d VARCHAR2(13);
BEGIN
    SELECT
        a.tipo_servicio
    INTO d
    FROM
        servicios a
    WHERE
        a.id = :new.id;

    IF ( d IS NULL OR d <> 'Gimnasio' ) THEN
        raise_application_error(-20223, 'FK Gimnasio_Servicios_FK in Table Gimnasio violates Arc constraint on Table Servicios - discriminator column Tipo_Servicio doesn''t have value ''Gimnasio'''
        );
    END IF;

EXCEPTION
    WHEN no_data_found THEN
        NULL;
    WHEN OTHERS THEN
        RAISE;
END;
/

CREATE OR REPLACE TRIGGER arc_fkarc_1_wifis BEFORE
    INSERT OR UPDATE OF id ON wifis
    FOR EACH ROW
DECLARE
    d VARCHAR2(13);
BEGIN
    SELECT
        a.tipo_servicio
    INTO d
    FROM
        servicios a
    WHERE
        a.id = :new.id;

    IF ( d IS NULL OR d <> 'Wifis' ) THEN
        raise_application_error(-20223, 'FK Wifis_Servicios_FK in Table Wifis violates Arc constraint on Table Servicios - discriminator column Tipo_Servicio doesn''t have value ''Wifis'''
        );
    END IF;

EXCEPTION
    WHEN no_data_found THEN
        NULL;
    WHEN OTHERS THEN
        RAISE;
END;
/

CREATE OR REPLACE TRIGGER arc_fkarc_1_lavado BEFORE
    INSERT OR UPDATE OF id ON lavado
    FOR EACH ROW
DECLARE
    d VARCHAR2(13);
BEGIN
    SELECT
        a.tipo_servicio
    INTO d
    FROM
        servicios a
    WHERE
        a.id = :new.id;

    IF ( d IS NULL OR d <> 'Lavado' ) THEN
        raise_application_error(-20223, 'FK Lavado_Servicios_FK in Table Lavado violates Arc constraint on Table Servicios - discriminator column Tipo_Servicio doesn''t have value ''Lavado'''
        );
    END IF;

EXCEPTION
    WHEN no_data_found THEN
        NULL;
    WHEN OTHERS THEN
        RAISE;
END;
/

CREATE OR REPLACE TRIGGER arc_fkarc_1_supermercados BEFORE
    INSERT OR UPDATE OF id ON supermercados
    FOR EACH ROW
DECLARE
    d VARCHAR2(13);
BEGIN
    SELECT
        a.tipo_servicio
    INTO d
    FROM
        servicios a
    WHERE
        a.id = :new.id;

    IF ( d IS NULL OR d <> 'Supermercados' ) THEN
        raise_application_error(-20223, 'FK Supermercados_Servicios_FK in Table Supermercados violates Arc constraint on Table Servicios - discriminator column Tipo_Servicio doesn''t have value ''Supermercados'''
        );
    END IF;

EXCEPTION
    WHEN no_data_found THEN
        NULL;
    WHEN OTHERS THEN
        RAISE;
END;
/

CREATE OR REPLACE TRIGGER arc_fkarc_1_salas BEFORE
    INSERT OR UPDATE OF id ON salas
    FOR EACH ROW
DECLARE
    d VARCHAR2(13);
BEGIN
    SELECT
        a.tipo_servicio
    INTO d
    FROM
        servicios a
    WHERE
        a.id = :new.id;

    IF ( d IS NULL OR d <> 'Salas' ) THEN
        raise_application_error(-20223, 'FK Salas_Servicios_FK in Table Salas violates Arc constraint on Table Servicios - discriminator column Tipo_Servicio doesn''t have value ''Salas'''
        );
    END IF;

EXCEPTION
    WHEN no_data_found THEN
        NULL;
    WHEN OTHERS THEN
        RAISE;
END;
/



-- Oracle SQL Developer Data Modeler Summary Report: 
-- 
-- CREATE TABLE                            28
-- CREATE INDEX                             1
-- ALTER TABLE                             56
-- CREATE VIEW                              0
-- ALTER VIEW                               0
-- CREATE PACKAGE                           0
-- CREATE PACKAGE BODY                      0
-- CREATE PROCEDURE                         0
-- CREATE FUNCTION                          0
-- CREATE TRIGGER                          10
-- ALTER TRIGGER                            0
-- CREATE COLLECTION TYPE                   0
-- CREATE STRUCTURED TYPE                   0
-- CREATE STRUCTURED TYPE BODY              0
-- CREATE CLUSTER                           0
-- CREATE CONTEXT                           0
-- CREATE DATABASE                          0
-- CREATE DIMENSION                         0
-- CREATE DIRECTORY                         0
-- CREATE DISK GROUP                        0
-- CREATE ROLE                              0
-- CREATE ROLLBACK SEGMENT                  0
-- CREATE SEQUENCE                          0
-- CREATE MATERIALIZED VIEW                 0
-- CREATE MATERIALIZED VIEW LOG             0
-- CREATE SYNONYM                           0
-- CREATE TABLESPACE                        0
-- CREATE USER                              0
-- 
-- DROP TABLESPACE                          0
-- DROP DATABASE                            0
-- 
-- REDACTION POLICY                         0
-- 
-- ORDS DROP SCHEMA                         0
-- ORDS ENABLE SCHEMA                       0
-- ORDS ENABLE OBJECT                       0
-- 
-- ERRORS                                   0
-- WARNINGS                                 0
