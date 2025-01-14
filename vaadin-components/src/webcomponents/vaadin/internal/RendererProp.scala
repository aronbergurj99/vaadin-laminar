package webcomponents.vaadin.internal

import com.raquo.laminar.api.L.{*, given}
import com.raquo.laminar.codecs.{AsIsCodec}

import scala.scalajs.js

import org.scalajs.dom

final class RendererProp[A](val name: String) {
    protected val rendererProp: HtmlProp[js.Function, _] = htmlProp(name, AsIsCodec())
    var rendered = false

    def :=(element: HtmlElement | Function1[A, HtmlElement]) =
        Modifier[HtmlElement] { parent =>
            def render = (root: dom.Element, ref: js.Any, model: A) => {
                element match {
                    case modelToElem: Function[_ >: A, _ <: HtmlElement] => {
                        root.innerHTML = modelToElem(model).ref.outerHTML
                    }
                    case _: HtmlElement => {
                        // This is static and does not change
                        if !rendered
                        then root.innerHTML = element.asInstanceOf[HtmlElement].ref.outerHTML
                    }
                }
            }
    
            rendererProp.apply(render).apply(parent)
        }
}