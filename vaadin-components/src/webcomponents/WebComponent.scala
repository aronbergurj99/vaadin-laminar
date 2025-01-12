package webcomponents

import com.raquo.laminar.api.L.{*, given}
import com.raquo.laminar.nodes.ReactiveHtmlElement

import org.scalajs.dom
import com.raquo.laminar.tags.CustomHtmlTag
import com.raquo.laminar.modifiers.Modifier

trait WebComponent {
    type Ref <: dom.HTMLElement

    protected val tag: CustomHtmlTag[Ref]

    type ModFunction  = this.type => Mod[ReactiveHtmlElement[Ref]]
    type ComponentMod = ModFunction | Mod[ReactiveHtmlElement[Ref]]

    final def apply(mods: ComponentMod*): HtmlElement = tag(
        mods.map {
            case mod: Mod[_ >: ReactiveHtmlElement[Ref]]                      => (_: this.type) => mod
            case mod: Function[_ >: this.type, _ <: ReactiveHtmlElement[Ref]] => mod
        }.map(_(this))*
    )
}