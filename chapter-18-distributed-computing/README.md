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

## What are EJBs?

## What is Jini?

## Why do I care about all of this?
