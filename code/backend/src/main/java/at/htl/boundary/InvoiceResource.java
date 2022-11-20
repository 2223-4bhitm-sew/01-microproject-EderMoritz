package at.htl.boundary;

import at.htl.control.InvoiceRepository;
import at.htl.entities.Invoice;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

public class InvoiceResource {

    @Inject
    InvoiceRepository invoiceRepository;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Invoice create(Invoice invoice) {
        return invoiceRepository.create(invoice);
    }

    @DELETE
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Invoice delete(Invoice invoice) {
        return invoiceRepository.delete(invoice);
    }

}
