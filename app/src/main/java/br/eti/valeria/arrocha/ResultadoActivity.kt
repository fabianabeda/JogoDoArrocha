package br.eti.valeria.arrocha

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import android.widget.TextView


class ResultadoActivity : AppCompatActivity() {
    private lateinit var layoutResultado: LinearLayout
    private lateinit var tvResultado: TextView
    private lateinit var tvIntervalo: TextView
    private lateinit var tvSorteado: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resultado)

        this.tvResultado = findViewById(R.id.tvResultado)
        this.tvIntervalo = findViewById(R.id.tvIntervalo)
        this.tvSorteado = findViewById(R.id.tvSorteado)
        this.layoutResultado= findViewById(R.id.layoutResultado)

        if (intent.hasExtra("JOGO")) {
            val jogo = intent.getSerializableExtra("JOGO") as Arrocha

            if (jogo.getStatus() == Status.GANHOU) {
                this.tvResultado.setText("GANHOU!")
                this.layoutResultado.setBackgroundColor(Color.GREEN)

            } else if (jogo.getStatus() == Status.PERDEU) {
                this.tvResultado.setText("PERDEU!")
                this.layoutResultado.setBackgroundColor(Color.RED)
            }

        this.tvSorteado.setText("Número sorteado: ${jogo.getSecreto()}")
        this.tvIntervalo.setText("Intervalo: ${jogo.getMenor()} e ${jogo.getMaior()}")

        }

    }

}

