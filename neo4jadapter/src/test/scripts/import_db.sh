#!/bin/sh

PROJECT_HOME="$HOME/dev/projets/alpha-ilipika"
NEO4J_HOME="$HOME/dev/sysex/neo4j/neo4j-community-2.2.2/"
DESTINATION_DB_FILE=$1

if [ $# -ne 1 ]
then
  echo "No argument. Defaulting to our_default.db"
  DESTINATION_DB_FILE="our_default.db"
fi

"$NEO4J_HOME"/bin/neo4j-import --into $DESTINATION_DB_FILE --nodes "$PROJECT_HOME/neo4jadapter/src/test/resources/data/shell/feeder/applications.csv" --relationships "$PROJECT_HOME/neo4jadapter/src/test/resources/data/shell/feeder/connected_to.csv"
