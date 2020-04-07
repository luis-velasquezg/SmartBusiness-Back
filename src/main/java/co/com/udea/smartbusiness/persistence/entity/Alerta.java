package co.com.udea.smartbusiness.persistence.entity;

import java.util.Date;

public class Alerta {
    private Promocion promocion;
    private Date fecha;

    public Alerta() {
    }

    public Promocion getPromocion() {
        return promocion;
    }

    public void setPromocion(Promocion promocion) {
        this.promocion = promocion;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
}

