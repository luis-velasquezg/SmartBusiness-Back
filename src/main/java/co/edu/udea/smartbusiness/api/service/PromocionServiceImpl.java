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
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
public class PromocionServiceImpl implements PromocionService{
    private List<Producto> productos;
    private List <Promocion> promociones;
    private Promocion promocion;
    private Configuracion configuracion;
    private PromocionDTO promocionDTO;
    private List <PromocionDTO> promocionesDTO;
    private ConfiguracionRepository configuracionRepository;
    private ProductoRepository productoRepository;
    private DetalleVentaRepository detalleVentaRepository;
    private PromocionRepository promocionRepository;


    public PromocionServiceImpl(ConfiguracionRepository configuracionRepository,
                                ProductoRepository productoRepository,
                                DetalleVentaRepository detalleVentaRepository,
                                PromocionRepository promocionRepository) {
        this.configuracionRepository = configuracionRepository;
        this.productoRepository = productoRepository;
        this.detalleVentaRepository = detalleVentaRepository;
        this.promocionRepository = promocionRepository;
    }

    @Override
    public List <PromocionDTO> calcularPromocion(Date fecha) {

        configuracion = configuracionRepository.findAll().get(0);
        promocionesDTO = new ArrayList<>();
        promociones = new ArrayList<>();
        //Consultamos los productos que tengan mayor inventario
        productos = consultarProductosMayorInventario(configuracion.getCantidadMaximaInventario());
        //Consultamos el producto con menores ventas de la lista
        productos = consultarProductosMenorVentaMes(productos);
        int cantProductos = productos.size();
        for(int i = 0; i < cantProductos; i++) {
            promocion = new Promocion();
            promocion.setProducto(productos.get(i));
            promocion.setCodigo(i + 1);
            promocion.setFecha(fecha);
            if (productos.get(i).getInventario() > configuracion.getCantidadMaximaInventario()) {
                if (productos.get(i).getCosto() > configuracion.getCostoMayor()) {
                    promocion.setPorcentajePromocion(configuracion.getPorcentajeDescuento1());
                } else {
                    promocion.setPorcentajePromocion(configuracion.getPorcentajeDescuento2());
                }
            } else {
                if (productos.get(i).getCosto() > configuracion.getCostoMayor()) {
                    promocion.setPorcentajePromocion(configuracion.getPorcentajeDescuento3());
                } else {
                    promocion.setPorcentajePromocion(configuracion.getPorcentajeDescuento4());
                }
            }
            String mensaje = "Usted puede aplicar " + promocion.getPorcentajePromocion() * 100 +
                    "% de descuento " + "al producto " + promocion.getProducto().getNombre();

            promocion.setMensaje(mensaje);
            if (!verificarExistenciaPromocion(promocion)){ ;
                promociones.add(promocion);
                promocionDTO = new PromocionDTO();
                promocionDTO = convertirEntityADTO(promocion);
                promocionesDTO.add(promocionDTO);
            }
        }
        return promocionesDTO;
    }

    @Override
    public void crearPromocion(PromocionDTO promocionDTO) {
        Promocion promocion = convertirDTOAEntity(promocionDTO);
        promocionRepository.save(promocion);
    }

    private List<Producto> consultarProductosMayorInventario(int cantidadMinima){
        return productoRepository.findAllByInventarioIsGreaterThanEqual(cantidadMinima);
    }

    private List<Producto>  consultarProductosMenorVentaMes(List<Producto> productos){
        Calendar ultimosTreintaDias = Calendar.getInstance();
        ultimosTreintaDias.setTime(new Date());
        ultimosTreintaDias.add(Calendar.DATE, -30);
        List<DetalleVenta> detalleVentas = new ArrayList<>();
        List<Producto> productosMenorVentas = new ArrayList<>();
        for(Producto producto : productos){
            int cantidadVentas = 0;
            detalleVentas = detalleVentaRepository.findByProductoAndFechaAfter(producto,ultimosTreintaDias.getTime());
            for(DetalleVenta detalleVenta : detalleVentas){
                cantidadVentas = cantidadVentas + detalleVenta.getCantidad();
            }
            if (cantidadVentas < configuracion.getCantidadMinimaVentas()){
                productosMenorVentas.add(producto);
            }
        }
        return productosMenorVentas;
    }

    private PromocionDTO convertirEntityADTO(Promocion promocion){
        PromocionDTO promocionDTO = new  PromocionDTO();
        promocionDTO.setCodigo(promocion.getCodigo());
        promocionDTO.setFecha(promocion.getFecha());
        promocionDTO.setMensaje(promocion.getMensaje());
        promocionDTO.setPorcentajePromocion(promocion.getPorcentajePromocion());
        promocionDTO.setProducto(promocion.getProducto());
        return  promocionDTO;
    }

    private Promocion convertirDTOAEntity(PromocionDTO promocionDTO){
        Promocion promocion = new  Promocion();
        //promocion.setCodigo(promocionDTO.getCodigo());
        promocion.setFecha(new Date());
        promocion.setMensaje(promocionDTO.getMensaje());
        promocion.setPorcentajePromocion(promocionDTO.getPorcentajePromocion());
        promocion.setProducto(promocionDTO.getProducto());
        return promocion;
    }
    private boolean verificarExistenciaPromocion(Promocion promocion){
        boolean respuesta = false;
        Promocion promocionEncontrada =
                promocionRepository.findByMensajeAndFechaEquals(promocion.getMensaje(),
                promocion.getFecha());
        if (promocionEncontrada != null){
            respuesta = true;
        }
        return respuesta;
    }
}
