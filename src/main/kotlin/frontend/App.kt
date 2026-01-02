package frontend

import java.io.IOException

import javafx.application.Application
import javafx.fxml.FXMLLoader
import javafx.stage.Stage
import javafx.scene.Scene
import javafx.stage.StageStyle
import javafx.stage.Screen
import javafx.scene.layout.VBox

class App: Application() {
    override fun start(primaryStage: Stage) {
        try {
            primaryStage.initStyle(StageStyle.TRANSPARENT)
            primaryStage.isAlwaysOnTop = true

            val fxmlLoader = FXMLLoader(javaClass.getResource("/frontend/infobar/infobar.fxml"))
            val root = fxmlLoader.load<VBox>()

            val scene = Scene(root, 400.0, 300.0)
            scene.fill = null

            primaryStage.width = 200.0
            primaryStage.height = 150.0
            primaryStage.title = "FXML 界面编写示例"
            primaryStage.scene = scene
            primaryStage.isResizable = true
            setPosition(primaryStage)

            primaryStage.show()

        } catch (e: IOException) {
            e.printStackTrace()
            println("FXML 文件加载失败：${e.message}")
        }
    }

    private fun setPosition(stage: Stage) {
        val screenBounds = Screen.getPrimary().visualBounds
        stage.x = (screenBounds.width - stage.width) / 2
        stage.y = 10.0
    }
}