package com.incava.praticejetpackcompose

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Send
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.compose.rememberImagePainter
import com.incava.praticejetpackcompose.ui.theme.PraticeJetpackComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PraticeJetpackComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
//                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
////        ButtonExample({})
////        TextExample("Android")
////        BoxWithConstraintsExample()
////        ImageExample()
//        CheckBoxEx()
//                    SlotAPIEx()
                    ScaffoldEx()
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
fun BoxWithConstraintsExample() {
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
        if (maxHeight > 150.dp) {
            Text(
                text = "너무 길어서 값이 나오지 않습니다.",
                modifier = Modifier.align(Alignment.BottomCenter)
            )
        }

        // Box기능 + min,max기능을 추가적으로 제약조건을 설정 가능.
        Text("maxW:$maxWidth maxH:$maxHeight minW:$minWidth minH: $minHeight")
    }
}

@Composable
fun ImageExample() {
    Image(
        painter = painterResource(id = R.drawable.ic_launcher_background),
        contentDescription = "백그라운드"
    )
}

@Composable
fun NetworkImageExample() {
    // 이미지를 네트워크에서 가져오기
    val painter =
        rememberImagePainter(data = "https://cdn.pixabay.com/photo/2023/09/16/17/13/cat-8257177_1280.jpg")
    Image(
        painter = painter,
        contentDescription = "고양이"
    )
}

@Composable
fun CoilEx() {
    // 이미지를 네트워크에서 가져오기 with coil
    // coil의 장점 : 코틀린 호환, 내부 쓰레드를 코루틴으로 작성
    // 코틀린 작성형태로 되어있음.

    AsyncImage(
        model = "https://cdn.pixabay.com/photo/2023/09/16/17/13/cat-8257177_1280.jpg",
        contentDescription = "고양이"
    )
}

@Composable
fun CheckBoxEx() {
    // CheckBox 값 변경해보기.
    Row(
        verticalAlignment = Alignment.CenterVertically
    ) {
//        var checked = false
//        Checkbox(
//            checked = checked,
//            onCheckedChange = {
//                checked = !checked
//            }
//        )
//    }

        // mutableStateOf를 사용해 변경
//    Row(
//        verticalAlignment = Alignment.CenterVertically
//    ){
//        //stateOf는 상태값을 가지고 랜더링을 할 때, 동기화 해주는 것인데, 언제 랜더링을 할 지 모름.
//        // remember를 통해 언제가 되었든 렌더링을 할 수 있도록 등록.
//        var checked = remember { mutableStateOf(false) }
//        Checkbox(
//            checked = checked.value,
//            onCheckedChange = {
//                checked.value = !checked.value
//            }
//        )
//    }

        // .value를 써야하는 부분을 대신해 위임된 속성인 delegated properies 사용하기.
        // checked가 프로퍼티인 것 처럼 사용하도록.
//        var checked by remember {
//            mutableStateOf(false)
//        }
//        Checkbox(checked = checked,
//            onCheckedChange = {
//                checked = !checked
//            }
//        )
//        Text("나는 취준생인가요?")

        // 비구조화로 적용
        val (getter, setter) = remember {
            mutableStateOf(false)
        }
        Checkbox(
            checked = getter,
            onCheckedChange = setter
        )
        Text(
            "나는 취준생인가요?",
            modifier = Modifier.clickable {
                // 텍스트를 누를 때도 박스에 대한 state 변경
                setter(!getter)
            }
        )

    }

}

@Composable
fun CheckBoxExWithSlot(
    checked: Boolean,
    onCheckedChanged: () -> Unit,
    content: @Composable RowScope.() -> Unit
) {
    // RowScope.로 사용하게 되면, 자동으로 Row안에 있듯 사용가능.
    // 현재 Row를 사용하고 있기 때문에, RowScope로 사용.
    // CheckBox 값 변경해보기.
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.clickable {
            onCheckedChanged()
        }
    ) {
        // 비구조화로 적용
        Checkbox(
            checked = checked,
            onCheckedChange = { onCheckedChanged() }
        )
        content()
    }

}

@Composable
fun SlotAPIEx() {
    //어떤 컴포저블 언어가 다른 컴포저블 언어를 포함하는 것을 의미.
    var checked1 by remember { mutableStateOf(false) }
    var checked2 by remember { mutableStateOf(false) }

    Column() {
        CheckBoxExWithSlot(
            checked = checked1,
            onCheckedChanged = {
                checked1 = !checked1
            }
        ) {
            Text(text = "checked1")
        }
        CheckBoxExWithSlot(
            checked = checked2,
            onCheckedChanged = {
                checked2 = !checked2
            }
        ) {
            Text(text = "checked2")
        }
    }
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
// 컴포즈 M3사용
@Composable
fun ScaffoldEx() {
    // 구글의 디자인 뼈대

    Scaffold(
        topBar = {
            TopAppBar(
                navigationIcon = {
                    IconButton(onClick = { /*TODO*/ }) {
                        Image(
                            imageVector = Icons.Filled.ArrowBack,
                            contentDescription = "뒤로 가기"
                        )
                    }
                },
                title = {
                    Text(text = "Scaffold App")
                },
            )
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = { /*TODO*/ },
            ) {
                Icon(
                    imageVector = Icons.Filled.Send,
                    contentDescription = null,
                )
            }
        }
    ) {
        Surface(modifier = Modifier.padding(8.dp)) {

        }
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    PraticeJetpackComposeTheme {
//        ButtonExample({})
//        TextExample("Android")
//        BoxWithConstraintsExample()
//        ImageExample()
//        CheckBoxEx()
//        SlotAPIEx()
        ScaffoldEx()
    }
}