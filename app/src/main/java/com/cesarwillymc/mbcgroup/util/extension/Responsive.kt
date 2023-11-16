package com.cesarwillymc.mbcgroup.util.extension

import android.content.res.Configuration
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.dp
import com.cesarwillymc.mbcgroup.util.constants.ONE_F
import com.cesarwillymc.mbcgroup.util.constants.TWO
import com.cesarwillymc.mbcgroup.util.constants.ZERO
import kotlin.math.pow
import kotlin.math.sqrt

/**
 * Created by cesarwillymamanicanaza on 17/03/22.
 * cesarwilly.mc@gmail.com
 *
 * Lima, Peru.
 */
@Composable
fun rememberResponsive(): Responsive {
    val configuration = LocalConfiguration.current
    return Responsive(configuration)
}

class Responsive constructor(private val configuration: Configuration) {
    private var width = ZERO
    private var height = ZERO
    private var inch = ZERO

    init {
        getDimension()
    }

    private fun getDimension() {
        width = configuration.screenWidthDp
        height = configuration.screenHeightDp
        inch = sqrt(
            width.toDouble().pow(TWO.toDouble()) + height.toDouble().pow(TWO.toDouble())
        ).toInt()
    }

    /** get size screen by size **/
    fun withR(percent: Float = ONE_F) = (width * percent).dp
    fun heightR(percent: Float = ONE_F) = (height * percent).dp
    fun inchR(percent: Float = ONE_F) = (inch * percent).dp
}
