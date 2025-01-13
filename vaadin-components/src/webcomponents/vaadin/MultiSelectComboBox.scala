package webcomponents.vaadin

import webcomponents.WebComponent

import scala.scalajs.js
import scala.scalajs.js.annotation.*

import org.scalajs.dom
import com.raquo.laminar.tags.CustomHtmlTag
import com.raquo.laminar.keys.HtmlAttr
import com.raquo.laminar.api.L.{htmlAttr, htmlProp}
import com.raquo.laminar.codecs.AsIsCodec
import scala.collection.mutable
import com.raquo.laminar.keys.HtmlProp

@js.native
trait withItems[A] extends js.Object {
  // var items: mutable.Seq[mutable.Map[String, A]] = js.native
  var items: js.Array[js.Dictionary[A]]
}

trait Item extends js.Object {
  val value: String
  val label: String
}

/**
  * Todo: write doc, implement missing API, WIP!
  */
 object MultiSelectComboBox extends WebComponent {
    @js.native
    @JSImport("@vaadin/multi-select-combo-box", JSImport.Default)
    object RawImport extends js.Object

    type Ref = dom.html.Element & js.Object

    used(RawImport)

    // Todo: abstract?
    lazy val label: HtmlAttr[String] = htmlAttr("label", AsIsCodec())

    protected val tag: CustomHtmlTag[Ref] = CustomHtmlTag("vaadin-multi-select-combo-box")

    lazy val items: HtmlProp[js.Array[Item], js.Array[Item]] = htmlProp("items", AsIsCodec())
}