package at.htl.control;

import at.htl.entities.Product;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

@ApplicationScoped
public class ProductRepository {

    @Inject
    EntityManager em;

    public Product save(Product product) {
        return em.merge(product);
    }

    public List<Product> findAll() {
        TypedQuery<Product> query = em
                .createNamedQuery("Product.findAll", Product.class);
        return query.getResultList();
    }

    public Product findById(long id) {
        return em.find(Product.class, id);
    }

    public void delete(Product Product) {
        em.remove(Product);
    }
    
}
