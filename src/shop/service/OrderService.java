package shop.service;

import shop.model.Order;

import java.util.Arrays;

public class OrderService {
    static Order[] orders = new Order[200];
    static int count = 0;
    static long idGeneration = 0L;

    public boolean add(Order order){
        order.setId(idGeneration++);
        orders[count++] = order;
        return true;
    }

    public Order[] show(Long id) {
        Order[] myOrders = new Order[count];
        int j = 0;
        for (int i = 0; i < count; i++) {
            if(orders[i].getUserId().equals(id)){
                myOrders[j++] = orders[i];
            }
        }
        return Arrays.copyOf(myOrders,j);
    }
}
