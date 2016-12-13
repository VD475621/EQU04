DELETE FROM DE;
DELETE FROM AYANT;
DELETE FROM ARRIVE;
DELETE FROM DEPART;
DELETE FROM TRX;
DELETE FROM CHAMBRE;
DELETE FROM TYPECHAM;
DELETE FROM LOCALISATION;
DELETE FROM TYPTRX;
DELETE FROM RESERVATION;
DELETE FROM CLIENT;
DELETE FROM COMMODITE;


insert into CLIENT (IdCli, Nom, Adresse, Telephone, NoCarte, TypeCarte, DateExp, Fax, Solde_du) values (SEQ_Client.nextval, 'Richard Burton', '972 Shelley Avenue', '8277390001', '35645980543', 'jcb', sysdate+10, '2452530671', 621.51);
insert into CLIENT (IdCli, Nom, Adresse, Telephone, NoCarte, TypeCarte, DateExp, Fax, Solde_du) values (SEQ_Client.nextval, 'Joe Fowler', '5906 Sommers Terrace', '7732465841', '401795737420', 'visa', sysdate+10, '8559778652', 642.80);
insert into CLIENT (IdCli, Nom, Adresse, Telephone, NoCarte, TypeCarte, DateExp, Fax, Solde_du) values (SEQ_Client.nextval, 'Julie Sanders', '5 Larry Park', '6728872961', '2016940236881', 'diners-club', sysdate+10, '9986517224', 17.48);
insert into CLIENT (IdCli, Nom, Adresse, Telephone, NoCarte, TypeCarte, DateExp, Fax, Solde_du) values (SEQ_Client.nextval, 'Frances Gordon', '79531 Larry Junction', '3605610399', '3020559085', 'diners-club', sysdate+10, '7614505033', 489.32);
insert into CLIENT (IdCli, Nom, Adresse, Telephone, NoCarte, TypeCarte, DateExp, Fax, Solde_du) values (SEQ_Client.nextval, 'Brian Armstrong', '32015 Truax Drive', '8302485429', '357225253371', 'jcb', sysdate+10, '9126981758', 90.41);
insert into CLIENT (IdCli, Nom, Adresse, Telephone, NoCarte, TypeCarte, DateExp, Fax, Solde_du) values (SEQ_Client.nextval, 'Todd Sullivan', '70064 Pond Place', '7313409466', '535450395591', 'mastercard', sysdate+10, '4115757658', 81.03);
insert into CLIENT (IdCli, Nom, Adresse, Telephone, NoCarte, TypeCarte, DateExp, Fax, Solde_du) values (SEQ_Client.nextval, 'Martin Martin', '7812 Summit Alley', '5613207615', '560223801370', 'china-unionpay', sysdate+10, '3015844657', 181.94);
insert into CLIENT (IdCli, Nom, Adresse, Telephone, NoCarte, TypeCarte, DateExp, Fax, Solde_du) values (SEQ_Client.nextval, 'Deborah Stevens', '518 Lyons Center', '1705522489', '353823996963', 'jcb', sysdate+10, '7578237259', 211.45);
insert into CLIENT (IdCli, Nom, Adresse, Telephone, NoCarte, TypeCarte, DateExp, Fax, Solde_du) values (SEQ_Client.nextval, 'Shawn Patterson', '5 Northview Plaza', '3487249539', '35445444673', 'jcb', sysdate+10, '9251022640', 632.49);
insert into CLIENT (IdCli, Nom, Adresse, Telephone, NoCarte, TypeCarte, DateExp, Fax, Solde_du) values (SEQ_Client.nextval, 'Roger Phillips', '695 Memorial Place', '8568585279', '35866125498', 'jcb', sysdate+10, '3295367571', 268.73);

