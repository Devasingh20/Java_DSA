# Object-Oriented Programming (OOP)

Object-Oriented Programming (OOP) is a programming paradigm (A programming paradigm is a style or approach of writing and organizing computer programs. It defines how programmers structure code and solve problems using a programming language.) that organizes software around objects, which contain data (attributes or fields) and behavior (methods). It uses classes as blueprints for creating objects and it promotes modularity, reusability, maintainability, and controlled access to data through concepts such as encapsulation, inheritance, polymorphism, and abstraction.

- **Modularity:** Dividing a program into smaller, independent, manageable parts called classes and objects.
- **Reusability:** Using existing code multiple times without rewriting it, through inheritance, composition, and other mechanisms.
- **Maintainability:** Making code easier to understand, modify, test, and debug when requirements change.

# Class

A class is a named blueprint that groups related data (fields or properties) and behavior (methods) into a single unit. That is used for creating objects, and an object is an instance of a class.
A class defines a reference type that specifies the fields and methods its objects can have.
When you create an object of a class, you create an instance of that class. In Java, the `new` operator is commonly used to create an object and invoke its constructor.

Thus, a class is a logical construct that defines the structure and behavior of objects, whereas an object is a runtime entity with its own identity and state.

## Example in Java

```java
class Student {
    String name;
    int age;
}

public class Main {
    public static void main(String[] args) {
        Student s1;              // Declares a reference variable
        s1 = new Student();      // Creates an object

        s1.name = "Aman";
        s1.age = 21;
    }
}
```

- `Student` → Class (blueprint).
- `s1` → Reference variable.
- `new Student()` → Creates an object.
- `name` and `age` → Instance variables that store the object's state.

# Object

An object in Java is an instance of a class that has three essential properties: state, identity, and behavior. It represents a runtime entity that contains data through fields and provides functionality through methods.

## What is a runtime entity?

A runtime entity is something that exists or is created while a program is executing.

- **Runtime** means the period when a program is running.
- **Entity** means a thing or unit that exists.

## Why is an object called a runtime entity?

Consider this Java code:

```java
class Student {
    String name;
}

Student s1 = new Student();
```

**Step 1:** `class Student` defines a blueprint. It describes what a student object can contain.

**Step 2:** `new Student()` creates a `Student` object while the program is running.

**Step 3:** `s1` holds a reference that allows you to access that object.

# Field and Instance Variable

## What do these terms mean?

- **Field:** A variable declared inside a class but outside its methods, constructors, and initializer blocks. It represents data associated with an object (or with the class if it is `static`).
- **Instance variable:** A non-static field whose value belongs to an individual object. Each object gets its own copy.

**Remember:** Every instance variable is a field, but not every field is an instance variable. A field declared with `static` belongs to the class rather than to each individual object.

# Static vs. Instance Variables

Here is a Java example demonstrating a static variable (class variable) versus instance variables.

## Example: Static vs. Instance Variables

```java
class Student {
    String name;                 // Field + Instance variable
    int age;                     // Field + Instance variable
    static String college = "JCB University"; // Field + Static variable
}

public class Main {
    public static void main(String[] args) {
        Student s1 = new Student();
        s1.name = "Aman";
        s1.age = 21;

        Student s2 = new Student();
        s2.name = "Rahul";
        s2.age = 22;

        System.out.println(s1.name);
        System.out.println(s1.age);
        System.out.println(s1.college);

        System.out.println(s2.name);
        System.out.println(s2.age);
        System.out.println(Student.college);
    }
}
Here, name and age are instance variables, whereas "Aman", 21, "Rahul", and 22 are the values assigned to those instance variables.
```

## Output

```text
Aman
21
JCB University
Rahul
22
JCB University
```

## How does it work?

**Student class**

One shared static variable:

`college = "JCB University"`

**Object `s1`**

- `name = "Aman"`
- `age = 21`

**Object `s2`**

- `name = "Rahul"`
- `age = 22`

Both objects share the same class variable, `college`, while their instance variables are separate.

## What happens if we change the static variable?

```java
Student.college = "Delhi University";

System.out.println(s1.college);
System.out.println(s2.college);
```

### Output

```text
Delhi University
Delhi University
```

Both objects reflect the change because `college` belongs to the class, not to individual objects.

## Key differences

| Instance variable | Static variable |
|---|---|
| Declared without `static` | Declared with `static` |
| Each object has its own copy | One class variable is shared |
| Accessed using an object, conventionally | Preferably accessed using the class name |
| Example: `name`, `age` | Example: `college` |

**Remember:** A static field is shared at the class level. For clarity, access it using `Student.college` rather than `s1.college`.

A static variable is not an instance variable. It is a class variable.

# Three Essential Properties of an Object

An object is characterized by three essential properties: state, identity, and behavior.

1. **State:** The state of an object is determined by the current values of its fields (instance variables). It represents the object's properties at a particular point in time.

2. **Identity:** The identity of an object distinguishes it from other objects, even if they have the same state. In Java, two distinct objects can contain identical field values but still be different objects.

3. **Behavior:** The behavior of an object is defined by the operations it can perform, typically implemented through its methods. These operations can access or modify the object's state or interact with other objects.

## Example in Java

```java
class Student {
    String name; // Field / Instance variable
    int age;

    void study() {
        System.out.println(name + " is studying");
    }
}

Student s1 = new Student();
s1.name = "Aman";
s1.age = 21;

Student s2 = new Student();
s2.name = "Aman";
s2.age = 21;
```

- **State:** Both objects have `name = "Aman"` and `age = 21`.
- **Identity:** `s1` and `s2` refer to two distinct objects, despite having identical states. In Java, `s1 == s2` evaluates to `false`.
- **Behavior:** The `study()` method defines an action a student object can perform.

# 1. The Dot Operator Accesses an Object's Members

The dot (`.`) is used to access an object's fields and methods through a reference.

The dot operator links the name of the object with the name of an instance variable.

Although commonly referred to as the dot operator, the formal specification for Java categorizes the `.` as a separator.

```java
Student kunal;
System.out.println(kunal.rno);
```

```java
// Create a class
// for every single student
class Student {
    int rno;
    String name;
    float marks;
}
```

## What Happens Here?

- `Student kunal;` — Declares a reference variable named `kunal` of type `Student`. No object is created.
- `System.out.println(kunal.rno);` — This causes a compilation error because `kunal` is a local variable that has not been initialized.

To create an object, write:

```java
Student kunal = new Student();
System.out.println(kunal.rno);
```

Assuming `Student` has the fields shown in your example, the output is `0` because Java initializes an object's `int` field to `0` by default.

**Remember:** Declaring a reference variable and creating an object are two different operations.

---

# 2. The `new` Keyword

1. The `new` keyword is used to create an object at runtime. It allocates memory for the object and invokes its constructor.
2. The `new` expression returns a reference to the newly created object. This reference allows us to access the object, but it is not necessarily a directly usable memory address.
3. This reference can be stored in a reference variable, which can then be used to access the object's fields and methods.
4. Java class instances are created at runtime. The `new` operator is the most common way to create objects, but it is not the only way; objects can also be created through mechanisms such as cloning and deserialization.

## Example

```java
class Student {
    String name;
}

Student kunal = new Student();
```

- `new Student()` creates a `Student` object.
- `kunal` stores the reference returned by the `new` expression.
- `kunal.name` accesses the object's field.

**Important:** Avoid saying that a reference is literally a memory address. A reference identifies or provides access to an object, while the JVM manages memory internally.

---

# 3. What Is a Constructor in Java?

A constructor is a special member of a class that is executed when an object is created to initialize that object.

A constructor has the same name as its class and has no return type, not even `void`.

## Example

```java
class Student {
    int rno;
    String name;

    // Constructor
    Student() {
        rno = 101;
        name = "Aman";
    }
}
```

Here, `Student()` is a constructor because:

- Its name is the same as the class name, `Student`.
- It has no return type.
- It initializes the object's fields.

## 3.1. What Happens When We Create an Object?

```java
Student student1 = new Student();
```

When this statement executes, Java creates and initializes a new object. The `new` expression invokes the constructor as part of the object-creation process.

```text
new Student()
     |
     v
Object-creation expression
     |
     v
Memory allocated and fields initialized
     |
     v
Student() constructor executes
     |
     v
Sets rno = 101 and name = "Aman"
     |
     v
Initialized Student object
     |
     +-- rno = 101
     |
     +-- name = "Aman"
```

## 3.2. What Does "Invoke the Constructor" Mean?

Invoke means to call or execute something.

Therefore, **invoke the constructor** means Java calls and executes the constructor during object creation.

For example:

```java
class Student {
    Student() {
        System.out.println("Constructor invoked");
    }
}

public class Main {
    public static void main(String[] args) {
        Student s1 = new Student();
        Student s2 = new Student();
    }
}
```

**Output:**

```text
Constructor invoked
Constructor invoked
```

Why does it print twice? Because `new Student()` is executed twice, creating two separate objects and invoking the constructor for each object.

## 3.3. Types of Constructors

### A. No-Argument Constructor

A constructor that accepts no parameters.

```java
Student() {
    System.out.println("Student created");
}
```

### B. Parameterized Constructor

A constructor that accepts parameters to initialize an object with specific values.

```java
class Student {
    String name;
    int age;

    Student(String n, int a) {
        name = n;
        age = a;
    }
}

Student s1 = new Student("Aman", 21);
Student s2 = new Student("Rahul", 22);
```

Now the objects have different initial states:

- `s1`: `"Aman"`, `21`
- `s2`: `"Rahul"`, `22`

### Important Distinction

If you do not declare any constructor, Java can provide a default constructor automatically. But if you declare a constructor yourself, Java does not automatically provide that default constructor.

**Remember:** A constructor initializes a newly created object, and invoking a constructor means executing it during object creation.

---

# 4. What Happens at Compile Time and Runtime?

When you write:

```java
Student student1 = new Student();
```

Two important things happen: Java declares a reference variable named `student1` and creates a `Student` object at runtime.

Let's separate what happens during compilation and what happens during runtime.

## 4.1. At Compile Time

The compiler checks your code before the program executes.

- It checks whether the `Student` class exists and is accessible.
- It checks whether the constructor call `new Student()` is valid.
- It checks whether the statement follows Java syntax and type rules.

The compiler does not normally create the actual `Student` object at this stage.

## 4.2. At Runtime

Consider this complete example:

```java
class Student {
    int rno;
    String name;
}

public class Main {
    public static void main(String[] args) {
        Student student1 = new Student();
    }
}
```

When this statement executes, the following steps occur.

### Step 1: Declare the Reference Variable

`student1` is a local variable capable of holding a `Student` reference. Before initialization, it cannot be used.

### Step 2: Allocate Memory for the Object

`new Student()` creates a new `Student` instance. Its instance fields initially receive default values:

- `rno = 0`
- `name = null`

### Step 3: Invoke the Constructor

Java invokes the appropriate constructor to initialize the object. If you have not declared any constructor, Java provides a default constructor.

### Step 4: Assign the Reference

The `new Student()` expression produces a reference to the new object, and that reference is assigned to `student1`.

These steps describe Java's object-creation process as specified by the Java Language Specification, Section 15.9.4.

## 4.3. Visualize the Result

```text
Reference variable
       |
       v
  student1
       |
       | Reference to the object
       v
  Student object
  +------------+
  | rno = 0    |
  | name = null|
  +------------+
```

## 4.4. What Is the Difference?

| Compile Time | Runtime |
|---|---|
| Checks syntax and types. | Executes the program. |
| Verifies that the constructor call is valid. | Creates the object when the expression executes. |
| Produces compiled bytecode when compilation succeeds. | Allocates and initializes the object according to Java's rules. |

**Remember:** The compiler checks whether `new Student()` is valid. When the statement executes at runtime, Java creates the object, invokes its constructor, and assigns the resulting reference to `student1`.

---

# 5. What Is Dynamic Memory Allocation Here?

Dynamic memory allocation means allocating memory for an object while the program is running (at runtime), rather than deciding its actual memory allocation entirely at compile time.

In your Java example:

```java
Student student1 = new Student();
```

The dynamic memory allocation happens when `new Student()` executes at runtime.

## What Happens Step by Step?

### Step 1: Compile Time

The compiler checks the statement and generates bytecode. The actual `Student` object has not yet been created by this statement.

### Step 2: Runtime — `new Student()`

Java allocates memory for the new object and initializes its instance fields. This is the dynamic memory allocation.

### Step 3: Reference Assignment

The reference returned by `new Student()` is assigned to `student1`, allowing you to access the object.

## Visual Example

```java
class Student {
    int rno;
}

Student student1 = new Student();
```

Conceptually, after execution:

```text
Reference variable: student1
          |
          v
Dynamically allocated object
+----------------------+
| Student instance     |
| rno = 0              |
+----------------------+
```

The `rno` field is initialized to `0` because that is Java's default value for an `int` instance field.

## Why Is It Called Dynamic?

Because the object is created during program execution. For example, you can create one student object or a thousand objects depending on what the program needs at runtime.

**Important distinction:** The reference variable `student1` and the object it refers to are different things. The object is dynamically allocated; the reference variable stores the reference to that object.

---

# 6. What Happens If You Print `student1.name`?

If you write:

```java
System.out.println(student1.name);
```

without defining a constructor, the output depends on whether you have created the object and assigned a value to `name`.

## Case 1: No Constructor Defined

```java
class Student {
    String name;
    int rno;
}

public class Main {
    public static void main(String[] args) {
        Student student1 = new Student();

        System.out.println(student1.name);
        System.out.println(student1.rno);
    }
}
```

**Output:**

```text
null
0
```

### Why?

When you do not declare any constructor, Java provides a default constructor automatically.

When `new Student()` executes:

- `name` gets the default value `null` because it is a reference-type field.
- `rno` gets the default value `0` because it is an `int` field.

