public class StackNode implements IStackNode {

    private Object value;
    private StackNode previousNode = null;

    public StackNode(Object value, StackNode previousNode) {
        this.previousNode = previousNode;
        this.value = value;
    }

    public StackNode(Object value) {
        this.value = value;
    }

    @Override
    public Object getValue() {
        return this.value;
    }

    @Override
    public StackNode getPreviousNode() {
        return this.previousNode;
    }

}
