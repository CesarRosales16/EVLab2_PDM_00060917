package com.example.corto2_00060917

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.Toast

//var  listaImg : ArrayList<ImageView> = ArrayList<ImageView>

class MainActivity : AppCompatActivity(), FakeBarFragment.OnSelectOption{
    override fun onAction(id: Int) {

        var content = when (id) {
            1 -> {
                Toast.makeText(this,"click en prev",Toast.LENGTH_LONG).show()
            }
            2 -> {
                Toast.makeText(this,"click en next",Toast.LENGTH_LONG).show()
            }
            else -> {
                "Fuck!"
            }
        }
        /*supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_content, ImageFragment.newInstance(content))
            //.addToBackStack("Co")
            .commit()*/
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var barFragment = FakeBarFragment.newInstace(
            "Previous",
            "Forward"
        )

        if (savedInstanceState == null) {
            supportFragmentManager
                .beginTransaction()
                .add(R.id.static_fragment, barFragment)
                .commit()
        }
    }

    fun initList() {

    }
    fun manageList() {

    }
}
