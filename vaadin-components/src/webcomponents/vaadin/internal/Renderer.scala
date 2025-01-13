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

type RendererProp = js.Function2[dom.Element, Any, Unit]

/* 
Draft

We want to be able to do
dialog(content <-- div("hello"), headerContent <-- div("my header") )

Instead of providing low level javascript render func
*/
final class Renderer[A](override val name: String) extends Key {
    private val renderer: HtmlProp[RendererProp,RendererProp] = htmlProp(name, AsIsCodec())

    // We don't have a render root until the first call to renderer function
    var maybeRoot: Option[RootNode] = None

    // Todo: hacky prototype as proof of concept
    // Works for components that should rerender (Throw state) like dialogs
    def :=(element: HtmlElement) = {
        new KeySetter[Renderer[A], RendererProp, HtmlElement](this, (el: dom.Element, ref: Any) => {
            maybeRoot match {
                case None => maybeRoot = Some(render(el, element))
                case Some(_) => println("Re opened")
            }

        }, (element: ReactiveHtmlElement.Base, prop: Renderer[A], value: RendererProp) => {
            element.amend(onUnmountCallback { _ => 
                maybeRoot match
                    case Some(root) => {
                        root.unmount()
                        maybeRoot = None
                        println("unmounting")
                    }
                    case None => println("No need to unmount never mounted")
                
            }).ref.asInstanceOf[js.Dynamic].updateDynamic(prop.name)(value.asInstanceOf[js.Any])
        })
    }

    // For grid
    // The render func is called each time the 

}