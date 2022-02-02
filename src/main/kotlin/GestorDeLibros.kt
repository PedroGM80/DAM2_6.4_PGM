import java.util.logging.Level
import java.util.logging.LogManager
import GestorDeLibrosIUT1 as GestorDeLibrosIUT11

internal val l = LogManager.getLogManager().getLogger("").apply { level = Level.ALL }
internal fun i(tag: String, msg: String) {
    l.info("[$tag] - $msg")
}

fun main() {
    var portatil = "Catalog.xml"
    //var casa = "/home/usuario/Documentos/workspace/IdeaProjects/IESRA-DAM/ejercicios/src/main/kotlin/un5/eje5_4/Catalog.xml"

    val gestorDeLibros = GestionLibros(portatil)
    gestorDeLibros.preguntarPorUnLibro()
    gestorDeLibros.mostrarInfoDeUnLibro()
}


class GestionLibros(var cargador: String) : Gestionable {
    var cat = CatalogoLibrosXML(cargador)

    fun preguntarPorUnLibro() {
        println("Introduzca un ID: ")
        var idLibro = readln()
        if (cat.existeLibro(idLibro))
            println("El libro $idLibro existe!")
        else
            println("El libro $idLibro NO existe!")
    }

    fun mostrarInfoDeUnLibro() {
        println("Introduzca un ID: ")
        var idLibro = readln()
        var infoLibro = cat.infoLibro(idLibro)
        if (!infoLibro.isEmpty())
            println("La información sobre es la siguiente\n$infoLibro")
        else
            println("No se encontró información sobre el libro")
    }


    override fun existeLibro(id: String): Boolean {
        if (cargador.contains(".xml")) {
            val aCatalogo = CatalogoLibrosXML(cargador)
            return aCatalogo.existeLibro(id)
        } else if (cargador.contains(".json")) {
            val aCatalogo = CatalogoLibrosJSON(cargador)
            return aCatalogo.existeLibro(id)
        }
        return false
    }

    override fun infoLibro(id: String): Map<String, Any> {
        if (cargador.contains(".xml")) {
            val aCatalogo = CatalogoLibrosXML(cargador)
            return aCatalogo.infoLibro(id)
        } else if (cargador.contains(".json")) {
            val aCatalogo = CatalogoLibrosJSON(cargador)
            return aCatalogo.infoLibro(id)
        }
        return  mutableMapOf<String, Any>()
    }

}