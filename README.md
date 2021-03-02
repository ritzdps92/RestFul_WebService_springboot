# RestFul_WebService_springboot

to do a data support context that is xml we have to add below dependency

<!-- https://mvnrepository.com/artifact/com.fasterxml.jackson.dataformat/jackson-dataformat-xml -->
<dependency>
    <groupId>com.fasterxml.jackson.dataformat</groupId>
    <artifactId>jackson-dataformat-xml</artifactId>
</dependency>

for static filtering while serializing
@jsonIgnore
@jsonIgnoreproperties

Versionning
There are different ways to do api versioning:
1) Uri Versioning - create a new method and change Url.
	example - Twitter
2) Parameter Versioning
	example - Amazon
3) Headers Versioning
	example- Microsoft
4) Media type versioning Content Negotiation or Accept Versioning
	example- Github

Factors to be considered while choosing type when doing api versioning:
	- URI Pollution
	- Misuse of HTTP Headers
	- Caching

Ways to authenticate your rest services:
	- Basic Authentication


Q- What is a MicroService?
Ans: Restful services with Small deployable units and cloud enabled. In simple words It is an small autonomous service that work together.

q_ What are challenges while designing a microservice?
Ans: Boundry Context, Configuration Management, Visibility, Dynamic scale up and scale down, 



							Micro services
1) Spring CLoud config server - Spring cloud config server is used to keep all the configurations at a centralized place and then connect all of our microservices to pick respective configuration.
It is a centralized external configuration management backed by git. 