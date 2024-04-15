package com.caiosilva.recyclerview2tdspn

import android.content.Intent
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.caiosilva.recyclerview2tdspn.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : ComponentActivity() {

    private lateinit var binding: ActivityMainBinding
    private val retrofit = RetrofitClient()
        .getRetrofit("https://jsonplaceholder.typicode.com/")
        .create(APIService::class.java)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        getPosts()
        getPhotos()
    }

    private fun getPosts() {
        val getPosts = retrofit.getPosts()

        getPosts.enqueue(object : Callback<List<Post>> {
            override fun onResponse(call: Call<List<Post>>, response: Response<List<Post>>) {
                println(response.body())
            }

            override fun onFailure(call: Call<List<Post>>, t: Throwable) {
                println(t.message)
            }
        })
    }

    private fun getPhotos() {
        val getPhotos = retrofit.getPhotos()

        getPhotos.enqueue(object : Callback<List<Photo>> {
            override fun onResponse(call: Call<List<Photo>>, response: Response<List<Photo>>) {
                setupRecyclerView(response.body().orEmpty())
            }

            override fun onFailure(p0: Call<List<Photo>>, p1: Throwable) {
                Toast.makeText(this@MainActivity, p1.message, Toast.LENGTH_SHORT).show()
            }
        })
    }

    private fun sendPost(photo: Photo) {
        val sendPostObject = SendPost(
            title = photo.title,
            body = photo.url,
            usedId = photo.id,
        )
        val sendPost = retrofit.sendPost(sendPostObject)

        sendPost.enqueue(object : Callback<Post> {
            override fun onResponse(call: Call<Post>, response: Response<Post>) {
                Toast.makeText(
                    this@MainActivity,
                    response.body()?.title,
                    Toast.LENGTH_SHORT
                ).show()
            }

            override fun onFailure(call: Call<Post>, t: Throwable) {
                Toast.makeText(
                    this@MainActivity,
                    t.message,
                    Toast.LENGTH_SHORT
                ).show()
            }
        })
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 1001 && resultCode == RESULT_OK) {
            val imageUri = data?.data
            val bitmap = MediaStore.Images.Media.getBitmap(contentResolver, imageUri)

            binding.imageViewFromPicker.setImageBitmap(bitmap)
        }
    }

    private fun setupRecyclerView(list: List<Photo>) {
        val adapter = PostagemAdapter()
        adapter.submitList(list)
        adapter.onClick = {
            sendPost(it)
//            openIntent(it)
//            openGallery()
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