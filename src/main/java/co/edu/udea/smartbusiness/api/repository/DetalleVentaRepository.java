package co.edu.udea.smartbusiness.api.repository;

import co.edu.udea.smartbusiness.api.model.DetalleVenta;
import co.edu.udea.smartbusiness.api.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface DetalleVentaRepository extends JpaRepository<DetalleVenta, String> {
    List<DetalleVenta> findByProductoAndFechaAfter(Producto producto, Date fecha);

}
