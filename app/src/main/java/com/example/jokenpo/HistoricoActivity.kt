package com.example.jokenpo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView

class HistoricoActivity : AppCompatActivity() {

    lateinit var listView : ListView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_historico)

        listView = findViewById(R.id.listView)

        var nossoHistorico = Jogada().ListarJogadas()

        // Passar o historico de jogadas para ser exibido
        var adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, nossoHistorico)
        listView.adapter = adapter
    }
}