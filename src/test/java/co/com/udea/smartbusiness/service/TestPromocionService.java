package co.com.udea.smartbusiness.service;
import co.com.udea.smartbusiness.persistence.entity.Producto;
import org.junit.Assert;
import org.junit.Test;

public class TestPromocionService {
    @Test
    public void debeRetornarTextoCuandoHayaPromocion(){
        //Arrange
        String resultado = "";
        Producto producto = new Producto();
        producto = null;
        PromocionService promocion = new PromocionServiceImpl();
        //Act
        resultado= promocion.calcularPromocion(producto);
        //Assert
        Assert.assertNotNull(resultado);
    }
}
