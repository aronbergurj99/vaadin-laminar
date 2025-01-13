package example

import com.raquo.laminar.api.L.{*, given}
import frontroute.*

import scala.scalajs.js
import scala.scalajs.js.annotation

import org.scalajs.dom

import webcomponents.vaadin
import example.examples.Example
import example.examples.ButtonExample
import example.examples.TextFieldExample
import example.examples.SelectExample
import webcomponents.vaadin.Dialog
import example.examples.DialogExample


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
                        vaadin.Icon(_.icon("vaadin:dashboard"), slot("prefix")),
                        _.path("/button"),
                        "Button",
                        onClick.preventDefault --> { _ => BrowserNavigation.pushState(url = "/button") }
                    ),
                    vaadin.SideNav.SideNavItem(
                        vaadin.Icon(_.icon("vaadin:dashboard"), slot("prefix")),
                        _.path("/text-field"),
                        "TextField",
                        onClick.preventDefault --> { _ => BrowserNavigation.pushState(url = "/text-field") }
                    ),
                    vaadin.SideNav.SideNavItem(
                        vaadin.Icon(_.icon("vaadin:dashboard"), slot("prefix")),
                        _.path("/select"),
                        "Select",
                        onClick.preventDefault --> { _ => BrowserNavigation.pushState(url = "/select") }
                    ),
                    vaadin.SideNav.SideNavItem(
                        vaadin.Icon(_.icon("vaadin:dashboard"), slot("prefix")),
                        _.path("/dialog"),
                        "Dialog",
                        onClick.preventDefault --> { _ => BrowserNavigation.pushState(url = "/dialog") }
                    )
                )
            ),
            routes(
                div(
                    ButtonExample(),
                    TextFieldExample(),
                    SelectExample(),
                    DialogExample()
                )
            )
        )
}