package co.edu.udea.smartbusiness.api.repository;

import co.edu.udea.smartbusiness.api.DTO.PromocionDTO;
import co.edu.udea.smartbusiness.api.model.Producto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class FakeDB {

    private List<PromocionDTO> promociones = new ArrayList<>();
    private List<Producto> productos = new ArrayList<>();
    private boolean estaProductosCargado = false;

    
    public FakeDB() {
        cargarDatosProductos();
        cargarDatosPromocion();
    }

    private void cargarDatosProductos() {
        Producto producto;

        producto = new Producto();
        producto.setCodigo(1);
        producto.setCosto(1000);
        producto.setPrecio(1200);
        producto.setNombre("Loratadina");
        producto.setInventario(300);
        producto.setIva(0.16);
        productos.add(producto);

        producto = new Producto();
        producto.setCodigo(2);
        producto.setCosto(3000);
        producto.setPrecio(6200);
        producto.setNombre("Cetirizina");
        producto.setInventario(350);
        producto.setIva(0.16);
        productos.add(producto);

        estaProductosCargado = true;
    }

    private void cargarDatosPromocion() {
        PromocionDTO promocion;

        promocion = new PromocionDTO();
        promocion.setCodigo(1);
        promocion.setPorcentajePromocion(24);
        promocion.setProducto(getProductoById(1));
        promocion.setMensaje("Usted puede aplicar " + promocion.getPorcentajePromocion() * 100 +
                "% de descuento al producto " + promocion.getProducto().getNombre());
        promocion.setFecha(new Date());
        promociones.add(promocion);

        promocion = new PromocionDTO();
        promocion.setCodigo(2);
        promocion.setPorcentajePromocion(15);
        promocion.setProducto(getProductoById(2));
        promocion.setMensaje("Usted puede aplicar " + promocion.getPorcentajePromocion() * 100 +
                "% de descuento al producto " + promocion.getProducto().getNombre());
        promocion.setFecha(new Date());
        promociones.add(promocion);

    }

    public Producto getProductoById(int codigoProducto) {
        if (!estaProductosCargado)
            return null;

        for (Producto producto: productos) {
            if (producto.getCodigo() == codigoProducto)
                return producto;
        }

        return null;
    }

    public List<PromocionDTO> getPromociones() {
        return promociones;
    }

    public void setPromociones(List<PromocionDTO> promociones) {
        this.promociones = promociones;
    }

    public List<Producto> getProductos() {
        return productos;
    }

    public void setProductos(List<Producto> productos) {
        this.productos = productos;
    }

}