## Case 2: Value Assigned Manually

```java
Student student1 = new Student();
student1.name = "Aman";

System.out.println(student1.name);
```

**Output:**

```text
Aman
```

## Case 3: Object Not Created

```java
Student student1;
System.out.println(student1.name);
```

**Result:** Compilation error because `student1` is an uninitialized local variable.

## Remember

| Situation | Result |
|---|---|
| Object created, no value assigned to `name` | `null` |
| Object created, `name = "Aman"` | `Aman` |
| Local reference declared but not initialized | Compilation error |

**Key point:** A constructor is not mandatory to write yourself. Java supplies a default constructor if your class declares no constructors, and Java initializes instance fields with their default values.

# Object Initialization and Field Initialization in Java

Every object is initialized when it is created, but it is not always initialized with values explicitly provided by the class. Java also assigns default values to instance variables.

## 1. Case 1: Values Provided by the Class

```java
class Student {
    String name = "Aman";
    int marks = 100;
}

Student student1 = new Student();
```

When `student1` is created:

- `name` → `"Aman"`
- `marks` → `100`

These are the initial values specified in the class.

## 2. Case 2: No Values Provided by the Class

```java
class Student {
    String name;
    int marks;
}

Student student1 = new Student();
```

Java assigns default values to the instance variables:

- `name` → `null`
- `marks` → `0`

## 3. Case 3: Values Provided Through a Constructor

```java
class Student {
    String name;
    int marks;

    Student(String n, int m) {
        name = n;
        marks = m;
    }
}

Student student1 = new Student("Aman", 90);
```

Here, the constructor initializes the object's fields with the supplied values:

- `name` → `"Aman"`
- `marks` → `90`

## Remember the Initialization Order

For instance fields, Java first provides default values, then applies field initializers and instance initialization blocks, and then executes the constructor body (with superclass initialization occurring as part of this process).

**Important:** A later assignment can change an object's field value, as in:

```java
student1.marks = 95;
```

---

# Object References and Dynamic Memory Allocation

It is important to understand that `new` allocates memory for an object during runtime.

```java
Box b1 = new Box();
Box b2 = b1;
```

`b1` and `b2` will both refer to the same object. The assignment of `b1` to `b2` did not allocate any memory or copy any part of the original object. It simply makes `b2` refer to the same object as does `b1`.

Thus, any changes made to the object through `b2` will affect the object to which `b1` is referring, since they are the same object.

When you assign one object reference variable to another object reference variable, you are not creating a copy of the object; you are only making a copy of the reference.

---

# Parameters and Arguments in Java

```java
int square(int i) {
    return i * i;
}
```

A parameter is a variable defined by a method that receives a value when the method is called. For example, in `square(int i)`, `i` is a parameter.

An argument is a value that is passed to a method when it is invoked. For example, `square(100)` passes `100` as an argument.

Inside `square()`, the parameter `i` receives that value.

---

# Compile Time and Runtime in Java

**NOTE:**

```java
Bus bus = new Bus();
```

In `Bus bus = new Bus();`, the compiler checks the declaration, types, and validity of the expression.

At runtime, the JVM executes the object-creation operation represented by `new Bus()`, initializes the object, invokes its constructor, and assigns the resulting reference to `bus`.

---

# Is Initializing the Object and Its Fields Different?

Yes, they are related but not exactly the same thing. Initializing an object includes initializing its fields, but we can discuss these as separate steps.

## Example in Java

```java
class Student {
    String name = "Aman";
    int marks = 100;
}

Student s1 = new Student();
```

## 1. Object Initialization

When `new Student()` executes, Java creates a new object and initializes it according to Java's object-creation process.

## 2. Field Initialization

The object's fields receive their initial values:

- `name = "Aman"` — from the field initializer.
- `marks = 100` — from the field initializer.

If you had not provided explicit initializers, Java would assign default values such as `null` for `String` and `0` for `int`.

## What Happens When a Constructor Is Involved?

```java
class Student {
    String name;
    int marks;

    Student() {
        name = "Aman";
        marks = 100;
    }
}

Student s1 = new Student();
```

Here, the constructor assigns values to the fields. More precisely, Java first initializes fields to their default values, then performs instance field initialization and executes the constructor body in the defined initialization order.

## Remember

- **Object initialization:** The overall process of preparing a newly created object for use.
- **Field initialization:** Setting the initial values of the object's fields.

---

# The `this` Keyword

The `this` keyword in Java is a reference to the current object. It is used inside an instance method or constructor to refer to the object whose method is being executed or whose constructor is initializing it.

It is commonly used to distinguish instance variables from local variables or parameters with the same name.

## Example

```java
class Student {
    String name;

    Student(String name) {
        this.name = name;
    }

    void display() {
        System.out.println(this.name);
    }
}
```

- `this.name` refers to the `name` instance variable of the current object.
- `name` in `Student(String name)` refers to the constructor parameter.
- `this` allows us to distinguish between them.

**Important:** You cannot use `this` directly inside a static method because a static method belongs to the class, not to a particular object.

---

# Accessing Instance Variables With and Without `this`

Java allows you to access an instance variable directly by its name inside an instance method, without writing `this`.

Let's understand using your code.

## 1. Without `this`

```java
void greeting() {
    System.out.println("Hello, I am " + name);
}
```

Here, `name` refers to the `name` instance variable of the current `Student` object.

Java implicitly treats it as:

```java
void greeting() {
    System.out.println("Hello, I am " + this.name);
}
```

## 2. With `this`

```java
void greeting1() {
    System.out.println("Hello, I am " + this.name);
}
```

Here, `this.name` explicitly refers to the `name` instance variable of the current object.

Both methods produce the same output:

```text
Hello, I am Deva singh
Hello, I am Deva singh
```

## 3. Why Does Java Allow Both?

When you call:

```java
Student Deva = new Student();

Deva.greeting();
Deva.greeting1();
```

Both methods execute on the same `Student` object referenced by `Deva`.

```text
Deva reference
      |
      v
Current Student object
      |
      +-- name = "Deva singh"
      +-- marks = 90
      +-- roll_no = 50008
```

Both methods access the same object's `name` field.

## 4. When Is `this` Especially Useful?

Consider your `changeName()` method:

```java
void changeName(String name) {
    this.name = name;
}
```

Here, both the parameter and instance variable are named `name`.

- `this.name` refers to the instance variable.
- `name` refers to the method parameter.

Without `this`, writing `name = name;` would assign the parameter to itself and would not update the instance variable.

## Remember

- `name` and `this.name` are equivalent when accessing the instance field in your `greeting()` methods.
- `this` explicitly identifies the current object.
- `this` is particularly useful when a parameter or local variable has the same name as an instance variable.

# The `final` Keyword in Java

A field can be declared as `final`. Doing so prevents the field from being reassigned after it has been initialized. For primitive types, this means its value cannot be changed. For reference types, the reference cannot be changed to point to another object, but the object itself may still be modified.

A `final` variable must be initialized exactly once. A `final` field can be initialized when it is declared, in an instance initializer block, or in a constructor, depending on whether it is an instance or static field.

It is a common coding convention to use uppercase identifiers for constants, especially `static final` fields.

```java
static final int FILE_OPEN = 2;
```

Once `FILE_OPEN` is initialized to `2`, it cannot be reassigned.

## 1. The `final` Keyword with Primitive Types

When a primitive variable is declared `final`, its value cannot be changed after initialization.

```java
final int FILE_OPEN = 2;

// FILE_OPEN = 3; // Compilation error
```

Here, `FILE_OPEN` cannot be assigned another value because it is declared `final`.

## 2. The `final` Keyword with Reference Types

When a reference variable is declared `final`, the reference cannot be reassigned to another object. However, the object itself can still be modified if its class allows modification.

```java
class Student {
    String name;
}

public class Main {
    public static void main(String[] args) {
        Student s1 = new Student();
        s1.name = "Aman";

        final Student s2 = s1;

        s2.name = "Rahul"; // Allowed

        // s2 = new Student(); // Compilation error

        System.out.println(s2.name);
    }
}
```

**Output:**

```text
Rahul
```

Here, `s2` continues to refer to the same `Student` object, but the object's `name` field changes from `"Aman"` to `"Rahul"`.

Therefore, the `final` keyword prevents reassignment of the reference, not modification of the referenced object.

## 3. Initialization of `final` Fields

A `final` field does not necessarily have to be initialized where it is declared. An instance `final` field can also be initialized in a constructor.

```java
class Student {
    final int rollNo;

    Student(int rollNo) {
        this.rollNo = rollNo;
    }
}
```

```java
Student s1 = new Student(101);
Student s2 = new Student(102);
```

Each object's `rollNo` field is initialized once during construction.

# The `finalize()` Method in Java

In older versions of Java, the `finalize()` method was provided as a mechanism that allowed an object to attempt cleanup before the garbage collector reclaimed its memory.

However, **the `finalize()` method has been deprecated since Java 9 and is deprecated for removal**. It should not be relied upon because the garbage collector is not guaranteed to invoke it or to invoke it at any particular time.

## Older Example (For Understanding Only)

```java
@Override
protected void finalize() throws Throwable {
    // Old finalization code
}
```

The Java runtime might invoke this method before reclaiming an object, but its execution is not guaranteed. Therefore, this mechanism is unsuitable for reliable resource management.

## Recommended Alternative: Try-with-Resources

For resources such as files, streams, and database connections, Java provides the try-with-resources statement. It automatically closes resources that implement `AutoCloseable`.

```java
try (java.io.BufferedReader reader =
         new java.io.BufferedReader(
             new java.io.FileReader("data.txt"))) {

    System.out.println(reader.readLine());

} catch (java.io.IOException e) {
    e.printStackTrace();
}
```

The reader is closed automatically when the `try` block finishes, including when an exception occurs.

## Summary

- **`final` with primitive types:** Prevents changing the variable's value after initialization.
- **`final` with reference types:** Prevents reassignment of the reference but does not automatically make the object immutable.
- **Initialization of `final` fields:** Can occur at declaration or through the appropriate initializer or constructor.
- **`finalize()` method:** An obsolete cleanup mechanism that should not be used in new Java code.
- **Try-with-resources:** The preferred approach for reliably closing resources.

**Official references:**

