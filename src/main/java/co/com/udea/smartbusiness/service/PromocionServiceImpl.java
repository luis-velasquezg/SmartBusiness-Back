package co.com.udea.smartbusiness.service;

import co.com.udea.smartbusiness.persistence.entity.Producto;

public class PromocionServiceImpl implements PromocionService{

    @Override
    public String calcularPromocion(Producto producto) {
        String mensaje="";
        if (producto == null){
            mensaje = null;
        }else{
            mensaje = "Hoy puedes aplicar 10% de descuento a las tohallas igienicas";
        }
        return mensaje;
    }
}
