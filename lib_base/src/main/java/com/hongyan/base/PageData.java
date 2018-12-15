package com.hongyan.base;

import java.util.ArrayList;

public class PageData {

    public ArrayList<PageInfo> pageList;

    public static class PageInfo {
        public String id;
        public String name;
        public String desc;
        public ArrayList<Param> params;

        public static class Param {
            public String key;
            public String value;
        }
    }
}