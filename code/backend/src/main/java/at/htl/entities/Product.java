package at.htl.entities;

import org.postgresql.largeobject.LargeObject;

import javax.persistence.*;

@NamedQueries({
        @NamedQuery(
                name = "Product.findAll",
                query = "select b from Product b"
        )
})
@Entity
@Table(name = "PRODUCTS")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "P_ID")
    private Long productID;

    @Column(name = "P_TYPE")
    String teaType;

    @Column(name = "P_PRICE")
    double price;

    public Product() {
    }

    public Product(Long productID, String teaType, double price) {
        this.productID = productID;
        this.teaType = teaType;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productID=" + productID +
                ", teaType='" + teaType + '\'' +
                ", price=" + price +
                '}';
    }

    public Long getProductID() {
        return productID;
    }

    public void setProductID(Long productID) {
        this.productID = productID;
    }

    public String getTeaType() {
        return teaType;
    }

    public void setTeaType(String teaType) {
        this.teaType = teaType;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
