package com.example.sampletest.activities.basketballCourt

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import io.github.sceneview.Scene
import io.github.sceneview.math.Position
import io.github.sceneview.node.ModelNode
import io.github.sceneview.rememberCameraManipulator
import io.github.sceneview.rememberCameraNode
import io.github.sceneview.rememberEngine
import io.github.sceneview.rememberModelLoader
import io.github.sceneview.rememberNodes

@Composable
fun BaskeballScene() {
    val engine = rememberEngine()
    val modelLoader = rememberModelLoader(engine)

    //Load basket ball
    val basketBall = remember {
        ModelNode(
            modelInstance = modelLoader.createModelInstance("models/basketball.glb"),
            scaleToUnits = 0.3f
        ).apply {
            transform(Position(x = -0.5f, y = 0f, z = 0f))
        }
    }
    // Load court
    val court = remember {
        ModelNode(
            modelInstance = modelLoader.createModelInstance("models/basketball_court.glb"),
            scaleToUnits = 2.0f
        ).apply {
            transform(Position(x = 0f, y = 0f, z = 0f))
        }
    }
    // Setup camera
    val cameraNode = rememberCameraNode(engine) {
        position = Position(x=0f, y = 2f, z = 6f)
        lookAt(Position(x=0f, y = 0f, z = 0f))
    }

    Box(modifier = Modifier.fillMaxSize()) {
        Scene (
            engine = engine,
            modelLoader = modelLoader,
            cameraNode = cameraNode,
            cameraManipulator = rememberCameraManipulator(),
            childNodes = rememberNodes {
                add(court)
                add(basketBall)
            }
        )
    }
}