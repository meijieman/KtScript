package com.baidu.ktscript

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.alibaba.fastjson.JSON
import com.alibaba.fastjson.JSONObject
import com.baidu.common.LogUtil
import com.baidu.common.logW
import com.baidu.ktscript.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding: ActivityMainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button.setOnClickListener {
            val time = Calendar.getInstance().time.toString()
            binding.tvMain.text = time

            Snackbar.make(it, time, Snackbar.LENGTH_SHORT).show()

            ConfigManager.INSTANCE.init(this, "/sdcard/debug/config.json")
            val config = ConfigManager.INSTANCE.asrConfig
            println("配置是 $config")

            LogUtil.i("")

            "".logW()

        }
    }
}