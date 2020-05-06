package co.edu.udea.smartbusiness.api.service;

import co.edu.udea.smartbusiness.api.model.Configuracion;
import co.edu.udea.smartbusiness.api.DTO.PromocionDTO;

import java.util.Date;
import java.util.List;


public interface PromocionService {

     List<PromocionDTO> calcularPromocion(Date fecha);

     void crearPromocion(PromocionDTO promocionDTO);
}
