package example.examples
import com.raquo.laminar.api.L.{*, given}
import frontroute.*
import webcomponents.vaadin
import webcomponents.vaadin.withItems
import scala.collection.mutable
import scala.scalajs.js
import webcomponents.vaadin.MultiSelectComboBox.items
import webcomponents.vaadin.Item

import org.scalajs.dom
import webcomponents.vaadin.Dialog.opened

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
                // Workign example
                // vaadin.Dialog(opened <-- dialogToggle.signal, _ => onMountCallback(ctx => {
                //     ctx.thisNode.ref.renderer = (el: dom.Element, ref: vaadin.Dialog.Ref) => {
                //         el.innerHTML = "<div><h1>Hello world</h1></div>"
                //         ()
                //     }
                // }) ),

                // another working example
                // vaadin.Dialog(opened <-- dialogToggle.signal, inContext { ctx => 
                //     ctx.ref.renderer = (el: dom.Element, ref: vaadin.Dialog.Ref) => {
                //         el.innerHTML = "<div><h1>Hello world</h1></div>"
                //         ()
                //     }
                //         ctx
                //     })

                vaadin.Dialog(opened <-- dialogToggle.signal, _.content := div(
                    h1("hello world"),
                    text <-- updatingSignal,
                    vaadin.Button("i am groot", onClick --> { _ =>
                        dom.console.log("GROOT IS CALLING FROM MODAL")
                    })
                ))
            )
        }         
    }
}