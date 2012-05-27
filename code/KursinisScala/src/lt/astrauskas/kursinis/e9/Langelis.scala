package lt.astrauskas.kursinis.e9

import java.lang.Integer

abstract class SkaičiųLangelis {
  type Tipas <: Number
  val numatytojiReikšmė: Tipas
  private var reikšmė: Tipas = numatytojiReikšmė
  def nustatytiReikšmę(naujaReikšmė: Tipas) = reikšmė = naujaReikšmė
  def gautiReikšmę() = reikšmė
  }

class SveikųjųSkaičiųLangelis(val numatytojiReikšmė: Integer)
    extends SkaičiųLangelis {
  type Tipas = Integer
  }

//class SimoboliųEilučiųLangelis(val numatytojiReikšmė: String)
//    extends SkaičiųLangelis {
//  type Tipas = String                   // Kompiliavimo klaida.
//  }