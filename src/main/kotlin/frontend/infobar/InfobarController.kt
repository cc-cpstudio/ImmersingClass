package frontend.infobar

import javafx.fxml.FXML
import javafx.scene.control.Button

class InfobarController {
    @FXML
    private lateinit var clickBtn: Button

    private var cnt = 0

    @FXML
    private fun update() {
        cnt ++
        clickBtn.style = when (cnt%4) {
            0 -> "-fx-background-color: #4CAF50; -fx-text-fill: white; -fx-padding: 8px 16px;"
            1 -> "-fx-background-color: #2196F3; -fx-text-fill: white; -fx-padding: 8px 16px;"
            2 -> "-fx-background-color: #FF9800; -fx-text-fill: white; -fx-padding: 8px 16px;"
            else -> "-fx-background-color: #F44336; -fx-text-fill: white; -fx-padding: 8px 16px;"
        }
    }
}