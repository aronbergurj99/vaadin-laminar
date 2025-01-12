package webcomponents.vaadin

import scala.scalajs.js
import scala.scalajs.js.annotation.*
import com.raquo.laminar.tags.CustomHtmlTag
import com.raquo.laminar.codecs.{BooleanAsAttrPresenceCodec}


import com.raquo.laminar.api.L.{*, given}

import org.scalajs.dom
import webcomponents.WebComponent
import com.raquo.laminar.keys.EventProp
import org.scalajs.dom.EventTarget
import org.scalajs.dom.Event
import com.raquo.laminar.keys.HtmlAttr

/** The Button component allows users to perform actions. 
  * It comes in several different style variants and supports icons as well as text labels.
  *
  * @see
  *   <a href="https://vaadin.com/docs/latest/components/button">the doc</a> for more information.
  */
object Button extends WebComponent {
  @js.native
  @JSImport("@vaadin/button", JSImport.Default)
  object RawImport extends js.Object

  type Ref = dom.html.Element & js.Object

  used(RawImport)

  lazy val disabled: HtmlAttr[Boolean]    = htmlAttr("disabled", BooleanAsAttrPresenceCodec)

  protected val tag: CustomHtmlTag[Ref] = CustomHtmlTag("vaadin-button") 
}
