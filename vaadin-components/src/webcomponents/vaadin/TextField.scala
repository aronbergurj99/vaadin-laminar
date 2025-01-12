package webcomponents.vaadin

import webcomponents.WebComponent

import scala.scalajs.js
import scala.scalajs.js.annotation.*

import org.scalajs.dom
import com.raquo.laminar.tags.CustomHtmlTag
import com.raquo.laminar.keys.HtmlAttr
import com.raquo.laminar.api.L.{htmlAttr}
import com.raquo.laminar.codecs.{StringAsIsCodec}

/**
  * Todo: write doc, implement missing API, WIP!
  */
object TextField extends WebComponent {
    @js.native
    @JSImport("@vaadin/text-field", JSImport.Default)
    object RawImport extends js.Object

    type Ref = dom.html.Element & js.Object

    used(RawImport)

    lazy val label: HtmlAttr[String] = htmlAttr("label", StringAsIsCodec)

    protected val tag: CustomHtmlTag[Ref] = CustomHtmlTag("vaadin-text-field")
}