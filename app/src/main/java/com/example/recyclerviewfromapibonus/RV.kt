import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerviewfromapibonus.databinding.ItemRowBinding

class RV( val names: ArrayList<String>): RecyclerView.Adapter<RV.HOLDER>() {
    class HOLDER(val binding: ItemRowBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HOLDER {
        return HOLDER(ItemRowBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: HOLDER, position: Int) {
        val name = names[position]

        holder.binding.apply {
            textView.text=name

        } }
    override fun getItemCount() = names.size
}