package com.mod.translator_kmm.translate.data.history

import com.mod.translator_kmm.translate.domain.history.HistoryItem
import database.HistoryEntity

fun HistoryEntity.toHistoryItem() = HistoryItem(
    id, fromLanguageCode, fromText, toLanguageCode, toText
)