package com.mengk.viewmodellivedata.model.viewmodel;

import android.app.Application;
import android.util.Log;

import com.mengk.viewmodellivedata.common.mvvm.base.AbsViewModel;
import com.mengk.viewmodellivedata.model.bean.HomeListVo;
import com.mengk.viewmodellivedata.model.source.NetRepository;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * @author Mengk
 * @date {2019/11/25}
 * @description viewModel
 */
public class NetModel extends AbsViewModel<NetRepository> {
    private MutableLiveData<HomeListVo> mLiveDataHome;

    public NetModel(@NonNull Application application) {
        super(application);
    }

    public LiveData<HomeListVo> getLiveDataHome() {
        if (mLiveDataHome == null) {
            mLiveDataHome = new MutableLiveData<>();
        }
        return mLiveDataHome;
    }

    public void getHomeListData(String id) {

        mRepository.getDataHome(id)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<HomeListVo>() {
            @Override
            public void onSubscribe(Disposable d) {
                Log.e("===z","onSubscribe");
            }

            @Override
            public void onNext(HomeListVo s) {
                mLiveDataHome.setValue(s);
                Log.e("===z","onNext" + s);
            }

            @Override
            public void onError(Throwable e) {
                Log.e("===z","onError" + e);
            }

            @Override
            public void onComplete() {
                Log.e("===z","onComplete");
            }
        });
    }

}
