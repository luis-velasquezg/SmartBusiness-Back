package co.edu.udea.smartbusiness.api.model;

import javax.persistence.*;

@Entity
@Table(name = "configuraciones")
public class Configuracion {
    @Id
    @Column(name="codigo")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int codigo;
    //Cantidad que no debe superarse en el inventario, si se supera, aplicaría promoción
    @Column(name="cant_max_inventario")
    private int cantidadMaximaInventario;

    @Column(name="costo_mayor")
    private double costoMayor;

    //Cantidad mímina que se debe vender, si no se vende, aplicaría promoción
    @Column(name="cant_min_ventas")
    private int cantidadMinimaVentas;

    //Porcentaje que se aplica cuando el producto supera la cantidad mínima del
    // producto configurada y el costo mayor
    @Column(name="porc_desc1")
    private double porcentajeDescuento1;

    //Porcentaje que se aplica cuando el producto supera la cantidad mínima del
    // producto configurada pero no el costo mayor
    @Column(name="porc_desc2")
    private double porcentajeDescuento2;

    //Porcentaje que se aplica cuando el producto no supera la cantidad mínima del
    // producto configurada pero sí el costo mayor
    @Column(name="porc_desc3")
    private double porcentajeDescuento3;

    //Porcentaje que se aplica cuando el producto no supera la cantidad mínima del
    // producto configurada y tampoco el costo mayor
    @Column(name="porc_desc4")
    private double porcentajeDescuento4;

    public Configuracion() {
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getCantidadMaximaInventario() {
        return cantidadMaximaInventario;
    }

    public void setCantidadMaximaInventario(int cantidadMaximaInventario) {
        this.cantidadMaximaInventario = cantidadMaximaInventario;
    }

    public double getCostoMayor() {
        return costoMayor;
    }

    public void setCostoMayor(double costoMayor) {
        this.costoMayor = costoMayor;
    }

    public int getCantidadMinimaVentas() {
        return cantidadMinimaVentas;
    }

    public void setCantidadMinimaVentas(int cantidadMinimaVentas) {
        this.cantidadMinimaVentas = cantidadMinimaVentas;
    }

    public double getPorcentajeDescuento1() {
        return porcentajeDescuento1;
    }

    public void setPorcentajeDescuento1(double porcentajeDescuento1) {
        this.porcentajeDescuento1 = porcentajeDescuento1;
    }

    public double getPorcentajeDescuento2() {
        return porcentajeDescuento2;
    }

    public void setPorcentajeDescuento2(double porcentajeDescuento2) {
        this.porcentajeDescuento2 = porcentajeDescuento2;
    }

    public double getPorcentajeDescuento3() {
        return porcentajeDescuento3;
    }

    public void setPorcentajeDescuento3(double porcentajeDescuento3) {
        this.porcentajeDescuento3 = porcentajeDescuento3;
    }

    public double getPorcentajeDescuento4() {
        return porcentajeDescuento4;
    }

    public void setPorcentajeDescuento4(double porcentajeDescuento4) {
        this.porcentajeDescuento4 = porcentajeDescuento4;
    }
}
