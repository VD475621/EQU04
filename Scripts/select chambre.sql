select c.NOCHAM, c.ETAGE,c.PRIX,c.FKCODTYPCHA,c.FKCODLOC, r.IDRESER, r.DATEDEBUT, r.DATEFIN, sysdate-4, sysdate+1,1
from Chambre c, Reservation r, De d
where c.Nocham=d.FKNOCHAM and d.FKIDRESER=r.IDRESER
and (sysdate-4>r.DATEFIN or sysdate+1<r.DATEDEBUT);

  --sysdate-4 sysdate+1 070 080

select c.NOCHAM, c.ETAGE,c.PRIX,c.FKCODTYPCHA,c.FKCODLOC, r.IDRESER, r.DATEDEBUT, r.DATEFIN, sysdate-10, sysdate+15,2
from Chambre c, Reservation r, De d
where c.Nocham=d.FKNOCHAM and d.FKIDRESER=r.IDRESER
and not(sysdate-10>r.DATEDEBUT and sysdate-10<r.DATEFIN) and not(sysdate+15<r.DATEFIN and sysdate+15>r.DATEDEBUT);


select c.NOCHAM, c.ETAGE,c.PRIX,c.FKCODTYPCHA,c.FKCODLOC, r.IDRESER, r.DATEDEBUT, r.DATEFIN, sysdate-4, sysdate+1,3
from Chambre c, Reservation r, De d
where c.Nocham=d.FKNOCHAM and d.FKIDRESER=r.IDRESER
and (r.DATEDEBUT<sysdate-4 and r.DATEFIN<sysdate+1
  or r.DATEDEBUT>sysdate-4 and r.DATEFIN>sysdate+1);



select de.attribuee,  sysdate-10,sysdate+15 from de;
