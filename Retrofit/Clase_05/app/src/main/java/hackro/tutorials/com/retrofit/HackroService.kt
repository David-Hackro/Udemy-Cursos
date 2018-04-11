package hackro.tutorials.com.retrofit

import retrofit2.http.*
/**Interface que tendra los metodos de consumo para el servicio de la aplicacion**/
interface HackroService{

    /**
     * La anotacion Query nos permite enviar parametros atraves de la url
     *      @Query("llave")      + [nombre de la variable]   + [Tipo de dato]
     *      @Query("id_user")    + [id]                      + [String]
     */


    /**
     * Podemos enviar de forma "hardcodeada" los valores
     */
    @GET(BuildConfig.ENDPOINT_USER+"?id_user=valor") fun getUser() : List<String>

    /**
     * Lo ideal es utilizar la anotacion Query
     * Ejemplo de la url:   /user?id_user=valor
     * **/
    @GET(BuildConfig.ENDPOINT_USER) fun getUser(@Query("id_user") id : String) : List<String>



    /**
    *Multiples parametros
     * Enviamos parametros por separado :
     *
     * id_user  = 6464
     * user     = hackro
     * name     = david
     *
     * Ejemplo de la URL; /user?id_user=6464&user=hackro&name=david
     **/
    @GET(BuildConfig.ENDPOINT_USER) fun getUser(@Query("id_user") id : String,
                                                @Query("user") user : String,
                                                @Query("name") name : String) : List<String>



    /**
     * Multiples parametros con el mismo nombre
     * Enviamos una lista con los valores :
     *
     * id_user  = 1
     * id_user  = 233
     * id_user  = 363
     *
     * Ejemplo de la URL; /user?id_user=1&id_user=233&id_user=363&.......
     **/
    @GET(BuildConfig.ENDPOINT_USER) fun getUser(@Query("id_user") list :List<String>) : List<String>





}