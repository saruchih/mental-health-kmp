package org.openmind.mentalhealth.ml

import org.openmind.mentalhealth.domain.model.Mood

interface EmotionAnalyzer {
    suspend fun analyze(text: String): Mood
}