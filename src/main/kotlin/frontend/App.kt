package frontend

import javafx.application.Application
import javafx.scene.Scene
import javafx.scene.control.Label
import javafx.scene.layout.StackPane
import javafx.stage.Stage

class App: Application() {
    override fun start(primaryStage: Stage) {
        // 1. 创建 UI 控件
        val helloLabel = Label("Hello Kotlin + JavaFX!")
        helloLabel.style = "-fx-font-size: 20px; -fx-text-fill: #2E86AB;"

        // 2. 创建布局容器（承载控件）
        val rootLayout = StackPane()
        rootLayout.children.add(helloLabel) // 将标签添加到布局中
        rootLayout.style = "-fx-background-color: #F2F2F2; -fx-alignment: center;"

        // 3. 创建场景（Scene 包含布局和控件）
        val scene = Scene(rootLayout, 400.0, 300.0) // 宽 400，高 300

        // 4. 配置主舞台（窗口）
        primaryStage.title = "Kotlin JavaFX 入门" // 窗口标题
        primaryStage.scene = scene // 绑定场景
        primaryStage.isResizable = true // 是否可调整大小
        primaryStage.show() // 显示窗口
    }
}