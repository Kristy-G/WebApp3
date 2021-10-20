package services;

import dao.OrderDao;
import tables.OrderTable;

import java.util.List;

public class OrderService {
    private OrderDao orderDao = new OrderDao();

    public OrderService() {
    }

    public OrderTable findOrder(int id) {
        return orderDao.findById(id);
    }

    public void saveOrder(OrderTable order) {
        orderDao.save(order);
    }

    public void deleteOrder(OrderTable order) {
        orderDao.delete(order);
    }

    public void updateOrder(OrderTable order) {
        orderDao.update(order);
    }

    public List<OrderTable> findAllOrders() {
        return orderDao.findAll();
    }

    public List<OrderTable> findBySubject(String s) {
        return orderDao.findBySubject(s);
    }

    public List<OrderTable> findDeadline(String s) {
        return orderDao.findByDeadline(s);
    }


}
