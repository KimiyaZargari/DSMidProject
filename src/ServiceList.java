/**
 * Created by Kimiya :) on 15/12/2017.
 */
public class ServiceList {
    private Node first;
    private Node last;

    public ServiceList() {
        first = null;
        last = null;
    }

    public boolean addService(String service) {
        Node temp = first;
        if (first == null) {
            first = new Node(service);
            last = first;
        } else if (findService(temp, service) == null) {
            last = last.addNext(service);
        } else
            return false;
        return true;
    }

    public boolean delete(String name) {
        Node temp = first;
        Node next = temp.getNext();
        if (temp.getData().equals(name)) {
            first = next;
            return true;
        }
        while (next != null) {
            if(next.getData().equals(name)){
                temp.setNext(next.getNext());
                return true;
            }
        }
        return  false;
    }

    public boolean addSubService(String service, String subService) {

        Node temp = first;
        Node serviceNode = findService(temp, service);
        if (temp == null) {
            System.out.println("no such service found");
            return false;
        }
        temp = first;
        if (findService(temp, subService) == null) {
            serviceNode.addSub(subService);
            return true;
        }
        return false;
    }

    public void show(Node from) {
        while (from != null) {
            System.out.print(from.getData());
            if (from.hasSub()) {
                System.out.print(" <");
                show(from.getSubNode());
                System.out.print(">");
            }
            if (from.hastNext())
                System.out.print(" , ");
            from = from.getNext();
        }
    }

    public Node findService(Node from, String service) {
        while (from != null) {
            if (from.getData().equals(service)) {
                return from;
            }
            if (from.hasSub()) {
                Node node = findService(from.getSubNode(), service);
                if (node != null)
                    return node;
            }
            from = from.getNext();
        }
        return null;
    }

    public Node getFirst() {
        Node temp = first;
        return temp;
    }

}
