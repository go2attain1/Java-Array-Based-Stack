package arrayStack;
import java.util.ArrayList;
import java.util.EmptyStackException;

/**
 * Test class for ArrayBasedStack
 * 
 * @author G.J. Hu
 * @version 2025.08.02
 */

public class ArrayBasedStackTest extends student.TestCase
{
    private ArrayBasedStack<String> stack1;
    
    /**
     * Set up for all test methods. Runs before every test.
     */
    public void setUp() {
        stack1 = new ArrayBasedStack<String>();
    }
    
    /**
     * Tests that the toArray() method returns the expected output
     */  
    public void testToArray() {
        stack1.push("U");
        stack1.push("X");
        stack1.push("Y");
        
        Object[] result = stack1.toArray();
        assertEquals(3, result.length);
        assertEquals("U", result[0]);
        assertEquals("X", result[1]);
        assertEquals("Y", result[2]);
        
        stack1.pop();
        Object[] result2 = stack1.toArray();
        assertEquals(2, result2.length);
        assertEquals("X", result2[1]);
        
        ArrayBasedStack<String> stack0 = new ArrayBasedStack<String>();
        Object[] result0 = stack0.toArray();
        assertEquals(0, result0.length);
    }
    
    /**
     * Tests that the equals() method returns the expected output
     */  
    public void testEquals() {
        assertTrue(stack1.equals(stack1));
        
        Object a = null;
        assertEquals(false, stack1.equals(a));

        Object o = new ArrayList<>();
        assertEquals(false, stack1.equals(o));
        
        ArrayBasedStack<String> stack2 = new ArrayBasedStack<>(3);
        ArrayBasedStack<String> stack3 = new ArrayBasedStack<>(4);
        stack2.push("P");
        stack2.push("T");
        stack3.push("R");
        stack3.push("C");
        stack3.push("D"); 
        assertEquals(false, stack2.equals(stack3));
        
        ArrayBasedStack<String> stack4 = new ArrayBasedStack<>(3);
        stack4.push("A");
        stack4.push("B");
        assertEquals(false, stack2.equals(stack4));
        
        ArrayBasedStack<String> stack5 = new ArrayBasedStack<>(3);
        stack5.push("T");
        stack5.push("P");
        assertEquals(false, stack2.equals(stack5));
        
        ArrayBasedStack<String> stack6 = new ArrayBasedStack<>(4);
        stack6.push("R");
        stack6.push("C");
        stack6.push("D"); 
        assertEquals(true, stack3.equals(stack6));     
    }
    
    /**
     * Tests that the isEmpty() method returns the expected output
     */  
    public void testIsEmpty() {
        ArrayBasedStack<String> stack = new ArrayBasedStack<>(8);
        assertTrue(stack.isEmpty());
        
        stack.push("F");
        assertFalse(stack.isEmpty());
    }
    
    /**
     * Tests that the peek() method returns the expected output
     */  
    public void testPeek() {
        ArrayBasedStack<String> stack7 = new ArrayBasedStack<>(5);
        
        Exception thrown = null; 
        try  
        { 
            stack7.peek();
        }  
        catch (Exception exception)  
        { 
            thrown = exception; 
        } 
         
        assertNotNull(thrown); 
        assertTrue(thrown instanceof EmptyStackException); 
        
        stack1.push("H");
        assertEquals("H", stack1.peek());
    }
    
    /**
     * Tests that the pop() method returns the expected output
     */  
    public void testPop() {
        ArrayBasedStack<String> stack8 = new ArrayBasedStack<>(5);
        stack8.push("A");
        stack8.push("H");
        assertEquals(2, stack8.size());
        
        assertEquals("H", stack8.pop());
        
        assertEquals(1, stack8.size());
        
        ArrayBasedStack<String> stack9 = new ArrayBasedStack<>(5);
        
        Exception thrown = null; 
        try  
        { 
            stack9.pop();
        }  
        catch (Exception exception)  
        { 
            thrown = exception; 
        } 
         
        assertNotNull(thrown); 
        assertTrue(thrown instanceof EmptyStackException);  
    }
    
    /**
     * Tests that the size() method returns the expected output
     */  
    public void testSize() {
        ArrayBasedStack<String> stack10 = new ArrayBasedStack<>(5);
        assertEquals(0, stack10.size());
        stack10.push("Hello");
        assertEquals(1, stack10.size());
        stack10.pop();
        assertEquals(0, stack10.size());
    }
    
    /**
     * Tests that the clear() method returns the expected output
     */  
    public void testClear() {
        ArrayBasedStack<String> stack = new ArrayBasedStack<>(5);
        assertTrue(stack.isEmpty());
        assertEquals(0, stack.size());

        stack.clear();
        assertTrue(stack.isEmpty());
        assertEquals(0, stack.size());

        stack.push("Apple");
        stack.push("Banana");
        stack.push("Cheese");

        assertFalse(stack.isEmpty());
        assertEquals(3, stack.size());

        stack.clear();

        assertTrue(stack.isEmpty());
        assertEquals(0, stack.size());
    }

    /**
     * Tests that the push() method returns the expected output
     */  
    public void testPush() {
        ArrayBasedStack<String> stack = new ArrayBasedStack<>();
        assertEquals(0, stack.size());
       
        stack.push("Apple");
        assertEquals(1, stack.size());
        assertEquals("Apple", stack.peek());
        
        for (int i = 1; i < 101; i++) {
            stack.push("Banana" + i);
        }
        assertEquals(101, stack.size());
        assertEquals("Banana100", stack.peek());
        
        stack.push(null); 
        stack.push("Apple");

        assertEquals("Apple", stack.peek());
    }
    
    /**
     * Tests that the contains() method returns the expected output
     */  
    public void testContains() {
        ArrayBasedStack<String> stack = new ArrayBasedStack<>(2);
        stack.push("Orange");
        assertTrue(stack.contains("Orange"));
        assertFalse(stack.contains("Watermelon"));
        
        assertFalse(stack.contains("Apple"));
        
        stack.push(null);
        assertTrue(stack.contains(null));
    }
    
    /**
     * Tests that the toString() method returns the expected output
     */  
    public void testToString() {
        ArrayBasedStack<String> stack12 = new ArrayBasedStack<>(3);
        stack12.push("Orange");
        stack12.push("Strawberry");
        
        assertEquals(stack12.toString(), "[Orange, Strawberry]");

        ArrayBasedStack<String> emptyStack = new ArrayBasedStack<>();
        assertEquals(emptyStack.toString(), "[]");
    }
}


