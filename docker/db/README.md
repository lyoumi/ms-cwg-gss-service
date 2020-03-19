1. docker-compose up
1. docker-compose exec cwd-mongo-primary mongo -u "root" -p "pass"
1. rs.initiate({"_id" : "cwd-replica-set","members" : [{"_id" : 0,"host" : "cwd-mongo-primary:27017"},{"_id" : 1,"host" : "cwd-mongo-worker-1:27017"},{"_id" : 2,"host" : "cwd-mongo-worker-2:27017"},{"_id" : 3,"host" : "cwd-mongo-worker-3:27017"}]});
1. conf = rs.config();
1. conf.members[0].priority = 2;
1. rs.reconfig(conf);
1. use admin;
1. db.createUser({user: "cluster_admin",pwd: "password",roles: [ { role: "userAdminAnyDatabase", db: "admin" },  { "role" : "clusterAdmin", "db" : "admin" } ]});
db.auth("cluster_admin", "password");
1. use crossworld;
1. db.createUser({user: "service_user",pwd: "password",roles: [ { role: "readWrite", db: "my_data" } ]});
