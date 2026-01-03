package frontend

import java.io.IOException

import javafx.application.Application
import javafx.fxml.FXMLLoader
import javafx.stage.Stage
import javafx.scene.Scene
import javafx.stage.StageStyle
import javafx.stage.Screen
import javafx.scene.layout.VBox

import mu.KLogging

import com.sun.jna.Platform

class App: Application() {
    companion object: KLogging()

    override fun start(icInfobar: Stage) {
        setupInfobar(icInfobar)
    }

    private fun setupInfobar(icInfobar: Stage) {
        try {
            icInfobar.initStyle(StageStyle.TRANSPARENT)
            icInfobar.isAlwaysOnTop = true

            val fxmlLoader = FXMLLoader(javaClass.getResource("/frontend/infobar/infobar.fxml"))
            val root = fxmlLoader.load<VBox>()

            val scene = Scene(root, 400.0, 300.0)
            scene.fill = null

            icInfobar.width = 100.0
            icInfobar.height = 50.0
            icInfobar.scene = scene
            icInfobar.isResizable = true
            setInfobarPosition(icInfobar)

            when {
                Platform.isWindows() -> { }
                Platform.isLinux() -> { }
                else -> { }
            }

            icInfobar.show()

        } catch (e: IOException) {
            logger.error("FXML 文件加载失败！")
            e.printStackTrace()
        }
    }

    private fun setInfobarPosition(stage: Stage) {
        val screenBounds = Screen.getPrimary().visualBounds
        stage.x = (screenBounds.width - stage.width) / 2
        stage.y = 10.0
    }
}