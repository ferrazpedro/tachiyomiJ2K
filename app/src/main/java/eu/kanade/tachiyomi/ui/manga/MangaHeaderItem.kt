package eu.kanade.tachiyomi.ui.manga

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import eu.davidea.flexibleadapter.FlexibleAdapter
import eu.davidea.flexibleadapter.items.AbstractFlexibleItem
import eu.davidea.flexibleadapter.items.IFlexible
import eu.kanade.tachiyomi.R
import eu.kanade.tachiyomi.data.database.models.Manga

class MangaHeaderItem(
    val manga: Manga,
    var startExpanded: Boolean,
) : AbstractFlexibleItem<MangaHeaderHolder>() {
    var isChapterHeader = false
    var isLocked = false
    var isTablet = false

    override fun getLayoutRes(): Int = if (isChapterHeader) R.layout.chapter_header_item else R.layout.manga_header_item

    override fun isSelectable(): Boolean = false

    override fun isSwipeable(): Boolean = false

    override fun createViewHolder(
        view: View,
        adapter: FlexibleAdapter<IFlexible<RecyclerView.ViewHolder>>,
    ): MangaHeaderHolder = MangaHeaderHolder(view, adapter as MangaDetailsAdapter, startExpanded, isTablet)

    override fun bindViewHolder(
        adapter: FlexibleAdapter<IFlexible<RecyclerView.ViewHolder>>,
        holder: MangaHeaderHolder,
        position: Int,
        payloads: MutableList<Any?>?,
    ) {
        if (isChapterHeader) {
            holder.bindChapters()
        } else {
            holder.bind(this, manga)
        }
    }

    override fun equals(other: Any?): Boolean = (this === other)

    override fun hashCode(): Int = -(manga.id).hashCode()
}
