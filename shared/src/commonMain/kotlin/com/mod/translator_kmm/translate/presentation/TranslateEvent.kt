package com.mod.translator_kmm.translate.presentation

import com.mod.translator_kmm.core.presentation.UiLanguage

sealed class TranslateEvent {
    data class ChooseFromLanguage(val language: UiLanguage): TranslateEvent()
    data class ChooseToLanguage(val language: UiLanguage): TranslateEvent()
    object StopChoosingLanguage: TranslateEvent()
    object SwipeLanguages: TranslateEvent()
    data class ChangeTranslatingText(val text: String): TranslateEvent()
    object Translate: TranslateEvent()
    object OpenFromLanguageDropDown: TranslateEvent()
    object OpenToLanguageDropDown: TranslateEvent()
    object CloseTranslation: TranslateEvent()
    data class SelectHistoryItem(val item: UiHistoryItem): TranslateEvent()
    object EditTranslation: TranslateEvent()
    object RecordAudio: TranslateEvent()
    data class SubmitVoiceResult(val result: String?): TranslateEvent()
    object OnErrorSeen: TranslateEvent()
}
