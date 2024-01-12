# Leads_API

Due to the simple nature of project, I have not created service layer. I am direly calling repository layer from controller layer. 

Please use the following CURL request to test API
Feel free to change data

1. Check save lead API
   curl --location 'http://localhost:8080/api/v1/leads/' \
--header 'Content-Type: application/json' \
--data-raw '{
  "leadId": "5678",
  "firstName": "Vineet",
  "middleName": "",
  "lastName": "KV",
  "mobileNumber": "8877887788",
  "Gender": "Male",
  "DOB": dd/mm/yyyy
  "email": "v@gmail.com"
}'

2. Fetch leads based on Mobile number API
   curl --location 'http://localhost:8080/api/v1/leads/8877887788'

