package example

import com.raquo.laminar.api.L.{*, given}

import scala.scalajs.js
import scala.scalajs.js.annotation

import org.scalajs.dom

import webcomponents.vaadin
import webcomponents.vaadin.Icon.icon
import webcomponents.vaadin.AppLayout.primarySection


object Main {
    def main(args: Array[String]): Unit = {

        renderOnDomContentLoaded(
            dom.document.getElementById("app"),
            appElement,
        )
    }

    def appElement = 
        vaadin.AppLayout(
            h1("vaadin-laminar", slot("navbar"), className("text-l m-0 ml-m")),
            vaadin.Scroller(
                slot("drawer"),
                vaadin.SideNav(
                    vaadin.SideNav.SideNavItem(
                        vaadin.Icon(icon("vaadin:dashboard"), slot("prefix")),
                        "Demo"
                    )
                )
            ),
            div(
                className("flex", "gap-s", "p-m"),
                vaadin.Button("enabled"),
                vaadin.Button("disabled", disabled(true)),
                vaadin.TextField(_.label("hello world"))
            )
        )
}