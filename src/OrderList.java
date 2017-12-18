import java.util.ArrayList;
import java.util.List;

/**
 * Created by Kimiya :) on 17/12/2017.
 */
public class OrderList {

    private Order[] orders;
    private int rear;

    public OrderList() {
        orders = new Order[10000];
        rear = 0;

    }

    /**
     * adds an order to the order list while keeping the list as  max heap
     *
     * @param order the added order
     */
//TODO check
    public void addOrder(Order order) {
        orders[++rear] = order;
        int index = rear;
        while (index > 1 && orders[index].getImmediacyLevel() > orders[index / 2].getImmediacyLevel()) {
            swapOrders(index, index / 2);
            index /= 2;

        }

    }


    /**
     * pops the order at the top of the heap while keeping the list as a max heap
     *
     * @return
     */
    public Order popOrder() {
        Order order = orders[1];
        orders[1] = null;
        heapify(1);

        rear--;
        return order;

    }


    private void heapify(int head) {

        if (orders[head * 2] == null && orders[head * 2 + 1] == null) {
            if (orders[head + 1] != null) {
                orders[head] = orders[head + 1];
                orders[head + 1] = null;
            }
            return;
        }
        if (orders[head * 2] == null && orders[head * 2 + 1] != null) {
            orders[head] = orders[head * 2 + 1];
            orders[head * 2 + 1] = null;
            return;
        }

        if (orders[head * 2 + 1] == null && orders[head * 2] != null) {
            orders[head] = orders[head * 2];
            orders[head * 2] = null;
            return;
        }
        if (orders[head * 2].getImmediacyLevel() > orders[head * 2 + 1].getImmediacyLevel()) {
            orders[head] = orders[head * 2];
            orders[head * 2] = null;
            heapify(head * 2);
        } else if (orders[head * 2].getImmediacyLevel() < orders[head * 2 + 1].getImmediacyLevel()) {
            orders[head] = orders[head * 2 + 1];
            orders[head * 2 + 1] = null;
            heapify(head * 2 + 1);

        } else {
            if (orders[head * 2].getOrderTime() < orders[head * 2 + 1].getOrderTime()) {
                orders[head] = orders[head * 2];
                orders[head * 2] = null;
                heapify(head * 2);
            } else {
                orders[head] = orders[head * 2 + 1];
                orders[head * 2 + 1] = null;
                heapify(head * 2 + 1);
            }
        }
    }

    public boolean isEmpty() {
        return rear == 0;
    }

    public void listOrders() {
        for (int i = 1; i <= rear; i++) {


            System.out.println(orders[i].getCostumerName());

        }
    }

    private void swapOrders(int i1, int i2) {
        Order temp = orders[i1];
        orders[i1] = orders[i2];
        orders[i2] = temp;
    }
}
