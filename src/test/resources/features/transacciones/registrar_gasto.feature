#Actor:User
@transacciones
Feature: Register expense
  I as a registered user
  need to register an expense in the system
  to have control of my expenses

  Scenario: Successful expense registration with valid data
    Given I am an authenticated user
    When I register an expense with valid data: category "Entretenimiento", concept "Netflix", amount "40000" and date "2026-05-05T22:57"
    Then the system displays the message "Transacción registrada exitosamente."
  Scenario: Failed expense registration due to empty amount
    Given I am an authenticated user
    When I try to register an expense with category "Comida" and empty amount
    Then the system displays the message "El monto debe ser mayor a $0.01."

  Scenario: Failed expense registration due to no category selected
    Given I am an authenticated user
    When I try to register an expense without selecting a category with amount "80000"
    Then the system displays the message "Selecciona una categoría."