package io.padam_exercise.padamdaily.models.mocking

import com.google.android.gms.maps.model.LatLng
import io.padam_exercise.padamdaily.models.Suggestion

class MockSuggestion {

    companion object {
        fun departures(): ArrayList<Suggestion> {
            val paris = Suggestion("Paris", LatLng(48.8588897, 2.320041))
            val orleans = Suggestion("Orléans", LatLng(47.9027336, 1.9086066))
            val lille = Suggestion("Lille", LatLng(50.6365654, 3.0635282))
            val strasbourg = Suggestion("Strasbourg", LatLng(48.584614, 7.7507127))

            return arrayListOf(paris, orleans, lille, strasbourg)
        }

        fun arrivals(): ArrayList<Suggestion> {
            val venezia = Suggestion("Venezia", LatLng(45.4371908, 12.3345898))
            val london = Suggestion("London", LatLng(51.5073219, -0.1276474))
            val surrey = Suggestion("Surrey", LatLng(51.2715316, -0.3414524))
            val hannover = Suggestion("Hannover", LatLng(52.3744779, 9.7385532))

            return arrayListOf(venezia, london, surrey, hannover)
        }
    }
}