package com.example.worldcup2022

import com.bumptech.glide.Glide
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class TeamAdapter(private val teams: List<Team>) : RecyclerView.Adapter<TeamAdapter.TeamViewHolder>() {

    inner class TeamViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val flagImageView: ImageView = itemView.findViewById(R.id.flag_image_view)
        val teamNameTextView: TextView = itemView.findViewById(R.id.team_name_text_view)

        init {
            itemView.setOnClickListener {
                val position = adapterPosition
                if (position != RecyclerView.NO_POSITION) {
                    val team = teams[position]
                    val intent = Intent(itemView.context, TeamDetailActivity::class.java).apply {
                        putExtra(TeamDetailActivity.EXTRA_TEAM_NAME, team.name)
                        putExtra(TeamDetailActivity.EXTRA_FLAG_URL, team.flagUrl)
                        putExtra(TeamDetailActivity.EXTRA_GROUP, team.group)
                        putStringArrayListExtra(TeamDetailActivity.EXTRA_PLAYERS, ArrayList(team.players))
                        putExtra(TeamDetailActivity.EXTRA_COACH, team.coach)
                    }
                    itemView.context.startActivity(intent)
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TeamViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.team_item, parent, false)
        return TeamViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: TeamViewHolder, position: Int) {
        val team = teams[position]
        Glide.with(holder.itemView.context)
            .load(team.flagUrl)
            .placeholder(R.drawable.flag_placeholder)
            .into(holder.flagImageView)
        holder.teamNameTextView.text = team.name

    }

    override fun getItemCount(): Int {
        return teams.size
    }
}
