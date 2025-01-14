package example.examples
import com.raquo.laminar.api.L.{*, given}
import com.vaadin.flow.theme.*
import com.vaadin.flow.theme.lumo.LumoUtility

object ExamplePanel {
    def apply(title: String)(body: HtmlElement): HtmlElement = {
        div(
            h2(s"${title}"),
            div(
                body,
            )
        )
    }
}