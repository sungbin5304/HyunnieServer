package com.sungbin.hyunnieserver.adapter

import android.app.Activity
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.NonNull
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.sungbin.hyunnieserver.R
import com.sungbin.hyunnieserver.databinding.LayoutFileBinding
import com.sungbin.hyunnieserver.model.FileItem
import com.sungbin.sungbintool.extensions.hide


/**
 * Created by SungBin on 2020-08-23.
 */

class FileAdapter(
    private val items: List<FileItem>,
    private val activity: Activity
) : RecyclerView.Adapter<FileAdapter.ViewHolder>() {

    private var onClickListener: OnClickListener? = null
    interface OnClickListener {
        fun onClick(fileItem: FileItem)
    }

    fun setOnClickListener(action: (FileItem) -> Unit) {
        onClickListener = object : OnClickListener {
            override fun onClick(fileItem: FileItem) {
                action(fileItem)
            }
        }
    }

    class ViewHolder(private val itemBinding: LayoutFileBinding, private val activity: Activity) :
        RecyclerView.ViewHolder(itemBinding.root) {
        fun bindViewHolder(file: FileItem, listener: OnClickListener?) {
            with (itemBinding) {
                item = file
                tvName.apply {
                    isSelected = true
                    setOnClickListener {
                        listener?.onClick(file)
                    }
                }
                if (file.size == "") tvDot.hide(true)
                invalidateAll()
            }
        }
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int) =
        ViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(viewGroup.context),
                R.layout.layout_file, viewGroup, false
            ), activity
        )

    override fun onBindViewHolder(@NonNull viewholder: ViewHolder, position: Int) {
        viewholder.bindViewHolder(items[position], onClickListener)
    }

    override fun getItemCount() = items.size
    override fun getItemId(position: Int) = position.toLong()
    override fun getItemViewType(position: Int) = position
}