Feature: Pagina Promocion
  como usuario quiero ver promociones
  para poder tomar la mejor decision
  acerca de las mejores promociones para mi negocio

  Scenario: Ingresar a la pagina de promociones desde home
    Given dado que el usaurio se encuentra en la pagina principal
    When hace clic sobre promociones
    And hace clic sobre promociones sugeridas
    Then se debe redirigir a la patalla promociones sugeridas
