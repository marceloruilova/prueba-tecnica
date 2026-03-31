# TC-01 – Login exitoso (happy path)
Feature: Login en SauceDemo

  Como usuario registrado
  Quiero iniciar sesión con credenciales válidas
  Para acceder al catálogo de productos

  Scenario: TC-01 Login exitoso con usuario estándar
    Given que el usuario está en la página de login de SauceDemo
    When inicia sesión con usuario "standard_user" y contraseña "secret_sauce"
    Then es redirigido a "/inventory.html"
    And el listado de productos es visible
    And no hay mensajes de error en pantalla
