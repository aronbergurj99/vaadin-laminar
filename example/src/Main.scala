package example

import com.raquo.laminar.api.L.{*, given}

import scala.scalajs.js
import scala.scalajs.js.annotation

import org.scalajs.dom

import webcomponents.vaadin
import webcomponents.vaadin.Icon.icon


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
                vaadin.AppLayout.DrawerToggle(slot("navbar")),
                h1("Hello world", slot("navbar"), className("text-l m-0")),
                vaadin.Scroller(
                    slot("drawer"),
                    vaadin.SideNav(
                        vaadin.SideNav.SideNavItem(
                            vaadin.Icon(icon("vaadin:dashboard"), slot("prefix")),
                            "hello world",
                        )
                    )
                )
            )
        )
}