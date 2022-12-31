package com.mod.translator_kmm.translate.data.translate

import com.mod.translator_kmm.NetworkConstants
import com.mod.translator_kmm.core.domain.language.Language
import com.mod.translator_kmm.translate.domain.translate.TranslateClient
import com.mod.translator_kmm.translate.domain.translate.TranslateError
import com.mod.translator_kmm.translate.domain.translate.TranslateException
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.request.*
import io.ktor.http.*
import io.ktor.utils.io.errors.*

class KtorTranslateClient(
    private val httpClient: HttpClient
): TranslateClient {
    override suspend fun translate(
        fromLanguage: Language,
        fromText: String,
        toLanguage: Language
    ): String {
        val result = try {
            httpClient.post {
                url(NetworkConstants.BASE_URL + "/translate")
                contentType(ContentType.Application.Json)
                setBody(
                    TranslateDto(
                        textToTranslate = fromText,
                        sourceLanguageCode = fromLanguage.langCode,
                        targetLanguageCode = toLanguage.langCode
                    )
                )
            }
        } catch (e: IOException) {
            throw TranslateException(error = TranslateError.SERVICE_UNAVAILABLE)
        }

        when (result.status.value) {
            in 200..299 -> Unit
            500 -> throw TranslateException(error = TranslateError.SERVER_ERROR)
            in 400..499 -> throw TranslateException(error = TranslateError.CLIENT_ERROR)
            else -> throw TranslateException(error = TranslateError.UNKNOWN_ERROR)
        }

        return try {
            result.body<TranslatedDto>().translatedText
        } catch (e: Exception) {
            throw TranslateException(error = TranslateError.SERVER_ERROR)
        }
    }

}