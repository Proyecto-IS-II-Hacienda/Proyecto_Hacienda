/*==============================================================*/
/* DBMS name:      ORACLE Version 11g                           */
/* Created on:     11/10/2019 18:11:54                          */
/*==============================================================*/


alter table ANIMALES
   drop constraint FK_ANIMALES_CLASIFICA_TIPOS_DE;

alter table ASIGNAR_AREA
   drop constraint FK_ASIGNAR__ASIGNAR_A_ANIMALES;

alter table ASIGNAR_AREA
   drop constraint FK_ASIGNAR__ASIGNAR_A_AREAS;

alter table ASIGNAR_AREA2
   drop constraint FK_ASIGNAR__ASIGNAR_A_AREAS_2;

alter table ASIGNAR_AREA2
   drop constraint FK_ASIGNAR__ASIGNAR_A_PLANTAS;

alter table ASIGNAR_CUIDADOS
   drop constraint FK_ASIGNAR__ASIGNAR_C_INVENTAR;

alter table ASIGNAR_CUIDADOS
   drop constraint FK_ASIGNAR__ASIGNAR_C_ANIMALES;

alter table ASIGNAR_CUIDADOS2
   drop constraint FK_ASIGNAR__ASIGNARCU_INVENTAR;

alter table ASIGNAR_CUIDADOS2
   drop constraint FK_ASIGNAR__ASIGNARCU_PLANTAS;

alter table INVENTARIO_INSUMOS
   drop constraint FK_INVENTAR_ALMACENAR_INSUMOS;

alter table INVENTARIO_PRODUCTOS
   drop constraint FK_INVENTAR_ALMACENAR_PRODUCTO;

alter table PLANTAS
   drop constraint FK_PLANTAS_CLASIFICA_TIPOS_DE;

alter table TRANSFORMAR
   drop constraint FK_TRANSFOR_TRANSFORM_PRODUCTO;

alter table TRANSFORMAR
   drop constraint FK_TRANSFOR_TRANSFORM_ANIMALES;

alter table TRANSFORMAR2
   drop constraint FK_TRANS_TRANSFORM_PRODUCTO;

alter table TRANSFORMAR2
   drop constraint FK_TRANSFOR_TRANSFORM_PLANTAS;

alter table VENDER
   drop constraint FK_VENDER_VENDER_CLIENTES;

alter table VENDER
   drop constraint FK_VENDER_VENDER2_INVENTAR;

drop index CLASIFICA_FK;

alter table ANIMALES
   drop primary key cascade;

drop table ANIMALES cascade constraints;

alter table AREAS
   drop primary key cascade;

drop table AREAS cascade constraints;

drop index ASIGNAR_AREA_FK;

drop index ASIGNAR_AREA3_FK;

drop table ASIGNAR_AREA cascade constraints;

drop index ASIGNAR_AREA2_FK;

drop index ASIGNAR_AREA4_FK;

drop table ASIGNAR_AREA2 cascade constraints;

drop index ASIGNAR_CUIDADOS_FK;

drop index ASIGNAR_CUIDADOS2_FK;

drop table ASIGNAR_CUIDADOS cascade constraints;

drop index ASIGNARCUIDADOS2_FK;

drop index ASIGNARCUIDADOS3_FK;

drop table ASIGNAR_CUIDADOS2 cascade constraints;

alter table CLIENTES
   drop primary key cascade;

drop table CLIENTES cascade constraints;

alter table INSUMOS
   drop primary key cascade;

drop table INSUMOS cascade constraints;

drop index ALMACENAR3_FK;

alter table INVENTARIO_INSUMOS
   drop primary key cascade;

drop table INVENTARIO_INSUMOS cascade constraints;

drop index ALMACENAR4_FK;

alter table INVENTARIO_PRODUCTOS
   drop primary key cascade;

drop table INVENTARIO_PRODUCTOS cascade constraints;

drop table LOGS cascade constraints;

drop index CLASIFICA2_FK;

alter table PLANTAS
   drop primary key cascade;

