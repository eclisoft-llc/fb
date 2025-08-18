# Introduction 
This is a SpringBoot MicroService program to return XAA statement numbers given an account number and statement date. 

# Getting Started
This program has one GET REST API endpoint. It expects a request body in form of application/json document.

Installation process: Pull this repo, then build and run the Jar file xaa-0.0.1-SNAPSHOT.jar
Software dependencies: This program uses Mybatis ORM for database connection and mapping. If you want to run the program as a developer in your local machine, 
you must be connected to firstbank's VPN.

# Build and Test
Pull this repo, then build and run the Jar file xaa-0.0.1-SNAPSHOT.jar. You may also run it in the IDE IntelliJ. The program supports filterting the XAASTATEMENTs table in various ways.
Two mandatory keys are expected in the passed JSON document. These are "type" and "accountnumber". 

The "type" value indicates the type of request the caller is making. The program supports five request types, these are:

1. anum: This is used to filter by account number only. Example call:

curl --header "Content-Type: application/json" \ --request GET \ --data "{\"accountnumber\":\"09936805244\",\"type\":\"anum\"}" \  http://localhost:9085/getxaa

2. anumdate: This is used to filter by account number and a specific statement date where this supplied date value is equals to statementdate column in the database. Example call:

curl --header "Content-Type: application/json" \ --request GET \ --data "{\"accountnumber\":\"09936805244\",\"type\":\"anumdate\",\"startdate\":\"2022-10-26T00:00:00.000Z\"}" \  http://localhost:9085/getxaa

3. anumsdate: This is used to filter by account number and a specific statement date where this supplied date value is greater or equals to statementdate column in the database. Example call:

curl --header "Content-Type: application/json" \ --request GET \ --data "{\"accountnumber\":\"09936805244\",\"type\":\"anumsdate\",\"startdate\":\"2022-10-26T00:00:00.000Z\"}" \  http://localhost:9085/getxaa

4. anumedate: This is used to filter by account number and a specific statement date where this supplied date value is less or equals to statementdate column in the database. Example call:

curl --header "Content-Type: application/json" \ --request GET \ --data "{\"accountnumber\":\"09936805244\",\"type\":\"anumedate\",\"startdate\":\"2022-10-26T00:00:00.000Z\"}" \  http://localhost:9085/getxaa

5. anumsdateedate: This is used to filter by account number and two date ranges inclusive. Example call:

curl --header "Content-Type: application/json" \ --request GET \ --data "{\"accountnumber\":\"09936805244\",\"type\":\"anumsdateedate\",\"startdate\":\"2022-10-26T00:00:00.000Z\",\"enddate\":\"2022-10-31T00:00:00.000Z\"}" \  http://localhost:9085/getxaa

NB: the "type" value is case sensitive. It must be in all lower case.