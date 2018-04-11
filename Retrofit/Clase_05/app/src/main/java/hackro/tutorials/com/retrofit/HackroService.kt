package hackro.tutorials.com.retrofit

import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT

/** Por practica, en Retrofit 2 los endpoint no deben comenzar con / **/
interface HackroService{

    /**
     * Métodos de petición HTTP
     *  @GET        Utilizado mas comunmente para recuperar/leer
     *  @POST       Ocupado comunmente en formularios
     *  @DELETE     Simplemente elimina un resource identificado en la URI
     *  @PUT        Utilizado normalmente para actualizar contenidos
     *
     * Mas informacion: https://stackoverflow.com/a/47831350/3741698
     **/

    /**
     * Recuerda que entre los paréntesis indicamos el endpoint que complementa a la url base
     *  URL_BASE +  BuildConfig.ENDPOINT_USER
     * **/


    @GET(BuildConfig.ENDPOINT_USER) fun getUser() : List<String>


    @POST(BuildConfig.ENDPOINT_USER) fun postUser() : String


    @PUT(BuildConfig.ENDPOINT_USER) fun putUser() : Int


    @DELETE(BuildConfig.ENDPOINT_USER) fun deleteUser() : Int








}