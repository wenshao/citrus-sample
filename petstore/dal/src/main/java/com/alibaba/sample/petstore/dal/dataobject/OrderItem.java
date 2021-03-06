package com.alibaba.sample.petstore.dal.dataobject;

import java.math.BigDecimal;

public class OrderItem {
    private int orderId;
    private int orderItemId;
    private int quantity;
    private String itemId;
    private BigDecimal unitPrice;
    private ProductItem item;
    private BigDecimal total;

    public OrderItem() {
    }

    public OrderItem(int orderItemId, CartItem cartItem) {
        this.orderItemId = orderItemId;
        this.quantity = cartItem.getQuantity();
        this.itemId = cartItem.getProductItem().getProductItemId();
        this.unitPrice = cartItem.getProductItem().getListPrice();
        this.item = cartItem.getProductItem();
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getOrderItemId() {
        return orderItemId;
    }

    public void setOrderItemId(int orderItemId) {
        this.orderItemId = orderItemId;
    }

    public String getProductItemId() {
        return itemId;
    }

    public void setProductItemId(String itemId) {
        this.itemId = itemId;
    }

    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(BigDecimal unitprice) {
        this.unitPrice = unitprice;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public ProductItem getItem() {
        return item;
    }

    public void setItem(ProductItem item) {
        this.item = item;
        calculateTotal();
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
        calculateTotal();
    }

    private void calculateTotal() {
        if (item != null && item.getListPrice() != null) {
            total = item.getListPrice().multiply(new BigDecimal(quantity));
        } else {
            total = null;
        }
    }
}
