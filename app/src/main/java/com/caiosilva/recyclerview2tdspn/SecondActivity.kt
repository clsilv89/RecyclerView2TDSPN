package com.caiosilva.recyclerview2tdspn

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.activity.ComponentActivity
import com.caiosilva.recyclerview2tdspn.databinding.ActivitySecondBinding

class SecondActivity : ComponentActivity() {

    private lateinit var binding: ActivitySecondBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)

        getUrlFromIntent()
    }

    private fun getUrlFromIntent() {
        val url = intent.getStringExtra("EXTRA_POSTAGEM_URL").orEmpty()
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
        val intentSend = Intent(Intent.ACTION_SEND)
        intentSend.setType("image/*")
        intentSend.putExtra(Intent.EXTRA_TEXT, url)


        binding.textViewDescricao.text = url
        binding.textViewDescricao.setOnClickListener {
            startActivity(intent)
        }

        binding.textViewDescricao.setOnLongClickListener(object : View.OnLongClickListener {
            override fun onLongClick(v: View?): Boolean {
                startActivity(intentSend)

                return true
            }
        })

    }
}