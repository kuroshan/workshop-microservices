docker cp [DIRECTORY]/taller_ms.sql oraclexe:/home/taller_ms.sql
docker cp [DIRECTORY]/hr_main.sql oraclexe:/home/hr_main.sql
docker cp [DIRECTORY]/hr_cre.sql oraclexe:/home/hr_cre.sql
docker cp [DIRECTORY]/hr_popul.sql oraclexe:/home/hr_popul.sql
docker cp [DIRECTORY]/hr_idx.sql oraclexe:/home/hr_idx.sql
docker cp [DIRECTORY]/hr_comnt.sql oraclexe:/home/hr_comnt.sql
docker cp [DIRECTORY]/hr_analz.sql oraclexe:/home/hr_analz.sql
docker cp [DIRECTORY]/mkverify.sql oraclexe:/home/mkverify.sql

docker exec -it oraclexe /bin/bash

sqlplus sys/admin@//localhost:1521/XE as sysdba

-- @/home/mksample <SYSTEM_password> <SYS_password> <HR_password> EXAMPLE TEMP $ORACLE_HOME/demo/schema/log/ localhost:1521/pdb
@/home/taller_ms admin admin hrpw SYSTEM TEMP [DIRECTORY]/log/ localhost:1521/XE
