import com.sun.org.apache.xpath.internal.operations.Or;

import java.util.ArrayList;
import java.util.List;

/**
 *list of all the current orders in queue. it is a priority queue implemented as a max heap
 */
public class OrderList {

    private Order[] orders;
    private int rear;

    public OrderList() {
        orders = new Order[10000];
        rear = 0;

    }

    /**
     * adds an order to the order list while keeping the list as a max heap
     *
     * @param order the added order
     */

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
        orders[1] = orders[rear];
        orders[rear] = null;
        rear--;
        heapify(1);
        return order;

    }

    /**
     * organizes a heap to become a maz heap by checking the parent with its children
     * and changing  their places if necessary
     * @param head head of the heap
     */
    private void heapify(int head) {
        int leftIndex = head * 2;
        int rightIndex = leftIndex + 1;
        if (leftIndex > rear) {
            return;
        }
        if (leftIndex == rear) {
            if (orders[leftIndex].getImmediacyLevel() > orders[head].getImmediacyLevel()) {
                swapOrders(leftIndex, head);

            } else if (orders[leftIndex].getImmediacyLevel() == orders[head].getImmediacyLevel()) {
                if (orders[leftIndex].getOrderTime() < orders[head].getOrderTime())
                    swapOrders(leftIndex, head);
            }
            return;
        }
        if (orders[head].getImmediacyLevel() > orders[rightIndex].getImmediacyLevel() && orders[head].getImmediacyLevel() > orders[leftIndex].getImmediacyLevel())
            return;
        else {
            if (orders[head].getImmediacyLevel() < orders[rightIndex].getImmediacyLevel() || orders[head].getImmediacyLevel() < orders[leftIndex].getImmediacyLevel()) {
                if (orders[leftIndex].getImmediacyLevel() > orders[rightIndex].getImmediacyLevel()) {
                    swapOrders(head, leftIndex);
                    heapify(leftIndex);
                } else if (orders[leftIndex].getImmediacyLevel() < orders[rightIndex].getImmediacyLevel()) {

                    swapOrders(head, rightIndex);
                    heapify(rightIndex);
                } else {
                    if (orders[leftIndex].getOrderTime() < orders[rightIndex].getOrderTime()) {
                        swapOrders(leftIndex, head);
                        heapify(leftIndex);
                    } else {
                        swapOrders(rightIndex, head);
                        heapify(rightIndex);
                    }
                }

            } else {
                if (orders[head].getImmediacyLevel() > orders[leftIndex].getImmediacyLevel()) {
                    if (orders[head].getOrderTime() > orders[rightIndex].getOrderTime()) {
                        swapOrders(rightIndex, head);
                        heapify(rightIndex);
                    }
                } else if (orders[head].getImmediacyLevel() > orders[rightIndex].getImmediacyLevel()) {
                    if (orders[head].getOrderTime() > orders[leftIndex].getOrderTime()) {
                        swapOrders(leftIndex, head);
                        heapify(leftIndex);
                    }
                } else {
                    if (orders[leftIndex].getOrderTime() > orders[rightIndex].getOrderTime()) {
                        if (orders[head].getOrderTime() > orders[rightIndex].getOrderTime()) {
                            swapOrders(rightIndex, head);
                            heapify(rightIndex);
                        }

                    } else {
                        if (orders[head].getOrderTime() > orders[leftIndex].getOrderTime()) {
                            swapOrders(leftIndex, head);
                            heapify(leftIndex);
                        }
                    }
                }
            }

        }

    }

    public boolean isEmpty() {
        return rear == 0;
    }

    public void listOrders() {
        if (isEmpty())
            System.out.println("list is empty");
        for (int i = 1; i <= rear; i++) {
            try {
                System.out.println(" service" + orders[i].getService().getData() +   " by " + orders[i].getAgency().getName() + " from: " + orders[i].getCostumerName() );
            } catch (NullPointerException e) {
                System.out.println("null");
            }

        }


    }

    private void swapOrders(int i1, int i2) {
        Order temp = orders[i1];
        orders[i1] = orders[i2];
        orders[i2] = temp;
    }
}
