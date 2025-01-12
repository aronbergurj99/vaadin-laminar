package example

import com.raquo.laminar.api.L.{*, given}

import scala.scalajs.js
import scala.scalajs.js.annotation

import org.scalajs.dom

import webcomponents.vaadin


object Main {
    def main(args: Array[String]): Unit = {
        renderOnDomContentLoaded(
            dom.document.getElementById("app"),
            appElement,
        )
    }

    def appElement = 
        div(
            vaadin.AppLayout(
                h1("Hello world", slot("navbar"), className("text-l m-0"))
            )
        )
}