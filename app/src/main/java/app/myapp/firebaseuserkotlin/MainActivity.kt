package app.myapp.firebaseuserkotlin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

class MainActivity : AppCompatActivity() {



    lateinit var edit: EditText
    lateinit var editPassword: EditText
   var firebase =FirebaseAuth.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)





        edit = findViewById(R.id.edit_name)

        editPassword = findViewById(R.id.edit_password)




    }








    fun ok(view: View) {



        val f= firebase.currentUser
        f!!.sendEmailVerification().addOnCompleteListener {

            if (it.isSuccessful) {

                firebase.createUserWithEmailAndPassword(
                        edit.text.toString(),
                        editPassword.text.toString()

                )
                        .addOnCompleteListener(this) { task ->


                            if (task.isSuccessful) {


                            } else {
                                //text.text = task.exception?.message
                            }

                        }
            }
        }
    }





    fun login(view: View) {


//        firebase.signInWithEmailAndPassword(edit.text.toString(), editPassword.text.toString())
//
//                .addOnCompleteListener(this) { task ->
//
//                    if (task.isSuccessful) {
//
//                        val f = firebase.currentUser
//
//                        if (f!!.isEmailVerified) {
//
//                            var intent = Intent(baseContext, MainFood::class.java)
//
//                            startActivity(intent)
//                        } else {
//                            Toast.makeText(baseContext, "لم يتم التحقق", Toast.LENGTH_SHORT).show()
//                        }
//                    } else {
//                       // text.text = task.exception?.message
//                    }
//                }

        var intent = Intent(baseContext, MainFood::class.java)

        startActivity(intent)
    }
}