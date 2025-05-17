package com.example.sqlite_app

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import java.time.LocalDate
import java.util.Date

class MainActivity : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val edtNome: EditText = findViewById(R.id.edtNome)
        val edtEndereco: EditText = findViewById(R.id.edtEndereco)
        val edtBairro: EditText = findViewById(R.id.edtBairro)
        val edtCep: EditText = findViewById(R.id.edtCep)
        val edtObs: EditText = findViewById(R.id.edtObs)
        val dataCadastro: String = LocalDate.now().toString()

        val btnCadastrar: Button = findViewById(R.id.btnCadastrar)

        btnCadastrar.setOnClickListener {
            val intent = Intent(this, RespostaActivity::class.java)
            intent.putExtra("nome", edtNome.text.toString())
            intent.putExtra("endereco", edtEndereco.text.toString())
            intent.putExtra("bairro", edtBairro.text.toString())
            intent.putExtra("cep", edtCep.text.toString())
            intent.putExtra("obs", edtObs.text.toString())
            intent.putExtra("dataCadastro", dataCadastro)
            startActivity(intent)
        }

    }
}