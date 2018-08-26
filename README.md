# owasp-app
This cloud application simulates **OWASP 2017** security risks then measures and stores **CPU and Thread metrics** of each request. After that, you can easily apply **machine learning** algorithm to stored data!

This cloud application is developed according to Open Web Application Security Project (OWASP) top 10 application security risk report in 2017.
Application security risks given below are mapped to CRUD operations in this project. Both malicious requests and ordinal user requests can be simulated in 
this API. 

Application is deployed to **Heroku Cloud Application Platform** to get more realistic results about a cloud application attack scenarios. For each request, CPU and worker thread metrcis are measured using JMX library and stored to a relational database. You can reach **the data in  [here](https://github.com/dilero/owasp-app/blob/master/src/main/resources/operation.csv)**. After the data is obtained, different machine learning algorithms are running on that data.


This OWASP attacks simulation application is developed during my **MS. thesis**. You can reach the **related conference paper about my thesis in [here](http://www.scitepress.org/Papers/2018/66882/66882.pdf)**.


1. Injection
1. Broken Authentication
1. Sensitive Data Exposure
1. XML External Entities (XXE)
1. Broken Access Control
1. Security Misconfiguration
1. Cross-Site Scripting (XSS)
1. Insecure Deserialization
1. Using Components with Known Vulnerabilities
1. Insufficient Logging&Monitoring

