package br.com.williambraz.conversor_de_moeda.model

import androidx.databinding.ObservableDouble

class Price {
    private var value = ObservableDouble()

    fun getValue() = value.get()
    fun setValue(value:Double){
        this.value.set(value)
    }
}