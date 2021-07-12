    package jp.ac.aut.mytimetable

import android.app.Activity
import android.graphics.Color
import android.os.Bundle
import com.stephentuso.welcome.*

class WalkThroughActivity : WelcomeActivity() {

    companion object{
        fun showIfNeeded(activity: Activity,savedInstanceState: Bundle?){
            WelcomeHelper(activity,WalkThroughActivity::class.java).show(savedInstanceState)
        }

        fun showForcibly(activity: Activity){
            WelcomeHelper(activity,WalkThroughActivity::class.java).forceShow()
        }

    }

    override fun configuration(): WelcomeConfiguration {
        return WelcomeConfiguration.Builder(this)
            .defaultBackgroundColor(BackgroundColor(Color.RED))
            .page(TitlePage(R.mipmap.ic_launcher,"Title"))
            .page(BasicPage(
                android.R.drawable.ic_delete,
                "Basic page 1",
                "unko")
                .background(BackgroundColor(Color.GREEN)))
            .page(BasicPage(
                android.R.drawable.ic_btn_speak_now,
                "Basic page 2",
                "fuga")
                .background(BackgroundColor(Color.BLUE))
            )
            .swipeToDismiss(true)
            .build()
    }
}