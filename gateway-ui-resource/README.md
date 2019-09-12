To make it work we need to setup redis server first.
Or we can use mongo etc for session store.

After successful login. We can see below data in REDIS:

→ rdcli -a password
127.0.0.1:6379> KEYS *

127.0.0.1:6379> KEYS *
1) spring:session:spring:session:index:org.springframework.session.FindByIndexNameSessionRepository.PRINCIPAL_NAME_INDEX_NAME:user
2) spring:session:spring:session:expirations:1568272200000
3) spring:session:spring:session:sessions:9692b7cb-d6ed-4bb3-b7f3-9f30fcb0b26a
4) spring:session:spring:session:sessions:expires:9692b7cb-d6ed-4bb3-b7f3-9f30fcb0b26a
