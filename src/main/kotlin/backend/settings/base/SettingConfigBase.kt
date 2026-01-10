package backend.settings.base

import org.dom4j.DocumentHelper
import org.dom4j.Element

abstract class SettingConfigBase {
    abstract val name: String
    abstract val title: String
    abstract val subtitle: String
    abstract val icon: Any
    abstract val type: SettingType
    abstract val def: Any?
    abstract var value: Any?

    fun toXML(): Element {
        val baseElem = DocumentHelper.createElement(name)
        val valueElem = DocumentHelper.createElement("value")
        valueElem.text = value?.toString() ?: "null"
        baseElem.add(valueElem)
        return baseElem
    }
}