drop table PLANTAS cascade constraints;

alter table PRODUCTOS
   drop primary key cascade;

drop table PRODUCTOS cascade constraints;

alter table TIPOS_DE_ANIMALES
   drop primary key cascade;

drop table TIPOS_DE_ANIMALES cascade constraints;

alter table TIPOS_DE_PLANTAS
   drop primary key cascade;

drop table TIPOS_DE_PLANTAS cascade constraints;

drop index TRANSFORMAR_FK;

drop index TRANSFORMAR3_FK;

drop table TRANSFORMAR cascade constraints;

drop index TRANSFORMAR2_FK;

drop index TRANSFORMAR4_FK;

drop table TRANSFORMAR2 cascade constraints;

drop index VENDER_FK;

drop index VENDER2_FK;

drop table VENDER cascade constraints;

/*==============================================================*/
/* Table: ANIMALES                                              */
/*==============================================================*/
create table ANIMALES 
(
   CODANIMAL            CHAR(10)             not null,
   RAZA                 CHAR(10)             not null,
   NOMBRE               CHAR(10)             not null,
   PESO                 INTEGER              not null,
   ALTURA               INTEGER              not null,
   FECHANACIMIENTO      DATE                 not null,
   GENERO               CHAR(1)              not null
);

alter table ANIMALES
   add constraint PK_ANIMALES primary key (CODANIMAL);

/*==============================================================*/
/* Index: CLASIFICA_FK                                          */
/*==============================================================*/
create index CLASIFICA_FK on ANIMALES (
   RAZA ASC,
   NOMBRE ASC
);

/*==============================================================*/
/* Table: AREAS                                                 */
/*==============================================================*/
create table AREAS 
(
   IDAREA               CHAR(10)             not null,
   DIMENSION            CHAR(10)             not null,
   CERCADO              SMALLINT             not null,
   TIEMPODEUSO          INTEGER              not null
);

alter table AREAS
   add constraint PK_AREAS primary key (IDAREA);

/*==============================================================*/
/* Table: ASIGNAR_AREA                                          */
/*==============================================================*/
create table ASIGNAR_AREA 
(
   CODANIMAL            CHAR(10)             not null,
   IDAREA               CHAR(10)             not null
);

/*==============================================================*/
/* Index: ASIGNAR_AREA3_FK                                      */
/*==============================================================*/
create index ASIGNAR_AREA3_FK on ASIGNAR_AREA (
   IDAREA ASC
);

/*==============================================================*/
/* Index: ASIGNAR_AREA_FK                                       */
/*==============================================================*/
create index ASIGNAR_AREA_FK on ASIGNAR_AREA (
   CODANIMAL ASC
);

/*==============================================================*/
/* Table: ASIGNAR_AREA2                                         */
/*==============================================================*/
create table ASIGNAR_AREA2 
(
   IDAREA               CHAR(10),
   IDPLANTA             CHAR(10)
);

/*==============================================================*/
/* Index: ASIGNAR_AREA4_FK                                      */
/*==============================================================*/
create index ASIGNAR_AREA4_FK on ASIGNAR_AREA2 (
   IDPLANTA ASC
);

/*==============================================================*/
/* Index: ASIGNAR_AREA2_FK                                      */
/*==============================================================*/
create index ASIGNAR_AREA2_FK on ASIGNAR_AREA2 (
   IDAREA ASC
);

/*==============================================================*/
/* Table: ASIGNAR_CUIDADOS                                      */
/*==============================================================*/
create table ASIGNAR_CUIDADOS 
(
   IDINVENTARIOINSUMO   INTEGER              not null,
   CODINSUMO            CHAR(10)             not null,
   CODANIMAL            CHAR(10)             not null,
   CANTIDAD             INTEGER              not null
);

/*==============================================================*/
/* Index: ASIGNAR_CUIDADOS2_FK                                  */
/*==============================================================*/
create index ASIGNAR_CUIDADOS2_FK on ASIGNAR_CUIDADOS (
   CODANIMAL ASC
);

