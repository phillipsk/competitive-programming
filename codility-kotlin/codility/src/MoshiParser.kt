import com.squareup.moshi.Json
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.JsonClass
import com.squareup.moshi.Moshi

var moviesJson =  "{\n" +
        "  \"vote_count\": 2026,\n" +
        "  \"id\": 19404,\n" +
        "  \"title\": \"Example Movie\",\n" +
        "  \"image_path\": \"/example-movie-image.jpg\",\n" +
        "  \"overview\": \"Overview of example movie\"\n" +
        "}"
@JsonClass(generateAdapter = true)
data class Movie (
        @Json(name = "vote_count") val voteCount: Int = -1,
        val id: Int,
        val title: String,
        @Json(name = "image_path") val imagePath: String,
        val overview: String
)

fun main() {
    val moshi: Moshi = Moshi.Builder().build()
    val adapter: JsonAdapter<Movie> = moshi.adapter(Movie::class.java)
    val movie = adapter.fromJson(moviesJson)
    print(movie)
}