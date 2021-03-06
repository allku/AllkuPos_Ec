//    Allku Pos  - Touch Friendly Point Of Sale
//    Copyright (c) 2009-2018 uniCenta & previous Openbravo POS works
//    https://www.allku.expert
//
//    This file is part of Allku Pos
//
//    Allku Pos is free software: you can redistribute it and/or modify
//    it under the terms of the GNU General Public License as published by
//    the Free Software Foundation, either version 3 of the License, or
//    (at your option) any later version.
//
//    Allku Pos is distributed in the hope that it will be useful,
//    but WITHOUT ANY WARRANTY; without even the implied warranty of
//    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
//    GNU General Public License for more details.
//
//    You should have received a copy of the GNU General Public License
//    along with Allku Pos.  If not, see <http://www.gnu.org/licenses/>.

package expert.allku.identification

/**
 * Created by jorge luis on 2021/03/03
 */

class Ruc(val ruc : String) : Ci(ci = ruc) {

    var tipo = ""
    private val NATURAL = "NATURAL"
    private val PUBLICO = "PÚBLICO"
    private val PRIVADO = "PRIVADO"

    override fun validar() : Boolean {
        if (!basica(13))
            return false
        if (!provincia())
            return false
        if (!establecimiento())
            return false
        if (!natural()){
            if (!privado()) {
                return publico()
            }
            else
                return true
        }
        else
            return true
    }

    fun natural() : Boolean {
        if (!modulo10())
            return false

        tipo=NATURAL
        return true
    }
    fun publico() : Boolean {
        if (!modulo11(PUBLICO))
            return false

        tipo=PUBLICO
        return true
    }
    fun privado() : Boolean {
        if (!modulo11(PRIVADO))
            return false

        tipo=PRIVADO
        return true
    }

    fun establecimiento() : Boolean {
        val numero = ruc.substring(10,13).toInt()
        println("Establecimiento: $numero")

        if (numero > 0)
            return true

        error = "Los 3 últimos díjitos del RUC no deben ser cero"
        return false
    }
    /**
     * Algoritmo Modulo11 para validar RUC de sociedades privadas y públicas
     *
     * El díjito verificador es el decimo digito para RUC de empresas privadas
     * y el noveno díjito para RUC de empresas públicas
     *
     * Paso 1: Multiplicar cada díjito de los digitos iniciales por su respectivo
     * coeficiente.
     *
     * Para RUC privadas el coeficiente esta definido y se multiplica con las siguientes
     * posiciones del RUC:
     *
     * Ejemplo
     * digitosIniciales posicion 1 x 4
     * digitosIniciales posicion 2 x 3
     * digitosIniciales posicion 3 x 2
     * digitosIniciales posicion 4 x 7
     * digitosIniciales posicion 5 x 6
     * digitosIniciales posicion 6 x 5
     * digitosIniciales posicion 7 x 4
     * digitosIniciales posicion 8 x 3
     * digitosIniciales posicion 9 x 2
     *
     * Para RUC privadas el coeficiente esta definido y se multiplica con las siguientes
     * posiciones del RUC:
     *
     * digitosIniciales posicion 1 x 3
     * digitosIniciales posicion 2 x 2
     * digitosIniciales posicion 3 x 7
     * digitosIniciales posicion 4 x 6
     * digitosIniciales posicion 5 x 5
     * digitosIniciales posicion 6 x 4
     * digitosIniciales posicion 7 x 3
     * digitosIniciales posicion 8 x 2
     *
     * Paso 2: Se suman los resultados y se obtiene total
     *
     * Paso 3: Divido total para 11, se guarda residuo. Se resta 11 menos el residuo.
     * El valor obtenido debe concordar con el digitoVerificador
     *
     * Nota: Cuando el residuo es cero(0) el díjito verificador debe ser 0.
     */

    fun modulo11(tipoRuc : String) : Boolean {
        val multiplicadores : IntArray
        val dijitos : CharArray
        val verificador : Int
        var valor : Int
        var total = 0
        val residuo : Int
        val resultado : Int

        if (tipoRuc == PUBLICO){
            multiplicadores = intArrayOf(3,2,7,6,5,4,3,2)
            dijitos = ruc.substring(0,8).toCharArray()
            verificador = ruc.substring(8,9).toInt()
        }
        else{
            multiplicadores = intArrayOf(4,3,2,7,6,5,4,3,2)
            dijitos = ruc.substring(0,9).toCharArray()
            verificador = ruc.substring(9,10).toInt()
        }

        println("Algoritmo Módulo 11 $tipoRuc")
        println("Verificador: $verificador")

        for (i in dijitos.indices){
            val multiplicador = multiplicadores[i]
            val dijito  = dijitos[i].toString().toInt()
            valor = multiplicador*dijito

            println("Multiplicador:  ${multiplicador} * Díjito: ${dijito} = $valor")

            total = total + valor

        }

        println("Total = $total")

        residuo = total % 11

        println("Residuo = $residuo")

        if (residuo == 0) {
            resultado = 0
        }
        else {
            resultado = 11 - residuo
        }

        if (resultado == verificador) {
            println("Resultado = $resultado")
            error = ""
            return true
        }

        error = "Los números no cumplen la validación del algoritomo módulo 11 para RUC $tipoRuc"
        return false
    }
}
