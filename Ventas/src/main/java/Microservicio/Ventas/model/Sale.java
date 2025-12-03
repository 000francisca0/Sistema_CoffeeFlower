package Microservicio.Ventas.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "sales")
public class Sale {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long userId;
    private Long productId;
    private int quantity;
    private double total;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime date;

    public Sale() {
        this.date = LocalDateTime.now();
    }

    // Getters y Setters
    public Long getId(){return id;} public void setId(Long id){this.id=id;}
    public Long getUserId(){return userId;} public void setUserId(Long userId){this.userId=userId;}
    public Long getProductId(){return productId;} public void setProductId(Long productId){this.productId=productId;}
    public int getQuantity(){return quantity;} public void setQuantity(int quantity){this.quantity=quantity;}
    public double getTotal(){return total;} public void setTotal(double total){this.total=total;}
    public LocalDateTime getDate(){return date;} public void setDate(LocalDateTime date){this.date=date;}
}
