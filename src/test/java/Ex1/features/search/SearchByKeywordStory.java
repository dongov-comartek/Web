package Ex1.features.search;

import Ex1.tasks.OpenResult;
import Ex1.tasks.Search;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.questions.page.TheWebPage;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.containsString;

@RunWith(SerenityRunner.class)
public class SearchByKeywordStory {
    Actor anna = Actor.named("Anna");
    @Managed(uniqueSession = true)
    public WebDriver herBrowser;
    @Before
    public void annaCanBrowseTheWeb() {
        anna.can(BrowseTheWeb.with(herBrowser));
        anna.attemptsTo(Open.url("https://www.google.com.vn/"));
    }
    @Test
    public void search_results_should_show_the_search_term_in_the_title() {
        anna.attemptsTo(
                Search.inputSearch("appium testing").input(),
                OpenResult.open()
        );
        anna.should(

                seeThat(TheWebPage.title(),containsString("Mobile Web Testingsss - Appium"))
        );
    }
}