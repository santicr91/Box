@StarSharp
Feature: Validar Flujo StarSharp
  Scenario Outline: Validar ingreso y crear unidad

    Given Se ingresa a StarSharp
    When Se ingresan los datos requeridos del usuario "<USUARIO>" "<PASSWORD>"
    And Se ingresa al menu organiazcion unidades de negocio "<NAMEUNIDAD>"
    Then Verificar la creacion de la Unidad

    Examples:
      | USUARIO | PASSWORD |  NAMEUNIDAD  |
      | admin | serenity |  test1 |

  Scenario Outline: Validar ingreso y reunion
    Given Se crea una reunion "<NAMEREU>" "<FECHAREU>" "<LOCALIZACION>" "<DIRECCION>" "<LATITUD>" "<LONGITUD>" "<TITULO>" "<NOMBREO>" "<APELLIDO>" "<USERMAIL>" "<MAIL>" "<ID>" "<NROREUNION>"
    Then Verificar la creacion de la reunion

    Examples:
      | NAMEREU | FECHAREU  | LOCALIZACION | DIRECCION |LATITUD|  LONGITUD  | TITULO | NOMBREO  | APELLIDO |USERMAIL|  MAIL  | ID |  NROREUNION  |
      | spike | 09/03/2021 |  OFICINA1 | CLL 29 - 12  | 2 | 3  |  ORGANIZADOR |  USUARIO1  | APEUSUARIO1  | USUARIO1 | GMAIL.COM | 1035487898  | 02138 |