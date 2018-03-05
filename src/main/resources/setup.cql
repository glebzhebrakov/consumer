CREATE KEYSPACE poc WITH REPLICATION = { 'class' : 'SimpleStrategy', 'replication_factor' : 1 };
create table poc.testmessage(id text PRIMARY KEY, payload text, timestamp timestamp);
