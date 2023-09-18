package br.senai.sp.jandira.s_book

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import br.senai.sp.jandira.s_book.components.create_account.screen.CreateContScreen
import br.senai.sp.jandira.s_book.components.create_account_endereco.screen.CreateAccountEndereco
import br.senai.sp.jandira.s_book.components.forgot_password.screen.ForgotPasswordScreen
import br.senai.sp.jandira.s_book.components.login.screen.LoginScreen
import br.senai.sp.jandira.s_book.model.CreateAccountView

import br.senai.sp.jandira.s_book.ui.theme.SBOOKTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SBOOKTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize()
                ) {

                    val navController = rememberNavController()
                    val viewModelCreateAccount = viewModel<CreateAccountView>()

                    NavHost(
                        navController = navController, startDestination = "login"
                    ){
                        composable("login") {
                            LoginScreen(navController = navController, lifecycleScope = lifecycleScope, viewModel = viewModelCreateAccount)
                        }

                        composable("create_account") {
                            CreateContScreen(navController = navController, lifecycleScope = lifecycleScope, viewModel = viewModelCreateAccount)
                        }

                        composable("create_account_endereco") {
                            CreateAccountEndereco(navController = navController, lifecycleScope = lifecycleScope, viewModel = viewModelCreateAccount)
                        }

                        composable("forgot_password") {
                            ForgotPasswordScreen(lifecycleScope = lifecycleScope)
                        }

                        // A surface container using the 'background' color from the theme
                        //LoginScreen(lifecycleScope = lifecycleScope)
                        //CreateContScreen(navController = navController)
                        //CreateAccountEndereco()
                        //AddressScreen()
                        //RediscoverPasswordScreen()
                        //ThanksScreen()
                        //ForgotPasswordScreen()
                        //InsertCode()
                        //CategoryList()
                        //CategoryScreen()
                    }
                }
            }
        }
    }
}

