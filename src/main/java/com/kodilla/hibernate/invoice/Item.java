package com.kodilla.hibernate.invoice;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Entity
@Table(name="ITEM")
public class Item {
    private int id;
    private Product product;
    private BigDecimal price;
    private int quantity;
    private BigDecimal value;
    private Invoice invoice;

    @ManyToOne(
            cascade = CascadeType.ALL
    )
    @JoinColumn(name = "ITEM_ID")
    public Product getProduct() {
        return product;
    }

    @ManyToOne(
            cascade = CascadeType.ALL
    )
    @JoinColumn(name = "INVOICE_ID")
    public Invoice getInvoice() {
        return invoice;
    }

    public void setInvoice(Invoice invoice) {
        this.invoice = invoice;
    }

    public Item(Product product, BigDecimal price, int quantity, BigDecimal value) {
        this.product = product;
        this.price = price;
        this.quantity = quantity;
        this.value = value;
    }

    public Item() {

    }

    @Id
    @Column(name = "ID", unique = true)
    @GeneratedValue
    @NotNull
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    @Column(name = "PRICE")
    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Column(name = "QUANTITY")
    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Column(name = "VALUE")
    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", product=" + product +
                ", price=" + price +
                ", quantity=" + quantity +
                ", value=" + value +
                ", invoice=" + invoice +
                '}';
    }
}
