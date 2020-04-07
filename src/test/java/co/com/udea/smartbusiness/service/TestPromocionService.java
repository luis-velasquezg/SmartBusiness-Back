package co.com.udea.smartbusiness.service;
import co.com.udea.smartbusiness.persistence.entity.Configuracion;
import co.com.udea.smartbusiness.persistence.entity.Producto;
import org.junit.Assert;
import org.junit.Test;

import java.util.Date;

public class TestPromocionService {
    @Test
    public void testCalcularPromocionMetodoPorDefectoCuandoCostoMayorEs100YCantidadMinimaEs300(){
        //Arrange
        Date fecha = new Date();
        Configuracion configuracion = new Configuracion();
        configuracion.setCantidadMinimaProductoPromocion(300);
        configuracion.setCostoMayor(100);
        configuracion.setPorcentajeDescuento1(0.40);
        configuracion.setPorcentajeDescuento1(0.30);
        configuracion.setPorcentajeDescuento1(0.20);
        configuracion.setPorcentajeDescuento1(0.10);
        String resultado = "";
        PromocionService promocion = new PromocionServiceImpl();
        //Act
        resultado= promocion.calcularPromocionMetodoPorDefecto(fecha, configuracion);
        //Assert
        Assert.assertTrue(resultado.contains(configuracion.getPorcentajeDescuento1()*100 +"%"));
    }

    @Test
    public void testCalcularPromocionMetodoPorDefectoCuandoCostoMayorEs100YCantidadMinimaEs500(){
        //Arrange
        Date fecha = new Date();
        Configuracion configuracion = new Configuracion();
        configuracion.setCantidadMinimaProductoPromocion(500);
        configuracion.setCostoMayor(100);
        configuracion.setPorcentajeDescuento1(0.40);
        configuracion.setPorcentajeDescuento2(0.30);
        configuracion.setPorcentajeDescuento3(0.20);
        configuracion.setPorcentajeDescuento4(0.10);
        String resultado = "";
        PromocionService promocion = new PromocionServiceImpl();
        //Act
        resultado= promocion.calcularPromocionMetodoPorDefecto(fecha, configuracion);
        //Assert
        Assert.assertTrue(resultado.contains(configuracion.getPorcentajeDescuento3()*100 +"%"));
    }

    @Test
    public void testCalcularPromocionMetodoPorDefectoCuandoCostoMayorEs99000YCantidadMinimaEs300(){
        //Arrange
        Date fecha = new Date();
        Configuracion configuracion = new Configuracion();
        configuracion.setCantidadMinimaProductoPromocion(300);
        configuracion.setCostoMayor(99000);
        configuracion.setPorcentajeDescuento1(0.40);
        configuracion.setPorcentajeDescuento1(0.30);
        configuracion.setPorcentajeDescuento1(0.20);
        configuracion.setPorcentajeDescuento1(0.10);
        String resultado = "";
        PromocionService promocion = new PromocionServiceImpl();
        //Act
        resultado= promocion.calcularPromocionMetodoPorDefecto(fecha, configuracion);
        //Assert
        Assert.assertTrue(resultado.contains(configuracion.getPorcentajeDescuento2()*100 +"%"));
    }

    @Test
    public void testCalcularPromocionMetodoPorDefectoCuandoCostoMayorEs9900YCantidadMinimaEs500(){
        //Arrange
        Date fecha = new Date();
        Configuracion configuracion = new Configuracion();
        configuracion.setCantidadMinimaProductoPromocion(500);
        configuracion.setCostoMayor(99000);
        configuracion.setPorcentajeDescuento1(0.40);
        configuracion.setPorcentajeDescuento1(0.30);
        configuracion.setPorcentajeDescuento1(0.20);
        configuracion.setPorcentajeDescuento1(0.10);
        String resultado = "";
        PromocionService promocion = new PromocionServiceImpl();
        //Act
        resultado= promocion.calcularPromocionMetodoPorDefecto(fecha, configuracion);
        //Assert
        Assert.assertTrue(resultado.contains(configuracion.getPorcentajeDescuento4()*100 +"%"));
    }
}
