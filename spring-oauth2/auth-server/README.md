# Spring security OAuth2
To create an oauth server add below dependency in build.gradle:

```$groovy
compile 'org.springframework.security.oauth:spring-security-oauth2'
```

And annotate the Application class with @EnableAuthorizationServer annotation.

```java
@SpringBootApplication
@EnableAuthorizationServer
public class AuthServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(AuthServerApplication.class, args);
    }

}
```

We only have to do 1 more thing (after adding @EnableAuthorizationServer):

application.properties
---
```#properties
...
security.oauth2.client.clientId=acme
security.oauth2.client.clientSecret=acmesecret
security.oauth2.client.authorized-grant-types=authorization_code,refresh_token,password
security.oauth2.client.scope=openid
```
---
This registers a client "acme" with a secret and some authorized grant types including "authorization_code".

Now let’s get it running on port 9999, with a predictable password for testing:

application.properties
---
```properties
server.port=9999
security.user.password=password
server.contextPath=/uaa
...
```
We also set the context path so that it doesn’t use the default ("/") because otherwise you can get cookies for other servers on localhost being sent to the wrong server. So get the server running and we can make sure it is working:

```groovy
gradle bootRun
```

# Testing the Authorization Server
Our server is using the Spring Boot default security settings, so like the server in Part I it will be protected by HTTP Basic authentication. To initiate an authorization code token grant you visit the authorization endpoint, e.g. at http://localhost:9999/uaa/oauth/authorize?response_type=code&client_id=acme&redirect_uri=http://example.com once you have authenticated you will get a redirect to example.com with an authorization code attached, e.g. http://example.com/?code=jYWioI.

Note
for the purposes of this sample application we have created a client "acme" with no registered redirect, which is what enables us to get a redirect the example.com. In a production application you should always register a redirect (and use HTTPS).
The code can be exchanged for an access token using the "acme" client credentials on the token endpoint:

```shell script
$ curl acme:acmesecret@localhost:9999/uaa/oauth/token  \
-d grant_type=authorization_code -d client_id=acme     \
-d redirect_uri=http://example.com -d code=jYWioI
```

```json
{"access_token":"2219199c-966e-4466-8b7e-12bb9038c9bb","token_type":"bearer","refresh_token":"d193caf4-5643-4988-9a4a-1c03c9d657aa","expires_in":43199,"scope":"openid"}
```
The access token is a UUID ("2219199c…"), backed by an in-memory token store in the server. We also got a refresh token that we can use to get a new access token when the current one expires.

Note
---
since we allowed "password" grants for the "acme" client we can also get a token directly from the token endpoint using curl and user credentials instead of an authorization code. This is not suitable for a browser based client, but it’s useful for testing.
If you followed the link above you would have seen the whitelabel UI provided by Spring OAuth. To start with we will use this and we can come back later to beef it up like we did in Part II for the self-contained server.