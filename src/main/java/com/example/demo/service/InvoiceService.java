package com.example.demo.service;

import com.example.demo.model.Client;
import com.example.demo.model.Invoice;
import com.example.demo.model.InvoiceDTO;
import com.example.demo.model.RequestInvoice;
import com.example.demo.repository.ClientRepository;
import com.example.demo.repository.InvoiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class InvoiceService {
    @Autowired
    private InvoiceRepository invoiceRepository;
    @Autowired
    private ClientRepository clientRepository;
    public InvoiceDTO postInvoice (RequestInvoice requestInvoice) throws Exception{
        Invoice invoiceCreated = new Invoice();
        invoiceCreated.setCreated_at(new Date().toString());
        System.out.println(requestInvoice.getClient_id());
        Optional<Client> clientExist = clientRepository.findById(requestInvoice.getClient_id());
        System.out.println(clientExist.isEmpty());
        if (clientExist.isEmpty()){
            throw new Exception("Client not found");
        }

        invoiceCreated.setClient(clientExist.get());
        invoiceCreated = invoiceRepository.save(invoiceCreated);
        return new InvoiceDTO(
                invoiceCreated.getId(),
                invoiceCreated.getCreated_at(),
                invoiceCreated.getTotal()
        );
    }

    public List<InvoiceDTO> getInvoicesByClientId (int clientId) throws Exception{
        System.out.println(clientId);
        return invoiceRepository.getInvoicesByClientById(clientId);
    }
    public InvoiceDTO getInvoiceById (int invoice_id) throws Exception{
        Optional<Invoice> invoiceFound = invoiceRepository.findById(invoice_id);
        if (invoiceFound.isEmpty()){
            throw new Exception("Invoice not found");
        }
        return new InvoiceDTO(
                invoiceFound.get().getId(),
                invoiceFound.get().getCreated_at(),
                invoiceFound.get().getTotal()
        );
    }
}
