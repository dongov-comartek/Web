package Ex1.ui;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class SearchBoxScreen {
    public static Target SEARCH_FIELD = Target.the("search field").located(By.name("q"));
    public static Target RESULT_FIELD = Target.the("result field").located(By.xpath("//h3[contains(text(),'Mobile Web Testing - Appium')]"));
}
