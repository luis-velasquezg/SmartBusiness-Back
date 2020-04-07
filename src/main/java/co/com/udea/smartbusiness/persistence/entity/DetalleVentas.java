package co.com.udea.smartbusiness.persistence.entity;

import java.util.Date;
import java.util.List;

public class DetalleVentas {

    private Date fecha;
    private  Producto producto;
    private int cantidad;

    public DetalleVentas() {
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
