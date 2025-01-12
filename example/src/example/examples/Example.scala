package example.examples
import com.raquo.laminar.api.L.{*, given}
import frontroute.*
import webcomponents.vaadin
import webcomponents.vaadin.withItems
import scala.collection.mutable
import scala.scalajs.js
import webcomponents.vaadin.MultiSelectComboBox.items
import webcomponents.vaadin.Item

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

object SelectExample extends Example("select") {
    def examples: HtmlElement = {
        ExamplePanel("Select") {
            vaadin.MultiSelectComboBox(_.label("Multi select"), _.items := js.Array(new Item {
                val value = "hello"
                val label = "some"}))
        }
    }
}