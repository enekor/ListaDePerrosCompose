package com.example.primeraappcompose

import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import com.example.primeraappcompose.ui.theme.PrimeraAppComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainScreen()
        }
    }
}

@Composable
fun MainScreen(){
    Surface(
        color = Color.LightGray,
        modifier = Modifier.fillMaxSize()
    ){
        LazyColumn {
            items(DataProvider.dogList){
                dog->
                CardItem(dog.name,dog.raza,dog.image,dog.years)
            }
        }
    }
}

@Composable
fun CardItem(name:String,raza:String,image:String,years:Int){

    val mContext = LocalContext.current

    Card(
        Modifier.fillMaxWidth().padding(12.dp),
        elevation = 10.dp
    ) {
        Row(
            modifier = Modifier.fillMaxWidth()
        ){
            Image(
                painter = rememberImagePainter(
                    image),
                contentDescription = "imagen de perro",
                modifier = Modifier.size(200.dp),
                contentScale = ContentScale.Crop
            )
            Column(
                Modifier.padding(start = 20.dp)

            ) {
                Text(
                    text = name,
                    style = MaterialTheme.typography.h4,
                    modifier = Modifier.clickable {  showMessage(mContext,"hola") }
                )
                Text(
                    text = "Raza: $raza",
                    style = MaterialTheme.typography.body2
                )
                Text(
                    text = "Edad: $years",
                    style = MaterialTheme.typography.body1
                )
            }
        }
    }
}

fun showMessage(contexto:Context, text:String){
    Toast.makeText(contexto, text, Toast.LENGTH_SHORT).show()
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    PrimeraAppComposeTheme {
        MainScreen()
    }
}