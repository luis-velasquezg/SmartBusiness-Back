package co.com.udea.smartbusiness.service;

import co.com.udea.smartbusiness.persistence.entity.Configuracion;
import co.com.udea.smartbusiness.persistence.entity.Producto;

import java.util.Date;
import java.util.List;

public interface PromocionService {

     public String calcularPromocionMetodoPorDefecto(Date fecha, Configuracion configuracion);

}
