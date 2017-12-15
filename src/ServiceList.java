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

    public void addService(String service) {
        if (first == null) {
            first = new Node(service);
            last = first;
        } else {
            last = last.addNext(service);
        }
    }

    public void addSubService(String service, String subService) {

        Node temp = first;
        temp = findService(temp, service);
        if (temp == null) {
            System.out.println("no such service found");
            return;
        }
        temp.addSub(subService);
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

    private Node findService(Node from, String service) {
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
