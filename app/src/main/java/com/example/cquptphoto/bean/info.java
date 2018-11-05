package com.example.cquptphoto.bean;

import java.util.List;

public class info {

    /**
     * code : 200
     * info : OK
     * results : [{"stuNum":"2018213906","name":"刘裕珂","sex":"男","classNum":"13001802","major":"软件工程","academy":"软件工程学院","grade":"2018","birthday":"20000313","photoUrl":"当前不可见"}]
     */

    private int code;
    private String info;
    private List<ResultsBean> results;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public List<ResultsBean> getResults() {
        return results;
    }

    public void setResults(List<ResultsBean> results) {
        this.results = results;
    }

    public static class ResultsBean {
        /**
         * stuNum : 2018213906
         * name : 刘裕珂
         * sex : 男
         * classNum : 13001802
         * major : 软件工程
         * academy : 软件工程学院
         * grade : 2018
         * birthday : 20000313
         * photoUrl : 当前不可见
         */

        private String stuNum;
        private String name;
        private String sex;
        private String classNum;
        private String major;
        private String academy;
        private String grade;
        private String birthday;
        private String photoUrl;

        public String getStuNum() {
            return stuNum;
        }

        public void setStuNum(String stuNum) {
            this.stuNum = stuNum;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getSex() {
            return sex;
        }

        public void setSex(String sex) {
            this.sex = sex;
        }

        public String getClassNum() {
            return classNum;
        }

        public void setClassNum(String classNum) {
            this.classNum = classNum;
        }

        public String getMajor() {
            return major;
        }

        public void setMajor(String major) {
            this.major = major;
        }

        public String getAcademy() {
            return academy;
        }

        public void setAcademy(String academy) {
            this.academy = academy;
        }

        public String getGrade() {
            return grade;
        }

        public void setGrade(String grade) {
            this.grade = grade;
        }

        public String getBirthday() {
            return birthday;
        }

        public void setBirthday(String birthday) {
            this.birthday = birthday;
        }

        public String getPhotoUrl() {
            return photoUrl;
        }

        public void setPhotoUrl(String photoUrl) {
            this.photoUrl = photoUrl;
        }
    }
}
