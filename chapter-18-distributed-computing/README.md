# Distributed Computing

## Table of Contents

- Java Remote Method Invocation (RMI)
- Servlets
- Enterprise JavaBeans (EJB)
- Jini

## What is RMI?

Invoking (calling) a method on an object on a different machine

4 pieces minimum:

- Client object -
  You can think of the Client object like a browser. It is the code that will "use" the server".
- Client helper (RMI Stub) -
  A "Stub" of the server. This is generated for you by `rmic`. It doesn't do the server's work, but it
  helps the client communicate with the server.
- Service helper (RMI Skeleton) -
  This is the server-sided counterpart to the Stub. It doesn't do the server's work, but handles passing
  the client's request off to the actual service object and communicating the result.
- Service object -
  The actual server code. This is the code that would talk to the database, do expensive calculations,
  or any other work that you don't want to do on the client (or can't do on the client).

Steps to make a remote **service**:

1. Make an `interface`
2. Make an implementation
3. Generate stubs and skeletons: `$ rmic MyRemoteServiceImpl`
4. Start the registry: `$ rmiregistry`
5. Start the service: `$ java MyRemoteServiceImpl`
6. Name an instance of your service: `Naming.rebind('My Service', new MyRemoteServiceImpl());`

Steps to create a **client** that interacts with a service:

1. Lookup the service: `MyRemoteService service = (MyRemoteService) Naming.lookup("rmi://localhost/My Service");`
2. Use it!: `int ten = service.double(5);`

The heart of Remote Method Invocation (RMI) is letting you write code that can run distributed
on different machines in a way that feels similar to regular method calls. To accomplish this,
Java provides `rmic` to generate some required code, `rmiregistery` to enable registering
new services to interact with, and some classes `Naming`, `UnicastRemoteObject`, `RemoteException`,
etc to support programming against RMI based services.

## What are Servlets?

Servlets are Java programs that run inside an HTTP web server. They might feel like a tiny version of a Django application.

To write a Servlet, you implement a class that extends a servlet base class (probably `HttpServlet`).
On this class, you override methods to setup your servlet.
For `HttpServlet` these methods will be related to how your servlet should handle HTTP requests like (`doGet`/`doPost`).

```java
public class MyServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
            PrintWriter out = response.getWriter();
            response.setContentType("text/html");
            out.write("Hello!");
            out.close();
        }
}
```

Running these servlets will involve setting up some sort of servlet container (e.g. Tomcat) and
placing your compiled servlets and some configuration in the correct directories for the container
to find and execute. In other words, it is not quite as simple as `./manage.py runserver`.

Interactions with requests/responses are exposed through methods on the `HttpServletRequest` object
and `HttpServletResponse` object. For example, form data from the request is available through the
`request.getParameter(name)` method.

## What are EJBs?

The book doesn't much description or any sample code about Enterprise Java Beans (EJBs).
The book summarizes them as RMI an steroids. It offers the idea that real world situations
have a lot of complicated problems that RMI doesn't address by default: transactions,
database management, security, etc. EJBs are supposed to be an RMI-esque tool that helps
developers address these additional, real world concerns.

## What is Jini?

Similar to EJBs, Jini isn't covered very much by the book. The book compares EJBs and Jini

> If EJB is RMI on steroids [...], Jini is RMI with wings.

The book describes two features Jini provides on top of RMI: adaptive discovery,
and self-healing networks.

Adaptive discovery allows clients to discover a service according to a desired `interface`
instead of by name. For instance, you could use Jini to lookup a `GuestbookServer` instead
of looking up a server by its name.

Self-healing networks involves registered services maintaining a "lease" with the Jini
lookup service. This allows the Jini lookup service to keep a dynamic understanding of
what services are available for which interfaces.
