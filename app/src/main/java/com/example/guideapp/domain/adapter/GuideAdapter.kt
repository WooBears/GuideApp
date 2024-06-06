package com.example.guideapp.domain.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.guideapp.data.remote.dto.GuideEntity
import com.example.guideapp.databinding.GuideItemBinding
import com.example.guideapp.presentation.ui.GuideDetailActivity

class GuideAdapter : ListAdapter<GuideEntity, GuideAdapter.GuideViewHolder>(GuideDiffCallback()){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GuideViewHolder {
        val binding = GuideItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return GuideViewHolder(binding)
    }

    override fun onBindViewHolder(holder: GuideViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class GuideViewHolder(private val binding: GuideItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(guide: GuideEntity) {
            binding.name.text = guide.name
            binding.cityState.text = "${guide.city}, ${guide.state}"
            binding.endDate.text = guide.endDate
            Glide.with(binding.icon.context)
                .load(guide.icon)
                .into(binding.icon)

            binding.root.setOnClickListener {
                val intent = Intent(binding.root.context, GuideDetailActivity::class.java)
                intent.putExtra("url", guide.url)
                binding.root.context.startActivity(intent)
            }
        }
    }

}
class GuideDiffCallback : DiffUtil.ItemCallback<GuideEntity>() {
    override fun areItemsTheSame(oldItem: GuideEntity, newItem: GuideEntity): Boolean {
        return oldItem.city == newItem.city
    }

    override fun areContentsTheSame(oldItem: GuideEntity, newItem: GuideEntity): Boolean {
        return oldItem == newItem
    }
}