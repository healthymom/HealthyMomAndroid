package kz.healthymom.data.room.model

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * created by: Makhanov Madiyar
 * on: 12.04.2021
 */
@Entity
data class Profile(
    @PrimaryKey(autoGenerate = true)
    val idLocal: Long? = null
)