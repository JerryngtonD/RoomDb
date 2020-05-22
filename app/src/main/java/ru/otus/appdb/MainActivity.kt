package ru.otus.appdb

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import java.util.concurrent.Executors

class MainActivity : AppCompatActivity() {
    companion object {
        const val INITIAL_CLICK = 1
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setCountView()
        setOnClicksListener()
    }

    private fun setOnClicksListener() {
        val task = Runnable {
            val db = Db.getInstance(applicationContext)!!
            val dbItems = db.getCountDao().getAllClicks()
            if (dbItems.isNullOrEmpty()) {
                db.getCountDao().saveClick(
                    Clicks(
                        count = INITIAL_CLICK
                    )
                )
            } else {
                db.getCountDao().saveClick(
                    Clicks(
                        count = (dbItems.size + 1)
                    )
                )
            }
        }

        increment_count.setOnClickListener {
            Executors.newSingleThreadExecutor().execute(task)
            setCountView()
        }
    }


    private fun setCountView() {
        val task = Runnable {
            counter.let {
                val db = Db.getInstance(context = applicationContext)!!
                val dbItems = db.getCountDao().getAllClicks()
                it.post {
                    it.text = dbItems.size.toString()
                }
            }
        }
        Executors.newSingleThreadExecutor().execute(task)
    }
}
