package hackro.tutorials.com.retrofit

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val retrofit = Retrofit.Builder()
                .baseUrl(BuildConfig.BASE_URL)
                .build()

        val service = retrofit.create<HackroService>(HackroService::class.java)


        /**
         * Clase 08 - Anotacion @Body
         */

        /**
         * Pasamos como parametro el objeto que funcionara como body (BodyUser.class)
         */
        var responseSync  : Call<String> = service.postDataUser(BodyUser("Hackro","27"))

        Log.e("Response Service : ",responseSync.execute().body().toString())





    }
}
