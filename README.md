# spring-security-samples

This repository is created to improve my understanding of the spring-security talk given by Dave Syer:

https://www.youtube.com/watch?v=x3pYcp1LopU&t=809s

# Angular 1
<b>spring-security-angular-backend</b> Project contains spring boot 1.4.0 and angular 1 code, as explained in above video.

# gateway-ui-resource
This project uses UI code created above and separated out APIs as a separate service (resourceserver). Login is handled at gateway level and session is stored in REDIS for communication.

Project is very basic just to understand the architecture so you might find some hardcodings etc. And it can be improved by using api gateways like [Zuul](https://github.com/Netflix/zuul)

Please refer below architecture diagram for complete understanding.

![gateway-ui-resource](https://github.com/vivekprm/spring-security-samples/blob/master/gateway-ui-resource/architecture-diagram.png)

# proxy-ui-resource
This project is same as gateway-ui-resource architecturally. However, here we are using Zuul as our gateway. Which is better than the previous approach.

Zuul is a JVM-based router and server-side load balancer from Netflix.

Netflix uses Zuul for the following:
* Authentication
* Insights
* Stress Testing
* Canary Testing
* Dynamic Routing
* Service Migration
* Load Shedding
* Security
* Static Response handling
* Active/Active traffic management

# spring-oauth2
Here we are using separate auth-server for login, separate service (oauth2-resource-server) for APIs and separate service (oauth2-ui-gateway) for UI.

# Angular 2
<b>spring-security-angular</b> contains backend code in spring boot 2.1.8.
<b>spring-security-angular-ui</b> contains frontend code written in angular 2. We can build the code in it and package everything as part of spring-security-angular project.
