package co.com.udea.smartbusiness.persistence.entity;

import java.util.Date;

public class Promocion {
    private int codigo;
    private String mensaje;
    private Date fecha;
    private Producto producto;
    private double porcentajePromocion;

    public Promocion() {
    }

    public Promocion(int codigo, String mensaje, Date fecha, Producto producto, double porcentajePromocion) {
        this.codigo = codigo;
        this.mensaje = mensaje;
        this.fecha = fecha;
        this.producto = producto;
        this.porcentajePromocion = porcentajePromocion;
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

