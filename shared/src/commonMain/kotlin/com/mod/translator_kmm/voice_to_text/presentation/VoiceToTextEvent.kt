package com.mod.translator_kmm.voice_to_text.presentation

sealed class VoiceToTextEvent {
    object Close: VoiceToTextEvent()
    data class PermissionResult(
        val isGranted: Boolean,
        val isPermanentlyDeclined: Boolean
    ): VoiceToTextEvent()
    data class ToggleRecording(val langCode: String): VoiceToTextEvent()
    object Reset: VoiceToTextEvent()
}
