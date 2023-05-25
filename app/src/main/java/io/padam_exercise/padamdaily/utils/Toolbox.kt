package io.padam_exercise.padamdaily.utils

import io.padam_exercise.padamdaily.models.Suggestion

class Toolbox {
    companion object {
        fun getStringListFromSuggestion(suggestionList: ArrayList<Suggestion>): ArrayList<String> {
            val stringList = arrayListOf<String>()
            suggestionList.forEach {
                stringList.add(it.name)
            }
            return stringList
        }
    }
}