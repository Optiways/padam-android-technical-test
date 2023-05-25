package io.padam_exercise.padamdaily.screens

import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import io.padam_exercise.padamdaily.models.MarkerType
import io.padam_exercise.padamdaily.models.mocking.MockSuggestion
import io.padam_exercise.padamdaily.models.Suggestion
import io.padam_exercise.padamdaily.utils.Toolbox
import kotlinx.android.synthetic.main.activity_search_itinerary.*
import padam_exercise.padamdaily.R

class SearchItineraryActivity : AppCompatActivity() {

    private var mMapDelegate: MapActionsDelegate? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search_itinerary)

        initMapFragment()
        initView()
    }

    private fun initMapFragment() {
        val mapFragment: MapFragment = MapFragment.newInstance()

        supportFragmentManager.beginTransaction()
            .replace(R.id.cl_map, mapFragment)
            .commitAllowingStateLoss()

        mMapDelegate = mapFragment
    }

    private fun initView() {
        initSpinners()
        manageOnClickSearchItinerary()
    }

    private fun initSpinners() {
        initDepartureSpinner()
        initArrivalSpinner()
    }

    private fun initDepartureSpinner() {
        val departuresList = Toolbox.getStringListFromSuggestion(MockSuggestion.departures())
        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, departuresList)
        spinner_departure.adapter = adapter
    }

    private fun initArrivalSpinner() {
        // TODO: Implement data
    }

    private fun manageOnClickSearchItinerary() {
        btn_search_itinerary.setOnClickListener {
            mMapDelegate?.clearMap()

            val selectedDeparture: String = spinner_departure.selectedItem.toString()
            val suggestion = getSuggestionFromSelection(selectedDeparture, MockSuggestion.departures())

            mMapDelegate?.updateMarker(MarkerType.DEPARTURE, suggestion)
            mMapDelegate?.updateMap(suggestion.latLng)
        }
    }

    private fun getSuggestionFromSelection(selection: String, suggestionList: ArrayList<Suggestion>): Suggestion {
        for (suggestion in suggestionList) {
            if (suggestion.name == selection) {
                return suggestion
            }
        }
        return suggestionList.first()
    }
}