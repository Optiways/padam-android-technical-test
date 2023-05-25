package io.padam_exercise.padamdaily.screens

import com.google.android.gms.maps.model.LatLng
import io.padam_exercise.padamdaily.models.MarkerType
import io.padam_exercise.padamdaily.models.Suggestion

/**
 * Map interface
 * Implement this in your page where there is a map to use map methods
 */
interface MapActionsDelegate {

    fun updateMap(vararg latLngArgs: LatLng?)

    fun updateMarker(markerType: MarkerType, suggestion: Suggestion)

    fun clearMap()

}
