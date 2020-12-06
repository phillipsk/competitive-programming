import com.google.gson.*
import com.google.gson.stream.JsonReader
import org.joda.time.DateTime
import org.joda.time.LocalDate
import java.io.InputStream
import java.io.InputStreamReader
import java.io.Reader
import java.lang.reflect.Type
import kotlin.collections.ArrayList

class JsonParser {
        private val deserializer = PostDeserializer()
    private val gson = Gson().newBuilder()
            .registerTypeAdapter(YTSnippet::class.java, deserializer)
            .setPrettyPrinting()
            .create()

    class PostDeserializer : JsonDeserializer<YTSnippet> {
        override fun deserialize(json: JsonElement?, typeOfT: Type?,
                                 context: JsonDeserializationContext?): YTSnippet {
            json as JsonObject

            val dt = DateTime(json.get("publishedAt").asString).toLocalDate()
            val channelId = json.get("channelId").toString()
            val title = json.get("title").toString()
            val description = json.get("description").toString()
//            val address = if (addressJson.isJsonObject) addressJson.asJsonObject.toString() else addressJson.asString

            return YTSnippet(publishedAt = dt,channelId = channelId,title = title,description = description)
        }

    }

    fun parse(jsonInputStream: InputStream): List<PostEntity> {
        val r: ArrayList<PostEntity> = ArrayList()
        val reader: Reader = InputStreamReader(jsonInputStream)
        val jsonReader: JsonReader? = gson.newJsonReader(reader)
        var entity = gson.fromJson<PostEntity>(jsonReader, PostEntity::class.java)
        r.add(entity)
        return r
    }

    data class PostEntity(
//            @SerializedName("kind")
            var snippet: YTSnippet // = null,
    )

    data class YTSnippet(
            var publishedAt: LocalDate? = null,
            var channelId: String? = null,
            var title: String? = null,
            var description: String? = null
    )
}


fun main() {
//    val jsonString = "{'items': [{'kind': 'youtube#searchResult', 'etag': '6Vr-uUUYKwL_ahPZlaA7yplchWY', 'id': {'kind': 'youtube#video', 'videoId': 'nPmdkKu8VPs'}, 'snippet': {'publishedAt': '2020-08-31T04:43:10Z', 'channelId': 'UC0clY7VjxRyRsfC6YWDlY6Q', 'title': '8/30/2020 Worship Service', 'description': '11:30 AM Worship Service.', 'thumbnails': {'default': {'url': 'https://i.ytimg.com/vi/nPmdkKu8VPs/default.jpg', 'width': 120, 'height': 90}, 'medium': {'url': 'https://i.ytimg.com/vi/nPmdkKu8VPs/mqdefault.jpg', 'width': 320, 'height': 180}, 'high': {'url': 'https://i.ytimg.com/vi/nPmdkKu8VPs/hqdefault.jpg', 'width': 480, 'height': 360}}, 'channelTitle': 'Mission Church', 'liveBroadcastContent': 'none', 'publishTime': '2020-08-31T04:43:10Z'}}, {'kind': 'youtube#searchResult', 'etag': 'Rd0Op3NFy23CMjfs671V97J_Rtc', 'id': {'kind': 'youtube#video', 'videoId': '902ptouzJ-s'}, 'snippet': {'publishedAt': '2020-08-31T02:38:25Z', 'channelId': 'UC0clY7VjxRyRsfC6YWDlY6Q', 'title': '8/30/2020 Worship Service', 'description': '11:30 AM Worship Service.', 'thumbnails': {'default': {'url': 'https://i.ytimg.com/vi/902ptouzJ-s/default.jpg', 'width': 120, 'height': 90}, 'medium': {'url': 'https://i.ytimg.com/vi/902ptouzJ-s/mqdefault.jpg', 'width': 320, 'height': 180}, 'high': {'url': 'https://i.ytimg.com/vi/902ptouzJ-s/hqdefault.jpg', 'width': 480, 'height': 360}}, 'channelTitle': 'Mission Church', 'liveBroadcastContent': 'none', 'publishTime': '2020-08-31T02:38:25Z'}}]}\n"
    val jsonString = "{'snippet': {'publishedAt': '2020-08-31T04:43:10Z', 'channelId': 'UC0clY7VjxRyRsfC6YWDlY6Q', 'title': '8/30/2020 Worship Service', 'description': '11:30 AM Worship Service.', 'thumbnails': {'default': {'url': 'https://i.ytimg.com/vi/nPmdkKu8VPs/default.jpg', 'width': 120, 'height': 90}, 'medium': {'url': 'https://i.ytimg.com/vi/nPmdkKu8VPs/mqdefault.jpg', 'width': 320, 'height': 180}, 'high': {'url': 'https://i.ytimg.com/vi/nPmdkKu8VPs/hqdefault.jpg', 'width': 480, 'height': 360}}, 'channelTitle': 'Mission Church', 'liveBroadcastContent': 'none', 'publishTime': '2020-08-31T04:43:10Z'}}\n"
    val jsonInputStream: InputStream = jsonString.byteInputStream()
    var a = JsonParser().parse(jsonInputStream)
    a.forEach { print(it) }
}