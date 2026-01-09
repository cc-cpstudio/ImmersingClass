package backend.settings.base

abstract class SettingConfigBase {
    abstract val name: String
    abstract val type: SettingType
    abstract val value: Any?
}