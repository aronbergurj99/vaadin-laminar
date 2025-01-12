package example.examples
import com.raquo.laminar.api.L.{*, given}

object ExamplePanel {
    def apply(title: String)(body: HtmlElement): HtmlElement = {
        div(
            h5(title),
            div(
                body,
            )
        )
    }
}