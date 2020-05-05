package co.edu.udea.smartbusiness.api.service;

import co.edu.udea.smartbusiness.api.model.Configuracion;
import co.edu.udea.smartbusiness.api.model.Promocion;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class TestPromocionService {
    Date fecha = new Date();
    Configuracion configuracion;
    String resultado = "";
    PromocionService promocion;
    List <Promocion> promociones;
    Configuracion configuracionMock = mock(Configuracion.class);


    @Before
    public void setUp(){
        when(configuracionMock.getPorcentajeDescuento1()).thenReturn(0.40);
        when(configuracionMock.getPorcentajeDescuento2()).thenReturn(0.30);
        when(configuracionMock.getPorcentajeDescuento3()).thenReturn(0.20);
        when(configuracionMock.getPorcentajeDescuento4()).thenReturn(0.10);
       // promocion = new PromocionServiceImpl();
    }

    @After
    public void tearDown(){
        resultado = "";
    }


    /*@Test
    public void testCalcularPromocionMetodoPorDefectoCuandoCostoMayorEs100YCantidadMinimaEs300(){
        //Arrange
        when(configuracionMock.getCantidadMinimaProductoPromocion()).thenReturn(300);
        when(configuracionMock.getCostoMayor()).thenReturn(new Double(100));
        //Act
        promociones = promocion.calcularPromocionMetodoPorDefecto(fecha, configuracionMock);
        resultado = promociones.get(1).getMensaje();
        //Assert
        assertTrue(resultado.contains(configuracionMock.getPorcentajeDescuento1()*100 +"%"));
    }

    @Test
    public void testCalcularPromocionMetodoPorDefectoCuandoCostoMayorEs100YCantidadMinimaEs500(){
        //Arrange
        when(configuracionMock.getCantidadMinimaProductoPromocion()).thenReturn(500);
        when(configuracionMock.getCostoMayor()).thenReturn(new Double(100));
        //Act
        promociones = promocion.calcularPromocionMetodoPorDefecto(fecha, configuracionMock);
        resultado = promociones.get(1).getMensaje();
        //Assert
        assertTrue(resultado.contains(configuracionMock.getPorcentajeDescuento3()*100 +"%"));
    }

    @Test
    public void testCalcularPromocionMetodoPorDefectoCuandoCostoMayorEs99000YCantidadMinimaEs300(){
        //Arrange
        when(configuracionMock.getCantidadMinimaProductoPromocion()).thenReturn(300);
        when(configuracionMock.getCostoMayor()).thenReturn(new Double(99000));
        //Act
        promociones = promocion.calcularPromocionMetodoPorDefecto(fecha, configuracionMock);
        resultado = promociones.get(1).getMensaje();
        //Assert
        assertTrue(resultado.contains(configuracionMock.getPorcentajeDescuento2()*100 +"%"));
    }

    @Test
    public void testCalcularPromocionMetodoPorDefectoCuandoCostoMayorEs9900YCantidadMinimaEs500(){
        //Arrange
        when(configuracionMock.getCantidadMinimaProductoPromocion()).thenReturn(500);
        when(configuracionMock.getCostoMayor()).thenReturn(new Double(99000));
        //Act
        promociones = promocion.calcularPromocionMetodoPorDefecto(fecha, configuracionMock);
        resultado = promociones.get(1).getMensaje();
        //Assert
        assertTrue(resultado.contains(configuracionMock.getPorcentajeDescuento4()*100 +"%"));
    }*/
}