/*==============================================================*/
/* Index: ASIGNAR_CUIDADOS_FK                                   */
/*==============================================================*/
create index ASIGNAR_CUIDADOS_FK on ASIGNAR_CUIDADOS (
   IDINVENTARIOINSUMO ASC,
   CODINSUMO ASC
);

/*==============================================================*/
/* Table: ASIGNAR_CUIDADOS2                                     */
/*==============================================================*/
create table ASIGNAR_CUIDADOS2 
(
   IDINVENTARIOINSUMO   INTEGER              not null,
   CODINSUMO            CHAR(10)             not null,
   IDPLANTA             CHAR(10)             not null,
   CANTIDAD             INTEGER              not null
);

/*==============================================================*/
/* Index: ASIGNARCUIDADOS3_FK                                   */
/*==============================================================*/
create index ASIGNARCUIDADOS3_FK on ASIGNAR_CUIDADOS2 (
   IDPLANTA ASC
);

/*==============================================================*/
/* Index: ASIGNARCUIDADOS2_FK                                   */
/*==============================================================*/
create index ASIGNARCUIDADOS2_FK on ASIGNAR_CUIDADOS2 (
   IDINVENTARIOINSUMO ASC,
   CODINSUMO ASC
);

/*==============================================================*/
/* Table: CLIENTES                                              */
/*==============================================================*/
create table CLIENTES 
(
   CEDULA               CHAR(10)             not null,
   NOMBRE               CHAR(10)             not null,
   APELLIDO             CHAR(10)             not null,
   TELEFONO             CHAR(15)             not null
);

alter table CLIENTES
   add constraint PK_CLIENTES primary key (CEDULA);

/*==============================================================*/
/* Table: INSUMOS                                               */
/*==============================================================*/
create table INSUMOS 
(
   CODINSUMO            CHAR(10)             not null,
   NOMBREANIMAL         CHAR(10)             not null,
   TIPO                 CHAR(10)             not null
);

alter table INSUMOS
   add constraint PK_INSUMOS primary key (CODINSUMO);

/*==============================================================*/
/* Table: INVENTARIO_INSUMOS                                    */
/*==============================================================*/
create table INVENTARIO_INSUMOS 
(
   IDINVENTARIOINSUMO   INTEGER              not null,
   CODINSUMO            CHAR(10)             not null,
   CANTIDAD             INTEGER
);

alter table INVENTARIO_INSUMOS
   add constraint PK_INVENTARIO_INSUMOS primary key (IDINVENTARIOINSUMO, CODINSUMO);

/*==============================================================*/
/* Index: ALMACENAR3_FK                                         */
/*==============================================================*/
create index ALMACENAR3_FK on INVENTARIO_INSUMOS (
   CODINSUMO ASC
);

/*==============================================================*/
/* Table: INVENTARIO_PRODUCTOS                                  */
/*==============================================================*/
create table INVENTARIO_PRODUCTOS 
(
   IDINVENTARIOPRODUCTOS CHAR(10)             not null,
   IDPRODUCTO           CHAR(10)             not null,
   CANTIDAD             INTEGER              not null
);

alter table INVENTARIO_PRODUCTOS
   add constraint PK_INVENTARIO_PRODUCTOS primary key (IDINVENTARIOPRODUCTOS, IDPRODUCTO);

/*==============================================================*/
/* Index: ALMACENAR4_FK                                         */
/*==============================================================*/
create index ALMACENAR4_FK on INVENTARIO_PRODUCTOS (
   IDPRODUCTO ASC
);

/*==============================================================*/
/* Table: LOGS                                                  */
/*==============================================================*/
create table LOGS 
(
   TABLA                CHAR(20)             not null,
   DATOSINICIALES       CHAR(20),
   OPERACION            CHAR(20),
   DATOSFINALES         CHAR(20),
   FECHA                DATE                 not null,
   USUARIO              CHAR(20)
);

