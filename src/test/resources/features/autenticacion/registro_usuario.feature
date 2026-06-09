@autenticacion
Feature: Register user
  I as a new user
  need to register in the system
  to access my personal finances

  Scenario: Successful user registration
    Given I am on the registration page
    When I register with email "newuser_test123@mailinator.com", password "Passw1!" and confirm password "Passw1!"
    Then I am redirected to the verification page

  Scenario: Failed registration due to already registered email
    Given I am on the registration page
    When I register with email "andrea.marin1713@gmail.com", password "Pass123!" and confirm password "Pass123!"
    Then the system displays the message "El correo ya está registrado"

  Scenario Outline: Failed registration due to invalid password
    Given I am on the registration page
    When I register with email "newuser_test123@mailinator.com", password "<contrasena>" and confirm password "<contrasena>"
    Then the system displays the message "<mensaje>"

    Examples:
      | contrasena | mensaje                                                   |
      | Passw1!    | La contraseña debe tener al menos 8 caracteres.           |
      | password1! | La contraseña requiere al menos una mayúscula.            |
      | Password!  | La contraseña requiere al menos un número.                |
      | Password1  | La contraseña requiere un carácter especial (@$!%*?&#._-) |

  Scenario: Failed registration due to empty fields
    Given I am on the registration page
    When I try to register with empty fields
    Then the system displays the message "Todos los campos son requeridos."
