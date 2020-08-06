package com.example.test.ui.matches

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.bumptech.glide.Glide
import com.example.test.R
import com.example.test.TeamApplication
import com.example.test.data.model.StadiumsResponse
import com.example.test.ui.StadiumViewModelFactory
import com.example.test.ui.viewmodel.StadiumViewModel
import kotlinx.android.synthetic.main.fragment_matches.*
import javax.inject.Inject

class MatchesFragment : Fragment() {
    lateinit var stadiumViewModel: StadiumViewModel
    @Inject
    lateinit var stadiumViewModelFactory: StadiumViewModelFactory
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_matches,container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        stadiumViewModel = ViewModelProviders.of(this,stadiumViewModelFactory)[StadiumViewModel::class.java]
        getData()
    }

    private fun getData(){
        stadiumViewModel.getStadiums()
        stadiumViewModel.listOfStadiums.observe(viewLifecycleOwner, Observer {data->
            populateViews(data)
        })
    }
    private fun populateViews(data: StadiumsResponse){
        TeamName1.text = data.results.team1.teamName
        TeamName2.text = data.results.team2.teamName
        score1.text = data.results.team1.score.toString()
        score2.text = data.results.team2.score.toString()
        Glide.with(this)
            .load(data.results.team1.teamImage)
            .into(TeamImage1)
        Glide.with(this)
            .load(data.results.team2.teamImage)
            .into(TeamImage2)
    }
    override fun onAttach(context: Context) {
        super.onAttach(context)
        (activity?.application as TeamApplication).appComponent.inject(this)
    }
}