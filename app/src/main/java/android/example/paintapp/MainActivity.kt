package android.example.paintapp

import android.example.paintapp.PaintView.Companion.colorList
import android.example.paintapp.PaintView.Companion.currentBrush
import android.example.paintapp.PaintView.Companion.pathList
import android.example.paintapp.databinding.ActivityMainBinding
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Path
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    companion object {                     //for accessing globally to these two path and paintBrush
        var path = Path()
        var paintBrush = Paint()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.apply {
            redBtn.setOnClickListener {
                currentColor(Color.RED)
            }

            blackBtn.setOnClickListener {
                currentColor(Color.BLACK)
            }

            blueBtn.setOnClickListener {
                currentColor(Color.BLUE)
            }

            eraserBtn.setOnClickListener {
                pathList.clear()
                colorList.clear()
                path.reset()
            }
        }
    }

    private fun currentColor(color: Int) {
        paintBrush.color = color
        currentBrush = color
        path = Path()
    }

}