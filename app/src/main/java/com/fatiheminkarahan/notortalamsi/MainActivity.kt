package com.fatiheminkarahan.notortalamsi

import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import android.view.Menu
import android.view.MenuItem
import com.fatiheminkarahan.notortalamsi.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.Hesapla.setOnClickListener{
            if (binding.Vize.text.isNotEmpty() && binding.Final.text.isNotEmpty()){
                var vizenot = binding.Vize.text.toString().toDouble()
                var finalnot = binding.Final.text.toString().toDouble()
                var ortalama:Double
                ortalama = ((vizenot*40)/100 + (finalnot*60)/100).toDouble()
                if (ortalama>=50 && finalnot>=50){
                    binding.Sonuc.text = ortalama.toString()+" "+"Geçtiniz"
                    binding.Sonuc.setTextColor(getColor(R.color.green))
                }
                else{
                    binding.Sonuc.text = ortalama.toString()+" "+"Kaldınız"
                    binding.Sonuc.setTextColor(getColor(R.color.red))
                }
            }
            else{
                binding.Sonuc.text = "Lütfen sınav notunuzu giriniz!!!"
                binding.Sonuc.setTextColor(getColor(R.color.red))
            }
        }
    }

}