insert into COMMODITE(CodCom, DescCom) values ('AS', 'Standards');
insert into COMMODITE(CodCom, DescCom) values ('BA', 'avec balcon');
insert into COMMODITE(CodCom, DescCom) values ('BT', 'bain tourbillon');
insert into COMMODITE(CodCom, DescCom) values ('CC', 'chambre communicante');
insert into COMMODITE(CodCom, DescCom) values ('IN', 'internet');
insert into COMMODITE(CodCom, DescCom) values ('MB', 'mini-bar');
insert into COMMODITE(CodCom, DescCom) values ('HP', 'handicap�');
insert into COMMODITE(CodCom, DescCom) values ('NF', 'non-fumeur');

insert into TYPECHAM(CodTypCha, DescType, NbDispo) values ('1J', '1 lit jumeau', 3);
insert into TYPECHAM(CodTypCha, DescType, NbDispo) values ('2J', '2 lits jumeaux', 3);
insert into TYPECHAM(CodTypCha, DescType, NbDispo) values ('1D', '1 lit double', 4);
insert into TYPECHAM(CodTypCha, DescType, NbDispo) values ('2D', '2 lits doubles', 3);
insert into TYPECHAM(CodTypCha, DescType, NbDispo) values ('LQ', 'lit queen', 1);
insert into TYPECHAM(CodTypCha, DescType, NbDispo) values ('LK', 'lit king', 2);
insert into TYPECHAM(CodTypCha, DescType, NbDispo) values ('ST', 'suite', 2);
insert into TYPECHAM(CodTypCha, DescType, NbDispo) values ('SR', 'salle reception', 2);

insert into LOCALISATION(CodLoc, DescLoc) values('AR', 'arriere');
insert into LOCALISATION(CodLoc, DescLoc) values('AS', 'pres de l ascenceur');
insert into LOCALISATION(CodLoc, DescLoc) values('AV', 'avant');
insert into LOCALISATION(CodLoc, DescLoc) values('VM', 'vue sur la mer');
insert into LOCALISATION(CodLoc, DescLoc) values('SM', 'pres de la salle a manger');

INSERT INTO Chambre VALUES('010','01',600, 1, '1J','AR',' ');
INSERT INTO Chambre VALUES('020','01',900, 1, '2J','AR',' ');
INSERT INTO Chambre VALUES('030','01',300, 1, '1D','AS',' ');
INSERT INTO Chambre VALUES('040','01',400, 1, '2D','AS',' ');
INSERT INTO Chambre VALUES('050','01',500, 1, 'LQ','AV',' ');
INSERT INTO Chambre VALUES('060','01',700, 1, 'LK','AV',' ');
INSERT INTO Chambre VALUES('070','01',800, 1, 'ST','VM',' ');
INSERT INTO Chambre VALUES('080','01',900, 1, 'SR','VM',' ');
INSERT INTO Chambre VALUES('090','01',200, 1, '1J','SM',' ');
INSERT INTO Chambre VALUES('100','02',100, 1, '2J','SM',' ');
INSERT INTO Chambre VALUES('110','02',200, 1, '1D','AR',' ');
INSERT INTO Chambre VALUES('120','02',900, 1, '2D','SM',' ');
INSERT INTO Chambre VALUES('130','02',400, 1, '1J','SM',' ');
INSERT INTO Chambre VALUES('140','02',350, 1, '2J','SM',' ');
INSERT INTO Chambre VALUES('150','02',250, 1, '2D','SM',' ');
INSERT INTO Chambre VALUES('160','02',400, 1, '1D','SM',' ');
INSERT INTO Chambre VALUES('170','02',500, 1, 'LK','SM',' ');
INSERT INTO Chambre VALUES('180','02',700, 1, 'ST','SM',' ');
INSERT INTO Chambre VALUES('190','02',750, 1, 'SR','SM',' ');
INSERT INTO Chambre VALUES('210','03',450, 1, '1D','AR',' ');




