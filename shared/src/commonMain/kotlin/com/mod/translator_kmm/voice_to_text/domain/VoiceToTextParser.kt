package com.mod.translator_kmm.voice_to_text.domain

import com.mod.translator_kmm.core.domain.util.CommonStateFlow

interface VoiceToTextParser {
    val state: CommonStateFlow<VoiceToTextParserState>

    fun startListening(langCode: String)
    fun stopListening()
    fun cancel()
    fun reset()
}