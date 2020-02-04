
package com.enviopost
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.enviopost.Entities.Post
import com.enviopost.Remote.RetrofitClient
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        BTN_ENVIAR.setOnClickListener{

            val CLAVE = etClave.text.toString().trim()
            val FECHA = etFecha.text.toString().trim()
            val LECTOR = etLector.text.toString().trim()
            val FECHA_LECTURA = etFechaLectura.text.toString().trim()

            if(CLAVE.isEmpty()){
                etClave.error = getString(R.string.error1)
                etClave.requestFocus()
                return@setOnClickListener
            }


            if(FECHA.isEmpty()){
                etFecha.error = getString(R.string.error2)
                etFecha.requestFocus()
                return@setOnClickListener
            }

            if(LECTOR.isEmpty()){
                etLector.error = getString(R.string.error3)
                etLector.requestFocus()
                return@setOnClickListener
            }

            if(FECHA_LECTURA.isEmpty()){
                etFechaLectura.error = getString(R.string.error4)
                etFechaLectura.requestFocus()
                return@setOnClickListener
            }

            RetrofitClient.instance.savePost(CLAVE,FECHA,LECTOR,FECHA_LECTURA)
                .enqueue(object: Callback<Post>{
                    override fun onFailure(call: Call<Post>, t: Throwable) {

                        Toast.makeText(applicationContext, t.message, Toast.LENGTH_LONG).show()
                        Log.e("Error en ",t.message)


                    }

                    override fun onResponse(call: Call<Post>, response: Response<Post>) {

                        if (response.isSuccessful){

                            Toast.makeText(applicationContext, getString(R.string.data_sent) + response.code(),Toast.LENGTH_SHORT).show()
                            Log.i("TAG", "" + response.body().toString())


                        }
                    }
                })





        }


    }
}