INSERT INTO RESERVATION(IdReser,FKIdCli,dateReser,dateDebut,dateFin) VALUES(SEQ_Reservation.nextval, 1, sysdate-15, sysdate-10, sysdate+15);
INSERT INTO RESERVATION(IdReser,FKIdCli,dateReser,dateDebut,dateFin) VALUES(SEQ_Reservation.nextval,2,sysdate-5,sysdate+5,sysdate+10);
INSERT INTO RESERVATION(IdReser,FKIdCli,dateReser,dateDebut,dateFin) VALUES(SEQ_Reservation.nextval,3,sysdate-6,sysdate+4,sysdate+9);
INSERT INTO RESERVATION(IdReser,FKIdCli,dateReser,dateDebut,dateFin) VALUES(SEQ_Reservation.nextval,4,sysdate-7,sysdate+3,sysdate+8);
INSERT INTO RESERVATION(IdReser,FKIdCli,dateReser,dateDebut,dateFin) VALUES(SEQ_Reservation.nextval,5,sysdate-14,sysdate-4,sysdate+1);
INSERT INTO RESERVATION(IdReser,FKIdCli,dateReser,dateDebut,dateFin) VALUES(SEQ_Reservation.nextval,6,sysdate-15,sysdate-5,sysdate+1);
INSERT INTO RESERVATION(IdReser,FKIdCli,dateReser,dateDebut,dateFin) VALUES(SEQ_Reservation.nextval,7,sysdate-16,sysdate-6,sysdate+1);
INSERT INTO RESERVATION(IdReser,FKIdCli,dateReser,dateDebut,dateFin) VALUES(SEQ_Reservation.nextval,8,sysdate-17,sysdate-7,sysdate-2);
INSERT INTO RESERVATION(IdReser,FKIdCli,dateReser,dateDebut,dateFin) VALUES(SEQ_Reservation.nextval,9,sysdate-18,sysdate-8,sysdate-3);
INSERT INTO RESERVATION(IdReser,FKIdCli,dateReser,dateDebut,dateFin) VALUES(SEQ_Reservation.nextval,10,sysdate-19,sysdate-9,sysdate-4);
INSERT INTO RESERVATION(IdReser,FKIdCli,dateReser,dateDebut,dateFin) VALUES(SEQ_Reservation.nextval,1,sysdate-20,sysdate-10,sysdate-5);
INSERT INTO RESERVATION(IdReser,FKIdCli,dateReser,dateDebut,dateFin) VALUES(SEQ_Reservation.nextval,2,sysdate-21,sysdate-11,sysdate-6);
INSERT INTO RESERVATION(IdReser,FKIdCli,dateReser,dateDebut,dateFin) VALUES(SEQ_Reservation.nextval,3,sysdate-22,sysdate-12,sysdate-7);
INSERT INTO RESERVATION(IdReser,FKIdCli,dateReser,dateDebut,dateFin) VALUES(SEQ_Reservation.nextval,4,sysdate-23,sysdate-13,sysdate);
INSERT INTO RESERVATION(IdReser,FKIdCli,dateReser,dateDebut,dateFin) VALUES(SEQ_Reservation.nextval,5,sysdate-24,sysdate-14,sysdate-12);
INSERT INTO RESERVATION(IdReser,FKIdCli,dateReser,dateDebut,dateFin) VALUES(SEQ_Reservation.nextval,6,sysdate-25,sysdate-15,sysdate-13);
INSERT INTO RESERVATION(IdReser,FKIdCli,dateReser,dateDebut,dateFin) VALUES(SEQ_Reservation.nextval,7,sysdate-26,sysdate-16,sysdate-13);
INSERT INTO RESERVATION(IdReser,FKIdCli,dateReser,dateDebut,dateFin) VALUES(SEQ_Reservation.nextval,8,sysdate-27,sysdate-17,sysdate-13);
INSERT INTO RESERVATION(IdReser,FKIdCli,dateReser,dateDebut,dateFin) VALUES(SEQ_Reservation.nextval,9,sysdate-28,sysdate-18,sysdate-13);
INSERT INTO RESERVATION(IdReser,FKIdCli,dateReser,dateDebut,dateFin) VALUES(SEQ_Reservation.nextval,10,sysdate-29,sysdate-19,sysdate-14);

