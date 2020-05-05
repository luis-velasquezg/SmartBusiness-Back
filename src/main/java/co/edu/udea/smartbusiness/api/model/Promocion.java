package co.edu.udea.smartbusiness.api.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="promociones")
public class Promocion {

    @Id
    @Column(name = "codigo")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int codigo;

    @Column(name = "mensaje")
    private String mensaje;

    @Column(name = "fecha")
    private Date fecha;

    @JoinColumn(name = "codigo_producto", nullable = false)
    @ManyToOne(optional = false,  fetch = FetchType.EAGER)
    private Producto producto;

    @Column(name = "porcentaje_promocion")
    private double porcentajePromocion;

    public Promocion() {
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
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

    public double getPorcentajePromocion() {
        return porcentajePromocion;
    }

    public void setPorcentajePromocion(double porcentajePromocion) {
        this.porcentajePromocion = porcentajePromocion;
    }
}

