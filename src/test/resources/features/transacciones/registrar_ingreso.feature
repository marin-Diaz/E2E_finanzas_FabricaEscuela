#Actor:User

Feature: Register income
  I as a registered user
  need to register an income in the system
  to have control of my personal finances

  Scenario: Successful income registration with valid data
    Given I am an authenticated user
    When I register an income with valid data: category "Salario", concept "Prima", amount "3000000" and date "2026-05-01T23:56"
    Then the system displays the message "Transacción registrada exitosamente."

  Scenario: Failed income registration due to empty amount
    Given I am an authenticated user
    When I try to register an income with category "Salario" and empty amount
    Then the system displays the message "El monto debe ser mayor a $0.01."

  Scenario: Failed income registration due to no category selected
    Given I am an authenticated user
    When I try to register an income without selecting a category with amount "500000"
    Then the system displays the message "Selecciona una categoría."