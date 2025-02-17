import java.lang.Comparable;

public class NodeType<T extends Comparable<T>> { 
    public T info; 
    public NodeType<T> next; 
    public NodeType<T> back;

    public NodeType() {
        info = null;
        next = null;
        back = null;
    }

    public NodeType(T info) {
        this.info = info;
        next = null;
        back = null;
    }
    public NodeType(T info, NodeType<T> next) {
        this.info = info;
        this.next = next;
        back = null;
    }
    public NodeType(T info, NodeType<T> next, NodeType<T> back) {
        this.info = info;
        this.next = next;
        this.back = back;
    }
    
    public T getInfo() {
        return info;
    }

    public NodeType<T> getNext() {
        return next;
    }

    public NodeType<T> getBack() {
        return back;
    }

    public void setNext(NodeType<T> next) {
        this.next = next;
    }

    public void setBack(NodeType<T> back) {
        this.back = back;
    }
} ;
