package com.app.arcoredemo

import android.os.Bundle
import android.widget.Toast
import androidx.annotation.RawRes
import androidx.appcompat.app.AppCompatActivity
import com.google.ar.sceneform.rendering.ModelRenderable
import com.google.ar.sceneform.ux.ArFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var arFragment: ArFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        arFragment = fragment as ArFragment

        /**
         * Touch listener to detect when a user touches the ArScene plane to place a model
         */
        arFragment.setOnTapArPlaneListener { hitResult, plane, motionEvent ->
        }
    }

    /**
     * Used to laod models from 'raw' with a callback when loading is complete
     */
    fun loadModel(@RawRes model: Int, callback: (ModelRenderable) -> Unit) {
        ModelRenderable
            .builder()
            .setSource(this, model)
            .build()
            .thenAcceptAsync { modelRenderable ->
                callback(modelRenderable)
            }
    }
}
