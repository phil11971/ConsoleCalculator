package com.company;

public enum Roman {
    I("I", 1), II("II", 2), III("III", 3), IV("IV", 4), V("V", 5),
    VI("VI", 6), VII("VII", 7), VIII("VIII", 8), IX("IX", 9), X("X", 10);

    private String key;
    private int value;

    Roman(String key, int value) {
        this.value = value;
    }

    static Integer toInt(String key)
    {
        for(Roman i: values())
            if (i.name().equals(key))
                return i.value;
        return null;
    }

    static String toRoman(int value)
    {
        for(Roman i: values())
            if (i.value == value)
                return i.toString();
        return null;
    }
}
