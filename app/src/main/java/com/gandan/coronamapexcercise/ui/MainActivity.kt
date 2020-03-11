package com.gandan.coronamapexcercise.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.gandan.coronamapexcercise.R
import com.gandan.coronamapexcercise.model.Store
import com.gandan.coronamapexcercise.util.RetrofitUtil
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class MainActivity : AppCompatActivity() {

    private var storeList = ArrayList<Store>()
    val compositeDisposable = CompositeDisposable()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        compositeDisposable.add(RetrofitUtil().getRetrofit().getStoresByGeo(37.4846385,127.0336286, 3000)
            .subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
            .subscribe ({
                success ->
                for(store in success.stores){
                    Log.e("Success", store.name);
                }
            }, {
                error -> Log.e("Error", "${error.message}")
            })
        )

    }

    override fun onDestroy() {
        super.onDestroy()
        compositeDisposable.dispose()
    }
}
