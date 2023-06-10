package fe.cachedurls

import com.google.gson.JsonObject

fun getResolvedUrlMap(jsonObject: JsonObject) = jsonObject.entrySet().associate {
    it.key to it.value.asJsonPrimitive.asString
}
