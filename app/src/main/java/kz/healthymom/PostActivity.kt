package kz.healthymom

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_post.*

class PostActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_post)
        Picasso.get()
            .load("https://www.elevit.ru/sites/g/files/vrxlpx19251/files/styles/desktop_1000xauto/public/2021-02/pitanie-vo-vremya-beremennosti_1440.png?itok=DehPExt0")
            .into(mkmkmkmk)
    }
}