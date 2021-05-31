package pageobjects;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

import org.openqa.selenium.support.FindBy;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.By;


@DefaultUrl("https://serenity.is/demo/")

public class IngresoPage extends PageObject {

    PageObject page;

    String strUrlStarSharp = "https://serenity.is/demo/";

    private String usuario;
    private String password;
    private String name;
    private String parent;
    private String nameReu;
    private String fecha;
    private String localizacion;
    private String direccion;
    private String latitud;
    private String longitud;
    private String titulo;
    private String nombreO;
    private String apellidO;
    private String correo;
    private String buzon;
    private String idOrganizador;
    private String nroReunion;

    static final String txtusuario = "//*[@id='StartSharp_Membership_LoginPanel0_Username']";
    static final String txtpass = "//*[@id='StartSharp_Membership_LoginPanel0_Password']";
    static final String btningresar = "//*[@id='StartSharp_Membership_LoginPanel0_LoginButton']";

    static final String txtname = "//input [@name='Name']";
    static final String btngrabar = "//div [@class='tool-button save-and-close-button icon-tool-button']";

    static final String btnNvaReunion = "//*[@id='GridDiv']/div[2]/div[2]/div/div/div[1]";
    static final String txtNameReunion = "//input [@name='MeetingName']";
    static final String txtFecha = "//input [@name='StartDate']";
    static final String cboHora = "//*[@id='StartSharp_Meeting_MeetingDialog14_PropertyGrid']/div/div/div[4]/select";
    static final String nvaLocalizacion = "/html/body/div[2]/div[1]/section/div[2]/div[2]/div[1]/div[2]/form/div/div/div/div/div[6]/a";
    static final String txtNombreLocacion = "//input [@name='Name']";
    static final String txtDireccion = "//input [@name='Address']";
    static final String txtLatitud = "//input [@name='Latitude']";
    static final String txtLongitud = "//input [@name='Longitude']";
    static final String btnGrabarLocal = "/html/body/div[6]/div[2]/div/div[1]/div/div/div/div[1]";

    static final String btnNvoOrganizador = "/html/body/div[2]/div[1]/section/div[2]/div[2]/div[1]/div[2]/form/div/div/div/div/div[8]/a";

    static final String txtTitulo = "//input [@name= 'Title']";
    static final String txtNombreO = "//input [@name= 'FirstName']";
    static final String txtApellido = "//input [@name= 'LastName']";
    static final String txtCorreo = "//input [@name= 'Email']";
    static final String txtBuzon = "//input [@class='emaildomain']";
    static final String txtIdentidad = "//input [@name='IdentityNo']";
    static final String cboUsuario = "/html/body/div[6]/div[2]/div/div[2]/form/div/div[1]/div/div/div[6]/div[1]/a/span[2]";
    static final String opcCboUsuario = "/html/body/div[10]/ul/li/div/span";
    static final String btnGrabarOrganizador = "/html/body/div[6]/div[2]/div/div[1]/div/div/div/div[1]/div/span";

    static final String txtNroReunion = "//input [@name='MeetingNumber']";
    static final String txtFechaFin = "//input [@name='EndDate']";
    static final String cboUnidad = "/html/body/div[2]/div[1]/section/div[2]/div[2]/div[1]/div[2]/form/div/div/div/div/div[7]/div[1]/a/span[2]";
    static final String opcCboUnidad = "/html/body/div[8]/ul/li[1]/div/span";
    static final String cboReportero = "/html/body/div[2]/div[1]/section/div[2]/div[2]/div[1]/div[2]/form/div/div/div/div/div[9]/div[1]/a/span[2]";
    static final String opcCboReportero = "/html/body/div[8]/ul/li[1]/div/span";

    static final String cboListaAsiste = "/html/body/div[3]/div[1]/section/div[2]/div[2]/div[1]/div[2]/form/div/div/div/div/div[10]/div[1]/div[1]/div[2]";
    static final String opcCboListaAsiste = "/html/body/div[11]/ul/li/div";
    static final String btnGrabarReunion = "/html/body/div[2]/div[1]/section/div[2]/div[2]/div[1]/div[1]/div/div/div/div[1]/div/span";

    static final String lblUnidad = "//*[@id='GridDiv']/div[3]/div[4]/div[3]/div/div[1]";
    static final String lblReunion = "//*[@id='GridDiv']/div[3]/div[4]/div[3]/div/div";


