package com.lib.share_lib.data

/**
 * @author yudenghao
 * @date 2020/10/20
 */
enum class ProgramType(var type: Int) {
    RELEASE(0),
    TEST(1),
    PREVIEW(2);

    fun getProgramType(): Int {
        return type
    }
}