/**
 * Created by Kimiya :) on 15/12/2017.
 */
public class Node {
    private String data;
    private Node next;
    private Node subNode;
    private int numOfAgenciesUsing;

    public Node(String data) {
        this.data = data;
        this.next = null;
    }

    public Node() {
        data = null;
        next = null;
    }

    public Node addNext(String data) {
        if (next == null)
            next = new Node(data);
        else {
            Node newNode = new Node(data);
            newNode.setNext(next);
            next = newNode;

        }
        return next;
    }

    public void addSub(String data) {
        if (subNode == null) {
            subNode = new Node(data);
        } else {
            Node temp = subNode;
            while (temp.next != null)
                temp = temp.next;
            temp.next = new Node(data);


        }
    }

    public boolean delete(Node prevNode) {
        try {
            prevNode.next = next;
            return true;
        } catch (NullPointerException e) {
            return false;
        }

    }

    public int getNumOfAgenciesUsing() {
        return numOfAgenciesUsing;
    }

    public void setNumOfAgenciesUsing(int numOfAgenciesUsing) {
        this.numOfAgenciesUsing = numOfAgenciesUsing;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public String getData() {
        return data;
    }

    public Node getNext() {
        return next;
    }

    public Node getSubNode() {
        return subNode;
    }

    public boolean hastNext() {
        return next != null;
    }

    public boolean hasSub() {
        return subNode != null;
    }

    public void setData(String data) {
        this.data = data;
    }
}
