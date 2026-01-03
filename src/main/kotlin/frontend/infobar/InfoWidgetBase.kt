package frontend.infobar

abstract class InfoWidgetBase {
    abstract var position: Int // 组件位置
    abstract val type: String  // 组件类型

    abstract fun toXml()       // 转为 XML 格式
    abstract fun self()        // 整理类属性并转换为 JavaFX 所支持的组件
}