import android.app.Activity
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.entheos.R
import com.example.entheos.itemsVIewModel
import com.example.entheos.promo_dis_main

class CustomAdapter_RcV_promo(val activityContext:Activity, private val mList: ArrayList<itemsVIewModel>)
    : RecyclerView.Adapter<CustomAdapter_RcV_promo.ViewHolder>() {
    // create new views
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        // inflates the card_view_design view
        // that is used to hold list item
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.card_view_design, parent, false)

        return ViewHolder(view)
    }
    // binds the list items to a view
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val ItemsViewModel = mList[position]

        holder.imageViewEve.setImageResource(ItemsViewModel.image);
        holder.textViewEve.text = ItemsViewModel.text
        holder.textViewSetDate.text=ItemsViewModel.date
        holder.cardID.setOnClickListener{
            var cardIntent =Intent(activityContext,promo_dis_main::class.java)
            cardIntent.putExtra("date",ItemsViewModel.date)
            cardIntent.putExtra("image",ItemsViewModel.image)
            activityContext.startActivity(cardIntent)
        }

    }

    // return the number of the items in the list
    override fun getItemCount(): Int {
        return mList.size
    }

    // Holds the views for adding it to image and text
    class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {
        val imageViewEve:ImageView  = itemView.findViewById(R.id.set_img)
        val textViewEve: TextView = itemView.findViewById(R.id.set_text)
        val textViewSetDate:TextView = itemView.findViewById(R.id.set_date)
        val cardID:CardView = itemView.findViewById(R.id.main_card)
    }
}
