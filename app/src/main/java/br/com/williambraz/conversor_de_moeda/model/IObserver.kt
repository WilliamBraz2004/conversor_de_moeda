package br.com.williambraz.conversor_de_moeda.model

interface IObserver {
    fun updateUI(data:MutableMap<String,Any>)
}