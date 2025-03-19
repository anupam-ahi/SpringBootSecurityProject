# SpringBootSecurity
Java Web server enabling security


In this project I have learnt:
1. How does the default spring security work: explored the /login endpoint that is enabled by default. How to confifure the username and password using the application.properties file.
2. How the filter chain works when the spring security is enabled, and the flow of actions that take place when a client communicates with the server.
3. Got to know about the csrf token. They are used to validate the user to access pages after login.
4. In the filter chain, I implemented a custom authentication provider using DaoAuthenticationProvider. Configured the filter to enable custom authentication, except for 2 endpoints.
5. Learnt about encrypt/decrypt to store user credentials in database (the user credentials are stored in the database using an ecryption algorithm) using hibernate and the database used is postgresql.
6. Learnt how to generate custom JWT to authenticate the user to access all endpoints after the initial login.
