package com.madchan.appdeveloperoption

import android.app.AlertDialog
import android.app.Dialog
import android.content.DialogInterface
import android.os.Bundle
import android.widget.EditText
import androidx.fragment.app.DialogFragment

/**
 * 调试模式登录验证弹框
 */
class DebugLoginDialogFragment : DialogFragment() {

    companion object {
        fun newInstance() = DebugLoginDialogFragment()
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return activity?.let {
            isCancelable = false    // 需要对fragment同样设置cancelable

            val builder = AlertDialog.Builder(it, android.R.style.Theme_Material_Light_Dialog)

            val view = requireActivity().layoutInflater.inflate(R.layout.dialog_debug_login, null)
            val username = view.findViewById<EditText>(R.id.username)
            val password = view.findViewById<EditText>(R.id.password)

            builder.setView(view)
                .setTitle("验证身份")
                .setPositiveButton("确定",
                    DialogInterface.OnClickListener { _, _ ->

                        // TODO 具体验证方式由接入方选择
                        if ("admin" == username.text.toString()
                            && "123456" == password.text.toString()
                        ) {
                            context?.let { it -> DebugActivity.startActivity(it) }
                            return@OnClickListener
                        }

                    })
                .setNegativeButton("取消", null)
                .setCancelable(false)
            builder.create()

        } ?: throw IllegalStateException("Activity cannot be null")
    }
}