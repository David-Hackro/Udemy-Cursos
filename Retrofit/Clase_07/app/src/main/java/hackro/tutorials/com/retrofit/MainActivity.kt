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
         * Clase 07 - Respuesta HTTP sin procesar
         */


        var responseSync  : Call<ResponseBody> = service.postNickNames()

        Log.e("Response Service Sync: ",responseSync.execute().body().toString())



        var responseAsync  : Call<ResponseBody> = service.postNickNames()

        responseAsync.enqueue(object : Callback<ResponseBody>{
            override fun onFailure(call: Call<ResponseBody>?, t: Throwable?) {
                Log.e("Error: ", t?.message)
            }

            override fun onResponse(call: Call<ResponseBody>?, response: Response<ResponseBody>?) {
                Log.e("Response Service Asyn: ",responseAsync.toString())
            }

        })






    }
}
