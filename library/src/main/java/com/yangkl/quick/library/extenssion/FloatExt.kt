package com.yangkl.quick.library.extenssion

import kotlin.math.roundToInt

/**
 * 保留小数点后 N 位
 *
 * @param num 要保留的小数点位数
 * @param roundOff true 表示进行四舍五入，false 表示直接截取
 */
fun Float.keepDecimalPlaces(num: Int, roundOff: Boolean = true): Float {
    var multiple = 1
    for (i in 1..num) {
        multiple *= 10
    }
    return if (roundOff) {
        (this * multiple).roundToInt().toFloat() / multiple
    } else {
        (this * multiple).toInt().toFloat() / multiple
    }
}