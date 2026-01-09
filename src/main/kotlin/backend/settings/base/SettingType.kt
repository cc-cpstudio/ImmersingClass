package backend.settings.base

enum class SettingType {
    INT_SIZER,       // 整数调节框
    INT_SLIDER,      // 整数滑动条
    DOUBLE_SIZER,    // 小数调节框
    DOUBLE_SLIDER,   // 小数滑动条
    STRING_INPUT,    // 字符串输入框
    COLOR_INPUT,     // 颜色选择框
    SWITCH,          // 开关
    SINGLE_SELECTOR, // 单选框
    MULTI_SELECTOR,  // 多选框
    NORMAL_GROUP,    // 普通设置组
    SWITCH_GROUP,    // 开关设置组
    SELECTOR_GROUP,  // 单选设置组
}