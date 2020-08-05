package Ex1.tasks;

import Ex1.ui.SearchBoxScreen;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class OpenResult implements Task {
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(SearchBoxScreen.RESULT_FIELD)
        );

    }
    public static OpenResult open() {
        return instrumented(OpenResult.class);
    }
}
