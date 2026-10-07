# Array-Based Stack

A Java project demonstrating a generic stack (LIFO) data structure built on an array.
`ArrayBasedStack<T>` implements the `StackADT<T>` interface and automatically doubles
its capacity when full.

## Overview

| Type | Kind | Description |
|------|------|-------------|
| `StackADT<T>` | Interface | Defines isEmpty, peek, pop, push, contains, size, clear, toArray |
| `ArrayBasedStack<T>` | Class | Generic array-backed implementation with `equals()`, `toString()`, and capacity expansion |
| `ArrayBasedStackTest` | Test class | JUnit tests for every method and exception path |

## How It Works

Items are stored in an array with the top of the stack at index `size - 1`. When
`push()` is called on a full stack, `expandCapacity()` doubles the array length and
copies the elements over.

```java
push("U"), push("X"), push("Y") -> [U, X, Y]
peek() -> "Y"
pop() -> "Y" // stack is now [U, X]
```


## Exceptions

| Scenario | Exception |
|----------|-----------|
| `peek()` on an empty stack | `EmptyStackException` |
| `pop()` on an empty stack | `EmptyStackException` |

## Concepts Demonstrated

- **Generics**: a type-parameterized class and interface, including the
  `(T[]) new Object[n]` generic array workaround
- **Constructor chaining**: the default constructor calls `this(100)`
- **Dynamic resizing**: capacity doubles when the stack is full
- **Overriding `equals()` and `toString()`**: stacks are equal if they have the same
  size and the same elements in the same order
- **Null handling**: `contains()` and `toString()` work with null elements
- **Unit testing**: exception paths, resizing past the initial capacity, and every
  `equals()` case (self, null, different class, different size, different
  elements, different order, equal)

## Project Structure

arrayStack/

├── StackADT.java

├── ArrayBasedStack.java

└── ArrayBasedStackTest.java


## Running the Tests

The tests extend `student.TestCase`, so `student.jar` must be on your classpath.

1. Create a Java project and a package named `arrayStack`
2. Place all three `.java` files in that package
3. Add `student.jar` to the project's build path
4. Run `ArrayBasedStackTest` as a JUnit test

## Example Usage

```java
ArrayBasedStack<String> stack = new ArrayBasedStack<>();
stack.push("Apple");
stack.push("Banana");

stack.size();           // 2
stack.peek();           // "Banana"
stack.contains("Apple"); // true
stack.toString();       // "[Apple, Banana]"
stack.pop();            // "Banana"
stack.isEmpty();        // false
```
