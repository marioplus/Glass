package com.marioplus;

import com.marioplus.Http.HttpUtil;

public class Test2 {
    public static void main(String[] args) {
        String url = "http://service.vip-h5.com/mzcGame/api/game/rank1?openid=oqCOR0iUd1TLsCrP6S3Hg5cdX-6I&page=1&size=20";
        String s = HttpUtil.doGet(url).get();
        System.out.println(s);
    }
}
