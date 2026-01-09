package frontend.widgets

import javafx.scene.Node

import org.dom4j.Element
import org.dom4j.DocumentHelper

abstract class InfobarWidgetBase {
    abstract var position: Int
    abstract val version: Int
    abstract val name: String

    val type: String = this.javaClass.simpleName

    abstract var opaqueness: Int?
    abstract var width: Int?
    abstract var fontSize: Int?
    abstract var fontColor: String?

    var alignment: Alignment = Alignment.STRETCH
    var marginLeft: Int = 0
    var marginRight: Int = 0

    abstract fun specialOverheadInfoXML(): Element // 将组件设置转为 XML 格式配置文件，以便进行后续持久化操作
    abstract fun self(): Node // 将组件转为 FXML 格式对象，以便在主界面上显示

    fun baseOverheadInfoXML(): Element {
        val baseElem: Element = DocumentHelper.createElement("baseOverheadInfo")

        val opaquenessElem: Element = DocumentHelper.createElement("opaqueness")
        opaquenessElem.text = opaqueness?.toString() ?: "0" // 默认值

        val widthElem: Element = DocumentHelper.createElement("width")
        widthElem.text = width?.toString() ?: "0" // 依旧默认值，以下皆是

        val fontSizeElem: Element = DocumentHelper.createElement("fontSize")
        fontSizeElem.text = fontSize?.toString() ?: "0"

        val fontColorElem: Element = DocumentHelper.createElement("fontColor")
        fontColorElem.text = fontColor ?: "..."

        val alignmentElem: Element = DocumentHelper.createElement("alignment")
        alignmentElem.text = alignment.toString()

        val marginLeftElem: Element = DocumentHelper.createElement("marginLeft")
        marginLeftElem.text = marginLeft.toString()

        val marginRightElem: Element = DocumentHelper.createElement("marginRight")
        marginRightElem.text = marginRight.toString()

        baseElem.add(opaquenessElem)
        baseElem.add(widthElem)
        baseElem.add(fontSizeElem)
        baseElem.add(fontColorElem)
        baseElem.add(alignmentElem)
        baseElem.add(marginLeftElem)
        baseElem.add(marginRightElem)

        return baseElem
    }

    fun toXML(): Element {
        val widgetElem = DocumentHelper.createElement("widget")
        widgetElem.name = name

        val positionElem = DocumentHelper.createElement("position")
        positionElem.text = position.toString()

        val versionElem = DocumentHelper.createElement("version")
        versionElem.text = version.toString()

        val extendsElem = DocumentHelper.createElement("extends")
        extendsElem.text = type

        val baseOverheadInfoElem = baseOverheadInfoXML()
        val specialOverheadInfoElem = specialOverheadInfoXML()

        widgetElem.add(positionElem)
        widgetElem.add(versionElem)
        widgetElem.add(extendsElem)
        widgetElem.add(baseOverheadInfoElem)
        widgetElem.add(specialOverheadInfoElem)

        return widgetElem
    }
}