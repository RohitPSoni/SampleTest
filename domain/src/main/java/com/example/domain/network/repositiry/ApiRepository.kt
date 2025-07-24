package com.example.domain.network.repositiry

import android.content.Context
import androidx.annotation.RawRes
import com.example.domain.R
import com.example.domain.network.data.AllInfo
import com.example.domain.network.data.Data
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

interface ApiRepository {
    suspend fun loadAllData(): Data
}

class ApiRepositoryImpl @Inject constructor(
    @ApplicationContext private val context: Context,
    private val gson: Gson
) : ApiRepository {
    override suspend fun loadAllData(): Data {
        return withContext(Dispatchers.IO) {
            readRawJson<AllInfo>(R.raw.players).data
        }
    }


    private inline fun <reified T> readRawJson(@RawRes rawResId: Int): T {
        context.resources.openRawResource(rawResId).bufferedReader().use {
            return gson.fromJson(it, object : TypeToken<T>() {}.type)
        }
    }
}