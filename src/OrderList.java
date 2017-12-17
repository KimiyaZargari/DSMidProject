import java.util.ArrayList;
import java.util.List;

/**
 * Created by Kimiya :) on 17/12/2017.
 */
public class OrderList {

    private Order[] orders;
    private int rear;

    public OrderList() {
        orders = new Order[Integer.MAX_VALUE];
        rear = 0;

    }

    /**
     * adds an order to the order list while keeping the list as  max heap
     * @param order the added order
     */

    public void addOrder(Order order) {
        orders[++rear] = order;
        int index = rear;
        while (orders[index].getImmediacyLevel() > orders[index / 2].getImmediacyLevel() && index > 1) {
            Order temp = orders[index];
            orders[index] = orders[index / 2];
            orders[index / 2] = temp;
        }
    }

    /**
     * pops the order at the top of the heap while keeping the list as a max heap
     * @return
     */
    public Order popOrder() {
        Order order = orders[1];
        int index = 1;
        orders[1] = orders[rear];

        while (orders[index].getImmediacyLevel() < orders[index * 2].getImmediacyLevel() || orders[index].getImmediacyLevel() < orders[index * 2 + 1].getImmediacyLevel()){
            index *= 2;
            if(orders[index * 2].getImmediacyLevel() >= orders[index * 2 + 1].getImmediacyLevel()){
                Order temp = orders[index];
                orders[index] = orders[index * 2];
                orders[index * 2] = temp;
            }
            else {
                Order temp = orders[index];
                orders[index] = orders[index * 2 + 1];
                orders[index * 2 + 1] = temp;
                index ++;
            }
        }
        rear --;
        return order;
    }

    public boolean isEmpty() {
        return rear == 0;
    }
}
