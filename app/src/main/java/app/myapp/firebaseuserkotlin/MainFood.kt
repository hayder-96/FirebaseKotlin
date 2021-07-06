package app.myapp.firebaseuserkotlin

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class MainFood : AppCompatActivity() {

   lateinit var r:RecyclerView
    lateinit var list:ArrayList<foodMain>

    lateinit var con:Context
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_food)

        r=findViewById(R.id.rec)



        con=this

        list =ArrayList()

       var database = FirebaseDatabase.getInstance().getReference("food")

        database.addValueEventListener(object : ValueEventListener {
            override fun onCancelled(error: DatabaseError) {

            }

            override fun onDataChange(snapshot: DataSnapshot) {



                if (snapshot!!.exists()){

                    list.clear()
                    for (f in snapshot.children){

                        var fm=f.getValue(foodMain::class.java)



                        list.add(fm!!)


                    }


                    var a=AdapterFood(list,con)
                    r.adapter=a
                    r.layoutManager= LinearLayoutManager(con)
                    r.setHasFixedSize(true)
                }
            }

        })









    }
}