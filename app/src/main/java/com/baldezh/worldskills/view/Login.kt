package com.baldezh.worldskills.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.baldezh.worldskills.R
import com.baldezh.worldskills.Routes
import com.baldezh.worldskills.ui.theme.Hint
import com.baldezh.worldskills.ui.theme.SubTextLight

@Composable
fun Login(navController: NavHostController) {
    val login = remember { mutableStateOf("") }
    val setLogin: (String) -> Unit = { login.value = it }
    val isCorrectLogin = remember { mutableStateOf(false) }

    val password = remember { mutableStateOf("") }
    val setPassword: (String) -> Unit = { password.value = it }
    var passwordVisible by rememberSaveable { mutableStateOf(false) }

    Scaffold(
        bottomBar = { IsFirstly() },
        modifier = Modifier.padding(top = 30.dp)
    ) { innerPadding ->
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxWidth()
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.SpaceAround,
                modifier = Modifier
                    .fillMaxWidth(0.9f)
                    .fillMaxHeight(0.6f)
            ) {
                Text(
                    text = "Привет!",
                    fontSize = 32.sp,
                    fontWeight = FontWeight.Bold,
                )
                Text(
                    text = "Заполните Свои данные или продолжите через социальные медиа",
                    fontSize = 17.sp,
                    textAlign = TextAlign.Center,
                    color = Color(112, 123, 129)
                )
                Column(horizontalAlignment = Alignment.Start, modifier = Modifier.fillMaxWidth()) {
                    Text(text = "Email")
                    OutlinedTextField(
                        value = login.value,
                        onValueChange = {
                            setLogin(it)
                            val regex = Regex("\\S+@\\S+\\.\\S+");
                            isCorrectLogin.value = !regex.matches(it)
                        },
                        placeholder = { Text("xyz@gmail.com") },
                        colors = OutlinedTextFieldDefaults.colors(
                            focusedBorderColor = Color.Transparent,
                            unfocusedBorderColor = Color.Transparent,
                            focusedTextColor = Hint,
                            unfocusedTextColor = Hint,
                            unfocusedLabelColor = Hint,
                            focusedLabelColor = Hint,
                            errorContainerColor = SubTextLight,
                            focusedContainerColor = SubTextLight,
                            unfocusedContainerColor = SubTextLight,
                        ),
                        shape = RoundedCornerShape(16.dp),
                        modifier = Modifier.fillMaxWidth(),
                        singleLine = true,
                        isError = isCorrectLogin.value
                    )
                }
                Column(horizontalAlignment = Alignment.Start, modifier = Modifier.fillMaxWidth()) {
                    Text(text = "Пароль")
                    OutlinedTextField(
                        value = password.value,
                        onValueChange = { setPassword(it) },
                        colors = OutlinedTextFieldDefaults.colors(
                            focusedBorderColor = Color.Transparent,
                            unfocusedBorderColor = Color.Transparent,
                            focusedTextColor = Hint,
                            unfocusedTextColor = Hint,
                            unfocusedLabelColor = Hint,
                            focusedLabelColor = Hint,
                            errorContainerColor = SubTextLight,
                            focusedContainerColor = SubTextLight,
                            unfocusedContainerColor = SubTextLight,
                        ),
                        shape = RoundedCornerShape(16.dp),
                        modifier = Modifier.fillMaxWidth(),
                        singleLine = true,
                        visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                        trailingIcon = {
                            val image = if (passwordVisible)
                                R.drawable.ic_visibility
                            else R.drawable.ic_visibility_off
                            val description = if (passwordVisible) "Hide password" else "Show password"

                            IconButton(onClick = {passwordVisible = !passwordVisible}){
                                Icon(painterResource(image), description)
                            }
                        }
                    )
                }
                Row(horizontalArrangement = Arrangement.End, modifier = Modifier.fillMaxWidth()) {
                    TextButton(onClick = {}) {
                        Text(text = "Восстановить", color = Color(112, 123, 129))
                    }
                }
                ElevatedButton(
                    onClick = {navController.navigate(Routes.Home.route)},
                    colors = ButtonColors(
                        containerColor = Color(72, 178, 231),
                        contentColor = Color.White,
                        disabledContainerColor = Color.White,
                        disabledContentColor = Color.White
                    ),
                    modifier = Modifier
                        .height(55.dp)
                        .fillMaxWidth(),
                    shape = RoundedCornerShape(14.dp),
                ) {
                    Text(text = "Войти")
                }
            }
        }


    }

}

@Composable
fun IsFirstly() {
    Row(
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.fillMaxWidth()
    ) {
        Text(
            text = "Вы впервые?",
            fontSize = 18.sp
        )
        TextButton(onClick = {}) {
            Text(
                text = "Создать пользователя",
                color = Color.Black,
                fontSize = 18.sp
            )
        }
    }
}