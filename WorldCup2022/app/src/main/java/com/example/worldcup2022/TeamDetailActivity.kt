package com.example.worldcup2022

import com.bumptech.glide.Glide
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class TeamDetailActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_TEAM_NAME = "extra_team_name"
        const val EXTRA_FLAG_URL = "extra_flag_url"
        const val EXTRA_GROUP = "extra_group"
        const val EXTRA_PLAYERS = "extra_players"
        const val EXTRA_COACH = "extra_coach"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_team_detail)


        val teamName = intent.getStringExtra(EXTRA_TEAM_NAME)
        val flagUrl = intent.getStringExtra(EXTRA_FLAG_URL)
        val group = intent.getStringExtra(EXTRA_GROUP)
        val players = intent.getStringArrayListExtra(EXTRA_PLAYERS)
        val coach = intent.getStringExtra(EXTRA_COACH)

        val flagImageView = findViewById<ImageView>(R.id.flag_image_view)
        val teamNameTextView = findViewById<TextView>(R.id.team_name_text_view)
        val groupTextView = findViewById<TextView>(R.id.group_text_view)
        val playersTextView = findViewById<TextView>(R.id.players_text_view)
        val coachTextView = findViewById<TextView>(R.id.coach_text_view)

        Glide.with(this)
            .load(flagUrl)
            .placeholder(R.drawable.flag_placeholder)
            .into(flagImageView)

        teamNameTextView.text = teamName
        groupTextView.text = group
        playersTextView.text = players?.joinToString(", ") ?: "No players available"
        coachTextView.text = coach
    }
}
