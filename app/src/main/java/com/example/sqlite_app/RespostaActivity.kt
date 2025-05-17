package com.example.sqlite_app

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.sqlite_app.db.DBHelper

class RespostaActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_resposta)

        val edtNome: EditText = findViewById(R.id.edtNome)
        val edtEndereco: EditText = findViewById(R.id.edtEndereco)
        val edtBairro: EditText = findViewById(R.id.edtBairro)
        val edtCep: EditText = findViewById(R.id.edtCep)
        val edtObs: EditText = findViewById(R.id.edtObs)
        val edtDataCadastro: EditText = findViewById(R.id.edtDataCadastro)
        val btnConfirmar: Button = findViewById(R.id.btnConfirmar)

        edtNome.setText(intent.getStringExtra("nome"))
        edtEndereco.setText(intent.getStringExtra("endereco"))
        edtBairro.setText(intent.getStringExtra("bairro"))
        edtCep.setText(intent.getStringExtra("cep"))
        edtObs.setText(intent.getStringExtra("obs"))
        edtDataCadastro.setText(intent.getStringExtra("dataCadastro"))

        edtDataCadastro.isEnabled = false

        val db = DBHelper(this, null)

        btnConfirmar.setOnClickListener {
            db.addPessoa(
                edtNome.text.toString(),
                edtEndereco.text.toString(),
                edtBairro.text.toString(),
                edtCep.text.toString(),
                edtObs.text.toString(),
                edtDataCadastro.text.toString()
            )
            finish()
        }

    }
}
