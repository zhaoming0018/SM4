sonar:sonar -Dsonar.host.url=http://192.168.99.100:9000 -Dsonar.login=c58fc196d73c868f5c3d194e7ddf1b4eff77d206 -Dsonar.java.binaries=target/classes
mvn org.jacoco:jacoco-maven-plugin:prepare-agent clean install