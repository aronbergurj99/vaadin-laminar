package webcomponents.vaadin

import webcomponents.WebComponent

import scala.scalajs.js
import scala.scalajs.js.annotation.*

import org.scalajs.dom
import com.raquo.laminar.tags.CustomHtmlTag

/**
  * Todo: write doc, implement missing API, WIP!
  */
object SideNav extends WebComponent {
    @js.native
    @JSImport("@vaadin/side-nav", JSImport.Default)
    object RawImport extends js.Object

    type Ref = dom.html.Element & js.Object

    used(RawImport)

    protected val tag: CustomHtmlTag[Ref] = CustomHtmlTag("vaadin-side-nav")

    /**
      * Todo: write doc, implement missing API, WIP!
      */
    object SideNavItem extends WebComponent {
      @js.native
      @JSImport("@vaadin/side-nav/vaadin-side-nav-item", JSImport.Default)
      object RawImport extends js.Object

      type Ref = dom.html.Element & js.Object

      used(RawImport)

      protected val tag: CustomHtmlTag[Ref] = CustomHtmlTag("vaadin-side-nav-item")
    }
}