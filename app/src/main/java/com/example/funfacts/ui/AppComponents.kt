package com.example.funfacts.ui

import android.widget.Button
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
//import androidx.compose.foundation.gestures.ModifierLocalScrollableContainerProvider.value
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.funfacts.R
import com.example.funfacts.Utils

@Composable
fun TopBar(value: String){
    Row(modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically){
        Text(
            text = value,
            color = Color.Black,
            fontSize = 24.sp,
            fontWeight = FontWeight.Medium
        )
        Spacer(modifier = Modifier.weight(1f)) // for putting next element on right hand
        // side

        Image(
            modifier = Modifier.size(80.dp),
            painter = painterResource(id = R.drawable.logo), contentDescription = "Faraz khan")
    }
}

@Preview
@Composable

fun TopBarPreview(){
    TopBar("")
}

@Composable
fun TextComponent(textValue: String,
                  textSize: TextUnit,
                  colorValue: Color = Color.Black)
{
    Text(text = textValue,
        fontSize = textSize,
        color = colorValue,
        fontWeight = FontWeight.Light
    )
}

@Preview(showBackground = true)
@Composable
fun TextComponentPreview(){
    TextComponent(textValue = "Faraz khan", textSize = 24.sp)
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TextFieldComponent(
    onTextChanged: (name:String)->Unit
){
    var currentValue by remember {
        mutableStateOf("")
    }
    val localFocusManager = LocalFocusManager.current
    OutlinedTextField(
        modifier = Modifier.fillMaxWidth(),
        value = currentValue,
        // whenever user enters any value , we want to update the ui state
        onValueChange = {
                    currentValue = it // to store value locally
                    onTextChanged(it) // it means value entered by user
        },
        placeholder = {
        Text(text = "Enter your name", fontSize = 18.sp)
    },
        textStyle = TextStyle.Default.copy(fontSize = 24.sp),
       //for changing the button design of done on the keyboard
        keyboardOptions = KeyboardOptions(
            imeAction = ImeAction.Done
        ),
        // if we click on done then cursor will not be shown on textbox for input and keyboard is gone
        keyboardActions = KeyboardActions{
            localFocusManager.clearFocus()
        }
    )
}

@Composable
fun AnimalCard(image: Int , selected:Boolean, animalSelected : (animalName:String)-> Unit){
    Card(
        modifier = Modifier
            .padding(24.dp)
            .size(130.dp),
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        // for green highlight over the selected animal image
        Box (
            modifier = Modifier
                .fillMaxSize()
                .border(
                    width = 1.dp,
                    color = if (selected) Color.Green else Color.Transparent,
                    shape = RoundedCornerShape(8.dp)
                )
        ){


            Image(
                modifier = Modifier
                    .padding(16.dp)
                    .wrapContentWidth()
                    .wrapContentHeight()
                    .clickable {
                        val animalName = if (image == R.drawable.ic_cat) "Cat" else "Dog"
                        animalSelected(animalName)
                    },
                painter = painterResource(id = image),
                contentDescription = "Animal Image"
            )

        }
    }
}

@Preview
@Composable
fun AnimalCardPreview(){
    AnimalCard(R.drawable.ic_cat,false, {"Dog"})
}
@Composable
fun ButtonComponent(
    gotoDetailsScreen: ()-> Unit
){
    Button(
        modifier = Modifier.fillMaxWidth(),
        onClick = {
            gotoDetailsScreen()
        }) {
        TextComponent(
            textValue = "Enter",
            textSize = 18.sp,
            colorValue = Color.White
        )

    }
}

@Composable
fun textWithShadow(value: String){
    val shadowOffset = Offset(x= 1f , y= 2f)
    Text(text = value,
        fontSize = 24.sp,
        fontWeight = FontWeight.Light,
        style = TextStyle(
            shadow = Shadow(Utils.generateRandomColor(), shadowOffset, 2f)
        )
    )
}

@Composable
fun FactComposable(value: String){
    Card(modifier = Modifier
        .padding(32.dp)
        .fillMaxWidth(),
        shape= RoundedCornerShape(8.dp),
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Column(modifier = Modifier.padding(18.dp , 24.dp)
        ) {
           Image(painter = painterResource(id = R.drawable.ic_quote), contentDescription = "Quote",
               modifier = Modifier.rotate(180f)
           )
            Spacer(modifier = Modifier.size(24.dp))

            textWithShadow(value = value)

            Spacer(modifier = Modifier.size(24.dp))

            Image(
                painter = painterResource(id = R.drawable.ic_quote),
                contentDescription = "Qoute Image",)


        }
    }
}

@Preview
@Composable
fun FactComposablePreview(){
    FactComposable(value = "ABCD")
}

