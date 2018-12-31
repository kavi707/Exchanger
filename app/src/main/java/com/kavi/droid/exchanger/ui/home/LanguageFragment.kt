package com.kavi.droid.exchanger.ui.home

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.kavi.droid.exchanger.R
import com.kavi.droid.exchanger.service.sharedPreference.PreferenceRepository
import com.kavi.droid.exchanger.ui.ExchangerBaseFragment
import com.kavi.droid.exchanger.util.CommonUtil
import kotlinx.android.synthetic.main.fragment_landing_language.*
import kotlinx.android.synthetic.main.fragment_landing_language.view.*

class LanguageFragment: ExchangerBaseFragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_landing_language, container, false)
        pageView = view

        setUpView(view)
        return view
    }

    override fun onResume() {
        super.onResume()
        init()
    }

    private fun setUpView(pageView: View) {

        var lanToLoad: String

        pageView.english_relative_layout.setOnClickListener { view ->
            lanToLoad = "en" // English
            setLocale(lanToLoad)
        }

        pageView.sinhala_relative_layout.setOnClickListener { view ->
            lanToLoad = "si" // Sinhala
            setLocale(lanToLoad)
        }

        pageView.tamil_relative_layout.setOnClickListener { view ->
            lanToLoad = "ta" // Tamil
            setLocale(lanToLoad)
        }
    }

    private fun init() {
        val selectedLocale = PreferenceRepository.getSelectedLocal(context!!)
        if (!"NULL".equals(selectedLocale)) {
            setLocalIndicator(selectedLocale.toString())
        } else {
            PreferenceRepository.setSelectedLocal(context!!, "en")
            setLocalIndicator("en")
        }
    }

    private fun setLocale(locale: String) {
        PreferenceRepository.setSelectedLocal(context!!, locale)
        setLocalIndicator(locale)
        CommonUtil.setLocale(activity!!)
        activityRelaunch()
    }

    private fun setLocalIndicator(locale: String) {
        when (locale) {
            "en" -> {
                englishTickIcon.visibility = View.VISIBLE
                sinhalaTickIcon.visibility = View.INVISIBLE
                tamilTickIcon.visibility = View.INVISIBLE
            }
            "si" -> {
                englishTickIcon.visibility = View.INVISIBLE
                sinhalaTickIcon.visibility = View.VISIBLE
                tamilTickIcon.visibility = View.INVISIBLE
            }
            "ta" -> {
                englishTickIcon.visibility = View.INVISIBLE
                sinhalaTickIcon.visibility = View.INVISIBLE
                tamilTickIcon.visibility = View.VISIBLE
            }
            else -> {
                englishTickIcon.visibility = View.VISIBLE
                sinhalaTickIcon.visibility = View.INVISIBLE
                tamilTickIcon.visibility = View.INVISIBLE
            }
        }
    }

    private fun activityRelaunch() {
        val refresh = Intent(activity, LandingActivity::class.java)
        startActivity(refresh)
        activity!!.finish()
    }
}