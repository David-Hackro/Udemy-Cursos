package hackro.tutorials.com.retrofit

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
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
         * Clase 06 - Parametro URL(Ruta)
         */

        val id_user = "4499"// id ocupado como parametro

        val response = service.getUserPath(id_user)

        Log.e("Response Service: ",response)



    }
}
