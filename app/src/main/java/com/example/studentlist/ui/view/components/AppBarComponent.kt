package com.example.studentlist.ui.view.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.studentlist.R
import com.example.studentlist.ui.theme.Dimensions
import com.example.studentlist.ui.theme.FontSize
import com.example.studentlist.ui.view.components.CustomTextView

@Preview(showBackground = true)
@Composable
fun AppBarComponent() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(Dimensions.dimens16),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            painter = painterResource(id = R.drawable.ic_arrow_back),
            contentDescription = stringResource(R.string.arrow_back_icon),
            modifier = Modifier.size(24.dp)
        )
        CustomTextView(
            text = stringResource(R.string.list_of_students),
            fontWeight = FontWeight.Bold,
            color = Color.Black,
            textSize = FontSize.fontSize16,
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f),
        )
    }
}