package frontend.widgets

import javafx.scene.Node
import org.dom4j.Element
import org.dom4j.DocumentHelper

class TextWidget: InfobarWidgetBase() {
    override var position: Int = -1
    override val name: String = "TextWidget"
    override var opaqueness: Int? = null
    override var width: Int? = null
    override var fontSize: Int? = null
    override var fontColor: String? = null

    override fun specialOverheadInfoXML(): Element {
        TODO("Not yet implemented")
    }
    override fun self(): Node {
        TODO("Not yet implemented")
    }
}