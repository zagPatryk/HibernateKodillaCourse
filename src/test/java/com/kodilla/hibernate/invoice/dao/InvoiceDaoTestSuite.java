package com.kodilla.hibernate.invoice.dao;

import com.kodilla.hibernate.invoice.Invoice;
import com.kodilla.hibernate.invoice.Item;
import com.kodilla.hibernate.invoice.Product;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class InvoiceDaoTestSuite {
    @Autowired
    private InvoiceDao invoiceDao;

    @Test
    public void testInvoiceDaoSave() {
        //Given
        Product product1 = new Product("Product 1");
        Product product2 = new Product("Product 2");

        Item item11 = new Item(product1, BigDecimal.ONE, 1, BigDecimal.TEN);
        Item item12 = new Item(product1, BigDecimal.ONE, 2, BigDecimal.TEN);

        Item item21 = new Item(product2, BigDecimal.ONE, 1, BigDecimal.TEN);

        List<Item> items1 = new ArrayList<>();
        items1.add(item11);
        items1.add(item12);
        items1.add(item21);

        Invoice invoice = new Invoice("Invoice name",items1);

        item11.setInvoice(invoice);
        item12.setInvoice(invoice);
        item21.setInvoice(invoice);

        //When
        invoiceDao.save(invoice);

        //Them

        int invoiceId = invoice.getId();
        Optional<Invoice> readInvoice = invoiceDao.findById(invoiceId);
        Assert.assertTrue(readInvoice.isPresent());

        //CleanUp
        invoiceDao.deleteById(invoiceId);
    }
}
