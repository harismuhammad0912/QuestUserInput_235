import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
// Hapus stringResource jika tidak tersedia, ganti dengan string biasa
// import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

// @Composable fun stringResource(@StringRes id: Int): String { return "SUBMIT" } // Contoh jika stringResource tidak tersedia

@Composable
fun FormulirPendaftaranModifikasi(modifier: Modifier = Modifier) {
    // State untuk input teks
    var textNama by remember { mutableStateOf("") }
    var textAlamat by remember { mutableStateOf("") }

    // State untuk RadioButton (Jenis Kelamin dan Status)
    var selectedJK by remember { mutableStateOf("") }
    var selectedStatus by remember { mutableStateOf("") }

    // State untuk hasil yang akan ditampilkan
    var namaResult by remember { mutableStateOf("") }
    var alamatResult by remember { mutableStateOf("") }
    var jenisResult by remember { mutableStateOf("") }
    var statusResult by remember { mutableStateOf("") }

    val gender: List<String> = listOf("Laki-laki", "Perempuan")
    val statusList: List<String> = listOf("Janda", "Lajang", "Duda", "Menikah") // Tambah "Menikah"

    val isButtonEnabled = textAlamat.isNotEmpty() && textNama.isNotEmpty() && selectedJK.isNotEmpty() && selectedStatus.isNotEmpty()

    LazyColumn( // Menggunakan LazyColumn agar formulir dapat di-scroll
        modifier = modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        item {
            // Header
            Text(
                text = "📝 Formulir Pendaftaran Baru",
                style = MaterialTheme.typography.headlineMedium.copy(fontWeight = FontWeight.Bold),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 24.dp, bottom = 16.dp),
                textAlign = TextAlign.Center,
                color = MaterialTheme.colorScheme.primary
            )
        }

        item {
            // Input Nama
            TextField(
                value = textNama,
                onValueChange = { textNama = it },
                label = { Text("Nama Lengkap") },
                singleLine = true,
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(16.dp))
        }

        item {
            // RadioButton JENIS KELAMIN
            Column(
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = "JENIS KELAMIN",
                    style = MaterialTheme.typography.bodyLarge.copy(fontWeight = FontWeight.Medium),
                    modifier = Modifier.padding(bottom = 8.dp)
                )
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceAround
                ) {
                    gender.forEach { item ->
                        Row(
                            modifier = Modifier
                                .selectable(
                                    selected = selectedJK == item,
                                    onClick = { selectedJK = item }
                                )
                                .padding(vertical = 4.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            RadioButton(
                                selected = selectedJK == item,
                                onClick = { selectedJK = item }
                            )
                            Text(item, style = MaterialTheme.typography.bodyMedium)
                        }
                    }
                }
            }
            Spacer(modifier = Modifier.height(16.dp))
        }

        item {
            // RadioButton STATUS PERKAWINAN - PERBAIKAN ERROR
            Column(
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = "STATUS PERKAWINAN",
                    style = MaterialTheme.typography.bodyLarge.copy(fontWeight = FontWeight.Medium),
                    modifier = Modifier.padding(bottom = 8.dp)
                )

                // **PERBAIKAN: Mengganti FlowRow dengan Column**
                Column(
                    modifier = Modifier.fillMaxWidth(),
                    verticalArrangement = Arrangement.spacedBy(4.dp) // Jarak vertikal antar item
                ) {
                    statusList.forEach { item ->
                        Row(
                            modifier = Modifier
                                .fillMaxWidth() // Tambahkan fillMaxWidth untuk Row di dalam Column
                                .selectable(
                                    selected = selectedStatus == item,
                                    onClick = { selectedStatus = item }
                                ),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            RadioButton(
                                selected = selectedStatus == item,
                                onClick = { selectedStatus = item }
                            )
                            Text(item, style = MaterialTheme.typography.bodyMedium)
                        }
                    }
                }
            }
            Spacer(modifier = Modifier.height(16.dp))
        }

        item {
            // Input Alamat
            OutlinedTextField(
                value = textAlamat,
                onValueChange = { textAlamat = it },
                label = { Text("Alamat Lengkap") },
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(24.dp))
        }

        item {
            // Tombol SUBMIT
            Button(
                onClick = {
                    namaResult = textNama
                    jenisResult = selectedJK
                    alamatResult = textAlamat
                    statusResult = selectedStatus
                },
                enabled = isButtonEnabled,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("SUBMIT DATA")
            }
