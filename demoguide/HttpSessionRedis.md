# HTTP Session Store in Redis
## Pre-requisite
* Four applications are running.
* demo-onlinestore-ui app is bound to Redis service, named "session-replication"

## Implementation
Just create a session object after login with no special way. 
```java
session.setAttribute("userid", getUserInfo(user).getId());
session.setAttribute("username", getUserInfo(user).getName());
session.setAttribute("address", getUserInfo(user).getAddress());
~
```

## Demonstration
After login, you can ses session contents in "/menu" or "/javainfo" in demo-onlinestore-ui. 
