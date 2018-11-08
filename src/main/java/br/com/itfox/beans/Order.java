/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.itfox.beans;

import java.util.Date;
import java.util.List;

/**
 *
 * @author belchiorpalma
 */
public class Order {
    private int orderId;
    private Date    orderDate;
    private Client client;
    private String description;
    private String orderStatus;
    private String session;
    private String ip;
    private List<OrderItem> items;
    private float totalSalesOrder;

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    @Override
    public String toString() {
        return "Order{" + "orderId=" + orderId + ", orderDate=" + orderDate + ", description=" + description + ", orderStatus=" + orderStatus + '}';
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public String getSession() {
        return session;
    }

    public void setSession(String session) {
        this.session = session;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public List<OrderItem> getItems() {
        return items;
    }

    public void setItems(List<OrderItem> items) {
        this.items = items;
    }

    public float getTotalSalesOrder() {
        return totalSalesOrder;
    }

    public void setTotalSalesOrder(float totalSalesOrder) {
        this.totalSalesOrder = totalSalesOrder;
    }
    
    
}
