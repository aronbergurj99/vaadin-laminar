package webcomponents.vaadin.internal

import scala.scalajs.js
import org.scalajs.dom

import com.raquo.laminar.api.L.{*, given}
import com.raquo.laminar.nodes.ReactiveHtmlElement
import com.raquo.laminar.codecs.{AsIsCodec}

final class ContentProp(val name: String) {
    protected val rendererProp: HtmlProp[js.Function, _] = htmlProp(name, AsIsCodec())

    var maybeRoot: Option[RootNode] = None

    def connectUnmount(parent: ReactiveHtmlElement.Base) =
        parent.amend(onUnmountCallback { _ =>
            maybeRoot.foreach(_.unmount())
            maybeRoot = None
        })


    def := (content: ReactiveHtmlElement.Base) =
        Modifier[ReactiveHtmlElement.Base] { parent =>
            connectUnmount(parent)     

            def renderer = (el: dom.Element) => {
                if (maybeRoot.isEmpty)
                then maybeRoot = Some(render(el, content))
            }

            rendererProp.apply(renderer).apply(parent)
        } 
}
