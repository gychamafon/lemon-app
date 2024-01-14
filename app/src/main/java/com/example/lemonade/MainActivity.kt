package com.example.lemonade

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lemonade.ui.theme.LemonadeTheme
import androidx.compose.material3.CenterAlignedTopAppBar as CenterAlignedTopAppBar1

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LemonadeTheme {

                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    LemonApp()


                }
            }
        }
    }
}

@Composable
@Preview(showBackground = true)
fun LemonApp() {

    var step by remember { mutableStateOf(1) }
    var count by remember { mutableStateOf(1) }

    when (step) {
        1 -> ImageAndText(imageId = R.drawable.lemon_tree, textId = R.string.lemon_tree,
            onImageClick = {
                count = (2..4).random()
                step = 2
            })

        2 -> ImageAndText(imageId = R.drawable.lemon_squeeze, textId = R.string.lemon,
            onImageClick = {
                count--
                if (count == 0) {
                    step = 3
                    count = (2..4).random()
                }
            })

        3 -> ImageAndText(imageId = R.drawable.lemon_drink, textId = R.string.glass_of_lemonade,
            onImageClick = {
                step = 4

            })

        4 -> ImageAndText(imageId = R.drawable.lemon_restart, textId = R.string.empty_glass,
            onImageClick = {
                step = 1

            })
    }
}


@Composable
fun ImageAndText(
    imageId: Int, textId: Int, modifier: Modifier = Modifier,
    onImageClick: () -> Unit
) {
    Column(
        modifier = modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            painter = painterResource(id = imageId), contentDescription = imageId.toString(),
            modifier = Modifier
                .clip(
                    RoundedCornerShape(40.dp)
                )
                .clickable { onImageClick() }
                .size(300.dp)
                .background(
                    Color(189, 236, 182)
                )

        )
        Spacer(modifier = modifier.height(40.dp))
        Text(text = stringResource(id = textId), fontSize = 20.sp)


    }

}
