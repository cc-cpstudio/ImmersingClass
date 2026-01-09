package frontend.widgets

import backend.settings.base.SettingConfigBase
import javafx.scene.Node

abstract class SettingWidgetBase {
    abstract val linked: SettingConfigBase

    abstract fun self(): Node
}