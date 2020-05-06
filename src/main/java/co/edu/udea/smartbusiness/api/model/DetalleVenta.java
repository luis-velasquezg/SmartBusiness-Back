package co.edu.udea.smartbusiness.api.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "detalle_ventas")
public class DetalleVenta {

    @Id
    @Column(name = "codigo")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int codigo;

    @Column(name = "fecha")
    private Date fecha;

    @JoinColumn(name = "codigo_producto", nullable = false)
    @ManyToOne(optional = false,  fetch = FetchType.EAGER)
    private  Producto producto;

    @Column(name = "cantidad")
    private int cantidad;

    public DetalleVenta() {
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
}
