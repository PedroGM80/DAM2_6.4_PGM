open class GestorDeLibrosIUT1 {

    fun cliPreguntarLibroIn(): String {
        println("Introduzca un ID: ")
        var idLibro = readln()
        return idLibro
    }

    fun cliRespuesta(exist: Boolean, idLibro: String) {
        if (exist)
            println("El libro $idLibro existe!")
        else
            println("El libro $idLibro NO existe!")
    }
}