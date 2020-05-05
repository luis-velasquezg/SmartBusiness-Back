package co.edu.udea.smartbusiness.api.repository;

import co.edu.udea.smartbusiness.api.model.Promocion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
public interface PromocionRepository extends JpaRepository<Promocion, String> {
    Promocion findByMensajeAndFechaEquals(String Mensaje, Date fecha);
}
