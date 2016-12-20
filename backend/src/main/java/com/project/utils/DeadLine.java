package com.project.utils;

import java.util.GregorianCalendar;

/**
 * Created by sergeyy on 12/20/16.
 */
public class DeadLine extends GregorianCalendar {
    @Override
    public String toString() {
        return (get(DAY_OF_MONTH) + "/" + get(MONTH) + "/" + get(YEAR));
    }

    public DeadLine(int year, int month, int dayOfMonth) {
        super(year, month, dayOfMonth);
    }
}
