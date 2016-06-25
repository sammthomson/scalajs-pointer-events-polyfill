# scalajs-pointer-events-polyfill

A Scala.js facade for [Pointer Events Polyfill](https://github.com/jquery/PEP/tree/0.4.1).
[Pointer Events](https://developer.mozilla.org/en-US/docs/Web/API/Pointer_events) provide
a common interface for handling different pointing devices (mouse, touch, pen, etc.).
They're not supported by many browsers yet, hence the need for a polyfill.

## Usage

Add the following to your `build.sbt`:

```sbt
resolvers += Resolver.bintrayRepo("sammthomson", "maven")
libraryDependencies += "org.samthomson" %%% "scalajs-pointer-events-polyfill" % "0.1"
```

Then you can attach a pointer event listener like so:

```scala
import org.samthomson.pointerevents.{PointerEvent, PointerEventTarget}
import org.scalajs.dom.{document, console}
import scala.scalajs.js.JSApp

object Example extends JSApp {
  def main(): Unit = {
    val canvas = document.getElementById("canvas")
    canvas.onPointerDown { (e: PointerEvent) => console.log(e.clientX + ", " e.clientY) }
  }
}
```

You'll want your html element to have a `touch-action="none"` attribute, e.g.:

```html
<html>
  <body>
    <canvas id="canvas" width="710" height="562" touch-action="none"></canvas>
  </body>
  <script type="text/javascript" src="./target/scala-2.11/example-jsdeps.js"></script>
  <script type="text/javascript" src="./target/scala-2.11/example-opt.js"></script>
  <script type="text/javascript">
    Example().main();
  </script>
</html>
```

`PointerEventTarget` is an implicit class that adds the following methods to any `org.scalajs.dom.raw.EventTarget`
(which includes `HTMLElement`s):

```scala
def onPointerDown(f: js.Function1[PointerEvent, _]): Unit
def onPointerUp(f: js.Function1[PointerEvent, _]): Unit
def onPointerMove(f: js.Function1[PointerEvent, _]): Unit
def onPointerOver(f: js.Function1[PointerEvent, _]): Unit
def onPointerOut(f: js.Function1[PointerEvent, _]): Unit
def onPointerEnter(f: js.Function1[PointerEvent, _]): Unit
def onPointerLeave(f: js.Function1[PointerEvent, _]): Unit
def onPointerCancel(f: js.Function1[PointerEvent, _]): Unit
def onGotPointerCapture(f: js.Function1[PointerEvent, _]): Unit
def onLostPointerCapture(f: js.Function1[PointerEvent, _]): Unit
```
