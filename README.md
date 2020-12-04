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


### Rest APIs : Postman
#### Create Score (POST)
Request URL: http://localhost:8080/create-score

Request Body Example: JSON
```sh
{
    "playerName": "DHONI",
    "score": 150,
    "scoreCreatedDateTime": "2018-11-21T11:13:13.276"
}
```

#### Get Score (GET)
Request URL: http://localhost:8080/score/{id}
Example: http://localhost:8080/score/2

#### Delete Score (DELETE)
Request URL: http://localhost:8080/score/{id}
Example: http://localhost:8080/score/2

#### Get list of scores

Request URL: http://localhost:8080s/score/score-list
Query Params: 1) scoreCreatedBeforeDateTime OR scoreCreatedAfterDateTime OR listOfPlayers
And page
AND size

Example: 
http://localhost:8080/score/score-list?scoreCreatedBeforeDateTime=2018-12-21T11:13:13.274&page=0&size=10
http://localhost:8080/score/score-list?scoreCreatedAfterDateTime=2018-01-21T01:13:13.274&page=0&size=10
http://localhost:8080/score/score-list?listOfPlayers=DHONI&page=0&size=2

#### Get players' history
Request URL: http://localhost:8080//player-history/{playerName}
Example: http://localhost:8080/player-history/DHONI


