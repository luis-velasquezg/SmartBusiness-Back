package co.com.udea.smartbusiness.service;
import co.com.udea.smartbusiness.persistence.entity.Configuracion;
import co.com.udea.smartbusiness.persistence.entity.Promocion;
import org.junit.After;
import org.junit.Test;
import org.junit.Assert;
import org.junit.Before;



import java.util.Date;
import java.util.List;

public class TestPromocionService {
    Date fecha = new Date();
    Configuracion configuracion;
    String resultado = "";
    PromocionService promocion;
    List <Promocion> promociones;

    @Before
    public void setUp(){
        configuracion = new Configuracion();
        configuracion.setPorcentajeDescuento1(0.40);
        configuracion.setPorcentajeDescuento2(0.30);
        configuracion.setPorcentajeDescuento3(0.20);
        configuracion.setPorcentajeDescuento4(0.10);
        promocion = new PromocionServiceImpl();
    }

    @After
    public void tearDown(){
        resultado = "";
    }


    @Test
    public void testCalcularPromocionMetodoPorDefectoCuandoCostoMayorEs100YCantidadMinimaEs300(){
        //Arrange
        configuracion.setCantidadMinimaProductoPromocion(300);
        configuracion.setCostoMayor(100);
        //Act
        promociones = promocion.calcularPromocionMetodoPorDefecto(fecha, configuracion);
        resultado = promociones.get(1).getMensaje();
        //Assert
        Assert.assertTrue(resultado.contains(configuracion.getPorcentajeDescuento1()*100 +"%"));
    }

    @Test
    public void testCalcularPromocionMetodoPorDefectoCuandoCostoMayorEs100YCantidadMinimaEs500(){
        //Arrange

        configuracion.setCantidadMinimaProductoPromocion(500);
        configuracion.setCostoMayor(100);
        //Act
        promociones = promocion.calcularPromocionMetodoPorDefecto(fecha, configuracion);
        resultado = promociones.get(1).getMensaje();
        //Assert
        Assert.assertTrue(resultado.contains(configuracion.getPorcentajeDescuento3()*100 +"%"));
    }

    @Test
    public void testCalcularPromocionMetodoPorDefectoCuandoCostoMayorEs99000YCantidadMinimaEs300(){
        //Arrange
        configuracion.setCantidadMinimaProductoPromocion(300);
        configuracion.setCostoMayor(99000);
        //Act
        promociones = promocion.calcularPromocionMetodoPorDefecto(fecha, configuracion);
        resultado = promociones.get(1).getMensaje();
        //Assert
        Assert.assertTrue(resultado.contains(configuracion.getPorcentajeDescuento2()*100 +"%"));
    }

    @Test
    public void testCalcularPromocionMetodoPorDefectoCuandoCostoMayorEs9900YCantidadMinimaEs500(){
        //Arrange
        configuracion.setCantidadMinimaProductoPromocion(500);
        configuracion.setCostoMayor(99000);
        //Act
        promociones = promocion.calcularPromocionMetodoPorDefecto(fecha, configuracion);
        resultado = promociones.get(1).getMensaje();
        //Assert
        Assert.assertTrue(resultado.contains(configuracion.getPorcentajeDescuento4()*100 +"%"));
    }
}
