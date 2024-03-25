package fe.cachedurls

import com.google.gson.JsonObject
import fe.gson.extension.io.parseJsonOrNull
import java.io.InputStream

object CachedUrlsLoader {
    fun loadCachedUrlsJson(inputStream: InputStream) = inputStream.use { it.parseJsonOrNull<JsonObject>() }
}
