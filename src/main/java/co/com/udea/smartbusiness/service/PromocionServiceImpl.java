package co.com.udea.smartbusiness.service;

import co.com.udea.smartbusiness.persistence.DAO.ProductoDao;
import co.com.udea.smartbusiness.persistence.entity.Configuracion;
import co.com.udea.smartbusiness.persistence.entity.Producto;
import co.com.udea.smartbusiness.persistence.entity.Promocion;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PromocionServiceImpl implements PromocionService{
    private ProductoDao productoDao;
    private Producto producto;
    private Promocion promocion;

    public PromocionServiceImpl() {
    }

    public PromocionServiceImpl(ProductoDao productoDao, Producto producto, Promocion promocion) {
        this.productoDao = productoDao;
        this.producto = producto;
        this.promocion = promocion;
    }

    @Override
    public String calcularPromocionMetodoPorDefecto(Date fecha, Configuracion configuracion) {
        List<Producto> productos;
        producto = new Producto();
        promocion = new Promocion();
        int cantidadMinima = 300;
        //Consultamos los productos que tengan mayor inventario
        productos = consultarProductoMayorInventario(cantidadMinima);
        //Consultamos el producto con menores ventas de la lista
        producto = consultarProductoMenorVentaMes(productos, fecha);
        promocion.setProducto(producto);
        promocion.setCodigo(1);
        promocion.setFecha(fecha);
        if(producto.getInventario() > configuracion.getCantidadMinimaProductoPromocion()){
            if(producto.getCosto() > configuracion.getCostoMayor()){
                promocion.setPorcentajePromocion(configuracion.getPorcentajeDescuento1());
            }else{
                promocion.setPorcentajePromocion(configuracion.getPorcentajeDescuento2());
            }
        }else{
            if(producto.getCosto() > configuracion.getCostoMayor()){
                promocion.setPorcentajePromocion(configuracion.getPorcentajeDescuento3());
            }else{
                promocion.setPorcentajePromocion(configuracion.getPorcentajeDescuento4());
            }
        }
        String mensaje= "Usted puede aplicar " + promocion.getPorcentajePromocion() *100 + "% de descuento "
                + "al producto " + promocion.getProducto().getNombre();
        return mensaje;
    }

    private List<Producto> consultarProductoMayorInventario(int cantidadMinima){
        productoDao = new ProductoDao();
        return productoDao.consultarProductosMayorInventario(cantidadMinima);
    }

    private Producto consultarProductoMenorVentaMes(List<Producto> productos, Date fecha){
        productoDao = new ProductoDao();
        return productoDao.consultarProductoMenorVentaMes(productos, fecha);
    }
}
