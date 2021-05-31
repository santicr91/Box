package runners;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.genericsTools.data.DataToFeature;
import org.junit.runner.RunWith;

import java.io.IOException;

@CucumberOptions(features = {"src/test/resources/features/appStarSharp.feature"},
        tags = "@StarSharp",
        glue = "stepdefinitions",
        snippets = SnippetType.CAMELCASE )
@RunWith(CucumberWithSerenity.class)
public class RunnerTags {
    public static void test() throws InvalidFormatException, IOException {
        DataToFeature.overrideFeatureFiles("src/test/resources/features",null);
    }
}
