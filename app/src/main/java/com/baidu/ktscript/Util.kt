package com.baidu.ktscript

import com.baidu.ktscript.Util.close
import java.io.*

/**
 * TODO
 *
 * @author meijie05
 * @since 2021/6/6 8:44 上午
 */

fun InputStream.readFile(): String {
    val baos = ByteArrayOutputStream()
    val buffer = ByteArray(1024)
    var len = read(buffer, 0, buffer.size)
    while (len != -1) {
        baos.write(buffer, 0, buffer.size)
        len = read(buffer, 0, buffer.size)
    }
    arrayListOf<Closeable>(this).close()

    return baos.toString()
}

// 如果扩展函数和类内部定义的成员函数重名，那么调用时执行的是类的函数。
//fun String?.isEmpty(): Boolean = this == null || this.isEmpty()


object Util {

    fun isEmpty(str: String?): Boolean = str == null || str.isEmpty()

    fun readFile(path: String): String {
        if (!File(path).exists()) {
            // 配置文件不存在
            return ""
        }
        val fis = FileInputStream(path)
        return fis.readFile()
    }

    fun ArrayList<Closeable>.close() {
        for (closeable in this) {
            closeable.close()
//            closeable = null
        }
    }
}
