# LibraryApplication-Spring

Spring Framework based application.

### Requirements

- JDK 1.8
- Maven
- MySQL

### Clone
```sh
git clone https://github.com/FYalcincosar/LibraryApplication-Spring.git
```
### Build

```sh
mvn clean install
```
### Create Database
```sh
create database library;
```
[Check out application.properties](https://github.com/FYalcincosar/LibraryApplication-Spring/blob/main/src/main/resources/application.properties)
### Deploy the WAR to Tomcat
Go to WAR location

```sh
cd .../LibraryExample/target
```

Copy the LibraryExample.war file and paste it inside the webapps folder of the Tomcat

```sh
sudo cp LibraryExample-1.0.war /opt/apache-tomcat-9/webapps
```

Start Tomcat

```sh
sudo /opt/apache-tomcat-9/bin/startup.sh
```

