//package com.example.studentlist.utils
//
//import android.graphics.Insets.add
//import androidx.compose.foundation.Image
//import androidx.compose.runtime.Composable
//import androidx.compose.runtime.remember
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.layout.ContentScale
//import androidx.compose.ui.platform.LocalContext
//import androidx.compose.ui.res.painterResource
//import androidx.compose.ui.res.stringResource
//import coil.ImageLoader
//import coil.request.CachePolicy
//
//@Composable
//fun LoadThumbnail(
//    mediaPath: String,
//    isVideo: Boolean,
//    modifier: Modifier = Modifier
//) {
//    val context = LocalContext.current
//    if (isVideo) {
//        val imageLoader = remember {
//            ImageLoader.Builder(context)
//                .memoryCachePolicy(CachePolicy.ENABLED)
//                .diskCachePolicy(CachePolicy.ENABLED)
//                .respectCacheHeaders(true)
//                .components {
//                    add(VideoFrameDecoder.Factory())
//                }
//                .crossfade(true)
//                .build()
//        }
//        val painter = rememberAsyncImagePainter(
//            model = mediaPath,
//            imageLoader = imageLoader,
//        )
//
//        if (painter.state is AsyncImagePainter.State.Loading) {
//            Image(
//                painter = painterResource(id = R.drawable.ic_default_thumbnail),
//                contentDescription = null,
//                modifier = modifier,
//                contentScale = ContentScale.Crop,
//            )
//        }
//
//        Image(
//            painter = painter,
//            contentDescription = stringResource(id = R.string.thumbnail),
//            contentScale = ContentScale.Crop,
//            modifier = modifier
//        )
//    } else {
//        AsyncImage(
//            model = mediaPath,
//            contentDescription = stringResource(id = R.string.thumbnail),
//            modifier = modifier,
//            contentScale = ContentScale.Crop,
//            placeholder = painterResource(id = R.drawable.ic_default_thumbnail),
//            error = painterResource(id = R.drawable.ic_default_thumbnail)
//        )
//    }
//}