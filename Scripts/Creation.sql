/*--------------------------DROP----------------------------------------------*/
drop table RESERVATION cascade constraints;
drop table CLIENT cascade constraints;
drop table ARRIVE cascade constraints;
drop table DE cascade constraints;
drop table TRX cascade constraints; 
drop table TYPTRX cascade constraints;
drop table COMMODITE cascade constraints;
drop table AYANT cascade constraints;
drop table CHAMBRE cascade constraints;
drop table DEPART cascade constraints;
drop table TYPECHAM cascade constraints;
drop table LOCALISATION cascade constraints; 

drop sequence SEQ;


/*--------------------------CREATION------------------------------------------*/
create sequence SEQ;

create table TYPECHAM
(
    CodTypCha varchar2(2) not null,
    DescTyp varchar2(25),
    NbDispo number(3,0),
    constraint PK_CodTypCha primary Key(CodTypCha)
);


create table LOCALISATION
(
    CodLoc varchar2(2) not null,
    DescLoc varchar2(25),
    constraint PK_CodLoc primary Key(CodLoc)
);

create table CLIENT
(
    IdCli number(5,0) not null,
    Nom varchar2(25),
    Adresse varchar2(50),
    Telephone varchar2(10),
    NoCarte varchar2(16),
    TypeCarte varchar2(15),
    DateExp date,
    fax varchar2(10),
    Solde_Du number(12,2),
    constraint PK_IdCli primary Key(IdCli)
);

create table RESERVATION
(
    IdReser number(5,0) not null,
    FKIdCli number(5,0),
    dateReser Date,
    dateDebut Date,
    dateFin Date,
    constraint PK_IdReser primary Key(IdReser),
    constraint FK_RESERVATION_CLIENT_IdCli foreign key (FKIdCli)
      references CLIENT (IdCli)
);


create table CHAMBRE
(
    NoCham varchar2(3) not null,
    Etage varchar2(2),
    Prix number(5,2),
    Etat number(1,0),
    FKCodTypCha varchar2(2),
    FKCodLoc varchar2(2),
    Memo varchar2(255),
    constraint PK_NoCham primary Key(NoCham),
    constraint FK_CHAMBRE_TYPECHAM_CodTypCha foreign key (FKCodTypCha)
      references TYPECHAM (CodTypCha),
    constraint FK_CHAMBRE_LOCALISATION_CodLoc foreign key (FKCodLoc)
      references LOCALISATION (CodLoc)
);


create table ARRIVE
(
    NoArrive number(5,0) not null,
    FKIdReser number(5,0),
    FKIdCli number(5,0),
    FKNoCham varchar2(3),
    DateArrive date,
    constraint PK_NoArrive primary Key(NoArrive),
    constraint FK_ARRIVE_CLIENT_IdCli foreign key (FKIdCli)
      references CLIENT (IdCli),
    constraint FK_ARRIVE_RESERVATION_IdReser foreign key (FKIdReser)
      references RESERVATION (IdReser),
    constraint FK_ARRIVE_CHAMBRE_NoCham foreign key (FKNoCham)
      references CHAMBRE (NoCham)
);


create table DE
(
    FKIdReser number(5,0),
    FKNoCham varchar2(3),
    Attribuee number(1,0),
    constraint PK_FKIdReser_FKNoCham primary Key(FKIdReser, FKNoCham),
    constraint FK_DE_RESERVATION_IdReser foreign key (FKIdReser)
      references RESERVATION (IdReser),
    constraint FK_DE_CHAMBRE_NoCham foreign key (FKNoCham)
      references CHAMBRE (NoCham)
);


create table TYPTRX
(
    CodTypTrx varchar2(2) not null,
    DescTrx varchar2(25),
    NatureTrx varchar2(2),
    constraint PK_CodTypTrx primary Key(CodTypTrx)
);

create table TRX
(
    IdTrx number(5,0) not null,
    FKIdReser number(5,0),
    FKIdCli number(5,0),
    DateTrx date,
    MontantTrx number(10,2),
    FKCodTypTrx varchar2(2),
    Reporte number(1,0),
    NoFact number(5,0),
    DateFact date,
    FKNoCham varchar2(3),
    constraint PK_IdTrx primary Key(IdTrx),
    constraint FK_TRX_CLIENT_IdCli foreign key (FKIdCli)
      references CLIENT (IdCli),
    constraint FK_TRX_RESERVATION_IdReser foreign key (FKIdReser)
      references RESERVATION (IdReser),
    constraint FK_TRX_CHAMBRE_NoCham foreign key (FKNoCham)
      references CHAMBRE (NoCham),
    constraint FK_TRX_TYPTRX_CodTypTrx foreign key (FKCodTypTrx)
      references TYPTRX (CodTypTrx)
);



create table COMMODITE
(
    CodCom varchar2(2) not null,
    DescCom varchar2(25),
    constraint PK_CodCom primary Key(CodCom)
);



create table AYANT
(
    FKNoCham varchar2(3),
    FKCodCom varchar2(2),
    constraint PK_FKNoCham_FKCodCom primary Key(FKNoCham, FKCodCom),
    constraint FK_AYANT_CHAMBRE_NoCham foreign key (FKNoCham)
      references CHAMBRE (NoCham),
    constraint FK_AYANT_COMMODITE_CodCom foreign key (FKCodCom)
      references COMMODITE (CodCom)
);


create table DEPART
(
    NoDepart number(5,0) not null,
    FKIdReser number(5,0),
    FKIdCli number(5,0),
    FKNoCham varchar2(3),
    DateDepart date,
    ConfirmePar varchar2(2),
    constraint PK_NoDepart primary Key(NoDepart),
    constraint FK_DEPART_CLIENT_IdCli foreign key (FKIdCli)
      references CLIENT (IdCli),
    constraint FK_DEPART_RESERVATION_IdReser foreign key (FKIdReser)
      references RESERVATION (IdReser),
    constraint FK_DEPART_CHAMBRE_NoCham foreign key (FKNoCham)
      references CHAMBRE (NoCham)
);


commit;
