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


