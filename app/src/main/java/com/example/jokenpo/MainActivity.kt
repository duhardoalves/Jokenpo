package com.example.jokenpo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import org.w3c.dom.Text
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    // Capturando nossos recursos
    lateinit var btn_pedra: ImageButton
    lateinit var btn_papel: ImageButton
    lateinit var btn_tesoura: ImageButton
    lateinit var imgMaquina: ImageView
    lateinit var resultado: TextView
    lateinit var btn_historico : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_papel = findViewById(R.id.btn_papel)
        btn_pedra = findViewById(R.id.btn_pedra)
        btn_tesoura = findViewById(R.id.btn_tesoura)
        imgMaquina = findViewById(R.id.random_img)
        resultado = findViewById(R.id.resultado)
        btn_historico = findViewById(R.id.btn_historico)

        btn_papel.setOnClickListener(){
            resultado.text = Jogar(0)
        }

        btn_pedra.setOnClickListener(){
            resultado.text = Jogar(1)
        }

        btn_tesoura.setOnClickListener(){
            resultado.text = Jogar(2)
        }

        // Chamada da nova activity
        btn_historico.setOnClickListener(){
            val intent = Intent(this, HistoricoActivity::class.java)
            startActivity(intent)
        }
    }

    // Nossa jogada
    fun Jogar(jogada : Int) : String{
        var resultado : String = ""
        // Chamando a jogada da maquina
        val resultMaquina = ResultadoMaquina()

        if (jogada == resultMaquina){
            resultado = "Empatou"
        }else{
            // 0 -> papel / 1-> pedra / 2-> tesoura
            if(jogada == 0 && resultMaquina == 1 ||
                jogada == 1 && resultMaquina == 2 ||
                jogada == 2 && resultMaquina == 0){
                resultado = "Venceu"
            }else{
                resultado = "Perdeu"
            }
        }

        var novaJogada = Jogada(jogada, resultMaquina, resultado)
        novaJogada.AdicionarJogada(novaJogada)

        return resultado
    }

    fun ResultadoMaquina(): Int {

        imgMaquina = findViewById(R.id.random_img)

        var numeroRandom = Random.nextInt(3)
        // 0 -> papel / 1-> pedra / 2-> tesoura

        when (numeroRandom) {
            0 -> imgMaquina.setImageDrawable(getDrawable(R.drawable.papel))
            1 -> imgMaquina.setImageDrawable(getDrawable(R.drawable.pedra))
            2 -> imgMaquina.setImageDrawable(getDrawable(R.drawable.tesoura))
        }
        return numeroRandom
    }

}