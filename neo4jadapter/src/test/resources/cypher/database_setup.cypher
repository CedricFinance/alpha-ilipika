// Creating nodes
CREATE (n:Application {name:"Alpha"}) RETURN n;
CREATE (n:Application {name:"PRB"}) RETURN n;
CREATE (n:Application {name:"Flash"}) RETURN n;
CREATE (n:Application {name:"Tessa"}) RETURN n;

// Creating relationships between the nodes
match(n:Application), (m:Application) where n.name="Alpha" and m.name="PRB" create (n)-[r:CONNECTED_TO]->(m) return n, m;
match(n:Application), (m:Application) where n.name="PRB" and m.name="Flash" create (n)-[r:CONNECTED_TO]->(m) return n, m;
match(n:Application), (m:Application) where n.name="Flash" and m.name="Tessa" create (n)-[r:CONNECTED_TO]->(m) return n, m;