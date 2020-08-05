package com.example.test.ui.matches

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.test.R
import com.example.test.TeamApplication
import com.example.test.data.model.StadiumsResponse
import com.example.test.repository.DataRepository
import com.example.test.ui.StadiumViewModelFactory
import com.example.test.ui.viewmodel.StadiumViewModel
import javax.inject.Inject

class MatchesFragment : Fragment() {
    lateinit var stadiumViewModel: StadiumViewModel
    @Inject
    lateinit var stadiumViewModelFactory: StadiumViewModelFactory
    lateinit var realData: StadiumsResponse
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_matches,container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (context as TeamApplication).appComponent.inject(this)
        stadiumViewModel = ViewModelProviders.of(this,stadiumViewModelFactory)[StadiumViewModel::class.java]
        val team1 = view.findViewById<TextView>(R.id.Team1)
        team1.text = realData.results.team1.teamName
    }

    private fun getData(){
        stadiumViewModel.listOfStadiums.observe(this, Observer {data->
            realData = data
        })
    }
}