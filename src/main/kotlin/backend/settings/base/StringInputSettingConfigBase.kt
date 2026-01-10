package backend.settings.base

abstract class StringInputSettingConfigBase: SettingConfigBase() {
    abstract override val name: String
    abstract override val title: String
    abstract override val subtitle: String
    abstract override val icon: Any
    override val type: SettingType = SettingType.STRING_INPUT
    abstract override val def: String

    abstract val tip: String

    override var value: Any? = def
}