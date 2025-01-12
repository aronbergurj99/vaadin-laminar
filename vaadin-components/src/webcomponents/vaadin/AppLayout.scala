package webcomponents.vaadin

import webcomponents.WebComponent

import scala.scalajs.js
import scala.scalajs.js.annotation.*

import org.scalajs.dom
import com.raquo.laminar.tags.CustomHtmlTag

/**
  * Todo: write doc, implement missing API, WIP!
  */
object AppLayout extends WebComponent {
    @js.native
    @JSImport("@vaadin/app-layout/vaadin-app-layout.js", JSImport.Default)
    object RawImport extends js.Object

    type Ref = dom.html.Element & js.Object

    used(RawImport)

    protected val tag: CustomHtmlTag[Ref] = CustomHtmlTag("vaadin-app-layout")
} 