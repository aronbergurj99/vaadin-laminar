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
object Icon extends WebComponent {
    @js.native
    @JSImport("@vaadin/icon", JSImport.Default)
    object RawImport extends js.Object

    @js.native
    @JSImport("@vaadin/icons", JSImport.Default)
    object Icons extends js.Object

    used(Icons)

    type Ref = dom.html.Element & js.Object

    used(RawImport)

    lazy val icon: HtmlAttr[String] = htmlAttr("icon", StringAsIsCodec)

    protected val tag: CustomHtmlTag[Ref] = CustomHtmlTag("vaadin-icon")
}