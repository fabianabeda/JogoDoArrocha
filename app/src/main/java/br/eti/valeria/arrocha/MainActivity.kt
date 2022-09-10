package br.eti.valeria.arrocha

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import android.widget.LinearLayout
import java.lang.NumberFormatException

class MainActivity : AppCompatActivity() {
    private lateinit var etNumero: EditText
    private lateinit var bnArrocha: Button
    private lateinit var arrocha: Arrocha

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        this.arrocha = Arrocha()

        this.etNumero = findViewById(R.id.etMainNumero)
        this.bnArrocha = findViewById(R.id.btMainArrocha)
        this.bnArrocha.setOnClickListener(OnClickBotao())

    }

    inner class OnClickBotao : View.OnClickListener {
        override fun onClick(p0: View?) {
            try {
                var numero = this@MainActivity.etNumero.text.toString().toInt()
                var msg = this@MainActivity.arrocha.jogar(numero)

                if (this@MainActivity.arrocha.getStatus() == Status.EXECUTANDO) {
                    Toast.makeText(this@MainActivity, msg, Toast.LENGTH_SHORT).show()
                } else {
                    //Navagar para outra tela
                    val intent = Intent(this@MainActivity, ResultadoActivity::class.java).apply {
                        putExtra("JOGO", this@MainActivity.arrocha)
                    }
                    //intent.putExtra("JOGO",this@MainActivity.arrocha)
                    startActivity(intent)
                    this@MainActivity.arrocha = Arrocha()
                }

                this@MainActivity.etNumero.setText("")
            }catch (e: NumberFormatException){
                Toast.makeText(this@MainActivity, "Digite um número válido", Toast.LENGTH_SHORT).show()
            }
        }
    }

}
