package com.example.examenandroidizder.ui.genericDialog

import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import com.example.examenandroidizder.databinding.DialogGenericBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment


class DialogGenericParm(var title: String, var body: String, var enum: EnumDialog) :
    BottomSheetDialogFragment() {

    private lateinit var binding: DialogGenericBinding
    lateinit var TipeEnum: EnumDialog
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        binding = DialogGenericBinding.inflate(LayoutInflater.from(context))

        val builder = androidx.appcompat.app.AlertDialog.Builder(requireActivity())
        builder.setView(binding.root)

        iniComponent()

        val dialog = builder.create()
        dialog.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

        return dialog
    }

    private fun iniComponent() {
        binding.txtTitle.text = title
        binding.txtBody.text = body

        binding.ccTrip.setCardBackgroundColor(Color.parseColor("#FFFFFF"))

//        binding.btnAcept.setOnClickListener {
//            if (EnumDialog.PERMISSIONPHOTO.equals(enum)) {
//                dismiss()
//            } else if (EnumDialog.QRMODE.equals(enum)) {
//                activity?.finish()
//            } else if (EnumDialog.DEFAULT.equals(enum)) {
//                activity?.finish()
//            }
//        }

    }


}
