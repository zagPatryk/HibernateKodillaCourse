package com.kodilla.hibernate.invoice;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Entity
@Table(name="ITEM")
public class Item {
    @Id
    @Column(name = "ID", unique = true)
    @GeneratedValue
    @NotNull
    private int id;

    @ManyToOne(
            cascade = CascadeType.ALL
    )
    @JoinColumn(name = "ITEM_ID")
    private Product product;

    @Column(name = "PRICE")
    private BigDecimal price;

    @Column(name = "QUANTITY")
    private int quantity;

    @Column(name = "VALUE")
    private BigDecimal value;

    @ManyToOne(
            cascade = CascadeType.ALL
    )
    @JoinColumn(name = "INVOICE_ID")
    private Invoice invoice;

    public Item(Product product, BigDecimal price, int quantity, BigDecimal value) {
        this.product = product;
        this.price = price;
        this.quantity = quantity;
        this.value = value;
    }

    public Item() {

    }

    public void setInvoice(Invoice invoice) {
        this.invoice = invoice;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
