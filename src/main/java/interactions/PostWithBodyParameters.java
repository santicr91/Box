package interactions;

import io.restassured.http.ContentType;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.rest.interactions.RestInteraction;
import net.thucydides.core.annotations.Step;

import java.io.File;
import java.util.Map;

public class PostWithBodyParameters extends RestInteraction {

    private String resource;
    private String body;
    private Map<String, Object> header;
    private String pathFile;

    public PostWithBodyParameters(String resource, String body, Map<String, Object> header,String pathFile) {
        this.resource = resource;
        this.body = body;
        this.header=header;
        this.pathFile=pathFile;
    }

    @Step("{0} executes a POST on the resource #resource")
    @Override
    public <T extends Actor> void performAs(T actor) {
        File archivo= new File(pathFile);
        rest().contentType("multipart/form-data")
                .relaxedHTTPSValidation()
                .headers(header)
                .multiPart("file",archivo)
                .multiPart("request",body)
                .when()
                .post(resource);
    }
}
