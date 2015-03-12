mvn clean install
mv core/target/mepbm.war ../../tomcatA/webapps/
mv ../ogsecurity/server/target/ogsecurity.war ../../tomcatA/webapps
mv ../ogsecurity/core/target/ogcore.jar ../../tomcatA/lib/ogcore.jar
