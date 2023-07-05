package com.example.demo.service;

import com.example.demo.model.InvoiceDetail;
import com.example.demo.model.InvoiceDetailDTO;
import com.example.demo.repository.InvoiceDetailRepository;
import com.example.demo.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InvoiceDetailService {

    @Autowired
    private InvoiceDetailRepository invoiceDetailRepository
            private ProductRepository productRepository
                    public void saveInvoiceDetail(InvoiceDetail invoiceDetail) throws Exception {
        invoiceDetailRepository.save(invoiceDetail);
                    }

                    public List<InvoiceDetailDTO> getInvoiceDetailByInvoiceId(int invoice_id) throws Exception{
        return invoiceDetailRepository.getInvoicesDetailByInvoicesId(invoice_id);
                    }


}
