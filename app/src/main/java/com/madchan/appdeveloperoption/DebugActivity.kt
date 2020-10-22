package com.madchan.appdeveloperoption

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.preference.*

/**
 * 调试页面
 */
class DebugActivity : AppCompatActivity() {

    companion object {
        fun startActivity(context: Context) {
            context.startActivity(Intent(context, DebugActivity::class.java))
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_debug)
        if (savedInstanceState == null) {
            supportFragmentManager
                .beginTransaction()
                .replace(R.id.settings, DebugFragment())
                .commit()
        }
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    class DebugFragment : PreferenceFragmentCompat() {
        override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
            setPreferencesFromResource(R.xml.root_preferences, rootKey)
            initConfigControl()
        }

        private fun initConfigControl() {
            initLineConfigControl()
            initLogConfigControl()
            initBrowserConfigControl()
        }

        private fun initLineConfigControl() {
            findPreference<ListPreference>("app_status")?.setOnPreferenceChangeListener { _, newValue ->
                val newStatus = Integer.valueOf(newValue as String)
                // TODO 切换线路业务逻辑
                true
            }
        }

        private fun initLogConfigControl() {
            findPreference<SwitchPreference>("log_debuggable")?.setOnPreferenceChangeListener { _, newValue ->
                val isDebugMode = newValue as Boolean
                // TODO 开启日志调试业务逻辑
                true
            }


            findPreference<Preference>("logcat_page")?.setOnPreferenceClickListener {
                // TODO 进入日志调试页业务逻辑
                true
            }
        }

        private fun initBrowserConfigControl() {
            findPreference<EditTextPreference>("dummy_app_version")?.setOnPreferenceChangeListener { _, newValue ->
                // TODO 修改应用版本业务逻辑
                true
            }
        }
    }
}