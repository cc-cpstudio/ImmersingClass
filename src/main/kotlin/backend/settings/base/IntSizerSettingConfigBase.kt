package backend.settings.base

abstract class IntSizerSettingConfigBase: SettingConfigBase() {
    abstract override val title: String
    abstract override val subtitle: String
    override val icon: Any = ""
    override val type: SettingType = SettingType.INT_SIZER
    abstract override val def: Int

    abstract val top: Int
    abstract val bottom: Int
    abstract val step: Int
    abstract val allowInput: Boolean
}