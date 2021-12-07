package com.timmitof.goalsapp.models

import java.io.Serializable

data class GoalsClass(
    val targetName: String,
    val reminderByWeek: String?,
    val reminderByHours: String?,
    val reminderByDay: String?,
) : Serializable