/*==============================================================*/
/* Table: PLANTAS                                               */
/*==============================================================*/
create table PLANTAS 
(
   IDPLANTA             CHAR(10)             not null,
   NOMBREDEPLANTA       CHAR(10)             not null,
   FECHAPLANTACION      DATE                 not null,
   OBSERVACION          CLOB
);

alter table PLANTAS
   add constraint PK_PLANTAS primary key (IDPLANTA);

/*==============================================================*/
/* Index: CLASIFICA2_FK                                         */
/*==============================================================*/
create index CLASIFICA2_FK on PLANTAS (
   NOMBREDEPLANTA ASC
);

/*==============================================================*/
/* Table: PRODUCTOS                                             */
/*==============================================================*/
create table PRODUCTOS 
(
   IDPRODUCTO           CHAR(10)             not null,
   NOMBREANIMAL         CHAR(10)             not null,
   FECHAELABORACION     DATE                 not null,
   PESO                 INTEGER              not null,
   PRECIO               NUMBER(8,2)          not null,
   FECHACADUCIDAD       DATE                 not null,
   DESCRIPCION          CLOB
);

alter table PRODUCTOS
   add constraint PK_PRODUCTOS primary key (IDPRODUCTO);

/*==============================================================*/
/* Table: TIPOS_DE_ANIMALES                                     */
/*==============================================================*/
create table TIPOS_DE_ANIMALES 
(
   RAZA                 CHAR(10)             not null,
   NOMBRE               CHAR(10)             not null
);

alter table TIPOS_DE_ANIMALES
   add constraint PK_TIPOS_DE_ANIMALES primary key (RAZA, NOMBRE);

/*==============================================================*/
/* Table: TIPOS_DE_PLANTAS                                      */
/*==============================================================*/
create table TIPOS_DE_PLANTAS 
(
   NOMBREDEPLANTA       CHAR(10)             not null,
   DIASCOSECHA          INTEGER              not null,
   DESCRIPCION          CLOB                 not null
);

alter table TIPOS_DE_PLANTAS
   add constraint PK_TIPOS_DE_PLANTAS primary key (NOMBREDEPLANTA);

/*==============================================================*/
/* Table: TRANSFORMAR                                           */
/*==============================================================*/
create table TRANSFORMAR 
(
   IDPRODUCTO           CHAR(10)             not null,
   CODANIMAL            CHAR(10)             not null,
   CANTIDAD             INTEGER              not null
);

/*==============================================================*/
/* Index: TRANSFORMAR3_FK                                       */
/*==============================================================*/
create index TRANSFORMAR3_FK on TRANSFORMAR (
   CODANIMAL ASC
);

/*==============================================================*/
/* Index: TRANSFORMAR_FK                                        */
/*==============================================================*/
create index TRANSFORMAR_FK on TRANSFORMAR (
   IDPRODUCTO ASC
);

/*==============================================================*/
/* Table: TRANSFORMAR2                                          */
/*==============================================================*/
create table TRANSFORMAR2 
(
   IDPRODUCTO           CHAR(10)             not null,
   IDPLANTA             CHAR(10)             not null
);

/*==============================================================*/
/* Index: TRANSFORMAR4_FK                                       */
/*==============================================================*/
create index TRANSFORMAR4_FK on TRANSFORMAR2 (
   IDPLANTA ASC
);

/*==============================================================*/
/* Index: TRANSFORMAR2_FK                                       */
/*==============================================================*/
create index TRANSFORMAR2_FK on TRANSFORMAR2 (
   IDPRODUCTO ASC
);

/*==============================================================*/
/* Table: VENDER                                                */
/*==============================================================*/
create table VENDER 
(
   CEDULA               CHAR(10)             not null,
   IDINVENTARIOPRODUCTOS CHAR(10)             not null,
   IDPRODUCTO           CHAR(10)             not null,
   CANTIDAD             INTEGER              not null
);

/*==============================================================*/
/* Index: VENDER2_FK                                            */
/*==============================================================*/
create index VENDER2_FK on VENDER (
   IDINVENTARIOPRODUCTOS ASC,
   IDPRODUCTO ASC
);

