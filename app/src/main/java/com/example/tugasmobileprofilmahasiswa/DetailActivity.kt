package com.example.tugasmobilekeprofilmahasiswa

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.School
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.profilmahasiswa.ui.theme.*

class DetailActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ProfilMahasiswaTheme {
                DetailScreen(onBack = { finish() })
            }
        }
    }
}

@Composable
fun DetailScreen(onBack: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(BackgroundLight)
            .verticalScroll(rememberScrollState())
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {

        // Header
        Text(
            text = "Detail Mahasiswa",
            fontSize = 22.sp,
            fontWeight = FontWeight.Bold,
            color = Primary
        )

        // ── Card Info Akademik ──
        Card(
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(16.dp),
            colors = CardDefaults.cardColors(containerColor = CardBg),
            elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
        ) {
            Column(modifier = Modifier.padding(20.dp)) {
                Text(
                    text = "Informasi Akademik",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = Primary
                )
                Spacer(modifier = Modifier.height(12.dp))
                DetailRow(icon = Icons.Filled.School, label = "Universitas", value = "Universitas Lambung Mangkurat")
                DetailRow(icon = Icons.Filled.School, label = "Fakultas", value = "Teknik")
                DetailRow(icon = Icons.Filled.Person, label = "Angkatan", value = "2023")
                DetailRow(icon = Icons.Filled.Person, label = "Status", value = "Aktif")
            }
        }

        // ── Card Kontak ──
        Card(
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(16.dp),
            colors = CardDefaults.cardColors(containerColor = CardBg),
            elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
        ) {
            Column(modifier = Modifier.padding(20.dp)) {
                Text(
                    text = "Kontak",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = Primary
                )
                Spacer(modifier = Modifier.height(12.dp))
                DetailRow(icon = Icons.Filled.Email, label = "Email", value = "maulana@example.com")
            }
        }

        Spacer(modifier = Modifier.height(4.dp))

        // ── Tombol Kembali ──
        Button(
            onClick = onBack,
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp),
            shape = RoundedCornerShape(24.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Primary)
        ) {
            Icon(
                imageVector = Icons.Filled.ArrowBack,
                contentDescription = null,
                modifier = Modifier.size(18.dp)
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(
                text = "Kembali",
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White
            )
        }
    }
}

@Composable
fun DetailRow(icon: ImageVector, label: String, value: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            imageVector = icon,
            contentDescription = null,
            tint = Accent,
            modifier = Modifier.size(18.dp)
        )
        Spacer(modifier = Modifier.width(8.dp))
        Column {
            Text(text = label, fontSize = 12.sp, color = TextSecondary)
            Text(text = value, fontSize = 14.sp, color = TextPrimary, fontWeight = FontWeight.Medium)
        }
    }
}