insert into ARRIVE(NoArrive,FKIdReser,FKIdCli,FKNoCham,dateArrive) values(SEQ_Arrive.nextval, 5, 5, '070', sysdate-4);
insert into ARRIVE(NoArrive,FKIdReser,FKIdCli,FKNoCham,dateArrive) values(SEQ_Arrive.nextval, 6, 6, '080', sysdate-5);
insert into ARRIVE(NoArrive,FKIdReser,FKIdCli,FKNoCham,dateArrive) values(SEQ_Arrive.nextval, 7, 7, '090', sysdate-6);
insert into ARRIVE(NoArrive,FKIdReser,FKIdCli,FKNoCham,dateArrive) values(SEQ_Arrive.nextval, 8, 8, '100', sysdate-7);
insert into ARRIVE(NoArrive,FKIdReser,FKIdCli,FKNoCham,dateArrive) values(SEQ_Arrive.nextval, 9, 9, '110', sysdate-8);
insert into ARRIVE(NoArrive,FKIdReser,FKIdCli,FKNoCham,dateArrive) values(SEQ_Arrive.nextval, 10, 10, '120', sysdate-9);
insert into ARRIVE(NoArrive,FKIdReser,FKIdCli,FKNoCham,dateArrive) values(SEQ_Arrive.nextval, 11, 1, '130', sysdate-10);
insert into ARRIVE(NoArrive,FKIdReser,FKIdCli,FKNoCham,dateArrive) values(SEQ_Arrive.nextval, 12, 2, '140', sysdate-11);
insert into ARRIVE(NoArrive,FKIdReser,FKIdCli,FKNoCham,dateArrive) values(SEQ_Arrive.nextval, 13, 3, '150', sysdate-12);
insert into ARRIVE(NoArrive,FKIdReser,FKIdCli,FKNoCham,dateArrive) values(SEQ_Arrive.nextval, 14, 4, '160', sysdate-13);
insert into ARRIVE(NoArrive,FKIdReser,FKIdCli,FKNoCham,dateArrive) values(SEQ_Arrive.nextval, 15, 5, '170', sysdate-14);
insert into ARRIVE(NoArrive,FKIdReser,FKIdCli,FKNoCham,dateArrive) values(SEQ_Arrive.nextval, 16, 6, '180', sysdate-15);
insert into ARRIVE(NoArrive,FKIdReser,FKIdCli,FKNoCham,dateArrive) values(SEQ_Arrive.nextval, 17, 7, '190', sysdate-16);
insert into ARRIVE(NoArrive,FKIdReser,FKIdCli,FKNoCham,dateArrive) values(SEQ_Arrive.nextval, 18, 8, '010', sysdate-17);
insert into ARRIVE(NoArrive,FKIdReser,FKIdCli,FKNoCham,dateArrive) values(SEQ_Arrive.nextval, 18, 6, '020', sysdate-17);
--insert into ARRIVE(NoArrive,FKIdReser,FKIdCli,FKNoCham,dateArrive) values(SEQ_Arrive.nextval, 19, 9, '030', sysdate-18);
insert into ARRIVE(NoArrive,FKIdReser,FKIdCli,FKNoCham,dateArrive) values(SEQ_Arrive.nextval, 20, 10, '040', sysdate-19);
--insert into ARRIVE(NoArrive,FKIdReser,FKIdCli,FKNoCham,dateArrive) values(SEQ_Arrive.nextval, 20, 13, '050', sysdate-19);


