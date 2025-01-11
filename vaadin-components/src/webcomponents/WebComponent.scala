package webcomponents

import com.raquo.laminar.api.L.{*, given}
import com.raquo.laminar.nodes.ReactiveHtmlElement

import org.scalajs.dom
import com.raquo.laminar.tags.CustomHtmlTag

trait WebComponent {
    type Ref <: dom.HTMLElement

    protected val tag: CustomHtmlTag[Ref]

    final def apply(mods: Mod[ReactiveHtmlElement[Ref]]*): HtmlElement = tag(mods)
}