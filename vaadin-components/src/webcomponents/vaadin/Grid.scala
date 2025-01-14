package webcomponents.vaadin

import scala.scalajs.js
import scala.scalajs.js.annotation.*

import org.scalajs.dom

import com.raquo.laminar.api.L.{*, given}
import com.raquo.laminar.tags.CustomHtmlTag
import com.raquo.laminar.codecs.{StringAsIsCodec, AsIsCodec}


import webcomponents.WebComponent
import webcomponents.vaadin.internal.RendererProp

object grid {
    object Grid extends WebComponent {
        trait RawElement extends js.Object    
    
        @js.native 
        @JSImport("@vaadin/grid", JSImport.Default)
        object RawImport extends js.Object
    
        type Ref = dom.html.Element with RawElement
    
        used(RawImport)
    
        protected val tag: CustomHtmlTag[Ref] = CustomHtmlTag("vaadin-grid")

        lazy val items: HtmlProp[js.Array[js.Object], _] = htmlProp("items", AsIsCodec())
    
    }  

    
    object Column {
        trait Model[Item <: js.Object | String] extends js.Object {
            val items: Item
        }
    
        class Column[Item <: js.Object | String] extends WebComponent {
            trait RawElement extends js.Object    
            type Ref = dom.html.Element with RawElement
            protected val tag: CustomHtmlTag[Ref] = CustomHtmlTag("vaadin-grid-column") 
        
        
            lazy val path: HtmlAttr[String] = htmlAttr("path", StringAsIsCodec)
            lazy val header: HtmlAttr[String] = htmlAttr("header", StringAsIsCodec)
    
            lazy val content = new RendererProp[Model[Item]]("renderer")
        }
    
        @js.native 
        @JSImport("@vaadin/grid/vaadin-grid-column", JSImport.Default)
        object RawImport extends js.Object


        used(RawImport)

        def apply = {
            new Column[js.Object]
        }

        def default = {
            apply
        }

        def withItem[Item <: js.Object | String ]: Column[Item] = {
            new Column[Item]()
        }
    }
}

