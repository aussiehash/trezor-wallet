package com.mattskala.trezorwallet.ui

import android.support.v4.app.Fragment
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.support.closestKodein


abstract class BaseFragment : Fragment(), KodeinAware {
    private val parentKodein by closestKodein()
    override val kodein = Kodein.lazy {
        extend(parentKodein)
        import(provideOverridingModule())
    }

    open fun provideOverridingModule() = Kodein.Module("Fragment") {}
}