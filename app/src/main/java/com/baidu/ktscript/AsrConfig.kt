package com.baidu.ktscript

/**
 * TODO
 *
 * @author meijie05
 * @since 2021/6/6 9:06 上午
 */
data class AsrConfig(
    var version: String,
    var asr_url: String,
    var dcs_curl: String,
    var offline_event_url: String,
    var asr_pid: Int,
    var asr_appkey: String,
    var cantonese_asr_pid: Int,
    var cantonese_asr_appkey: String
)
