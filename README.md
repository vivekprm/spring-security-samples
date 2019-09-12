# spring-security-samples

This is sample spring security project explained in Dave Syer video below:

https://www.youtube.com/watch?v=x3pYcp1LopU&t=809s

# Angular 1
<b>spring-security-angular-backend</b> Project contains spring boot 1.4.0 and angular 1 code, as explained in above video.

# gateway-ui-resource
This project uses UI code created above and separated out APIs as a separate service (resourceserver). Login is handled at gateway level and session is stored in REDIS for communication.

Project is very basic just to understand the architecture so you might find some hardcodings etc. And it can be improved by using api gateways like [Zuul](https://github.com/Netflix/zuul)

Please refer architecture diagram for complete understanding.

# Angular 2
<b>spring-security-angular</b> contains backend code in spring boot 2.1.8.
<b>spring-security-angular-ui</b> contains frontend code written in angular 2. We can build the code in it and package everything as part of spring-security-angular project.