insert into DEPART(NoDepart,FKIdReser,FkIdCli,FKNoCham,dateDepart,ConfirmePar) values(SEQ_Depart.nextval,8,8,'100',sysdate-2,'CG');
insert into DEPART(NoDepart,FKIdReser,FkIdCli,FKNoCham,dateDepart,ConfirmePar) values(SEQ_Depart.nextval,9,9,'110',sysdate-3,'CG');
insert into DEPART(NoDepart,FKIdReser,FkIdCli,FKNoCham,dateDepart,ConfirmePar) values(SEQ_Depart.nextval,10,10,'120',sysdate-4,'VD');
insert into DEPART(NoDepart,FKIdReser,FkIdCli,FKNoCham,dateDepart,ConfirmePar) values(SEQ_Depart.nextval,11,1,'130',sysdate-5,'CG');
insert into DEPART(NoDepart,FKIdReser,FkIdCli,FKNoCham,dateDepart,ConfirmePar) values(SEQ_Depart.nextval,12,2,'140',sysdate-6,'VD');
insert into DEPART(NoDepart,FKIdReser,FkIdCli,FKNoCham,dateDepart,ConfirmePar) values(SEQ_Depart.nextval,13,3,'150',sysdate-7,'CG');
insert into DEPART(NoDepart,FKIdReser,FkIdCli,FKNoCham,dateDepart,ConfirmePar) values(SEQ_Depart.nextval,14,4,'160',sysdate-1,'MQ');
--insert into DEPART(NoDepart,FKIdReser,FkIdCli,FKNoCham,dateDepart,ConfirmePar) values(SEQ_Depart.nextval,15,5,'170',sysdate-12,'VD');
--insert into DEPART(NoDepart,FKIdReser,FkIdCli,FKNoCham,dateDepart,ConfirmePar) values(SEQ_Depart.nextval,16,6,'180',sysdate-13,'MQ');
--insert into DEPART(NoDepart,FKIdReser,FkIdCli,FKNoCham,dateDepart,ConfirmePar) values(SEQ_Depart.nextval,17,7,'190',sysdate-13,'VD');
insert into DEPART(NoDepart,FKIdReser,FkIdCli,FKNoCham,dateDepart,ConfirmePar) values(SEQ_Depart.nextval,18,8,'010',sysdate-13,'CG');
insert into DEPART(NoDepart,FKIdReser,FkIdCli,FKNoCham,dateDepart,ConfirmePar) values(SEQ_Depart.nextval,18,6,'020',sysdate-13,'CG');
--insert into DEPART(NoDepart,FKIdReser,FkIdCli,FKNoCham,dateDepart,ConfirmePar) values(SEQ_Depart.nextval,19,9,'030',sysdate-13,'CG');
--insert into DEPART(NoDepart,FKIdReser,FkIdCli,FKNoCham,dateDepart,ConfirmePar) values(SEQ_Depart.nextval,20,10,'040',sysdate-14,'CG');
--insert into DEPART(NoDepart,FKIdReser,FkIdCli,FKNoCham,dateDepart,ConfirmePar) values(SEQ_Depart.nextval,20,13,'050',sysdate-14,'CG');


INSERT INTO TYPTRX(CODTYPTRX, DESCTRX, NatureTrx) values ('01', 'Prix de la chambre', 'DB');
INSERT INTO TYPTRX(CODTYPTRX, DESCTRX, NatureTrx) values ('02', 'Lit additionnel', 'DB');
INSERT INTO TYPTRX(CODTYPTRX, DESCTRX, NatureTrx) values ('10', 'Telephone interurbain', 'DB' );
INSERT INTO TYPTRX(CODTYPTRX, DESCTRX, NatureTrx) values ('21', 'Photocopie', 'DB');
INSERT INTO TYPTRX(CODTYPTRX, DESCTRX, NatureTrx) values ('22', 'Internet', 'DB');
INSERT INTO TYPTRX(CODTYPTRX, DESCTRX, NatureTrx) values ('30', 'Restaurant', 'DB');
INSERT INTO TYPTRX(CODTYPTRX, DESCTRX, NatureTrx) values ('31', 'Bar terrasse', 'DB');
INSERT INTO TYPTRX(CODTYPTRX, DESCTRX, NatureTrx) values ('50', 'Depot argent', 'CR');
INSERT INTO TYPTRX(CODTYPTRX, DESCTRX, NatureTrx) values ('60', 'Paiement', 'CR');

