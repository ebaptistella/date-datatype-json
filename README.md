# date-datatype-json
Serialize/Deserialize data type Date/LocalDate/LocalDateTime and LocalTime with spring boot and jackson

### Using cURL for request

Request for server using the port **8080**, request for consummer port is **8081**. 

##### With parameter date+time and formatter

```bash
$ curl -X GET -Ss -H "Content-Type: application/json" -H "Accept: application/json" 127.0.0.1:8080/date-datatype-json-server/transfer?dateTime=2019-11-28%2014:53:12.001&format=yyyy-MM-dd%20HH:mm:ss.SSS
```

##### Date and Time parameter only

```bash
$ curl -X GET -Ss -H "Content-Type: application/json" -H "Accept: application/json" 127.0.0.1:8080/date-datatype-json-server/transfer?dateTime=2019-11-28%2014:53:12.001
```

##### Full parameters, Date, Time, Formatter and Zone ID

```bash
$ curl -X GET -Ss -H "Content-Type: application/json" -H "Accept: application/json" 127.0.0.1:8080/date-datatype-json-server/transfer?dateTime=2019-11-28%2014:53:12.001&format=yyyy-MM-dd%20HH:mm:ss.SSS&zoneID=America/Sao_Paulo
```

