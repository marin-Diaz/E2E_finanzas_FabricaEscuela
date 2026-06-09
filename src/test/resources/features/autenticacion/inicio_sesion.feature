@autenticacion
Feature: User login
  I as a registered user
  need to log in to the system
  to access my personal finances

  Scenario: Successful login with valid credentials
    Given I am on the login page
    When I log in with email "andrea.marin1713@gmail.com" and password "Mipass123!"
    Then I am redirected to the dashboard

  Scenario: Failed login due to incorrect credentials
    Given I am on the login page
    When I log in with email "andrea.marin1713@gmail.com" and password "WrongPass123!"
    Then the system displays the message "Correo o contraseña incorrectos"

  Scenario: Failed login due to empty fields
    Given I am on the login page
    When I try to log in with empty fields
    Then the system displays the message "Error de validación en los datos enviados"

  Scenario: Failed login due to unregistered user
    Given I am on the login page
    When I log in with email "notregistered_xyz@test.com" and password "Pass123!"
    Then the system displays the message "Correo o contraseña incorrectos"
