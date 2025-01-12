package example.examples
import com.raquo.laminar.api.L.{*, given}
import frontroute.*
import webcomponents.vaadin

trait Example(val component: String) {
    def examples: HtmlElement

    def apply() = {
        path(this.component) {
            examples
        }
    }
}

object ButtonExample extends Example("button") {
    def examples: HtmlElement = {
        ExamplePanel("Button disabled") {
            vaadin.Button("enabled")
        }
    }
}

object TextFieldExample extends Example("text-field") {
    def examples: HtmlElement = {
        ExamplePanel("Text Field") {
            vaadin.TextField(_.label("my label"))
        }
    }
}