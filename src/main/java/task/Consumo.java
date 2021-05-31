package task;

import interactions.Servicio;
import io.restassured.http.Header;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.rest.interactions.Get;
import net.serenitybdd.screenplay.rest.interactions.Post;
import net.serenitybdd.screenplay.rest.interactions.RestInteraction;

import java.util.Map;

public class Consumo implements Task {

    String metodo, url, body,pathFile;
    Map<String, String> headers;
    public Consumo(String metodo, String url, Map<String, String> headers, String body,  String pathFile) {
        this.metodo = metodo;
        this.body = body;
        this.url = url;
        this.headers = headers;
        this.pathFile=pathFile;
    }
    public static Consumo elApi(String metodo, String url, Map<String, String> headers, String body,String pathFile) {
        return Tasks.instrumented(Consumo.class, metodo, url, headers, body,pathFile);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(
                Post.to("/obtnere/")
                        .with(requestSpecification ->
                                requestSpecification)
        );

            switch(metodo){
                case "DELETE":
                    actor.attemptsTo(
                            Servicio.restDelete(url,body,headers)
                    );
                    break;
                case "DELETESTATUSVERIFICATION":
                    actor.attemptsTo(
                            Servicio.restDeleteVerification(url,body,headers)
                    );
                    break;
                case "GET":
                    actor.attemptsTo(
                            Servicio.restGet(url)
                    );
                    break;
                case "GETSTATUSVERIFICATION":
                    actor.attemptsTo(
                            Servicio.restGetVerification(url)
                    );
                    break;
                case "GETWHSTATUSVERIFICATION":
                    actor.attemptsTo(
                            Servicio.restGetVerification(url,headers)
                    );
                    break;
                case "GETWITHHEADER":
                    actor.attemptsTo(
                            Servicio.restGet(url,headers)
                    );
                    break;
                case "POST":
                    actor.attemptsTo(
                            Servicio.restPost(url,body)
                    );
                    break;
                case "POSTSATUSVERIFICATION":
                    actor.attemptsTo(
                            Servicio.restPostVerification(url,body)
                    );
                    break;
                case "POSTWHSATUSVERIFICATION":
                    actor.attemptsTo(
                            Servicio.restPostVerification(url,body,headers)
                    );
                    break;
                case "POSTWITHBODYPARAMETERS":
                    actor.attemptsTo(
                            Servicio.restPostNew(url,body,headers,pathFile)
                    );
                    break;
                case "POSTWITHHEADER":
                    actor.attemptsTo(
                            Servicio.restPost(url,body,headers)
                    );
                    break;
                case "PUTWITHHEADERS":
                    actor.attemptsTo(
                            Servicio.restPut(url,body,headers)
                    );
                    break;
                case "SOAP":
                    actor.attemptsTo(
                            Servicio.soap(url,body)
                    );
                    break;
            }
    }
}
