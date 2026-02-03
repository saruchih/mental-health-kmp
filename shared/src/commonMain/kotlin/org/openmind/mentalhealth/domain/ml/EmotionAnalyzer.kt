package org.openmind.mentalhealth.domain.ml

import org.openmind.mentalhealth.domain.model.Mood

interface EmotionAnalyzer {
    suspend fun analyze(text: String): Mood
}