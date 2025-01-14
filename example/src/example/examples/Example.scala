package example.examples
import com.raquo.laminar.api.L.{*, given}
import frontroute.*
import webcomponents.vaadin
import scala.collection.mutable
import scala.scalajs.js
import webcomponents.vaadin.Item

import org.scalajs.dom

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

object DialogExample extends Example("dialog") {
    def updatingSignal = {
        EventStream.periodic(1000)
    }
    def examples: HtmlElement = {
        val dialogToggle = Var(false)
        ExamplePanel("Dialog") {
            div(
                vaadin.Button("open", onClick --> (_ => {
                    dialogToggle.update(!_)
                })),
                vaadin.Dialog(_.opened <-- dialogToggle.signal, _.content := { _ =>
                    div(
                        vaadin.Button("i am groot", onClick --> { _ =>
                            dom.console.log("GROOT IS CALLING FROM MODAL")
                        }),
                        h1("hello world")
                    )
                })
            )
        }         
    }
}


object GridExample extends Example("grid") {
    trait Person extends js.Object {
        val name: String
        val age: Int
    }
    def examples: HtmlElement = {
        ExamplePanel("Grid") {
            div(
                vaadin.grid.Grid(
                    _.items := js.Array(
                        js.Dynamic.literal("name" -> "Aron", "age" -> 25),
                        js.Dynamic.literal("name" -> "Bryndis", "age" -> 23)
                        ),
                    vaadin.grid.Column.default(_.path("name"), _.header("Name")),
                    vaadin.grid.Column.default(_.path("age"), _.header("Age")),
                    vaadin.grid.Column.withItem[Person](_.header("action"), _.content := { model =>
                        println(model)
                        div("hello")
                    }),
                    // vaadin.grid.Column()(_.path := "name", _.header := "Name"),
                    // vaadin.grid.Column(_.path := "age", _.header := "Age"),
                    // vaadin.grid.Column(_.header := "Actions")
                )
            )

        }
    }

}