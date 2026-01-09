package backend.settings.base

abstract class SettingConfigBase {
    abstract val title: String
    abstract val subtitle: String
    abstract val icon: Any
    abstract val type: SettingType
    abstract val def: Any?
    abstract var value: Any?
}