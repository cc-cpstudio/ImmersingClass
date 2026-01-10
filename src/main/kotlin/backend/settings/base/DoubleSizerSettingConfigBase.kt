package backend.settings.base

abstract class DoubleSizerSettingConfigBase: SettingConfigBase() {

    abstract val top: Double
    abstract val bottom: Double
    abstract val step: Double
    abstract val allowInput: Boolean

    override var value: Any? = def
}