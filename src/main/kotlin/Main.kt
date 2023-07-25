/*Universidad del Vallel de Guatemala
Programación de Plataformas Móviles
Michelle Mejía Villela
Carnet 22596
 */

//Clase persona
data class Person(val name: String, val age: Int, val gender: String)

//Clase estudiante
data class Student(val name: String, val age: Int, val gender: String, val studentId: String)

//Función para calcular promedio usando reduce
fun calculateProm(numbers: List<Int>): Int{
    val suma = numbers.reduce { acc, num -> acc + num }
    return suma/numbers.size
}

//Función para verificar si es un palíndromo
fun isPalindrome(text: String): Boolean {
    return (text == text.reversed())
}

//Función para realizar operaciones matemáticas
fun performOperation(a: Int, b: Int, operation: (Int, Int) -> Int): Int {
    return operation(a, b)
}

//Función para convertir a una persona en estudiante
fun personToStudent(person: Person): Student {
    return Student(person.name, person.age, person.gender, "${person.name}-${person.age}")
}

//Código principal
fun main(args: Array<String>) {

    //Ejercicio 1
    println(" ")
    val numbers = listOf(2, 3, 5, 7)
    val prom = calculateProm(numbers)
    println("El promedio (entero) total de la lista $numbers es $prom")

    //Ejercicio 2
    println(" ")
    val enteros = listOf(4, 6, 10, 33, 7, 5)
    val impares = enteros.filter { it % 2 != 0 }
    println("Los números impares de la lista $enteros son: $impares")

    //Ejercicio 3
    println(" ")
    val texto = "Abuelito"
    if (isPalindrome(texto)){
        println("la palabra <<$texto>> es un palíndromo")
    }else{
        println("la palabra <<$texto>> no es un palíndromo")
    }

    //Ejercicio 4
    println(" ")
    val nombres = listOf("Juan", "Fulanito", "Michelle")
    val saludos = nombres.map { "¡Hola, $it!" }
    println(saludos)

    //Ejercicio 5
    println(" ")
    val num1 = 6
    val num2 = 5

    val suma = performOperation(num1, num2) { a, b -> a + b }
    val resta = performOperation(num1, num2) { a, b -> a - b }
    val multiplicacion = performOperation(num1, num2) { a, b -> a * b }
    val division = performOperation(num1, num2) { a, b -> a / b }

    println("Los números electos son $num1 y $num2")
    println("La suma es: $suma")
    println("La resta es: $resta")
    println("La multiplicacion es: $multiplicacion")
    println("La division es: $division")

    //Ejercicio 6
    println(" ")
    val personas = listOf(
        Person("Juan", 15, "Hombre"),
        Person("Fulanito", 51, "Hombre"),
        Person("Michelle", 19, "Mujer")
    )

    val estudiantes = personas.map { personToStudent(it) }
    estudiantes.forEach {
        val pronoun = if (it.gender == "Hombre") "El" else "La"
        println("$pronoun estudiante ${it.name} tiene ${it.age}")
    }

}