package com.example.inputpengguna.ui.theme

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.selection.selectable
import androidx.compose.material3.Button
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun FormDataDiri(modifier: Modifier = Modifier) {

    var textNama by remember { mutableStateOf(value = "MUHAMMAD HARIS") }
    var textAlamat by remember { mutableStateOf(value = "PAYAKUMBUH") }
    var textJk by remember { mutableStateOf(value = "Laki-Laki") }

    var nama by remember { mutableStateOf(value = "MUHAMMAD HARIS") }
    var alamat by remember { mutableStateOf(value = "PAYAKUMBUH") }
    var jenis by remember { mutableStateOf(value = "Laki-Laki") }

    val gender: List<String> = listOf("Laki-Laki", "Perempuan")

    Column(
        modifier = modifier
            .padding(top = 50.dp, start = 16.dp, end = 16.dp)
            .fillMaxWidth(),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        OutlinedTextField(
            value = textNama,
            onValueChange = { textNama = it },
            singleLine = true,
            shape = MaterialTheme.shapes.large,
            modifier = Modifier.width(width = 250.dp),
            label = { Text("Nama Lengkap") }
        )

        Row(
            modifier = Modifier
                .width(250.dp)
                .padding(top = 8.dp),
            horizontalArrangement = Arrangement.SpaceAround,
            verticalAlignment = Alignment.CenterVertically
        ) {
            gender.forEach { item ->
                Row(
                    modifier = Modifier
                        .selectable(
                            selected = (textJk == item),
                            onClick = { textJk = item }
                        ),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    RadioButton(
                        selected = (textJk == item),
                        onClick = { textJk = item }
                    )
                    Text(
                        text = item,
                        modifier = Modifier.padding(start = 4.dp)
                    )
                }
            }
        }

        OutlinedTextField(
            value = textAlamat,
            onValueChange = { textAlamat = it },
            singleLine = true,
            modifier = Modifier
                .width(width = 250.dp)
                .padding(top = 8.dp),
            label = { Text(text = "Alamat Lengkap") }
        )

        HorizontalDivider(
            modifier = Modifier.padding(top = 16.dp, bottom = 16.dp),
            thickness = 1.dp,
            color = Color.DarkGray
        )

        Button(
            modifier = Modifier.width(250.dp),
            enabled = textAlamat.isNotEmpty() && textNama.isNotEmpty() && textJk.isNotEmpty(),
            onClick = {
                nama = textNama
                jenis = textJk
                alamat = textAlamat
            }
