package com.mengk.viewmodellivedata.model.source;

import com.mengk.viewmodellivedata.common.mvvm.base.BaseRepository;
import com.mengk.viewmodellivedata.model.bean.HomeListVo;

import io.reactivex.Observable;

public class NetRepository extends BaseRepository {
    public NetRepository() {
    }


    public Observable<HomeListVo> getDataHome(String id) {
        return apiService.getHomeData(id);
    }


}
