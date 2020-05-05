package co.edu.udea.smartbusiness.api.DTO;

import co.edu.udea.smartbusiness.api.model.Producto;

import java.util.Date;

public class PromocionDTO {

    private int codigo;
    private String mensaje;
    private Date fecha;
    private Producto producto;
    private double porcentajePromocion;

    public PromocionDTO() {
    }

    public PromocionDTO(int codigo, String mensaje, Date fecha, Producto producto, double porcentajePromocion) {
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


