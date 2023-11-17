package com.cesarwillymc.mbcgroup.util.extension

import java.text.SimpleDateFormat
import java.util.Date

/**
 * Created by Cesar Canaza on 11/16/23.
 * cesarwilly.mc@gmail.com
 *
 * IOWA, United States.
 */
fun formatDateWithSimpleDateFormat(date: Date): String {
    val pattern = "EEEE, MMMM d"
    val simpleDateFormat = SimpleDateFormat(pattern)
    return simpleDateFormat.format(date)
}
