package eu.kanade.tachiyomi.appwidget.components

import android.graphics.Bitmap
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import androidx.glance.GlanceModifier
import androidx.glance.Image
import androidx.glance.ImageProvider
import androidx.glance.layout.Box
import androidx.glance.layout.ContentScale
import androidx.glance.layout.fillMaxSize
import androidx.glance.layout.size
import eu.kanade.tachiyomi.R
import eu.kanade.tachiyomi.appwidget.util.appWidgetInnerRadius

val CoverWidth = 58.dp
val CoverHeight = 87.dp

@Composable
fun UpdatesMangaCover(
    modifier: GlanceModifier = GlanceModifier,
    cover: Bitmap?,
) {
    Box(
        modifier =
            modifier
                .size(width = CoverWidth, height = CoverHeight)
                .appWidgetInnerRadius(),
    ) {
        if (cover != null) {
            Image(
                provider = ImageProvider(cover),
                contentDescription = null,
                modifier =
                    GlanceModifier
                        .fillMaxSize()
                        .appWidgetInnerRadius(),
                contentScale = ContentScale.Crop,
            )
        } else {
            // Enjoy placeholder
            Image(
                provider = ImageProvider(R.drawable.appwidget_cover_error),
                contentDescription = null,
                modifier = GlanceModifier.fillMaxSize(),
                contentScale = ContentScale.Crop,
            )
        }
    }
}
