package backend.settings.base

abstract class SwitchSettingConfigBase: SettingConfigBase() {
    abstract override val name: String
    abstract override val title: String
    abstract override val subtitle: String
    abstract override val icon: Any
    abstract override val def: Boolean
    override val type: SettingType = SettingType.SWITCH

    override var value: Any? = def
}