/*==============================================================*/
/* Index: VENDER_FK                                             */
/*==============================================================*/
create index VENDER_FK on VENDER (
   CEDULA ASC
);

alter table ANIMALES
   add constraint FK_ANIMALES_CLASIFICA_TIPOS_DE foreign key (RAZA, NOMBRE)
      references TIPOS_DE_ANIMALES (RAZA, NOMBRE);

alter table ASIGNAR_AREA
   add constraint FK_ASIGNAR__ASIGNAR_A_ANIMALES foreign key (CODANIMAL)
      references ANIMALES (CODANIMAL);

alter table ASIGNAR_AREA
   add constraint FK_ASIGNAR__ASIGNAR_A_AREAS foreign key (IDAREA)
      references AREAS (IDAREA);

alter table ASIGNAR_AREA2
   add constraint FK_ASIGNAR__ASIGNAR_A_AREAS_2 foreign key (IDAREA)
      references AREAS (IDAREA);

alter table ASIGNAR_AREA2
   add constraint FK_ASIGNAR__ASIGNAR_A_PLANTAS foreign key (IDPLANTA)
      references PLANTAS (IDPLANTA);

alter table ASIGNAR_CUIDADOS
   add constraint FK_ASIGNAR__ASIGNAR_C_INVENTAR foreign key (IDINVENTARIOINSUMO, CODINSUMO)
      references INVENTARIO_INSUMOS (IDINVENTARIOINSUMO, CODINSUMO);

alter table ASIGNAR_CUIDADOS
   add constraint FK_ASIGNAR__ASIGNAR_C_ANIMALES foreign key (CODANIMAL)
      references ANIMALES (CODANIMAL);

alter table ASIGNAR_CUIDADOS2
   add constraint FK_ASIGNAR__ASIGNARCU_INVENTAR foreign key (IDINVENTARIOINSUMO, CODINSUMO)
      references INVENTARIO_INSUMOS (IDINVENTARIOINSUMO, CODINSUMO);

alter table ASIGNAR_CUIDADOS2
   add constraint FK_ASIGNAR__ASIGNARCU_PLANTAS foreign key (IDPLANTA)
      references PLANTAS (IDPLANTA);

alter table INVENTARIO_INSUMOS
   add constraint FK_INVENTAR_ALMACENAR_INSUMOS foreign key (CODINSUMO)
      references INSUMOS (CODINSUMO);

alter table INVENTARIO_PRODUCTOS
   add constraint FK_INVENTAR_ALMACENAR_PRODUCTO foreign key (IDPRODUCTO)
      references PRODUCTOS (IDPRODUCTO);

alter table PLANTAS
   add constraint FK_PLANTAS_CLASIFICA_TIPOS_DE foreign key (NOMBREDEPLANTA)
      references TIPOS_DE_PLANTAS (NOMBREDEPLANTA);

alter table TRANSFORMAR
   add constraint FK_TRANSFOR_TRANSFORM_PRODUCTO foreign key (IDPRODUCTO)
      references PRODUCTOS (IDPRODUCTO);

alter table TRANSFORMAR
   add constraint FK_TRANSFOR_TRANSFORM_ANIMALES foreign key (CODANIMAL)
      references ANIMALES (CODANIMAL);

alter table TRANSFORMAR2
   add constraint FK_TRANS_TRANSFORM_PRODUCTO foreign key (IDPRODUCTO)
      references PRODUCTOS (IDPRODUCTO);

alter table TRANSFORMAR2
   add constraint FK_TRANSFOR_TRANSFORM_PLANTAS foreign key (IDPLANTA)
      references PLANTAS (IDPLANTA);

alter table VENDER
   add constraint FK_VENDER_VENDER_CLIENTES foreign key (CEDULA)
      references CLIENTES (CEDULA);

alter table VENDER
   add constraint FK_VENDER_VENDER2_INVENTAR foreign key (IDINVENTARIOPRODUCTOS, IDPRODUCTO)
      references INVENTARIO_PRODUCTOS (IDINVENTARIOPRODUCTOS, IDPRODUCTO);

