package com.osi.creasol.data;

public class AttendanceData {
    String month;
    int present;
    int absent;

    public AttendanceData(String month, int present, int absent) {
        this.month = month;
        this.present = present;
        this.absent = absent;
    }
    public AttendanceData(){}
    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public int getPresent() {
        return present;
    }

    public void setPresent(int present) {
        this.present = present;
    }

    public int getAbsent() {
        return absent;
    }

    public void setAbsent(int absent) {
        this.absent = absent;
    }


}
