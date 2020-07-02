docker pull wnameless/oracle-xe-11g-r2
docker run --name ms-oracle -d -p 1522:1521 -p 8081:8080 wnameless/oracle-xe-11g-r2
docker exec -it ms-oracle /bin/bash
sqlplus sys/oracle@//localhost:1521/XE as sysdba

docker cp [LOCAL_DIRECTORY]/taller_ms.sql ms-oracle:/home/taller_ms.sql
docker cp [LOCAL_DIRECTORY]/hr_main.sql ms-oracle:/home/hr_main.sql
docker cp [LOCAL_DIRECTORY]/hr_cre.sql ms-oracle:/home/hr_cre.sql
docker cp [LOCAL_DIRECTORY]/hr_popul.sql ms-oracle:/home/hr_popul.sql
docker cp [LOCAL_DIRECTORY]/hr_idx.sql ms-oracle:/home/hr_idx.sql
docker cp [LOCAL_DIRECTORY]/hr_comnt.sql ms-oracle:/home/hr_comnt.sql
docker cp [LOCAL_DIRECTORY]/hr_analz.sql ms-oracle:/home/hr_analz.sql
docker cp [LOCAL_DIRECTORY]/mkverify.sql ms-oracle:/home/mkverify.sql

docker exec -it ms-oracle /bin/bash

sqlplus sys/oracle@//localhost:1521/XE as sysdba

@/home/taller_ms.sql oracle oracle hrpw SYSTEM TEMP /home/log/ localhost:1521/XE

-- @/home/mksample <SYSTEM_password> <SYS_password> <HR_password> EXAMPLE TEMP $ORACLE_HOME/demo/schema/log/ localhost:1521/pdb