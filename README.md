SOLID PRINCIPLES :

Good Design Add Value Faster Than It Adds Cost.

- It Help us to design and write better code.
- refers to a set of principles of object-oriented programming and design.

- Principles are intended to help developers to write maintainable, extensible code.

The Principles :

- S: Single-Responsibility.
- O: Open/Closed.
- L: Liskov Substitution.
- I: Interface Segregation.
- D: Dependency Inversion.


The benifits of applying SOLID principles :

- Encourages good design
- You can look at any part of the system and understand how it works and how it fits togother.
- increases cohesion in classes.

(Helps us to write code that allow classes to do one thing.)

- Reduces dependencies between classes (making it easier to modify without effecting something else.)
- When we modify code we can be sure that we will not be effecting anything else in the process.
- It simplifies debugging.
- It simplifies maintenance.
- It simplifies unit testing.

\-------------------------------------------

- Single Responsibility :

`	`- the class should have only one reason to change.

`	`(When we write a class and we come back to modify it, we should have a very good and specific reason for modifying that class and that reason should related to the core purpose.)

\*\* A class or method should be responsible for doing only one job and should do that really well. \*\*

\-----------


- Open/Closed :

`	`- Software entities, classes, modules, functions, ....etc (software components) - should be open for extension and closed for modification.

`	`- Design our system in such way that can easily add features without having to modify, recompile and redeploy core components. so...

(We can use inheritance to extend classes and add behaviors.)

\-----------

- Liskov Substitution :

`	`- When code depends on class or interface X, any subtype of X sould be entirely valid in the same context.

\*\* If I have a class and I have got a couple of different subtypes and I have code that depends on that class, That code will behave in exactly the same way regardless of which subtype it use.

(Various subtypes of class should be able to be used interchangeably where an instance of that class is expected.)


\-----------

- Interface Segregation :

`	`- No client should be forced to depend on methods it does not use.

\*\* Each class should serve a well-defined purpose and only expose behavior that is aligned with that purpose. \*\*


(Consumers of that class should not be forced to depend on methods which they do not require "Optional methods".)


- Dependency Inversion :

`	`- High Level Modules should not depend on Low Level Modules, Both should depend on abstractions, and abstractions should not depend on details. Details should depends on abstractions.



`	`- In other words, classes should not depend on each other directly (Related to open/closed and Liskov subistitution).
