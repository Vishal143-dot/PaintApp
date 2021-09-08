package android.example.paintapp

import android.example.paintapp.PaintView.Companion.colorList
import android.example.paintapp.PaintView.Companion.currentBrush
import android.example.paintapp.PaintView.Companion.pathList
import android.graphics.Color

import android.graphics.Paint
import android.graphics.Path
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    companion object{                     //for accessing globally to these two path and paintBrush
        var path=Path()
        var paintBrush=Paint()
    }



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.hide()    //To remove the top bar written as paintApp

        val redBtn=findViewById<ImageButton>(R.id.redColor)
        val blackBtn=findViewById<ImageButton>(R.id.blackColor)
        val blueBtn=findViewById<ImageButton>(R.id.blueColor)
        val eraser=findViewById<ImageButton>(R.id.whiteColor)

       redBtn.setOnClickListener{
       Toast.makeText(this,"Clicked",Toast.LENGTH_SHORT).show()
           paintBrush.color = Color.RED
           currentColor(paintBrush.color)
       }
        blackBtn.setOnClickListener{
            Toast.makeText(this,"Clicked",Toast.LENGTH_SHORT).show()
            paintBrush.color = Color.BLACK
            currentColor(paintBrush.color)
        }
        blueBtn.setOnClickListener{
            Toast.makeText(this,"Clicked",Toast.LENGTH_SHORT).show()
            paintBrush.color = Color.BLUE
            currentColor(paintBrush.color)
        }
        eraser.setOnClickListener{
            Toast.makeText(this,"Clicked",Toast.LENGTH_SHORT).show()
            pathList.clear()
            colorList.clear()
                  path.reset()
        }
    }
    private fun currentColor(color: Int){
        currentBrush = color
        path=Path()
    }

}