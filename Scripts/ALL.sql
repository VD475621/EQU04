@Creation.sql;
@Insertion.sql;
@View.sql;
@trigger_reservation_delete.sql;

Grant all privileges on DE to EQU04COMMIS;
Grant all privileges on ARRIVE to EQU04COMMIS;
Grant all privileges on AYANT to EQU04COMMIS;
Grant all privileges on CHAMBRE to EQU04COMMIS;
Grant all privileges on CLIENT to EQU04COMMIS;
Grant all privileges on COMMODITE to EQU04COMMIS;
Grant all privileges on DEPART to EQU04COMMIS;
Grant all privileges on LOCALISATION to EQU04COMMIS;
Grant all privileges on RESERVATION to EQU04COMMIS;
Grant all privileges on TEMP_CHAMBRE to EQU04COMMIS;
Grant all privileges on TRX to EQU04COMMIS;
Grant all privileges on TYPECHAM to EQU04COMMIS;
Grant all privileges on TYPTRX to EQU04COMMIS;

Grant all privileges on DE to EQU04GERANT;
Grant all privileges on ARRIVE to EQU04GERANT;
Grant all privileges on AYANT to EQU04GERANT;
Grant all privileges on CHAMBRE to EQU04GERANT;
Grant all privileges on CLIENT to EQU04GERANT;
Grant all privileges on COMMODITE to EQU04GERANT;
Grant all privileges on DEPART to EQU04GERANT;
Grant all privileges on LOCALISATION to EQU04GERANT;
Grant all privileges on RESERVATION to EQU04GERANT;
Grant all privileges on TEMP_CHAMBRE to EQU04GERANT;
Grant all privileges on TRX to EQU04GERANT;
Grant all privileges on TYPECHAM to EQU04GERANT;
Grant all privileges on TYPTRX to EQU04GERANT;

commit;