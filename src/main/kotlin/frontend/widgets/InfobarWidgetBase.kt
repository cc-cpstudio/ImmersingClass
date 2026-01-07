package frontend.widgets

import javafx.scene.Node

import org.dom4j.Element
import org.dom4j.DocumentHelper

abstract class InfobarWidgetBase {
    abstract var position: Int
    abstract val name: String

    val type: String = this.javaClass.simpleName

    abstract var opaqueness: Int?
    abstract var width: Int?
    abstract var fontSize: Int?
    abstract var fontColor: String?

    var alignment: Alignment = Alignment.STRETCH
    var marginLeft: Int = 0
    var marginRight: Int = 0

    abstract fun toXML(): Element
    abstract fun self(): Node

    fun BaseOverheadInfoXML(): Element {
        val baseElem: Element = DocumentHelper.createElement("BaseOverheadInfo")

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
}