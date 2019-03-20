package com.lhy.mybatis1.vo;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

/**
 * IM登陆结果
 * */
@Slf4j
@Data
public class ImLoginResult {

    /**
     * code : 200
     * info : {"token":"85f3d613b16ae869bd8472fbf3f341e9","accid":"13922239152","name":""}
     * "desc":"already register"
     */

    private int code;
    private InfoBean info;
    private String desc;


    public static class InfoBean {
        /**
         * token : 85f3d613b16ae869bd8472fbf3f341e9
         * accid : 13922239152
         * name :
         */

        private String token;
        private String accid;
        private String name;

        public String getToken() {
            return token;
        }

        public void setToken(String token) {
            this.token = token;
        }

        public String getAccid() {
            return accid;
        }

        public void setAccid(String accid) {
            this.accid = accid;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
