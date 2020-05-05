package co.edu.udea.smartbusiness.api.model;

import javax.persistence.*;

@Entity
@Table(name="productos")
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="codigo")
    private int codigo;

    @Column(name="nombre")
    private String nombre;

    @Column(name="precio")
    private double precio;

    @Column(name="costo")
    private double costo;

    @Column(name="iva")
    private double iva;

    @Column(name="inventario")
    private int inventario;

    public Producto() {
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }

    public double getIva() {
        return iva;
    }

    public void setIva(double iva) {
        this.iva = iva;
    }

    public int getInventario() {
        return inventario;
    }

    public void setInventario(int inventario) {
        this.inventario = inventario;
    }

}
