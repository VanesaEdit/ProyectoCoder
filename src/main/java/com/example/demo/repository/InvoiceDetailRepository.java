package com.example.demo.repository;

import com.example.demo.model.InvoiceDTO;
import com.example.demo.model.InvoiceDetailDTO;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface InvoiceDetailRepository {

    @Query("SELECT new com.example.demo.model.InvoiceDetailDTO(" +
            "p.title, " +
            "p.code, " +
            "d.price," +
            "d.quantity" +
            ") FROM Invoice i JOIN i.invoiceDetail d JOIN  D.product p WHERE i.id = :invoice_id")
    List<InvoiceDetailDTO> getInvoicesDetailByInvoicesId(@Param("invoice_id") int invoice_id);
}
