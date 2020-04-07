package co.com.udea.smartbusiness.persistence.entity;

public class Configuracion {
    private int cantidadMinimaProductoPromocion;
    private double costoMayor;
    //Porcentaje que se aplica cuando el producto supera la cantidad mínima del
    // producto configurada y el costo mayor
    private double porcentajeDescuento1;
    //Porcentaje que se aplica cuando el producto supera la cantidad mínima del
    // producto configurada pero no el costo mayor
    private double porcentajeDescuento2;
    //Porcentaje que se aplica cuando el producto no supera la cantidad mínima del
    // producto configurada pero sí el costo mayor
    private double porcentajeDescuento3;
    //Porcentaje que se aplica cuando el producto no supera la cantidad mínima del
    // producto configurada y tampoco el costo mayor
    private double porcentajeDescuento4;

    public Configuracion() {
    }

    public int getCantidadMinimaProductoPromocion() {
        return cantidadMinimaProductoPromocion;
    }

    public void setCantidadMinimaProductoPromocion(int cantidadMinimaProductoPromocion) {
        this.cantidadMinimaProductoPromocion = cantidadMinimaProductoPromocion;
    }

    public double getCostoMayor() {
        return costoMayor;
    }

    public void setCostoMayor(double costoMayor) {
        this.costoMayor = costoMayor;
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
