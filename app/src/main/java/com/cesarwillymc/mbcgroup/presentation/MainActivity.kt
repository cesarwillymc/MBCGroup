package com.cesarwillymc.mbcgroup.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.cesarwillymc.mbcgroup.ui.navigation.graph.CustomNavGraph
import com.cesarwillymc.mbcgroup.ui.theme.MBCGroupTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MBCGroupTheme {
                val navController = rememberNavController()
                Box(modifier = Modifier.fillMaxSize()) {
                    CustomNavGraph(
                        navController = navController
                    )
                }
            }
        }
    }
}
