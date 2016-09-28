import java.util.*;

/**
 * Generic implementation of a queue using two stacks (not necessarily optimal).
 * @param <T> the type of value being implemented with the queue.
 */

public class myQueue<T> {
    private Stack<T> mainStack;
    private Stack<T> tempStack;
    private int maxCapacity;
    private int currentCapacity;

    /**
     * Constructor.
     *
     * Initialize two stacks to implement a queue.
     *
     */
    public myQueue() {
        mainStack = new Stack<T>();
        tempStack = new Stack<T>();
    }

    /**
     * Overloaded Constructor.
     *
     * Initialize two stacks to implement a queue.
     * Set a max capacity of elements that the queue can hold.
     *
     */
    public myQueue(int maxCapacity) throws IllegalStateException {
        mainStack = new Stack<T>();
        tempStack = new Stack<T>();

        if (maxCapacity <= 0) {
            throw new IllegalStateException("Invalid queue capacity size. It must" +
                    "be greater than 0.");
        } else {
            this.maxCapacity = maxCapacity;
        }
        currentCapacity = 0;
    }

    /** Add an element to the queue (with stacks).
     *
     * Throw an exception if the current capacity of the queue is greater than the
     * maximum capacity of the queue.
     *
     *  @param element an object or value to add to the queue.
     */
    public void add(T element) {
        try {
            if (currentCapacity >= maxCapacity) {
                throw new IllegalStateException();
            } else {
                mainStack.add(element);
            }
        } catch (IllegalStateException e) {
            System.out.println("You have exceeded the maximum capacity of this queue.");
        }
    }

    /** Returns head of the queue but does not remove it.  */
    public T peek() {
        if (mainStack.isEmpty()) {
            return null;
        } else {
            while (!mainStack.isEmpty()) {
                tempStack.add(mainStack.pop());
            }
            T head = tempStack.peek();
            while (!tempStack.isEmpty()) {
                mainStack.add(tempStack.pop());
            }
            return head;
        }
    }

    /** Returns head of the queue and removes it.  */
    public T remove() {
        if (mainStack.isEmpty()) {
            return null;
        } else {
            while (!mainStack.isEmpty()) {
                tempStack.add(mainStack.pop());
            }
            T head = tempStack.pop();
            while (!tempStack.isEmpty()) {
                mainStack.add(tempStack.pop());
            }
            return head;
        }
    }
}
