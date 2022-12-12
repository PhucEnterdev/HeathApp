package vn.com.enterdev.heathapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_result.*

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val bundle = intent.getBundleExtra(Constants.BUNDLE)
        // Lay cac gia tri trong bundle
        var male = bundle?.getBoolean(Constants.MALE)
        var female = bundle?.getBoolean(Constants.FEMALE)
        var age = bundle?.getInt(Constants.AGE)
        var height: Int? = bundle?.getInt(Constants.HEIGHT)
        var weight: Int? = bundle?.getInt(Constants.WEIGHT)

        // tinh BMI
        var bmi  = (weight!!).toDouble()/(height!!/100.toDouble()* height!!/100.toDouble())
        Log.d("phuccongtu", height.toString())
        Log.d("phuccongtu", weight.toString())
        Log.d("phuccongtu", bmi.toString())
        tv_bmi.text = bmi.toString()

        if (bmi < 18.5){
            tv_result.text = Constants.LIGHTWEIGHT
            tv_comment.text = "Ban dang trong tinh trang nhe can."
        }else if (bmi in 18.5..22.9){
            tv_result.text = Constants.NORMAL
            tv_comment.text = "Tinh trang dinh duong binh thuong."
        }else if (bmi >= 23.0 && bmi < 30.0){
            tv_result.text = Constants.OVERWEIGHT
            tv_comment.text = "Ban dang trong tinh trang thua can."
        }else{
            tv_result.text = Constants.OBESITY_LV2
            tv_comment.text = "Ban dang trong tinh trang beo phi cap do 2."
        }


        btn_recalculate.setOnClickListener {
            val intent : Intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

    }
}