- [Java Language Specification — ](https://docs.oracle.com/javase/specs/jls/se25/html/jls-4.html#jls-4.12.4)[`final`](https://docs.oracle.com/javase/specs/jls/se25/html/jls-4.html#jls-4.12.4)[ Variables](https://docs.oracle.com/javase/specs/jls/se25/html/jls-4.html#jls-4.12.4)
- [Oracle Java API — ](https://docs.oracle.com/en/java/javase/25/docs/api/java.base/java/lang/Object.html#finalize\(\))[`Object.finalize()`](https://docs.oracle.com/en/java/javase/25/docs/api/java.base/java/lang/Object.html#finalize\(\))


# 1. Why does `System.out.println(Deva)` print `Student@7344699f`?

`println()` uses `String.valueOf()`, which calls the object's `toString()` method. The `toString()` method already exists in Java's `Object` class. You do not have to write it yourself.

Let's understand step by step.

## 1. Why does `System.out.println(Deva)` print `Student@7344699f`?

Suppose you have this code:

```java
class Student {
    String name = "Deva Singh";
    int marks = 90;
}

public class Main {
    public static void main(String[] args) {
        Student Deva = new Student();

        System.out.println(Deva);
    }
}
```

Output (example):

```text
Student@7344699f
```

The exact hexadecimal part can differ between objects and runs.

## 2. What happens internally?

Conceptually, the process is:

```java
System.out.println(Deva);
```

1. Passes the object reference to `println()`.
2. `String.valueOf(Deva)` converts the object reference into a string representation.
3. `Deva.toString()` is called.
4. The resulting string is printed.

```text
Student@7344699f
```

This is a conceptual explanation of the call chain, not the exact source-code implementation of every `println()` overload.

## 3. But we never created a `toString()` method. How does it work?

Every Java class implicitly inherits from the `Object` class if it does not extend another class.

For example:

```java
class Student {
    String name;
    int marks;
}
```

Conceptually, this is equivalent to:

```java
class Student extends Object {
    String name;
    int marks;
}
```

The `Object` class already provides a `toString()` method.

Its default behavior produces a string based on:

```text
ClassName@hexadecimalHashCode
```

Therefore:

- `Student` → the class name.
- `@` → a separator in the default representation.
- `7344699f` → a hexadecimal representation derived from the object's hash code.

**Important:** This hexadecimal value is not necessarily the object's memory address.

## 4. What if we create our own `toString()` method?

You can override the inherited method to display meaningful information.

```java
class Student {
    String name = "Deva Singh";
    int marks = 90;

    @Override
    public String toString() {
        return "Name: " + name + ", Marks: " + marks;
    }
}
```

Now:

```java
Student Deva = new Student();
System.out.println(Deva);
```

Output:

```text
Name: Deva Singh, Marks: 90
```

Java now calls your overridden `toString()` method instead of using the default implementation inherited from `Object`.

## 5. Remember the difference

| Concept | Explanation |
|---|---|
| `println(Deva)` | Prints the object's string representation. |
| `String.valueOf(Deva)` | Converts the object reference into a string representation. |
| `Object.toString()` | Provides the default implementation inherited by `Student`. |
| Overridden `toString()` | Lets you define what information the object displays. |

Your understanding was almost correct. The only correction is that you do not need to create `toString()` yourself because Java provides it through the `Object` class. You override it only when you want more meaningful output.

# 2. What is a package in Java?

In Java, a package is a way to group related classes, interfaces, and other types together. It helps organize code, avoid naming conflicts, and control access to classes and members.

Think of a package as a folder that organizes related Java classes.

## 1. How to use a class from another package

Suppose your project contains these files:

```text
Project/
├── student/
│   └── Student.java
└── app/
    └── Main.java
```

### `Student.java`

```java
package student;

public class Student {
    public void display() {
        System.out.println("Hello from Student");
    }
}
```

### `Main.java`

```java
package app;

import student.Student;

public class Main {
    public static void main(String[] args) {
        Student s1 = new Student();
        s1.display();
    }
}
```

Output:

```text
Hello from Student
```

Here, `import student.Student;` allows the code to refer to the `Student` class by its simple name.

You can also use its fully qualified name without an import:

```java
student.Student s1 = new student.Student();
```

## 2. Types of packages in Java

There are two broad categories you'll commonly encounter.

| Type | Meaning | Examples |
|---|---|---|
| Built-in packages | Packages supplied by the Java platform | `java.util`, `java.io`, `java.lang` |
| User-defined packages | Packages created by developers | `student`, `app`, `oops` |

For example:

```java
import java.util.Scanner;
```

Here, `Scanner` belongs to the `java.util` package. It can be used to take input from the keyboard.

Another example:

```java
import java.io.File;
```

Here, `File` belongs to the `java.io` package and represents file and directory paths.

**Note:** `java.lang` is automatically imported into ordinary Java source files, so you don't need to write `import java.lang.String;` to use `String`.

## 3. Important rules to remember

1. A package helps organize related classes and interfaces.
2. The package declaration specifies the package to which a class belongs.
3. The `import` statement lets you refer to types from other packages by their simple names.
4. Packages help avoid naming conflicts. For example, two packages can contain classes named `Student`.
5. Packages also participate in Java's access-control rules. For example, a class or member with no access modifier (package-private access) is generally accessible only within its own package.

## 4. Package vs. class vs. object

| Concept | Meaning | Example |
|---|---|---|
| Package | Groups related types | `student` |
| Class | Defines fields and methods | `Student` |
| Object | An instance of a class | `new Student()` |

The relationship is:

```text
Package
   └── Class
         └── Objects created from that class
```

A package contains classes, and a class can be used to create objects.


# Static Keyword in Java

## 1. Definition of `static`

In Java, the `static` keyword is used to declare a member that belongs to the class rather than to individual objects. Therefore, static variables and methods can be accessed using the class name without creating an object of that class.

### Example

```java
class Student {
    static void display() {
        System.out.println("Hello");
    }
}

public class Main {
    public static void main(String[] args) {
        Student.display(); // No object required
    }
}
```

### Remember

Static members belong to the class and are shared at the class level, whereas non-static members belong to individual objects.

The `main()` method is the entry point of a traditional Java application, and it must be static so the JVM can call it without creating an object of the class. Without a valid entry-point method, the program cannot run normally using the standard Java launcher.

**Remember one more point:** Inside a static method, you cannot directly use anything that is non-static. If you need to access a non-static member, you must use an object reference.

For example:

```java
class Student {
    int age = 20;
    static int population = 0;

    static void display() {
        System.out.println(population); // Valid

        // System.out.println(age); // Compilation error
    }
}
```

The `age` variable belongs to an object, whereas `population` belongs to the class.

## 2. Can a class be static in Java?

**NOTE:** A top-level class in Java cannot be declared `static` because `static` applies to members of a class, not to a top-level class. However, a class declared inside another class can be static or non-static.

- **Static nested class:** It does not require an object of the outer class to be created. It can directly access only the static members of the outer class.
- **Non-static inner class:** It requires an instance of the outer class to be created first and can access both static and instance members of that outer class.

## 3. Example: Static variable `population`

### `Humans.java`

```java
package staticExample;

public class Humans {
    int age;
    String name;
    int salary;
    boolean married;

    static int population;

    public Humans(int age, String name, int salary, boolean married) {
        this.age = age;
        this.name = name;
        this.salary = salary;
        this.married = married;

        Humans.population += 1;
    }
}
```

### `Main.java`

```java
package staticExample;

public class Main {
    public static void main(String[] args) {
        Humans deva = new Humans(20, "Deva", 20000, false);
        Humans singh = new Humans(18, "Singh", 15000, false);

        System.out.println(deva.name);
        System.out.println(singh.name);
        System.out.println(singh.age);
        System.out.println(singh.salary);
        System.out.println(singh.married);

        System.out.println(Humans.population);
        System.out.println(Humans.population);
    }
}
```

## 4. When you use `static`

Consider the declaration:

```java
static int population;
```

Your constructor contains:

```java
Humans.population += 1;
```

When you create objects:

```java
Humans deva = new Humans(20, "Deva", 20000, false);
Humans singh = new Humans(18, "Singh", 15000, false);
```

The value changes as follows.

### Initially

```text
population = 0
```

### Create `deva`

```text
population = 1
```

### Create `singh`

```text
population = 2
```

### Shared value

```text
population = 2
```

Java loads the `Humans` class, and the static variable `population` is initialized to `0`. When the `deva` object is created using the constructor, Java allocates memory for the object, initializes its instance variables to their default values, and then executes the constructor. The constructor assigns `"Deva"` to the `name` variable and increments the shared static variable `population` by 1, making it `1`.

Similarly, when the `singh` object is created, the constructor assigns `"Singh"` to its own `name` variable and increments the same shared `population` variable from `1` to `2`.

Since `population` is static, it belongs to the `Humans` class and is shared by all its objects. Therefore, when we print `Humans.population`, the output is `2`.

## 5. Step-by-step execution

### Step 1: Java loads the `Humans` class

- The static variable `population` is initialized to `0`.
- It belongs to the class, not to individual objects.

```text
Humans.population = 0
```

### Step 2: Java executes `new Humans("Deva")`

- Memory for the new object is allocated, and its instance field `name` initially has the default value `null`.
- The constructor executes.
- `this.name = name` assigns `"Deva"` to that object's `name`.
- `Humans.population++` increments the shared static variable from `0` to `1`.

**Deva object**

```text
name = "Deva"

Shared population: 1
```

### Step 3: Java executes `new Humans("Singh")`

- A second object is created, with its own instance field `name`, initially `null`.
- The constructor executes again.
- `this.name = name` assigns `"Singh"` to the second object's `name`.
- `Humans.population++` increments the same shared variable from `1` to `2`.

**Singh object**

```text
name = "Singh"

Shared population: 2
```

### Step 4: Java prints the result

```text
2
```

## 6. Your main question: Before or after object creation?

The constructor executes during the object-creation process, after the object's memory is allocated and its fields receive their initial default values, but before the `new` expression finishes and returns the object reference.

So the order is:

1. Allocate memory for the object.
2. Initialize its instance fields to default values.
3. Execute the constructor (after the relevant superclass initialization).
4. Return the object reference and assign it to `deva` or `singh`.

Because `population` is static, there is only one shared variable for the entire `Humans` class.

Therefore:

```java
System.out.println(Humans.population);
System.out.println(Humans.population);
```

Output:

```text
2
2
```

Both statements print the same shared value.

## 7. When you remove `static`

Suppose you change your declaration to:

```java
int population;
```

Now every object has its own separate `population` variable.

Initially, Java gives each object's `int` field the default value `0`.

When the constructor executes, you must also change this line:

```java
this.population += 1;
```

Otherwise, `Humans.population` will produce a compilation error because `population` is no longer static.

Now the process becomes:

- Creating `deva`: `deva.population` changes from `0` to `1`.
- Creating `singh`: `singh.population` changes from `0` to `1`.

### Output

```java
System.out.println(deva.population);
System.out.println(singh.population);
```

Output:

```text
1
1
```

Each object has its own counter, so both values are `1`.

## 8. Compare both cases

| Feature | `static int population` | `int population` |
|---|---|---|
| Belongs to | Class | Each object |
| Number of variables | One shared variable | One per object |
| After creating two objects and incrementing each once | `2` | `1` for each object |
| Access using | `Humans.population` | `deva.population`, `singh.population` |

### Remember

In your program, `population` represents the total number of `Humans` objects created. Therefore, `static` is the appropriate choice.

One small correction: if you want to count all objects created, your current constructor-based counter works for ordinary object creation, but it will not automatically account for every possible object-creation mechanism or decrement when objects become unreachable.

# Inheritance in Java — Complete Notes

## 1. Definition of Inheritance

Inheritance is an OOP concept in Java in which one class acquires the accessible fields and methods of another class, allowing code reusability and the creation of relationships between classes.

- **Parent class / Superclass / Base class:** The class whose members are inherited.
- **Child class / Subclass / Derived class:** The class that inherits from another class.
- **`extends` keyword:** Used by a class to inherit from another class.

### Example

```java
class Box {
    double length;
    double width;
    double height;

    void display() {
        System.out.println(length);
        System.out.println(width);
        System.out.println(height);
    }
}

class BoxWeight extends Box {
    double weight;
}
```

Here:

- `Box` is the parent class.
- `BoxWeight` is the child class.
- `BoxWeight extends Box` means `BoxWeight` inherits the accessible members of `Box`.
- `BoxWeight` has its own `weight` field as well as the inherited `length`, `width`, and `height` fields.

We can create an object like this:

```java
public class Main {
    public static void main(String[] args) {
        BoxWeight box = new BoxWeight();

        box.length = 10;
        box.width = 20;
        box.height = 30;
        box.weight = 40;

        box.display();

        System.out.println("Weight: " + box.weight);
    }
}
```

Output:

```text
10.0
20.0
30.0
Weight: 40.0
```

The child object can use the inherited `display()` method and accessible fields without defining them again.

## 2. Why do we use inheritance?

1. **Code reusability:** Reuse existing methods and fields instead of rewriting them.
2. **Extensibility:** Add new features to an existing class through a subclass.
3. **Method overriding:** Allow a subclass to provide a specialized implementation of an inherited instance method.
4. **Polymorphism:** Use a parent-class reference to refer to a child-class object.
5. **Logical relationships:** Represent an is-a relationship, such as `Dog is an Animal`.

Inheritance should represent a genuine is-a relationship. It should not be used merely to avoid writing a few lines of code.

## 3. Types of inheritance in Java

Java has several inheritance patterns. The main ones are single, multilevel, hierarchical, multiple, and hybrid inheritance.

### 1. Single inheritance

One child inherits from one parent.

```java
class A {}
class B extends A {}
```

### 2. Multilevel inheritance

A class inherits from a child class, creating a chain.

```java
class A {}
class B extends A {}
class C extends B {}
```

### 3. Hierarchical inheritance

Multiple child classes inherit from the same parent.

```java
class A {}
class B extends A {}
class C extends A {}
```

### 4. Multiple inheritance

One child inherits from multiple parents.

```java
// Not allowed for Java classes:
// class C extends A, B {}
```

Java does not support multiple inheritance of classes, but it supports implementing multiple interfaces.

### 5. Hybrid inheritance

A combination of two or more inheritance patterns. Java can achieve many hybrid designs using classes and interfaces, but not arbitrary multiple inheritance of classes.

## 4. Important rule: Constructors are not inherited

This is one of the most important concepts in Java inheritance.

Consider:

```java
class Box {
    double length;
    double width;

    Box(double length, double width) {
        this.length = length;
        this.width = width;
    }
}

class BoxWeight extends Box {
    double weight;

    BoxWeight(double length, double width, double weight) {
        super(length, width);
        this.weight = weight;
    }
}
```

Usage:

```java
BoxWeight box = new BoxWeight(10, 20, 30);

System.out.println(box.length);
System.out.println(box.width);
System.out.println(box.weight);
```

Output:

```text
10.0
20.0
30.0
```

### What happens?

1. `new BoxWeight(10, 20, 30)` invokes the `BoxWeight` constructor.
2. `super(length, width)` invokes the parent class constructor `Box(double, double)`.
3. The parent constructor initializes `length` and `width`.
4. The child constructor initializes `weight`.

Remember:

- Constructors are not inherited.
- A child constructor can call a parent constructor using `super()`.
- If you do not explicitly call a parent constructor, Java inserts an implicit `super()` only when the parent has an accessible no-argument constructor.
- `this()` calls another constructor in the same class.
- `super()` must be the first statement in a constructor under the traditional Java syntax rules; Java 25 and later allow certain restricted statements before it.

## 5. The `super` keyword

The `super` keyword refers to the superclass part of the current object. It is commonly used for three purposes.

### A. Call the parent constructor

```java
class A {
    A(int x) {
        System.out.println("Parent: " + x);
    }
}

class B extends A {
    B() {
        super(10);
        System.out.println("Child constructor");
    }
}
```

Output:

```text
Parent: 10
Child constructor
```

### B. Access a parent field hidden by a child field

```java
class A {
    int x = 10;
}

class B extends A {
    int x = 20;

    void display() {
        System.out.println(x);
        System.out.println(super.x);
    }
}
```

Output:

```text
20
10
```

Here, `x` refers to the child field, while `super.x` refers to the parent field.

### C. Call a parent method

```java
class A {
    void display() {
        System.out.println("Parent method");
    }
}

class B extends A {
    @Override
    void display() {
        super.display();
        System.out.println("Child method");
    }
}
```

Output:

```text
Parent method
Child method
```

# 1 Multilevel Inheritance in Java

### Definition

Multilevel inheritance is a type of inheritance in which a class (called a derived class) inherits from another class, and that derived class becomes the parent of a third class, and the third class inherits from that derived class, forming a chain of inheritance.

In simple words, one class inherits from a parent class, and another class inherits from that child class.

### Example in Java

```text
Animal
  |
  | Parent class
  v
Dog
  |
  | Child of Animal
  v
Puppy
  |
  | Child of Dog
```

Here, `Dog` inherits from `Animal`, and `Puppy` inherits from `Dog`. Therefore, `Puppy` can access the inherited methods of both `Dog` and `Animal`, provided their access modifiers allow it.

### Full Java program

```java
class Animal {
    void eat() {
        System.out.println("Animal is eating");
    }
}

class Dog extends Animal {
    void bark() {
        System.out.println("Dog is barking");
    }
}

class Puppy extends Dog {
    void weep() {
        System.out.println("Puppy is weeping");
    }
}

public class Main {
    public static void main(String[] args) {
        Puppy p = new Puppy();

        p.eat();   // Inherited from Animal
        p.bark();  // Inherited from Dog
        p.weep();  // Defined in Puppy
    }
}
```

### Output

```text
Animal is eating
Dog is barking
Puppy is weeping
```

### How does it work?

1. `Animal` defines the `eat()` method.
2. `Dog extends Animal`, so `Dog` inherits `eat()` and defines its own `bark()` method.
3. `Puppy extends Dog`, so `Puppy` inherits both `bark()` and `eat()`, and defines its own `weep()` method.
4. We create only one object, `new Puppy()`, and use it to call all three methods.

### Important points

- Multilevel inheritance forms an inheritance chain: `A → B → C`.
- Java supports multilevel inheritance through classes.
- The child class can reuse accessible members from its parent and ancestors.
- It promotes code reusability and reduces code duplication.

**Remember:** In `class C extends B` and `class B extends A`, class `C` can inherit accessible members from both `B` and `A`.

# 2. Multiple Inheritance in Java

## Definition

Multiple inheritance is a type of inheritance in which one child class inherits properties and methods from two or more parent classes.

In Java, multiple inheritance is not supported through classes, meaning a class cannot extend two or more classes. However, Java supports multiple inheritance through interfaces.

## Example

```text
Camera
  |
  | Interface
  |
MusicPlayer
  |
  | Interface
  |
SmartPhone
  |
  | Implements both
```

Here, `SmartPhone` implements both `Camera` and `MusicPlayer` interfaces.

### Full Java Program

```java
interface Camera {
    void takePhoto();
}

interface MusicPlayer {
    void playMusic();
}

class SmartPhone implements Camera, MusicPlayer {

    public void takePhoto() {
        System.out.println("Taking a photo");
    }

    public void playMusic() {
        System.out.println("Playing music");
    }
}

public class Main {
    public static void main(String[] args) {
        SmartPhone phone = new SmartPhone();

        phone.takePhoto();
        phone.playMusic();
    }
}
```

### Output

```text
Taking a photo
Playing music
```

### Explanation

- `Camera` declares the `takePhoto()` method.
- `MusicPlayer` declares the `playMusic()` method.
- `SmartPhone` implements both interfaces and provides implementations for both methods.

**Remember:** `extends` is used to inherit from a class, while `implements` is used to implement interfaces.

---

# 3. Hierarchical Inheritance in Java

## Definition

Hierarchical inheritance is a type of inheritance in which two or more child classes inherit from the same parent class.

## Example

```text
        Animal
      Parent class
        /   \
       /     \
     Dog      Cat
  Child class Child class
```

Here, both `Dog` and `Cat` inherit from the same parent class, `Animal`.

### Full Java Program

```java
class Animal {
    void eat() {
        System.out.println("Animal is eating");
    }
}

class Dog extends Animal {
    void bark() {
        System.out.println("Dog is barking");
    }
}

class Cat extends Animal {
    void meow() {
        System.out.println("Cat is meowing");
    }
}

public class Main {
    public static void main(String[] args) {
        Dog d = new Dog();
        d.eat();
        d.bark();

        Cat c = new Cat();
        c.eat();
        c.meow();
    }
}
```

### Output

```text
Animal is eating
Dog is barking
Animal is eating
Cat is meowing
```

### Explanation

- `Animal` defines the common `eat()` method.
- `Dog` inherits `eat()` and defines `bark()`.
- `Cat` inherits `eat()` and defines `meow()`.
- Both child classes reuse the same parent-class method.

## Difference Between Multiple and Hierarchical Inheritance

| Feature | Multiple Inheritance | Hierarchical Inheritance |
|---|---|---|
| Meaning | One child has multiple parents | Multiple children share one parent |
| Structure | `A + B → C` | `A → B, C` |
| Through Java classes | Not supported | Supported |
| Through interfaces | Supported | Not required |
| Main benefit | Combines multiple capabilities | Reuses common functionality |

### Quick Way to Remember

- **Multiple:** Many parents, one child.
- **Hierarchical:** One parent, many children.
- **Multilevel:** A chain of inheritance, such as `A → B → C`.

# 4. Hybrid Inheritance in Java

## Definition

Hybrid inheritance is a combination of two or more types of inheritance, such as multilevel, hierarchical, and multiple inheritance, within a single program.

In Java, hybrid inheritance is not directly supported through classes alone because Java does not allow a class to extend multiple classes. However, it can be achieved by combining class inheritance with interfaces.

## Example of Hybrid Inheritance

Consider the following structure, which combines hierarchical and multiple inheritance.

```text
             Animal
           Parent class
            /      \
           /        \
         Dog         Cat
      Child class  Child class
           |
           | Implements
           |
           Pet
        Interface
```

Here, `Dog` inherits from `Animal` and implements the `Pet` interface. This combines class inheritance with interface implementation.

## Full Java Program

```java
class Animal {
    void eat() {
        System.out.println("Animal is eating");
    }
}

interface Pet {
    void play();
}

class Dog extends Animal implements Pet {

    void bark() {
        System.out.println("Dog is barking");
    }

    public void play() {
        System.out.println("Dog is playing");
    }
}

class Cat extends Animal {

    void meow() {
        System.out.println("Cat is meowing");
    }
}

public class Main {
    public static void main(String[] args) {
        Dog d = new Dog();

        d.eat();
        d.bark();
        d.play();

        Cat c = new Cat();

        c.eat();
        c.meow();
    }
}
```

### Output

```text
Animal is eating
Dog is barking
Dog is playing
Animal is eating
Cat is meowing
```

## Explanation

1. **Hierarchical inheritance:** Both `Dog` and `Cat` inherit from `Animal`.
2. **Interface implementation:** `Dog` implements `Pet` and provides the `play()` method.
3. **Hybrid inheritance:** The program combines class inheritance and interface implementation to create a hybrid structure.

## Advantages of Hybrid Inheritance

- Promotes code reusability.
- Allows different inheritance patterns to be combined.
- Interfaces allow a class to implement multiple capabilities.
- Helps design flexible and extensible programs.

**Important for exams:** Java does not support hybrid inheritance using classes alone, but hybrid structures can be implemented using classes and interfaces.


# Polymorphism in Java

## 1. Definition of Polymorphism

Polymorphism is an OOP concept in which one entity can take multiple forms. In Java, polymorphism allows the same method name or reference type to work with different objects and exhibit different behaviors depending on the context.

### Meaning of the Word

The word polymorphism comes from two Greek words:

- Poly = many
- Morph = forms

Therefore, polymorphism means "many forms."

For example, the same `sound()` method produces different sounds for different animals:

- Dog → Bark
- Cat → Meow
- Cow → Moo

The method name is the same, but the behavior differs.

## 2. Example of Polymorphism Using Inheritance

```java
class Animal {
    void sound() {
        System.out.println("Animal sound");
    }
}

class Dog extends Animal {
    @Override
    void sound() {
        System.out.println("Bark");
    }
}

class Cat extends Animal {
    @Override
    void sound() {
        System.out.println("Meow");
    }
}

public class Main {
    public static void main(String[] args) {
        Animal a1 = new Dog();
        Animal a2 = new Cat();

        a1.sound();
        a2.sound();
    }
}
```

### Output

```text
Bark
Meow
```

### How Does It Work?

Consider this statement:

```java
Animal a1 = new Dog();
```

- `Animal` is the reference type.
- `a1` is the reference variable.
- `new Dog()` creates the actual `Dog` object.
- `Dog` overrides the `sound()` method inherited from `Animal`.

When Java executes:

```java
a1.sound();
```

It calls `Dog`'s `sound()` method because the actual object is a `Dog`.

Similarly:

```java
Animal a2 = new Cat();
a2.sound();
```

Java calls `Cat`'s `sound()` method because the actual object is a `Cat`.

This is called **runtime polymorphism**, also known as **dynamic method dispatch**.

## 3. Types of Polymorphism in Java

Java commonly supports two types of polymorphism.

### 1. Compile-Time Polymorphism (Static Polymorphism)

The method to use is selected by the compiler based on the method signature and the arguments.

**Achieved through:** Method overloading.

**Example:** `add(int, int)` and `add(double, double)`.

### 2. Runtime Polymorphism (Dynamic Polymorphism)

The overridden instance method implementation is selected at runtime based on the actual object's class.

**Achieved through:** Method overriding and inheritance.

**Example:** `Animal a = new Dog(); a.sound();`.

## 4. Compile-Time Polymorphism: Method Overloading

**Definition:** Method overloading occurs when a class has multiple methods with the same name but different parameter lists.

The methods may differ in the number, types, or order of their parameters.

### Example

```java
class Calculator {

    int add(int a, int b) {
        return a + b;
    }

    int add(int a, int b, int c) {
        return a + b + c;
    }

    double add(double a, double b) {
        return a + b;
    }
}

public class Main {
    public static void main(String[] args) {
        Calculator c = new Calculator();

        System.out.println(c.add(10, 20));
        System.out.println(c.add(10, 20, 30));
        System.out.println(c.add(2.5, 3.5));
    }
}
```

### Output

```text
30
60
6.0
```

### How Does It Work?

- `add(10, 20)` selects the two-`int` version.
- `add(10, 20, 30)` selects the three-`int` version.
- `add(2.5, 3.5)` selects the two-`double` version.

The compiler selects the applicable overload based on the argument types and method overload-resolution rules.

**Important:** Changing only the return type does not create a valid overload.

```java
int display(int x) {
    return x;
}

// Invalid overload if this is the only difference:
double display(int x) {
    return x;
}
```

## 5. Runtime Polymorphism: Method Overriding

**Definition:** Method overriding occurs when a subclass provides its own implementation of an inherited instance method with a compatible signature.

The implementation that runs is determined by the actual object's class at runtime.

### Example

```java
class Animal {
    void sound() {
        System.out.println("Animal sound");
    }
}

class Dog extends Animal {
    @Override
    void sound() {
        System.out.println("Dog barks");
    }
}

class Cat extends Animal {
    @Override
    void sound() {
        System.out.println("Cat meows");
    }
}

public class Main {
    public static void main(String[] args) {
        Animal animal;

        animal = new Dog();
        animal.sound();

        animal = new Cat();
        animal.sound();
    }
}
```

### Output

```text
Dog barks
Cat meows
```

### Why Is This Runtime Polymorphism?

The same reference variable, `animal`, refers to different objects at different times.

```java
animal = new Dog();
animal.sound();
```

The actual object is a `Dog`, so `Dog.sound()` executes.

```java
animal = new Cat();
animal.sound();
```

The actual object is a `Cat`, so `Cat.sound()` executes.

The compiler checks that `sound()` is available through the `Animal` reference type. At runtime, Java dispatches the call to the appropriate overridden implementation.

At runtime, Java executes the method that the compiler selected during compile time. The compiler has already determined which overloaded `add()` method each call refers to.

Let's understand step by step.

## 1. Your Code

```java
class Calculator {

    int add(int a, int b) {
        return a + b;
    }

    int add(int a, int b, int c) {
        return a + b + c;
    }

    double add(double a, double b) {
        return a + b;
    }
}

public class Main {
    public static void main(String[] args) {
        Calculator c = new Calculator();

        System.out.println(c.add(10, 20));
        System.out.println(c.add(10, 20, 30));
        System.out.println(c.add(2.5, 3.5));
    }
}
```

## 2. What Happens at Compile Time?

The compiler examines the arguments in each method call and selects the appropriate overloaded method.

| Method call | Method selected by compiler |
|---|---|
| `c.add(10, 20)` | `add(int a, int b)` |
| `c.add(10, 20, 30)` | `add(int a, int b, int c)` |
| `c.add(2.5, 3.5)` | `add(double a, double b)` |

The compiler also checks that the calls are valid and that their return values can be used as written.

## 3. What Happens at Runtime?

At runtime, the JVM executes the already-selected method for each call.

### First Call

```java
c.add(10, 20);
```

The JVM executes `add(int a, int b)`.

Calculation: `10 + 20 = 30`

Returns `30`.

### Second Call

```java
c.add(10, 20, 30);
```

The JVM executes `add(int a, int b, int c)`.

Calculation: `10 + 20 + 30 = 60`

Returns `60`.

### Third Call

```java
c.add(2.5, 3.5);
```

The JVM executes `add(double a, double b)`.

Calculation: `2.5 + 3.5 = 6.0`

Returns `6.0`.

### Output

```text
30
60
6.0
```

## 4. The Key Difference

- **Compile time:** The compiler determines which overloaded method should be called.
- **Runtime:** The JVM executes that selected method and produces the result.

Unlike runtime polymorphism through method overriding, method overloading does not choose between implementations based on the actual object's type at runtime. Overload selection is based on compile-time types and Java's overload-resolution rules.

```text
 Animal a = new Dog(); in this : what things you have to access depends on Animal a and which one of those versiosn is depends on new Dog().
 ```

**At compile time:** Java checks the reference type to determine which fields and methods can be accessed.

**At runtime:** When an overridden instance method is called, Java checks the actual object's class and executes the appropriate overridden implementation. If the method is not overridden, the inherited implementation executes.

### Example

```java
class Animal {
    int age = 5;

    void sound() {
        System.out.println("Animal sound");
    }
}

class Dog extends Animal {
    int age = 10;

    @Override
    void sound() {
        System.out.println("Dog barks");
    }

    void eat() {
        System.out.println("Dog is eating");
    }
}

public class Main {
    public static void main(String[] args) {
        Animal a = new Dog();

        System.out.println(a.age);
        a.sound();

        // a.eat(); // Compile-time error
    }
}
```

### Output

```text
5
Dog barks
```

### Why Does This Happen?

- `a.age` prints `5` because field access depends on the reference type (`Animal`).
- `a.sound()` prints `Dog barks` because overridden instance method execution depends on the actual object type (`Dog`).
- `a.eat()` causes a compile-time error because `eat()` is not declared in `Animal`.

### Remember This Rule

| At compile time | At runtime |
|---|---|
| Reference type determines accessible members. | Actual object type determines which overridden instance method executes. |
| Checks whether the method call is valid. | Executes the selected method implementation. |
| Field access depends on reference type. | Fields are not dynamically overridden. |

One important detail: Java does not simply check whether a method is overridden every time it runs. Runtime method dispatch selects the appropriate implementation for an overridable instance-method call. Static methods and fields do not use this kind of runtime polymorphism.


# Upcasting and Downcasting in Java

## Upcasting

**Definition:** When a child-class object is assigned to a parent-class reference, it is called upcasting.

## 1. Why Do We Use Upcasting?

Upcasting allows us to refer to different child-class objects using a common parent-class reference. This is useful for writing flexible, reusable code.

```java
class Box {
    void display() {
        System.out.println("I am a Box");
    }
}

class BoxWeight extends Box {
    double weight = 40;

    @Override
    void display() {
        System.out.println("I am a BoxWeight");
    }
}
```

### Example

```java
Box box = new BoxWeight();

box.display();
```

### Output

```text
I am a BoxWeight
```

Here, `Box box = new BoxWeight();` is upcasting.

### Why Is It Useful?

Imagine you have multiple subclasses:

```java
Box box1 = new BoxWeight();
Box box2 = new Box();
```

You can write methods that accept the common `Box` type rather than creating separate methods for every subclass.

```java
static void printBox(Box box) {
    box.display();
}
```

Now you can call:

```java
printBox(new Box());
printBox(new BoxWeight());
```

This is one of the main benefits of upcasting: polymorphism and code reusability.

## 2. Why Do We Use Downcasting?

Downcasting in Java means converting a reference of a parent class into a reference of a child class. It allows you to access child-specific members when the actual object is an instance of that child class.

Downcasting allows us to convert a parent-class reference into a child-class reference when the actual object is of that child type. It is useful when you need to access child-specific fields or methods.

```java
class Box {
}

class BoxWeight extends Box {
    double weight = 40;

    void displayWeight() {
        System.out.println(weight);
    }
}
```

### Example

```java
Box box = new BoxWeight(); // Upcasting

// System.out.println(box.weight); // Compile-time error

BoxWeight bw = (BoxWeight) box; // Downcasting

System.out.println(bw.weight);
bw.displayWeight();
```

### Output

```text
40.0
40.0
```

### Why Is Downcasting Needed?

The reference type `Box` does not declare `weight` or `displayWeight()`. Downcasting lets you access those child-specific members because the actual object is a `BoxWeight`.

Remember, downcasting does not create a new object.

## 3. Upcasting vs. Downcasting

| Feature      | Upcasting                                 | Downcasting                         |
| ------------ | ----------------------------------------- | ----------------------------------- |
| Conversion   | Child reference to parent reference       | Parent reference to child reference |
| Syntax       | Usually implicit                          | Explicit cast required              |
| Main purpose | Polymorphism and generalization           | Access child-specific members       |
| Safety       | Safe for a valid inheritance relationship | Can fail at runtime                 |
| Example      | `Box b = new BoxWeight();`                | `BoxWeight bw = (BoxWeight) b;`     |

## 4. Important: Downcasting Can Fail

```java
Box box = new Box();

BoxWeight bw = (BoxWeight) box;
```

This throws a `ClassCastException` at runtime because the actual object is a `Box`, not a `BoxWeight`.

You can check first:

```java
if (box instanceof BoxWeight) {
    BoxWeight bw = (BoxWeight) box;
    System.out.println(bw.weight);
}
```

## Remember These Two Definitions

- **Upcasting:** Used to treat a child object as its parent type, enabling polymorphism and reusable code.
- **Downcasting:** Used to treat a parent reference as a specific child type to access child-specific members, provided the actual object is compatible.

**Interview tip:** Upcasting is common in polymorphism. Downcasting is less common and should be used carefully because it can cause runtime errors.

---

# Full Java Examples: Without and With Upcasting

Here are the full Java codes for both cases: without using a common parent-type method and with upcasting and polymorphism.

## Case 1: Without a Common Parent-Type Method

We create a separate method for each class, even though all three methods perform the same task.

```java
class Box {
    void display() {
        System.out.println("I am a Box");
    }
}

class BoxWeight extends Box {
    @Override
    void display() {
        System.out.println("I am a BoxWeight");
    }
}

class GiftBox extends Box {
    @Override
    void display() {
        System.out.println("I am a GiftBox");
    }
}

public class Main {

    static void printBox(Box box) {
        box.display();
    }

    static void printBoxWeight(BoxWeight box) {
        box.display();
    }

    static void printGiftBox(GiftBox box) {
        box.display();
    }

    public static void main(String[] args) {
        Box box = new Box();
        BoxWeight boxWeight = new BoxWeight();
        GiftBox giftBox = new GiftBox();

        printBox(box);
        printBoxWeight(boxWeight);
        printGiftBox(giftBox);
    }
}
```

### Output

```text
I am a Box
I am a BoxWeight
I am a GiftBox
```

**Problem:** We need three separate methods to perform essentially the same operation.

## Case 2: Using Upcasting and Polymorphism

Now we use a single method that accepts the parent class `Box`. It can handle objects of `Box`, `BoxWeight`, and `GiftBox`.

```java
class Box {
    void display() {
        System.out.println("I am a Box");
    }
}

class BoxWeight extends Box {
    @Override
    void display() {
        System.out.println("I am a BoxWeight");
    }
}

class GiftBox extends Box {
    @Override
    void display() {
        System.out.println("I am a GiftBox");
    }
}

public class Main {

    static void printBox(Box box) {
        box.display();
    }

    public static void main(String[] args) {
        Box box = new Box();
        BoxWeight boxWeight = new BoxWeight();
        GiftBox giftBox = new GiftBox();

        printBox(box);
        printBox(boxWeight);
        printBox(giftBox);
    }
}
```

### Output

```text
I am a Box
I am a BoxWeight
I am a GiftBox
```

## What Is Happening in Case 2?

Consider this call:

```java
printBox(boxWeight);
```

The method expects a `Box` reference:

```java
static void printBox(Box box) {
    box.display();
}
```

But we pass a `BoxWeight` object. This works because `BoxWeight extends Box`, so Java automatically upcasts the reference when passing the argument.

Inside the method:

- **Reference type:** `Box`
- **Actual object type:** `BoxWeight`
- **Method executed:** `BoxWeight`'s overridden `display()` method

The same method works for all three classes because Java selects the overridden instance method according to the actual object's type at runtime.

## Comparison

| Case 1                                         | Case 2                            |
| ---------------------------------------------- | --------------------------------- |
| Three separate methods                         | One common method                 |
| Repeated code                                  | Less repeated code                |
| Each method accepts a specific class           | Method accepts the parent class   |
| Does not demonstrate this form of polymorphism | Demonstrates runtime polymorphism |

**Conclusion:** Upcasting allows us to pass child-class objects to a method that accepts the parent class. Combined with method overriding, this enables runtime polymorphism and makes code more reusable.

---

# Why Do We Use `@Override`?

`@Override` tells the compiler that you intend to override an inherited method. If you accidentally write the wrong method signature, the compiler can catch the mistake.

### Example

```java
class Box {
    void display() {
        System.out.println("I am a Box");
    }
}

class BoxWeight extends Box {
    @Override
    void displays() { // Compilation error
        System.out.println("I am a BoxWeight");
    }
}
```

Because `displays()` does not override `display()`, the compiler reports an error due to `@Override`.

Without the annotation, `displays()` would simply be a separate method, and `BoxWeight` would inherit the original `display()` method.

## 3. Remember the Difference

| Concept                             | Required?                                              |
| ----------------------------------- | ------------------------------------------------------ |
| Overriding a method                 | No annotation required                                 |
| Writing `@Override`                 | Optional, but recommended                              |
| Using `@Override` to catch mistakes | Yes, it helps the compiler detect incorrect overriding |

**Conclusion:** In your code, you can remove `@Override` and the program will still work. However, using it is a good practice because it helps catch errors during compilation.

# Method Overloading vs. Method Overriding in Java

## 1. Can Method Overloading Occur Without Inheritance?

Yes! You can say that method overloading can occur without inheritance.

Method overloading can happen within a single class.

### Example

```java
class Calculator {
    void add(int a, int b) {
        System.out.println(a + b);
    }

    void add(int a, int b, int c) {
        System.out.println(a + b + c);
    }
}
```

Both methods belong to the same class, `Calculator`. No inheritance is required.

```java
Calculator c = new Calculator();

c.add(10, 20);     // Output: 30
c.add(10, 20, 30); // Output: 60
```

### Remember

- **Overloading:** Can occur without inheritance; it uses different parameter lists.
- **Overriding:** Requires an inheritance or interface implementation relationship to redefine an inherited instance method.

**Exam-ready statement:** Method overloading is a form of compile-time polymorphism that can be achieved within a single class without inheritance.

## 2. Can Method Overloading Occur With Inheritance?

Yes! Method overloading can occur both with inheritance and without inheritance.

### 1. Without Inheritance

Both overloaded methods are in the same class.

```java
class Calculator {
    void add(int a, int b) {
        System.out.println(a + b);
    }

    void add(int a, int b, int c) {
        System.out.println(a + b + c);
    }
}
```

### 2. With Inheritance

A child class can declare an overloaded method with a different parameter list from an inherited method.

```java
class Parent {
    void display(int a) {
        System.out.println("Parent: " + a);
    }
}

class Child extends Parent {
    void display(String name) {
        System.out.println("Child: " + name);
    }
}

public class Main {
    public static void main(String[] args) {
        Child obj = new Child();

        obj.display(10);       // Inherited method
        obj.display("Deva");   // Child's overloaded method
    }
}
```

### Output

```text
Parent: 10
Child: Deva
```

Here, `Child` inherits `display(int)` and declares `display(String)`. Both are available through the `Child` reference and have different parameter lists.

### Remember

- **Overloading:** Can occur with or without inheritance.
- **Overriding:** Requires a subclass or interface implementation to provide a new implementation of an inherited instance method.

## 3. What Is the Difference Between Overloading and Overriding?

In Java, method overloading and method overriding are two different ways to achieve polymorphism.

**Note:** "Riding" is called overriding in Java.

### 1. Method Overloading vs. Method Overriding

| Feature | Method Overloading | Method Overriding |
|---|---|---|
| Meaning | Same method name, different parameter lists | Child class provides a new implementation of an inherited instance method |
| Inheritance | Not required | Required through inheritance or interface implementation |
| Parameters | Must have different parameter lists | Must have the same parameter types |
| Return type | Can differ if parameter lists differ | Must have a compatible return type |
| Polymorphism | Compile-time | Runtime |
| `@Override` | Not applicable | Optional but recommended |

### 2. Example of Overloading

Both methods are in the same class, but their parameters differ.

```java
class Calculator {
    void add(int a, int b) {
        System.out.println(a + b);
    }

    void add(int a, int b, int c) {
        System.out.println(a + b + c);
    }
}
```

Usage:

```java
Calculator c = new Calculator();

c.add(10, 20);     // 30
c.add(10, 20, 30); // 60
```

Java selects the appropriate method at compile time based on the arguments and overload-resolution rules.

### 3. Example of Overriding

The child class provides its own implementation of the parent's method.

```java
class Shapes {
    void area() {
        System.out.println("Inside shapes");
    }
}

class Circle extends Shapes {
    @Override
    void area() {
        System.out.println("Inside circle");
    }
}
```

Usage:

```java
Shapes shape = new Circle();
shape.area();
```

### Output

```text
Inside circle
```

Java selects `Circle`'s implementation at runtime because the actual object is a `Circle`.

### 4. Can Overloading Happen With Inheritance?

Yes! A child class can overload an inherited method by declaring another method with a different parameter list.

```java
class Parent {
    void display(int a) {
        System.out.println(a);
    }
}

class Child extends Parent {
    void display(String name) {
        System.out.println(name);
    }
}
```

Here, `display(int)` is inherited, while `display(String)` is an overloaded method.

### Remember This Simple Rule

- **Overloading:** Same name, different parameters — which method matches the call?
- **Overriding:** Same inherited instance-method signature — which class's implementation should execute?

## 4. Does Overloading Require Parameters?

Not exactly. Method overloading requires different parameter lists, but those parameters do not have to be non-empty in every method.

Let's understand with examples.

### Case 1: Two Methods With No Parameters

```java
class Demo {
    void show() {
        System.out.println("Hello");
    }

    void show() {
        System.out.println("Welcome");
    }
}
```

❌ **Compilation error:** You cannot overload methods by declaring two methods with identical parameter lists. Both have zero parameters.

### Case 2: One Method Without Parameters and Another With Parameters

```java
class Demo {
    void show() {
        System.out.println("Hello");
    }

    void show(int a) {
        System.out.println(a);
    }
}
```

✅ This is method overloading because the parameter lists differ: one has no parameters, and the other has one `int` parameter.

```java
Demo d = new Demo();

d.show();      // Hello
d.show(10);    // 10
```

### Remember

- `show()` and `show(int a)` → Overloading
- `show()` and `show()` in the same class → Not overloading; compilation error

The number, types, or order of parameters must differ for a valid overload. Changing only the return type is insufficient.

## 5. Is Overriding Possible With Parameters?

Yes! Method overriding is absolutely possible with parameters. In fact, the parent and child methods normally must have the same parameter list to override each other.

### Example: Overriding With Parameters

```java
class Parent {
    void display(int a) {
        System.out.println("Parent: " + a);
    }
}

class Child extends Parent {
    @Override
    void display(int a) {
        System.out.println("Child: " + a);
    }
}

public class Main {
    public static void main(String[] args) {
        Parent obj = new Child();
        obj.display(10);
    }
}
```

### Output

```text
Child: 10
```

### Why Is This Overriding?

- Both methods have the same name: `display`.
- Both have the same parameter list: `int a`.
- `Child` inherits from `Parent` and provides its own implementation.
- At runtime, Java executes `Child`'s overridden method because the actual object is a `Child`.

### What If the Parameter Lists Differ?

```java
class Parent {
    void display(int a) {
        System.out.println("Parent");
    }
}

class Child extends Parent {
    void display(String name) {
        System.out.println("Child");
    }
}
```

This is overloading, not overriding, because the parameter lists differ.

### Remember This Rule

| Parent Method | Child Method | Result |
|---|---|---|
| `display()` | `display()` | Overriding |
| `display(int a)` | `display(int a)` | Overriding |
| `display(int a)` | `display(String s)` | Overloading |
| `display(int a)` | `display(int a, int b)` | Overloading |

**Important:** These examples assume the methods are eligible for overriding (for example, they are not `private`, `static`, or `final`).


# Is Every Class in Java a Subclass of the `Object` Class?

In Java, every class implicitly extends the `Object` class if it does not explicitly extend another class. The `Object` class belongs to the `java.lang` package.

However, there is one important detail: if a class extends another class, it inherits from `Object` indirectly through its parent class.

## 1. Example: Without Explicitly Extending `Object`

```java
class Animal {
    void sound() {
        System.out.println("Animal sound");
    }
}
```

Java treats this class as if it were written like this:

```java
class Animal extends Object {
    void sound() {
        System.out.println("Animal sound");
    }
}
```

These two declarations have the same inheritance relationship.

## 2. Example: Through Inheritance

```java
class Animal {
}

class Dog extends Animal {
}
```

The inheritance hierarchy is:

```text
Object
  |
  v
Animal
  |
  v
Dog
```

`Dog` extends `Animal`, and `Animal` extends `Object` implicitly. Therefore, `Dog` indirectly inherits accessible methods from `Object`.

## 3. What Methods Does `Object` Provide?

Some important methods include:

| Method | Purpose |
|---|---|
| `toString()` | Returns a string representation of an object |
| `equals(Object obj)` | Checks logical equality when appropriately implemented |
| `hashCode()` | Returns a hash code |
| `getClass()` | Returns the object's runtime class |
| `wait()` | Used in thread coordination |
| `notify()` | Wakes one waiting thread |
| `notifyAll()` | Wakes waiting threads |

### Example

```java
class Student {
}

public class Main {
    public static void main(String[] args) {
        Student s = new Student();

        System.out.println(s.toString());
        System.out.println(s.getClass());
    }
}
```

This works even though `Student` does not define either method itself.

## Remember for Exams

- A class with no explicit superclass implicitly extends `Object`.
- A class that extends another class inherits from `Object` indirectly.
- `Object` is the root of Java's class inheritance hierarchy.
- `Object` itself does not extend any class.


Dynamic method resolution, late binding, and early binding describe how Java determines which method implementation should be executed. These concepts are closely related to polymorphism.

Let's understand each one with simple examples.

## 1. Dynamic Method Resolution

**Definition:** Dynamic method resolution is the process by which the JVM determines at runtime which overridden instance-method implementation to execute, based on the actual object's class.

### Example

```java
class Animal {
    void sound() {
        System.out.println("Animal sound");
    }
}

class Dog extends Animal {
    @Override
    void sound() {
        System.out.println("Dog barks");
    }
}

public class Main {
    public static void main(String[] args) {
        Animal a = new Dog();
        a.sound();
    }
}
```

### Output

```text
Dog barks
```

### How Does It Work?

1. `Animal a` declares a reference of type `Animal`.
2. `new Dog()` creates an object of class `Dog`.
3. At compile time, Java checks that `sound()` can be called through the `Animal` reference.
4. At runtime, the JVM's method-dispatch mechanism selects `Dog.sound()` because the actual object is a `Dog`.

This is dynamic method resolution and is associated with runtime polymorphism.

## 2. Late Binding (Dynamic Binding)

**Definition:** Late binding means determining the implementation of a method call at runtime rather than fixing it solely from the reference type at compile time.

In the previous example:

```java
Animal a = new Dog();
a.sound();
```

The call to `sound()` uses late binding because the implementation is selected according to the actual object's class at runtime.

If the object were a `Cat` instead, and `Cat` overrode `sound()`, the `Cat` implementation would execute.

```java
Animal a = new Cat();
a.sound(); // Executes Cat.sound(), if overridden
```

Late binding is used for overridden instance methods.

## 3. Early Binding (Static Binding)

**Definition:** Early binding means that the method or member to be used is determined at compile time, based on the available compile-time information.

For example, method overloading uses compile-time overload resolution.

```java
class Calculator {
    void add(int a, int b) {
        System.out.println("Integer addition");
    }

    void add(double a, double b) {
        System.out.println("Double addition");
    }
}
```

### Usage

```java
Calculator c = new Calculator();

c.add(10, 20);       // Integer addition
c.add(2.5, 3.5);     // Double addition
```

The compiler selects the appropriate overload based on the arguments and Java's overload-resolution rules.

Other examples of compile-time selection include field access and static method selection.

## 4. Comparison Table

| Feature | Early Binding | Late Binding |
|---|---|---|
| When selection occurs | Compile time | Runtime |
| Common example | Method overloading | Method overriding |
| Depends on actual object's class? | Not for overload selection | Yes, for overridden instance methods |
| Associated polymorphism | Compile-time polymorphism | Runtime polymorphism |
| Common name | Static binding | Dynamic binding |

## 5. Understand With One Comparison

```java
Animal a = new Dog();
a.sound();
```

- **Compile time:** Java checks whether `sound()` is accessible through the `Animal` reference.
- **Runtime:** Dynamic method dispatch selects `Dog.sound()`.
- **Late binding:** Describes the runtime selection of the implementation.

One important detail: Java doesn't use late binding for every method. Static methods are hidden rather than overridden, and fields are accessed based on the reference's compile-time type.

### Exam-Ready Definitions

- **Dynamic method resolution:** The JVM selects the appropriate overridden instance-method implementation at runtime based on the actual object's class.
- **Late binding:** The implementation of an overridden instance-method call is determined at runtime.
- **Early binding:** The method or member selection is determined at compile time, as with overloaded-method resolution.

**Remember:** Early binding is associated with compile-time selection; late binding is associated with runtime method dispatch.


# Encapsulation and Abstraction in Java

Encapsulation and abstraction are two important pillars of Object-Oriented Programming (OOP) in Java. They both help manage complexity, but they solve different problems.

## 1. Encapsulation in Java

**Definition:** Encapsulation is the process of wrapping data (variables) and the methods that operate on that data into a single unit (class), while restricting direct access to the data using access modifiers.

In simple words, encapsulation means protecting data by controlling how it is accessed and modified.

### Example

```java
class BankAccount {
    private double balance; // Data is hidden

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        }
    }

    public double getBalance() {
        return balance;
    }
}

public class Main {
    public static void main(String[] args) {
        BankAccount account = new BankAccount();

        account.deposit(1000);
        System.out.println(account.getBalance());

        // account.balance = -500; // Compile-time error
    }
}
```

### Output

```text
1000.0
```

### How Does Encapsulation Work?

- `private double balance` prevents direct access to `balance` from outside the `BankAccount` class.
- `deposit()` controls how money is added.
- `getBalance()` provides controlled access to the balance.
- The class can reject invalid values, such as a negative deposit.

### Why Do We Use Encapsulation?

- Data protection and controlled access.
- Validation of data before modification.
- Easier maintenance because internal implementation can change without changing the public interface.

## 2. Abstraction in Java

**Definition:** Abstraction is the process of hiding implementation details and exposing only the essential features or functionality to the user.
In simple words, abstraction means showing what an object does without requiring the user to know how it does it.
Java commonly achieves abstraction through abstract classes and interfaces.
Remember this rule
- A class containing an abstract method must be abstract.
- An abstract class can contain both abstract and concrete methods.
- A concrete subclass must implement all inherited abstract methods.

## 1. What Is a Concrete Method?

A **concrete method** is a method that has a body containing its implementation.

**Example:**

```java
class Car {

    void start() {
        System.out.println("Car starts");
    }
}
```

Here, `start()` is a concrete method because it has a method body `{ }` containing the code to execute.

Compare it with an abstract method:

```java
abstract class Vehicle {

    abstract void start();  // Abstract method

    void stop() {           // Concrete method
        System.out.println("Vehicle stops");
    }
}
```

- `start()` is abstract because it has no implementation.
- `stop()` is concrete because it has an implementation.

## 2. What Is a Concrete Class?

A **concrete class** is a class that can be instantiated to create objects.

**Example:**

```java
class Car {
    void start() {
        System.out.println("Car starts");
    }
}
```

We can create an object of `Car`:

```java
Car c = new Car();  // Valid
c.start();
```

**Output:**

```text
Car starts
```

Therefore, `Car` is a concrete class.

Now consider an abstract class:

```java
abstract class Vehicle {
    abstract void start();
}
```

```java
Vehicle v = new Vehicle(); // Compilation error
```

We cannot instantiate `Vehicle` because it is declared `abstract`.

## 3. Difference at a Glance

| Term | Meaning | Example |
|---|---|---|
| Concrete method | A method with an implementation | `void start() { ... }` |
| Abstract method | A method without an implementation | `abstract void start();` |
| Concrete class | A class that can be instantiated | `class Car { ... }` |
| Abstract class | A class that cannot be instantiated directly | `abstract class Vehicle { ... }` |

## 4. One Important Thing to Remember

A concrete class does not mean that every method must be written directly inside that class. It can inherit concrete implementations from its parent.

**For example:**

```java
abstract class Vehicle {
    abstract void start();

    void stop() {
        System.out.println("Vehicle stops");
    }
}

class Car extends Vehicle {
    @Override
    void start() {
        System.out.println("Car starts");
    }
}
```

`Car` is a concrete class because it implements the inherited abstract `start()` method. It also inherits the already implemented `stop()` method.
```text
Remember: You cannot instantiate an abstract class directly, but you can use an abstract class as a reference type to refer to an object of a concrete subclass.
you cannot create an object of the abstract class.
In Java, static methods and fields cannot be overridden. However, static methods can be hidden, and fields can be hidden when a subclass declares members with the same names.
```
### Example Using an Abstract Class

```java
abstract class Shape {
    abstract void area(); // What needs to be done
}

class Circle extends Shape {
    double radius = 5;

    @Override
    void area() {
        System.out.println(3.14 * radius * radius);
    }
}

public class Main {
    public static void main(String[] args) {
        Shape shape = new Circle();

        shape.area();
    }
}
```

### Output

```text
78.5
```

### How Does Abstraction Work?

- `Shape` declares an abstract method `area()` without providing its implementation.
- `Circle` implements `area()` and defines how to calculate its area.
- The caller invokes `shape.area()` without needing to know the calculation details.
- The abstract class defines what operation is required, while the concrete subclass provides how the operation works.

## 1. Why Can't a Static Method Be Abstract?

An abstract method has no implementation in the parent class and is meant to be implemented by a subclass.

A static method belongs to the class, not to an individual object. Static methods are hidden rather than overridden, so they cannot use runtime polymorphism in the way abstract instance methods do.

❌ **Invalid code:**

```java
abstract class Parent {
    abstract static void display(); // Compilation error
}
```

✅ **Correct code:**

```java
abstract class Parent {
    static void display() {
        System.out.println("Static method");
    }

    abstract void show();
}
```

Here, `display()` is a normal static method, while `show()` is an abstract instance method.

## 2. Why Can't a Constructor Be Abstract?

A constructor initializes an object when it is created. An abstract constructor would have no implementation, which conflicts with the purpose of a constructor.

❌ **Invalid code:**

```java
abstract class Parent {
    abstract Parent(); // Compilation error
}
```

✅ **Correct code:**

```java
abstract class Parent {
    Parent() {
        System.out.println("Parent constructor");
    }

    abstract void display();
}

class Child extends Parent {
    @Override
    void display() {
        System.out.println("Child display");
    }
}
```

**Usage:**

```java
Parent p = new Child();
p.display();
```

**Output:**

```text
Parent constructor
Child display
```

When `new Child()` executes, the parent constructor runs as part of the initialization process, even though `Parent` is abstract.

## 3. Quick Revision Table

| Member | Can Be `abstract`? | Reason |
|---|---|---|
| Instance method | Yes | Subclass can implement it |
| Static method | No | Static methods are hidden, not overridden |
| Constructor | No | Constructors initialize objects and cannot be overridden |
| Instance field | No | Fields cannot be abstract |
| Static field | No | Fields cannot be abstract |

## 3. Difference Between Encapsulation and Abstraction

| Feature | Encapsulation | Abstraction |
|---|---|---|
| Main purpose | Control access to data and implementation | Hide unnecessary implementation details |
| Focus | How data and access are managed | What functionality is exposed |
| Achieved through | Classes, access modifiers, controlled methods | Abstract classes and interfaces, among other techniques |
| Example | `private balance` with `deposit()` | `Shape` declares `area()`; `Circle` implements it |
| Main benefit | Data integrity and controlled modification | Reduced complexity and clear interfaces |

![Abstraction Vs Encapsulation](images\AbstractionVsEncapsulation.png)

# 1. Encapsulation — Bank Account Management

**Professional definition:** Encapsulation bundles data and related methods within a class while restricting direct access to internal state and providing controlled operations to maintain data integrity.

Imagine you're developing banking software. You should not allow other classes to directly change a customer's account balance.

## BankAccount.java

```java
import java.math.BigDecimal;

public class BankAccount {

    private final String accountNumber;
    private BigDecimal balance;

    public BankAccount(String accountNumber, BigDecimal initialBalance) {
        if (initialBalance == null ||
            initialBalance.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("Invalid initial balance");
        }

        this.accountNumber = accountNumber;
        this.balance = initialBalance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void deposit(BigDecimal amount) {
        if (amount == null ||
            amount.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("Invalid deposit amount");
        }

        balance = balance.add(amount);
    }

    public void withdraw(BigDecimal amount) {
        if (amount == null ||
            amount.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("Invalid withdrawal amount");
        }

        if (balance.compareTo(amount) < 0) {
            throw new IllegalStateException("Insufficient balance");
        }

        balance = balance.subtract(amount);
    }
}
```

## Main.java

```java
import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {
        BankAccount account = new BankAccount(
            "ACC101",
            new BigDecimal("10000.00")
        );

        account.deposit(new BigDecimal("2000.00"));
        account.withdraw(new BigDecimal("1500.00"));

        System.out.println(account.getBalance());
    }
}
```

### Output

```text
10500.00
```

### How Is Encapsulation Achieved?

- `private balance` prevents other classes from directly modifying the balance.
- `deposit()` and `withdraw()` provide controlled ways to update it.
- Validation prevents invalid amounts and withdrawals exceeding the available balance.
- `getBalance()` allows the balance to be read without allowing direct assignment.

For example:

```java
// Compilation error: balance is private
// account.balance = new BigDecimal("-5000");
```

**Professional benefit:** The class protects its internal state and enforces business rules. This is especially important in financial applications.


# What Is `BigDecimal` in Java?

Yes! ✅ `BigDecimal` is a **class in Java**, and when you create an instance of it, you get an **object**.

It belongs to the `java.math` package and is used to represent decimal numbers with arbitrary precision. It is particularly useful for financial calculations, such as banking and payments.

## 1. How Do We Create a `BigDecimal` Object?

Consider this statement from our previous example:

```java
BigDecimal balance = new BigDecimal("10000.00");
```

Let's break it down:

| Part | Meaning |
|---|---|
| `BigDecimal` | Class name |
| `balance` | Reference variable |
| `new` | Creates an object |
| `BigDecimal("10000.00")` | Calls the constructor with a `String` argument |
| `"10000.00"` | The decimal value represented by the object |

Conceptually, it works like this:

- `BigDecimal` is the class.
- `new BigDecimal("10000.00")` creates an object.
- `balance` refers to that object.

## 2. Why Use `BigDecimal` Instead of `double`?

Consider this example:

```java
double price = 0.1 + 0.2;
System.out.println(price);
```

**Output:**

```text
0.30000000000000004
```

This happens because `double` uses binary floating-point representation, which cannot represent many decimal fractions exactly.

Using `BigDecimal`:

```java
import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {
        BigDecimal a = new BigDecimal("0.1");
        BigDecimal b = new BigDecimal("0.2");

        BigDecimal result = a.add(b);

        System.out.println(result);
    }
}
```

**Output:**

```text
0.3
```

**Important:** Prefer constructing `BigDecimal` from a `String` when exact decimal values matter. Using `new BigDecimal(0.1)` can preserve the floating-point approximation instead.

## 3. How Does It Work in Our Banking Example?

```java
private BigDecimal balance;
```

Here, `balance` is a **reference variable** declared as a field of the `BankAccount` class.

Then:

```java
this.balance = initialBalance;
```

This assigns the reference held by `initialBalance` to the `balance` field. Both references refer to the same `BigDecimal` object.

When we write:

```java
balance = balance.add(amount);
```

`add()` returns a new `BigDecimal` object representing the sum because `BigDecimal` is **immutable**. It does not modify the original object.

## Remember

- `BigDecimal` → Class.
- `new BigDecimal("100.00")` → Creates an object.
- `balance` → Reference variable.
- `add()` → Adds two values and returns a new `BigDecimal` object.

Unlike primitive types such as `int` and `double`, `BigDecimal` is a **reference type**.


# 1. Is `balance` Pointing to the New Object?

Yes! ✅ Exactly. But there is one important detail: `balance.add(amount)` returns a `BigDecimal` reference representing the result, but `balance` will refer to that returned object only when you assign the result back to it.

Let's understand step by step.

## 1. Consider This Statement

```java
balance = balance.add(amount);
```

Suppose initially:

```java
balance = new BigDecimal("1000.00");
amount = new BigDecimal("500.00");
```

### Step 1: Before Addition

Conceptually:

```text
balance ──────► BigDecimal object (1000.00)

amount  ──────► BigDecimal object (500.00)
```

### Step 2: Java Executes `balance.add(amount)`

```java
balance.add(amount);
```

The `add()` method calculates the sum and returns a `BigDecimal` reference representing `1500.00`.

Conceptually:

```text
balance ──────► BigDecimal object (1000.00)

amount  ──────► BigDecimal object (500.00)

                  BigDecimal object (1500.00)
                  ▲
                  │
                  Returned by add()
```

At this point, the original `balance` reference still points to `1000.00` because we haven't reassigned it.

### Step 3: Assignment Takes Place

```java
balance = balance.add(amount);
```

Now `balance` refers to the returned result:

```text
balance ──────► BigDecimal object (1500.00)

amount  ──────► BigDecimal object (500.00)
```

The original `BigDecimal` object representing `1000.00` remains unchanged.

## 2. What If We Don't Assign the Result?

```java
balance.add(amount);
```

The addition result is returned but ignored.

Therefore, `balance` still refers to the original `BigDecimal` value of `1000.00`.

**Output of `balance` would still be:**

```text
1000.00
```

## Remember This Rule

`BigDecimal` is immutable, meaning its value cannot be changed after its creation.

- `balance.add(amount)` → Returns a `BigDecimal` reference representing the sum.
- `balance = balance.add(amount)` → Assigns the returned reference to `balance`.

This is different from mutable objects, whose internal state can be changed without replacing the reference.

---

# 3. How Does `add()` Create an Object?

Great question! The key is understanding that `add()` is a method already implemented inside Java's `BigDecimal` class. Its implementation calculates the sum and returns a `BigDecimal` reference representing the result.

Let's understand this step by step.

## 1. How Does `add()` Create an Object?

Consider this code:

```java
BigDecimal balance = new BigDecimal("1000.00");
BigDecimal amount = new BigDecimal("500.00");

balance = balance.add(amount);
```

When Java executes:

```java
balance.add(amount);
```

The `add()` method performs the addition and returns a `BigDecimal` representing the result.

Conceptually, you can imagine its implementation working like this:

```java
public BigDecimal add(BigDecimal other) {
    // Calculate the sum.
    BigDecimal result = new BigDecimal(/* sum */);

    return result;
}
```

**Important:** This is simplified illustrative code, not the actual implementation of Java's `BigDecimal.add()` method.

The real implementation is more sophisticated and can reuse an existing object in certain cases. You should not assume that every call necessarily allocates a new object.

## 2. Let's Trace the Execution

Initially:

```java
BigDecimal balance = new BigDecimal("1000.00");
BigDecimal amount = new BigDecimal("500.00");
```

Conceptually:

```text
balance ──────► BigDecimal object (1000.00)

amount  ──────► BigDecimal object (500.00)
```

Now execute:

```java
balance = balance.add(amount);
```

**Step 1:** Java calls `add()` on the object referenced by `balance`.

**Step 2:** The method calculates `1000.00 + 500.00`.

**Step 3:** The method returns a `BigDecimal` representing `1500.00`.

**Step 4:** The assignment makes `balance` refer to the returned result.

Conceptually, the final state is:

```text
balance ──────► BigDecimal object (1500.00)

amount  ──────► BigDecimal object (500.00)
```

The original `1000.00` object remains unchanged.

## 3. But How Can a Method Return an Object?

In Java, a method can return a reference to an object.

For example:

```java
class Student {
    String name;

    Student(String name) {
        this.name = name;
    }
}

public class Main {

    static Student createStudent() {
        Student s = new Student("Rahul");
        return s;
    }

    public static void main(String[] args) {
        Student student = createStudent();

        System.out.println(student.name);
    }
}
```

**Output:**

```text
Rahul
```

Here, `createStudent()` creates a `Student` object and returns a reference to it.

Similarly, `BigDecimal.add()` returns a `BigDecimal` reference representing the calculated result.

## Remember These Three Things

1. `add()` is a method defined by the `BigDecimal` class.
2. Its return type is `BigDecimal`, so it returns a reference to a `BigDecimal` object.
3. `balance = balance.add(amount);` assigns the returned reference to `balance`.

**The important distinction is that a method returning an object does not necessarily mean it creates a brand-new object on every call.**

# Can an Abstract Class Have a Constructor in Java?

Yes! ✅ An abstract class in Java can have a constructor.

Although we cannot instantiate an abstract class directly, its constructor is called when an object of its concrete subclass is created.

## 1. Example

```java
abstract class Vehicle {

    Vehicle() {
        System.out.println("Vehicle constructor called");
    }
}

class Car extends Vehicle {

    Car() {
        System.out.println("Car constructor called");
    }
}

public class Main {
    public static void main(String[] args) {
        Car c = new Car();
    }
}
```

**Output:**

```text
Vehicle constructor called
Car constructor called
```

## 2. Why Is the Abstract Class Constructor Called?

When you execute:

```java
Car c = new Car();
```

Java performs these steps:

1. Memory is allocated for the `Car` object.
2. The `Car` constructor invokes the parent class constructor using `super()` implicitly.
3. The `Vehicle` constructor executes first.
4. The `Car` constructor executes next.

## 3. Why Does an Abstract Class Need a Constructor?

An abstract class can have instance variables that need initialization.

```java
abstract class Vehicle {

    String brand;

    Vehicle(String brand) {
        this.brand = brand;
    }
}

class Car extends Vehicle {

    Car(String brand) {
        super(brand);
    }
}
```

Now:

```java
Car c = new Car("Toyota");
System.out.println(c.brand);
```

**Output:**

```text
Toyota
```

Here, the abstract class constructor initializes the inherited `brand` field.

## 4. Important Interview Distinction

| Statement | Valid? |
|---|---|
| An abstract class can have a constructor. | ✅ Yes |
| We can directly instantiate an abstract class. | ❌ No |
| An abstract class constructor can execute when a subclass object is created. | ✅ Yes |
| An abstract class constructor initializes inherited state. | ✅ Yes |

**Interview-ready answer:** An abstract class can have a constructor because it may need to initialize instance variables. Although we cannot instantiate an abstract class directly, its constructor executes during the construction of a concrete subclass object.

# Access Modifiers in Java

In Java, **access modifiers** (also called access specifiers) control where classes, variables, constructors, and methods can be accessed from.

Java has four access levels:

- `private`
- Default (package-private)
- `protected`
- `public`

## Access Modifiers Table

| Access Modifier | Class | Package | Subclass (Same Package) | Subclass (Different Package) | World (Different Package, Not Subclass) |
|---|:---:|:---:|:---:|:---:|:---:|
| `public` | + | + | + | + | + |
| `protected` | + | + | + | + | |
| Default (no modifier) | + | + | + | | |
| `private` | + | | | | |

**Legend:**
- `+` : Accessible
- Blank : Not accessible

# Protected Access Modifier in Java

`protected` members can be accessed from a different package through inheritance, but not by every unrelated class in that package.

There are two main cases.

## 1. Same Package — Subclass Is Not Required

```java
// File: package1/Animal.java
package package1;

public class Animal {
    protected void sound() {
        System.out.println("Animal sound");
    }
}
```

```java
// File: package1/Test.java
package package1;

public class Test {
    public static void main(String[] args) {
        Animal a = new Animal();
        a.sound(); // Allowed
    }
}
```

Both classes belong to `package1`, so access is allowed.

## 2. Different Package — Subclass Is Required

```java
// File: package1/Animal.java
package package1;

public class Animal {
    protected void sound() {
        System.out.println("Animal sound");
    }
}
```

```java
// File: package2/Dog.java
package package2;

import package1.Animal;

public class Dog extends Animal {
    public void test() {
        sound(); // Allowed
    }
}
```

`Dog` can access `sound()` because it extends `Animal`.

However, an unrelated class in `package2` cannot access it directly:

```java
package package2;

import package1.Animal;

public class Test {
    public static void main(String[] args) {
        Animal a = new Animal();
        // a.sound(); // Compilation error
    }
}
```

## Important Detail About Cross-Package Subclasses

Inside a subclass in another package, protected access has additional restrictions. For instance, `Dog` can call `sound()` through itself or a `Dog` reference, but generally cannot access it through an arbitrary `Animal` reference.

## Remember This Rule

| Location | Can Access `protected` Member? |
|---|---|
| Same class | Yes |
| Different class, same package | Yes |
| Subclass in a different package | Yes, subject to protected-access rules |
| Unrelated class in a different package | No |

**Exam-ready answer:** The `protected` access modifier allows access within the same package and in subclasses located in different packages, subject to Java's inheritance access rules.

When a `protected` member is accessed from a different package, access is allowed through inheritance, subject to Java's protected-access rules. An unrelated class in that different package cannot access it directly.
``` text
implicitly means something happens automatically or without stating it directly, whereas explicitly means stating or writing it directly.
```

# Interface in Java

## 1. What is an interface in Java?

An interface in Java is a blueprint of a class that defines a contract that implementing classes must follow.

It specifies what a class must do, rather than requiring every class to implement the behavior in the same way.

An interface can contain:

- Abstract methods (methods without a body).
- `default` methods (methods with a body).
- `static` methods (methods with a body).
- Constants, which are implicitly `public static final`.
- Private methods (with a body, since Java 9).

**Definition for interviews:**

An interface in Java is a reference type that defines a contract for classes to implement. It supports abstraction and allows a class to implement multiple interfaces.

## 2. Example of an interface

Suppose we have two classes: `Car` and `Bike`. Both can start, but their starting mechanisms may be different.

```java
interface Vehicle {
    void start();
}
```

Here, `Vehicle` is an interface, and `start()` is an abstract method by default because it has no body.

Now, let's implement this interface.

```java
class Car implements Vehicle {

    @Override
    public void start() {
        System.out.println("Car starts with a key");
    }
}

class Bike implements Vehicle {

    @Override
    public void start() {
        System.out.println("Bike starts with a button");
    }
}
```

Let's execute the code:

```java
public class Main {
    public static void main(String[] args) {

        Vehicle car = new Car();
        car.start();

        Vehicle bike = new Bike();
        bike.start();
    }
}
```

**Output:**

```text
Car starts with a key
Bike starts with a button
```

### How does it work?

**Vehicle (Interface)**

`start();`

Implemented using `implements`

**Car**

`start()`

Starts with a key

**Bike**

`start()`

Starts with a button

The interface defines the contract, while each implementing class provides its own implementation of the method.

Notice that we use `implements` instead of `extends` when a class implements an interface.

## 3. How is an interface different from a class?

| Feature | Class | Interface |
|---|---|---|
| Declaration | `class Car` | `interface Vehicle` |
| Purpose | Defines objects and their behavior/state | Defines a contract |
| Object creation | Can instantiate a concrete class | Cannot instantiate an interface directly |
| Constructors | Can have constructors | Cannot have constructors |
| Instance variables | Can have instance variables | Cannot have ordinary instance variables; fields are constants |
| Methods | Can have concrete and abstract methods (if abstract) | Can have abstract, default, static and private methods, subject to Java rules |
| Inheritance | A class can extend only one class | A class can implement multiple interfaces |
| Keyword used by a class | `extends` | `implements` |
| Multiple inheritance | Cannot extend multiple classes | Can implement multiple interfaces |

## 4. Important differences with code

### A. A class can have instance variables, but an interface cannot

**Class:**

```java
class Car {
    int speed = 100;
}
```

**Interface:**

```java
interface Vehicle {
    int MAX_SPEED = 120;
}
```

In an interface, `MAX_SPEED` is implicitly:

```java
public static final int MAX_SPEED = 120;
```

Therefore, you cannot change its value after initialization.

### B. A class can have a constructor, but an interface cannot

```java
class Car {
    Car() {
        System.out.println("Car created");
    }
}
```

This is valid because a class constructor initializes an object.

However, this is invalid:

```java
interface Vehicle {
    Vehicle() { } // Compilation error
}
```

An interface cannot be instantiated directly, so it has no constructor.

### C. A class can implement multiple interfaces

Java does not allow this:

```java
class C extends A, B { } // Compilation error
```

But Java allows this:

```java
interface Camera {
    void takePhoto();
}

interface MusicPlayer {
    void playMusic();
}

class Smartphone implements Camera, MusicPlayer {

    public void takePhoto() {
        System.out.println("Taking photo");
    }

    public void playMusic() {
        System.out.println("Playing music");
    }
}
```

Here, `Smartphone` implements both interfaces.

This is one of the main reasons interfaces are useful: they allow a class to follow multiple contracts without extending multiple classes.

## 5. Can an interface have a method body?

Yes! This is an important interview question.

An interface can have different types of methods.

```java
interface Vehicle {

    // Abstract method
    void start();

    // Default method
    default void stop() {
        System.out.println("Vehicle stopped");
    }

    // Static method
    static void info() {
        System.out.println("Vehicles provide transportation");
    }

    // Private method (Java 9+)
    private void helper() {
        System.out.println("Helper method");
    }
}
```

Remember:

- **Abstract method:** Has no method body.
- **Default method:** Has a body and can be inherited by implementing classes.
- **Static method:** Belongs to the interface and is called using the interface name, such as `Vehicle.info()`.
- **Private method:** Helps reuse code inside the interface's own default or static methods.

An abstract method declared in an interface is implicitly `public abstract`. Therefore, when implementing it, you must use `public` visibility.

## 6. Interface vs abstract class

Since you're learning abstraction in Java, this difference is especially important.

| Abstract class | Interface |
|---|---|
| Declared using `abstract class` | Declared using `interface` |
| Can have instance variables | Fields are implicitly `public static final` |
| Can have constructors | Cannot have constructors |
| Can have abstract and concrete methods | Can have abstract, default, static and private methods |
| A class can extend only one class | A class can implement multiple interfaces |
| Useful for sharing common state and implementation | Useful for defining a common contract across different classes |

**Example to understand the difference:**

- An abstract class `Animal` might contain shared properties such as `name` and `age`, along with common behavior.
- An interface `Flyable` might define a `fly()` contract for a bird, airplane, or drone, even though these are fundamentally different types of things.

A class can also extend an abstract class and implement interfaces simultaneously.

## 7. Quick interview revision

**Q1. What is an interface in Java?**

An interface is a reference type that defines a contract for implementing classes. It supports abstraction and allows a class to implement multiple interfaces.

**Q2. Which keyword is used to implement an interface?**

`implements`.

**Q3. Can we create an object of an interface?**

No, we cannot instantiate an interface directly. However, an interface reference can point to an object of an implementing class.

```java
Vehicle v = new Car();
```

**Q4. Can an interface extend another interface?**

Yes. An interface can extend one or multiple interfaces using `extends`.

**Q5. Can a class implement multiple interfaces?**

Yes.

**Q6. Why do we use interfaces?**

- To achieve abstraction.
- To define common contracts.
- To support multiple inheritance of type.
- To reduce coupling between components.

**Q7. What is the difference between `extends` and `implements`?**

- `extends` is used when a class inherits from another class or an interface inherits from another interface.
- `implements` is used when a class implements an interface.

# Interface in Java

## 1. What is an interface in Java?

An interface in Java is a blueprint of a class that defines a contract that implementing classes must follow.

It specifies what a class must do, rather than requiring every class to implement the behavior in the same way.

An interface can contain:

- Abstract methods (methods without a body).
- `default` methods (methods with a body).
- `static` methods (methods with a body).
- Constants, which are implicitly `public static final`.
- Private methods (with a body, since Java 9).

**Definition for interviews:**

An interface in Java is a reference type that defines a contract for classes to implement. It supports abstraction and allows a class to implement multiple interfaces.

## 2. Example of an interface

Suppose we have two classes: `Car` and `Bike`. Both can start, but their starting mechanisms may be different.

```java
interface Vehicle {
    void start();
}
```

Here, `Vehicle` is an interface, and `start()` is an abstract method by default because it has no body.

Now, let's implement this interface.

```java
class Car implements Vehicle {

    @Override
    public void start() {
        System.out.println("Car starts with a key");
    }
}

class Bike implements Vehicle {

    @Override
    public void start() {
        System.out.println("Bike starts with a button");
    }
}
```

Let's execute the code:

```java
public class Main {
    public static void main(String[] args) {

        Vehicle car = new Car();
        car.start();

        Vehicle bike = new Bike();
        bike.start();
    }
}
```

**Output:**

```text
Car starts with a key
Bike starts with a button
```

### How does it work?

**Vehicle (Interface)**

`start();`

Implemented using `implements`

**Car**

`start()`

Starts with a key

**Bike**

`start()`

Starts with a button

The interface defines the contract, while each implementing class provides its own implementation of the method.

Notice that we use `implements` instead of `extends` when a class implements an interface.

## 3. How is an interface different from a class?

| Feature | Class | Interface |
|---|---|---|
| Declaration | `class Car` | `interface Vehicle` |
| Purpose | Defines objects and their behavior/state | Defines a contract |
| Object creation | Can instantiate a concrete class | Cannot instantiate an interface directly |
| Constructors | Can have constructors | Cannot have constructors |
| Instance variables | Can have instance variables | Cannot have ordinary instance variables; fields are constants |
| Methods | Can have concrete and abstract methods (if abstract) | Can have abstract, default, static and private methods, subject to Java rules |
| Inheritance | A class can extend only one class | A class can implement multiple interfaces |
| Keyword used by a class | `extends` | `implements` |
| Multiple inheritance | Cannot extend multiple classes | Can implement multiple interfaces |

## 4. Important differences with code

### A. A class can have instance variables, but an interface cannot

**Class:**

```java
class Car {
    int speed = 100;
}
```

**Interface:**

```java
interface Vehicle {
    int MAX_SPEED = 120;
}
```

In an interface, `MAX_SPEED` is implicitly:

```java
public static final int MAX_SPEED = 120;
```

Therefore, you cannot change its value after initialization.

### B. A class can have a constructor, but an interface cannot

```java
class Car {
    Car() {
        System.out.println("Car created");
    }
}
```

This is valid because a class constructor initializes an object.

However, this is invalid:

```java
interface Vehicle {
    Vehicle() { } // Compilation error
}
```

An interface cannot be instantiated directly, so it has no constructor.

### C. A class can implement multiple interfaces

Java does not allow this:

```java
class C extends A, B { } // Compilation error
```

But Java allows this:

```java
interface Camera {
    void takePhoto();
}

interface MusicPlayer {
    void playMusic();
}

class Smartphone implements Camera, MusicPlayer {

    public void takePhoto() {
        System.out.println("Taking photo");
    }

    public void playMusic() {
        System.out.println("Playing music");
    }
}
```

Here, `Smartphone` implements both interfaces.

This is one of the main reasons interfaces are useful: they allow a class to follow multiple contracts without extending multiple classes.

## 5. Can an interface have a method body?

Yes! This is an important interview question.

An interface can have different types of methods.

```java
interface Vehicle {

    // Abstract method
    void start();

    // Default method
    default void stop() {
        System.out.println("Vehicle stopped");
    }

    // Static method
    static void info() {
        System.out.println("Vehicles provide transportation");
    }

    // Private method (Java 9+)
    private void helper() {
        System.out.println("Helper method");
    }
}
```

Remember:

- **Abstract method:** Has no method body.
- **Default method:** Has a body and can be inherited by implementing classes.
- **Static method:** Belongs to the interface and is called using the interface name, such as `Vehicle.info()`.
- **Private method:** Helps reuse code inside the interface's own default or static methods.

An abstract method declared in an interface is implicitly `public abstract`. Therefore, when implementing it, you must use `public` visibility.

## 6. Interface vs abstract class

Since you're learning abstraction in Java, this difference is especially important.

| Abstract class | Interface |
|---|---|
| Declared using `abstract class` | Declared using `interface` |
| Can have instance variables | Fields are implicitly `public static final` |
| Can have constructors | Cannot have constructors |
| Can have abstract and concrete methods | Can have abstract, default, static and private methods |
| A class can extend only one class | A class can implement multiple interfaces |
| Useful for sharing common state and implementation | Useful for defining a common contract across different classes |

**Example to understand the difference:**

- An abstract class `Animal` might contain shared properties such as `name` and `age`, along with common behavior.
- An interface `Flyable` might define a `fly()` contract for a bird, airplane, or drone, even though these are fundamentally different types of things.

A class can also extend an abstract class and implement interfaces simultaneously.

## 7. Quick interview revision

**Q1. What is an interface in Java?**

An interface is a reference type that defines a contract for implementing classes. It supports abstraction and allows a class to implement multiple interfaces.

**Q2. Which keyword is used to implement an interface?**

`implements`.

**Q3. Can we create an object of an interface?**

No, we cannot instantiate an interface directly. However, an interface reference can point to an object of an implementing class.

```java
Vehicle v = new Car();
```

**Q4. Can an interface extend another interface?**

Yes. An interface can extend one or multiple interfaces using `extends`.

**Q5. Can a class implement multiple interfaces?**

Yes.

**Q6. Why do we use interfaces?**

- To achieve abstraction.
- To define common contracts.
- To support multiple inheritance of type.
- To reduce coupling between components.

**Q7. What is the difference between `extends` and `implements`?**

- `extends` is used when a class inherits from another class or an interface inherits from another interface.
- `implements` is used when a class implements an interface.

# What Does It Mean?

It means that an **abstract class can implement an interface without providing implementations for all its methods.** A concrete child class can implement the remaining methods later.

Let's understand step by step.

## 1. Step 1: Create an Interface

```java
interface Vehicle {
    void start();
    void stop();
}
```

The `Vehicle` interface declares two abstract methods: `start()` and `stop()`.

Any concrete class implementing this interface must provide implementations for both methods.

## 2. Step 2: Create an Abstract Class

```java
abstract class Car implements Vehicle {

    @Override
    public void start() {
        System.out.println("Car starts");
    }

    // We have not implemented stop()
}
```

**Why is this valid?**

- `Car` implements the `Vehicle` interface.
- `Car` provides the implementation of `start()`.
- `Car` does not implement `stop()`.

Because `Car` is declared `abstract`, Java allows it to leave `stop()` unimplemented.

## 3. Step 3: Create a Concrete Child Class

```java
class SportsCar extends Car {

    @Override
    public void stop() {
        System.out.println("Sports car stops");
    }
}
```

Now, `SportsCar` implements the remaining `stop()` method.

Because `SportsCar` is a concrete class, it must implement all inherited abstract methods.

## 4. Step 4: Create an Object

```java
public class Main {
    public static void main(String[] args) {

        SportsCar car = new SportsCar();

        car.start();
        car.stop();
    }
}
```

**Output:**

```text
Car starts
Sports car stops
```

## Understand the Flow

**Vehicle (Interface)**

Declares `start()` and `stop()`.

↓

**Car (Abstract class)**

Implements `start()` but leaves `stop()` unimplemented.

↓

**SportsCar (Concrete class)**

Implements the remaining `stop()` method.

## The Main Difference

- **Abstract class:** May leave some abstract methods unimplemented.
- **Concrete class:** Must implement all inherited abstract methods unless they have already been implemented by a parent class.

**Interview answer:** An abstract class can implement an interface without implementing all its methods because an abstract class is allowed to contain incomplete behavior. A concrete subclass must provide any remaining implementations before its objects can be created.