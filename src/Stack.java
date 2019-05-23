public class Stack implements IStack {

    private StackNode topNode;
    private int nodeCount;          // keep track of Stack size (Node count)
    private int maxSize;            // ... and Stack max size

    public Stack(int maxSize) throws Exception {
        if (maxSize < 1)
            throw new Exception("stack max size should be greater than zero.");

        this.topNode = null;
        this.nodeCount = 0;
        this.maxSize = maxSize;
    }

    @Override
    public synchronized void push(Object value) throws Exception {
        if (this.nodeCount < this.maxSize) {
            this.topNode = new StackNode(value, this.topNode);      // put new Node on top, with value and link to previous top Node
            this.nodeCount += 1;
        } else {
            throw new Exception("stack size exceeded.");            // Exception if Stack overflows (maxSize)
        }
    }

    @Override
    public synchronized Object pop() {
        if (this.topNode != null) {
            Object value = this.topNode.getValue();
            this.topNode = this.topNode.getPreviousNode();          // previous Node is now on top, popped Node is pending garbage collection

            this.nodeCount -= 1;

            return value;                                           // return value of popped Node
        } else {
            return null;                                            // ... or null when Stack empty
        }
    }

    @Override
    public synchronized Object peek() {
        if (this.topNode != null) {
            return this.topNode.getValue();
        } else {
            return null;
        }
    }

    @Override
    public synchronized void grow(int size) {
        if (size > 0) {
            this.maxSize += size;
        }
    }

    @Override
    public synchronized boolean isEmpty() {
        return (this.nodeCount == 0);
    }

    @Override
    public synchronized boolean isFull() {
        return (this.nodeCount == this.maxSize);
    }

    @Override
    public synchronized int size() {
        return this.nodeCount;
    }

    @Override
    public synchronized int maxSize() {
        return this.maxSize;
    }
}

