package webcomponents.vaadin

import scala.scalajs.js
import scala.scalajs.js.annotation.*

import org.scalajs.dom

import com.raquo.laminar.api.L.{*, given}
import com.raquo.laminar.tags.CustomHtmlTag

import webcomponents.WebComponent

@js.native 
@JSImport("@vaadin/grid", JSImport.Default)
object RawImport extends js.Object

class Grid(val testing: String) extends WebComponent{
    trait RawElement extends js.Object    

    type Ref = dom.html.Element with RawElement

    used(RawImport)

    protected val tag: CustomHtmlTag[Ref] = CustomHtmlTag("vaadin-grid")
}  
