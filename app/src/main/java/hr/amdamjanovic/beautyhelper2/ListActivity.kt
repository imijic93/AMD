package hr.amdamjanovic.beautyhelper2

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class ListActivity : AppCompatActivity(){



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)

        val array = arrayOf("Spring", "Summer", "Autumn", "Winter")
        val listView = findViewById<ListView>(R.id.season_listView)

        listView.adapter = MyCustomAdapter(this)
        val adapter = ArrayAdapter(this, R.layout.row_list, R.id.title_textView, array)
        val season_imageView= findViewById<ImageView>(R.id.season_imageView)

        listView.setOnItemClickListener{parent, view, position, id ->
            val element = adapter.getItemId(position)
            val intent= Intent(this, UploadActivity::class.java)
            startActivity(intent)
        }


    }

    private class MyCustomAdapter(context: Context): BaseAdapter(){

        private val mContext: Context

        private val seasons = arrayListOf<String>("Spring", "Summer", "Autumn", "Winter")

        private val desc = arrayListOf<String>("Opis za proljeće", "opis za ljeto", "opis za jesen", "opis za zimu")

        var imageIdList = arrayOf<Int>(
            R.drawable.spring,
            R.drawable.summer,
            R.drawable.autumn,
            R.drawable.winter
        )

        init {
            mContext = context
        }


        //broj redova u listi
        override fun getCount(): Int {
            return seasons.size
        }

        override fun getItem(position: Int): Any {
            return "test string"
        }

        override fun getItemId(position: Int): Long {
            return position.toLong()
        }

        override fun getView(position: Int, convertView: View?, viewGroup: ViewGroup?): View {


            val layoutInflater = LayoutInflater.from(mContext)
            val rowList =layoutInflater.inflate(R.layout.row_list,viewGroup, false)
            val titleTextView =rowList.findViewById<TextView>(R.id.title_textView)
            val seasonImageView = rowList.findViewById<ImageView>(R.id.season_imageView)
            seasonImageView.setImageResource(imageIdList[position])
            titleTextView.text = seasons.get(position)

            val descTextView = rowList.findViewById<TextView>(R.id.desc_textView)

            descTextView.text = desc.get(position)


             return rowList

            //val textView = TextView(mContext)
            //textView.text = "Here is my row"
            //return textView

        }


    }
}