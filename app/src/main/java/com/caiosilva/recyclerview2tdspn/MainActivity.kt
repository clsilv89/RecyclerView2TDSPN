package com.caiosilva.recyclerview2tdspn

import android.content.Intent
import android.os.Bundle
import android.provider.MediaStore
import androidx.activity.ComponentActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.caiosilva.recyclerview2tdspn.databinding.ActivityMainBinding

class MainActivity : ComponentActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupRecyclerView()
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 1001 && resultCode == RESULT_OK) {
            val imageUri = data?.data
            val bitmap = MediaStore.Images.Media.getBitmap(contentResolver, imageUri)

            binding.imageViewFromPicker.setImageBitmap(bitmap)
        }
    }

    private fun setupRecyclerView() {
        val adapter = PostagemAdapter()
        adapter.submitList(listaPostagem())
        adapter.onClick = {
//            openIntent(it)
            openGallery()
        }

        binding.recyclerView.adapter = adapter
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
    }

    private fun openIntent(postagem: Postagem) {
        val intent = Intent(this, SecondActivity().javaClass)
        intent.putExtra("EXTRA_POSTAGEM_URL", postagem.postagem)

        startActivity(intent)
    }

    private fun openGallery() {
        val intent = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.INTERNAL_CONTENT_URI)
        startActivityForResult(intent, 1001)
    }


    private fun listaPostagem(): List<Postagem> {
        return listOf(
            Postagem(
                "https://i.ytimg.com/vi/z01IkdZ66YE/hqdefault.jpg",
                "https://t.ctcdn.com.br/Ym9t_1dCfwc9uIknM54YCC4phg8=/i489927.jpeg",
                "caio",
                "Uma foto de um cachorro"
            ),
            Postagem(
                "https://i.ytimg.com/vi/z01IkdZ66YE/hqdefault.jpg",
                "https://t.ctcdn.com.br/Ym9t_1dCfwc9uIknM54YCC4phg8=/i489927.jpeg",
                "caio",
                "Uma foto de um cachorro"
            ),
            Postagem(
                "https://i.ytimg.com/vi/z01IkdZ66YE/hqdefault.jpg",
                "https://t.ctcdn.com.br/Ym9t_1dCfwc9uIknM54YCC4phg8=/i489927.jpeg",
                "caio",
                "Uma foto de um cachorro"
            ),
            Postagem(
                "https://i.ytimg.com/vi/z01IkdZ66YE/hqdefault.jpg",
                "https://t.ctcdn.com.br/Ym9t_1dCfwc9uIknM54YCC4phg8=/i489927.jpeg",
                "caio",
                "Uma foto de um cachorro"
            ),
            Postagem(
                "https://i.ytimg.com/vi/z01IkdZ66YE/hqdefault.jpg",
                "https://t.ctcdn.com.br/Ym9t_1dCfwc9uIknM54YCC4phg8=/i489927.jpeg",
                "caio",
                "Uma foto de um cachorro"
            ),
            Postagem(
                "https://i.ytimg.com/vi/z01IkdZ66YE/hqdefault.jpg",
                "https://t.ctcdn.com.br/Ym9t_1dCfwc9uIknM54YCC4phg8=/i489927.jpeg",
                "caio",
                "Uma foto de um cachorro"
            ),
            Postagem(
                "https://i.ytimg.com/vi/z01IkdZ66YE/hqdefault.jpg",
                "https://t.ctcdn.com.br/Ym9t_1dCfwc9uIknM54YCC4phg8=/i489927.jpeg",
                "caio",
                "Uma foto de um cachorro"
            ),
            Postagem(
                "https://i.ytimg.com/vi/z01IkdZ66YE/hqdefault.jpg",
                "https://t.ctcdn.com.br/Ym9t_1dCfwc9uIknM54YCC4phg8=/i489927.jpeg",
                "caio",
                "Uma foto de um cachorro"
            ),
            Postagem(
                "https://i.ytimg.com/vi/z01IkdZ66YE/hqdefault.jpg",
                "https://t.ctcdn.com.br/Ym9t_1dCfwc9uIknM54YCC4phg8=/i489927.jpeg",
                "caio",
                "Uma foto de um cachorro"
            ),
            Postagem(
                "https://i.ytimg.com/vi/z01IkdZ66YE/hqdefault.jpg",
                "https://t.ctcdn.com.br/Ym9t_1dCfwc9uIknM54YCC4phg8=/i489927.jpeg",
                "caio",
                "Uma foto de um cachorro"
            ),
        )
    }
}