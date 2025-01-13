package webcomponents.vaadin

import webcomponents.WebComponent
import org.scalajs.dom

import scala.scalajs.js
import scala.scalajs.js.annotation.*
import com.raquo.laminar.tags.CustomHtmlTag
import org.scalajs.dom.html.Element
import com.raquo.laminar.api.L.{*, given}
import com.raquo.laminar.codecs.BooleanAsIsCodec
import webcomponents.vaadin.internal.Renderer

object Dialog extends WebComponent {
    trait RawElement extends js.Object {
        var renderer: js.Function2[dom.Element, Dialog.Ref, Unit]
    }
    
    @js.native 
    @JSImport("@vaadin/dialog", JSImport.Default)
    object RawImport extends js.Object

    type Ref = dom.html.Element with RawElement

    used(RawImport)

    protected val tag: CustomHtmlTag[Ref] = CustomHtmlTag("vaadin-dialog")

    lazy val opened: HtmlProp[Boolean, Boolean] = htmlProp("opened", BooleanAsIsCodec)

    lazy val content: Renderer[Ref] = Renderer[Ref]("renderer")
}
