# topscore-rest-api
Top Score Rest API
============================
### Application source structure
```
The application source structure is as follows.
.
+-- src                                 # Source folder for x largest numbers
+-- Dockerfile                          # Docker file for application
+-- pom.xml                             # Applicaton pom file
+-- README.MD
```


### git clone 
```sh
git clone https://github.com/rishabhkatyal60/topscore-rest-api.git
```

### Using Docker

### 1. Change Directory

```sh
cd topscore-rest-api
```

### 2. Build Docker Image

```sh
docker build -t topscore-rest-api .
```

### 3. Run Docker Image

```sh
docker run -p 8080:8080 topscore-rest-api
```

### Using Maven


### 1. Change Directory

```sh
cd topscore-rest-api
```

### 2. Maven Build

```sh
mvn clean package
```

### 3. Run Application

```sh
topscore-rest-api-1.0-SNAPSHOT.jar
```


