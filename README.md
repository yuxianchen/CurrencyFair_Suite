# CurrencyFair_Suite

#Preparations:
For both Backend and Frontend, they are both Intellij spring-boot maven projects. You can simply open them from your Intellij studio.
Please prepare maven, npm, curl and Nodejs in your operating system.
For Backend app, 
  1) Make sure you have sql server installed and version should be greater than 2012. 
  2) Go to application.properties to modify username(spring.datasource.username) and password (spring.datasource.password) for your sql server instance. 
  3) Go to sql server studio to create db called springbootdb.

#How to start apps:
For Backend app:
1) Simply run CurrencyfairBackendApplication.
	
For Frontend app:
1) Navigate to directory \CurrencyFair_Suite\Currencyfair_Frontend, and run mvn spring-boot:run.
2) Navigate to direcotry src/main/resource, and run npm install. 
3) run npm start.

#For post messages to backend, please use Postman and flow steps below, this is because the app is secured by oauth2.0 password grant.
1) Run curl testjwtclientid:XY7kmzoNzl100@localhost:8080/currencyfair/oauth/token -d grant_type=password -d username=john.doe -d password=jwtpass to generate JWT token. You will receive a response similar to below:

{"access_token":"eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJhdWQiOlsidGVzdGp3dHJlc2
91cmNlaWQiXSwidXNlcl9uYW1lIjoiam9obi5kb2UiLCJzY29wZSI6WyJyZWFkIiwid3JpdGUiXSwiZX
hwIjoxNTQzNzE4MTk5LCJhdXRob3JpdGllcyI6WyJTVEFOREFSRF9VU0VSIl0sImp0aSI6IjY4NDBmMD
ZlLWExYWMtNDg4YS04ZmI1LTA0ZTkwMDI1MjhlNiIsImNsaWVudF9pZCI6InRlc3Rqd3RjbGllbnRpZC
J9.G6PIHxM0F9MftzDaQotd1n9ybnSGsEjlYXdF6H6IKOg","token_type":"bearer","expires_i
n":43200,"scope":"read write","jti":"6840f06e-a1ac-488a-8fb5-04e9002528e6"}

2) Go to Postman and update your post message header to include three things:
  - Authorization: value should be similar like below:
  Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJhdWQiOlsidGVzdGp3dHJlc291cmNlaWQiXSwidXNlcl9uYW1lIjoiam9obi5kb2UiLCJzY29wZSI6WyJyZWFkIiwid3JpdGUiXSwiZXhwIjoxNTQzNzE4MTk5LCJhdXRob3JpdGllcyI6WyJTVEFOREFSRF9VU0VSIl0sImp0aSI6IjY4NDBmMDZlLWExYWMtNDg4YS04ZmI1LTA0ZTkwMDI1MjhlNiIsImNsaWVudF9pZCI6InRlc3Rqd3RjbGllbnRpZCJ9.G6PIHxM0F9MftzDaQotd1n9ybnSGsEjlYXdF6H6IKOg
  - Content-Type: value should be application/json
  - Accept: value should be application/json
  
3) Put json message body:
  {
	"userId": "134256",
	"currencyFrom": "EUR",
	"currencyTo": "GBP",
	"amountSell": 1000,
	"amountBuy": 747.10,
	"rate": 0.7471,
	"timePlaced" : "24-JAN-15 10:27:44",
	"originatingCountry" : "FR"
}
  