INSERT INTO Trx VALUES(SEQ_Trx.nextval, 5,5,sysdate-4, 60,'02',0,1,sysdate-4,'070');
INSERT INTO Trx VALUES(SEQ_Trx.nextval,5,5,sysdate-4, 30,'10',1,1,sysdate-4,'070');
INSERT INTO Trx VALUES(SEQ_Trx.nextval,8,8,sysdate-7, 46,'10',1,2, sysdate-7,'100');
INSERT INTO Trx VALUES(SEQ_Trx.nextval,9,9,sysdate-8, 306,'21',1,3,sysdate-8,'110');
INSERT INTO Trx VALUES(SEQ_Trx.nextval,10,10,sysdate-9, 904,'22',1,4,sysdate-9,'120');
INSERT INTO Trx VALUES(SEQ_Trx.nextval,11,1,sysdate-10, 218,'30',1,5,sysdate-10,'130');
INSERT INTO Trx VALUES(SEQ_Trx.nextval,11,1,sysdate-10, 218,'22',1,5,sysdate-10,'130');
INSERT INTO Trx VALUES(SEQ_Trx.nextval,11,1,sysdate-10, 218,'31',1,5,sysdate-10,'130');
INSERT INTO Trx VALUES(SEQ_Trx.nextval,12,2,sysdate-11, 50,'31',1,6,sysdate-11,'140');
INSERT INTO Trx VALUES(SEQ_Trx.nextval,13,3,sysdate-12, -480,'50',1,8,sysdate-12,'150');
INSERT INTO Trx VALUES(SEQ_Trx.nextval,14,4,sysdate-13, -792,'60',1,9,sysdate-13,'160');
INSERT INTO Trx VALUES(SEQ_Trx.nextval,15,5,sysdate-14, 652,'01',1,10,sysdate-14,'170');
INSERT INTO Trx VALUES(SEQ_Trx.nextval,16,6,sysdate-15, 605,'02',1,11,sysdate,'180');
INSERT INTO Trx VALUES(SEQ_Trx.nextval,16,6,sysdate-15, -50,'50',1,11,sysdate,'180');
INSERT INTO Trx VALUES(SEQ_Trx.nextval,17,7,sysdate-16, -200,'50',1,12,sysdate,'190');
INSERT INTO Trx VALUES(SEQ_Trx.nextval,18,8,sysdate-17, -200,'50',1,13,sysdate,'010');
INSERT INTO Trx VALUES(SEQ_Trx.nextval,18,8,sysdate-17, -200,'50',1,14,sysdate,'020');
INSERT INTO Trx VALUES(SEQ_Trx.nextval,19,9,sysdate-18, -200,'50',1,15,sysdate,'030');
INSERT INTO Trx VALUES(SEQ_Trx.nextval,20,10,sysdate-19, -200,'50',1,16,sysdate,'040');
INSERT INTO Trx VALUES(SEQ_Trx.nextval,20,10,sysdate-19, 20,'10',1,16,sysdate,'040');
INSERT INTO Trx VALUES(SEQ_Trx.nextval,20,10,sysdate-19, -200,'50',1,16,sysdate,'050');


