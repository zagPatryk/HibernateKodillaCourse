package com.kodilla.hibernate.invoice;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Table(name="INVOICE")
public class Invoice {
    private int id;
    private String number;
    private List<Item> items;

    @OneToMany(
            targetEntity = Item.class,
            mappedBy = "invoice",
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER
    )
    public List<Item> getItems() {
        return items;
    }

    @Id
    @Column(name = "ID", unique = true)
    @GeneratedValue
    @NotNull
    public int getId() {
        return id;
    }

    @Column(name = "NUMBER")
    public String getNumber() {
        return number;
    }

    public Invoice(String number, List<Item> items) {
        this.number = number;
        this.items = items;
    }

    public Invoice() {
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    @Override
    public String toString() {
        return "Invoice{" +
                "id=" + id +
                ", number='" + number + '\'' +
                ", items=" + items +
                '}';
    }
}
