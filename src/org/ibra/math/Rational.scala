package org.ibra.math

class Rational(n: Int, d: Int) {
  //Primary constructor body
  require(d != 0, "Dominator shouldn't be 0")
  
  private val cd = gcd(n, d)
  println("Greatest common divider is : " + cd)
  val numer = n / cd
  val domin = d / cd
  //Auxiliary constructor
  def this(number: Int) = this(number, 1)
  
  def add(that: Rational): Rational = {
    return new Rational(that.domin * numer + that.numer * domin, that.domin * domin);
  }
  
  private def gcd(x: Int, y: Int): Int = {
    if(y == 0) x else gcd(y, x % y)
  }
  
  override def toString(): String = {
    return numer + "/" + domin;
  }
}