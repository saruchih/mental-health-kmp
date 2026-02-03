package org.openmind.mentalhealth.domain.ml

import org.openmind.mentalhealth.domain.model.Mood


/**
 * Temporary, offline-first implementation.
 * Will be replaced by real ML (TFLite / ONNX).
 */
class StubEmotionAnalyzer : EmotionAnalyzer {

    override suspend fun analyze(text: String): Mood {
        // Very naive heuristic for now
        return when {
            text.contains("happy", ignoreCase = true) -> Mood.HAPPY
            text.contains("sad", ignoreCase = true) -> Mood.SAD
            text.contains("stress", ignoreCase = true) -> Mood.STRESSED
            else -> Mood.NEUTRAL
        }
    }
}