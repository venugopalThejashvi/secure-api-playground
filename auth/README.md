### register
```bash

curl --location 'http://localhost:8080/auth/register' \
--header 'accept: */*' \
--header 'Content-Type: application/json' \
--data '{
"username" : "TEST",
"password" : "TEST",
"role" : "ADMIN"
}'
```
### login
```bash

curl --location 'http://localhost:8080/auth/login' \
--header 'accept: */*' \
--header 'Content-Type: application/json' \
--data '{
"username" : "TEST",
"password" : "TEST"
}'
```

### health check(with jwt)
```bash

curl --location 'http://localhost:8080/health' \
--header 'accept: */*' \
--header 'Authorization: Bearer {{token}}'
```