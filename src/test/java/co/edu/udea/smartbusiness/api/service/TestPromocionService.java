package co.edu.udea.smartbusiness.api.service;

import co.edu.udea.smartbusiness.api.DTO.PromocionDTO;
import co.edu.udea.smartbusiness.api.model.Configuracion;
import co.edu.udea.smartbusiness.api.model.DetalleVenta;
import co.edu.udea.smartbusiness.api.model.Producto;
import co.edu.udea.smartbusiness.api.model.Promocion;
import co.edu.udea.smartbusiness.api.repository.ConfiguracionRepository;
import co.edu.udea.smartbusiness.api.repository.DetalleVentaRepository;
import co.edu.udea.smartbusiness.api.repository.ProductoRepository;
import co.edu.udea.smartbusiness.api.repository.PromocionRepository;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.junit4.SpringRunner;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

//@PrepareForTest(PromocionServiceImpl.class)

@RunWith(SpringRunner.class)
public class TestPromocionService {

    @TestConfiguration
    static class PromocionServiceImplTestContextConfiguration {

        @Bean
        public PromocionService promocionService() {
            return new PromocionServiceImpl();
        }
}

    @Autowired
    private PromocionService promocionService;

    @MockBean
    private ProductoRepository productoRepositoryMock;

    @MockBean
    private ConfiguracionRepository configuracionRepositoryMock;

    @MockBean
    private DetalleVentaRepository detalleVentaRepositoryMock;

    @MockBean
    private PromocionRepository promocionRepositoryMock;

    Date fecha = new Date();
    Configuracion configuracion;
    Producto producto;
    DetalleVenta detalleVenta;
    Promocion promocion;
    String resultado;
    List <Configuracion> configuraciones;
    List <Producto> productos;
    List <DetalleVenta> detalleVentas;
    List <PromocionDTO> promocionesDTO;

    @Before
    public void setUp(){
        productos = new ArrayList<>();
        detalleVentas= new ArrayList<>();
        producto = new Producto();
        detalleVenta = new DetalleVenta();
        promocion = new Promocion();
        configuraciones = new ArrayList<>();
        configuracion = new Configuracion();
        configuracion.setCostoMayor(100000);
        configuracion.setCantidadMinimaVentas(300);
        configuracion.setCantidadMaximaInventario(100);
        configuraciones.add(configuracion);
        when(configuracionRepositoryMock.findAll()).thenReturn(configuraciones);
        when(detalleVentaRepositoryMock.findByProductoAndFechaAfter(any(Producto.class),any(Date.class))).thenReturn(detalleVentas);
        when(productoRepositoryMock.findAllByInventarioIsGreaterThanEqual(100)).thenReturn(productos);


    }

    @After
    public void tearDown(){
        productos = null;
        detalleVentas= null;
        producto = null;
        detalleVenta = null;
        promocion = null;
        configuraciones = null;
        configuracion = null;
        resultado = null;
    }


    @Test
    public void cuandoCostoProductoVale101000YTiene101DeInventarioYTiene299VentasDebeRetornar40deDescuento(){
        //Arrange
        producto.setCosto(101000);
        producto.setInventario(101);
        productos.add(producto);
        detalleVenta.setCantidad(299);
        detalleVentas.add(detalleVenta);

        //Act
        promocionesDTO = promocionService.calcularPromocion(fecha);
        resultado = promocionesDTO.get(0).getMensaje();

        //Assert
        assertTrue(resultado.contains(configuracion.getPorcentajeDescuento1() *100 +"%"));
    }

    @Test
    public void cuandoCostoProductoVale100000YTiene101DeInventarioYTiene299VentasDebeRetornar30deDescuento(){
        //Arrange
        producto.setCosto(100000);
        producto.setInventario(101);
        productos.add(producto);
        detalleVenta.setCantidad(299);
        detalleVentas.add(detalleVenta);

        //Act
        promocionesDTO = promocionService.calcularPromocion(fecha);
        resultado = promocionesDTO.get(0).getMensaje();

        //Assert
        assertTrue(resultado.contains(configuracion.getPorcentajeDescuento2() *100 +"%"));
    }

    @Test
    public void cuandoCostoProductoVale101000YTiene100DeInventarioYTiene299VentasDebeRetornar20deDescuento(){
        //Arrange
        producto.setCosto(101000);
        producto.setInventario(100);
        productos.add(producto);
        detalleVenta.setCantidad(299);
        detalleVentas.add(detalleVenta);

        //Act
        promocionesDTO = promocionService.calcularPromocion(fecha);
        resultado = promocionesDTO.get(0).getMensaje();

        //Assert
        assertTrue(resultado.contains(configuracion.getPorcentajeDescuento2() *100 +"%"));
    }

    @Test
    public void cuandoCostoProductoVale100000YTiene100DeInventarioYTiene299VentasDebeRetornar20deDescuento(){
        //Arrange
        producto.setCosto(100000);
        producto.setInventario(100);
        productos.add(producto);
        detalleVenta.setCantidad(299);
        detalleVentas.add(detalleVenta);

        //Act
        promocionesDTO = promocionService.calcularPromocion(fecha);
        resultado = promocionesDTO.get(0).getMensaje();

        //Assert
        assertTrue(resultado.contains(configuracion.getPorcentajeDescuento2() *100 +"%"));
    }
}
