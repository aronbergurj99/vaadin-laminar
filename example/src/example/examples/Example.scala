package example.examples
import com.raquo.laminar.api.L.{*, given}
import frontroute.*
import webcomponents.vaadin
import scala.collection.mutable
import scala.scalajs.js
import webcomponents.vaadin.Item
import org.scalajs.dom
import com.vaadin.flow.theme.lumo.{ LumoUtility }

abstract class Example(val component: String) {
    def examples: HtmlElement

    def apply() = {
        path(this.component) {
            div(
                className(
                    LumoUtility.MaxWidth.SCREEN_MEDIUM,
                    LumoUtility.Margin.AUTO,
                    LumoUtility.Padding.Top.XLARGE,
                    LumoUtility.Display.FLEX,
                    LumoUtility.FlexDirection.COLUMN,
                    LumoUtility.Gap.MEDIUM,
                ),
                h1("Grid"),
                examples
            )
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
                vaadin.Dialog(_.opened <-- dialogToggle.signal, _.content :=
                    div(
                        vaadin.Button("i am groot", onClick --> { _ =>
                            dom.console.log("GROOT IS CALLING FROM MODAL")
                        }),
                        text <-- updatingSignal,
                        h1("hello world")
                    )
                )
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
        val items: Var[js.Array[js.Object]] = Var(js.Array(
                        js.Dynamic.literal("name" -> "PO0001", "age" -> 25),
                        js.Dynamic.literal("name" -> "PO0002", "age" -> 23)
                    ))

        ExamplePanel("Simple Grid") {
            div(
                vaadin.grid.Grid(
                    _.items <-- items,
                    vaadin.grid.Column(_.path("name"), _.header("Name")),
                    vaadin.grid.Column(_.path("age"), _.header("Age")),
                    vaadin.grid.Column.withItem[Person](_.header("action"), _.content := { model => 
                        vaadin.Button(s"${model.item.name} - ${model.item.age}")
                    })
                ),
                vaadin.Button(onClick --> {_ => items.set(js.Array(js.Dynamic.literal("name" -> "Aron", "age" -> 25)))}, "clear"),
                vaadin.Button(onClick --> {_ => items.set(js.Array(
                        js.Dynamic.literal("name" -> "Aron", "age" -> 25),
                        js.Dynamic.literal("name" -> "Bryndis", "age" -> 23)
                        ))}, "set")
            )
        }
    }
}