package br.senai.sp.jandira.s_book.model

import androidx.lifecycle.ViewModel

class CreateAccountView: ViewModel() {
    var nome: String? = ""
    var email: String? = ""
    var cpf: String? = ""
    var dataNascimento: String? = ""
    var senha: String? = ""
}