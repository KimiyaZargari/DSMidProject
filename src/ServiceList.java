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
        if (temp == null){
            System.out.println("no such service found");
            return;
        }
        temp.addSub(subService);
    }

    private Node findService(Node from, String service) {
        while (from != null) {
            if (from.getData().equals(service)) {
                return from;
            }
            if (from.hasSub())
                return findService(from.getSubNode(), service);
            from = from.getNext();
        }
        return null;
    }

}
