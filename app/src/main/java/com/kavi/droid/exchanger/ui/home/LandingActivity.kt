package com.kavi.droid.exchanger.ui.home

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.design.widget.NavigationView
import android.support.v4.app.Fragment
import android.support.v4.view.GravityCompat
import android.support.v4.widget.DrawerLayout
import android.support.v7.app.ActionBarDrawerToggle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import com.kavi.droid.exchanger.AppConstant
import com.kavi.droid.exchanger.R
import com.kavi.droid.exchanger.ui.ExchangerBaseActivity
import com.kavi.droid.exchanger.util.CommonUtil
import kotlinx.android.synthetic.main.activity_landing.*
import kotlinx.android.synthetic.main.view_landing_app_bar.*

class LandingActivity : ExchangerBaseActivity(), NavigationView.OnNavigationItemSelectedListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_landing)
        setSupportActionBar(toolbar)

        setupView()
    }

    override fun onBackPressed() {
        if (drawer_layout.isDrawerOpen(GravityCompat.START)) {
            drawer_layout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.landing, menu)
        return true
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        // Handle navigation view item clicks here.
        var fragment: Fragment? = null
        var fragmentTag = AppConstant.DEFAULT_FRAGMENT_TAG
        when (item.itemId) {
            R.id.nav_home -> {
                fragment = HomeFragment()
                fragmentTag = AppConstant.LANDING_HOME_FRAGMENT_TAG
            }
            R.id.nav_history -> {
                fragment = LanguageFragment()
                fragmentTag = AppConstant.LANDING_LANGUAGE_FRAGMENT_TAG
            }
            R.id.nav_profile -> {
                fragment = LanguageFragment()
                fragmentTag = AppConstant.LANDING_LANGUAGE_FRAGMENT_TAG
            }
            R.id.nav_notifications -> {
                fragment = LanguageFragment()
                fragmentTag = AppConstant.LANDING_LANGUAGE_FRAGMENT_TAG
            }
            R.id.nav_language -> {
                fragment = LanguageFragment()
                fragmentTag = AppConstant.LANDING_LANGUAGE_FRAGMENT_TAG
            }
        }

        if (fragment != null) {
            replaceFragmentView(fragment, R.id.landing_frame_container, fragmentTag, null)

            val drawer = findViewById(R.id.drawer_layout) as DrawerLayout
            drawer.closeDrawer(GravityCompat.START)
        } else {
            // error in creating fragment
            Log.e("", "LandingActivity:onNavigationItemSelected / On Fragment form error: Fail to create Fragment")
        }

        return true
    }

    fun setupView() {
        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
        }

        val toggle = ActionBarDrawerToggle(
                this, drawer_layout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close)
        drawer_layout.addDrawerListener(toggle)
        toggle.syncState()

        nav_view.setNavigationItemSelectedListener(this)

        // Remove app title from the action bar
        supportActionBar!!.setDisplayShowTitleEnabled(false)

        setInitialView()
    }

    fun setInitialView() {
        val fragment = HomeFragment();
        replaceFragmentView(fragment, R.id.landing_frame_container, AppConstant.LANDING_HOME_FRAGMENT_TAG, null)
    }
}
