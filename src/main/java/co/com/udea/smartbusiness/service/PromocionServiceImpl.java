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
    private List<Producto> productos;
    private List <Promocion> promociones;
    private Promocion promocion;

    public PromocionServiceImpl() {
    }

    @Override
    public List <Promocion> calcularPromocionMetodoPorDefecto(Date fecha, Configuracion configuracion) {

        promociones = new ArrayList<>();
        //Consultamos los productos que tengan mayor inventario
        productos = consultarProductoMayorInventario(configuracion.getCantidadMinimaProductoPromocion());
        //Consultamos el producto con menores ventas de la lista
        productos = consultarProductoMenorVentaMes(productos, fecha);
        int cantProductos = productos.size();
        for(int i = 0; i < cantProductos; i++){
            promocion = new Promocion();
            promocion.setProducto(productos.get(i));
            promocion.setCodigo(i + 1);
            promocion.setFecha(fecha);
            if(productos.get(i).getInventario() > configuracion.getCantidadMinimaProductoPromocion()){
                if(productos.get(i).getCosto() > configuracion.getCostoMayor()){
                    promocion.setPorcentajePromocion(configuracion.getPorcentajeDescuento1());
                }else{
                    promocion.setPorcentajePromocion(configuracion.getPorcentajeDescuento2());
                }
            }else{
                if(productos.get(i).getCosto() > configuracion.getCostoMayor()){
                    promocion.setPorcentajePromocion(configuracion.getPorcentajeDescuento3());
                }else{
                    promocion.setPorcentajePromocion(configuracion.getPorcentajeDescuento4());
                }
            }
            String mensaje = "Usted puede aplicar " + promocion.getPorcentajePromocion() * 100 +
                    "% de descuento " + "al producto " + promocion.getProducto().getNombre();
            promocion.setMensaje(mensaje);
            promociones.add(promocion);
        }
        return promociones;
    }

    private List<Producto> consultarProductoMayorInventario(int cantidadMinima){
        productoDao = new ProductoDao();
        return productoDao.consultarProductosMayorInventario(cantidadMinima);
    }

    private List<Producto>  consultarProductoMenorVentaMes(List<Producto> productos, Date fecha){
        productoDao = new ProductoDao();
        return productoDao.consultarProductoMenorVentaMes(productos, fecha);
    }
}
