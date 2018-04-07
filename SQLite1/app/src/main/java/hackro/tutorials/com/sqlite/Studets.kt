package hackro.tutorials.com.sqlite


/**
 * @param id  Id del usuario, este id es unico y autoincrementable
 * @param name  Nombre del usuario
 * @param lastName  Apellido del usuario
 * @param age  Edad del usuario
 * @param genre Genero : F/M
 */
open class Studets(id: Int,name : String,lastName : String,age: Int = 0,genre: String)