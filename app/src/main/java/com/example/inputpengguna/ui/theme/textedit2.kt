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

