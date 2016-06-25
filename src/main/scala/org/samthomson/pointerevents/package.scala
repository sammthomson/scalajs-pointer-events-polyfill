package org.samthomson

import org.scalajs.dom._

import scala.scalajs.js

package object pointerevents {
  /** Enriches an EventTarget with methods to add listeners for PointerEvents */
  implicit class PointerEventTarget(target: EventTarget) {
    /** fired when a pointer becomes active. */
    def onPointerDown(f: js.Function1[PointerEvent, _]): Unit = add("pointerdown", f)
    /** fired when a pointer is no longer active. */
    def onPointerUp(f: js.Function1[PointerEvent, _]): Unit = add("pointerup", f)
    /** fired when a pointer changes coordinates. */
    def onPointerMove(f: js.Function1[PointerEvent, _]): Unit = add("pointermove", f)
    /** fired when a pointing device is moved into an element's hit test boundaries. */
    def onPointerOver(f: js.Function1[PointerEvent, _]): Unit = add("pointerover", f)
    /**
      * fired for several reasons including: pointing device is moved out of the
      * hit test boundaries of an element; firing the pointerup event for a
      * device that does not support hover (see pointerup); after firing the
      * pointercancel event (see pointercancel); when a pen stylus leaves the
      * hover range detectable by the digitizer.
      */
    def onPointerOut(f: js.Function1[PointerEvent, _]): Unit = add("pointerout", f)
    /**
      * fired when when a pointing device is moved into the hit test boundaries
      * of an element or one of its descendants, including as a result of a
      * pointerdown event from a device that does not support hover (see
      * pointerdown).
      */
    def onPointerEnter(f: js.Function1[PointerEvent, _]): Unit = add("pointerenter", f)
    /**
      * fired when a pointing device is moved out of the hit test boundaries of
      * an element. For pen devices, this event is fired when the stylus leaves
      * the hover range detectable by the digitizer.
      */
    def onPointerLeave(f: js.Function1[PointerEvent, _]): Unit = add("pointerleave", f)
    /**
      * a browser fires this event if it concludes the pointer will no longer be
      * able to generate events (for example the related device is deactived).
      */
    def onPointerCancel(f: js.Function1[PointerEvent, _]): Unit = add("pointercancel", f)
    /** fired when an element receives pointer capture. */
    def onGotPointerCapture(f: js.Function1[PointerEvent, _]): Unit = add("gotpointercapture", f)
    /** fired after pointer capture is released for a pointer. */
    def onLostPointerCapture(f: js.Function1[PointerEvent, _]): Unit = add("lostpointercapture", f)

    private def add(name: String, f: js.Function1[PointerEvent, _]): Unit = target.addEventListener(name, f)
  }
}
