package co.edu.udea.smartbusiness.api.repository;

import co.edu.udea.smartbusiness.api.model.Configuracion;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;


@Repository
public interface ConfiguracionRepository extends JpaRepository<Configuracion, String>{

}
