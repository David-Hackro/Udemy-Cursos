package hackro.tutorials.com.retrofit

import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.http.*
import retrofit2.http.GET


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
    @GET(BuildConfig.ENDPOINT_USER+"?id_user=valor") fun getUser() : Call<List<String>>

    /**
     * Lo ideal es utilizar la anotacion Query
     * Ejemplo de la url:   /user?id_user=valor
     * **/
    @GET(BuildConfig.ENDPOINT_USER) fun getUser(@Query("id_user") id : String) : Call<List<String>>



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
                                                @Query("name") name : String) : Call<List<String>>



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
    @GET(BuildConfig.ENDPOINT_USER) fun getUser(@Query("id_user") list :List<String>) : Call<List<String>>


    /**
     * Parametro URL(Ruta)
     * Enviaremos el valor deseado concatenando el valor con ´{}´
     * Asignaremos un identificador {id_user}
     * Ejemplo de la URL: /user?63438
     **/
    @GET(BuildConfig.ENDPOINT_USER + "?{id_user}") fun getUserPath(@Path("id_user") taskId: String) : Call<String>


    /**
     * Respuesta HTTP sin procesar
     * De esta manera indicamos que retornaremos el response sin procesar
     */
    @POST(BuildConfig.ENDPOINT_USER) fun postNickNames() : Call<ResponseBody>




    /**
     * Anotacion Body
     * De esta manera podremos enviar un Body con multiples propiedades
     * Creamos una clase que sera el body (BodyUser.class)
     */

    @POST(BuildConfig.ENDPOINT_USER) fun postDataUser(@Body body: BodyUser ) : Call<String>


    /**
     * Anotacion Custom @Header
     *Con esta anotacion podremos enviar el Header de una manera custom, con elementos que quieras
     *
     */

    @Headers("User-Agent: Hackro")
    @GET(BuildConfig.ENDPOINT_USER)
    fun getUserRandom() : Call<String>

}