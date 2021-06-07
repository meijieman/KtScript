package com.baidu.ktscript

import android.content.Context
import com.baidu.ktscript.Util.isEmpty
import com.baidu.ktscript.Util.readFile
import org.json.JSONObject

/**
 * TODO
 *
 * @author meijie05
 * @since 2021/6/6 9:09 上午
 */
class ConfigManager private constructor() {

    lateinit var asrConfig: AsrConfig
    private lateinit var mContext: Context


    companion object {
        val INSTANCE = ConfigManager()
    }

    fun init(ctx: Context, path: String) {
        mContext = ctx.applicationContext

        var s = readFile(path)
        if (s.isEmpty()) {
            s = readAssets("config.json")
        }
        val generate = generate(s)
        requireNotNull(generate) {
            println("配置文件不能为空")
        }
        asrConfig = generate

    }

    private fun readAssets(path: String): String {
        val `is` = mContext.assets.open(path)
        return `is`.readFile()
    }

    private fun generate(json: String?): AsrConfig? {
        if (json.isEmpty()) {
            return null
        }
        val jo = JSONObject()
        val env = jo.optJSONObject(jo.getString("env_name"))
        if (env != null) {
            return AsrConfig(
                env.getString("version"),
                env.getString("asr_url"),
                env.getString("dcs_curl"),
                env.getString("offline_event_url"),
                env.getInt("asr_pid"),
                env.getString("asr_appkey"),
                env.getInt("cantonese_asr_pid"),
                env.getString("cantonese_asr_appkey")
            )
        }
        return null
    }
}