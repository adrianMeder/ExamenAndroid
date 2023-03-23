package com.example.examenandroidizder.ui.genericDialog

import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import com.example.examenandroidizder.databinding.DialogGenericBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment


class DialogGenericModal(
    var title: String,
    var body: String,
    var enum: EnumDialog,
    var iModal: IDialogModalInterface,
) :
    BottomSheetDialogFragment() {

    private lateinit var binding: DialogGenericBinding

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

        eventBottom()


    }

    private fun eventBottom() {
        if (EnumDialog.MODALPHOTO.equals(enum)) {
            binding.btnTakePhoto.setOnClickListener {
                iModal.dialogTakePhoto()
            }
            binding.btnShowPhoto.setOnClickListener {
                iModal.dialogViewPhoto()
            }
        }
    }


}
