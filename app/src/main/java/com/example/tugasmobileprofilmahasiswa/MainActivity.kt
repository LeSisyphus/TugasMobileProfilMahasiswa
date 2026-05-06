package com.example.tugasmobileprofilmahasiswa

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tugasmobileprofilmahasiswa.ui.theme.*

class MainActivity : ComponentActivity() {

    private val TAG = "MainActivity"
    private var lifecycleStatus = mutableStateOf("onCreate()")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        updateStatus("onCreate()")
        Log.d(TAG, "onCreate() dipanggil")

        setContent {
            ProfilMahasiswaTheme {
                ProfilScreen(lifecycleStatus = lifecycleStatus.value)
            }
        }
    }

    override fun onStart() {
        super.onStart()
        updateStatus("onStart()")
        Log.d(TAG, "onStart() dipanggil")
    }

    override fun onResume() {
        super.onResume()
        updateStatus("onResume()")
        Log.d(TAG, "onResume() dipanggil")
    }

    override fun onPause() {
        super.onPause()
        updateStatus("onPause()")
        Log.d(TAG, "onPause() dipanggil")
    }

    override fun onStop() {
        super.onStop()
        updateStatus("onStop()")
        Log.d(TAG, "onStop() dipanggil")
    }

    override fun onDestroy() {
        super.onDestroy()
        updateStatus("onDestroy()")
        Log.d(TAG, "onDestroy() dipanggil")
    }

    override fun onRestart() {
        super.onRestart()
        updateStatus("onRestart()")
        Log.d(TAG, "onRestart() dipanggil")
    }

    private fun updateStatus(status: String) {
        lifecycleStatus.value = status
    }
}

@Composable
fun ProfilScreen(lifecycleStatus: String) {
    val context = LocalContext.current

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(BackgroundLight)
            .verticalScroll(rememberScrollState())
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {

        Card(
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(16.dp),
            colors = CardDefaults.cardColors(containerColor = CardBg),
            elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(24.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Image(
                    painter = painterResource(id = R.drawable.img),
                    contentDescription = "Foto Mahasiswa",
                    contentScale = ContentScale.FillHeight,
                    alignment = Alignment.TopCenter,
                    modifier = Modifier
                        .size(200.dp)
                        .clip(CircleShape)
                        .border(3.dp, BorderDark, CircleShape)
                )

                Spacer(modifier = Modifier.height(12.dp))

                Text(
                    text = "Muhammad Maulana Azhari",
                    fontSize = 22.sp,
                    fontWeight = FontWeight.Bold,
                    color = Primary
                )

                Spacer(modifier = Modifier.height(6.dp))

                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center
                ) {
                    Icon(
                        imageVector = Icons.Filled.Person,
                        contentDescription = "NIM",
                        tint = TextSecondary,
                        modifier = Modifier.size(16.dp)
                    )
                    Spacer(modifier = Modifier.width(4.dp))
                    Text(
                        text = "2410817210003",
                        fontSize = 14.sp,
                        color = TextSecondary
                    )
                }

                Spacer(modifier = Modifier.height(4.dp))

                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center
                ) {
                    Icon(
                        imageVector = Icons.Filled.Star,
                        contentDescription = "Prodi",
                        tint = TextSecondary,
                        modifier = Modifier.size(16.dp)
                    )
                    Spacer(modifier = Modifier.width(4.dp))
                    Text(
                        text = "Teknologi Informasi",
                        fontSize = 14.sp,
                        color = TextSecondary
                    )
                }
            }
        }

        Card(
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(16.dp),
            colors = CardDefaults.cardColors(containerColor = CardBg),
            elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
        ) {
            Column(modifier = Modifier.padding(20.dp)) {
                Text(
                    text = "Tentang Saya",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = Primary
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = "Mahasiswa aktif yang tertarik pada pengembangan aplikasi mobile dan teknologi informasi. Sedang menempuh studi di Universitas Lambung Mangkurat.",
                    fontSize = 14.sp,
                    color = TextSecondary,
                    lineHeight = 20.sp
                )
            }
        }

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(color = LifecycleBg, shape = RoundedCornerShape(8.dp))
                .border(width = 1.dp, color = Accent, shape = RoundedCornerShape(8.dp))
                .padding(16.dp)
        ) {
            Column {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(
                        imageVector = Icons.Filled.Info,
                        contentDescription = null,
                        tint = Primary,
                        modifier = Modifier.size(18.dp)
                    )
                    Spacer(modifier = Modifier.width(6.dp))
                    Text(
                        text = "Activity Lifecycle",
                        fontSize = 14.sp,
                        fontWeight = FontWeight.SemiBold,
                        color = Primary
                    )
                }
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = "Status: $lifecycleStatus",
                    fontSize = 14.sp,
                    color = Primary,
                    fontWeight = FontWeight.Medium
                )
            }
        }

        Spacer(modifier = Modifier.height(4.dp))

        Button(
            onClick = {
                val intent = Intent(context, DetailActivity::class.java)
                context.startActivity(intent)
            },
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp),
            shape = RoundedCornerShape(24.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Primary)
        ) {
            Icon(
                imageVector = Icons.Filled.Person,
                contentDescription = null,
                modifier = Modifier.size(18.dp)
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(
                text = "Lihat Detail",
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ProfilScreenPreview() {
    ProfilMahasiswaTheme {
        ProfilScreen(lifecycleStatus = "onResume()")
    }
}