package co.edu.udea.smartbusiness.api.repository;

import co.edu.udea.smartbusiness.api.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, String> {

    List<Producto> findAllByInventarioIsGreaterThanEqual(int cantidadMinima);

}
