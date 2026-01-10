package backend.settings.base

abstract class SingleSelectorSettingConfigBase: SettingConfigBase() {
    data class Option(val name: String, val icon: Any)

    abstract override val name: String
    abstract override val title: String
    abstract override val subtitle: String
    abstract override val icon: Any
    abstract override val def: Int
    override val type: SettingType = SettingType.SINGLE_SELECTOR

    abstract val options: List<Option>
    var valIndex: Int = def
        set(value) {
            if (value >= options.size) {
                throw IllegalArgumentException("Index out of bounds")
            }
            field = value
        }

    override var value: Any? = null
        get() = options[valIndex]
}