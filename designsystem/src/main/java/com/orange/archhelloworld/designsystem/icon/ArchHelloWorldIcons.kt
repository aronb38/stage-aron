package com.orange.archhelloworld.designsystem.icon

import androidx.annotation.DrawableRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Edit
import androidx.compose.material.icons.outlined.List
import androidx.compose.ui.graphics.vector.ImageVector

object ArchHelloWorldIcons {
    val EditAppBar = Icons.Outlined.Edit
    val CheckListAppBar = Icons.Outlined.List
}

sealed class Icon {

    data class ImageVectorIcon(val imageVector: ImageVector) : Icon()

    data class DrawableResourceIcon(@DrawableRes val id: Int) : Icon()

}