----------------------------------------------------------------------------------------------------------------------
insert into AYANT(FKNoCham, FKCodCom) values ('010', 'AS');
insert into AYANT(FKNoCham, FKCodCom) values ('010', 'BA');
insert into AYANT(FKNoCham, FKCodCom) values ('020', 'AS');
insert into AYANT(FKNoCham, FKCodCom) values ('020', 'BT');
insert into AYANT(FKNoCham, FKCodCom) values ('030', 'AS');
insert into AYANT(FKNoCham, FKCodCom) values ('030', 'CC');
insert into AYANT(FKNoCham, FKCodCom) values ('040', 'AS');
insert into AYANT(FKNoCham, FKCodCom) values ('040', 'IN');
insert into AYANT(FKNoCham, FKCodCom) values ('050', 'MB');
insert into AYANT(FKNoCham, FKCodCom) values ('060', 'HP');
insert into AYANT(FKNoCham, FKCodCom) values ('070', 'IN');
insert into AYANT(FKNoCham, FKCodCom) values ('080', 'CC');
insert into AYANT(FKNoCham, FKCodCom) values ('090', 'BA');
insert into AYANT(FKNoCham, FKCodCom) values ('100', 'BT');
insert into AYANT(FKNoCham, FKCodCom) values ('110', 'HP');
insert into AYANT(FKNoCham, FKCodCom) values ('120', 'IN');
insert into AYANT(FKNoCham, FKCodCom) values ('130', 'IN');
insert into AYANT(FKNoCham, FKCodCom) values ('140', 'AS');
insert into AYANT(FKNoCham, FKCodCom) values ('140', 'IN');
insert into AYANT(FKNoCham, FKCodCom) values ('150', 'MB');
insert into AYANT(FKNoCham, FKCodCom) values ('160', 'HP');
insert into AYANT(FKNoCham, FKCodCom) values ('170', 'IN');
insert into AYANT(FKNoCham, FKCodCom) values ('180', 'CC');
insert into AYANT(FKNoCham, FKCodCom) values ('190', 'BA');
insert into AYANT(FKNoCham, FKCodCom) values ('210', 'BA');
----------------------------------------------------------------------------------------------------------------------
insert into DE values ( 1, '010' , 0);
insert into DE values ( 1, '020' , 0);
insert into DE values ( 2, '030' , 0);
insert into DE values ( 2, '040' , 0);
insert into DE values ( 3, '050' , 0);
insert into DE values ( 4, '060' , 0);
insert into DE values ( 5, '070' , 1);
insert into DE values ( 6, '080' , 1);
insert into DE values ( 6, '210' , 0);
insert into DE values ( 6, '190' , 0);
insert into DE values ( 7, '090' , 1);
insert into DE values ( 8, '100' , 1);
insert into DE values ( 9, '110' , 1);
insert into DE values ( 10, '120' ,1);
insert into DE values ( 11, '130' , 1);
insert into DE values ( 12, '140' , 1);
insert into DE values ( 13, '150' , 1);
insert into DE values ( 14, '160' , 1);
insert into DE values ( 15, '170' , 1);
insert into DE values ( 16, '180' , 1);
insert into DE values ( 17, '190' , 1);
insert into DE values ( 18, '010' , 1);
insert into DE values ( 18, '020' , 1);
insert into DE values ( 19, '030' , 0);
insert into DE values ( 20, '040' , 1);
insert into DE values ( 20, '050' , 0);


/*
GRANT ALL on DE TO EQU04PRG02;
GRANT ALL on DE TO EQU04PRG02;
GRANT ALL on DE TO EQU04PRG02;
GRANT ALL on DE TO EQU04PRG02;
GRANT ALL on DE TO EQU04PRG02;
GRANT ALL on DE TO EQU04PRG02;
GRANT ALL on DE TO EQU04PRG02;
GRANT ALL on DE TO EQU04PRG02;
GRANT ALL on DE TO EQU04PRG02;
GRANT ALL on DE TO EQU04PRG02;
GRANT ALL on DE TO EQU04PRG02;

GRANT ALL on DE TO EQU04PRG03;
GRANT ALL on DE TO EQU04PRG03;	
GRANT ALL on DE TO EQU04PRG03;
GRANT ALL on DE TO EQU04PRG03;	
GRANT ALL on DE TO EQU04PRG03;	
GRANT ALL on DE TO EQU04PRG03;	
GRANT ALL on DE TO EQU04PRG03;	
GRANT ALL on DE TO EQU04PRG03;	
GRANT ALL on DE TO EQU04PRG03;	
GRANT ALL on DE TO EQU04PRG03;	
*/
commit;
