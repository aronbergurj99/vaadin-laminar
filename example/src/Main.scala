package example

import com.raquo.laminar.api.L.{*, given}

import scala.scalajs.js
import scala.scalajs.js.annotation

import org.scalajs.dom


object Main {
    def main(args: Array[String]): Unit = {
        println("hello world")
        renderOnDomContentLoaded(
            dom.document.getElementById("app"),
            appElement,
        )
    }

    def appElement = 
        div(
            h1("hello world")
        )
}