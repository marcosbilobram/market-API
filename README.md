# Market-API

This API shows an example of an API from a market, where you can execute CRUD operations in entities like user, product, category and more.

Problems:
It sems like the new version of spring boot 3.0.1 is having a problem with basic request using hiperlink. Basically when you try to do a request
the program just returns a 404 error page.

I've tried many different ways to solve the problem but without sucess. I've determinate that the problems came from the new Tomcat version, and when you try
to go back in the 9's versions the application can't build itself, resulted by a conflict between libraries in the spring boot web dependecy.
