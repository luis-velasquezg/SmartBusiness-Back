package co.edu.udea.smartbusiness.api.controller;
import co.edu.udea.smartbusiness.api.DTO.PromocionDTO;
import co.edu.udea.smartbusiness.api.model.Configuracion;
import co.edu.udea.smartbusiness.api.service.PromocionService;
import co.edu.udea.smartbusiness.api.service.PromocionServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;


@RestController
@RequestMapping("api/v1/promociones")
public class PromocionController {
    private PromocionService promocionService;
    private Configuracion configuracion;

    public PromocionController(PromocionService promocionService) {
        this.promocionService = promocionService;
    }

    @GetMapping()
    public ResponseEntity<List<PromocionDTO>> verPromociones(){
        Date fecha = new Date();
        return  ResponseEntity.ok(promocionService.calcularPromocion(fecha));
    }

    @PostMapping()
    public String guardarPromocion(@RequestBody PromocionDTO promocionDTO) {
        promocionService.crearPromocion(promocionDTO);
        return "Promoción aplicada correctamente";
    }

    @GetMapping("/guardadas")
    public ResponseEntity<List<PromocionDTO>> verPromocionesGuardadas(){
        return  ResponseEntity.ok(promocionService.verPromocionesGuardas());
    }



}
