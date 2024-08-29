import kotlin.math.sqrt // Importa la función para calcular la raíz cuadrada.
import kotlin.random.Random // Importa la función para generar números aleatorios.

fun main() {
    // Crear una lista con 1000 números aleatorios entre 1 y 99.
    val numeros = List(1000) { Random.nextInt(1, 100) }

    // Calcular la media (promedio) de los números.
    val media = numeros.average()

    // Ordenar los números para calcular la mediana.
    val numerosOrdenados = numeros.sorted()
    // Si hay una cantidad par de números, la mediana es el promedio de los dos números del medio.
    // Si hay una cantidad impar, la mediana es el número del medio.
    val mediana = if (numeros.size % 2 == 0) {
        (numerosOrdenados[numeros.size / 2] + numerosOrdenados[numeros.size / 2 - 1]) / 2.0
    } else {
        numerosOrdenados[numeros.size / 2].toDouble()
    }

    // Crear un mapa para contar cuántas veces aparece cada número.
    val mapaFrecuencia = numeros.groupingBy { it }.eachCount()
    // Encontrar el número que aparece más veces (la moda).
    val moda = mapaFrecuencia.maxByOrNull { it.value }?.key

    // Calcular la varianza: el promedio de las diferencias al cuadrado entre cada número y la media.
    val varianza = numeros.map { numero -> (numero - media) * (numero - media) }.average()
    // Calcular la desviación estándar: la raíz cuadrada de la varianza.
    val desviacionEstandar = sqrt(varianza)

    // Mostrar los resultados en la consola.
    println("Media: $media")
    println("Mediana: $mediana")
    println("Moda: $moda")
    println("Desviación Estándar: $desviacionEstandar")
}
