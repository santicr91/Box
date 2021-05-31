package stepdefinitions;
import static org.junit.Assert.assertEquals;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;
import pageobjects.IngresoPage;

import static org.junit.Assert.assertEquals;

public class IngresoStarSharpSteps {
    IngresoPage ingresoPage;

    @Given("^Se ingresa a StarSharp$")
    public void ingresarStarSharp() throws Throwable
    {
        ingresoPage.abrirUrl();
        System.out.println("ingreso a la url StarShaps");
    }

    @When("^Se ingresan los datos requeridos del usuario \"([^\"]*)\" \"([^\"]*)\"$")
    public void ingresarDatosUsuario(String usuario, String password) throws Exception {
        ingresoPage.ingresarStrarSharp(usuario, password);

    }

    @And("^Se ingresa al menu organiazcion unidades de negocio \"([^\"]*)\"$")
    public void ingresarDatosUnidad(String nameb) throws Throwable
    {
        ingresoPage.crearBusinessUnit(nameb);
    }

    @Given("^Se crea una reunion \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\"$")
    public void ingresarReunion(String nameREU, String fechareu, String localizacion, String direccion, String latitud, String longitud, String titulo, String nombreo, String apellido, String usermail, String mail, String id, String nroReu) throws Throwable
    {
        ingresoPage.crearReunion(nameREU, fechareu, localizacion, direccion,latitud, longitud, titulo, nombreo, apellido, usermail, mail, id, nroReu);
    }

    @Then("^Verificar la creacion de la Unidad$")
    public void ValidarDatosUnidad() throws Throwable, PendingException
    {
        assertEquals(true,ingresoPage.validarUnidad());
    }

    @Then("^Verificar la creacion de la reunion$")
    public void ValidarDatosReunion() throws Throwable, PendingException
    {
        assertEquals(true,ingresoPage.validarReunion());
    }

}