    static final String menuReunion = "//*[@id='SidebarMenu']/li[5]/a/i[2]";
    static final String subMenuReuniones = "//*[@id='SidebarMenu']/li[5]/ul/li[1]";
    static final String menuOrganizacion = "//*[@id='SidebarMenu']/li[6]/a/i[2]";
    static final String suMenuUnidadesNegocio = "//*[@id='SidebarMenu']/li[6]/ul/li[1]/a/span";
    static final String menuNuevoBusiness = "//*[@id='GridDiv']/div[2]/div[2]/div/div";
    static final String menuCrearBusiness = "//*[@id='GridDiv']/div[2]/div[2]/div/div";


    public void abrirUrl() {

        getDriver().manage().window().maximize();
        getDriver().get(strUrlStarSharp);
        waitFor(3).seconds();
        System.out.println("Abrir url StarSharp");
    }

    public void ingresarStrarSharp( String  user, String pass) throws Exception {

        try {
            usuario = user;
            password = pass;
            System.out.println("se ingresan los datos del usuario ");
            findBy(txtusuario).type(usuario);
            waitFor(3).seconds();
            findBy(txtpass).type(password);
            waitFor(3).seconds();

            findBy(btningresar).click();
            System.out.println("Datos del usuario ingresados con exito");

            waitFor(5).seconds();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void crearBusinessUnit(String nameB) throws Exception
    {
        try {
            name= nameB;

            findBy(menuOrganizacion).click();
            waitFor(3).seconds();

           findBy(suMenuUnidadesNegocio).click();
            waitFor(5).seconds();

            findBy(menuCrearBusiness).click();
            waitFor(3).seconds();

            findBy(txtname).type(name);
            waitFor(5).seconds();

            findBy(btngrabar).click();

            System.out.println("Se ha creado BusinessUnit con exito");

            waitFor(5).seconds();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void crearReunion(String nombreReunion, String fechareu, String localizacionOf, String direccionOf, String latitudOf, String longitudOf, String tituloOr, String nombreOr, String apellidOr, String usermail, String mail, String id, String nroReu) throws Exception
    {
        try {
            nameReu= nombreReunion;
            fecha= fechareu;
            localizacion = localizacionOf;
            direccion = direccionOf;
            latitud = latitudOf;
            longitud = longitudOf;
            nombreO = nombreOr;
            apellidO = apellidOr;
            correo = usermail;
            buzon = mail;
            idOrganizador = id;
            nroReunion = nroReu;
            titulo = tituloOr;

            waitFor(5).seconds();

            findBy(menuReunion).click();

            waitFor(3).seconds();

            findBy(subMenuReuniones).click();
            waitFor(3).seconds();

            findBy(btnNvaReunion).click();

            findBy(txtNameReunion).type(nameReu);
            waitFor(3).seconds();

            findBy(txtFecha).type(fecha);
            waitFor(3).seconds();

            findBy(nvaLocalizacion).click();
            waitFor(3).seconds();

            findBy(txtNombreLocacion).type(nombreO);
            waitFor(3).seconds();

            findBy(txtDireccion).type(direccion);
            waitFor(3).seconds();

            findBy(txtLatitud).type(latitud);
            waitFor(3).seconds();

            findBy(txtLongitud).type(longitud);
            waitFor(3).seconds();

            findBy(btnGrabarLocal).click();

            System.out.println("Se ha Grabado la locacion con exito");

            waitFor(5).seconds();

            findBy(btnNvoOrganizador).click();

            findBy(txtTitulo).type(titulo);

            findBy(txtNombreO).type(nombreO);

            findBy(txtApellido).type(apellidO);

            findBy(txtCorreo).type(correo);

            findBy(txtBuzon).type(buzon);

            findBy(txtIdentidad).type(idOrganizador);

            findBy(btnGrabarOrganizador).click();
            waitFor(3).seconds();

            findBy(txtNroReunion).type(nroReunion);

            findBy(txtFechaFin).type(fecha);

         /*   findBy(cboUnidad).click();

            findBy(opcCboUnidad).click();

            findBy(cboReportero).click();

            findBy(opcCboReportero).click();

            findBy(cboListaAsiste).click();

            findBy(opcCboListaAsiste).click();*/

            findBy(btnGrabarReunion).click();


            System.out.println("Se ha Grabado la Reunion con exito");

            waitFor(5).seconds();


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Boolean validarUnidad()
    {
        Boolean valor = false;
        if(findBy(lblUnidad).isPresent())
        {
            valor=true;
        }
        return valor;
    }

    public Boolean validarReunion()
    {
        Boolean valor = false;
        if(findBy(lblReunion).isPresent())
        {
            valor=true;
        }
        return valor;
    }

}
