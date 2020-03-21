
package com.osi.creasol.data;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Data {

    @SerializedName("teacher_details")
    @Expose
    private TeacherDetails teacherDetails;
    @SerializedName("token")
    @Expose
    private String token;

    public TeacherDetails getTeacherDetails() {
        return teacherDetails;
    }

    public void setTeacherDetails(TeacherDetails teacherDetails) {
        this.teacherDetails = teacherDetails;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

}
