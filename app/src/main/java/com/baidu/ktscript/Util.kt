package com.baidu.ktscript

import java.io.ByteArrayOutputStream
import java.io.Closeable
import java.io.FileInputStream
import java.io.InputStream

/**
 * TODO
 *
 * @author meijie05
 * @since 2021/6/6 8:44 上午
 */
object Util {
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

    open fun readFile(path: String?): String {
        requireNotNull(path) { return "" }

        val fis = FileInputStream(path)
        return fis.readFile()
    }


    fun ArrayList<Closeable>.close() {
        for (closeable in this) {
            closeable.close()
//            closeable = null
        }
    }

    fun String?.isEmpty(): Boolean = this == null || this.isEmpty()

}
