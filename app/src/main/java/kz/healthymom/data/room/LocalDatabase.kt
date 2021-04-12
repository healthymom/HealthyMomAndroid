package kz.healthymom.data.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import kz.healthymom.data.room.dao.ProfileDao
import kz.healthymom.data.room.model.Profile

/**
 * created by: Makhanov Madiyar
 * on: 12.04.2021
 */
@Database(
    entities = [
        Profile::class
    ],
    version = 1
)
@TypeConverters()
abstract class LocalDatabase : RoomDatabase() {
    abstract fun getProfileDao(): ProfileDao

    companion object {
        @Volatile
        private var instance: LocalDatabase? = null
        private val LOCK = Any()

        private const val DB_NAME_DEBUG = "healthymom_database.db"

        operator fun invoke(context: Context) = instance ?: synchronized(LOCK) {
            instance ?: buildDatabase(context).also { instance = it }
        }

        private fun buildDatabase(context: Context): LocalDatabase {

            return Room.databaseBuilder(
                context.applicationContext,
                LocalDatabase::class.java,
                DB_NAME_DEBUG
            ).fallbackToDestructiveMigration()
                .build()
        }
    }
}