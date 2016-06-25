package org.samthomson.pointerevents

import org.scalajs.dom._
import scala.scalajs.js


/**
  * An event triggered by a pointing device (mouse, touch, pen, etc.).
  *
  * See:
  * https://github.com/jquery/PEP
  * https://developer.mozilla.org/en-US/docs/Web/API/Pointer_events
  */
@js.native
class PointerEvent extends UIEvent with ModifierKeyEvent {
  /** One of {"", "unavailable", "touch", "pen", "mouse"} */
  def pointerType: String = js.native
  /** A unique id for the pointing device */
  def pointerId: Int = js.native
  /** Whether this pointing device is the primary one for this pointer type */
  def isPrimary: Boolean = js.native

  // Coordinates are all in pixels, but may be non-integers if the screen is zoomed, e.g.
  /** X coordinate of the pointer in global (screen) coordinates. */
  def screenX: Double = js.native
  /** Y coordinate of the pointer in global (screen) coordinates. */
  def screenY: Double = js.native
  /**
    * X coordinate of the pointer (in pixels), relative to the whole document, when the mouse event fired.
    * Takes into account any horizontal scrolling of the page.
    */
  def pageX: Double = js.native
  /**
    * Y coordinate of the pointer (in pixels), relative to the whole document, when the mouse event fired.
    * Takes into account any vertical scrolling of the page.
    */
  def pageY: Double = js.native
  /** X coordinate of the pointer in local (DOM content) coordinates. */
  def clientX: Double = js.native
  /** Y coordinate of the pointer in local (DOM content) coordinates. */
  def clientY: Double = js.native

  /** The secondary target for the event, if there is one, `null` otherwise. */
  def relatedTarget: EventTarget = js.native
  /**
    * Which button was pressed to trigger the event.
    * For mice:
    *   0: Main button pressed, usually the left button or the un-initialized state
    *   1: Auxiliary button pressed, usually the wheel button or the middle button (if present)
    *   2: Secondary button pressed, usually the right button
    *   3: Fourth button, typically the Browser Back button
    *   4: Fifth button, typically the Browser Forward button
    */
  def button: Int = js.native
  /**
    * Bitmap of which buttons are currently pressed.
    * `buttonsPressed.map(b => math.pow(2, b)).sum`
    */
  def buttons: Int = js.native

  // Touch-specific
  /** Width of the touch in pixels, 0 for mice */
  def width: Double = js.native
  /** Height of the touch in pixels, 0 for mice */
  def height: Double = js.native
  /**
    * Pressure of the touch, from min 0.0 to max 1.0.
    * For mice, 0.5 for down state and 0 for up state.
    */
  def pressure: Double = js.native
  /**
    * the plane angle (in degrees, in the range of -90 to 90) between the Y-Z
    * plane and the plane containing both the transducer (e.g. pen stylus) axis
    * and the Y axis.
    * 0 for mice.
    */
  def tiltX: Double = js.native
  /**
    * the plane angle (in degrees, in the range of -90 to 90) between the X-Z
    * plane and the plane containing both the transducer (e.g. pen stylus) axis
    * and the X axis.
    * 0 for mice */
  def tiltY: Double = js.native
}
