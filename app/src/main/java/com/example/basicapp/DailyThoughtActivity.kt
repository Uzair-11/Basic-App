package com.example.basicapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.basicapp.databinding.ActivityDailyThoughtBinding
import okhttp3.*
import org.json.JSONArray
import java.io.IOException

class DailyThoughtActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDailyThoughtBinding
    private val client = OkHttpClient()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDailyThoughtBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Start with the TextView invisible for animation
        binding.tvThought.alpha = 0f

        fetchThought()
    }

    private fun fetchThought() {
        val request = Request.Builder()
            .url("https://zenquotes.io/api/random")
            .build()

        client.newCall(request).enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {
                runOnUiThread {
                    binding.tvThought.text = "Failed to fetch thought: ${e.message}"
                    binding.tvThought.alpha = 1f // Make sure it’s visible on error
                }
            }

            override fun onResponse(call: Call, response: Response) {
                response.body?.let { body ->
                    val json = JSONArray(body.string())
                    val quote = json.getJSONObject(0).getString("q")
                    val author = json.getJSONObject(0).getString("a")

                    runOnUiThread {
                        binding.tvThought.text = "\"$quote\"\n- $author"

                        // Fade-in animation
                        binding.tvThought.animate()
                            .alpha(1f)
                            .setDuration(1000)
                            .start()
                    }
                }
            }
        })
    }
}
