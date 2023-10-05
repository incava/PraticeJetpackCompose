package com.incava.praticejetpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.BoxWithConstraintsScope
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Send
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.incava.praticejetpackcompose.ui.theme.PraticeJetpackComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PraticeJetpackComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    TextExample("Android")
                }
            }
        }
    }
}

@Composable
fun TextExample(name: String, modifier: Modifier = Modifier) {
    // Text에 대한 여러 요소 넣고 확인
    // Modifier는 UI 요소의 모양, 크기, 위치, 스타일 및 상호 작용과 관련된 여러 속성을 변경하는 데 사용.
    Text(
        modifier = Modifier.width(1000.dp),
        color = Color.Red,
        text = "Hello $name",
        fontSize = 24.sp,
        fontWeight = FontWeight.Bold,
        fontFamily = FontFamily.Cursive,
        letterSpacing = 1.sp,
        textDecoration = TextDecoration.Underline,
        textAlign = TextAlign.Center,
    )
}

@Composable
fun ButtonExample(onButtonClicked: () -> Unit) {
    // 버튼에 대한 여러 요소 넣고 확인.
    Button(
        onClick = onButtonClicked,
        border = BorderStroke(10.dp, Color.DarkGray)
    ) {
        Icon(
            imageVector = Icons.Filled.Send,
            contentDescription = null,
        )
        // Spacer는 여백을 의미
        Spacer(modifier = Modifier.size(ButtonDefaults.IconSpacing))

        Text(
            text = "Send"
        )
    }
}

@Composable
fun BoxWithConstraintsExample(){
    Outer()
}

@Composable
fun Outer() {
    Column {
        Inner(
            modifier = Modifier
                .widthIn(
                    min = 50.dp,
                )
                .heightIn(min = 160.dp, max = 250.dp)

        )
    }
}

@Composable
fun Inner(modifier: Modifier = Modifier) {
    // modifier를 지정하지 않았으면 기본 반응형으로 설정.
    // width나 height에 대한 조건이 필요할 때 사용하면 좋음.
    BoxWithConstraints(modifier = modifier) {
        if(maxHeight > 150.dp){
            Text(
                text = "너무 길어서 값이 나오지 않습니다.",
                modifier = Modifier.align(Alignment.BottomCenter)
            )
        }

        // Box기능 + min,max기능을 추가적으로 제약조건을 설정 가능.
        Text("maxW:$maxWidth maxH:$maxHeight minW:$minWidth minH: $minHeight")
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    PraticeJetpackComposeTheme {
//        ButtonExample({})
//        TextExample("Android")
        BoxWithConstraintsExample()
    }
}