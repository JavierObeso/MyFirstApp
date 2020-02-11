package javier.obeso.myfirstapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    var mas = 100
    var menos = 0
    var num = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val etiqueta:TextView = findViewById(R.id.etiqueta)
        val up:Button = findViewById(R.id.up) as Button
        val down:Button = findViewById(R.id.down) as Button
        val generate:Button = findViewById(R.id.generate) as Button
        val correct:Button = findViewById(R.id.correct) as Button
        val restart:Button = findViewById(R.id.restart) as Button

        generate.setOnClickListener{
            num = Random.nextInt(0,100)
            etiqueta.setText(""+num+"")
            generate.setEnabled(false)
        }

        up.setOnClickListener{
            menos = num
            num = Random.nextInt(num,mas)
            etiqueta.setText(""+num+"")
        }

        down.setOnClickListener{
            mas = num
            num = Random.nextInt(menos,num)
            etiqueta.setText(""+num+"")
        }

        correct.setOnClickListener{
            etiqueta.setText("Tu número es el $num! Gracias por jugar!")
        }

        restart.setOnClickListener{
            generate.setEnabled(true)
            mas = 100
            menos = 0
            num = 0
            etiqueta.setText("Dale a generar!")
        }
    }
}
