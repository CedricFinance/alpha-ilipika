load csv with headers from "file:///home/pacman/dev/projets/alpha-ilipika/neo4jadapter/src/test/resources/data/feeder/applications.csv" as csvLine
create(a:Application{id:toInt(csvLine.id), name:csvLine.name});

create constraint on (a:Application) assert a.id is unique;

load csv with headers from "file:///home/pacman/dev/projets/alpha-ilipika/neo4jadapter/src/test/resources/data/feeder/connected_to.csv" as csvLine
match (a_from:Application{id: toInt(csvLine.application_from_id)}),(a_to:Application{id: toInt(csvLine.application_to_id)})
create (a_from)-[:CONNECTED_TO]->(a_to);

drop constraint on (a:Application) assert a.id is unique;

match (a)
where a:Application
remove a.id;