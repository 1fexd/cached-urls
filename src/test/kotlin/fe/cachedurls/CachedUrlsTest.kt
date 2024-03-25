package fe.cachedurls

import CachedUrlsResource
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class CachedUrlsTest {
    @Test
    fun test() {
        val jsonObject = CachedUrlsLoader.loadCachedUrlsJson(CachedUrlsResource.getBuiltInResolvedUrlsJson()!!)!!
        val map = getResolvedUrlMap(jsonObject)

        assertEquals("https://grapheneos.org/releases#2023022300", map["https://t.co/coInA0UU8T"])
    }
}
