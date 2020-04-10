package co.com.udea.smartbusiness.persistence.DAO;

import co.com.udea.smartbusiness.persistence.entity.Categoria;
import co.com.udea.smartbusiness.persistence.entity.Producto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ProductoDao {
    private List<Producto> productos = new ArrayList<>();
    private Producto producto = new Producto();
    private Categoria categoria = new Categoria(1,"Antistamínicos" );

    public List<Producto> consultarProductosMayorInventario(int cantidadMinima){
        producto = new Producto();
        producto.setCategoria(categoria);
        producto.setCodigo(1);
        producto.setCosto(1000);
        producto.setPrecio(1200);
        producto.setNombre("Loratadina");
        producto.setInventario(300);
        producto.setIva(0.16);
        productos.add(producto);
        producto = new Producto();
        producto.setCategoria(categoria);
        producto.setCodigo(2);
        producto.setCosto(3000);
        producto.setPrecio(6200);
        producto.setNombre("Cetirizina");
        producto.setInventario(350);
        producto.setIva(0.16);
        productos.add(producto);
        return productos;
    }

    public  List<Producto> consultarProductoMenorVentaMes(List<Producto> productos, Date fecha){
        return  productos;
    }

}
