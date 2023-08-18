package com.example.jokenpo

class Jogada {
    var jogador : Int = 0
    var maquina : Int = 0
    var resultado : String = ""

    // Informação compartilhada pela classe
    companion object{
        private val historico = mutableListOf<Jogada>()
    }

    // Quando chamar a classe jogada
    // Devo passar os meus valores
    constructor(jogador : Int, maquina : Int, resultado : String){
        // Referencia  da caracteristica da classe -> this.
        this.jogador = jogador
        this.maquina = maquina
        this.resultado = resultado
    }

    constructor()

    // Função para adicionar as jogadas na lista
    fun AdicionarJogada(novaJogada: Jogada){
        historico.add(novaJogada)
    }

    // Devolvendo todas as listas
    fun ListarJogadas() : List<Jogada>{
        return historico.toList()
    }


    override fun toString(): String {

        var tradutor = if(jogador == 0){
            "papel"
        }else if(jogador == 1){
            "pedra"
        }else{
            "tesoura"
        }

        var tradutorMaquina = if(maquina == 0){
            "papel"
        }else if(maquina == 1){
            "pedra"
        }else{
            "tesoura"
        }

        return "A minha jogada: ${tradutor}, a jogada da máquina: ${tradutorMaquina}, e o resultado ${resultado}"
    }
}