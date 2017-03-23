package pl.writeonly.son2.util

import java.util.function.Consumer

object Control {

  val UTF_8 = "UTF-8"

  def using[A <: {def close() : Unit}, B](resource: A)(f: A => B): B =
    try {
      f(resource)
    } finally {
      resource.close()
    }

  implicit def toConsumerUnit[A](function: A => Unit): Consumer[A] = new Consumer[A]() {
    override def accept(arg: A): Unit = function.apply(arg)
  }

  implicit def toConsumerAny[A](function: A => Any): Consumer[A] = new Consumer[A]() {
    override def accept(arg: A): Unit = function.apply(arg)
  }
}