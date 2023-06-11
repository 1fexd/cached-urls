import java.io.InputStream

object CachedUrlsResource {
    fun getBuiltInResolvedUrlsJson(
        name: String = "resolved_urls.json"
    ): InputStream? = CachedUrlsResource::class.java.getResourceAsStream(name)

    fun getBuiltInAmp2HtmlUrlsJson(
        name: String = "amp2html_urls.json"
    ): InputStream? = CachedUrlsResource::class.java.getResourceAsStream(name)
}
