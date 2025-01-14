package webcomponents.vaadin.internal

import scala.scalajs.js
import scala.scalajs.js.annotation.*

import org.scalajs.dom
import com.raquo.laminar.codecs.AsIsCodec

import com.raquo.laminar.api.L.{*, given}
import com.raquo.laminar.keys.HtmlAttr
import com.raquo.laminar.nodes.ReactiveElement.Base

import com.raquo.laminar.modifiers.KeySetter.PropSetter
import com.raquo.laminar.modifiers.KeySetter
import webcomponents.WebComponent

import com.raquo.laminar.DomApi
import com.raquo.laminar.nodes.ReactiveElement
import com.raquo.laminar.nodes.ReactiveHtmlElement
import com.raquo.laminar.keys.{Key}
import com.raquo.laminar.codecs.Codec
import com.raquo.laminar.api.L
import com.raquo.laminar.modifiers.Modifier
import org.w3c.dom.html.HTMLHtmlElement
import com.raquo.laminar.keys.HtmlProp
import org.scalajs.dom.HTMLElement


final class RendererProp[A](override val name: String) extends Key {
    var maybeRoot: Option[RootNode] = None
    var maybeModel: Option[Var[A]] = None

    val modelEventBus = EventBus[A]()
    var modelSignal: Signal[A] = null 

    def apply(element: ReactiveElement.Base) =  {
        element.amend(onUnmountCallback { _ => 
            maybeRoot.foreach(_.unmount())
            maybeRoot = None
        })
    }

    protected val renderer: HtmlProp[js.Function, _] = htmlProp(name, AsIsCodec())

    def :=(content: HtmlElement | Function1[Signal[A], HtmlElement]) = {
        Modifier[ReactiveHtmlElement.Base] { parent =>
            this(parent) // Start by setting unmount callback


            def renderFunc = (el: dom.Element, ref: js.Any, model: A) => {
                println(s"render: ${el.hashCode()}")
                if (modelSignal == null)
                then modelSignal = modelEventBus.events.startWith(model)
                else modelEventBus.emit(model)

                    
                if (maybeRoot.isEmpty)
                then {
                    val element = content match
                        case signalToElem: Function[_ >: Signal[A], _ <: ReactiveHtmlElement.Base] => {
                            signalToElem(modelSignal)
                        }
                        case _: HtmlElement => content.asInstanceOf[ReactiveHtmlElement.Base]

                    maybeRoot = Some(render(el, element))
                }
            }

            renderer.apply(renderFunc).apply(parent)
        }
    }
}

    // For grid
    // The render func is called each time the underlying model is called.

    /* 

    case class Person(name: String, age: Int)

    vaadin.Grid.of[Person](
        _.items = [Person("aron", 35)],
        vaadin.Column.of[Int](
            _.path = "name"
            _.content { column =>
                div(h1(column))
            }

        vaadin.Column(
            _.path = "age"
        )
    ) 

    */
