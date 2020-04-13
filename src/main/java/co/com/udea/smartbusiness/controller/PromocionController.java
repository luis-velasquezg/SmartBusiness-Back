package co.com.udea.smartbusiness.controller;
import co.com.udea.smartbusiness.persistence.entity.Configuracion;
import co.com.udea.smartbusiness.persistence.entity.Promocion;
import co.com.udea.smartbusiness.service.PromocionService;
import co.com.udea.smartbusiness.service.PromocionServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;


@RestController
@RequestMapping("/promociones")
public class PromocionController {
    private PromocionService promocionService;
    private Configuracion configuracion;

    @GetMapping("/verpromociones")
    public ResponseEntity<List<Promocion>> verPromociones(){
        Date fecha = new Date();
        configuracion = new Configuracion();
        configuracion.setCantidadMinimaProductoPromocion(300);
        configuracion.setCostoMayor(99000);
        configuracion.setPorcentajeDescuento1(0.40);
        configuracion.setPorcentajeDescuento2(0.30);
        configuracion.setPorcentajeDescuento3(0.20);
        configuracion.setPorcentajeDescuento4(0.10);
        promocionService = new PromocionServiceImpl();
        return  ResponseEntity.ok(promocionService.calcularPromocionMetodoPorDefecto(fecha, configuracion));
    }

}
