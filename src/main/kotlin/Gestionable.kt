interface Gestionable {


    abstract fun existeLibro(id:String):Boolean
    abstract fun infoLibro(id:String):Map<String,Any>
}