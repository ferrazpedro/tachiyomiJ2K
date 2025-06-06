package eu.kanade.tachiyomi.ui.migration

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import eu.davidea.flexibleadapter.FlexibleAdapter
import eu.davidea.flexibleadapter.items.AbstractHeaderItem
import eu.davidea.flexibleadapter.items.IFlexible
import eu.kanade.tachiyomi.R
import eu.kanade.tachiyomi.databinding.SourceHeaderItemBinding
import eu.kanade.tachiyomi.ui.base.holder.BaseFlexibleViewHolder

/**
 * Item that contains the selection header.
 */
class SelectionHeader : AbstractHeaderItem<SelectionHeader.Holder>() {
    /**
     * Returns the layout resource of this item.
     */
    override fun getLayoutRes(): Int = R.layout.source_header_item

    /**
     * Creates a new view holder for this item.
     */
    override fun createViewHolder(
        view: View,
        adapter: FlexibleAdapter<IFlexible<RecyclerView.ViewHolder>>,
    ): Holder = Holder(view, adapter)

    /**
     * Binds this item to the given view holder.
     */
    override fun bindViewHolder(
        adapter: FlexibleAdapter<IFlexible<RecyclerView.ViewHolder>>,
        holder: Holder,
        position: Int,
        payloads: MutableList<Any?>?,
    ) {
        // Intentionally empty
    }

    class Holder(
        view: View,
        adapter: FlexibleAdapter<IFlexible<RecyclerView.ViewHolder>>,
    ) : BaseFlexibleViewHolder(view, adapter) {
        init {
            val binding = SourceHeaderItemBinding.bind(view)
            binding.title.text = view.context.getString(R.string.select_a_source_then_item_to_migrate)
        }
    }

    override fun equals(other: Any?): Boolean = other is SelectionHeader

    override fun hashCode(): Int = 0
}
