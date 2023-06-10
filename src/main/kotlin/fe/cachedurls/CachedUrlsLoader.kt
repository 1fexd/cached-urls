package fe.cachedurls

import com.google.gson.JsonObject
import fe.gson.extensions.parseReaderAs
import java.io.InputStream

object CachedUrlsLoader {
    fun loadCachedUrlsJson(inputStream: InputStream) = inputStream.use { parseReaderAs<JsonObject>(it.reader()) }
}
