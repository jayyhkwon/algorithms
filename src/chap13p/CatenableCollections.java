package chap13p;

import chap13.Queue;
import chap13.Stack;
import utilities.StdOut;

import java.util.StringJoiner;

/**
 * Problem 1.3.47 Catenable queues, stacks, or steques
 *
 * Add an extra operation catenation that (destructively) concatenates two queues, stacks, or steques.
 * Hint: use a circular linked list, maintaining a pointer to the last item.
 */
public class CatenableCollections<Item> {

    public LinkedListCircular<Item> catenationQueues(Queue<Item> queue1, Queue<Item> queue2) {
        if (queue1 == null || queue2 == null) return null;
        LinkedListCircular<Item> linkedListCircular = new LinkedListCircular<>();
        while (!queue1.isEmpty()) {
            Item item = queue1.dequeue();
            linkedListCircular.insert(item);
        }
        while (!queue2.isEmpty()) {
            Item item = queue2.dequeue();
            linkedListCircular.insert(item);
        }
        return linkedListCircular;
    }

    public LinkedListCircular<Item> catenationStacks(Stack<Item> stack1, Stack<Item> stack2) {
        if (stack1 == null || stack2 == null) return null;
        LinkedListCircular<Item> linkedListCircular = new LinkedListCircular<>();
        Stack<Item> tempStack1 = new Stack<>();
        while (!stack1.isEmpty()) {
            Item item = stack1.pop();
            tempStack1.push(item);
        }
        while (!tempStack1.isEmpty()) {
            Item item = tempStack1.pop();
            linkedListCircular.insert(item);
        }
        Stack<Item> tempStack2 = new Stack<>();
        while (!stack2.isEmpty()) {
            Item item = stack2.pop();
            tempStack2.push(item);
        }
        while (!tempStack2.isEmpty()) {
            Item item = tempStack2.pop();
            linkedListCircular.insert(item);
        }
        return linkedListCircular;
    }

    public LinkedListCircular<Item> catenationSteques(Steque<Item> steque1, Steque<Item> steque2) {
        if (steque1 == null || steque2 == null) return null;
        LinkedListCircular<Item> linkedListCircular = new LinkedListCircular<>();
        while (!steque1.isEmpty()) {
            Item item = steque1.pop();
            linkedListCircular.insert(item);
        }
        while (!steque2.isEmpty()) {
            Item item = steque2.pop();
            linkedListCircular.insert(item);
        }
        return linkedListCircular;
    }

    public static void main(String[] args) {
        CatenableCollections<Integer> catenableCollections = new CatenableCollections<>();

        StdOut.println("Catenation of queues");
        testQueueCatenation(catenableCollections);

        StdOut.println("Catenation of stacks");
        testStackCatenation(catenableCollections);

        StdOut.println("Catenation of steques");
        testStequeCatenation(catenableCollections);
    }

    private static void testStequeCatenation(CatenableCollections<Integer> catenableCollections) {
        Steque<Integer> steque1 = new Steque<>();
        steque1.enqueue(0);
        steque1.enqueue(1);
        steque1.enqueue(2);
        steque1.enqueue(3);

        Steque<Integer> steque2 = new Steque<>();
        steque2.enqueue(7);
        steque2.enqueue(8);
        steque2.enqueue(9);

        LinkedListCircular<Integer> linkedListCircular = catenableCollections.catenationSteques(steque1, steque2);

        StringJoiner linkedListItems = new StringJoiner(" ");
        for (int item : linkedListCircular) {
            linkedListItems.add(String.valueOf(item));
        }

        StdOut.println("Result after catenation: " + linkedListItems.toString());
        StdOut.println("Expected: 0 1 2 3 7 8 9");

        StdOut.println();

        StringJoiner steque1Items = new StringJoiner(" ");
        for (int item : steque1) {
            steque1Items.add(String.valueOf(item));
        }

        StdOut.println("Steque 1 after catenation: " + steque1Items.toString());
        StdOut.println("Expected: ");

        StdOut.println();

        StringJoiner steque2Items = new StringJoiner(" ");
        for (int item : steque2) {
            steque2Items.add(String.valueOf(item));
        }

        StdOut.println("Steque 2 after catenation: " + steque2Items.toString());
        StdOut.println("Expected: ");
    }

    private static void testStackCatenation(CatenableCollections<Integer> catenableCollections) {
        Stack<Integer> stack1 = new Stack<>();
        stack1.push(0);
        stack1.push(1);
        stack1.push(2);
        stack1.push(3);

        Stack<Integer> stack2 = new Stack<>();
        stack2.push(7);
        stack2.push(8);
        stack2.push(9);

        LinkedListCircular<Integer> linkedListCircular = catenableCollections.catenationStacks(stack1, stack2);

        StringJoiner linkedListItems = new StringJoiner(" ");
        for (int item : linkedListCircular) {
            linkedListItems.add(String.valueOf(item));
        }

        StdOut.println("Result after catenation: " + linkedListItems.toString());
        StdOut.println("Expected: 0 1 2 3 7 8 9");

        StdOut.println();

        StringJoiner stack1Items = new StringJoiner(" ");
        for (int item : stack1) {
            stack1Items.add(String.valueOf(item));
        }

        StdOut.println("Stack 1 after catenation: " + stack1.toString());
        StdOut.println("Expected: ");

        StdOut.println();

        StringJoiner stack2Items = new StringJoiner(" ");
        for (int item : stack2) {
            stack2Items.add(String.valueOf(item));
        }

        StdOut.println("Stack 2 after catenation: " + stack2Items.toString());
        StdOut.println("Expected: ");
        StdOut.println();
    }

    private static void testQueueCatenation(CatenableCollections<Integer> catenableCollections) {
        Queue<Integer> queue1 = new Queue<>();
        queue1.enqueue(0);
        queue1.enqueue(1);
        queue1.enqueue(2);
        queue1.enqueue(3);

        Queue<Integer> queue2 = new Queue<>();
        queue2.enqueue(7);
        queue2.enqueue(8);
        queue2.enqueue(9);

        LinkedListCircular<Integer> linkedListCircular = catenableCollections.catenationQueues(queue1, queue2);

        StringJoiner linkedListItems = new StringJoiner(" ");
        for (int item : linkedListCircular) {
            linkedListItems.add(String.valueOf(item));
        }

        StdOut.println("Result after catenation: " + linkedListItems.toString());
        StdOut.println("Expected: 0 1 2 3 7 8 9");

        StdOut.println();

        StringJoiner queue1Items = new StringJoiner(" ");
        for (int item : queue1) {
            queue1Items.add(String.valueOf(item));
        }

        StdOut.println("Queue 1 after catenation: " + queue1Items.toString());
        StdOut.println("Expected: ");

        StdOut.println();

        StringJoiner queue2Items = new StringJoiner(" ");
        for (int item : queue2) {
            queue1Items.add(String.valueOf(item));
        }

        StdOut.println("Queue 2 after catenation: " + queue2Items.toString());
        StdOut.println("Expected: ");
        StdOut.println();
    }

}
