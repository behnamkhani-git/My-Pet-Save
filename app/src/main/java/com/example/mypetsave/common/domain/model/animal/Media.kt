package com.example.mypetsave.common.domain.model.animal

import androidx.annotation.VisibleForTesting

/*
The Media class and the Photo class have:
1- Highly cohesive logic
2- A simplified Null Object Pattern
 */
data class Media(
    val photos: List<Photo>,
    val videos: List<Video>
) {
    companion object {
        const val EMPTY_MEDIA = ""  // We use a companion object that represents an empty value to implement Null Object pattern
    }

    fun getFirstSmallestAvailablePhoto(): String {
        if (photos.isEmpty()) return EMPTY_MEDIA

        return photos.first().getSmallestAvailablePhoto()
    }

    data class Photo(
        val medium: String,     // A link for the medium-sized photo
        val full: String        // A link for the full-sized photo
    ) {

        companion object {
            const val EMPTY_PHOTO = ""   // We use a companion object that represents an empty value to implement Null Object pattern
        }

        /*
        We have some logic here.
        When we have a piece of logic related to a domain model object, it's a good practice to keep
        that logic contained within the object. This principle is known as encapsulation.
        Encapsulation means bundling data and behavior together within an object.
        This is a good example of High Cohesion.
         */
        fun getSmallestAvailablePhoto(): String {
            return when {
                isValidPhoto(medium) -> medium  // Check if the link of the medium image is valid
                isValidPhoto(full) -> full      // Check if the link of the full image is valid
                else -> EMPTY_PHOTO
            }
        }

        private fun isValidPhoto(photo: String): Boolean {
            return photo.isNotEmpty()   // It just checks if the link is not an empty string
        }
    }

    data class Video(val video: String)
}