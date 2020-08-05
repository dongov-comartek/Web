package Ex1.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Enter;
import net.thucydides.core.annotations.Step;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static org.openqa.selenium.Keys.ENTER;

import Ex1.ui.SearchBoxScreen;

public class Search implements Task {

    String searchTerm;

    public Search(String searchTerm) {
        this.searchTerm = searchTerm;
    }

    @Step("Search for #searchTerm")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Enter.theValue(this.searchTerm)
                        .into(SearchBoxScreen.SEARCH_FIELD)
                        .thenHit(ENTER)
        );
    }


    public static SearchBuilder inputSearch(String searchTerm) {
        return new SearchBuilder(searchTerm);
    }

    public static class SearchBuilder {
        String searchTerm;
        public SearchBuilder(String searchTerm){
            this.searchTerm=searchTerm;
        }
        public Search input(){
            return instrumented(Search.class,this.searchTerm);
        }


    }

}
