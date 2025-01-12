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
    @JSImport("@vaadin/app-layout", JSImport.Default)
    object RawImport extends js.Object

    type Ref = dom.html.Element & js.Object

    used(RawImport)

    protected val tag: CustomHtmlTag[Ref] = CustomHtmlTag("vaadin-app-layout")

    object DrawerToggle extends WebComponent {
        @js.native
        @JSImport("@vaadin/app-layout/vaadin-drawer-toggle", JSImport.Default)
        object RawImport extends js.Object

        type Ref = dom.html.Element & js.Object

        used(RawImport)

        protected val tag: CustomHtmlTag[Ref] = CustomHtmlTag("vaadin-drawer-toggle")      
    }
} 