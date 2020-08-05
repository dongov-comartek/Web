package Ex1.questions;

import Ex1.ui.SearchBoxScreen;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Consequence;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.ConsequenceGroup;
import net.serenitybdd.screenplay.questions.Text;

public class VerifyResult implements Question<String> {
    @Override
    public String answeredBy(Actor actor) {
        return Text.of(SearchBoxScreen.RESULT_FIELD).viewedBy(actor).asString();
    }
    public static Question<String> verify(){
        return new VerifyResult();
    }
}
